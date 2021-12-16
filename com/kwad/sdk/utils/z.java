package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes3.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f60249b;

        /* renamed from: c  reason: collision with root package name */
        public int f60250c;

        /* renamed from: d  reason: collision with root package name */
        public int f60251d;

        /* renamed from: e  reason: collision with root package name */
        public int f60252e;

        /* renamed from: f  reason: collision with root package name */
        public int f60253f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f60249b = -1;
            this.f60250c = -1;
            this.f60251d = -1;
            this.f60252e = -1;
            this.f60253f = -1;
        }

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.f60249b = -1;
            this.f60250c = -1;
            this.f60251d = -1;
            this.f60252e = -1;
            this.f60253f = -1;
            this.a = i2;
            this.f60249b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f60250c = (int) f2;
                this.f60251d = (int) f3;
            }
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                this.a = i2;
                this.f60249b = i3;
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60249b : invokeV.intValue;
        }

        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f60252e = (int) f2;
                this.f60253f = (int) f3;
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60250c : invokeV.intValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60251d : invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60252e : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60253f : invokeV.intValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.a + "," + this.f60249b + "," + this.f60250c + "," + this.f60251d + "," + this.f60252e + "," + this.f60253f + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 > -1 ? String.valueOf(i2) : "-999" : (String) invokeI.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.replace("__TS__", String.valueOf(System.currentTimeMillis())) : (String) invokeL.objValue;
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String b2 = b(b(str, aVar));
            String v = av.v(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(v)) {
                b2 = b2.replace("__MAC__", v).replace("__MAC2__", aa.a(v)).replace("__MAC3__", aa.a(v.replace(":", "")));
            }
            String d2 = av.d(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(d2)) {
                b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", aa.a(d2)).replace("__IMEI3__", aa.b(d2));
            }
            String a2 = com.kwad.sdk.core.f.a.a();
            if (!TextUtils.isEmpty(a2)) {
                b2 = b2.replace("__OAID__", a2).replace("__OAID2__", aa.a(a2));
            }
            String t = av.t(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(t)) {
                b2 = b2.replace("__ANDROIDID2__", aa.a(t)).replace("__ANDROIDID3__", aa.b(t)).replace("__ANDROIDID__", t);
            }
            return a(b2);
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            Context context = KsAdSDKImpl.get().getContext();
            return str.replace("__SCREEN_WIDTH__", String.valueOf(av.n(context))).replace("__SCREEN_HEIGHT__", String.valueOf(av.o(context))).replace("__DEVICE_WIDTH__", String.valueOf(av.p(context))).replace("__DEVICE_HEIGHT__", String.valueOf(av.q(context)));
        }
        return (String) invokeL.objValue;
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar)) == null) ? (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f())) : (String) invokeLL.objValue;
    }
}
