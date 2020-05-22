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
/* loaded from: classes5.dex */
public class a {
    private Activity d;
    private b mVa;
    private c mVn;
    private InterfaceC0809a mVo;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0809a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.mVo = (InterfaceC0809a) activity;
        } catch (Exception e) {
            this.mVo = null;
        }
    }

    public void a() {
        d();
        this.mVn = null;
    }

    public void b() {
        d();
        this.d = null;
        this.mVo = null;
    }

    public void a(c cVar) {
        if (this.mVn != null && this.mVn.p != null && !this.mVn.p.equals(cVar.p)) {
            c cVar2 = this.mVn;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.mVn = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dFQ() {
        return this.mVn;
    }

    public H5Positon Je(int i) {
        if (this.mVn == null) {
            return null;
        }
        if (i == 1) {
            return this.mVn.mVi;
        }
        return this.mVn.mVj;
    }

    private void d() {
        if (this.mVa != null) {
            this.mVa.dispose();
            this.mVa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.mVn != null) {
            d();
            if (this.mVn.e == 0) {
                a(this.mVn, false);
                return;
            }
            final long j = this.mVn.e;
            this.mVa = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dLd()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.mVn, false);
                }
            }).b(io.reactivex.a.b.a.dKy()).a(io.reactivex.a.b.a.dKy()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.mVn.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.mVn.e);
                    if (a.this.mVo != null) {
                        a.this.mVo.b(a.this.mVn.e);
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
        com.kascend.chushou.c.c.dDV().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet dV = com.kascend.chushou.c.e.dV(jSONObject);
                    if (dV.mRc == 0 && dV.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dV.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) dV.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.mVn != null) {
                            a.this.mVn.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(dV.mRc, dV.mMessage);
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
        if (this.mVo != null) {
            d();
            if (aVar != null) {
                this.mVn = null;
                this.mVo.b(0L);
                this.mVo.b(aVar);
            }
        }
    }
}
