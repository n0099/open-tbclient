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
/* loaded from: classes10.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f74534d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f74535e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74539i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f74531a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f74532b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f74533c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f74537g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f74536f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f74538h = String.valueOf(Process.myPid());

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74542a;

        /* renamed from: b  reason: collision with root package name */
        public String f74543b;

        /* renamed from: c  reason: collision with root package name */
        public String f74544c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f74531a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f74538h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f74542a = stringBuffer.toString();
            this.f74543b = str2;
            this.f74544c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f74532b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f74532b.size() == 0) {
            this.f74533c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f74534d * 1000);
        }
    }

    private void c() {
        if (this.f74532b.size() == this.f74535e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f74537g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f74539i;
        synchronized (this.f74532b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f74539i;
        synchronized (this.f74532b) {
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
                synchronized (b.this.f74532b) {
                    b.this.f74533c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f74532b);
                    b.this.f74532b.clear();
                }
                try {
                    try {
                        b.this.f74536f.a(b.this.f74537g);
                        for (a aVar : arrayList) {
                            b.this.f74536f.a(aVar.f74542a, aVar.f74543b, aVar.f74544c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f74536f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f74536f.a();
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
        return this.f74539i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f74539i;
        synchronized (this.f74532b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f74539i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f74539i;
        synchronized (this.f74532b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f74539i;
        synchronized (this.f74532b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
