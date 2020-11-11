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
/* loaded from: classes6.dex */
public class b {
    private Activity c;
    private io.reactivex.disposables.b puZ;
    private a pva;
    private final tv.chushou.zues.c pvb = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C1002b> f = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1002b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c pvc;

        private C1002b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.pva = (a) activity;
        } catch (Exception e) {
            this.pva = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.pvb.cs(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.pvb.cs(null);
        g();
        this.c = null;
        this.pva = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.pva != null) {
                this.pva.b(this.e.size());
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
        C1002b c1002b = new C1002b();
        c1002b.pvc = cVar;
        c1002b.c = SystemClock.uptimeMillis();
        c1002b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.pvb.f(c1002b.b, cVar.e * 1000);
        this.f.put(cVar.p, c1002b);
    }

    public void a(String str) {
        C1002b c1002b = this.f.get(str);
        if (c1002b != null) {
            b(c1002b.pvc);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c evT() {
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
    public H5Positon QI(int i) {
        com.kascend.chushou.player.ui.h5.c.c evT = evT();
        if (evT == null) {
            return null;
        }
        if (i == 1) {
            return evT.pvh;
        }
        return evT.pvi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C1002b c1002b = this.f.get(this.e.get(0).p);
            if (c1002b != null) {
                g();
                final long uptimeMillis = c1002b.pvc.e - ((SystemClock.uptimeMillis() - c1002b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.puZ = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.eBg()).b(io.reactivex.a.b.a.eAB()).a(io.reactivex.a.b.a.eAB()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.pva != null) {
                            b.this.pva.a(longValue);
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
        if (this.puZ != null) {
            this.puZ.dispose();
            this.puZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pva != null) {
            g();
            if (aVar != null) {
                this.pva.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.etT().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet eX = com.kascend.chushou.c.e.eX(jSONObject);
                    if (eX.mRc == 0 && eX.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) eX.mData;
                        long longValue = ((Long) eX.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C1002b c1002b = (C1002b) b.this.f.get(cVar.p);
                        if (c1002b != null) {
                            c1002b.c = SystemClock.uptimeMillis();
                            c1002b.pvc.e = longValue;
                            if (b.this.evT() == cVar) {
                                b.this.f();
                            }
                            b.this.pvb.N(c1002b.b);
                            b.this.pvb.f(c1002b.b, c1002b.pvc.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(eX.mRc, eX.mMessage);
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
        C1002b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.pvb.N(remove.b);
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
        if (this.pva != null) {
            this.pva.b(this.e.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.c == null || this.c.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(Context context, long j) {
        return context.getString(a.i.luckydraw_count_down, Integer.valueOf((int) (j / 60)), Integer.valueOf((int) (j % 60)));
    }
}
