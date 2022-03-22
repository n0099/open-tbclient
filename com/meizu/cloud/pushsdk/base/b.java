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
/* loaded from: classes7.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f42038d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f42039e = 10;
    public boolean i = false;
    public SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f42036b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f42037c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f42041g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f42040f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f42042h = String.valueOf(Process.myPid());

    /* loaded from: classes7.dex */
    public class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f42043b;

        /* renamed from: c  reason: collision with root package name */
        public String f42044c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f42042h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.a = stringBuffer.toString();
            this.f42043b = str2;
            this.f42044c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f42036b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.f42036b.size() == 0) {
            this.f42037c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f42038d * 1000);
        }
    }

    private void c() {
        if (this.f42036b.size() == this.f42039e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f42041g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.i) {
            Log.d(str, str2);
        }
        synchronized (this.f42036b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        if (this.i) {
            Log.e(str, str2, th);
        }
        synchronized (this.f42036b) {
            b();
            a(new a("E", str, str2 + "\n" + Log.getStackTraceString(th)));
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
                synchronized (b.this.f42036b) {
                    b.this.f42037c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f42036b);
                    b.this.f42036b.clear();
                }
                try {
                    try {
                        b.this.f42040f.a(b.this.f42041g);
                        for (a aVar : arrayList) {
                            b.this.f42040f.a(aVar.a, aVar.f42043b, aVar.f42044c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f42040f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f42040f.a();
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
        return this.i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        if (this.i) {
            Log.i(str, str2);
        }
        synchronized (this.f42036b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        if (this.i) {
            Log.w(str, str2);
        }
        synchronized (this.f42036b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        if (this.i) {
            Log.e(str, str2);
        }
        synchronized (this.f42036b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
