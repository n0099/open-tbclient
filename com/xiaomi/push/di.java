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
    private static volatile di f14237a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f287a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f288a = new ConcurrentLinkedQueue<>();

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
        long f14239a = System.currentTimeMillis();

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
            return System.currentTimeMillis() - this.f14239a > 172800000;
        }
    }

    /* loaded from: classes6.dex */
    class c extends b {

        /* renamed from: a  reason: collision with root package name */
        int f14241a;

        /* renamed from: a  reason: collision with other field name */
        File f290a;

        /* renamed from: a  reason: collision with other field name */
        String f291a;

        /* renamed from: a  reason: collision with other field name */
        boolean f292a;

        /* renamed from: b  reason: collision with root package name */
        String f14242b;

        /* renamed from: b  reason: collision with other field name */
        boolean f293b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f291a = str;
            this.f14242b = str2;
            this.f290a = file;
            this.f293b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = di.this.f287a.getSharedPreferences("log.timestamp", 0);
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
            return az.d(di.this.f287a) || (this.f293b && az.b(di.this.f287a));
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.be.m589a());
                    hashMap.put("token", this.f14242b);
                    hashMap.put("net", az.m170a(di.this.f287a));
                    az.a(this.f291a, hashMap, this.f290a, "file");
                }
                this.f292a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo259c() {
            if (!this.f292a) {
                this.f14241a++;
                if (this.f14241a < 3) {
                    di.this.f288a.add(this);
                }
            }
            if (this.f292a || this.f14241a >= 3) {
                this.f290a.delete();
            }
            di.this.a((1 << this.f14241a) * 1000);
        }
    }

    private di(Context context) {
        this.f287a = context;
        this.f288a.add(new a());
        b(0L);
    }

    public static di a(Context context) {
        if (f14237a == null) {
            synchronized (di.class) {
                if (f14237a == null) {
                    f14237a = new di(context);
                }
            }
        }
        f14237a.f287a = context;
        return f14237a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f288a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m154a()) {
            return;
        }
        try {
            File file = new File(this.f287a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f288a.isEmpty()) {
            return;
        }
        gv.a(new dk(this), j);
    }

    private void c() {
        while (!this.f288a.isEmpty()) {
            b peek = this.f288a.peek();
            if (peek != null) {
                if (!peek.b() && this.f288a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f288a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f288a.add(new dj(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
