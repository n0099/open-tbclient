package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.utdid2.a.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f36985a;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f36986e = new Object();
    public static final String j = ".UTSystemConfig" + File.separator + "Global";

    /* renamed from: a  reason: collision with other field name */
    public com.ta.utdid2.b.a.c f17a;

    /* renamed from: a  reason: collision with other field name */
    public d f18a;

    /* renamed from: b  reason: collision with root package name */
    public com.ta.utdid2.b.a.c f36987b;

    /* renamed from: h  reason: collision with root package name */
    public String f36989h;

    /* renamed from: i  reason: collision with root package name */
    public String f36990i;
    public Context mContext;

    /* renamed from: g  reason: collision with root package name */
    public String f36988g = null;

    /* renamed from: b  reason: collision with other field name */
    public Pattern f19b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public c(Context context) {
        this.mContext = null;
        this.f18a = null;
        this.f36989h = "xx_utdid_key";
        this.f36990i = "xx_utdid_domain";
        this.f17a = null;
        this.f36987b = null;
        this.mContext = context;
        this.f36987b = new com.ta.utdid2.b.a.c(context, j, "Alvin2", false, true);
        this.f17a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f18a = new d();
        this.f36989h = String.format("K_%d", Integer.valueOf(f.hashCode(this.f36989h)));
        this.f36990i = String.format("D_%d", Integer.valueOf(f.hashCode(this.f36990i)));
    }

    public static c a(Context context) {
        if (context != null && f36985a == null) {
            synchronized (f36986e) {
                if (f36985a == null) {
                    c cVar = new c(context);
                    f36985a = cVar;
                    cVar.m54c();
                }
            }
        }
        return f36985a;
    }

    private byte[] b() throws Exception {
        String str;
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

    /* renamed from: c  reason: collision with other method in class */
    private void m54c() {
        com.ta.utdid2.b.a.c cVar = this.f36987b;
        if (cVar != null) {
            if (f.isEmpty(cVar.getString("UTDID2"))) {
                String string = this.f36987b.getString("UTDID");
                if (!f.isEmpty(string)) {
                    d(string);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!f.isEmpty(this.f36987b.getString("DID"))) {
                this.f36987b.remove("DID");
                z = true;
            }
            if (!f.isEmpty(this.f36987b.getString("EI"))) {
                this.f36987b.remove("EI");
                z = true;
            }
            if (f.isEmpty(this.f36987b.getString("SI"))) {
                z2 = z;
            } else {
                this.f36987b.remove("SI");
            }
            if (z2) {
                this.f36987b.commit();
            }
        }
    }

    private void d(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.f36987b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.f36987b.commit();
        }
    }

    private void e(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str == null || (cVar = this.f17a) == null || str.equals(cVar.getString(this.f36989h))) {
            return;
        }
        this.f17a.putString(this.f36989h, str);
        this.f17a.commit();
    }

    private void f(String str) {
        if (e() && a(str)) {
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

    private void h(String str) {
        if (!e() || str == null) {
            return;
        }
        g(str);
    }

    public synchronized String getValue() {
        if (this.f36988g != null) {
            return this.f36988g;
        }
        return d();
    }

    /* renamed from: e  reason: collision with other method in class */
    public synchronized String m55e() {
        String str;
        String string;
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
                String c2 = this.f18a.c(d2);
                if (!f.isEmpty(c2)) {
                    h(c2);
                    try {
                        str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String d3 = this.f18a.d(str);
            if (a(d3)) {
                this.f36988g = d3;
                d(d3);
                e(str);
                f(this.f36988g);
                return this.f36988g;
            }
        }
        String c3 = c();
        if (a(c3)) {
            String c4 = this.f18a.c(c3);
            if (z) {
                h(c4);
            }
            f(c3);
            e(c4);
            this.f36988g = c3;
            return c3;
        }
        String string2 = this.f17a.getString(this.f36989h);
        if (!f.isEmpty(string2)) {
            String d4 = eVar.d(string2);
            if (!a(d4)) {
                d4 = this.f18a.d(string2);
            }
            if (a(d4)) {
                String c5 = this.f18a.c(d4);
                if (!f.isEmpty(d4)) {
                    this.f36988g = d4;
                    if (z) {
                        h(c5);
                    }
                    d(this.f36988g);
                    return this.f36988g;
                }
            }
        }
        return null;
    }

    private boolean a(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f19b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String d() {
        String m55e = m55e();
        this.f36988g = m55e;
        if (!TextUtils.isEmpty(m55e)) {
            return this.f36988g;
        }
        try {
            byte[] b2 = b();
            if (b2 != null) {
                String encodeToString = com.ta.utdid2.a.a.b.encodeToString(b2, 2);
                this.f36988g = encodeToString;
                d(encodeToString);
                String c2 = this.f18a.c(b2);
                if (c2 != null) {
                    h(c2);
                    e(c2);
                }
                return this.f36988g;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private String c() {
        com.ta.utdid2.b.a.c cVar = this.f36987b;
        if (cVar != null) {
            String string = cVar.getString("UTDID2");
            if (f.isEmpty(string) || this.f18a.c(string) == null) {
                return null;
            }
            return string;
        }
        return null;
    }

    public static String b(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, PublicSuffixDatabase.EXCEPTION_MARKER, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.ta.utdid2.a.a.e.a(bArr2), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
    }

    private boolean e() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }
}
