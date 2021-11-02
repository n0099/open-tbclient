package com.sdk.mobile.b;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.f.g.g;
/* loaded from: classes2.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68264a = "com.sdk.mobile.b.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f68265b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public CallBack<T> f68266c;

    /* renamed from: d  reason: collision with root package name */
    public Context f68267d;

    /* renamed from: e  reason: collision with root package name */
    public e f68268e;

    /* renamed from: f  reason: collision with root package name */
    public f f68269f;

    /* renamed from: g  reason: collision with root package name */
    public int f68270g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1411092635, "Lcom/sdk/mobile/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1411092635, "Lcom/sdk/mobile/b/a;");
                return;
            }
        }
        f68265b = Boolean.valueOf(com.sdk.base.framework.c.f.f68206b);
    }

    public a(Context context, int i2, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), callBack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68266c = callBack;
        this.f68267d = context;
        i2 = i2 <= 0 ? 30 : i2;
        this.f68270g = i2;
        e eVar = new e(this, i2 * 1000);
        this.f68268e = eVar;
        eVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, str) == null) {
            String a2 = com.sdk.base.framework.f.f.a.b().a();
            if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
                a2 = com.sdk.base.framework.f.i.a.a(20);
            }
            e eVar = this.f68268e;
            if (eVar != null) {
                eVar.b();
            }
            CallBack<T> callBack = this.f68266c;
            if (callBack != null) {
                callBack.onFailed(i2, i3, str, a2);
                this.f68266c = null;
            }
            com.sdk.base.framework.f.k.a.a(this.f68267d, i3, str, a2, this.f68270g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, int i3, T t, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) {
            if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
                str2 = com.sdk.base.framework.f.i.a.a(20);
            }
            e eVar = this.f68268e;
            if (eVar != null) {
                eVar.b();
            }
            CallBack<T> callBack = this.f68266c;
            if (callBack != null) {
                callBack.onSuccess(i2, str, i3, t, str2);
                this.f68266c = null;
            }
            com.sdk.base.framework.f.k.a.a(this.f68267d, i3, str, str2, this.f68270g);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String a2 = com.sdk.base.framework.a.a.a.a(this.f68267d, i2, g.f68241a.a());
            if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
                a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
            } else if (!com.sdk.base.framework.f.i.b.a(this.f68267d)) {
                a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
            } else {
                new com.sdk.mobile.a.a();
                com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f68267d, new b(this, i2));
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i2));
                dataInfo.putData("privateIp", com.sdk.base.framework.f.a.a.a());
                dataInfo.putData("newVersion", "10");
                this.f68269f = aVar.a(aVar.f68215b, "/dro/netm/v1.0/qc", dataInfo, aVar.a(), 0, j.f68166b);
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            com.sdk.base.framework.a.a.a.a(this.f68267d);
            new com.sdk.mobile.a.a();
            this.f68269f = com.sdk.mobile.a.a.a(this.f68267d, str, null, new d(this));
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            com.sdk.base.framework.a.a.a.b(this.f68267d);
            new com.sdk.mobile.a.a();
            this.f68269f = com.sdk.mobile.a.a.a(this.f68267d, str, str2, new c(this));
        }
    }
}
