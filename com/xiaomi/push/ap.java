package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes2.dex */
public class ap implements ar {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70666a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f123a;

    /* renamed from: a  reason: collision with other field name */
    public Context f124a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f125a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f126a;

    /* renamed from: a  reason: collision with other field name */
    public volatile String f127a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f70667b;

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f128b;

    /* loaded from: classes2.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ap f70668a;

        public a(ap apVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70668a = apVar;
        }

        public /* synthetic */ a(ap apVar, aq aqVar) {
            this(apVar);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.f70668a.f127a = b.a(iBinder);
                    this.f70668a.f128b = b.m153a(iBinder);
                    this.f70668a.b();
                    this.f70668a.f123a = 2;
                    synchronized (this.f70668a.f126a) {
                        try {
                            this.f70668a.f126a.notifyAll();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    this.f70668a.b();
                    this.f70668a.f123a = 2;
                    synchronized (this.f70668a.f126a) {
                        try {
                            this.f70668a.f126a.notifyAll();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    this.f70668a.b();
                    this.f70668a.f123a = 2;
                    synchronized (this.f70668a.f126a) {
                        try {
                            this.f70668a.f126a.notifyAll();
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

    /* loaded from: classes2.dex */
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
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
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
        public static boolean m153a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
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

    public ap(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f123a = 0;
        this.f127a = null;
        this.f128b = false;
        this.f70667b = null;
        this.f126a = new Object();
        this.f124a = context;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str3 = null;
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    str2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null);
                    if (str2 != null) {
                        return str2;
                    }
                } else {
                    str2 = null;
                }
            } catch (Exception unused) {
            }
            try {
                str = context.getSharedPreferences("aaid", 0).getString("aaid", null);
            } catch (Exception unused2) {
                str3 = str2;
                str = str3;
                if (str != null) {
                }
            }
            return str != null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    private void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f125a = new a(this, null);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                z = this.f124a.bindService(intent, this.f125a, 1);
            } catch (Exception unused) {
                z = false;
            }
            this.f123a = z ? 1 : 2;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && this.f123a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f126a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m73a("huawei's " + str + " wait...");
                    this.f126a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m151a(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
                z = (packageInfo.applicationInfo.flags & 1) != 0;
                f70666a = packageInfo.versionCode >= 20602000;
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
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (serviceConnection = this.f125a) == null) {
            return;
        }
        try {
            this.f124a.unbindService(serviceConnection);
        } catch (Exception unused) {
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f70666a : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b  reason: collision with other method in class */
    public String mo152b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a("getOAID");
            return this.f127a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f70667b == null) {
                synchronized (this) {
                    if (this.f70667b == null) {
                        this.f70667b = a(this.f124a);
                    }
                }
            }
            return this.f70667b;
        }
        return (String) invokeV.objValue;
    }
}
