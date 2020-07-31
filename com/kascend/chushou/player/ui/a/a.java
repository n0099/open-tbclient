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
    private BangInfo nyN;
    private AutoBang nyO;
    private final SparseArrayCompat<BangListInfo> nyP = new SparseArrayCompat<>();
    private IconConfig.Config nyQ = new IconConfig.Config();
    private InterfaceC0834a nyR;
    private b nyS;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0834a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0834a interfaceC0834a) {
        this.nyR = interfaceC0834a;
    }

    public void a() {
        this.nyQ = new IconConfig.Config();
        this.nyN = null;
        this.nyO = null;
        this.nyP.clear();
        if (this.nyS != null) {
            this.nyS.dispose();
            this.nyS = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nyP.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nyP.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nyQ = config;
            if (this.nyR != null) {
                this.nyR.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nyN = bangInfo;
            if (this.nyR != null) {
                this.nyR.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nyO;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nyS != null) {
                        this.nyS.dispose();
                        this.nyS = null;
                        return;
                    }
                    return;
                } else if (this.nyS != null) {
                    this.nyS.dispose();
                    this.nyS = null;
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
                if (this.nyS != null) {
                    this.nyS.dispose();
                    this.nyS = null;
                    return;
                }
                return;
            }
            if (this.nyS != null) {
                this.nyS.dispose();
                this.nyS = null;
            }
            this.nyO = autoBang3;
            this.nyS = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dTx()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nyR != null) {
                        a.this.nyR.a(0L, a.this.nyN, a.this.d());
                    }
                    a.this.nyO = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nyR != null) {
                        a.this.nyR.a(0L, a.this.nyN, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dSS()).a(io.reactivex.a.b.a.dSS()).c(io.reactivex.a.b.a.dSS()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nyR != null) {
                        a.this.nyR.a(longValue, a.this.nyN, a.this.d());
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

    public IconConfig.Config dOe() {
        return this.nyQ;
    }

    public String d() {
        if (this.nyN == null) {
            return null;
        }
        return a(this.nyN.mLevel);
    }

    public BangInfo dOf() {
        return this.nyN;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nyP.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
