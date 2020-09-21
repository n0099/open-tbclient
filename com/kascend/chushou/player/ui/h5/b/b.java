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
    private io.reactivex.disposables.b oeQ;
    private a oeR;
    private final tv.chushou.zues.c oeS = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0893b> f = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0893b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c oeT;

        private C0893b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.oeR = (a) activity;
        } catch (Exception e) {
            this.oeR = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.oeS.cl(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.oeS.cl(null);
        g();
        this.c = null;
        this.oeR = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.oeR != null) {
                this.oeR.b(this.e.size());
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
        C0893b c0893b = new C0893b();
        c0893b.oeT = cVar;
        c0893b.c = SystemClock.uptimeMillis();
        c0893b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.oeS.e(c0893b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0893b);
    }

    public void a(String str) {
        C0893b c0893b = this.f.get(str);
        if (c0893b != null) {
            b(c0893b.oeT);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c eet() {
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
    public H5Positon NQ(int i) {
        com.kascend.chushou.player.ui.h5.c.c eet = eet();
        if (eet == null) {
            return null;
        }
        if (i == 1) {
            return eet.oeY;
        }
        return eet.oeZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0893b c0893b = this.f.get(this.e.get(0).p);
            if (c0893b != null) {
                g();
                final long uptimeMillis = c0893b.oeT.e - ((SystemClock.uptimeMillis() - c0893b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.oeQ = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.ejG()).b(io.reactivex.a.b.a.ejb()).a(io.reactivex.a.b.a.ejb()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.oeR != null) {
                            b.this.oeR.a(longValue);
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
        if (this.oeQ != null) {
            this.oeQ.dispose();
            this.oeQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.oeR != null) {
            g();
            if (aVar != null) {
                this.oeR.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.ect().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet eF = com.kascend.chushou.c.e.eF(jSONObject);
                    if (eF.mRc == 0 && eF.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) eF.mData;
                        long longValue = ((Long) eF.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0893b c0893b = (C0893b) b.this.f.get(cVar.p);
                        if (c0893b != null) {
                            c0893b.c = SystemClock.uptimeMillis();
                            c0893b.oeT.e = longValue;
                            if (b.this.eet() == cVar) {
                                b.this.f();
                            }
                            b.this.oeS.L(c0893b.b);
                            b.this.oeS.e(c0893b.b, c0893b.oeT.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(eF.mRc, eF.mMessage);
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
        C0893b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.oeS.L(remove.b);
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
        if (this.oeR != null) {
            this.oeR.b(this.e.size());
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
