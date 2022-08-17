package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile com.heytap.openid.a a;
    public String b;
    public String c;
    public final Object d;
    public ServiceConnection e;

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.a.a = a.AbstractBinderC0299a.a(iBinder);
                synchronized (this.a.d) {
                    this.a.d.notify();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.a.a = null;
            }
        }
    }

    /* renamed from: com.heytap.openid.sdk.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0301b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1715560652, "Lcom/heytap/openid/sdk/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1715560652, "Lcom/heytap/openid/sdk/b$b;");
                    return;
                }
            }
            a = new b();
        }
    }

    public b() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = new Object();
        this.e = new a(this);
    }

    public synchronized String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            synchronized (this) {
                String str2 = "getOpenID:" + str;
                if (this.a != null) {
                    try {
                        return b(context, str);
                    } catch (RemoteException unused) {
                        Log.e("OpenIDHelper", "getOpenId removeException");
                        return "";
                    }
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                try {
                    if (!context.bindService(intent, this.e, 1)) {
                        Log.e("OpenIDHelper", "bindService fail.");
                    } else if (this.a == null) {
                        synchronized (this.d) {
                            try {
                                if (this.a == null) {
                                    this.d.wait(3000L);
                                }
                            } catch (InterruptedException unused2) {
                                Log.e("OpenIDHelper", "ex:InterruptedException");
                            }
                        }
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ex:");
                    sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                    Log.e("OpenIDHelper", sb.toString());
                }
                if (this.a == null) {
                    Log.e("OpenIDHelper", "openIDService is NULL, return NULL");
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException unused3) {
                    Log.e("OpenIDHelper", "getOpenId removeException");
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public final String b(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.c = str2;
            }
            if (this.a != null) {
                String a2 = this.a.a(this.b, this.c, str);
                return TextUtils.isEmpty(a2) ? "" : a2;
            }
            Log.e("OpenIDHelper", context.getPackageName() + ":openIDService is NULL, return NULL");
            return "";
        }
        return (String) invokeLL.objValue;
    }
}
