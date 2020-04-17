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
    private b mAR;
    private c mBe;
    private InterfaceC0730a mBf;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0730a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.mBf = (InterfaceC0730a) activity;
        } catch (Exception e) {
            this.mBf = null;
        }
    }

    public void a() {
        d();
        this.mBe = null;
    }

    public void b() {
        d();
        this.d = null;
        this.mBf = null;
    }

    public void a(c cVar) {
        if (this.mBe != null && this.mBe.p != null && !this.mBe.p.equals(cVar.p)) {
            c cVar2 = this.mBe;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.mBe = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dyB() {
        return this.mBe;
    }

    public H5Positon It(int i) {
        if (this.mBe == null) {
            return null;
        }
        if (i == 1) {
            return this.mBe.mAZ;
        }
        return this.mBe.mBa;
    }

    private void d() {
        if (this.mAR != null) {
            this.mAR.dispose();
            this.mAR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.mBe != null) {
            d();
            if (this.mBe.e == 0) {
                a(this.mBe, false);
                return;
            }
            final long j = this.mBe.e;
            this.mAR = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dDm()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.mBe, false);
                }
            }).b(io.reactivex.a.b.a.dCH()).a(io.reactivex.a.b.a.dCH()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.mBe.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.mBe.e);
                    if (a.this.mBf != null) {
                        a.this.mBf.b(a.this.mBe.e);
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
        com.kascend.chushou.c.c.dwG().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet dO = com.kascend.chushou.c.e.dO(jSONObject);
                    if (dO.mRc == 0 && dO.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dO.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) dO.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.mBe != null) {
                            a.this.mBe.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(dO.mRc, dO.mMessage);
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
        if (this.mBf != null) {
            d();
            if (aVar != null) {
                this.mBe = null;
                this.mBf.b(0L);
                this.mBf.b(aVar);
            }
        }
    }
}
