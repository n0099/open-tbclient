package com.repackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q40 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public Set<String> c;
    public String d;
    public Context e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755430236, "Lcom/repackage/q40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755430236, "Lcom/repackage/q40;");
                return;
            }
        }
        g = new byte[]{77, 73, 78, 71};
    }

    public q40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean e(String str, Context context, JSONObject jSONObject, Set<String> set) throws JSONException, PackageManager.NameNotFoundException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, context, jSONObject, set)) == null) {
            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            String[] h = h(context.getPackageManager().getPackageInfo(str, 64).signatures);
            if (h != null && h.length > 0) {
                Collections.addAll(set, h);
            }
            return g(strArr, h);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean g(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public static String[] h(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = z30.c(signatureArr[i].toByteArray());
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (Set) invokeV.objValue;
    }

    public final void b(Bundle bundle, t30 t30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, t30Var) == null) {
            try {
                if (t30Var == null) {
                    this.f |= 16;
                    return;
                }
                String string = bundle.getString("helios_data");
                if (TextUtils.isEmpty(string)) {
                    this.f |= 1;
                    return;
                }
                String string2 = bundle.getString("helios_sf");
                if (TextUtils.isEmpty(string2)) {
                    this.f |= 2;
                    return;
                }
                byte[] decode = Base64.decode(string.getBytes(IMAudioTransRequest.CHARSET), 1);
                for (int i = 0; i < decode.length; i++) {
                    decode[i] = (byte) (decode[i] ^ g[i % g.length]);
                }
                JSONObject jSONObject = new JSONObject(new String(decode));
                if (f(jSONObject)) {
                    HashSet hashSet = new HashSet();
                    this.c = hashSet;
                    if (!e(this.d, this.e, jSONObject, hashSet)) {
                        this.f |= 4;
                    } else if (!Arrays.equals(a40.a(Base64.decode(string2, 0), t30Var), z30.b(decode))) {
                        this.f |= 8;
                    } else {
                        this.a = jSONObject.getLong("priority");
                        this.b = true;
                    }
                }
            } catch (Exception e) {
                this.f |= 256;
                Log.getStackTraceString(e);
            }
        }
    }

    public void c(t30 t30Var, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, t30Var, z) == null) {
            PackageManager packageManager = this.e.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(this.d, 2);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null || (activityInfoArr = packageInfo.receivers) == null || activityInfoArr.length <= 0) {
                return;
            }
            for (ActivityInfo activityInfo2 : activityInfoArr) {
                if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                    try {
                        activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        activityInfo = null;
                    }
                    if (activityInfo != null && (bundle = activityInfo.metaData) != null && bundle.containsKey("helios") && z) {
                        b(bundle, t30Var);
                    }
                }
            }
        }
    }

    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
            this.d = str;
            this.e = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r10.equals(r9.d) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.startsWith(r10) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            y30 y30Var = new y30();
            y30Var.b(jSONObject.optLong("flags"));
            String optString = jSONObject.optString("package", "");
            long a = y30Var.a(7L);
            if (!optString.equals("") || a == 4) {
                if (a != 0) {
                    if (a == 1) {
                        String str = this.d;
                        if (str != null) {
                        }
                        i = this.f | 32;
                        this.f = i;
                        return false;
                    } else if (a == 2) {
                        try {
                            if (!Pattern.compile(optString).matcher(this.d).matches()) {
                                this.f |= 32;
                                return false;
                            }
                        } catch (Exception unused) {
                            i = this.f | 128;
                        }
                    } else if (a == 4) {
                        return true;
                    }
                    return true;
                }
            }
            i = this.f | 64;
            this.f = i;
            return false;
        }
        return invokeL.booleanValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.longValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.booleanValue;
    }
}
