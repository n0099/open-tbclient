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
/* loaded from: classes8.dex */
public class dd {
    private static volatile dd a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f222a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f223a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    class c extends b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        File f225a;

        /* renamed from: a  reason: collision with other field name */
        String f226a;

        /* renamed from: a  reason: collision with other field name */
        boolean f227a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f228b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f226a = str;
            this.b = str2;
            this.f225a = file;
            this.f228b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = dd.this.f222a.getSharedPreferences("log.timestamp", 0);
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
            return as.d(dd.this.f222a) || (this.f228b && as.b(dd.this.f222a));
        }

        @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.ba.m529a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", as.m135a(dd.this.f222a));
                    as.a(this.f226a, hashMap, this.f225a, "file");
                }
                this.f227a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo223c() {
            if (!this.f227a) {
                this.a++;
                if (this.a < 3) {
                    dd.this.f223a.add(this);
                }
            }
            if (this.f227a || this.a >= 3) {
                this.f225a.delete();
            }
            dd.this.a((1 << this.a) * 1000);
        }
    }

    private dd(Context context) {
        this.f222a = context;
        this.f223a.add(new a());
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
        a.f222a = context;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f223a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (aa.b() || aa.m126a()) {
            return;
        }
        try {
            File file = new File(this.f222a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f223a.isEmpty()) {
            return;
        }
        gp.a(new df(this), j);
    }

    private void c() {
        while (!this.f223a.isEmpty()) {
            b peek = this.f223a.peek();
            if (peek != null) {
                if (!peek.b() && this.f223a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f223a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f223a.add(new de(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
