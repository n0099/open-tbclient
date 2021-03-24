package d.b.j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
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
/* loaded from: classes2.dex */
public class l {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f63769g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f63770a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1727a f63771b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f63772c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f63773d;

    /* renamed from: e  reason: collision with root package name */
    public b f63774e;

    /* renamed from: f  reason: collision with root package name */
    public f f63775f;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f63776g = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f63777a;

        /* renamed from: b  reason: collision with root package name */
        public String f63778b;

        /* renamed from: c  reason: collision with root package name */
        public String f63779c;

        /* renamed from: d  reason: collision with root package name */
        public long f63780d;

        /* renamed from: e  reason: collision with root package name */
        public String f63781e;

        /* renamed from: f  reason: collision with root package name */
        public int f63782f = 1;

        public String e() {
            return this.f63777a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f63782f == aVar.f63782f && this.f63777a.equals(aVar.f63777a) && this.f63778b.equals(aVar.f63778b) && this.f63779c.equals(aVar.f63779c)) {
                String str = this.f63781e;
                String str2 = aVar.f63781e;
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
            return this.f63781e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f63777a, this.f63778b, this.f63779c, this.f63781e, Integer.valueOf(this.f63782f)});
        }

        public String j() {
            return this.f63778b;
        }

        public j l() {
            j jVar = new j();
            jVar.f63763a = this.f63777a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f63778b);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.f63778b)) {
                sb.append(this.f63779c);
            }
            if (!TextUtils.isEmpty(this.f63781e)) {
                sb.append(this.f63781e);
            }
            jVar.f63764b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f63777a);
                jSONObject.put("v270fk", this.f63778b);
                jSONObject.put("cck", this.f63779c);
                jSONObject.put("vsk", this.f63782f);
                jSONObject.put("ctk", this.f63780d);
                jSONObject.put("ek", this.f63781e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.b.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f63778b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f63777a);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f63779c);
            }
            if (!TextUtils.isEmpty(this.f63781e)) {
                sb.append(this.f63781e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.b.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f63770a = context.getApplicationContext();
        a.C1727a b2 = aVar.e().b("bohrium");
        this.f63771b = b2;
        b2.d();
        this.f63775f = fVar;
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
                aVar.f63777a = optString;
                aVar.f63779c = optString2;
                aVar.f63780d = optLong;
                aVar.f63782f = optInt;
                aVar.f63781e = optString3;
                aVar.f63778b = optString4;
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
                aVar.f63777a = str;
                aVar.f63779c = m;
                aVar.f63780d = currentTimeMillis;
                aVar.f63782f = 1;
                aVar.f63781e = str3;
                aVar.f63778b = str2;
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
        if (new File(this.f63771b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f63780d = System.currentTimeMillis();
            aVar.f63782f = 1;
            try {
                boolean z = false;
                aVar.f63778b = jVar.f63764b.substring(0, 1);
                aVar.f63777a = jVar.f63763a;
                aVar.f63779c = m(jVar.f63763a);
                String[] strArr = a.f63776g;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (strArr[i].equals(aVar.f63778b)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z && (str = jVar.f63764b) != null && str.length() >= 2) {
                    aVar.f63781e = jVar.f63764b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.b.j.b.a a2 = this.f63774e.a(str2);
        a.g gVar = new a.g();
        gVar.f63652a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f63653a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f63771b.c("libbh.so", z);
    }

    public final void h(d.b.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f63647a = this.f63770a;
        bVar2.f63648b = aVar;
        a.d dVar = new a.d();
        for (d.b.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f63774e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.b.j.b.a aVar2 : this.f63774e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f63777a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f63771b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f63771b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f63770a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f63769g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f63780d = System.currentTimeMillis();
        aVar.f63782f = 1;
        aVar.f63777a = b2;
        aVar.f63778b = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        aVar.f63779c = m(b2);
        aVar.f63781e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f63771b.g(".lock");
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
                        this.f63772c = randomAccessFile2.getChannel().lock();
                        this.f63773d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.b.j.i.c.c(e);
                    if (this.f63772c == null) {
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
        if (this.f63772c != null) {
            try {
                this.f63772c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f63772c = null;
        }
        d.b.j.i.c.b(this.f63773d);
        this.f63773d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f63652a = true;
        List<d.b.j.b.a> b2 = this.f63774e.b();
        Collections.sort(b2, d.b.j.b.a.f63642e);
        List<e> h2 = this.f63775f.h(this.f63770a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f63748d && eVar.f63747c) {
                    for (d.b.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f63745a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f63653a) != null) {
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
