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
    private b nUE;
    private c nUR;
    private InterfaceC0897a nUS;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0897a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.nUS = (InterfaceC0897a) activity;
        } catch (Exception e) {
            this.nUS = null;
        }
    }

    public void a() {
        d();
        this.nUR = null;
    }

    public void b() {
        d();
        this.d = null;
        this.nUS = null;
    }

    public void a(c cVar) {
        if (this.nUR != null && this.nUR.p != null && !this.nUR.p.equals(cVar.p)) {
            c cVar2 = this.nUR;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.nUR = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c eam() {
        return this.nUR;
    }

    public H5Positon Nl(int i) {
        if (this.nUR == null) {
            return null;
        }
        if (i == 1) {
            return this.nUR.nUM;
        }
        return this.nUR.nUN;
    }

    private void d() {
        if (this.nUE != null) {
            this.nUE.dispose();
            this.nUE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.nUR != null) {
            d();
            if (this.nUR.e == 0) {
                a(this.nUR, false);
                return;
            }
            final long j = this.nUR.e;
            this.nUE = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.efA()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.nUR, false);
                }
            }).b(io.reactivex.a.b.a.eeV()).a(io.reactivex.a.b.a.eeV()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.nUR.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.nUR.e);
                    if (a.this.nUS != null) {
                        a.this.nUS.b(a.this.nUR.e);
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
        com.kascend.chushou.c.c.dYm().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet ex = com.kascend.chushou.c.e.ex(jSONObject);
                    if (ex.mRc == 0 && ex.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) ex.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) ex.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.nUR != null) {
                            a.this.nUR.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(ex.mRc, ex.mMessage);
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
        if (this.nUS != null) {
            d();
            if (aVar != null) {
                this.nUR = null;
                this.nUS.b(0L);
                this.nUS.b(aVar);
            }
        }
    }
}
