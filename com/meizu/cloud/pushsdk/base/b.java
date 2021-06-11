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
    public long f38428d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f38429e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38433i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f38425a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f38426b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f38427c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f38431g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f38430f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f38432h = String.valueOf(Process.myPid());

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38436a;

        /* renamed from: b  reason: collision with root package name */
        public String f38437b;

        /* renamed from: c  reason: collision with root package name */
        public String f38438c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f38425a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f38432h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f38436a = stringBuffer.toString();
            this.f38437b = str2;
            this.f38438c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f38426b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.f38426b.size() == 0) {
            this.f38427c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f38428d * 1000);
        }
    }

    private void c() {
        if (this.f38426b.size() == this.f38429e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f38431g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.f38433i) {
            Log.d(str, str2);
        }
        synchronized (this.f38426b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        if (this.f38433i) {
            Log.e(str, str2, th);
        }
        synchronized (this.f38426b) {
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
                synchronized (b.this.f38426b) {
                    b.this.f38427c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f38426b);
                    b.this.f38426b.clear();
                }
                try {
                    try {
                        b.this.f38430f.a(b.this.f38431g);
                        for (a aVar : arrayList) {
                            b.this.f38430f.a(aVar.f38436a, aVar.f38437b, aVar.f38438c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f38430f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f38430f.a();
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
        return this.f38433i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        if (this.f38433i) {
            Log.i(str, str2);
        }
        synchronized (this.f38426b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f38433i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        if (this.f38433i) {
            Log.w(str, str2);
        }
        synchronized (this.f38426b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        if (this.f38433i) {
            Log.e(str, str2);
        }
        synchronized (this.f38426b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
