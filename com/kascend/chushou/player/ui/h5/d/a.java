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
    private b pwD;
    private c pwQ;
    private InterfaceC1006a pwR;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1006a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.pwR = (InterfaceC1006a) activity;
        } catch (Exception e) {
            this.pwR = null;
        }
    }

    public void a() {
        d();
        this.pwQ = null;
    }

    public void b() {
        d();
        this.d = null;
        this.pwR = null;
    }

    public void a(c cVar) {
        if (this.pwQ != null && this.pwQ.p != null && !this.pwQ.p.equals(cVar.p)) {
            c cVar2 = this.pwQ;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.pwQ = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c evT() {
        return this.pwQ;
    }

    public H5Positon Rl(int i) {
        if (this.pwQ == null) {
            return null;
        }
        if (i == 1) {
            return this.pwQ.pwL;
        }
        return this.pwQ.pwM;
    }

    private void d() {
        if (this.pwD != null) {
            this.pwD.dispose();
            this.pwD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.pwQ != null) {
            d();
            if (this.pwQ.e == 0) {
                a(this.pwQ, false);
                return;
            }
            final long j = this.pwQ.e;
            this.pwD = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.eBh()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.pwQ, false);
                }
            }).b(io.reactivex.a.b.a.eAC()).a(io.reactivex.a.b.a.eAC()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.pwQ.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.pwQ.e);
                    if (a.this.pwR != null) {
                        a.this.pwR.b(a.this.pwQ.e);
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
        com.kascend.chushou.c.c.etT().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet eS = com.kascend.chushou.c.e.eS(jSONObject);
                    if (eS.mRc == 0 && eS.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) eS.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) eS.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.pwQ != null) {
                            a.this.pwQ.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(eS.mRc, eS.mMessage);
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
        if (this.pwR != null) {
            d();
            if (aVar != null) {
                this.pwQ = null;
                this.pwR.b(0L);
                this.pwR.b(aVar);
            }
        }
    }
}
