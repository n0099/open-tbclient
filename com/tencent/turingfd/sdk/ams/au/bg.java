package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.result.AccountCenterResult;
import com.tencent.turingfd.sdk.ams.au.an;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f13810a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f13811b = new AtomicBoolean(false);
    public static final Object c;
    public static AtomicBoolean d;

    static {
        new AtomicBoolean(false);
        c = new Object();
        d = new AtomicBoolean(false);
        Log.d("TuringFdJava", b());
    }

    public static int a() {
        if (f13810a.get()) {
            if (f13811b.get()) {
                return 0;
            }
            return AccountCenterResult.ERROR_CODE_LOGIN_SUCCESS;
        }
        return -10001;
    }

    public static void a(aq aqVar) {
        if (d.get()) {
            return;
        }
        synchronized (c) {
            if (aqVar.f13788b > 0 && af.f13767a == 0) {
                af.f13767a = aqVar.f13788b;
            }
            if (f13811b.get()) {
                b(aqVar);
            } else if (d.get()) {
            } else {
                d.set(true);
                if (!c(aqVar)) {
                    f13811b.set(false);
                } else if (af.f13767a == 0) {
                    Log.i("TuringFdJava", "error channel");
                    f13811b.set(false);
                } else {
                    b(aqVar);
                    f13811b.set(true);
                    d.set(false);
                }
            }
        }
    }

    public static String b() {
        return String.format(Locale.getDefault(), "TuringFD v%d (l%s, t%d, %s, %s, e%d, d%d, p%d, compiled %s)", 47, "08494CC7F34DBB9B", 1, "auMini", "taf", 0, 0, 0, "2020_05_18_11_15_01");
    }

    public static void b(aq aqVar) {
        Log.i("TuringFdJava", ab.a("channel : ").append(af.f13767a).toString());
        an anVar = an.f13775a;
        anVar.d = aqVar;
        if (anVar.f) {
            return;
        }
        anVar.f = true;
        aj.a(aqVar.g());
        f fVar = f.f13822a;
        aqVar.g();
        fVar.f = new be(anVar);
        HandlerThread handlerThread = new HandlerThread(ab.a("TuringFdCore_47_").append(af.f13767a).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("auMini").toString(), -8);
        handlerThread.start();
        anVar.e = new an.b(handlerThread.getLooper(), aqVar.g());
        anVar.g = new c(anVar.e);
        Context g = aqVar.g();
        if (m.f13834a.containsKey(m.c)) {
            new l(m.f13834a.get(m.c), g).start();
        }
        if (anVar.d.c()) {
            new al(anVar).start();
        }
    }

    public static boolean c(aq aqVar) {
        boolean z = true;
        if (f13810a.get()) {
            return f13810a.get();
        }
        if (aqVar.b()) {
            TextUtils.isEmpty(aqVar.m());
            String m = aqVar.m();
            try {
                if (TextUtils.isEmpty(m)) {
                    System.loadLibrary("turingau");
                } else {
                    System.load(m);
                }
            } catch (Throwable th) {
                Log.w("TuringFdJava", th);
                z = false;
            }
            f13810a.set(z);
            if (!z) {
                Log.i("TuringFdJava", "load so failure");
            }
        } else {
            f13810a.set(true);
        }
        return f13810a.get();
    }
}
