package d.b.j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.util.FieldBuilder;
import d.b.j.b.a;
import d.b.j.b.b;
import d.b.j.f;
import d.b.j.g.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f64470g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f64471a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1740a f64472b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f64473c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f64474d;

    /* renamed from: e  reason: collision with root package name */
    public b f64475e;

    /* renamed from: f  reason: collision with root package name */
    public f f64476f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f64477g = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f64478a;

        /* renamed from: b  reason: collision with root package name */
        public String f64479b;

        /* renamed from: c  reason: collision with root package name */
        public String f64480c;

        /* renamed from: d  reason: collision with root package name */
        public long f64481d;

        /* renamed from: e  reason: collision with root package name */
        public String f64482e;

        /* renamed from: f  reason: collision with root package name */
        public int f64483f = 1;

        public String e() {
            return this.f64478a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f64483f == aVar.f64483f && this.f64478a.equals(aVar.f64478a) && this.f64479b.equals(aVar.f64479b) && this.f64480c.equals(aVar.f64480c)) {
                String str = this.f64482e;
                String str2 = aVar.f64482e;
                if (str == str2) {
                    return true;
                }
                if (str != null && str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }

        public String h() {
            return this.f64482e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f64478a, this.f64479b, this.f64480c, this.f64482e, Integer.valueOf(this.f64483f)});
        }

        public String j() {
            return this.f64479b;
        }

        public j l() {
            j jVar = new j();
            jVar.f64464a = this.f64478a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f64479b);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.f64479b)) {
                sb.append(this.f64480c);
            }
            if (!TextUtils.isEmpty(this.f64482e)) {
                sb.append(this.f64482e);
            }
            jVar.f64465b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f64478a);
                jSONObject.put("v270fk", this.f64479b);
                jSONObject.put("cck", this.f64480c);
                jSONObject.put("vsk", this.f64483f);
                jSONObject.put("ctk", this.f64481d);
                jSONObject.put("ek", this.f64482e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.b.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f64479b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f64478a);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f64480c);
            }
            if (!TextUtils.isEmpty(this.f64482e)) {
                sb.append(this.f64482e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.b.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f64471a = context.getApplicationContext();
        a.C1740a b2 = aVar.e().b("bohrium");
        this.f64472b = b2;
        b2.d();
        this.f64476f = fVar;
        h(aVar);
    }

    public static a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("dik", "");
            String optString2 = jSONObject.optString("cck", "");
            long optLong = jSONObject.optLong("ctk", 0L);
            int optInt = jSONObject.optInt("vsk", 1);
            String optString3 = jSONObject.optString("ek", "");
            String optString4 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            if (!TextUtils.isEmpty(optString)) {
                a aVar = new a();
                aVar.f64478a = optString;
                aVar.f64480c = optString2;
                aVar.f64481d = optLong;
                aVar.f64483f = optInt;
                aVar.f64482e = optString3;
                aVar.f64479b = optString4;
                return aVar;
            }
        } catch (Exception e2) {
            d.b.j.i.c.c(e2);
        }
        return null;
    }

    public static a e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String m = m(str);
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                aVar.f64478a = str;
                aVar.f64480c = m;
                aVar.f64481d = currentTimeMillis;
                aVar.f64483f = 1;
                aVar.f64482e = str3;
                aVar.f64479b = str2;
                return aVar;
            } catch (Exception e2) {
                d.b.j.i.c.c(e2);
            }
        }
        return null;
    }

    public static String m(String str) {
        try {
            return new d.b.j.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.b.j.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public a a() {
        if (new File(this.f64472b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f64481d = System.currentTimeMillis();
            aVar.f64483f = 1;
            try {
                boolean z = false;
                aVar.f64479b = jVar.f64465b.substring(0, 1);
                aVar.f64478a = jVar.f64464a;
                aVar.f64480c = m(jVar.f64464a);
                String[] strArr = a.f64477g;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (strArr[i].equals(aVar.f64479b)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z && (str = jVar.f64465b) != null && str.length() >= 2) {
                    aVar.f64482e = jVar.f64465b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.b.j.b.a a2 = this.f64475e.a(str2);
        a.g gVar = new a.g();
        gVar.f64353a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f64354a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f64472b.c("libbh.so", z);
    }

    public final void h(d.b.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f64348a = this.f64471a;
        bVar2.f64349b = aVar;
        a.d dVar = new a.d();
        for (d.b.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f64475e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.b.j.b.a aVar2 : this.f64475e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f64478a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f64472b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
                    String n = c2.n();
                    if (!TextUtils.isEmpty(n) && n.equals(aVar.n())) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return this.f64472b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f64471a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f64470g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f64481d = System.currentTimeMillis();
        aVar.f64483f = 1;
        aVar.f64478a = b2;
        aVar.f64479b = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        aVar.f64480c = m(b2);
        aVar.f64482e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f64472b.g(".lock");
        if (!g2.exists()) {
            try {
                g2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(g2, "rw");
            for (int i = 0; i < 100; i++) {
                try {
                    try {
                        this.f64473c = randomAccessFile2.getChannel().lock();
                        this.f64474d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.b.j.i.c.c(e);
                    if (this.f64473c == null) {
                        d.b.j.i.c.b(randomAccessFile);
                    }
                    return false;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return false;
    }

    public synchronized void n() {
        if (this.f64473c != null) {
            try {
                this.f64473c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f64473c = null;
        }
        d.b.j.i.c.b(this.f64474d);
        this.f64474d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f64353a = true;
        List<d.b.j.b.a> b2 = this.f64475e.b();
        Collections.sort(b2, d.b.j.b.a.f64343e);
        List<e> h2 = this.f64476f.h(this.f64471a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f64449d && eVar.f64448c) {
                    for (d.b.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f64446a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f64354a) != null) {
                            return aVar;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return null;
    }
}
