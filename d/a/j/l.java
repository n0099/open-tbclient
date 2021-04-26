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
    public static boolean f50349g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f50350a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1093a f50351b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f50352c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f50353d;

    /* renamed from: e  reason: collision with root package name */
    public b f50354e;

    /* renamed from: f  reason: collision with root package name */
    public f f50355f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f50356g = {"V", "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f50357a;

        /* renamed from: b  reason: collision with root package name */
        public String f50358b;

        /* renamed from: c  reason: collision with root package name */
        public String f50359c;

        /* renamed from: d  reason: collision with root package name */
        public long f50360d;

        /* renamed from: e  reason: collision with root package name */
        public String f50361e;

        /* renamed from: f  reason: collision with root package name */
        public int f50362f = 1;

        public String e() {
            return this.f50357a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f50362f == aVar.f50362f && this.f50357a.equals(aVar.f50357a) && this.f50358b.equals(aVar.f50358b) && this.f50359c.equals(aVar.f50359c)) {
                String str = this.f50361e;
                String str2 = aVar.f50361e;
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
            return this.f50361e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f50357a, this.f50358b, this.f50359c, this.f50361e, Integer.valueOf(this.f50362f)});
        }

        public String j() {
            return this.f50358b;
        }

        public j l() {
            j jVar = new j();
            jVar.f50343a = this.f50357a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f50358b);
            if ("V".equals(this.f50358b)) {
                sb.append(this.f50359c);
            }
            if (!TextUtils.isEmpty(this.f50361e)) {
                sb.append(this.f50361e);
            }
            jVar.f50344b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f50357a);
                jSONObject.put("v270fk", this.f50358b);
                jSONObject.put("cck", this.f50359c);
                jSONObject.put("vsk", this.f50362f);
                jSONObject.put("ctk", this.f50360d);
                jSONObject.put("ek", this.f50361e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.a.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f50358b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f50357a);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f50359c);
            }
            if (!TextUtils.isEmpty(this.f50361e)) {
                sb.append(this.f50361e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.a.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f50350a = context.getApplicationContext();
        a.C1093a b2 = aVar.e().b("bohrium");
        this.f50351b = b2;
        b2.d();
        this.f50355f = fVar;
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
                aVar.f50357a = optString;
                aVar.f50359c = optString2;
                aVar.f50360d = optLong;
                aVar.f50362f = optInt;
                aVar.f50361e = optString3;
                aVar.f50358b = optString4;
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
                aVar.f50357a = str;
                aVar.f50359c = m;
                aVar.f50360d = currentTimeMillis;
                aVar.f50362f = 1;
                aVar.f50361e = str3;
                aVar.f50358b = str2;
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
        if (new File(this.f50351b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f50360d = System.currentTimeMillis();
            aVar.f50362f = 1;
            try {
                boolean z = false;
                aVar.f50358b = jVar.f50344b.substring(0, 1);
                aVar.f50357a = jVar.f50343a;
                aVar.f50359c = m(jVar.f50343a);
                String[] strArr = a.f50356g;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f50358b)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = jVar.f50344b) != null && str.length() >= 2) {
                    aVar.f50361e = jVar.f50344b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.a.j.b.a a2 = this.f50354e.a(str2);
        a.g gVar = new a.g();
        gVar.f50230a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f50231a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f50351b.c("libbh.so", z);
    }

    public final void h(d.a.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f50225a = this.f50350a;
        bVar2.f50226b = aVar;
        a.d dVar = new a.d();
        for (d.a.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f50354e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.a.j.b.a aVar2 : this.f50354e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f50357a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f50351b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f50351b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f50350a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f50349g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f50360d = System.currentTimeMillis();
        aVar.f50362f = 1;
        aVar.f50357a = b2;
        aVar.f50358b = "V";
        aVar.f50359c = m(b2);
        aVar.f50361e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f50351b.g(".lock");
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
                        this.f50352c = randomAccessFile2.getChannel().lock();
                        this.f50353d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.a.j.i.c.c(e);
                    if (this.f50352c == null) {
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
        if (this.f50352c != null) {
            try {
                this.f50352c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f50352c = null;
        }
        d.a.j.i.c.b(this.f50353d);
        this.f50353d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f50230a = true;
        List<d.a.j.b.a> b2 = this.f50354e.b();
        Collections.sort(b2, d.a.j.b.a.f50220e);
        List<e> h2 = this.f50355f.h(this.f50350a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f50328d && eVar.f50327c) {
                    for (d.a.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f50325a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f50231a) != null) {
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
