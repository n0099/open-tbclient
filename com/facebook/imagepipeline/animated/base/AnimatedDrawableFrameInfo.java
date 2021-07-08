package com.facebook.imagepipeline.animated.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AnimatedDrawableFrameInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlendOperation blendOperation;
    public final DisposalMethod disposalMethod;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class BlendOperation {
        public static final /* synthetic */ BlendOperation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BlendOperation BLEND_WITH_PREVIOUS;
        public static final BlendOperation NO_BLEND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-196484216, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$BlendOperation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-196484216, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$BlendOperation;");
                    return;
                }
            }
            BLEND_WITH_PREVIOUS = new BlendOperation("BLEND_WITH_PREVIOUS", 0);
            BlendOperation blendOperation = new BlendOperation("NO_BLEND", 1);
            NO_BLEND = blendOperation;
            $VALUES = new BlendOperation[]{BLEND_WITH_PREVIOUS, blendOperation};
        }

        public BlendOperation(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BlendOperation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BlendOperation) Enum.valueOf(BlendOperation.class, str) : (BlendOperation) invokeL.objValue;
        }

        public static BlendOperation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BlendOperation[]) $VALUES.clone() : (BlendOperation[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class DisposalMethod {
        public static final /* synthetic */ DisposalMethod[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DisposalMethod DISPOSE_DO_NOT;
        public static final DisposalMethod DISPOSE_TO_BACKGROUND;
        public static final DisposalMethod DISPOSE_TO_PREVIOUS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1708043564, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1708043564, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo$DisposalMethod;");
                    return;
                }
            }
            DISPOSE_DO_NOT = new DisposalMethod("DISPOSE_DO_NOT", 0);
            DISPOSE_TO_BACKGROUND = new DisposalMethod("DISPOSE_TO_BACKGROUND", 1);
            DisposalMethod disposalMethod = new DisposalMethod("DISPOSE_TO_PREVIOUS", 2);
            DISPOSE_TO_PREVIOUS = disposalMethod;
            $VALUES = new DisposalMethod[]{DISPOSE_DO_NOT, DISPOSE_TO_BACKGROUND, disposalMethod};
        }

        public DisposalMethod(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DisposalMethod valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DisposalMethod) Enum.valueOf(DisposalMethod.class, str) : (DisposalMethod) invokeL.objValue;
        }

        public static DisposalMethod[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DisposalMethod[]) $VALUES.clone() : (DisposalMethod[]) invokeV.objValue;
        }
    }

    public AnimatedDrawableFrameInfo(int i2, int i3, int i4, int i5, int i6, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), blendOperation, disposalMethod};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.frameNumber = i2;
        this.xOffset = i3;
        this.yOffset = i4;
        this.width = i5;
        this.height = i6;
        this.blendOperation = blendOperation;
        this.disposalMethod = disposalMethod;
    }
}
