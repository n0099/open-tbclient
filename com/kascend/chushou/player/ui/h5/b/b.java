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
    private io.reactivex.disposables.b nAQ;
    private a nAR;
    private final tv.chushou.zues.c nAS = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0838b> f = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0838b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c nAT;

        private C0838b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.nAR = (a) activity;
        } catch (Exception e) {
            this.nAR = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.nAS.ch(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.nAS.ch(null);
        g();
        this.c = null;
        this.nAR = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.nAR != null) {
                this.nAR.b(this.e.size());
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
        C0838b c0838b = new C0838b();
        c0838b.nAT = cVar;
        c0838b.c = SystemClock.uptimeMillis();
        c0838b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.nAS.e(c0838b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0838b);
    }

    public void a(String str) {
        C0838b c0838b = this.f.get(str);
        if (c0838b != null) {
            b(c0838b.nAT);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c dOk() {
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
    public H5Positon KH(int i) {
        com.kascend.chushou.player.ui.h5.c.c dOk = dOk();
        if (dOk == null) {
            return null;
        }
        if (i == 1) {
            return dOk.nAY;
        }
        return dOk.nAZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0838b c0838b = this.f.get(this.e.get(0).p);
            if (c0838b != null) {
                g();
                final long uptimeMillis = c0838b.nAT.e - ((SystemClock.uptimeMillis() - c0838b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.nAQ = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dTy()).b(io.reactivex.a.b.a.dST()).a(io.reactivex.a.b.a.dST()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.nAR != null) {
                            b.this.nAR.a(longValue);
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
        if (this.nAQ != null) {
            this.nAQ.dispose();
            this.nAQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nAR != null) {
            g();
            if (aVar != null) {
                this.nAR.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.dMl().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet em = com.kascend.chushou.c.e.em(jSONObject);
                    if (em.mRc == 0 && em.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) em.mData;
                        long longValue = ((Long) em.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0838b c0838b = (C0838b) b.this.f.get(cVar.p);
                        if (c0838b != null) {
                            c0838b.c = SystemClock.uptimeMillis();
                            c0838b.nAT.e = longValue;
                            if (b.this.dOk() == cVar) {
                                b.this.f();
                            }
                            b.this.nAS.O(c0838b.b);
                            b.this.nAS.e(c0838b.b, c0838b.nAT.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(em.mRc, em.mMessage);
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
        C0838b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.nAS.O(remove.b);
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
        if (this.nAR != null) {
            this.nAR.b(this.e.size());
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
