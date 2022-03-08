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

    /* renamed from: b  reason: collision with root package name */
    public String f60072b;

    /* renamed from: c  reason: collision with root package name */
    public String f60073c;

    /* renamed from: d  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f60074d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60075e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f60076f;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f60077g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60078h;

    public d() {
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
        this.a = null;
        this.f60072b = null;
        this.f60073c = null;
        this.f60076f = new CountDownLatch(1);
        this.f60077g = new e(this);
        this.f60078h = false;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f60073c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f60072b)) {
                    String a = this.a.a(this.f60072b, this.f60073c, str);
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
                        this.f60074d.a(a);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.f60074d.e();
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void a(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (serviceConnection = this.f60077g) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.f60074d = bVar;
                this.f60075e = context;
                boolean b2 = b(context);
                this.f60078h = b2;
                if (!b2) {
                    a(false);
                    return;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (!context.bindService(intent, this.f60077g, 1)) {
                    a(false);
                    return;
                }
                if (TextUtils.isEmpty(this.f60072b)) {
                    this.f60072b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.f60073c) && (signatureArr = context.getPackageManager().getPackageInfo(this.f60072b, 64).signatures) != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b3 : digest) {
                            sb.append(Integer.toHexString((b3 & 255) | 256).substring(1, 3));
                        }
                        this.f60073c = sb.toString();
                    }
                }
                this.f60076f.await(10L, TimeUnit.SECONDS);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60078h : invokeV.booleanValue;
    }
}
