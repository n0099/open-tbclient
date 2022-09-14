package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public class bb implements au {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f131a;

    /* renamed from: a  reason: collision with other field name */
    public Context f132a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f133a;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f134a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f135a;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb a;

        /* renamed from: a  reason: collision with other field name */
        public String f136a;
        public String b;
        public String c;
        public String d;

        public a(bb bbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bbVar;
            this.f136a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public /* synthetic */ a(bb bbVar, bc bcVar) {
            this(bbVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb a;

        public b(bb bbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bbVar;
        }

        public /* synthetic */ b(bb bbVar, bc bcVar) {
            this(bbVar);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) && this.a.f134a == null) {
                new Thread(new bd(this, iBinder)).start();
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
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(IBinder iBinder, String str, String str2, String str3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, iBinder, str, str2, str3)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return (String) invokeLLLL.objValue;
        }
    }

    public bb(Context context) {
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
        this.f131a = 0;
        this.f134a = null;
        this.f135a = new Object();
        this.f132a = context;
        a();
    }

    private void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f133a = new b(this, null);
            Intent intent = new Intent();
            intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            try {
                z = this.f132a.bindService(intent, this.f133a, 1);
            } catch (Exception unused) {
                z = false;
            }
            this.f131a = z ? 1 : 2;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, str) == null) && this.f131a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f135a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m90a("oppo's " + str + " wait...");
                    this.f135a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
                if (packageInfo != null) {
                    long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                    boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                    a = longVersionCode >= 1;
                    if (z) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                Signature[] signatureArr = this.f132a.getPackageManager().getPackageInfo(this.f132a.getPackageName(), 64).signatures;
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                StringBuilder sb = new StringBuilder();
                for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b  reason: collision with other method in class */
    public void m193b() {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (serviceConnection = this.f133a) == null) {
            return;
        }
        try {
            this.f132a.unbindService(serviceConnection);
        } catch (Exception unused) {
        }
    }

    @Override // com.xiaomi.push.au
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getOAID");
            if (this.f134a == null) {
                return null;
            }
            return this.f134a.b;
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
