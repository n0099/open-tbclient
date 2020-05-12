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
    private b mAW;
    private c mBk;
    private InterfaceC0751a mBl;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0751a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.mBl = (InterfaceC0751a) activity;
        } catch (Exception e) {
            this.mBl = null;
        }
    }

    public void a() {
        d();
        this.mBk = null;
    }

    public void b() {
        d();
        this.d = null;
        this.mBl = null;
    }

    public void a(c cVar) {
        if (this.mBk != null && this.mBk.p != null && !this.mBk.p.equals(cVar.p)) {
            c cVar2 = this.mBk;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.mBk = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dyy() {
        return this.mBk;
    }

    public H5Positon It(int i) {
        if (this.mBk == null) {
            return null;
        }
        if (i == 1) {
            return this.mBk.mBe;
        }
        return this.mBk.mBf;
    }

    private void d() {
        if (this.mAW != null) {
            this.mAW.dispose();
            this.mAW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.mBk != null) {
            d();
            if (this.mBk.e == 0) {
                a(this.mBk, false);
                return;
            }
            final long j = this.mBk.e;
            this.mAW = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dDj()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.mBk, false);
                }
            }).b(io.reactivex.a.b.a.dCE()).a(io.reactivex.a.b.a.dCE()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.mBk.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.mBk.e);
                    if (a.this.mBl != null) {
                        a.this.mBl.b(a.this.mBk.e);
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
        com.kascend.chushou.c.c.dwE().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
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
                        } else if (a.this.mBk != null) {
                            a.this.mBk.e = longValue;
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
        if (this.mBl != null) {
            d();
            if (aVar != null) {
                this.mBk = null;
                this.mBl.b(0L);
                this.mBl.b(aVar);
            }
        }
    }
}
