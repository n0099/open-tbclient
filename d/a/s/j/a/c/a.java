package d.a.s.j.a.c;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.g.c.a.e;
import d.a.s.g.c.a.f;
import d.a.s.g.c.a.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f68007g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f68008a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68009b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f68010c;

    /* renamed from: d  reason: collision with root package name */
    public String f68011d;

    /* renamed from: e  reason: collision with root package name */
    public Context f68012e;

    /* renamed from: f  reason: collision with root package name */
    public int f68013f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1232782074, "Ld/a/s/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1232782074, "Ld/a/s/j/a/c/a;");
                return;
            }
        }
        f68007g = new byte[]{77, 73, 78, 71};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean e(String str, Context context, JSONObject jSONObject, Set<String> set) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, context, jSONObject, set)) == null) {
            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArray.getString(i2);
            }
            String[] h2 = h(context.getPackageManager().getPackageInfo(str, 64).signatures);
            if (h2 != null && h2.length > 0) {
                Collections.addAll(set, h2);
            }
            return g(strArr, h2);
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
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = f.c(signatureArr[i2].toByteArray());
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public final void a(Bundle bundle, d.a.s.g.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, aVar) == null) {
            try {
                if (aVar == null) {
                    this.f68013f |= 16;
                    return;
                }
                String string = bundle.getString("helios_data");
                if (TextUtils.isEmpty(string)) {
                    this.f68013f |= 1;
                    return;
                }
                String string2 = bundle.getString("helios_sf");
                if (TextUtils.isEmpty(string2)) {
                    this.f68013f |= 2;
                    return;
                }
                byte[] decode = Base64.decode(string.getBytes("utf-8"), 1);
                for (int i2 = 0; i2 < decode.length; i2++) {
                    decode[i2] = (byte) (decode[i2] ^ f68007g[i2 % f68007g.length]);
                }
                JSONObject jSONObject = new JSONObject(new String(decode));
                if (f(jSONObject)) {
                    HashSet hashSet = new HashSet();
                    this.f68010c = hashSet;
                    if (!e(this.f68011d, this.f68012e, jSONObject, hashSet)) {
                        this.f68013f |= 4;
                    } else if (!Arrays.equals(g.a(Base64.decode(string2, 0), aVar), f.b(decode))) {
                        this.f68013f |= 8;
                    } else {
                        this.f68008a = jSONObject.getLong("priority");
                        this.f68009b = true;
                    }
                }
            } catch (Exception e2) {
                this.f68013f |= 256;
                Log.getStackTraceString(e2);
            }
        }
    }

    public void b(d.a.s.g.b.e.a aVar, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            PackageManager packageManager = this.f68012e.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(this.f68011d, 2);
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
                        a(bundle, aVar);
                    }
                }
            }
        }
    }

    public void c(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, context) == null) {
            this.f68011d = str;
            this.f68012e = context;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68009b : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r10.equals(r9.f68011d) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.startsWith(r10) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            e eVar = new e();
            eVar.b(jSONObject.optLong("flags"));
            String optString = jSONObject.optString(AsInstallService.SCHEME_PACKAGE_ADDED, "");
            long a2 = eVar.a(7L);
            if (!optString.equals("") || a2 == 4) {
                if (a2 != 0) {
                    if (a2 == 1) {
                        String str = this.f68011d;
                        if (str != null) {
                        }
                        i2 = this.f68013f | 32;
                        this.f68013f = i2;
                        return false;
                    } else if (a2 == 2) {
                        try {
                            if (!Pattern.compile(optString).matcher(this.f68011d).matches()) {
                                this.f68013f |= 32;
                                return false;
                            }
                        } catch (Exception unused) {
                            i2 = this.f68013f | 128;
                        }
                    } else if (a2 == 4) {
                        return true;
                    }
                    return true;
                }
            }
            i2 = this.f68013f | 64;
            this.f68013f = i2;
            return false;
        }
        return invokeL.booleanValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68008a : invokeV.longValue;
    }

    public Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68010c : (Set) invokeV.objValue;
    }
}
