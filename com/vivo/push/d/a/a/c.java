package com.vivo.push.d.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public final class c extends a<com.vivo.push.d.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639544171, "Lcom/vivo/push/d/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639544171, "Lcom/vivo/push/d/a/a/c;");
                return;
            }
        }
        b = Arrays.asList(3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.vivo.push.d.a.a aVar, h hVar) {
        super("CheckNode", aVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1], (h) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static int a2(com.vivo.push.d.a.a aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            try {
            } catch (Exception e) {
                u.a("CheckNode", e);
            }
            if (!com.vivo.push.d.a.a().e().m()) {
                u.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
                return 2809;
            }
            Intent b2 = aVar.b();
            String b3 = com.vivo.push.sdk.a.a().b();
            if (!TextUtils.isEmpty(b3) && b3.contains("CommandService")) {
                if (b2 != null && a(b2) && b(b2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    u.a("CheckNode", " !checkIntentIsSecurity(intent)");
                    return 2801;
                }
            }
            Context b4 = com.vivo.push.d.a.a().b();
            String packageName = b4.getPackageName();
            String stringExtra = b2.getStringExtra("command_type");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                int intExtra = b2.getIntExtra("command", -1);
                if (intExtra < 0) {
                    intExtra = b2.getIntExtra("method", -1);
                }
                if (b.contains(Integer.valueOf(intExtra)) && aa.c(b4, packageName) && !aa.b(b4)) {
                    u.a("CheckNode", "METHOD_ON_MESSAGE is not support");
                    return 2803;
                }
                String action = b2.getAction();
                if (TextUtils.isEmpty(com.vivo.push.d.a.a().e().a(b4, action))) {
                    u.d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    b2.setPackage(packageName);
                    b4.sendBroadcast(b2);
                    return 2802;
                }
                return 0;
            }
            u.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
            return 2801;
        }
        return invokeL.intValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent)) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                return true;
            }
            try {
                Context b2 = com.vivo.push.d.a.a().b();
                String b3 = ag.b(b2, "com.vivo.pushservice");
                u.d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(b3)));
                if (!TextUtils.equals(b3, "1")) {
                    return true;
                }
                String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
                String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    if (!TextUtils.equals(stringExtra, "com.vivo.pushservice") && !TextUtils.equals(stringExtra2, "com.vivo.pushservice")) {
                        if (com.vivo.push.e.b.a().a(b2).a("com.vivo.pushservice".getBytes("UTF-8"), ab.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                            u.d("CheckNode", " RSA验签通过  ");
                            return true;
                        }
                        u.d("CheckNode", " RSA验签 不通过  ");
                        return false;
                    }
                    u.a("CheckNode", " 验签参数传入错误 securityContent = " + stringExtra + " publickKey= " + stringExtra2);
                    return true;
                }
                u.a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
                return false;
            } catch (Exception e) {
                u.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, intent)) == null) {
            try {
                String stringExtra = intent.getStringExtra("security_avoid_pull");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        String b2 = com.vivo.push.util.a.a(com.vivo.push.d.a.a().b()).b(stringExtra);
                        if (!"com.vivo.pushservice".equals(b2)) {
                            u.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b2)));
                            return false;
                        }
                        return true;
                    } catch (Exception e) {
                        u.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
                        return false;
                    }
                }
                u.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
                return true;
            } catch (Exception unused) {
                u.a("CheckNode", "getStringExtra error");
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.vivo.push.d.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.d.a.a aVar) {
        return a2(aVar);
    }
}
