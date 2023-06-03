package com.facebook.imagepipeline;

import com.facebook.imagepipeline.producers.NetworkFetcher;
/* loaded from: classes9.dex */
public class ImagePipelineConfigProxy {
    public static ImagePipelineConfig imagePipelineConfig;

    /* loaded from: classes9.dex */
    public interface ImagePipelineConfig {
        NetworkFetcher getNetworkFetcher();
    }

    public static ImagePipelineConfig getImagePipelineConfig() {
        return imagePipelineConfig;
    }

    public static void setImagePipelineConfig(ImagePipelineConfig imagePipelineConfig2) {
        imagePipelineConfig = imagePipelineConfig2;
    }
}
