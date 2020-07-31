package com.kascend.chushou.player.ui.h5.d;

import android.app.Activity;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.player.ui.h5.c.c;
import io.reactivex.disposables.b;
import io.reactivex.g;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.chushou.zues.utils.e;
/* loaded from: classes6.dex */
public class a {
    private Activity d;
    private b nAO;
    private c nBb;
    private InterfaceC0839a nBc;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0839a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.nBc = (InterfaceC0839a) activity;
        } catch (Exception e) {
            this.nBc = null;
        }
    }

    public void a() {
        d();
        this.nBb = null;
    }

    public void b() {
        d();
        this.d = null;
        this.nBc = null;
    }

    public void a(c cVar) {
        if (this.nBb != null && this.nBb.p != null && !this.nBb.p.equals(cVar.p)) {
            c cVar2 = this.nBb;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.nBb = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dOj() {
        return this.nBb;
    }

    public H5Positon KH(int i) {
        if (this.nBb == null) {
            return null;
        }
        if (i == 1) {
            return this.nBb.nAW;
        }
        return this.nBb.nAX;
    }

    private void d() {
        if (this.nAO != null) {
            this.nAO.dispose();
            this.nAO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.nBb != null) {
            d();
            if (this.nBb.e == 0) {
                a(this.nBb, false);
                return;
            }
            final long j = this.nBb.e;
            this.nAO = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dTx()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.nBb, false);
                }
            }).b(io.reactivex.a.b.a.dSS()).a(io.reactivex.a.b.a.dSS()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.nBb.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.nBb.e);
                    if (a.this.nBc != null) {
                        a.this.nBc.b(a.this.nBb.e);
                    }
                }
            }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.ui.h5.d.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Throwable th) throws Exception {
                    e.e("VoteController", "", th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, final boolean z) {
        com.kascend.chushou.c.c.dMk().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet em = com.kascend.chushou.c.e.em(jSONObject);
                    if (em.mRc == 0 && em.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) em.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) em.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.nBb != null) {
                            a.this.nBb.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(em.mRc, em.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (!a.this.f()) {
                    e.d("VoteController", "check luckdraw finish, code=" + i + ",msg=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.d == null || this.d.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nBc != null) {
            d();
            if (aVar != null) {
                this.nBb = null;
                this.nBc.b(0L);
                this.nBc.b(aVar);
            }
        }
    }
}
