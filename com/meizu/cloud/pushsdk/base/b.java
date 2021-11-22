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
    public long f68344d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f68345e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68349i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f68341a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f68342b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f68343c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f68347g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f68346f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f68348h = String.valueOf(Process.myPid());

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f68352a;

        /* renamed from: b  reason: collision with root package name */
        public String f68353b;

        /* renamed from: c  reason: collision with root package name */
        public String f68354c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f68341a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f68348h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f68352a = stringBuffer.toString();
            this.f68353b = str2;
            this.f68354c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f68342b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f68342b.size() == 0) {
            this.f68343c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f68344d * 1000);
        }
    }

    private void c() {
        if (this.f68342b.size() == this.f68345e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f68347g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f68349i;
        synchronized (this.f68342b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f68349i;
        synchronized (this.f68342b) {
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
                synchronized (b.this.f68342b) {
                    b.this.f68343c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f68342b);
                    b.this.f68342b.clear();
                }
                try {
                    try {
                        b.this.f68346f.a(b.this.f68347g);
                        for (a aVar : arrayList) {
                            b.this.f68346f.a(aVar.f68352a, aVar.f68353b, aVar.f68354c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f68346f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f68346f.a();
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
        return this.f68349i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f68349i;
        synchronized (this.f68342b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f68349i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f68349i;
        synchronized (this.f68342b) {
            b();
            a(new a("W", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f68349i;
        synchronized (this.f68342b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
