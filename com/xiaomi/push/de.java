package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.am;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class de {
    public static volatile de a;

    /* renamed from: a  reason: collision with other field name */
    public Context f209a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f210a;

    /* loaded from: classes10.dex */
    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.de.b, com.xiaomi.push.am.b
        public void b() {
            de.this.b();
        }
    }

    /* loaded from: classes10.dex */
    public class b extends am.b {
        public long a = System.currentTimeMillis();

        public b() {
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.am.b.a()V */
        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.am.b
        public void b() {
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.am.b.b()V */
        /* renamed from: b  reason: collision with other method in class */
        public final boolean m359b() {
            return System.currentTimeMillis() - this.a > 172800000;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public File f212a;

        /* renamed from: a  reason: collision with other field name */
        public String f213a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f214a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f215b;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.f213a = str;
            this.b = str2;
            this.f212a = file;
            this.f215b = z;
        }

        private boolean c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = de.this.f209a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i > 10) {
                return false;
            } else {
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.am.b.a()V */
        @Override // com.xiaomi.push.de.b
        public boolean a() {
            return bi.e(de.this.f209a) || (this.f215b && bi.b(de.this.f209a));
        }

        @Override // com.xiaomi.push.de.b, com.xiaomi.push.am.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.bv.m805a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", bi.m289a(de.this.f209a));
                    bi.a(this.f213a, hashMap, this.f212a, "file");
                }
                this.f214a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.am.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo360c() {
            if (!this.f214a) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    de.this.f210a.add(this);
                }
            }
            if (this.f214a || this.a >= 3) {
                this.f212a.delete();
            }
            de.this.a((1 << this.a) * 1000);
        }
    }

    public de(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f210a = concurrentLinkedQueue;
        this.f209a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static de a(Context context) {
        if (a == null) {
            synchronized (de.class) {
                if (a == null) {
                    a = new de(context);
                }
            }
        }
        a.f209a = context;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f210a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m255a()) {
            return;
        }
        try {
            File file = new File(this.f209a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j) {
        if (this.f210a.isEmpty()) {
            return;
        }
        gy.a(new dg(this), j);
    }

    private void c() {
        while (!this.f210a.isEmpty()) {
            b peek = this.f210a.peek();
            if (peek != null) {
                if (!peek.m359b() && this.f210a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f210a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f210a.add(new df(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
