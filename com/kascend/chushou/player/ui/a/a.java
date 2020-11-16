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
    private BangInfo puD;
    private AutoBang puE;
    private final SparseArrayCompat<BangListInfo> puF = new SparseArrayCompat<>();
    private IconConfig.Config puG = new IconConfig.Config();
    private InterfaceC1001a puH;
    private b puI;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1001a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC1001a interfaceC1001a) {
        this.puH = interfaceC1001a;
    }

    public void a() {
        this.puG = new IconConfig.Config();
        this.puD = null;
        this.puE = null;
        this.puF.clear();
        if (this.puI != null) {
            this.puI.dispose();
            this.puI = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.puF.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.puF.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.puG = config;
            if (this.puH != null) {
                this.puH.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.puD = bangInfo;
            if (this.puH != null) {
                this.puH.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.puE;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.puI != null) {
                        this.puI.dispose();
                        this.puI = null;
                        return;
                    }
                    return;
                } else if (this.puI != null) {
                    this.puI.dispose();
                    this.puI = null;
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
                if (this.puI != null) {
                    this.puI.dispose();
                    this.puI = null;
                    return;
                }
                return;
            }
            if (this.puI != null) {
                this.puI.dispose();
                this.puI = null;
            }
            this.puE = autoBang3;
            this.puI = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.eBh()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.puH != null) {
                        a.this.puH.a(0L, a.this.puD, a.this.d());
                    }
                    a.this.puE = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.puH != null) {
                        a.this.puH.a(0L, a.this.puD, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.eAC()).a(io.reactivex.a.b.a.eAC()).c(io.reactivex.a.b.a.eAC()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.puH != null) {
                        a.this.puH.a(longValue, a.this.puD, a.this.d());
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
        return this.puG;
    }

    public String d() {
        if (this.puD == null) {
            return null;
        }
        return a(this.puD.mLevel);
    }

    public BangInfo evP() {
        return this.puD;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.puF.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
