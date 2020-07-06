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
    private io.reactivex.disposables.b nse;
    private a nsf;
    private final tv.chushou.zues.c nsg = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0829b> f = new HashMap();

    /* loaded from: classes5.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0829b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c nsh;

        private C0829b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.nsf = (a) activity;
        } catch (Exception e) {
            this.nsf = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.nsg.ch(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.nsg.ch(null);
        g();
        this.c = null;
        this.nsf = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.nsf != null) {
                this.nsf.b(this.e.size());
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
        C0829b c0829b = new C0829b();
        c0829b.nsh = cVar;
        c0829b.c = SystemClock.uptimeMillis();
        c0829b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.nsg.e(c0829b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0829b);
    }

    public void a(String str) {
        C0829b c0829b = this.f.get(str);
        if (c0829b != null) {
            b(c0829b.nsh);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c dKO() {
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
    public H5Positon Kn(int i) {
        com.kascend.chushou.player.ui.h5.c.c dKO = dKO();
        if (dKO == null) {
            return null;
        }
        if (i == 1) {
            return dKO.nsm;
        }
        return dKO.nsn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0829b c0829b = this.f.get(this.e.get(0).p);
            if (c0829b != null) {
                g();
                final long uptimeMillis = c0829b.nsh.e - ((SystemClock.uptimeMillis() - c0829b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.nse = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dQb()).b(io.reactivex.a.b.a.dPw()).a(io.reactivex.a.b.a.dPw()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.nsf != null) {
                            b.this.nsf.a(longValue);
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
        if (this.nse != null) {
            this.nse.dispose();
            this.nse = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nsf != null) {
            g();
            if (aVar != null) {
                this.nsf.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.dIP().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet ef = com.kascend.chushou.c.e.ef(jSONObject);
                    if (ef.mRc == 0 && ef.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) ef.mData;
                        long longValue = ((Long) ef.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0829b c0829b = (C0829b) b.this.f.get(cVar.p);
                        if (c0829b != null) {
                            c0829b.c = SystemClock.uptimeMillis();
                            c0829b.nsh.e = longValue;
                            if (b.this.dKO() == cVar) {
                                b.this.f();
                            }
                            b.this.nsg.P(c0829b.b);
                            b.this.nsg.e(c0829b.b, c0829b.nsh.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(ef.mRc, ef.mMessage);
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
        C0829b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.nsg.P(remove.b);
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
        if (this.nsf != null) {
            this.nsf.b(this.e.size());
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
