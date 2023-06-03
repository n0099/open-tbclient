package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    public final Set<ControllerListener> mBoundControllerListeners;
    public final Set<ControllerListener2> mBoundControllerListeners2;
    public final Context mContext;
    @Nullable
    public final ImagePerfDataListener mDefaultImagePerfDataListener;
    public final ImagePipeline mImagePipeline;
    public final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, null);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, @Nullable DraweeConfig draweeConfig) {
        this(context, ImagePipelineFactory.getInstance(), draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, @Nullable DraweeConfig draweeConfig) {
        this(context, imagePipelineFactory, null, null, draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set<ControllerListener> set, Set<ControllerListener2> set2, @Nullable DraweeConfig draweeConfig) {
        ImmutableList<DrawableFactory> immutableList;
        Supplier<Boolean> supplier;
        this.mContext = context;
        this.mImagePipeline = imagePipelineFactory.getImagePipeline();
        if (draweeConfig != null && draweeConfig.getPipelineDraweeControllerFactory() != null) {
            this.mPipelineDraweeControllerFactory = draweeConfig.getPipelineDraweeControllerFactory();
        } else {
            this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        }
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.mPipelineDraweeControllerFactory;
        Resources resources = context.getResources();
        DeferredReleaser deferredReleaser = DeferredReleaser.getInstance();
        DrawableFactory animatedDrawableFactory = imagePipelineFactory.getAnimatedDrawableFactory(context);
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
        MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
        if (draweeConfig != null) {
            immutableList = draweeConfig.getCustomDrawableFactories();
        } else {
            immutableList = null;
        }
        if (draweeConfig != null) {
            supplier = draweeConfig.getDebugOverlayEnabledSupplier();
        } else {
            supplier = null;
        }
        pipelineDraweeControllerFactory.init(resources, deferredReleaser, animatedDrawableFactory, uiThreadImmediateExecutorService, bitmapMemoryCache, immutableList, supplier);
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        this.mDefaultImagePerfDataListener = draweeConfig != null ? draweeConfig.getImagePerfDataListener() : null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public PipelineDraweeControllerBuilder get() {
        return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners, this.mBoundControllerListeners2).setPerfDataListener(this.mDefaultImagePerfDataListener);
    }
}
