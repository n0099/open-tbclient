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
    private BangInfo nyP;
    private AutoBang nyQ;
    private final SparseArrayCompat<BangListInfo> nyR = new SparseArrayCompat<>();
    private IconConfig.Config nyS = new IconConfig.Config();
    private InterfaceC0834a nyT;
    private b nyU;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0834a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0834a interfaceC0834a) {
        this.nyT = interfaceC0834a;
    }

    public void a() {
        this.nyS = new IconConfig.Config();
        this.nyP = null;
        this.nyQ = null;
        this.nyR.clear();
        if (this.nyU != null) {
            this.nyU.dispose();
            this.nyU = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nyR.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nyR.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nyS = config;
            if (this.nyT != null) {
                this.nyT.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nyP = bangInfo;
            if (this.nyT != null) {
                this.nyT.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nyQ;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nyU != null) {
                        this.nyU.dispose();
                        this.nyU = null;
                        return;
                    }
                    return;
                } else if (this.nyU != null) {
                    this.nyU.dispose();
                    this.nyU = null;
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
                if (this.nyU != null) {
                    this.nyU.dispose();
                    this.nyU = null;
                    return;
                }
                return;
            }
            if (this.nyU != null) {
                this.nyU.dispose();
                this.nyU = null;
            }
            this.nyQ = autoBang3;
            this.nyU = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dTy()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nyT != null) {
                        a.this.nyT.a(0L, a.this.nyP, a.this.d());
                    }
                    a.this.nyQ = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nyT != null) {
                        a.this.nyT.a(0L, a.this.nyP, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dST()).a(io.reactivex.a.b.a.dST()).c(io.reactivex.a.b.a.dST()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nyT != null) {
                        a.this.nyT.a(longValue, a.this.nyP, a.this.d());
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

    public IconConfig.Config dOf() {
        return this.nyS;
    }

    public String d() {
        if (this.nyP == null) {
            return null;
        }
        return a(this.nyP.mLevel);
    }

    public BangInfo dOg() {
        return this.nyP;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nyR.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
