package d.n.a.a.a.b.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.f.a f75084a;

    /* renamed from: b  reason: collision with root package name */
    public String f75085b;

    /* renamed from: c  reason: collision with root package name */
    public String f75086c;

    /* renamed from: d  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f75087d;

    /* renamed from: e  reason: collision with root package name */
    public Context f75088e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f75089f;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f75090g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f75091h;

    public a() {
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
        this.f75084a = null;
        this.f75085b = null;
        this.f75086c = null;
        this.f75089f = new CountDownLatch(1);
        this.f75090g = new b(this);
        this.f75091h = false;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode > 0;
            } catch (PackageManager.NameNotFoundException e2) {
                d.n.a.a.c.b.b.c(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            try {
                if (this.f75091h) {
                    if (TextUtils.isEmpty(this.f75085b)) {
                        this.f75085b = context.getPackageName();
                    }
                    if (TextUtils.isEmpty(this.f75086c)) {
                        String str2 = null;
                        Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f75085b, 64).signatures;
                        if (signatureArr != null && signatureArr.length > 0) {
                            byte[] byteArray = signatureArr[0].toByteArray();
                            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                            if (messageDigest != null) {
                                byte[] digest = messageDigest.digest(byteArray);
                                StringBuilder sb = new StringBuilder();
                                for (byte b2 : digest) {
                                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                                }
                                str2 = sb.toString();
                            }
                        }
                        this.f75086c = str2;
                    }
                    if (!TextUtils.isEmpty(this.f75086c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f75085b)) {
                        String a2 = this.f75084a.a(this.f75085b, this.f75086c, str);
                        return TextUtils.isEmpty(a2) ? "" : a2;
                    }
                    return "";
                }
                return "";
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || (serviceConnection = this.f75090g) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            try {
                this.f75087d = bVar;
                this.f75088e = context;
                boolean g2 = g(context);
                this.f75091h = g2;
                if (!g2) {
                    e(false);
                    return;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (!context.bindService(intent, this.f75090g, 1)) {
                    e(false);
                    return;
                }
                this.f75089f.await(3000L, TimeUnit.MILLISECONDS);
                if (this.f75084a != null) {
                    e(true);
                } else {
                    e(false);
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                if (z) {
                    this.f75087d.a(this.f75084a);
                } else {
                    this.f75087d.e();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75091h : invokeV.booleanValue;
    }
}
