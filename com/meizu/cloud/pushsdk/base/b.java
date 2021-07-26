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
    public long f37492d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f37493e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37497i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f37489a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f37490b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f37491c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f37495g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f37494f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f37496h = String.valueOf(Process.myPid());

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f37500a;

        /* renamed from: b  reason: collision with root package name */
        public String f37501b;

        /* renamed from: c  reason: collision with root package name */
        public String f37502c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f37489a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f37496h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f37500a = stringBuffer.toString();
            this.f37501b = str2;
            this.f37502c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f37490b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.f37490b.size() == 0) {
            this.f37491c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f37492d * 1000);
        }
    }

    private void c() {
        if (this.f37490b.size() == this.f37493e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f37495g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.f37497i) {
            Log.d(str, str2);
        }
        synchronized (this.f37490b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        if (this.f37497i) {
            Log.e(str, str2, th);
        }
        synchronized (this.f37490b) {
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
                synchronized (b.this.f37490b) {
                    b.this.f37491c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f37490b);
                    b.this.f37490b.clear();
                }
                try {
                    try {
                        b.this.f37494f.a(b.this.f37495g);
                        for (a aVar : arrayList) {
                            b.this.f37494f.a(aVar.f37500a, aVar.f37501b, aVar.f37502c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f37494f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f37494f.a();
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
        return this.f37497i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        if (this.f37497i) {
            Log.i(str, str2);
        }
        synchronized (this.f37490b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f37497i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        if (this.f37497i) {
            Log.w(str, str2);
        }
        synchronized (this.f37490b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        if (this.f37497i) {
            Log.e(str, str2);
        }
        synchronized (this.f37490b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
