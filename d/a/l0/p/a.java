package d.a.l0.p;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sso.o.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sso.o.a f43160a;

    /* renamed from: b  reason: collision with root package name */
    public Context f43161b;

    /* renamed from: c  reason: collision with root package name */
    public String f43162c;

    /* renamed from: d  reason: collision with root package name */
    public String f43163d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.n.b f43164e;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f43165f;

    public a(Context context) {
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
        this.f43160a = null;
        this.f43162c = null;
        this.f43163d = null;
        this.f43165f = new c(this);
        this.f43161b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055 A[Catch: NoSuchAlgorithmException -> 0x006f, all -> 0x007e, LOOP:0: B:24:0x0053->B:25:0x0055, LOOP_END, TryCatch #1 {NoSuchAlgorithmException -> 0x006f, blocks: (B:23:0x0045, B:25:0x0055, B:26:0x006b), top: B:45:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f43160a != null) {
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.f43162c)) {
                        this.f43162c = this.f43161b.getPackageName();
                    }
                    if (TextUtils.isEmpty(this.f43163d)) {
                        try {
                            packageInfo = this.f43161b.getPackageManager().getPackageInfo(this.f43162c, 64);
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (packageInfo != null) {
                            signatureArr = packageInfo.signatures;
                            if (signatureArr != null && signatureArr.length > 0) {
                                try {
                                    byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b2 : digest) {
                                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                                    }
                                    str2 = sb.toString();
                                } catch (NoSuchAlgorithmException unused2) {
                                }
                            }
                            this.f43163d = str2;
                        }
                        signatureArr = null;
                        if (signatureArr != null) {
                            byte[] digest2 = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                            StringBuilder sb2 = new StringBuilder();
                            while (r3 < r4) {
                            }
                            str2 = sb2.toString();
                        }
                        this.f43163d = str2;
                    }
                    str2 = ((a.AbstractBinderC0170a.C0171a) this.f43160a).a(this.f43162c, this.f43163d, str);
                } catch (Throwable unused3) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            this.f43161b.bindService(intent, this.f43165f, 1);
        }
    }
}
