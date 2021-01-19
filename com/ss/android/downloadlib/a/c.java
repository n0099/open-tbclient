package com.ss.android.downloadlib.a;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.downloadlib.f.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12943a = c.class.getSimpleName();
    private static volatile c pRc;
    private ConcurrentHashMap<Long, Runnable> d;
    private com.ss.android.downloadlib.f.j pQI = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);

    public c() {
        this.d = null;
        this.d = new ConcurrentHashMap<>();
    }

    public static c eCg() {
        if (pRc == null) {
            synchronized (c.class) {
                if (pRc == null) {
                    pRc = new c();
                }
            }
        }
        return pRc;
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null) {
            boolean a2 = j.eCv() != null ? j.eCv().a() : false;
            long j = 0;
            if (message.obj instanceof Long) {
                j = ((Long) message.obj).longValue();
            }
            switch (message.what) {
                case 4:
                    if (a2) {
                        com.ss.android.downloadlib.e.a.eCL().a(j, true, 2);
                        return;
                    }
                    return;
                case 5:
                    if (a2) {
                        com.ss.android.downloadlib.e.a.eCL().a(j, true, 1);
                        return;
                    }
                    return;
                case 6:
                default:
                    return;
                case 7:
                    Runnable runnable = this.d.get(Long.valueOf(j));
                    this.d.remove(Long.valueOf(j));
                    if (a2) {
                        com.ss.android.downloadlib.e.a.eCL().a(j, 1);
                        com.ss.android.downloadlib.e.a.eCL().a(j, true, 1);
                        return;
                    }
                    if (runnable != null) {
                        this.pQI.post(runnable);
                    }
                    com.ss.android.downloadlib.e.a.eCL().a(j, false, 1);
                    return;
            }
        }
    }

    public void a(int i, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        com.ss.android.downloadlib.f.h.i(f12943a, "sendQuickAppMsg msgWhat:" + i, null);
        if (this.pQI != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = Long.valueOf(cVar.d());
            this.pQI.sendMessageDelayed(obtain, b());
        }
    }

    public long b() {
        return j.i().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean b(com.ss.android.a.a.b.c cVar) {
        return (cVar == null || cVar.eBH() == null || TextUtils.isEmpty(cVar.eBH().a())) ? false : true;
    }

    public static boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return cVar == null || cVar.q() == 0 || cVar.q() == -4;
    }
}
