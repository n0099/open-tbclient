package com.meizu.cloud.pushsdk.base;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class b implements g {

    /* renamed from: d  reason: collision with root package name */
    public long f67431d = 60;

    /* renamed from: e  reason: collision with root package name */
    public int f67432e = 10;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67436i = false;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDateFormat f67428a = new SimpleDateFormat("MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public List<a> f67429b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public Handler f67430c = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public String f67434g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";

    /* renamed from: f  reason: collision with root package name */
    public e f67433f = new e();

    /* renamed from: h  reason: collision with root package name */
    public String f67435h = String.valueOf(Process.myPid());

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f67439a;

        /* renamed from: b  reason: collision with root package name */
        public String f67440b;

        /* renamed from: c  reason: collision with root package name */
        public String f67441c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.f67428a.format(new Date()));
            stringBuffer.append(" ");
            stringBuffer.append(b.this.f67435h);
            stringBuffer.append("-");
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.f67439a = stringBuffer.toString();
            this.f67440b = str2;
            this.f67441c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.f67429b.add(aVar);
        } catch (Exception e2) {
            String str = "add logInfo error " + e2.getMessage();
        }
    }

    private void b() {
        if (this.f67429b.size() == 0) {
            this.f67430c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.f67431d * 1000);
        }
    }

    private void c() {
        if (this.f67429b.size() == this.f67432e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.f67434g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        boolean z = this.f67436i;
        synchronized (this.f67429b) {
            b();
            a(new a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2, Throwable th) {
        boolean z = this.f67436i;
        synchronized (this.f67429b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2 + StringUtils.LF + Log.getStackTraceString(th)));
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
                synchronized (b.this.f67429b) {
                    b.this.f67430c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.f67429b);
                    b.this.f67429b.clear();
                }
                try {
                    try {
                        b.this.f67433f.a(b.this.f67434g);
                        for (a aVar : arrayList) {
                            b.this.f67433f.a(aVar.f67439a, aVar.f67440b, aVar.f67441c);
                        }
                        bVar = b.this;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Exception unused2) {
                    bVar = b.this;
                } catch (Throwable th) {
                    try {
                        b.this.f67433f.a();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
                bVar.f67433f.a();
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
        return this.f67436i;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(String str, String str2) {
        boolean z = this.f67436i;
        synchronized (this.f67429b) {
            b();
            a(new a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void b(boolean z) {
        this.f67436i = z;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void c(String str, String str2) {
        boolean z = this.f67436i;
        synchronized (this.f67429b) {
            b();
            a(new a(ExifInterface.LONGITUDE_WEST, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void d(String str, String str2) {
        boolean z = this.f67436i;
        synchronized (this.f67429b) {
            b();
            a(new a(ExifInterface.LONGITUDE_EAST, str, str2));
            c();
        }
    }
}
