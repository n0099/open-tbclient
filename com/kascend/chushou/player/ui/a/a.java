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
    private BangInfo pjB;
    private AutoBang pjC;
    private final SparseArrayCompat<BangListInfo> pjD = new SparseArrayCompat<>();
    private IconConfig.Config pjE = new IconConfig.Config();
    private InterfaceC0979a pjF;
    private b pjG;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0979a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0979a interfaceC0979a) {
        this.pjF = interfaceC0979a;
    }

    public void a() {
        this.pjE = new IconConfig.Config();
        this.pjB = null;
        this.pjC = null;
        this.pjD.clear();
        if (this.pjG != null) {
            this.pjG.dispose();
            this.pjG = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.pjD.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.pjD.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.pjE = config;
            if (this.pjF != null) {
                this.pjF.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.pjB = bangInfo;
            if (this.pjF != null) {
                this.pjF.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.pjC;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.pjG != null) {
                        this.pjG.dispose();
                        this.pjG = null;
                        return;
                    }
                    return;
                } else if (this.pjG != null) {
                    this.pjG.dispose();
                    this.pjG = null;
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
                if (this.pjG != null) {
                    this.pjG.dispose();
                    this.pjG = null;
                    return;
                }
                return;
            }
            if (this.pjG != null) {
                this.pjG.dispose();
                this.pjG = null;
            }
            this.pjC = autoBang3;
            this.pjG = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.exr()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.pjF != null) {
                        a.this.pjF.a(0L, a.this.pjB, a.this.d());
                    }
                    a.this.pjC = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.pjF != null) {
                        a.this.pjF.a(0L, a.this.pjB, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.ewM()).a(io.reactivex.a.b.a.ewM()).c(io.reactivex.a.b.a.ewM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.pjF != null) {
                        a.this.pjF.a(longValue, a.this.pjB, a.this.d());
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

    public IconConfig.Config erZ() {
        return this.pjE;
    }

    public String d() {
        if (this.pjB == null) {
            return null;
        }
        return a(this.pjB.mLevel);
    }

    public BangInfo esa() {
        return this.pjB;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.pjD.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
