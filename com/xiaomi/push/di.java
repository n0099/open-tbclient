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
public class di {
    private static volatile di a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f208a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f209a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    class c extends b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        File f211a;

        /* renamed from: a  reason: collision with other field name */
        String f212a;

        /* renamed from: a  reason: collision with other field name */
        boolean f213a;
        String b;

        /* renamed from: b  reason: collision with other field name */
        boolean f214b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.f212a = str;
            this.b = str2;
            this.f211a = file;
            this.f214b = z;
        }

        private boolean c() {
            int i;
            SharedPreferences sharedPreferences = di.this.f208a.getSharedPreferences("log.timestamp", 0);
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
            return az.d(di.this.f208a) || (this.f214b && az.b(di.this.f208a));
        }

        @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.be.m559a());
                    hashMap.put("token", this.b);
                    hashMap.put("net", az.m140a(di.this.f208a));
                    az.a(this.f212a, hashMap, this.f211a, "file");
                }
                this.f213a = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.push.al.b
        /* renamed from: c  reason: collision with other method in class */
        public void mo229c() {
            if (!this.f213a) {
                this.a++;
                if (this.a < 3) {
                    di.this.f209a.add(this);
                }
            }
            if (this.f213a || this.a >= 3) {
                this.f211a.delete();
            }
            di.this.a((1 << this.a) * 1000);
        }
    }

    private di(Context context) {
        this.f208a = context;
        this.f209a.add(new a());
        b(0L);
    }

    public static di a(Context context) {
        if (a == null) {
            synchronized (di.class) {
                if (a == null) {
                    a = new di(context);
                }
            }
        }
        a.f208a = context;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b peek = this.f209a.peek();
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
            File file = new File(this.f208a.getExternalFilesDir(null) + "/.logcache");
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
        if (this.f209a.isEmpty()) {
            return;
        }
        gv.a(new dk(this), j);
    }

    private void c() {
        while (!this.f209a.isEmpty()) {
            b peek = this.f209a.peek();
            if (peek != null) {
                if (!peek.b() && this.f209a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f209a.remove(peek);
            }
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f209a.add(new dj(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
