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
    public static boolean f43915g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f43916a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0604a f43917b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f43918c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f43919d;

    /* renamed from: e  reason: collision with root package name */
    public b f43920e;

    /* renamed from: f  reason: collision with root package name */
    public f f43921f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f43922g = {"V", "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f43923a;

        /* renamed from: b  reason: collision with root package name */
        public String f43924b;

        /* renamed from: c  reason: collision with root package name */
        public String f43925c;

        /* renamed from: d  reason: collision with root package name */
        public long f43926d;

        /* renamed from: e  reason: collision with root package name */
        public String f43927e;

        /* renamed from: f  reason: collision with root package name */
        public int f43928f = 1;

        public String e() {
            return this.f43923a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f43928f == aVar.f43928f && this.f43923a.equals(aVar.f43923a) && this.f43924b.equals(aVar.f43924b) && this.f43925c.equals(aVar.f43925c)) {
                String str = this.f43927e;
                String str2 = aVar.f43927e;
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
            return this.f43927e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f43923a, this.f43924b, this.f43925c, this.f43927e, Integer.valueOf(this.f43928f)});
        }

        public String j() {
            return this.f43924b;
        }

        public j l() {
            j jVar = new j();
            jVar.f43909a = this.f43923a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f43924b);
            if ("V".equals(this.f43924b)) {
                sb.append(this.f43925c);
            }
            if (!TextUtils.isEmpty(this.f43927e)) {
                sb.append(this.f43927e);
            }
            jVar.f43910b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f43923a);
                jSONObject.put("v270fk", this.f43924b);
                jSONObject.put("cck", this.f43925c);
                jSONObject.put("vsk", this.f43928f);
                jSONObject.put("ctk", this.f43926d);
                jSONObject.put("ek", this.f43927e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.a.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f43924b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f43923a);
            sb.append("|");
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f43925c);
            }
            if (!TextUtils.isEmpty(this.f43927e)) {
                sb.append(this.f43927e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.a.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f43916a = context.getApplicationContext();
        a.C0604a b2 = aVar.e().b("bohrium");
        this.f43917b = b2;
        b2.d();
        this.f43921f = fVar;
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
                aVar.f43923a = optString;
                aVar.f43925c = optString2;
                aVar.f43926d = optLong;
                aVar.f43928f = optInt;
                aVar.f43927e = optString3;
                aVar.f43924b = optString4;
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
                aVar.f43923a = str;
                aVar.f43925c = m;
                aVar.f43926d = currentTimeMillis;
                aVar.f43928f = 1;
                aVar.f43927e = str3;
                aVar.f43924b = str2;
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
        if (new File(this.f43917b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f43926d = System.currentTimeMillis();
            aVar.f43928f = 1;
            try {
                boolean z = false;
                aVar.f43924b = jVar.f43910b.substring(0, 1);
                aVar.f43923a = jVar.f43909a;
                aVar.f43925c = m(jVar.f43909a);
                String[] strArr = a.f43922g;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f43924b)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = jVar.f43910b) != null && str.length() >= 2) {
                    aVar.f43927e = jVar.f43910b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.a.j.b.a a2 = this.f43920e.a(str2);
        a.g gVar = new a.g();
        gVar.f43796a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f43797a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f43917b.c("libbh.so", z);
    }

    public final void h(d.a.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f43791a = this.f43916a;
        bVar2.f43792b = aVar;
        a.d dVar = new a.d();
        for (d.a.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f43920e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.a.j.b.a aVar2 : this.f43920e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f43923a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f43917b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f43917b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f43916a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f43915g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f43926d = System.currentTimeMillis();
        aVar.f43928f = 1;
        aVar.f43923a = b2;
        aVar.f43924b = "V";
        aVar.f43925c = m(b2);
        aVar.f43927e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f43917b.g(".lock");
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
                        this.f43918c = randomAccessFile2.getChannel().lock();
                        this.f43919d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.a.j.i.c.c(e);
                    if (this.f43918c == null) {
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
        if (this.f43918c != null) {
            try {
                this.f43918c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f43918c = null;
        }
        d.a.j.i.c.b(this.f43919d);
        this.f43919d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f43796a = true;
        List<d.a.j.b.a> b2 = this.f43920e.b();
        Collections.sort(b2, d.a.j.b.a.f43786e);
        List<e> h2 = this.f43921f.h(this.f43916a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f43894d && eVar.f43893c) {
                    for (d.a.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f43891a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f43797a) != null) {
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
