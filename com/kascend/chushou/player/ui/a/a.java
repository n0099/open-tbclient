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
/* loaded from: classes6.dex */
public class a {
    private BangInfo psZ;
    private AutoBang pta;
    private final SparseArrayCompat<BangListInfo> ptb = new SparseArrayCompat<>();
    private IconConfig.Config ptc = new IconConfig.Config();
    private InterfaceC0998a ptd;
    private b pte;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0998a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0998a interfaceC0998a) {
        this.ptd = interfaceC0998a;
    }

    public void a() {
        this.ptc = new IconConfig.Config();
        this.psZ = null;
        this.pta = null;
        this.ptb.clear();
        if (this.pte != null) {
            this.pte.dispose();
            this.pte = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.ptb.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.ptb.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.ptc = config;
            if (this.ptd != null) {
                this.ptd.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.psZ = bangInfo;
            if (this.ptd != null) {
                this.ptd.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.pta;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.pte != null) {
                        this.pte.dispose();
                        this.pte = null;
                        return;
                    }
                    return;
                } else if (this.pte != null) {
                    this.pte.dispose();
                    this.pte = null;
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
                if (this.pte != null) {
                    this.pte.dispose();
                    this.pte = null;
                    return;
                }
                return;
            }
            if (this.pte != null) {
                this.pte.dispose();
                this.pte = null;
            }
            this.pta = autoBang3;
            this.pte = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.eBg()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.ptd != null) {
                        a.this.ptd.a(0L, a.this.psZ, a.this.d());
                    }
                    a.this.pta = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.ptd != null) {
                        a.this.ptd.a(0L, a.this.psZ, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.eAB()).a(io.reactivex.a.b.a.eAB()).c(io.reactivex.a.b.a.eAB()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.ptd != null) {
                        a.this.ptd.a(longValue, a.this.psZ, a.this.d());
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

    public IconConfig.Config evO() {
        return this.ptc;
    }

    public String d() {
        if (this.psZ == null) {
            return null;
        }
        return a(this.psZ.mLevel);
    }

    public BangInfo evP() {
        return this.psZ;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.ptb.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
