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
    public long f75068d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f75069e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75073i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f75065a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f75066b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f75067c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f75071g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f75070f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f75072h = String.valueOf(Process.myPid());

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f75076a;

        /* renamed from: b  reason: collision with root package name */
        public String f75077b;

        /* renamed from: c  reason: collision with root package name */
        public String f75078c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f75065a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f75072h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f75076a = stringBuffer.toString();
            this.f75077b = str2;
            this.f75078c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f75066b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f75066b.size() == 0) {
            this.f75067c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f75068d * 1000);
        }
    }

    private void c() {
        if (this.f75066b.size() == this.f75069e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f75071g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f75073i;
        synchronized (this.f75066b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f75073i;
        synchronized (this.f75066b) {
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
                synchronized (b.this.f75066b) {
                    b.this.f75067c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f75066b);
                    b.this.f75066b.clear();
                }
                try {
                    try {
                        b.this.f75070f.a(b.this.f75071g);
                        for (a aVar : arrayList) {
                            b.this.f75070f.a(aVar.f75076a, aVar.f75077b, aVar.f75078c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f75070f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f75070f.a();
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
        return this.f75073i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f75073i;
        synchronized (this.f75066b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f75073i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f75073i;
        synchronized (this.f75066b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f75073i;
        synchronized (this.f75066b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
