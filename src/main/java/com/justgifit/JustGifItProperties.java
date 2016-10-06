package com.justgifit;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

/**
 * Created by amarendra on 06/10/16.
 */
@ConfigurationProperties(prefix = "com.justGifIt")
public class JustGifItProperties {

    /**
     * The location of the animated GIF
     */
    private File location;

    /**
     * Whether to optimize ot not.
     */
    private Boolean optimize;

    public File getLocation() {
        return location;
    }

    public void setLocation(File location) {
        this.location = location;
    }

    public Boolean getOptimize() {
        return optimize;
    }

    public void setOptimize(Boolean optimize) {
        this.optimize = optimize;
    }
}
