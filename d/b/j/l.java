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
    public static boolean f52665g = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f52666a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1154a f52667b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f52668c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f52669d;

    /* renamed from: e  reason: collision with root package name */
    public b f52670e;

    /* renamed from: f  reason: collision with root package name */
    public f f52671f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f52672g = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: a  reason: collision with root package name */
        public String f52673a;

        /* renamed from: b  reason: collision with root package name */
        public String f52674b;

        /* renamed from: c  reason: collision with root package name */
        public String f52675c;

        /* renamed from: d  reason: collision with root package name */
        public long f52676d;

        /* renamed from: e  reason: collision with root package name */
        public String f52677e;

        /* renamed from: f  reason: collision with root package name */
        public int f52678f = 1;

        public String e() {
            return this.f52673a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f52678f == aVar.f52678f && this.f52673a.equals(aVar.f52673a) && this.f52674b.equals(aVar.f52674b) && this.f52675c.equals(aVar.f52675c)) {
                String str = this.f52677e;
                String str2 = aVar.f52677e;
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
            return this.f52677e;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f52673a, this.f52674b, this.f52675c, this.f52677e, Integer.valueOf(this.f52678f)});
        }

        public String j() {
            return this.f52674b;
        }

        public j l() {
            j jVar = new j();
            jVar.f52659a = this.f52673a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f52674b);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.f52674b)) {
                sb.append(this.f52675c);
            }
            if (!TextUtils.isEmpty(this.f52677e)) {
                sb.append(this.f52677e);
            }
            jVar.f52660b = sb.toString().trim();
            return jVar;
        }

        public String m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f52673a);
                jSONObject.put("v270fk", this.f52674b);
                jSONObject.put("cck", this.f52675c);
                jSONObject.put("vsk", this.f52678f);
                jSONObject.put("ctk", this.f52676d);
                jSONObject.put("ek", this.f52677e);
                return jSONObject.toString();
            } catch (JSONException e2) {
                d.b.j.i.c.c(e2);
                return null;
            }
        }

        public String n() {
            String str = this.f52674b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f52673a);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f52675c);
            }
            if (!TextUtils.isEmpty(this.f52677e)) {
                sb.append(this.f52677e);
            }
            return sb.toString().trim();
        }
    }

    public l(Context context, d.b.j.g.a aVar, f fVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f52666a = context.getApplicationContext();
        a.C1154a b2 = aVar.e().b("bohrium");
        this.f52667b = b2;
        b2.d();
        this.f52671f = fVar;
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
                aVar.f52673a = optString;
                aVar.f52675c = optString2;
                aVar.f52676d = optLong;
                aVar.f52678f = optInt;
                aVar.f52677e = optString3;
                aVar.f52674b = optString4;
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
                aVar.f52673a = str;
                aVar.f52675c = m;
                aVar.f52676d = currentTimeMillis;
                aVar.f52678f = 1;
                aVar.f52677e = str3;
                aVar.f52674b = str2;
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
        if (new File(this.f52667b.f(), "libbh.so").exists()) {
            return c(g(true));
        }
        return null;
    }

    public a b(j jVar) {
        String str;
        if (jVar != null) {
            a aVar = new a();
            aVar.f52676d = System.currentTimeMillis();
            aVar.f52678f = 1;
            try {
                boolean z = false;
                aVar.f52674b = jVar.f52660b.substring(0, 1);
                aVar.f52673a = jVar.f52659a;
                aVar.f52675c = m(jVar.f52659a);
                String[] strArr = a.f52672g;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (strArr[i].equals(aVar.f52674b)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z && (str = jVar.f52660b) != null && str.length() >= 2) {
                    aVar.f52677e = jVar.f52660b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a d(String str, String str2) {
        d.b.j.b.a a2 = this.f52670e.a(str2);
        a.g gVar = new a.g();
        gVar.f52548a = true;
        a.h b2 = a2.b(str, gVar);
        if (b2 == null || !b2.c()) {
            return null;
        }
        return b2.f52549a;
    }

    public final String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public final String g(boolean z) {
        return this.f52667b.c("libbh.so", z);
    }

    public final void h(d.b.j.g.a aVar) {
        b bVar = new b(new c());
        a.b bVar2 = new a.b();
        bVar2.f52543a = this.f52666a;
        bVar2.f52544b = aVar;
        a.d dVar = new a.d();
        for (d.b.j.b.a aVar2 : bVar.b()) {
            aVar2.d(bVar2);
            aVar2.e(dVar);
        }
        this.f52670e = bVar;
    }

    public void i(a aVar) {
        a.e eVar = new a.e();
        for (d.b.j.b.a aVar2 : this.f52670e.b()) {
            aVar2.a(eVar, aVar);
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        a c2;
        if (aVar == null || TextUtils.isEmpty(aVar.f52673a)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f52667b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
        return this.f52667b.e("libbh.so", aVar.m(), z);
    }

    public a k(String str) {
        String str2;
        String f2 = f(this.f52666a);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f52665g) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + f2 + uuid;
        } else {
            str2 = "com.baidu" + f2;
        }
        String b2 = f.c.b(str2.getBytes(), true);
        a aVar = new a();
        aVar.f52676d = System.currentTimeMillis();
        aVar.f52678f = 1;
        aVar.f52673a = b2;
        aVar.f52674b = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        aVar.f52675c = m(b2);
        aVar.f52677e = null;
        return aVar;
    }

    public synchronized boolean l() {
        File g2 = this.f52667b.g(".lock");
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
                        this.f52668c = randomAccessFile2.getChannel().lock();
                        this.f52669d = randomAccessFile2;
                        return true;
                    } catch (OverlappingFileLockException unused) {
                        Thread.sleep(100L);
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    d.b.j.i.c.c(e);
                    if (this.f52668c == null) {
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
        if (this.f52668c != null) {
            try {
                this.f52668c.release();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f52668c = null;
        }
        d.b.j.i.c.b(this.f52669d);
        this.f52669d = null;
    }

    public a o() {
        a aVar;
        a.g gVar = new a.g();
        gVar.f52548a = true;
        List<d.b.j.b.a> b2 = this.f52670e.b();
        Collections.sort(b2, d.b.j.b.a.f52538e);
        List<e> h2 = this.f52671f.h(this.f52666a);
        if (h2 != null) {
            for (e eVar : h2) {
                if (!eVar.f52644d && eVar.f52643c) {
                    for (d.b.j.b.a aVar2 : b2) {
                        a.h b3 = aVar2.b(eVar.f52641a.packageName, gVar);
                        if (b3 != null && b3.c() && (aVar = b3.f52549a) != null) {
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
