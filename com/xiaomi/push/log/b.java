package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.at;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static volatile b c = null;
    private final ConcurrentLinkedQueue<C0291b> a = new ConcurrentLinkedQueue<>();
    private Context b;

    /* loaded from: classes3.dex */
    class a extends C0291b {
        a() {
            super();
        }

        @Override // com.xiaomi.push.log.b.C0291b, com.xiaomi.channel.commonutils.misc.h.b
        public void b() {
            b.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.log.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0291b extends h.b {
        long i = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0291b() {
        }

        @Override // com.xiaomi.channel.commonutils.misc.h.b
        public void b() {
        }

        public boolean d() {
            return true;
        }

        final boolean e() {
            return System.currentTimeMillis() - this.i > 172800000;
        }
    }

    /* loaded from: classes3.dex */
    class c extends C0291b {
        String a;
        String b;
        File c;
        int d;
        boolean e;
        boolean f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2, File file, boolean z) {
            super();
            this.a = str;
            this.b = str2;
            this.c = file;
            this.f = z;
        }

        private boolean f() {
            int i;
            SharedPreferences sharedPreferences = b.this.b.getSharedPreferences("log.timestamp", 0);
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

        @Override // com.xiaomi.push.log.b.C0291b, com.xiaomi.channel.commonutils.misc.h.b
        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", at.e());
                    hashMap.put(Constants.EXTRA_KEY_TOKEN, this.b);
                    hashMap.put("net", com.xiaomi.channel.commonutils.network.d.k(b.this.b));
                    com.xiaomi.channel.commonutils.network.d.a(this.a, hashMap, this.c, "file");
                }
                this.e = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.channel.commonutils.misc.h.b
        public void c() {
            if (!this.e) {
                this.d++;
                if (this.d < 3) {
                    b.this.a.add(this);
                }
            }
            if (this.e || this.d >= 3) {
                this.c.delete();
            }
            b.this.a((1 << this.d) * 1000);
        }

        @Override // com.xiaomi.push.log.b.C0291b
        public boolean d() {
            return com.xiaomi.channel.commonutils.network.d.f(b.this.b) || (this.f && com.xiaomi.channel.commonutils.network.d.d(b.this.b));
        }
    }

    private b(Context context) {
        this.b = context;
        this.a.add(new a());
        b(0L);
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        c.b = context;
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        C0291b peek = this.a.peek();
        if (peek == null || !peek.d()) {
            return;
        }
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (com.xiaomi.channel.commonutils.file.c.b() || com.xiaomi.channel.commonutils.file.c.a()) {
            return;
        }
        try {
            File file = new File(this.b.getExternalFilesDir(null) + "/.logcache");
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
        if (this.a.isEmpty()) {
            return;
        }
        com.xiaomi.smack.util.e.a(new d(this), j);
    }

    private void c() {
        while (!this.a.isEmpty()) {
            if (!this.a.peek().e() && this.a.size() <= 6) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
            this.a.remove();
        }
    }

    public void a() {
        c();
        a(0L);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.a.add(new com.xiaomi.push.log.c(this, i, date, date2, str, str2, z));
        b(0L);
    }
}
