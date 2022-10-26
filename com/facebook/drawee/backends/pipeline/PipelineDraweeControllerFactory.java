package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PipelineDraweeControllerFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DrawableFactory mAnimatedDrawableFactory;
    @Nullable
    public Supplier mDebugOverlayEnabledSupplier;
    public DeferredReleaser mDeferredReleaser;
    @Nullable
    public ImmutableList mDrawableFactories;
    public MemoryCache mMemoryCache;
    public Resources mResources;
    public Executor mUiThreadExecutor;

    public PipelineDraweeControllerFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void init(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache memoryCache, @Nullable ImmutableList immutableList, @Nullable Supplier supplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList, supplier}) == null) {
            this.mResources = resources;
            this.mDeferredReleaser = deferredReleaser;
            this.mAnimatedDrawableFactory = drawableFactory;
            this.mUiThreadExecutor = executor;
            this.mMemoryCache = memoryCache;
            this.mDrawableFactories = immutableList;
            this.mDebugOverlayEnabledSupplier = supplier;
        }
    }

    public PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache memoryCache, @Nullable ImmutableList immutableList) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList})) == null) {
            return new PipelineDraweeController(resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList);
        }
        return (PipelineDraweeController) invokeCommon.objValue;
    }

    public PipelineDraweeController newController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PipelineDraweeController internalCreateController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
            Supplier supplier = this.mDebugOverlayEnabledSupplier;
            if (supplier != null) {
                internalCreateController.setDrawDebugOverlay(((Boolean) supplier.get()).booleanValue());
            }
            return internalCreateController;
        }
        return (PipelineDraweeController) invokeV.objValue;
    }
}
