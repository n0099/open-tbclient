package com.kwad.sdk.utils;

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
/* loaded from: classes2.dex */
public final class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f67636a;

        /* renamed from: b  reason: collision with root package name */
        public int f67637b;

        /* renamed from: c  reason: collision with root package name */
        public int f67638c;

        /* renamed from: d  reason: collision with root package name */
        public int f67639d;

        /* renamed from: e  reason: collision with root package name */
        public int f67640e;

        /* renamed from: f  reason: collision with root package name */
        public int f67641f;

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
            this.f67636a = -1;
            this.f67637b = -1;
            this.f67638c = -1;
            this.f67639d = -1;
            this.f67640e = -1;
            this.f67641f = -1;
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
            this.f67636a = -1;
            this.f67637b = -1;
            this.f67638c = -1;
            this.f67639d = -1;
            this.f67640e = -1;
            this.f67641f = -1;
            this.f67636a = i2;
            this.f67637b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67636a : invokeV.intValue;
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f67638c = (int) f2;
                this.f67639d = (int) f3;
            }
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                this.f67636a = i2;
                this.f67637b = i3;
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67637b : invokeV.intValue;
        }

        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f67640e = (int) f2;
                this.f67641f = (int) f3;
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67638c : invokeV.intValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67639d : invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67640e : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67641f : invokeV.intValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.f67636a + "," + this.f67637b + "," + this.f67638c + "," + this.f67639d + "," + this.f67640e + "," + this.f67641f + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 > -1 ? String.valueOf(i2) : "-999" : (String) invokeI.objValue;
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String b2 = b(str, aVar);
            String o = ap.o(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(o)) {
                b2 = b2.replace("__MAC__", o).replace("__MAC2__", w.a(o)).replace("__MAC3__", w.a(o.replace(":", "")));
            }
            String d2 = ap.d(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(d2)) {
                b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", w.a(d2)).replace("__IMEI3__", w.b(d2));
            }
            String a2 = com.kwad.sdk.core.f.a.a();
            if (!TextUtils.isEmpty(a2)) {
                b2 = b2.replace("__OAID__", a2).replace("__OAID2__", w.a(a2));
            }
            String m = ap.m(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(m)) {
                b2 = b2.replace("__ANDROIDID2__", w.a(m)).replace("__ANDROIDID3__", w.b(m)).replace("__ANDROIDID__", m);
            }
            return b2.replace("__TS__", String.valueOf(System.currentTimeMillis()));
        }
        return (String) invokeLL.objValue;
    }

    @WorkerThread
    public static String b(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, aVar)) == null) ? (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", a(aVar.a())).replace("__HEIGHT__", a(aVar.b())).replace("__DOWN_X__", a(aVar.c())).replace("__DOWN_Y__", a(aVar.d())).replace("__UP_X__", a(aVar.e())).replace("__UP_Y__", a(aVar.f())) : (String) invokeLL.objValue;
    }
}
