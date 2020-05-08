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
    private io.reactivex.disposables.b mAW;
    private a mAX;
    private final tv.chushou.zues.c mAY = new tv.chushou.zues.c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.c> e = new ArrayList();
    private final Map<String, C0750b> f = new HashMap();

    /* loaded from: classes5.dex */
    public interface a {
        void a(long j);

        void a(com.kascend.chushou.player.ui.h5.c.a aVar);

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.h5.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0750b {
        Runnable b;
        long c;
        com.kascend.chushou.player.ui.h5.c.c mAZ;

        private C0750b() {
        }
    }

    public b(Activity activity) {
        this.c = activity;
        try {
            this.mAX = (a) activity;
        } catch (Exception e) {
            this.mAX = null;
        }
    }

    public void a() {
        this.e.clear();
        this.f.clear();
        this.mAY.ca(null);
        g();
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.mAY.ca(null);
        g();
        this.c = null;
        this.mAX = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.c> list) {
        if (!h.isEmpty(list)) {
            for (com.kascend.chushou.player.ui.h5.c.c cVar : list) {
                a(cVar);
            }
            f();
            if (this.mAX != null) {
                this.mAX.b(this.e.size());
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
        C0750b c0750b = new C0750b();
        c0750b.mAZ = cVar;
        c0750b.c = SystemClock.uptimeMillis();
        c0750b.b = new Runnable() { // from class: com.kascend.chushou.player.ui.h5.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar);
            }
        };
        this.mAY.e(c0750b.b, cVar.e * 1000);
        this.f.put(cVar.p, c0750b);
    }

    public void a(String str) {
        C0750b c0750b = this.f.get(str);
        if (c0750b != null) {
            b(c0750b.mAZ);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.h5.c.c dyx() {
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
    public H5Positon It(int i) {
        com.kascend.chushou.player.ui.h5.c.c dyx = dyx();
        if (dyx == null) {
            return null;
        }
        if (i == 1) {
            return dyx.mBe;
        }
        return dyx.mBf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!h.isEmpty(this.e)) {
            C0750b c0750b = this.f.get(this.e.get(0).p);
            if (c0750b != null) {
                g();
                final long uptimeMillis = c0750b.mAZ.e - ((SystemClock.uptimeMillis() - c0750b.c) / 1000);
                if (uptimeMillis <= 0) {
                    uptimeMillis = 0;
                }
                this.mAW = g.a(1L, uptimeMillis, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dDi()).b(io.reactivex.a.b.a.dCD()).a(io.reactivex.a.b.a.dCD()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.b.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                        long longValue = uptimeMillis - l.longValue();
                        e.d("LuckydrawController", "抽奖计时：" + longValue);
                        if (b.this.mAX != null) {
                            b.this.mAX.a(longValue);
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
        if (this.mAW != null) {
            this.mAW.dispose();
            this.mAW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mAX != null) {
            g();
            if (aVar != null) {
                this.mAX.a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kascend.chushou.player.ui.h5.c.c cVar) {
        com.kascend.chushou.c.c.dwD().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.b.b.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!b.this.h()) {
                    ParserRet dO = com.kascend.chushou.c.e.dO(jSONObject);
                    if (dO.mRc == 0 && dO.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dO.mData;
                        long longValue = ((Long) dO.mData1).longValue();
                        if (longValue <= 0) {
                            b.this.a(aVar);
                            b.this.b(cVar.p);
                            b.this.f();
                            return;
                        }
                        C0750b c0750b = (C0750b) b.this.f.get(cVar.p);
                        if (c0750b != null) {
                            c0750b.c = SystemClock.uptimeMillis();
                            c0750b.mAZ.e = longValue;
                            if (b.this.dyx() == cVar) {
                                b.this.f();
                            }
                            b.this.mAY.N(c0750b.b);
                            b.this.mAY.e(c0750b.b, c0750b.mAZ.e * 1000);
                            return;
                        }
                        return;
                    }
                    a(dO.mRc, dO.mMessage);
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
        C0750b remove = this.f.remove(str);
        if (remove != null && remove.b != null) {
            this.mAY.N(remove.b);
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
        if (this.mAX != null) {
            this.mAX.b(this.e.size());
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
