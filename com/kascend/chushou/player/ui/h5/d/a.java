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
    private b nse;
    private c nsr;
    private InterfaceC0830a nss;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0830a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.nss = (InterfaceC0830a) activity;
        } catch (Exception e) {
            this.nss = null;
        }
    }

    public void a() {
        d();
        this.nsr = null;
    }

    public void b() {
        d();
        this.d = null;
        this.nss = null;
    }

    public void a(c cVar) {
        if (this.nsr != null && this.nsr.p != null && !this.nsr.p.equals(cVar.p)) {
            c cVar2 = this.nsr;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.nsr = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c dKO() {
        return this.nsr;
    }

    public H5Positon Kn(int i) {
        if (this.nsr == null) {
            return null;
        }
        if (i == 1) {
            return this.nsr.nsm;
        }
        return this.nsr.nsn;
    }

    private void d() {
        if (this.nse != null) {
            this.nse.dispose();
            this.nse = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.nsr != null) {
            d();
            if (this.nsr.e == 0) {
                a(this.nsr, false);
                return;
            }
            final long j = this.nsr.e;
            this.nse = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dQb()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.nsr, false);
                }
            }).b(io.reactivex.a.b.a.dPw()).a(io.reactivex.a.b.a.dPw()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.nsr.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.nsr.e);
                    if (a.this.nss != null) {
                        a.this.nss.b(a.this.nsr.e);
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
        com.kascend.chushou.c.c.dIP().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet ef = com.kascend.chushou.c.e.ef(jSONObject);
                    if (ef.mRc == 0 && ef.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) ef.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) ef.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.nsr != null) {
                            a.this.nsr.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(ef.mRc, ef.mMessage);
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
        if (this.nss != null) {
            d();
            if (aVar != null) {
                this.nsr = null;
                this.nss.b(0L);
                this.nss.b(aVar);
            }
        }
    }
}
