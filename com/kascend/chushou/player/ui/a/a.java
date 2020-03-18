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
    private BangInfo ncp;
    private AutoBang ncq;
    private final SparseArrayCompat<BangListInfo> ncr = new SparseArrayCompat<>();
    private IconConfig.Config ncs = new IconConfig.Config();
    private InterfaceC0701a nct;
    private b ncu;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0701a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0701a interfaceC0701a) {
        this.nct = interfaceC0701a;
    }

    public void a() {
        this.ncs = new IconConfig.Config();
        this.ncp = null;
        this.ncq = null;
        this.ncr.clear();
        if (this.ncu != null) {
            this.ncu.dispose();
            this.ncu = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.ncr.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.ncr.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.ncs = config;
            if (this.nct != null) {
                this.nct.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.ncp = bangInfo;
            if (this.nct != null) {
                this.nct.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.ncq;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.ncu != null) {
                        this.ncu.dispose();
                        this.ncu = null;
                        return;
                    }
                    return;
                } else if (this.ncu != null) {
                    this.ncu.dispose();
                    this.ncu = null;
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
                if (this.ncu != null) {
                    this.ncu.dispose();
                    this.ncu = null;
                    return;
                }
                return;
            }
            if (this.ncu != null) {
                this.ncu.dispose();
                this.ncu = null;
            }
            this.ncq = autoBang3;
            this.ncu = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dKn()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nct != null) {
                        a.this.nct.a(0L, a.this.ncp, a.this.d());
                    }
                    a.this.ncq = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nct != null) {
                        a.this.nct.a(0L, a.this.ncp, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dJJ()).a(io.reactivex.a.b.a.dJJ()).c(io.reactivex.a.b.a.dJJ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nct != null) {
                        a.this.nct.a(longValue, a.this.ncp, a.this.d());
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

    public IconConfig.Config dEw() {
        return this.ncs;
    }

    public String d() {
        if (this.ncp == null) {
            return null;
        }
        return a(this.ncp.mLevel);
    }

    public BangInfo dEx() {
        return this.ncp;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.ncr.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
