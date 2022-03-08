package com.fun.openid.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.v;
/* loaded from: classes7.dex */
public class g implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public g() {
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
        this.a = false;
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, final f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || this.a) {
            return;
        }
        v vVar = new v();
        v.a aVar2 = new v.a() { // from class: c.g.g0.a.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.fun.openid.sdk.v.a
            public final void a(Object obj, v vVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, vVar2) == null) {
                    g.this.a(aVar, (String) obj, vVar2);
                }
            }
        };
        vVar.a = context;
        vVar.f52923d = aVar2;
        vVar.f52922c = new u(vVar);
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        char c2 = vVar.a.bindService(intent, vVar.f52922c, 1) ? (char) 1 : (char) 65535;
        this.a = true;
        if (c2 != 1) {
            aVar.a(true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(2:4|5)|(7:7|8|(2:10|(5:15|16|(2:18|19)|27|19)(2:12|13))(1:30)|20|21|22|23)|32|8|(0)(0)|20|21|22|23) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(f.a aVar, String str, v vVar) {
        boolean z;
        String str2;
        t tVar;
        t tVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, str, vVar) == null) {
            vVar.getClass();
            try {
                tVar2 = vVar.f52921b;
            } catch (RemoteException unused) {
            }
            if (tVar2 != null) {
                z = tVar2.a();
                if (!z) {
                    if (vVar.a != null) {
                        try {
                            tVar = vVar.f52921b;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (tVar != null) {
                            str2 = tVar.b();
                            aVar.a(true, str2);
                        }
                        str2 = null;
                        aVar.a(true, str2);
                    } else {
                        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
                    }
                } else {
                    FunOpenIDSdk.isLogEnabled();
                    aVar.a(false, null);
                }
                vVar.a.unbindService(vVar.f52922c);
                vVar.f52921b = null;
                this.a = false;
            }
            z = false;
            if (!z) {
            }
            vVar.a.unbindService(vVar.f52922c);
            vVar.f52921b = null;
            this.a = false;
        }
    }
}
