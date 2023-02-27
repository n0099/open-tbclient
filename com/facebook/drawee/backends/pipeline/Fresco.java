package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class Fresco {
    public static final Class<?> TAG = Fresco.class;
    public static DraweeControllerBuilderSupplierFactory mFactory;
    public static volatile boolean sIsInitialized;

    /* loaded from: classes7.dex */
    public static class DraweeControllerBuilderSupplierFactory implements Supplier<Supplier<? extends AbstractDraweeControllerBuilder>> {
        public Context mContext;
        public DraweeConfig mImagePipelineConfig;
        public volatile PipelineDraweeControllerBuilderSupplier mInstance = null;

        public DraweeControllerBuilderSupplierFactory(Context context, DraweeConfig draweeConfig) {
            this.mContext = context;
            this.mImagePipelineConfig = draweeConfig;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.facebook.common.internal.Supplier<com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder>' to match base method */
        @Override // com.facebook.common.internal.Supplier
        /* renamed from: get */
        public Supplier<? extends AbstractDraweeControllerBuilder> get2() {
            if (this.mInstance == null) {
                synchronized (this) {
                    if (this.mInstance == null) {
                        this.mInstance = new PipelineDraweeControllerBuilderSupplier(this.mContext, this.mImagePipelineConfig);
                    }
                }
            }
            return this.mInstance;
        }
    }

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        return (PipelineDraweeControllerBuilderSupplier) mFactory.get2();
    }

    public static ImagePipeline getImagePipeline() {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static ImagePipelineFactory getImagePipelineFactory() {
        return ImagePipelineFactory.getInstance();
    }

    public static boolean hasBeenInitialized() {
        return sIsInitialized;
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        return (PipelineDraweeControllerBuilder) mFactory.get2().get();
    }

    public static void shutDown() {
        mFactory = null;
        SimpleDraweeView.shutDown();
        ImagePipelineFactory.shutDown();
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig) {
        initialize(context, imagePipelineConfig, null);
    }

    public static void initializeDrawee(Context context, @Nullable DraweeConfig draweeConfig) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("Fresco.initializeDrawee");
        }
        DraweeControllerBuilderSupplierFactory draweeControllerBuilderSupplierFactory = new DraweeControllerBuilderSupplierFactory(context, draweeConfig);
        mFactory = draweeControllerBuilderSupplierFactory;
        SimpleDraweeView.initialize(draweeControllerBuilderSupplierFactory);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig, @Nullable DraweeConfig draweeConfig) {
        initialize(context, imagePipelineConfig, draweeConfig, true);
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig, @Nullable DraweeConfig draweeConfig, boolean z) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("Fresco#initialize");
        }
        if (sIsInitialized) {
            FLog.w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            sIsInitialized = true;
        }
        Context applicationContext = context.getApplicationContext();
        if (imagePipelineConfig == null) {
            ImagePipelineFactory.initialize(applicationContext);
        } else {
            ImagePipelineFactory.initialize(imagePipelineConfig);
        }
        initializeDrawee(applicationContext, draweeConfig);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }
}
