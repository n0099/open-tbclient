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
/* loaded from: classes6.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f34749d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f34750e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34754i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f34746a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f34747b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f34748c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f34752g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f34751f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f34753h = String.valueOf(Process.myPid());

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f34757a;

        /* renamed from: b  reason: collision with root package name */
        public String f34758b;

        /* renamed from: c  reason: collision with root package name */
        public String f34759c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f34746a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f34753h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f34757a = stringBuffer.toString();
            this.f34758b = str2;
            this.f34759c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f34747b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.f34747b.size() == 0) {
            this.f34748c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f34749d * 1000);
        }
    }

    private void c() {
        if (this.f34747b.size() == this.f34750e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f34752g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.f34754i) {
            Log.d(str, str2);
        }
        synchronized (this.f34747b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        if (this.f34754i) {
            Log.e(str, str2, th);
        }
        synchronized (this.f34747b) {
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
                synchronized (b.this.f34747b) {
                    b.this.f34748c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f34747b);
                    b.this.f34747b.clear();
                }
                try {
                    try {
                        b.this.f34751f.a(b.this.f34752g);
                        for (a aVar : arrayList) {
                            b.this.f34751f.a(aVar.f34757a, aVar.f34758b, aVar.f34759c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f34751f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f34751f.a();
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
        return this.f34754i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        if (this.f34754i) {
            Log.i(str, str2);
        }
        synchronized (this.f34747b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f34754i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        if (this.f34754i) {
            Log.w(str, str2);
        }
        synchronized (this.f34747b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        if (this.f34754i) {
            Log.e(str, str2);
        }
        synchronized (this.f34747b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
