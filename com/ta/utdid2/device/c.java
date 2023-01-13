package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static c a;
    public static final Object e;
    public static final String k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public com.ta.utdid2.b.a.c f31a;

    /* renamed from: a  reason: collision with other field name */
    public d f32a;
    public com.ta.utdid2.b.a.c b;

    /* renamed from: b  reason: collision with other field name */
    public Pattern f33b;
    public String h;
    public String i;
    public String j;
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
        e = new Object();
        k = ".UTSystemConfig" + File.separator + "Global";
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.h = null;
        this.f32a = null;
        this.i = "xx_utdid_key";
        this.j = "xx_utdid_domain";
        this.f31a = null;
        this.b = null;
        this.f33b = Pattern.compile("[^0-9a-zA-Z=/+]+");
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f31a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f32a = new d();
        this.i = String.format("K_%d", Integer.valueOf(g.a(this.i)));
        this.j = String.format("D_%d", Integer.valueOf(g.a(this.j)));
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && a == null) {
                synchronized (e) {
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
                if (str.endsWith("\n")) {
                    str = str.substring(0, str.length() - 1);
                }
                if (24 == str.length() && !this.f33b.matcher(str).find()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (cVar = this.b) != null) {
                cVar.putString("UTDID2", str);
                this.b.commit();
            }
        }
    }

    public static String b(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            byte[] bArr2 = {69, 114, 116, -33, 125, ExifInterface.MARKER_SOF10, ExifInterface.MARKER_APP1, 86, -11, Constants.GZIP_CAST_TYPE, -78, -96, -17, -99, 64, 23, -95, -126, -82, ExifInterface.MARKER_SOF0, 113, 116, -16, -103, 49, -30, 9, ExifInterface.MARKER_EOI, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, ExifInterface.MARKER_SOF15, 106, 85, ExifInterface.MARKER_SOS, -93};
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(f.a(bArr2), mac.getAlgorithm()));
            return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
        }
        return (String) invokeL.objValue;
    }

    private void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && f() && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = ApiReplaceUtil.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (!b(str2)) {
                    try {
                        Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (cVar = this.b) != null) {
            if (g.m93a(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!g.m93a(string)) {
                    f(string);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!g.m93a(this.b.getString("DID"))) {
                this.b.remove("DID");
                z = true;
            }
            if (!g.m93a(this.b.getString("EI"))) {
                this.b.remove("EI");
                z = true;
            }
            if (!g.m93a(this.b.getString("SI"))) {
                this.b.remove("SI");
            } else {
                z2 = z;
            }
            if (z2) {
                this.b.commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m100c() throws Exception {
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

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.ta.utdid2.b.a.c cVar = this.b;
            if (cVar != null) {
                String string = cVar.getString("UTDID2");
                if (!g.m93a(string) && this.f32a.c(string) != null) {
                    return string;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                String str = this.h;
                if (str != null) {
                    return str;
                }
                return h();
            }
        }
        return (String) invokeV.objValue;
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, str) == null) && str != null && (cVar = this.f31a) != null && !str.equals(cVar.getString(this.i))) {
            this.f31a.putString(this.i, str);
            this.f31a.commit();
        }
    }

    private void i(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            try {
                str2 = ApiReplaceUtil.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception unused) {
                str2 = null;
            }
            if (!str.equals(str2)) {
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && f() && str != null) {
            i(str);
        }
    }

    public synchronized String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String i = i();
                this.h = i;
                if (!TextUtils.isEmpty(i)) {
                    return this.h;
                }
                try {
                    byte[] m100c = m100c();
                    if (m100c != null) {
                        String encodeToString = com.ta.utdid2.a.a.b.encodeToString(m100c, 2);
                        this.h = encodeToString;
                        f(encodeToString);
                        String c = this.f32a.c(m100c);
                        if (c != null) {
                            j(c);
                            g(c);
                        }
                        return this.h;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
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
                    string = ApiReplaceUtil.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (b(string)) {
                    return string;
                }
                e eVar = new e();
                boolean z = false;
                try {
                    str = ApiReplaceUtil.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                } catch (Exception unused2) {
                    str = null;
                }
                if (!g.m93a(str)) {
                    String e2 = eVar.e(str);
                    if (b(e2)) {
                        h(e2);
                        return e2;
                    }
                    String d = eVar.d(str);
                    if (b(d)) {
                        String c = this.f32a.c(d);
                        if (!g.m93a(c)) {
                            j(c);
                            try {
                                str = ApiReplaceUtil.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    String d2 = this.f32a.d(str);
                    if (b(d2)) {
                        this.h = d2;
                        f(d2);
                        g(str);
                        h(this.h);
                        return this.h;
                    }
                } else {
                    z = true;
                }
                String g = g();
                if (b(g)) {
                    String c2 = this.f32a.c(g);
                    if (z) {
                        j(c2);
                    }
                    h(g);
                    g(c2);
                    this.h = g;
                    return g;
                }
                String string2 = this.f31a.getString(this.i);
                if (!g.m93a(string2)) {
                    String d3 = eVar.d(string2);
                    if (!b(d3)) {
                        d3 = this.f32a.d(string2);
                    }
                    if (b(d3)) {
                        String c3 = this.f32a.c(d3);
                        if (!g.m93a(d3)) {
                            this.h = d3;
                            if (z) {
                                j(c3);
                            }
                            f(this.h);
                            return this.h;
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
