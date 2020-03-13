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
    private b ncF;
    private c ncS;
    private InterfaceC0705a ncT;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0705a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.ncT = (InterfaceC0705a) activity;
        } catch (Exception e) {
            this.ncT = null;
        }
    }

    public void a() {
        d();
        this.ncS = null;
    }

    public void b() {
        d();
        this.d = null;
        this.ncT = null;
    }

    public void a(c cVar) {
        if (this.ncS != null && this.ncS.p != null && !this.ncS.p.equals(cVar.p)) {
            c cVar2 = this.ncS;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.ncS = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dEb() {
        return this.ncS;
    }

    public H5Positon MT(int i) {
        if (this.ncS == null) {
            return null;
        }
        if (i == 1) {
            return this.ncS.ncN;
        }
        return this.ncS.ncO;
    }

    private void d() {
        if (this.ncF != null) {
            this.ncF.dispose();
            this.ncF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.ncS != null) {
            d();
            if (this.ncS.e == 0) {
                a(this.ncS, false);
                return;
            }
            final long j = this.ncS.e;
            this.ncF = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dJN()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.ncS, false);
                }
            }).b(io.reactivex.a.b.a.dJj()).a(io.reactivex.a.b.a.dJj()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.ncS.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.ncS.e);
                    if (a.this.ncT != null) {
                        a.this.ncT.b(a.this.ncS.e);
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
        com.kascend.chushou.c.c.dBR().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet dL = com.kascend.chushou.c.e.dL(jSONObject);
                    if (dL.mRc == 0 && dL.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) dL.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) dL.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.ncS != null) {
                            a.this.ncS.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(dL.mRc, dL.mMessage);
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
        if (this.ncT != null) {
            d();
            if (aVar != null) {
                this.ncS = null;
                this.ncT.b(0L);
                this.ncT.b(aVar);
            }
        }
    }
}
