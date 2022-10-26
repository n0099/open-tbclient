package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set mBoundControllerListeners;
    public final Set mBoundControllerListeners2;
    public final Context mContext;
    @Nullable
    public final ImagePerfDataListener mDefaultImagePerfDataListener;
    public final ImagePipeline mImagePipeline;
    public final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (DraweeConfig) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PipelineDraweeControllerBuilderSupplier(Context context, @Nullable DraweeConfig draweeConfig) {
        this(context, ImagePipelineFactory.getInstance(), draweeConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, draweeConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (ImagePipelineFactory) objArr2[1], (DraweeConfig) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, @Nullable DraweeConfig draweeConfig) {
        this(context, imagePipelineFactory, null, null, draweeConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, imagePipelineFactory, draweeConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (ImagePipelineFactory) objArr2[1], (Set) objArr2[2], (Set) objArr2[3], (DraweeConfig) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set set, Set set2, @Nullable DraweeConfig draweeConfig) {
        ImmutableList immutableList;
        Supplier supplier;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, imagePipelineFactory, set, set2, draweeConfig};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
        MemoryCache bitmapMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
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
    @Override // com.facebook.common.internal.Supplier
    public PipelineDraweeControllerBuilder get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners, this.mBoundControllerListeners2).setPerfDataListener(this.mDefaultImagePerfDataListener);
        }
        return (PipelineDraweeControllerBuilder) invokeV.objValue;
    }
}
