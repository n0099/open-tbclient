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
    private BangInfo myQ;
    private AutoBang myR;
    private final SparseArrayCompat<BangListInfo> myS = new SparseArrayCompat<>();
    private IconConfig.Config myT = new IconConfig.Config();
    private InterfaceC0725a myU;
    private b myV;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0725a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0725a interfaceC0725a) {
        this.myU = interfaceC0725a;
    }

    public void a() {
        this.myT = new IconConfig.Config();
        this.myQ = null;
        this.myR = null;
        this.myS.clear();
        if (this.myV != null) {
            this.myV.dispose();
            this.myV = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.myS.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.myS.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.myT = config;
            if (this.myU != null) {
                this.myU.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.myQ = bangInfo;
            if (this.myU != null) {
                this.myU.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.myR;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.myV != null) {
                        this.myV.dispose();
                        this.myV = null;
                        return;
                    }
                    return;
                } else if (this.myV != null) {
                    this.myV.dispose();
                    this.myV = null;
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
                if (this.myV != null) {
                    this.myV.dispose();
                    this.myV = null;
                    return;
                }
                return;
            }
            if (this.myV != null) {
                this.myV.dispose();
                this.myV = null;
            }
            this.myR = autoBang3;
            this.myV = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dDm()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.myU != null) {
                        a.this.myU.a(0L, a.this.myQ, a.this.d());
                    }
                    a.this.myR = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.myU != null) {
                        a.this.myU.a(0L, a.this.myQ, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dCH()).a(io.reactivex.a.b.a.dCH()).c(io.reactivex.a.b.a.dCH()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.myU != null) {
                        a.this.myU.a(longValue, a.this.myQ, a.this.d());
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

    public IconConfig.Config dyw() {
        return this.myT;
    }

    public String d() {
        if (this.myQ == null) {
            return null;
        }
        return a(this.myQ.mLevel);
    }

    public BangInfo dyx() {
        return this.myQ;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.myS.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
