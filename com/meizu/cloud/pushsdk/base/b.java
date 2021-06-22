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
    public long f38526d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f38527e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38531i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f38523a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f38524b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f38525c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f38529g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f38528f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f38530h = String.valueOf(Process.myPid());

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38534a;

        /* renamed from: b  reason: collision with root package name */
        public String f38535b;

        /* renamed from: c  reason: collision with root package name */
        public String f38536c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f38523a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f38530h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f38534a = stringBuffer.toString();
            this.f38535b = str2;
            this.f38536c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f38524b.add(aVar);
        } catch (Exception e2) {
            Log.e("Logger", "add logInfo error " + e2.getMessage());
        }
    }

    private void b() {
        if (this.f38524b.size() == 0) {
            this.f38525c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f38526d * 1000);
        }
    }

    private void c() {
        if (this.f38524b.size() == this.f38527e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f38529g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.f38531i) {
            Log.d(str, str2);
        }
        synchronized (this.f38524b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        if (this.f38531i) {
            Log.e(str, str2, th);
        }
        synchronized (this.f38524b) {
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
                synchronized (b.this.f38524b) {
                    b.this.f38525c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f38524b);
                    b.this.f38524b.clear();
                }
                try {
                    try {
                        b.this.f38528f.a(b.this.f38529g);
                        for (a aVar : arrayList) {
                            b.this.f38528f.a(aVar.f38534a, aVar.f38535b, aVar.f38536c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f38528f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f38528f.a();
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
        return this.f38531i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        if (this.f38531i) {
            Log.i(str, str2);
        }
        synchronized (this.f38524b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f38531i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        if (this.f38531i) {
            Log.w(str, str2);
        }
        synchronized (this.f38524b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        if (this.f38531i) {
            Log.e(str, str2);
        }
        synchronized (this.f38524b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
