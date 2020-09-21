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
    private BangInfo ocR;
    private AutoBang ocS;
    private final SparseArrayCompat<BangListInfo> ocT = new SparseArrayCompat<>();
    private IconConfig.Config ocU = new IconConfig.Config();
    private InterfaceC0889a ocV;
    private b ocW;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0889a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0889a interfaceC0889a) {
        this.ocV = interfaceC0889a;
    }

    public void a() {
        this.ocU = new IconConfig.Config();
        this.ocR = null;
        this.ocS = null;
        this.ocT.clear();
        if (this.ocW != null) {
            this.ocW.dispose();
            this.ocW = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.ocT.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.ocT.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.ocU = config;
            if (this.ocV != null) {
                this.ocV.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.ocR = bangInfo;
            if (this.ocV != null) {
                this.ocV.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.ocS;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.ocW != null) {
                        this.ocW.dispose();
                        this.ocW = null;
                        return;
                    }
                    return;
                } else if (this.ocW != null) {
                    this.ocW.dispose();
                    this.ocW = null;
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
                if (this.ocW != null) {
                    this.ocW.dispose();
                    this.ocW = null;
                    return;
                }
                return;
            }
            if (this.ocW != null) {
                this.ocW.dispose();
                this.ocW = null;
            }
            this.ocS = autoBang3;
            this.ocW = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.ejG()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.ocV != null) {
                        a.this.ocV.a(0L, a.this.ocR, a.this.d());
                    }
                    a.this.ocS = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.ocV != null) {
                        a.this.ocV.a(0L, a.this.ocR, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.ejb()).a(io.reactivex.a.b.a.ejb()).c(io.reactivex.a.b.a.ejb()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.ocV != null) {
                        a.this.ocV.a(longValue, a.this.ocR, a.this.d());
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

    public IconConfig.Config eeo() {
        return this.ocU;
    }

    public String d() {
        if (this.ocR == null) {
            return null;
        }
        return a(this.ocR.mLevel);
    }

    public BangInfo eep() {
        return this.ocR;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.ocT.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
