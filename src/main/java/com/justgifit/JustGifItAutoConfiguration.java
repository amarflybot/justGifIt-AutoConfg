package com.justgifit;

import com.justgifit.service.ConverterService;
import com.justgifit.service.GifEncoderService;
import com.justgifit.service.VideoDecoderService;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Created by amarendra on 05/10/16.
 */

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
public class JustGifItAutoConfiguration {

    @Value("${spring.http.multipart.location}/gif/")
    private String location;

    @Bean
    @ConditionalOnProperty(prefix = "com.justgifit" , name = "create-result-dir")
    public Boolean createResultDir(){
        File gifFolder = new File(location);
        if(!gifFolder.exists()){
            gifFolder.mkdir();
        }

        return true;
    }

    @Bean
    @ConditionalOnMissingBean(VideoDecoderService.class)
    public VideoDecoderService videoDecoderService(){
        return new VideoDecoderService();
    }

    @Bean
    @ConditionalOnMissingBean(GifEncoderService.class)
    public GifEncoderService gifEncoderService(){
        return new GifEncoderService();
    }

    @Bean
    @ConditionalOnMissingBean(ConverterService.class)
    public ConverterService converterService(){
        return new ConverterService();
    }
}
