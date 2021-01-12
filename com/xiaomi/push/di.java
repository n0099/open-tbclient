package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.al;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class di {

    /* renamed from: a  reason: collision with root package name */
    private static volatile di f13937a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f286a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f287a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes6.dex */
    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public void b() {
            di.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends al.b {

        /* renamed from: a  reason: collision with root package name */
        long f13939a = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // com.xiaomi.push.al.b
        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.al.b
        public void b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaomi.push.al.b
        public final boolean b() {
            return System.currentTimeMillis() - this.f13939a > 172800000;
        }
    }

    /* loaded from: classes6.dex */
    class c extends b {

        /* renamed from: a  reason: collision with root package name */
        int f13941a;

        /* renamed from: a  reason: collision with other field name */
        File f289a;

        /* renamed from: a  reason: collision with other field name */
        String f290a;

        /* renamed from: a  reason: collision with other field name */
        boolean f291a;

        /* renamed from: b  reason: collision with root package name */
        String f13942b;

        /* renamed from: b  reason: collision with other field name */
        boolean f292b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f290a = str;
            this.f13942b = str2;
            this.f289a = file;
            this.f292b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = di.this.f286a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException e) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
                i = 0;
            } else if (i > 10) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public boolean a() {
            return az.d(di.this.f286a) || (this.f292b && az.b(di.this.f286a));
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.be.m585a());
                    hashMap.put("token", this.f13942b);
                    hashMap.put("net", az.m166a(di.this.f286a));
                    az.a(this.f290a, hashMap, this.f289a, "file");
                }
                this.f291a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo255c() {
            if (!this.f291a) {
                this.f13941a++;
                if (this.f13941a < 3) {
                    di.this.f287a.add(this);
                }
            }
            if (this.f291a || this.f13941a >= 3) {
                this.f289a.delete();
            }
            di.this.a((1 << this.f13941a) * 1000);
        }
    }

    private di(Context context) {
        this.f286a = context;
        this.f287a.add(new a());
        b(0L);
    }

    public static di a(Context context) {
        if (f13937a == null) {
            synchronized (di.class) {
                if (f13937a == null) {
                    f13937a = new di(context);
                }
            }
        }
        f13937a.f286a = context;
        return f13937a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f287a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m150a()) {
            return;
        }
        try {
            File file = new File(this.f286a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        } catch (NullPointerException e) {
        }
    }

    private void b(long j) {
        if (this.f287a.isEmpty()) {
            return;
        }
        gv.a(new dk(this), j);
    }

    private void c() {
        while (!this.f287a.isEmpty()) {
            b peek = this.f287a.peek();
            if (peek != null) {
                if (!peek.b() && this.f287a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f287a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f287a.add(new dj(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
