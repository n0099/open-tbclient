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
/* loaded from: classes7.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f39405a;

        /* renamed from: b  reason: collision with root package name */
        public int f39406b;

        /* renamed from: c  reason: collision with root package name */
        public int f39407c;

        /* renamed from: d  reason: collision with root package name */
        public int f39408d;

        /* renamed from: e  reason: collision with root package name */
        public int f39409e;

        /* renamed from: f  reason: collision with root package name */
        public int f39410f;

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
            this.f39405a = -1;
            this.f39406b = -1;
            this.f39407c = -1;
            this.f39408d = -1;
            this.f39409e = -1;
            this.f39410f = -1;
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
            this.f39405a = -1;
            this.f39406b = -1;
            this.f39407c = -1;
            this.f39408d = -1;
            this.f39409e = -1;
            this.f39410f = -1;
            this.f39405a = i2;
            this.f39406b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39405a : invokeV.intValue;
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f39407c = (int) f2;
                this.f39408d = (int) f3;
            }
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                this.f39405a = i2;
                this.f39406b = i3;
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39406b : invokeV.intValue;
        }

        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f39409e = (int) f2;
                this.f39410f = (int) f3;
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39407c : invokeV.intValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39408d : invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39409e : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39410f : invokeV.intValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.f39405a + "," + this.f39406b + "," + this.f39407c + "," + this.f39408d + "," + this.f39409e + "," + this.f39410f + PreferencesUtil.RIGHT_MOUNT;
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
            String k = ah.k(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(k)) {
                b2 = b2.replace("__MAC__", k).replace("__MAC2__", t.a(k)).replace("__MAC3__", t.a(k.replace(":", "")));
            }
            String d2 = ah.d(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(d2)) {
                b2 = b2.replace("__IMEI__", d2).replace("__IMEI2__", t.a(d2)).replace("__IMEI3__", t.b(d2));
            }
            String a2 = com.kwad.sdk.core.f.a.a();
            if (!TextUtils.isEmpty(a2)) {
                b2 = b2.replace("__OAID__", a2).replace("__OAID2__", t.a(a2));
            }
            String i2 = ah.i(KsAdSDKImpl.get().getContext());
            if (!TextUtils.isEmpty(i2)) {
                b2 = b2.replace("__ANDROIDID2__", t.a(i2)).replace("__ANDROIDID3__", t.b(i2)).replace("__ANDROIDID__", i2);
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
