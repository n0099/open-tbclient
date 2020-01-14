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
/* loaded from: classes4.dex */
public class b {
    private Activity c;
    private io.reactivex.disposables.b nbP;
    private a nbQ;
    private final tv.chushou.zues.c nbR = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0696b> f = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0696b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c nbS;

        private C0696b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.nbQ = (a) activity;
        } catch (Exception e) {
            this.nbQ = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.nbR.cp(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.nbR.cp(null);
        g();
        this.c = null;
        this.nbQ = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.nbQ != null) {
                this.nbQ.b(this.e.size());
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
        C0696b c0696b = new C0696b();
        c0696b.nbS = cVar;
        c0696b.c = SystemClock.uptimeMillis();
        c0696b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.nbR.d(c0696b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0696b);
    }

    public void a(String str) {
        C0696b c0696b = this.f.get(str);
        if (c0696b != null) {
            b(c0696b.nbS);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c dCS() {
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
    public H5Positon MQ(int i) {
        com.kascend.chushou.player.ui.h5.c.c dCS = dCS();
        if (dCS == null) {
            return null;
        }
        if (i == 1) {
            return dCS.nbX;
        }
        return dCS.nbY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0696b c0696b = this.f.get(this.e.get(0).p);
            if (c0696b != null) {
                g();
                final long uptimeMillis = c0696b.nbS.e - ((SystemClock.uptimeMillis() - c0696b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.nbP = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dID()).b(io.reactivex.a.b.a.dHZ()).a(io.reactivex.a.b.a.dHZ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.nbQ != null) {
                            b.this.nbQ.a(longValue);
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
        if (this.nbP != null) {
            this.nbP.dispose();
            this.nbP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nbQ != null) {
            g();
            if (aVar != null) {
                this.nbQ.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.dAI().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet dL = com.kascend.chushou.c.e.dL(jSONObject);
                    if (dL.mRc == 0 && dL.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dL.mData;
                        long longValue = ((Long) dL.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0696b c0696b = (C0696b) b.this.f.get(cVar.p);
                        if (c0696b != null) {
                            c0696b.c = SystemClock.uptimeMillis();
                            c0696b.nbS.e = longValue;
                            if (b.this.dCS() == cVar) {
                                b.this.f();
                            }
                            b.this.nbR.removeCallbacks(c0696b.b);
                            b.this.nbR.d(c0696b.b, c0696b.nbS.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(dL.mRc, dL.mMessage);
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
        C0696b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.nbR.removeCallbacks(remove.b);
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
        if (this.nbQ != null) {
            this.nbQ.b(this.e.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.c == null || this.c.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(Context context, long j) {
        return context.getString(a.i.luckydraw_count_down, Integer.valueOf((int) (j / 60)), Integer.valueOf((int) (j % 60)));
    }
}
