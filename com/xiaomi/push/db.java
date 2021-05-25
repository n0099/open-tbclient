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
/* loaded from: classes7.dex */
public class db {

    /* renamed from: a  reason: collision with root package name */
    public static volatile db f37423a;

    /* renamed from: a  reason: collision with other field name */
    public Context f214a;

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<b> f215a;

    /* loaded from: classes7.dex */
    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            db.this.b();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends al.b {

        /* renamed from: a  reason: collision with root package name */
        public long f37425a = System.currentTimeMillis();

        public b() {
        }

        @Override // com.xiaomi.push.al.b
        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.al.b
        public void b() {
        }

        @Override // com.xiaomi.push.al.b
        public final boolean b() {
            return System.currentTimeMillis() - this.f37425a > 172800000;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public int f37427a;

        /* renamed from: a  reason: collision with other field name */
        public File f217a;

        /* renamed from: a  reason: collision with other field name */
        public String f218a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f219a;

        /* renamed from: b  reason: collision with root package name */
        public String f37428b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f220b;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.f218a = str;
            this.f37428b = str2;
            this.f217a = file;
            this.f220b = z;
        }

        private boolean c() {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = db.this.f214a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i2 > 10) {
                return false;
            } else {
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public boolean a() {
            return bg.e(db.this.f214a) || (this.f220b && bg.b(db.this.f214a));
        }

        @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.bi.m599a());
                    hashMap.put("token", this.f37428b);
                    hashMap.put("net", bg.m159a(db.this.f214a));
                    bg.a(this.f218a, hashMap, this.f217a, "file");
                }
                this.f219a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo229c() {
            if (!this.f219a) {
                int i2 = this.f37427a + 1;
                this.f37427a = i2;
                if (i2 < 3) {
                    db.this.f215a.add(this);
                }
            }
            if (this.f219a || this.f37427a >= 3) {
                this.f217a.delete();
            }
            db.this.a((1 << this.f37427a) * 1000);
        }
    }

    public db(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f215a = concurrentLinkedQueue;
        this.f214a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static db a(Context context) {
        if (f37423a == null) {
            synchronized (db.class) {
                if (f37423a == null) {
                    f37423a = new db(context);
                }
            }
        }
        f37423a.f214a = context;
        return f37423a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f215a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m125a()) {
            return;
        }
        try {
            File file = new File(this.f214a.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void b(long j) {
        if (this.f215a.isEmpty()) {
            return;
        }
        go.a(new dd(this), j);
    }

    private void c() {
        while (!this.f215a.isEmpty()) {
            b peek = this.f215a.peek();
            if (peek != null) {
                if (!peek.b() && this.f215a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f215a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i2, boolean z) {
        this.f215a.add(new dc(this, i2, date, date2, str, str2, z));
        b(0L);
    }
}
