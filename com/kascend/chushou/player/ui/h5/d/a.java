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
    private b ouj;
    private c oux;
    private InterfaceC0912a ouy;

    /* renamed from: com.kascend.chushou.player.ui.h5.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0912a {
        void b(long j);

        void b(com.kascend.chushou.player.ui.h5.c.a aVar);
    }

    public a(Activity activity) {
        this.d = activity;
        try {
            this.ouy = (InterfaceC0912a) activity;
        } catch (Exception e) {
            this.ouy = null;
        }
    }

    public void a() {
        d();
        this.oux = null;
    }

    public void b() {
        d();
        this.d = null;
        this.ouy = null;
    }

    public void a(c cVar) {
        if (this.oux != null && this.oux.p != null && !this.oux.p.equals(cVar.p)) {
            c cVar2 = this.oux;
            a((com.kascend.chushou.player.ui.h5.c.a) null);
            a(cVar2, true);
        }
        this.oux = cVar;
        e.d("VoteController", "投票开始计时，剩下时间：" + cVar.e);
        e();
    }

    public c eie() {
        return this.oux;
    }

    public H5Positon Ow(int i) {
        if (this.oux == null) {
            return null;
        }
        if (i == 1) {
            return this.oux.our;
        }
        return this.oux.ous;
    }

    private void d() {
        if (this.ouj != null) {
            this.ouj.dispose();
            this.ouj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.oux != null) {
            d();
            if (this.oux.e == 0) {
                a(this.oux, false);
                return;
            }
            final long j = this.oux.e;
            this.ouj = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.ens()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.h5.d.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    e.d("VoteController", "投票计时结束");
                    a.this.a((com.kascend.chushou.player.ui.h5.c.a) null);
                    a.this.a(a.this.oux, false);
                }
            }).b(io.reactivex.a.b.a.emM()).a(io.reactivex.a.b.a.emM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.h5.d.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    a.this.oux.e = j - l.longValue();
                    e.d("VoteController", "投票计时：" + a.this.oux.e);
                    if (a.this.ouy != null) {
                        a.this.ouy.b(a.this.oux.e);
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
        com.kascend.chushou.c.c.ege().d(cVar.f, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.h5.d.a.4
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!a.this.f()) {
                    ParserRet eJ = com.kascend.chushou.c.e.eJ(jSONObject);
                    if (eJ.mRc == 0 && eJ.mData != null) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) eJ.mData;
                        if (z) {
                            a.this.a(aVar);
                            return;
                        }
                        long longValue = ((Long) eJ.mData1).longValue();
                        e.d("VoteController", "投票计时查询剩下：" + longValue);
                        if (longValue <= 0) {
                            a.this.a(aVar);
                            return;
                        } else if (a.this.oux != null) {
                            a.this.oux.e = longValue;
                            a.this.e();
                            return;
                        } else {
                            return;
                        }
                    }
                    a(eJ.mRc, eJ.mMessage);
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
        if (this.ouy != null) {
            d();
            if (aVar != null) {
                this.oux = null;
                this.ouy.b(0L);
                this.ouy.b(aVar);
            }
        }
    }
}
