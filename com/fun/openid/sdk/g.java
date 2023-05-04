package com.fun.openid.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:3|4|5|(7:7|8|(2:10|(5:15|16|(2:18|19)|27|19)(2:12|13))(3:30|(1:32)|33)|20|21|22|23)|35|8|(0)(0)|20|21|22|23) */
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
                tVar2 = vVar.b;
            } catch (RemoteException unused) {
            }
            if (tVar2 != null) {
                z = tVar2.a();
                if (!z) {
                    if (vVar.a != null) {
                        try {
                            tVar = vVar.b;
                        } catch (RemoteException e) {
                            e.printStackTrace();
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
                    if (FunOpenIDSdk.isLogEnabled()) {
                        Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                    }
                    aVar.a(false, null);
                }
                vVar.a.unbindService(vVar.c);
                vVar.b = null;
                this.a = false;
            }
            z = false;
            if (!z) {
            }
            vVar.a.unbindService(vVar.c);
            vVar.b = null;
            this.a = false;
        }
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, final f.a aVar) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) && !this.a) {
            v vVar = new v();
            v.a aVar2 = new v.a() { // from class: com.baidu.tieba.eva
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.fun.openid.sdk.v.a
                public final void a(Object obj, com.fun.openid.sdk.v vVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, vVar2) == null) {
                        com.fun.openid.sdk.g.this.a(aVar, (String) obj, vVar2);
                    }
                }
            };
            vVar.a = context;
            vVar.d = aVar2;
            vVar.c = new u(vVar);
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (vVar.a.bindService(intent, vVar.c, 1)) {
                c = 1;
            } else {
                c = 65535;
            }
            this.a = true;
            if (c != 1) {
                aVar.a(true, null);
            }
        }
    }
}
