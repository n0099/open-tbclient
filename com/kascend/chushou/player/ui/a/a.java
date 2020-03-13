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
/* loaded from: classes5.dex */
public class a {
    private BangInfo naE;
    private AutoBang naF;
    private final SparseArrayCompat<BangListInfo> naG = new SparseArrayCompat<>();
    private IconConfig.Config naH = new IconConfig.Config();
    private InterfaceC0700a naI;
    private b naJ;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0700a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0700a interfaceC0700a) {
        this.naI = interfaceC0700a;
    }

    public void a() {
        this.naH = new IconConfig.Config();
        this.naE = null;
        this.naF = null;
        this.naG.clear();
        if (this.naJ != null) {
            this.naJ.dispose();
            this.naJ = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.naG.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.naG.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.naH = config;
            if (this.naI != null) {
                this.naI.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.naE = bangInfo;
            if (this.naI != null) {
                this.naI.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.naF;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.naJ != null) {
                        this.naJ.dispose();
                        this.naJ = null;
                        return;
                    }
                    return;
                } else if (this.naJ != null) {
                    this.naJ.dispose();
                    this.naJ = null;
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
                if (this.naJ != null) {
                    this.naJ.dispose();
                    this.naJ = null;
                    return;
                }
                return;
            }
            if (this.naJ != null) {
                this.naJ.dispose();
                this.naJ = null;
            }
            this.naF = autoBang3;
            this.naJ = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dJN()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.naI != null) {
                        a.this.naI.a(0L, a.this.naE, a.this.d());
                    }
                    a.this.naF = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.naI != null) {
                        a.this.naI.a(0L, a.this.naE, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dJj()).a(io.reactivex.a.b.a.dJj()).c(io.reactivex.a.b.a.dJj()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.naI != null) {
                        a.this.naI.a(longValue, a.this.naE, a.this.d());
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

    public IconConfig.Config dDW() {
        return this.naH;
    }

    public String d() {
        if (this.naE == null) {
            return null;
        }
        return a(this.naE.mLevel);
    }

    public BangInfo dDX() {
        return this.naE;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.naG.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
