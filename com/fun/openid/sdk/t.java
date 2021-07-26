package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.s;
import com.fun.openid.sdk.u;
/* loaded from: classes5.dex */
public class t implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f32987a;

    public t(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32987a = uVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:10|11|(2:12|13)|(5:15|(2:17|(5:22|23|(2:25|26)|33|26)(2:19|20))(3:36|(1:38)|39)|27|28|29)|41|(0)(0)|27|28|29) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[Catch: all -> 0x0086, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:14:0x0022, B:16:0x002a, B:18:0x002d, B:20:0x0031, B:24:0x0039, B:26:0x0040, B:28:0x0044, B:33:0x004e, B:40:0x0071, B:41:0x0078, B:34:0x0054, B:35:0x005b, B:31:0x004a, B:36:0x005c, B:38:0x0062, B:39:0x006a, B:42:0x007f, B:8:0x000e, B:10:0x0016, B:12:0x001a, B:13:0x001d), top: B:53:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c A[Catch: all -> 0x0086, TryCatch #0 {, blocks: (B:5:0x0005, B:14:0x0022, B:16:0x002a, B:18:0x002d, B:20:0x0031, B:24:0x0039, B:26:0x0040, B:28:0x0044, B:33:0x004e, B:40:0x0071, B:41:0x0078, B:34:0x0054, B:35:0x005b, B:31:0x004a, B:36:0x005c, B:38:0x0062, B:39:0x006a, B:42:0x007f, B:8:0x000e, B:10:0x0016, B:12:0x001a, B:13:0x001d), top: B:53:0x0005, inners: #1 }] */
    @Override // android.content.ServiceConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        s c0378a;
        boolean z;
        String str;
        s sVar;
        s sVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            synchronized (this) {
                u uVar = this.f32987a;
                int i2 = s.a.f32985a;
                if (iBinder == null) {
                    c0378a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                    c0378a = (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new s.a.C0378a(iBinder) : (s) queryLocalInterface;
                }
                uVar.f32989b = c0378a;
                u uVar2 = this.f32987a;
                u.a aVar = uVar2.f32991d;
                if (aVar != null) {
                    g.a aVar2 = (g.a) aVar;
                    try {
                        sVar2 = uVar2.f32989b;
                    } catch (RemoteException unused) {
                    }
                    if (sVar2 != null) {
                        z = sVar2.a();
                        if (!z) {
                            f.a aVar3 = aVar2.f32964a;
                            if (uVar2.f32988a != null) {
                                try {
                                    sVar = uVar2.f32989b;
                                } catch (RemoteException e2) {
                                    e2.printStackTrace();
                                }
                                if (sVar != null) {
                                    str = sVar.b();
                                    ((e.a) aVar3).a(true, str);
                                }
                                str = null;
                                ((e.a) aVar3).a(true, str);
                            } else {
                                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
                            }
                        } else {
                            if (FunOpenIDSdk.isLogEnabled()) {
                                Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                            }
                            ((e.a) aVar2.f32964a).a(false, null);
                        }
                        uVar2.f32988a.unbindService(uVar2.f32990c);
                        uVar2.f32989b = null;
                        aVar2.f32965b.f32963a = false;
                    }
                    z = false;
                    if (!z) {
                    }
                    uVar2.f32988a.unbindService(uVar2.f32990c);
                    uVar2.f32989b = null;
                    aVar2.f32965b.f32963a = false;
                }
                this.f32987a.getClass();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.f32987a.f32989b = null;
        }
    }
}
