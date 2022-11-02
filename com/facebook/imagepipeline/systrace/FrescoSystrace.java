package com.facebook.imagepipeline.systrace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class FrescoSystrace {
    public static /* synthetic */ Interceptable $ic;
    public static final ArgsBuilder NO_OP_ARGS_BUILDER;
    @Nullable
    public static volatile Systrace sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.imagepipeline.systrace.FrescoSystrace$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface ArgsBuilder {
        ArgsBuilder arg(String str, double d);

        ArgsBuilder arg(String str, int i);

        ArgsBuilder arg(String str, long j);

        ArgsBuilder arg(String str, Object obj);

        void flush();
    }

    /* loaded from: classes7.dex */
    public interface Systrace {
        void beginSection(String str);

        ArgsBuilder beginSectionWithArgs(String str);

        void endSection();

        boolean isTracing();
    }

    /* loaded from: classes7.dex */
    public static final class NoOpArgsBuilder implements ArgsBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d)})) == null) ? this : (ArgsBuilder) invokeCommon.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? this : (ArgsBuilder) invokeLI.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this : (ArgsBuilder) invokeLJ.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) ? this : (ArgsBuilder) invokeLL.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public NoOpArgsBuilder() {
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

        public /* synthetic */ NoOpArgsBuilder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1554588377, "Lcom/facebook/imagepipeline/systrace/FrescoSystrace;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1554588377, "Lcom/facebook/imagepipeline/systrace/FrescoSystrace;");
                return;
            }
        }
        NO_OP_ARGS_BUILDER = new NoOpArgsBuilder(null);
        sInstance = null;
    }

    public FrescoSystrace() {
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

    public static void endSection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            getInstance().endSection();
        }
    }

    public static Systrace getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (sInstance == null) {
                synchronized (FrescoSystrace.class) {
                    if (sInstance == null) {
                        sInstance = new DefaultFrescoSystrace();
                    }
                }
            }
            return sInstance;
        }
        return (Systrace) invokeV.objValue;
    }

    public static boolean isTracing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return getInstance().isTracing();
        }
        return invokeV.booleanValue;
    }

    public static void beginSection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            getInstance().beginSection(str);
        }
    }

    public static ArgsBuilder beginSectionWithArgs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return getInstance().beginSectionWithArgs(str);
        }
        return (ArgsBuilder) invokeL.objValue;
    }

    public static void provide(Systrace systrace) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, systrace) == null) {
            sInstance = systrace;
        }
    }
}
