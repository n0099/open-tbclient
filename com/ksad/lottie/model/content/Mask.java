package com.ksad.lottie.model.content;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Mask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MaskMode f33873a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f33874b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f33875c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MaskMode {
        public static final /* synthetic */ MaskMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskMode MaskModeAdd;
        public static final MaskMode MaskModeIntersect;
        public static final MaskMode MaskModeSubtract;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1888019638, "Lcom/ksad/lottie/model/content/Mask$MaskMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1888019638, "Lcom/ksad/lottie/model/content/Mask$MaskMode;");
                    return;
                }
            }
            MaskModeAdd = new MaskMode("MaskModeAdd", 0);
            MaskModeSubtract = new MaskMode("MaskModeSubtract", 1);
            MaskMode maskMode = new MaskMode("MaskModeIntersect", 2);
            MaskModeIntersect = maskMode;
            $VALUES = new MaskMode[]{MaskModeAdd, MaskModeSubtract, maskMode};
        }

        public MaskMode(String str, int i2) {
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

        public static MaskMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskMode) Enum.valueOf(MaskMode.class, str) : (MaskMode) invokeL.objValue;
        }

        public static MaskMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskMode[]) $VALUES.clone() : (MaskMode[]) invokeV.objValue;
        }
    }

    public Mask(MaskMode maskMode, com.ksad.lottie.model.a.h hVar, com.ksad.lottie.model.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maskMode, hVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33873a = maskMode;
        this.f33874b = hVar;
        this.f33875c = dVar;
    }

    public MaskMode a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33873a : (MaskMode) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33874b : (com.ksad.lottie.model.a.h) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33875c : (com.ksad.lottie.model.a.d) invokeV.objValue;
    }
}
