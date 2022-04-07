package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class Fresco {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public static DraweeControllerBuilderSupplierFactory mFactory;
    public static volatile boolean sIsInitialized;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class DraweeControllerBuilderSupplierFactory implements Supplier<Supplier<? extends AbstractDraweeControllerBuilder>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public DraweeConfig mImagePipelineConfig;
        public volatile PipelineDraweeControllerBuilderSupplier mInstance;

        public DraweeControllerBuilderSupplierFactory(Context context, DraweeConfig draweeConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, draweeConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInstance = null;
            this.mContext = context;
            this.mImagePipelineConfig = draweeConfig;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.facebook.common.internal.Supplier<com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder>' to match base method */
        @Override // com.facebook.common.internal.Supplier
        /* renamed from: get */
        public Supplier<? extends AbstractDraweeControllerBuilder> get2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mInstance == null) {
                    synchronized (this) {
                        if (this.mInstance == null) {
                            this.mInstance = new PipelineDraweeControllerBuilderSupplier(this.mContext, this.mImagePipelineConfig);
                        }
                    }
                }
                return this.mInstance;
            }
            return (Supplier) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(577772188, "Lcom/facebook/drawee/backends/pipeline/Fresco;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(577772188, "Lcom/facebook/drawee/backends/pipeline/Fresco;");
                return;
            }
        }
        TAG = Fresco.class;
    }

    public Fresco() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (PipelineDraweeControllerBuilderSupplier) mFactory.get2() : (PipelineDraweeControllerBuilderSupplier) invokeV.objValue;
    }

    public static ImagePipeline getImagePipeline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? getImagePipelineFactory().getImagePipeline() : (ImagePipeline) invokeV.objValue;
    }

    public static ImagePipelineFactory getImagePipelineFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ImagePipelineFactory.getInstance() : (ImagePipelineFactory) invokeV.objValue;
    }

    public static boolean hasBeenInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? sIsInitialized : invokeV.booleanValue;
    }

    public static void initialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            initialize(context, null, null);
        }
    }

    public static void initializeDrawee(Context context, @Nullable DraweeConfig draweeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, draweeConfig) == null) {
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
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (PipelineDraweeControllerBuilder) mFactory.get2().get() : (PipelineDraweeControllerBuilder) invokeV.objValue;
    }

    public static void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            mFactory = null;
            SimpleDraweeView.shutDown();
            ImagePipelineFactory.shutDown();
        }
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, imagePipelineConfig) == null) {
            initialize(context, imagePipelineConfig, null);
        }
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig, @Nullable DraweeConfig draweeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, imagePipelineConfig, draweeConfig) == null) {
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
}
