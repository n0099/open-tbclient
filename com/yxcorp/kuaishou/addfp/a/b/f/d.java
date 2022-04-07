package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public String b;
    public String c;
    public com.yxcorp.kuaishou.addfp.a.b.b d;
    public Context e;
    public CountDownLatch f;
    public ServiceConnection g;
    public boolean h;

    public d() {
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
        this.f = new CountDownLatch(1);
        this.g = new e(this);
        this.h = false;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.b)) {
                    String a = this.a.a(this.b, this.c, str);
                    return TextUtils.isEmpty(a) ? "" : a;
                }
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            if (z) {
                try {
                    String a = a("OUID");
                    if (!TextUtils.isEmpty(a)) {
                        this.d.a(a);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.d.e();
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void a(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (serviceConnection = this.g) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.d = bVar;
                this.e = context;
                boolean b = b(context);
                this.h = b;
                if (!b) {
                    a(false);
                    return;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (!context.bindService(intent, this.g, 1)) {
                    a(false);
                    return;
                }
                if (TextUtils.isEmpty(this.b)) {
                    this.b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.c) && (signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures) != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        this.c = sb.toString();
                    }
                }
                this.f.await(10L, TimeUnit.SECONDS);
                if (this.a != null) {
                    a(true);
                } else {
                    a(false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a(false);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : invokeV.booleanValue;
    }
}
