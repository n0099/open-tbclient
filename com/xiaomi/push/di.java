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
/* loaded from: classes12.dex */
public class di {

    /* renamed from: a  reason: collision with root package name */
    private static volatile di f4853a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f205a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f206a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public class b extends al.b {

        /* renamed from: a  reason: collision with root package name */
        long f4855a = System.currentTimeMillis();

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
            return System.currentTimeMillis() - this.f4855a > 172800000;
        }
    }

    /* loaded from: classes12.dex */
    class c extends b {

        /* renamed from: a  reason: collision with root package name */
        int f4856a;

        /* renamed from: a  reason: collision with other field name */
        File f208a;

        /* renamed from: a  reason: collision with other field name */
        String f209a;

        /* renamed from: a  reason: collision with other field name */
        boolean f210a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f211b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f209a = str;
            this.b = str2;
            this.f208a = file;
            this.f211b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = di.this.f205a.getSharedPreferences("log.timestamp", 0);
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
            return az.d(di.this.f205a) || (this.f211b && az.b(di.this.f205a));
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.be.m559a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", az.m140a(di.this.f205a));
                    az.a(this.f209a, hashMap, this.f208a, "file");
                }
                this.f210a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo229c() {
            if (!this.f210a) {
                this.f4856a++;
                if (this.f4856a < 3) {
                    di.this.f206a.add(this);
                }
            }
            if (this.f210a || this.f4856a >= 3) {
                this.f208a.delete();
            }
            di.this.a((1 << this.f4856a) * 1000);
        }
    }

    private di(Context context) {
        this.f205a = context;
        this.f206a.add(new a());
        b(0L);
    }

    public static di a(Context context) {
        if (f4853a == null) {
            synchronized (di.class) {
                if (f4853a == null) {
                    f4853a = new di(context);
                }
            }
        }
        f4853a.f205a = context;
        return f4853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f206a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m124a()) {
            return;
        }
        try {
            File file = new File(this.f205a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f206a.isEmpty()) {
            return;
        }
        gv.a(new dk(this), j);
    }

    private void c() {
        while (!this.f206a.isEmpty()) {
            b peek = this.f206a.peek();
            if (peek != null) {
                if (!peek.b() && this.f206a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f206a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f206a.add(new dj(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
