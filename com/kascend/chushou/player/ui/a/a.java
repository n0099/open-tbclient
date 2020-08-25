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
    private BangInfo nSE;
    private AutoBang nSF;
    private final SparseArrayCompat<BangListInfo> nSG = new SparseArrayCompat<>();
    private IconConfig.Config nSH = new IconConfig.Config();
    private InterfaceC0892a nSI;
    private b nSJ;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0892a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0892a interfaceC0892a) {
        this.nSI = interfaceC0892a;
    }

    public void a() {
        this.nSH = new IconConfig.Config();
        this.nSE = null;
        this.nSF = null;
        this.nSG.clear();
        if (this.nSJ != null) {
            this.nSJ.dispose();
            this.nSJ = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nSG.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nSG.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nSH = config;
            if (this.nSI != null) {
                this.nSI.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nSE = bangInfo;
            if (this.nSI != null) {
                this.nSI.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nSF;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nSJ != null) {
                        this.nSJ.dispose();
                        this.nSJ = null;
                        return;
                    }
                    return;
                } else if (this.nSJ != null) {
                    this.nSJ.dispose();
                    this.nSJ = null;
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
                if (this.nSJ != null) {
                    this.nSJ.dispose();
                    this.nSJ = null;
                    return;
                }
                return;
            }
            if (this.nSJ != null) {
                this.nSJ.dispose();
                this.nSJ = null;
            }
            this.nSF = autoBang3;
            this.nSJ = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.efA()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nSI != null) {
                        a.this.nSI.a(0L, a.this.nSE, a.this.d());
                    }
                    a.this.nSF = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nSI != null) {
                        a.this.nSI.a(0L, a.this.nSE, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.eeV()).a(io.reactivex.a.b.a.eeV()).c(io.reactivex.a.b.a.eeV()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nSI != null) {
                        a.this.nSI.a(longValue, a.this.nSE, a.this.d());
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

    public IconConfig.Config eah() {
        return this.nSH;
    }

    public String d() {
        if (this.nSE == null) {
            return null;
        }
        return a(this.nSE.mLevel);
    }

    public BangInfo eai() {
        return this.nSE;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nSG.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
