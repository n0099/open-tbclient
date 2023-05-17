package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class DraweeConfig {
    @Nullable
    public final ImmutableList<DrawableFactory> mCustomDrawableFactories;
    public final Supplier<Boolean> mDebugOverlayEnabledSupplier;
    @Nullable
    public final ImagePerfDataListener mImagePerfDataListener;
    @Nullable
    public final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    /* loaded from: classes8.dex */
    public static class Builder {
        public List<DrawableFactory> mCustomDrawableFactories;
        public Supplier<Boolean> mDebugOverlayEnabledSupplier;
        @Nullable
        public ImagePerfDataListener mImagePerfDataListener;
        public PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        public DraweeConfig build() {
            return new DraweeConfig(this);
        }

        public Builder addCustomDrawableFactory(DrawableFactory drawableFactory) {
            if (this.mCustomDrawableFactories == null) {
                this.mCustomDrawableFactories = new ArrayList();
            }
            this.mCustomDrawableFactories.add(drawableFactory);
            return this;
        }

        public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> supplier) {
            Preconditions.checkNotNull(supplier);
            this.mDebugOverlayEnabledSupplier = supplier;
            return this;
        }

        public Builder setDrawDebugOverlay(boolean z) {
            return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(z)));
        }

        public Builder setImagePerfDataListener(@Nullable ImagePerfDataListener imagePerfDataListener) {
            this.mImagePerfDataListener = imagePerfDataListener;
            return this;
        }

        public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory pipelineDraweeControllerFactory) {
            this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
            return this;
        }
    }

    public DraweeConfig(Builder builder) {
        ImmutableList<DrawableFactory> immutableList;
        Supplier<Boolean> of;
        if (builder.mCustomDrawableFactories != null) {
            immutableList = ImmutableList.copyOf(builder.mCustomDrawableFactories);
        } else {
            immutableList = null;
        }
        this.mCustomDrawableFactories = immutableList;
        if (builder.mDebugOverlayEnabledSupplier == null) {
            of = Suppliers.of(Boolean.FALSE);
        } else {
            of = builder.mDebugOverlayEnabledSupplier;
        }
        this.mDebugOverlayEnabledSupplier = of;
        this.mPipelineDraweeControllerFactory = builder.mPipelineDraweeControllerFactory;
        this.mImagePerfDataListener = builder.mImagePerfDataListener;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Nullable
    public ImmutableList<DrawableFactory> getCustomDrawableFactories() {
        return this.mCustomDrawableFactories;
    }

    public Supplier<Boolean> getDebugOverlayEnabledSupplier() {
        return this.mDebugOverlayEnabledSupplier;
    }

    @Nullable
    public ImagePerfDataListener getImagePerfDataListener() {
        return this.mImagePerfDataListener;
    }

    @Nullable
    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.mPipelineDraweeControllerFactory;
    }
}
