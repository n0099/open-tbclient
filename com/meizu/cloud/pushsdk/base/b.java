package com.meizu.cloud.pushsdk.base;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes3.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f58637d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f58638e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58642i = false;
    public SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f58635b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f58636c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f58640g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f58639f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f58641h = String.valueOf(Process.myPid());

    /* loaded from: classes3.dex */
    public class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58643b;

        /* renamed from: c  reason: collision with root package name */
        public String f58644c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f58641h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.a = stringBuffer.toString();
            this.f58643b = str2;
            this.f58644c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f58635b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f58635b.size() == 0) {
            this.f58636c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f58637d * 1000);
        }
    }

    private void c() {
        if (this.f58635b.size() == this.f58638e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f58640g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f58642i;
        synchronized (this.f58635b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f58642i;
        synchronized (this.f58635b) {
            b();
            a(new a("E", str, str2 + StringUtils.LF + Log.getStackTraceString(th)));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(boolean z) {
        Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.2
            @Override // java.lang.Runnable
            public void run() {
                b bVar;
                ArrayList<a> arrayList = new ArrayList();
                synchronized (b.this.f58635b) {
                    b.this.f58636c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f58635b);
                    b.this.f58635b.clear();
                }
                try {
                    try {
                        b.this.f58639f.a(b.this.f58640g);
                        for (a aVar : arrayList) {
                            b.this.f58639f.a(aVar.a, aVar.f58643b, aVar.f58644c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f58639f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f58639f.a();
            }
        };
        if (z) {
            f.a().execute(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public boolean a() {
        return this.f58642i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f58642i;
        synchronized (this.f58635b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f58642i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f58642i;
        synchronized (this.f58635b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f58642i;
        synchronized (this.f58635b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
