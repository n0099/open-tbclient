package com.kascend.chushou.player.ui.h5.b;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.constants.ParserRet;
import io.reactivex.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private Activity c;
    private io.reactivex.disposables.b mWk;
    private a mWl;
    private final tv.chushou.zues.c mWm = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0809b> f = new HashMap();

    /* loaded from: classes5.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0809b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c mWn;

        private C0809b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.mWl = (a) activity;
        } catch (Exception e) {
            this.mWl = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.mWm.cg(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.mWm.cg(null);
        g();
        this.c = null;
        this.mWl = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.mWl != null) {
                this.mWl.b(this.e.size());
            }
        }
    }

    private void a(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        if (h.isEmpty(cVar.p)) {
            cVar.p = UUID.randomUUID().toString();
        }
        for (com.kascend.chushou.player.ui.h5.c.c cVar2 : this.e) {
            if (!h.isEmpty(cVar2.p) && cVar2.p.equals(cVar.p)) {
                return;
            }
        }
        this.e.add(0, cVar);
        C0809b c0809b = new C0809b();
        c0809b.mWn = cVar;
        c0809b.c = SystemClock.uptimeMillis();
        c0809b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.mWm.e(c0809b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0809b);
    }

    public void a(String str) {
        C0809b c0809b = this.f.get(str);
        if (c0809b != null) {
            b(c0809b.mWn);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c dGe() {
        if (this.e.size() > 0) {
            return this.e.get(0);
        }
        return null;
    }

    public List<com.kascend.chushou.player.ui.h5.c.c> d() {
        return this.e;
    }

    public int e() {
        return this.e.size();
    }

    @Nullable
    public H5Positon Jg(int i) {
        com.kascend.chushou.player.ui.h5.c.c dGe = dGe();
        if (dGe == null) {
            return null;
        }
        if (i == 1) {
            return dGe.mWs;
        }
        return dGe.mWt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0809b c0809b = this.f.get(this.e.get(0).p);
            if (c0809b != null) {
                g();
                final long uptimeMillis = c0809b.mWn.e - ((SystemClock.uptimeMillis() - c0809b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.mWk = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dLr()).b(io.reactivex.a.b.a.dKM()).a(io.reactivex.a.b.a.dKM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.mWl != null) {
                            b.this.mWl.a(longValue);
                        }
                    }
                }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.ui.h5.b.b.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Throwable th) throws Exception {
                        e.e("LuckydrawController", "", th);
                    }
                });
            }
        }
    }

    private void g() {
        if (this.mWk != null) {
            this.mWk.dispose();
            this.mWk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWl != null) {
            g();
            if (aVar != null) {
                this.mWl.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.dEj().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet dV = com.kascend.chushou.c.e.dV(jSONObject);
                    if (dV.mRc == 0 && dV.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dV.mData;
                        long longValue = ((Long) dV.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0809b c0809b = (C0809b) b.this.f.get(cVar.p);
                        if (c0809b != null) {
                            c0809b.c = SystemClock.uptimeMillis();
                            c0809b.mWn.e = longValue;
                            if (b.this.dGe() == cVar) {
                                b.this.f();
                            }
                            b.this.mWm.P(c0809b.b);
                            b.this.mWm.e(c0809b.b, c0809b.mWn.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(dV.mRc, dV.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (!b.this.h()) {
                    b.this.b(cVar.p);
                    b.this.f();
                    e.d("LuckydrawController", "check luckdraw finish, code=" + i + ",msg=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        C0809b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.mWm.P(remove.b);
        }
        Iterator<com.kascend.chushou.player.ui.h5.c.c> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().p.equals(str)) {
                it.remove();
                break;
            }
        }
        if (this.mWl != null) {
            this.mWl.b(this.e.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.c == null || this.c.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context, long j) {
        return context.getString(a.i.luckydraw_count_down, Integer.valueOf((int) (j / 60)), Integer.valueOf((int) (j % 60)));
    }
}
