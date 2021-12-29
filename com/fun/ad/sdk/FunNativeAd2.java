package com.fun.ad.sdk;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface FunNativeAd2 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class NativeType {
        public static /* synthetic */ Interceptable $ic;
        public static final NativeType BOTH;
        public static final NativeType CUSTOM;
        public static final NativeType EXPRESS;
        public static final /* synthetic */ NativeType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f56208b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f56209c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733932266, "Lcom/fun/ad/sdk/FunNativeAd2$NativeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1733932266, "Lcom/fun/ad/sdk/FunNativeAd2$NativeType;");
                    return;
                }
            }
            NativeType nativeType = new NativeType("CUSTOM", 0, true, false);
            CUSTOM = nativeType;
            NativeType nativeType2 = new NativeType("EXPRESS", 1, false, true);
            EXPRESS = nativeType2;
            NativeType nativeType3 = new NativeType("BOTH", 2, true, true);
            BOTH = nativeType3;
            a = new NativeType[]{nativeType, nativeType2, nativeType3};
        }

        public NativeType(String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f56208b = z;
            this.f56209c = z2;
        }

        public static NativeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NativeType) Enum.valueOf(NativeType.class, str) : (NativeType) invokeL.objValue;
        }

        public static NativeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NativeType[]) a.clone() : (NativeType[]) invokeV.objValue;
        }

        public boolean supportCustom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56208b : invokeV.booleanValue;
        }

        public boolean supportExpress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56209c : invokeV.booleanValue;
        }
    }

    FunNativeInfo getNativeInfo();

    NativeType getNativeType();

    void show(Activity activity, NativeInflater nativeInflater, String str, FunAdInteractionListener funAdInteractionListener);
}
