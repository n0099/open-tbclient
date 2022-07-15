package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class as implements au {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f827a;

    /* renamed from: a  reason: collision with other field name */
    public Context f828a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f829a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f830a;

    /* renamed from: a  reason: collision with other field name */
    public volatile String f831a;
    public volatile String b;

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f832b;

    /* loaded from: classes8.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as a;

        public a(as asVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = asVar;
        }

        public /* synthetic */ a(as asVar, at atVar) {
            this(asVar);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.a.f831a = b.a(iBinder);
                    this.a.f832b = b.m1110a(iBinder);
                    this.a.b();
                    this.a.f827a = 2;
                    synchronized (this.a.f830a) {
                        try {
                            this.a.f830a.notifyAll();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    this.a.b();
                    this.a.f827a = 2;
                    synchronized (this.a.f830a) {
                        try {
                            this.a.f830a.notifyAll();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    this.a.b();
                    this.a.f827a = 2;
                    synchronized (this.a.f830a) {
                        try {
                            this.a.f830a.notifyAll();
                        } catch (Exception unused4) {
                        }
                        throw th;
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iBinder)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return (String) invokeL.objValue;
        }

        /* renamed from: a  reason: collision with other method in class */
        public static boolean m1110a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    iBinder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return invokeL.booleanValue;
        }
    }

    public as(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f827a = 0;
        this.f831a = null;
        this.f832b = false;
        this.b = null;
        this.f830a = new Object();
        this.f828a = context;
        a();
    }

    private void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f829a = new a(this, null);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                z = this.f828a.bindService(intent, this.f829a, 1);
            } catch (Exception unused) {
                z = false;
            }
            this.f827a = z ? 1 : 2;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, str) == null) && this.f827a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f830a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m1027a("huawei's " + str + " wait...");
                    this.f830a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
                z = (packageInfo.applicationInfo.flags & 1) != 0;
                a = packageInfo.versionCode >= 20602000;
            } catch (Exception unused) {
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (serviceConnection = this.f829a) == null) {
            return;
        }
        try {
            this.f828a.unbindService(serviceConnection);
        } catch (Exception unused) {
        }
    }

    @Override // com.xiaomi.push.au
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getOAID");
            return this.f831a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.au
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }
}
