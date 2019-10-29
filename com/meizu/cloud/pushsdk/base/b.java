package com.meizu.cloud.pushsdk.base;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements g {
    private long d = 60;
    private int e = 10;
    private boolean i = false;
    private SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss");
    private List<a> b = Collections.synchronizedList(new ArrayList());
    private Handler c = new Handler(Looper.getMainLooper());
    private String g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";
    private e f = new e();
    private String h = String.valueOf(Process.myPid());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        String a;
        String b;
        String c;

        public a(String str, String str2, String str3) {
            StringBuffer stringBuffer = new StringBuffer(b.this.a.format(new Date()));
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
            stringBuffer.append(b.this.h);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            stringBuffer.append(String.valueOf(Thread.currentThread().getId()));
            stringBuffer.append(HanziToPinyin.Token.SEPARATOR);
            stringBuffer.append(str);
            stringBuffer.append("/");
            this.a = stringBuffer.toString();
            this.b = str2;
            this.c = str3;
        }
    }

    private void a(a aVar) {
        try {
            this.b.add(aVar);
        } catch (Exception e) {
            Log.e("Logger", "add logInfo error " + e.getMessage());
        }
    }

    private void b() {
        if (this.b.size() == 0) {
            this.c.postDelayed(new Runnable() { // from class: com.meizu.cloud.pushsdk.base.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a(true);
                }
            }, this.d * 1000);
        }
    }

    private void c() {
        if (this.b.size() == this.e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str) {
        this.g = str;
    }

    @Override // com.meizu.cloud.pushsdk.base.g
    public void a(String str, String str2) {
        if (this.i) {
            Log.d(str, str2);
        }
        synchronized (this.b) {
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
        synchronized (this.b) {
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
                ArrayList<a> arrayList = new ArrayList();
                synchronized (b.this.b) {
                    b.this.c.removeCallbacksAndMessages(null);
                    arrayList.addAll(b.this.b);
                    b.this.b.clear();
                }
                try {
                    b.this.f.a(b.this.g);
                    for (a aVar : arrayList) {
                        b.this.f.a(aVar.a, aVar.b, aVar.c);
                    }
                    try {
                        b.this.f.a();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        b.this.f.a();
                    } catch (Exception e3) {
                    }
                } catch (Throwable th) {
                    try {
                        b.this.f.a();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
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
        synchronized (this.b) {
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
        synchronized (this.b) {
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
        synchronized (this.b) {
            b();
            a(new a("E", str, str2));
            c();
        }
    }
}
