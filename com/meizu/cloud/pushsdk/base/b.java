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
    public long f75033d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f75034e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75038i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f75030a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f75031b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f75032c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f75036g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f75035f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f75037h = String.valueOf(Process.myPid());

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f75041a;

        /* renamed from: b  reason: collision with root package name */
        public String f75042b;

        /* renamed from: c  reason: collision with root package name */
        public String f75043c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f75030a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f75037h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f75041a = stringBuffer.toString();
            this.f75042b = str2;
            this.f75043c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f75031b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f75031b.size() == 0) {
            this.f75032c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f75033d * 1000);
        }
    }

    private void c() {
        if (this.f75031b.size() == this.f75034e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f75036g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f75038i;
        synchronized (this.f75031b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f75038i;
        synchronized (this.f75031b) {
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
                synchronized (b.this.f75031b) {
                    b.this.f75032c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f75031b);
                    b.this.f75031b.clear();
                }
                try {
                    try {
                        b.this.f75035f.a(b.this.f75036g);
                        for (a aVar : arrayList) {
                            b.this.f75035f.a(aVar.f75041a, aVar.f75042b, aVar.f75043c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f75035f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f75035f.a();
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
        return this.f75038i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f75038i;
        synchronized (this.f75031b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f75038i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f75038i;
        synchronized (this.f75031b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f75038i;
        synchronized (this.f75031b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
