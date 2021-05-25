package d.a.j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.util.FieldBuilder;
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
    public static boolean f40234g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f40235a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0548a f40236b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f40237c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f40238d;

    /* renamed from: e  reason: collision with root package name */
    public b f40239e;

    /* renamed from: f  reason: collision with root package name */
    public f f40240f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f40241g = {"V", "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f40242a;

        /* renamed from: b  reason: collision with root package name */
        public String f40243b;

        /* renamed from: c  reason: collision with root package name */
        public String f40244c;

        /* renamed from: d  reason: collision with root package name */
        public long f40245d;

        /* renamed from: e  reason: collision with root package name */
        public String f40246e;

        /* renamed from: f  reason: collision with root package name */
        public int f40247f = 1;

        public String e() {
            return this.f40242a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f40247f == aVar.f40247f && this.f40242a.equals(aVar.f40242a) && this.f40243b.equals(aVar.f40243b) && this.f40244c.equals(aVar.f40244c)) {
                String str = this.f40246e;
                String str2 = aVar.f40246e;
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
            return this.f40246e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f40242a, this.f40243b, this.f40244c, this.f40246e, Integer.valueOf(this.f40247f)});
        }

        public String j() {
            return this.f40243b;
        }

        public j l() {
            j jVar = new j();
            jVar.f40228a = this.f40242a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f40243b);
            if ("V".equals(this.f40243b)) {
                sb.append(this.f40244c);
            }
            if (!TextUtils.isEmpty(this.f40246e)) {
                sb.append(this.f40246e);
            }
            jVar.f40229b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f40242a);
                jSONObject.put("v270fk", this.f40243b);
                jSONObject.put("cck", this.f40244c);
                jSONObject.put("vsk", this.f40247f);
                jSONObject.put("ctk", this.f40245d);
                jSONObject.put("ek", this.f40246e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.a.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f40243b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f40242a);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f40244c);
            }
            if (!TextUtils.isEmpty(this.f40246e)) {
                sb.append(this.f40246e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.a.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f40235a = context.getApplicationContext();
        a.C0548a b2 = aVar.e().b("bohrium");
        this.f40236b = b2;
        b2.d();
        this.f40240f = fVar;
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
                aVar.f40242a = optString;
                aVar.f40244c = optString2;
                aVar.f40245d = optLong;
                aVar.f40247f = optInt;
                aVar.f40246e = optString3;
                aVar.f40243b = optString4;
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
                aVar.f40242a = str;
                aVar.f40244c = m;
                aVar.f40245d = currentTimeMillis;
                aVar.f40247f = 1;
                aVar.f40246e = str3;
                aVar.f40243b = str2;
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
        if (new File(this.f40236b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f40245d = System.currentTimeMillis();
            aVar.f40247f = 1;
            try {
                boolean z = false;
                aVar.f40243b = jVar.f40229b.substring(0, 1);
                aVar.f40242a = jVar.f40228a;
                aVar.f40244c = m(jVar.f40228a);
                String[] strArr = a.f40241g;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f40243b)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = jVar.f40229b) != null && str.length() >= 2) {
                    aVar.f40246e = jVar.f40229b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.a.j.b.a a2 = this.f40239e.a(str2);
        a.g gVar = new a.g();
        gVar.f40115a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f40116a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f40236b.c("libbh.so", z);
    }

    public final void h(d.a.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f40110a = this.f40235a;
        bVar2.f40111b = aVar;
        a.d dVar = new a.d();
        for (d.a.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f40239e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.a.j.b.a aVar2 : this.f40239e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f40242a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f40236b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f40236b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f40235a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f40234g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f40245d = System.currentTimeMillis();
        aVar.f40247f = 1;
        aVar.f40242a = b2;
        aVar.f40243b = "V";
        aVar.f40244c = m(b2);
        aVar.f40246e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f40236b.g(".lock");
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
                        this.f40237c = randomAccessFile2.getChannel().lock();
                        this.f40238d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.a.j.i.c.c(e);
                    if (this.f40237c == null) {
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
        if (this.f40237c != null) {
            try {
                this.f40237c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f40237c = null;
        }
        d.a.j.i.c.b(this.f40238d);
        this.f40238d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f40115a = true;
        List<d.a.j.b.a> b2 = this.f40239e.b();
        Collections.sort(b2, d.a.j.b.a.f40105e);
        List<e> h2 = this.f40240f.h(this.f40235a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f40213d && eVar.f40212c) {
                    for (d.a.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f40210a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f40116a) != null) {
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
