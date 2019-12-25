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
/* loaded from: classes5.dex */
public class dd {
    private static volatile dd a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f226a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f227a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes5.dex */
    class a extends b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            dd.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends al.b {
        long a = System.currentTimeMillis();

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
            return System.currentTimeMillis() - this.a > 172800000;
        }
    }

    /* loaded from: classes5.dex */
    class c extends b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        File f229a;

        /* renamed from: a  reason: collision with other field name */
        String f230a;

        /* renamed from: a  reason: collision with other field name */
        boolean f231a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f232b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f230a = str;
            this.b = str2;
            this.f229a = file;
            this.f232b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = dd.this.f226a.getSharedPreferences("log.timestamp", 0);
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

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public boolean a() {
            return as.d(dd.this.f226a) || (this.f232b && as.b(dd.this.f226a));
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.ba.m512a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", as.m118a(dd.this.f226a));
                    as.a(this.f230a, hashMap, this.f229a, "file");
                }
                this.f231a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo206c() {
            if (!this.f231a) {
                this.a++;
                if (this.a < 3) {
                    dd.this.f227a.add(this);
                }
            }
            if (this.f231a || this.a >= 3) {
                this.f229a.delete();
            }
            dd.this.a((1 << this.a) * 1000);
        }
    }

    private dd(Context context) {
        this.f226a = context;
        this.f227a.add(new a());
        b(0L);
    }

    public static dd a(Context context) {
        if (a == null) {
            synchronized (dd.class) {
                if (a == null) {
                    a = new dd(context);
                }
            }
        }
        a.f226a = context;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f227a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m109a()) {
            return;
        }
        try {
            File file = new File(this.f226a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f227a.isEmpty()) {
            return;
        }
        gp.a(new df(this), j);
    }

    private void c() {
        while (!this.f227a.isEmpty()) {
            b peek = this.f227a.peek();
            if (peek != null) {
                if (!peek.b() && this.f227a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f227a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f227a.add(new de(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
