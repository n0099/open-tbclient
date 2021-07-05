package com.facebook.drawee.backends.pipeline;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DraweeConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final ImmutableList<DrawableFactory> mCustomDrawableFactories;
    public final Supplier<Boolean> mDebugOverlayEnabledSupplier;
    @Nullable
    public final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    /* renamed from: com.facebook.drawee.backends.pipeline.DraweeConfig$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<DrawableFactory> mCustomDrawableFactories;
        public Supplier<Boolean> mDebugOverlayEnabledSupplier;
        public PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder addCustomDrawableFactory(DrawableFactory drawableFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drawableFactory)) == null) {
                if (this.mCustomDrawableFactories == null) {
                    this.mCustomDrawableFactories = new ArrayList();
                }
                this.mCustomDrawableFactories.add(drawableFactory);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public DraweeConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new DraweeConfig(this, null) : (DraweeConfig) invokeV.objValue;
        }

        public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, supplier)) == null) {
                Preconditions.checkNotNull(supplier);
                this.mDebugOverlayEnabledSupplier = supplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDrawDebugOverlay(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(z))) : (Builder) invokeZ.objValue;
        }

        public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory pipelineDraweeControllerFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pipelineDraweeControllerFactory)) == null) {
                this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public /* synthetic */ DraweeConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    @Nullable
    public ImmutableList<DrawableFactory> getCustomDrawableFactories() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCustomDrawableFactories : (ImmutableList) invokeV.objValue;
    }

    public Supplier<Boolean> getDebugOverlayEnabledSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDebugOverlayEnabledSupplier : (Supplier) invokeV.objValue;
    }

    @Nullable
    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPipelineDraweeControllerFactory : (PipelineDraweeControllerFactory) invokeV.objValue;
    }

    public DraweeConfig(Builder builder) {
        Supplier<Boolean> of;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCustomDrawableFactories = builder.mCustomDrawableFactories != null ? ImmutableList.copyOf(builder.mCustomDrawableFactories) : null;
        if (builder.mDebugOverlayEnabledSupplier != null) {
            of = builder.mDebugOverlayEnabledSupplier;
        } else {
            of = Suppliers.of(Boolean.FALSE);
        }
        this.mDebugOverlayEnabledSupplier = of;
        this.mPipelineDraweeControllerFactory = builder.mPipelineDraweeControllerFactory;
    }
}
