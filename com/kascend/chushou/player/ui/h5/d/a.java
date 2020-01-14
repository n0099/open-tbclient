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
/* loaded from: classes4.dex */
public class a {
    private Activity d;
    private b nbP;
    private c ncc;
    private InterfaceC0697a ncd;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0697a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.ncd = (InterfaceC0697a) activity;
        } catch (Exception e) {
            this.ncd = null;
        }
    }

    public void a() {
        d();
        this.ncc = null;
    }

    public void b() {
        d();
        this.d = null;
        this.ncd = null;
    }

    public void a(c cVar) {
        if (this.ncc != null && this.ncc.p != null && !this.ncc.p.equals(cVar.p)) {
            c cVar2 = this.ncc;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.ncc = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dCS() {
        return this.ncc;
    }

    public H5Positon MQ(int i) {
        if (this.ncc == null) {
            return null;
        }
        if (i == 1) {
            return this.ncc.nbX;
        }
        return this.ncc.nbY;
    }

    private void d() {
        if (this.nbP != null) {
            this.nbP.dispose();
            this.nbP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.ncc != null) {
            d();
            if (this.ncc.e == 0) {
                a(this.ncc, false);
                return;
            }
            final long j = this.ncc.e;
            this.nbP = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dID()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.ncc, false);
                }
            }).b(io.reactivex.a.b.a.dHZ()).a(io.reactivex.a.b.a.dHZ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.ncc.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.ncc.e);
                    if (a.this.ncd != null) {
                        a.this.ncd.b(a.this.ncc.e);
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
        com.kascend.chushou.c.c.dAI().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
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
                        } else if (a.this.ncc != null) {
                            a.this.ncc.e = longValue;
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
        if (this.ncd != null) {
            d();
            if (aVar != null) {
                this.ncc = null;
                this.ncd.b(0L);
                this.ncd.b(aVar);
            }
        }
    }
}
