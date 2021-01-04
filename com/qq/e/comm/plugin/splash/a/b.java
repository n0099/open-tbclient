package com.qq.e.comm.plugin.splash.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.s.g;
import com.qq.e.comm.plugin.s.h;
import com.qq.e.comm.plugin.splash.l;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static Object f12757a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f12758b;

    private b() {
        a(GDTADManager.getInstance().getAppContext());
    }

    public static b a() {
        if (f12758b == null) {
            synchronized (b.class) {
                try {
                    if (f12758b == null) {
                        f12758b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12758b;
    }

    private void a(Context context) {
        try {
            context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(final a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b())) {
            return;
        }
        s.f12888a.submit(new Runnable() { // from class: com.qq.e.comm.plugin.splash.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.f12757a) {
                    String a2 = a.this.a();
                    if (!TextUtils.isEmpty(a2)) {
                        ah.a(new File(ah.c() + File.separator + a.this.b()), a2);
                        GDTLogger.d("FirstPlayHelpercache fb report data " + a.this.b());
                    }
                }
            }
        });
    }

    public static boolean a(f fVar) {
        if (fVar == null) {
            return false;
        }
        List<h> j = fVar.j();
        if (j != null && j.size() > 0) {
            for (h hVar : j) {
                if (hVar != null && hVar.e() && a(hVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(h hVar) {
        int h;
        if (hVar == null) {
            return false;
        }
        List<Point> c = hVar.c();
        if (c == null || c.isEmpty()) {
            return true;
        }
        for (Point point : c) {
            int i = point.x;
            int i2 = point.y;
            if (i < 0) {
                i = 0;
            }
            if (i2 > 1440) {
                i2 = 1440;
            }
            if (i < i2 && (h = h()) <= i2 && h >= i) {
                return true;
            }
        }
        return false;
    }

    public static void b(f fVar) {
        if (fVar == null) {
            return;
        }
        a aVar = new a();
        aVar.f = fVar.f();
        aVar.g = l.a();
        aVar.h = fVar.q();
        if (fVar.R() != null && fVar.R().size() > 0) {
            aVar.i = new ArrayList();
            for (g gVar : fVar.R()) {
                aVar.i.add(gVar.a());
            }
        }
        if (fVar.S() != null && fVar.S().size() > 0) {
            aVar.j = new ArrayList();
            for (g gVar2 : fVar.S()) {
                aVar.j.add(gVar2.a());
            }
        }
        a(aVar);
    }

    public static boolean c() {
        return l.a().equalsIgnoreCase(i());
    }

    public static void d() {
        at.a("first_play_date", l.a());
    }

    public static void e() {
        GDTLogger.d("FirstPlayHelper clear fp report Data");
        ah.b(ah.c());
    }

    private static int h() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(12) + (calendar.get(11) * 60);
    }

    private static String i() {
        return at.b("first_play_date", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<a> j() {
        a aVar;
        File[] listFiles = ah.c().listFiles();
        if (listFiles.length == 0) {
            GDTLogger.d("FirstPlayHelper no first play cache data");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (f12757a) {
            for (File file : listFiles) {
                arrayList.add(new a(ah.c(file)));
                GDTLogger.d("bean " + aVar.toString());
            }
            e();
        }
        return arrayList;
    }

    public void b() {
        s.f12888a.submit(new Runnable() { // from class: com.qq.e.comm.plugin.splash.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                List<a> j = b.j();
                if (j == null || j.size() == 0) {
                    return;
                }
                for (a aVar : j) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.b())) {
                        af.a(aVar.h);
                        if (aVar.i != null && aVar.i.size() > 0) {
                            for (String str : aVar.i) {
                                if (!TextUtils.isEmpty(str)) {
                                    af.a(str);
                                }
                            }
                        }
                        if (aVar.j != null && aVar.j.size() > 0) {
                            for (String str2 : aVar.j) {
                                if (!TextUtils.isEmpty(str2)) {
                                    aa.a(str2);
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GDTLogger.d("FirstPlayHelper：网络状态变化");
        if (!l.a(context)) {
            GDTLogger.d("FirstPlayHelper：当前无网络连接");
            return;
        }
        GDTLogger.d("FirstPlayHelper：有网络尝试补报第一刷");
        b();
    }
}
