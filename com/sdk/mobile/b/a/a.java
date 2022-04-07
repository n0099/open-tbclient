package com.sdk.mobile.b.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.f.g.g;
/* loaded from: classes7.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.mobile.b.a.a";
    public static Boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public d c;
    public Context d;
    public f e;
    public int f;
    public CallBack<T> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1149634835, "Lcom/sdk/mobile/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1149634835, "Lcom/sdk/mobile/b/a/a;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.base.framework.c.f.b);
    }

    public a(Context context, int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), callBack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = context;
        this.g = callBack;
        i = i <= 0 ? 30 : i;
        this.f = i;
        d dVar = new d(this, i * 1000);
        this.c = dVar;
        dVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2, str) == null) {
            String a2 = com.sdk.base.framework.f.f.a.b().a();
            if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
                a2 = com.sdk.base.framework.f.i.a.a(20);
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.b();
            }
            CallBack<T> callBack = this.g;
            if (callBack != null) {
                callBack.onFailed(i, i2, str, a2);
                this.g = null;
            }
            com.sdk.base.framework.f.k.a.a(this.d, i2, str, a2, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, T t, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
                str2 = com.sdk.base.framework.f.i.a.a(20);
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.b();
            }
            CallBack<T> callBack = this.g;
            if (callBack != null) {
                callBack.onSuccess(i, str, i2, t, str2);
                this.g = null;
            }
            com.sdk.base.framework.f.k.a.a(this.d, i2, str, str2, this.f);
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            String a2 = com.sdk.base.framework.a.a.a.a(this.d, i, g.b.a());
            if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
                a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
            } else if (!com.sdk.base.framework.f.i.b.a(this.d)) {
                a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
            } else {
                new com.sdk.mobile.a.a();
                com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.d, new b(this, i));
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData("serviceType", Integer.valueOf(i));
                this.e = aVar.a(aVar.b, "/dro/netm/v1.0/gctcbs", dataInfo, aVar.a(), 0, j.b);
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            com.sdk.base.framework.a.a.a.b(this.d);
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.d, new c(this, str2));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(YYInnerSSOLoginActivity.o, str);
            dataInfo.putData("mobile", str2);
            this.e = aVar.a(aVar.b, "/dro/netm/v1.0/gmctc", dataInfo, aVar.a(), 0, j.b);
        }
    }
}
