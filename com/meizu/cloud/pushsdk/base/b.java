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
/* loaded from: classes2.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f60363d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f60364e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60368i = false;
    public SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f60361b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f60362c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f60366g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f60365f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f60367h = String.valueOf(Process.myPid());

    /* loaded from: classes2.dex */
    public class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f60369b;

        /* renamed from: c  reason: collision with root package name */
        public String f60370c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f60367h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.a = stringBuffer.toString();
            this.f60369b = str2;
            this.f60370c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f60361b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f60361b.size() == 0) {
            this.f60362c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f60363d * 1000);
        }
    }

    private void c() {
        if (this.f60361b.size() == this.f60364e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f60366g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f60368i;
        synchronized (this.f60361b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f60368i;
        synchronized (this.f60361b) {
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
                synchronized (b.this.f60361b) {
                    b.this.f60362c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f60361b);
                    b.this.f60361b.clear();
                }
                try {
                    try {
                        b.this.f60365f.a(b.this.f60366g);
                        for (a aVar : arrayList) {
                            b.this.f60365f.a(aVar.a, aVar.f60369b, aVar.f60370c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f60365f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f60365f.a();
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
        return this.f60368i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f60368i;
        synchronized (this.f60361b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f60368i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f60368i;
        synchronized (this.f60361b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f60368i;
        synchronized (this.f60361b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
