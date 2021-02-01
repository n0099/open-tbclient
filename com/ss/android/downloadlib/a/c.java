package com.ss.android.downloadlib.a;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.downloadlib.f.j;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12945a = c.class.getSimpleName();
    private static volatile c qbg;
    private ConcurrentHashMap<Long, Runnable> d;
    private com.ss.android.downloadlib.f.j qaM = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);

    public c() {
        this.d = null;
        this.d = new ConcurrentHashMap<>();
    }

    public static c eEx() {
        if (qbg == null) {
            synchronized (c.class) {
                if (qbg == null) {
                    qbg = new c();
                }
            }
        }
        return qbg;
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null) {
            boolean a2 = j.eEM() != null ? j.eEM().a() : false;
            long j = 0;
            if (message.obj instanceof Long) {
                j = ((Long) message.obj).longValue();
            }
            switch (message.what) {
                case 4:
                    if (a2) {
                        com.ss.android.downloadlib.e.a.eFc().a(j, true, 2);
                        return;
                    }
                    return;
                case 5:
                    if (a2) {
                        com.ss.android.downloadlib.e.a.eFc().a(j, true, 1);
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
                        com.ss.android.downloadlib.e.a.eFc().a(j, 1);
                        com.ss.android.downloadlib.e.a.eFc().a(j, true, 1);
                        return;
                    }
                    if (runnable != null) {
                        this.qaM.post(runnable);
                    }
                    com.ss.android.downloadlib.e.a.eFc().a(j, false, 1);
                    return;
            }
        }
    }

    public void a(int i, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        com.ss.android.downloadlib.f.h.i(f12945a, "sendQuickAppMsg msgWhat:" + i, null);
        if (this.qaM != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = Long.valueOf(cVar.d());
            this.qaM.sendMessageDelayed(obtain, b());
        }
    }

    public long b() {
        return j.i().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean b(com.ss.android.a.a.b.c cVar) {
        return (cVar == null || cVar.eDY() == null || TextUtils.isEmpty(cVar.eDY().a())) ? false : true;
    }

    public static boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return cVar == null || cVar.q() == 0 || cVar.q() == -4;
    }
}
