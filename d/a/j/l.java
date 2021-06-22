package d.a.j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.a.j.b.a;
import d.a.j.b.b;
import d.a.j.f;
import d.a.j.g.a;
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
    public static boolean f44018g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f44019a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0607a f44020b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f44021c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f44022d;

    /* renamed from: e  reason: collision with root package name */
    public b f44023e;

    /* renamed from: f  reason: collision with root package name */
    public f f44024f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f44025g = {"V", "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f44026a;

        /* renamed from: b  reason: collision with root package name */
        public String f44027b;

        /* renamed from: c  reason: collision with root package name */
        public String f44028c;

        /* renamed from: d  reason: collision with root package name */
        public long f44029d;

        /* renamed from: e  reason: collision with root package name */
        public String f44030e;

        /* renamed from: f  reason: collision with root package name */
        public int f44031f = 1;

        public String e() {
            return this.f44026a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f44031f == aVar.f44031f && this.f44026a.equals(aVar.f44026a) && this.f44027b.equals(aVar.f44027b) && this.f44028c.equals(aVar.f44028c)) {
                String str = this.f44030e;
                String str2 = aVar.f44030e;
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
            return this.f44030e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f44026a, this.f44027b, this.f44028c, this.f44030e, Integer.valueOf(this.f44031f)});
        }

        public String j() {
            return this.f44027b;
        }

        public j l() {
            j jVar = new j();
            jVar.f44012a = this.f44026a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f44027b);
            if ("V".equals(this.f44027b)) {
                sb.append(this.f44028c);
            }
            if (!TextUtils.isEmpty(this.f44030e)) {
                sb.append(this.f44030e);
            }
            jVar.f44013b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f44026a);
                jSONObject.put("v270fk", this.f44027b);
                jSONObject.put("cck", this.f44028c);
                jSONObject.put("vsk", this.f44031f);
                jSONObject.put("ctk", this.f44029d);
                jSONObject.put("ek", this.f44030e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.a.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f44027b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f44026a);
            sb.append("|");
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f44028c);
            }
            if (!TextUtils.isEmpty(this.f44030e)) {
                sb.append(this.f44030e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.a.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f44019a = context.getApplicationContext();
        a.C0607a b2 = aVar.e().b("bohrium");
        this.f44020b = b2;
        b2.d();
        this.f44024f = fVar;
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
            String optString4 = jSONObject.optString("v270fk", "V");
            if (!TextUtils.isEmpty(optString)) {
                a aVar = new a();
                aVar.f44026a = optString;
                aVar.f44028c = optString2;
                aVar.f44029d = optLong;
                aVar.f44031f = optInt;
                aVar.f44030e = optString3;
                aVar.f44027b = optString4;
                return aVar;
            }
        } catch (Exception e2) {
            d.a.j.i.c.c(e2);
        }
        return null;
    }

    public static a e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String m = m(str);
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                aVar.f44026a = str;
                aVar.f44028c = m;
                aVar.f44029d = currentTimeMillis;
                aVar.f44031f = 1;
                aVar.f44030e = str3;
                aVar.f44027b = str2;
                return aVar;
            } catch (Exception e2) {
                d.a.j.i.c.c(e2);
            }
        }
        return null;
    }

    public static String m(String str) {
        try {
            return new d.a.j.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.a.j.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public a a() {
        if (new File(this.f44020b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f44029d = System.currentTimeMillis();
            aVar.f44031f = 1;
            try {
                boolean z = false;
                aVar.f44027b = jVar.f44013b.substring(0, 1);
                aVar.f44026a = jVar.f44012a;
                aVar.f44028c = m(jVar.f44012a);
                String[] strArr = a.f44025g;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f44027b)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = jVar.f44013b) != null && str.length() >= 2) {
                    aVar.f44030e = jVar.f44013b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.a.j.b.a a2 = this.f44023e.a(str2);
        a.g gVar = new a.g();
        gVar.f43899a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f43900a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f44020b.c("libbh.so", z);
    }

    public final void h(d.a.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f43894a = this.f44019a;
        bVar2.f43895b = aVar;
        a.d dVar = new a.d();
        for (d.a.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f44023e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.a.j.b.a aVar2 : this.f44023e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f44026a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f44020b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f44020b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f44019a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f44018g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f44029d = System.currentTimeMillis();
        aVar.f44031f = 1;
        aVar.f44026a = b2;
        aVar.f44027b = "V";
        aVar.f44028c = m(b2);
        aVar.f44030e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f44020b.g(".lock");
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
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    try {
                        this.f44021c = randomAccessFile2.getChannel().lock();
                        this.f44022d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.a.j.i.c.c(e);
                    if (this.f44021c == null) {
                        d.a.j.i.c.b(randomAccessFile);
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
        if (this.f44021c != null) {
            try {
                this.f44021c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f44021c = null;
        }
        d.a.j.i.c.b(this.f44022d);
        this.f44022d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f43899a = true;
        List<d.a.j.b.a> b2 = this.f44023e.b();
        Collections.sort(b2, d.a.j.b.a.f43889e);
        List<e> h2 = this.f44024f.h(this.f44019a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f43997d && eVar.f43996c) {
                    for (d.a.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f43994a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f43900a) != null) {
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
