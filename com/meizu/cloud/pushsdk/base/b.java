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
    public long f74714d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f74715e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74719i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f74711a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f74712b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f74713c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f74717g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f74716f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f74718h = String.valueOf(Process.myPid());

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74722a;

        /* renamed from: b  reason: collision with root package name */
        public String f74723b;

        /* renamed from: c  reason: collision with root package name */
        public String f74724c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f74711a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f74718h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f74722a = stringBuffer.toString();
            this.f74723b = str2;
            this.f74724c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f74712b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f74712b.size() == 0) {
            this.f74713c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f74714d * 1000);
        }
    }

    private void c() {
        if (this.f74712b.size() == this.f74715e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f74717g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f74719i;
        synchronized (this.f74712b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f74719i;
        synchronized (this.f74712b) {
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
                synchronized (b.this.f74712b) {
                    b.this.f74713c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f74712b);
                    b.this.f74712b.clear();
                }
                try {
                    try {
                        b.this.f74716f.a(b.this.f74717g);
                        for (a aVar : arrayList) {
                            b.this.f74716f.a(aVar.f74722a, aVar.f74723b, aVar.f74724c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f74716f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f74716f.a();
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
        return this.f74719i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f74719i;
        synchronized (this.f74712b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f74719i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f74719i;
        synchronized (this.f74712b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f74719i;
        synchronized (this.f74712b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
