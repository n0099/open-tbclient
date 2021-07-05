package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ta.utdid2.a.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c f41684a;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f41685e;
    public static final String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public com.ta.utdid2.b.a.c f20a;

    /* renamed from: a  reason: collision with other field name */
    public d f21a;

    /* renamed from: b  reason: collision with root package name */
    public com.ta.utdid2.b.a.c f41686b;

    /* renamed from: b  reason: collision with other field name */
    public Pattern f22b;

    /* renamed from: g  reason: collision with root package name */
    public String f41687g;

    /* renamed from: h  reason: collision with root package name */
    public String f41688h;

    /* renamed from: i  reason: collision with root package name */
    public String f41689i;
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
        f41685e = new Object();
        j = ".UTSystemConfig" + File.separator + "Global";
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
        this.f41687g = null;
        this.f21a = null;
        this.f41688h = "xx_utdid_key";
        this.f41689i = "xx_utdid_domain";
        this.f20a = null;
        this.f41686b = null;
        this.f22b = Pattern.compile("[^0-9a-zA-Z=/+]+");
        this.mContext = context;
        this.f41686b = new com.ta.utdid2.b.a.c(context, j, "Alvin2", false, true);
        this.f20a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f21a = new d();
        this.f41688h = String.format("K_%d", Integer.valueOf(f.hashCode(this.f41688h)));
        this.f41689i = String.format("D_%d", Integer.valueOf(f.hashCode(this.f41689i)));
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && f41684a == null) {
                synchronized (f41685e) {
                    if (f41684a == null) {
                        c cVar = new c(context);
                        f41684a = cVar;
                        cVar.m66c();
                    }
                }
            }
            return f41684a;
        }
        return (c) invokeL.objValue;
    }

    private byte[] b() throws Exception {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nextInt = new Random().nextInt();
            byte[] bytes = com.ta.utdid2.a.a.c.getBytes(currentTimeMillis);
            byte[] bytes2 = com.ta.utdid2.a.a.c.getBytes(nextInt);
            byteArrayOutputStream.write(bytes, 0, 4);
            byteArrayOutputStream.write(bytes2, 0, 4);
            byteArrayOutputStream.write(3);
            byteArrayOutputStream.write(0);
            try {
                str = com.ta.utdid2.a.a.d.getImei(this.mContext);
            } catch (Exception unused) {
                str = "" + new Random().nextInt();
            }
            byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.hashCode(str)), 0, 4);
            byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(f.hashCode(b(byteArrayOutputStream.toByteArray()))));
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m66c() {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (cVar = this.f41686b) == null) {
            return;
        }
        if (f.isEmpty(cVar.getString("UTDID2"))) {
            String string = this.f41686b.getString("UTDID");
            if (!f.isEmpty(string)) {
                d(string);
            }
        }
        boolean z = false;
        boolean z2 = true;
        if (!f.isEmpty(this.f41686b.getString("DID"))) {
            this.f41686b.remove("DID");
            z = true;
        }
        if (!f.isEmpty(this.f41686b.getString("EI"))) {
            this.f41686b.remove("EI");
            z = true;
        }
        if (f.isEmpty(this.f41686b.getString("SI"))) {
            z2 = z;
        } else {
            this.f41686b.remove("SI");
        }
        if (z2) {
            this.f41686b.commit();
        }
    }

    private void d(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, str) == null) && a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.f41686b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.f41686b.commit();
        }
    }

    private void e(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, str) == null) || str == null || (cVar = this.f20a) == null || str.equals(cVar.getString(this.f41688h))) {
            return;
        }
        this.f20a.putString(this.f41688h, str);
        this.f20a.commit();
    }

    private void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && e() && a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (a(str2)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void g(String str) {
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

    private void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && e() && str != null) {
            g(str);
        }
    }

    public synchronized String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f41687g != null) {
                    return this.f41687g;
                }
                return d();
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public synchronized String m67e() {
        InterceptResult invokeV;
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                try {
                    string = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (a(string)) {
                    return string;
                }
                e eVar = new e();
                boolean z = false;
                try {
                    str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                } catch (Exception unused2) {
                    str = null;
                }
                if (f.isEmpty(str)) {
                    z = true;
                } else {
                    String e2 = eVar.e(str);
                    if (a(e2)) {
                        f(e2);
                        return e2;
                    }
                    String d2 = eVar.d(str);
                    if (a(d2)) {
                        String c2 = this.f21a.c(d2);
                        if (!f.isEmpty(c2)) {
                            h(c2);
                            try {
                                str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    String d3 = this.f21a.d(str);
                    if (a(d3)) {
                        this.f41687g = d3;
                        d(d3);
                        e(str);
                        f(this.f41687g);
                        return this.f41687g;
                    }
                }
                String c3 = c();
                if (a(c3)) {
                    String c4 = this.f21a.c(c3);
                    if (z) {
                        h(c4);
                    }
                    f(c3);
                    e(c4);
                    this.f41687g = c3;
                    return c3;
                }
                String string2 = this.f20a.getString(this.f41688h);
                if (!f.isEmpty(string2)) {
                    String d4 = eVar.d(string2);
                    if (!a(d4)) {
                        d4 = this.f21a.d(string2);
                    }
                    if (a(d4)) {
                        String c5 = this.f21a.c(d4);
                        if (!f.isEmpty(d4)) {
                            this.f41687g = d4;
                            if (z) {
                                h(c5);
                            }
                            d(this.f41687g);
                            return this.f41687g;
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str != null) {
                if (str.endsWith("\n")) {
                    str = str.substring(0, str.length() - 1);
                }
                if (24 == str.length() && !this.f22b.matcher(str).find()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                String m67e = m67e();
                this.f41687g = m67e;
                if (!TextUtils.isEmpty(m67e)) {
                    return this.f41687g;
                }
                try {
                    byte[] b2 = b();
                    if (b2 != null) {
                        String encodeToString = com.ta.utdid2.a.a.b.encodeToString(b2, 2);
                        this.f41687g = encodeToString;
                        d(encodeToString);
                        String c2 = this.f21a.c(b2);
                        if (c2 != null) {
                            h(c2);
                            e(c2);
                        }
                        return this.f41687g;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            com.ta.utdid2.b.a.c cVar = this.f41686b;
            if (cVar != null) {
                String string = cVar.getString("UTDID2");
                if (f.isEmpty(string) || this.f21a.c(string) == null) {
                    return null;
                }
                return string;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String b(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, PublicSuffixDatabase.EXCEPTION_MARKER, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93};
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(com.ta.utdid2.a.a.e.a(bArr2), mac.getAlgorithm()));
            return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
        }
        return (String) invokeL.objValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0 : invokeV.booleanValue;
    }
}
