package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static c a;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f60551e;
    public static final String k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public com.ta.utdid2.b.a.c f25a;

    /* renamed from: a  reason: collision with other field name */
    public d f26a;

    /* renamed from: b  reason: collision with root package name */
    public com.ta.utdid2.b.a.c f60552b;

    /* renamed from: b  reason: collision with other field name */
    public Pattern f27b;

    /* renamed from: h  reason: collision with root package name */
    public String f60553h;

    /* renamed from: i  reason: collision with root package name */
    public String f60554i;

    /* renamed from: j  reason: collision with root package name */
    public String f60555j;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(61108092, "Lcom/ta/utdid2/device/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(61108092, "Lcom/ta/utdid2/device/c;");
                return;
            }
        }
        f60551e = new Object();
        k = ".UTSystemConfig" + File.separator + "Global";
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.f60553h = null;
        this.f26a = null;
        this.f60554i = "xx_utdid_key";
        this.f60555j = "xx_utdid_domain";
        this.f25a = null;
        this.f60552b = null;
        this.f27b = Pattern.compile("[^0-9a-zA-Z=/+]+");
        this.mContext = context;
        this.f60552b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f25a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f26a = new d();
        this.f60554i = String.format("K_%d", Integer.valueOf(g.a(this.f60554i)));
        this.f60555j = String.format("D_%d", Integer.valueOf(g.a(this.f60555j)));
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && a == null) {
                synchronized (f60551e) {
                    if (a == null) {
                        c cVar = new c(context);
                        a = cVar;
                        cVar.c();
                    }
                }
            }
            return a;
        }
        return (c) invokeL.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (str != null) {
                if (str.endsWith(StringUtils.LF)) {
                    str = str.substring(0, str.length() - 1);
                }
                if (24 == str.length() && !this.f27b.matcher(str).find()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (cVar = this.f60552b) == null) {
            return;
        }
        if (g.m123a(cVar.getString("UTDID2"))) {
            String string = this.f60552b.getString("UTDID");
            if (!g.m123a(string)) {
                f(string);
            }
        }
        boolean z = false;
        boolean z2 = true;
        if (!g.m123a(this.f60552b.getString("DID"))) {
            this.f60552b.remove("DID");
            z = true;
        }
        if (!g.m123a(this.f60552b.getString("EI"))) {
            this.f60552b.remove("EI");
            z = true;
        }
        if (g.m123a(this.f60552b.getString("SI"))) {
            z2 = z;
        } else {
            this.f60552b.remove("SI");
        }
        if (z2) {
            this.f60552b.commit();
        }
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && b(str)) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.f60552b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.f60552b.commit();
        }
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || str == null || (cVar = this.f25a) == null || str.equals(cVar.getString(this.f60554i))) {
            return;
        }
        this.f25a.putString(this.f60554i, str);
        this.f25a.commit();
    }

    private void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && f() && b(str)) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (b(str2)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void i(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            try {
                str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception unused) {
                str2 = null;
            }
            if (str.equals(str2)) {
                return;
            }
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception unused2) {
            }
        }
    }

    private void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && f() && str != null) {
            i(str);
        }
    }

    public synchronized String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                String str = this.f60553h;
                return str != null ? str : h();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String i() {
        InterceptResult invokeV;
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                try {
                    string = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (b(string)) {
                    return string;
                }
                e eVar = new e();
                boolean z = false;
                try {
                    str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                } catch (Exception unused2) {
                    str = null;
                }
                if (g.m123a(str)) {
                    z = true;
                } else {
                    String e2 = eVar.e(str);
                    if (b(e2)) {
                        h(e2);
                        return e2;
                    }
                    String d2 = eVar.d(str);
                    if (b(d2)) {
                        String c2 = this.f26a.c(d2);
                        if (!g.m123a(c2)) {
                            j(c2);
                            try {
                                str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    String d3 = this.f26a.d(str);
                    if (b(d3)) {
                        this.f60553h = d3;
                        f(d3);
                        g(str);
                        h(this.f60553h);
                        return this.f60553h;
                    }
                }
                String g2 = g();
                if (b(g2)) {
                    String c3 = this.f26a.c(g2);
                    if (z) {
                        j(c3);
                    }
                    h(g2);
                    g(c3);
                    this.f60553h = g2;
                    return g2;
                }
                String string2 = this.f25a.getString(this.f60554i);
                if (!g.m123a(string2)) {
                    String d4 = eVar.d(string2);
                    if (!b(d4)) {
                        d4 = this.f26a.d(string2);
                    }
                    if (b(d4)) {
                        String c4 = this.f26a.c(d4);
                        if (!g.m123a(d4)) {
                            this.f60553h = d4;
                            if (z) {
                                j(c4);
                            }
                            f(this.f60553h);
                            return this.f60553h;
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, PublicSuffixDatabase.EXCEPTION_MARKER, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93};
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(f.a(bArr2), mac.getAlgorithm()));
            return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
        }
        return (String) invokeL.objValue;
    }

    private String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.ta.utdid2.b.a.c cVar = this.f60552b;
            if (cVar != null) {
                String string = cVar.getString("UTDID2");
                if (g.m123a(string) || this.f26a.c(string) == null) {
                    return null;
                }
                return string;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0 : invokeV.booleanValue;
    }

    public synchronized String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String i2 = i();
                this.f60553h = i2;
                if (!TextUtils.isEmpty(i2)) {
                    return this.f60553h;
                }
                try {
                    byte[] m130c = m130c();
                    if (m130c != null) {
                        String encodeToString = com.ta.utdid2.a.a.b.encodeToString(m130c, 2);
                        this.f60553h = encodeToString;
                        f(encodeToString);
                        String c2 = this.f26a.c(m130c);
                        if (c2 != null) {
                            j(c2);
                            g(c2);
                        }
                        return this.f60553h;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m130c() throws Exception {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nextInt = new Random().nextInt();
            byte[] bytes = com.ta.utdid2.a.a.d.getBytes(currentTimeMillis);
            byte[] bytes2 = com.ta.utdid2.a.a.d.getBytes(nextInt);
            byteArrayOutputStream.write(bytes, 0, 4);
            byteArrayOutputStream.write(bytes2, 0, 4);
            byteArrayOutputStream.write(3);
            byteArrayOutputStream.write(0);
            try {
                str = com.ta.utdid2.a.a.e.a(this.mContext);
            } catch (Exception unused) {
                str = "" + new Random().nextInt();
            }
            byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(str)), 0, 4);
            byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeV.objValue;
    }
}
