package com.kascend.chushou.player.ui.a;

import android.support.v4.util.SparseArrayCompat;
import com.kascend.chushou.constants.AutoBang;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.BangListInfo;
import com.kascend.chushou.constants.IconConfig;
import io.reactivex.disposables.b;
import io.reactivex.g;
import java.util.concurrent.TimeUnit;
import tv.chushou.zues.utils.e;
/* loaded from: classes4.dex */
public class a {
    private BangInfo mZO;
    private AutoBang mZP;
    private final SparseArrayCompat<BangListInfo> mZQ = new SparseArrayCompat<>();
    private IconConfig.Config mZR = new IconConfig.Config();
    private InterfaceC0692a mZS;
    private b mZT;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0692a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0692a interfaceC0692a) {
        this.mZS = interfaceC0692a;
    }

    public void a() {
        this.mZR = new IconConfig.Config();
        this.mZO = null;
        this.mZP = null;
        this.mZQ.clear();
        if (this.mZT != null) {
            this.mZT.dispose();
            this.mZT = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.mZQ.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.mZQ.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.mZR = config;
            if (this.mZS != null) {
                this.mZS.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.mZO = bangInfo;
            if (this.mZS != null) {
                this.mZS.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.mZP;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.mZT != null) {
                        this.mZT.dispose();
                        this.mZT = null;
                        return;
                    }
                    return;
                } else if (this.mZT != null) {
                    this.mZT.dispose();
                    this.mZT = null;
                    return;
                } else {
                    return;
                }
            }
            AutoBang autoBang3 = new AutoBang();
            if (autoBang2 != null) {
                autoBang3.bangTime = Math.max(autoBang2.bangTime, autoBang.bangTime);
                autoBang3.currentTime = Math.max(autoBang2.currentTime, autoBang.currentTime);
            } else {
                autoBang3.currentTime = autoBang.currentTime;
                autoBang3.bangTime = autoBang.bangTime;
            }
            final long j = (autoBang3.bangTime - autoBang3.currentTime) / 1000;
            if (j <= 0) {
                if (this.mZT != null) {
                    this.mZT.dispose();
                    this.mZT = null;
                    return;
                }
                return;
            }
            if (this.mZT != null) {
                this.mZT.dispose();
                this.mZT = null;
            }
            this.mZP = autoBang3;
            this.mZT = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dID()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mZS != null) {
                        a.this.mZS.a(0L, a.this.mZO, a.this.d());
                    }
                    a.this.mZP = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mZS != null) {
                        a.this.mZS.a(0L, a.this.mZO, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dHZ()).a(io.reactivex.a.b.a.dHZ()).c(io.reactivex.a.b.a.dHZ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.mZS != null) {
                        a.this.mZS.a(longValue, a.this.mZO, a.this.d());
                    }
                }
            }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.ui.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Throwable th) throws Exception {
                    e.e("BangController", "", th);
                }
            });
        }
    }

    public IconConfig.Config dCN() {
        return this.mZR;
    }

    public String d() {
        if (this.mZO == null) {
            return null;
        }
        return a(this.mZO.mLevel);
    }

    public BangInfo dCO() {
        return this.mZO;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.mZQ.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
