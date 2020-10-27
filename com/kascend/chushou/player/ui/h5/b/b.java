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
    private io.reactivex.disposables.b plB;
    private a plC;
    private final tv.chushou.zues.c plD = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0983b> f = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0983b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c plE;

        private C0983b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.plC = (a) activity;
        } catch (Exception e) {
            this.plC = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.plD.cs(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.plD.cs(null);
        g();
        this.c = null;
        this.plC = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.plC != null) {
                this.plC.b(this.e.size());
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
        C0983b c0983b = new C0983b();
        c0983b.plE = cVar;
        c0983b.c = SystemClock.uptimeMillis();
        c0983b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.plD.f(c0983b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0983b);
    }

    public void a(String str) {
        C0983b c0983b = this.f.get(str);
        if (c0983b != null) {
            b(c0983b.plE);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c ese() {
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
    public H5Positon Qn(int i) {
        com.kascend.chushou.player.ui.h5.c.c ese = ese();
        if (ese == null) {
            return null;
        }
        if (i == 1) {
            return ese.plJ;
        }
        return ese.plK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0983b c0983b = this.f.get(this.e.get(0).p);
            if (c0983b != null) {
                g();
                final long uptimeMillis = c0983b.plE.e - ((SystemClock.uptimeMillis() - c0983b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.plB = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.exr()).b(io.reactivex.a.b.a.ewM()).a(io.reactivex.a.b.a.ewM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.plC != null) {
                            b.this.plC.a(longValue);
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
        if (this.plB != null) {
            this.plB.dispose();
            this.plB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.plC != null) {
            g();
            if (aVar != null) {
                this.plC.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.eqe().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet eR = com.kascend.chushou.c.e.eR(jSONObject);
                    if (eR.mRc == 0 && eR.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) eR.mData;
                        long longValue = ((Long) eR.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0983b c0983b = (C0983b) b.this.f.get(cVar.p);
                        if (c0983b != null) {
                            c0983b.c = SystemClock.uptimeMillis();
                            c0983b.plE.e = longValue;
                            if (b.this.ese() == cVar) {
                                b.this.f();
                            }
                            b.this.plD.N(c0983b.b);
                            b.this.plD.f(c0983b.b, c0983b.plE.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(eR.mRc, eR.mMessage);
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
        C0983b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.plD.N(remove.b);
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
        if (this.plC != null) {
            this.plC.b(this.e.size());
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
