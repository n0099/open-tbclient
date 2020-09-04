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
    private b nUW;
    private c nVj;
    private InterfaceC0897a nVk;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0897a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.nVk = (InterfaceC0897a) activity;
        } catch (Exception e) {
            this.nVk = null;
        }
    }

    public void a() {
        d();
        this.nVj = null;
    }

    public void b() {
        d();
        this.d = null;
        this.nVk = null;
    }

    public void a(c cVar) {
        if (this.nVj != null && this.nVj.p != null && !this.nVj.p.equals(cVar.p)) {
            c cVar2 = this.nVj;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.nVj = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c eav() {
        return this.nVj;
    }

    public H5Positon Nl(int i) {
        if (this.nVj == null) {
            return null;
        }
        if (i == 1) {
            return this.nVj.nVe;
        }
        return this.nVj.nVf;
    }

    private void d() {
        if (this.nUW != null) {
            this.nUW.dispose();
            this.nUW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.nVj != null) {
            d();
            if (this.nVj.e == 0) {
                a(this.nVj, false);
                return;
            }
            final long j = this.nVj.e;
            this.nUW = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.efJ()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.nVj, false);
                }
            }).b(io.reactivex.a.b.a.efe()).a(io.reactivex.a.b.a.efe()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.nVj.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.nVj.e);
                    if (a.this.nVk != null) {
                        a.this.nVk.b(a.this.nVj.e);
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
        com.kascend.chushou.c.c.dYv().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
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
                        } else if (a.this.nVj != null) {
                            a.this.nVj.e = longValue;
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
        if (this.nVk != null) {
            d();
            if (aVar != null) {
                this.nVj = null;
                this.nVk.b(0L);
                this.nVk.b(aVar);
            }
        }
    }
}
