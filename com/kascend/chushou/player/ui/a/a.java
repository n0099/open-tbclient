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
    private BangInfo nar;
    private AutoBang nas;
    private final SparseArrayCompat<BangListInfo> nat = new SparseArrayCompat<>();
    private IconConfig.Config nau = new IconConfig.Config();
    private InterfaceC0700a nav;
    private b naw;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0700a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0700a interfaceC0700a) {
        this.nav = interfaceC0700a;
    }

    public void a() {
        this.nau = new IconConfig.Config();
        this.nar = null;
        this.nas = null;
        this.nat.clear();
        if (this.naw != null) {
            this.naw.dispose();
            this.naw = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nat.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nat.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nau = config;
            if (this.nav != null) {
                this.nav.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nar = bangInfo;
            if (this.nav != null) {
                this.nav.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nas;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.naw != null) {
                        this.naw.dispose();
                        this.naw = null;
                        return;
                    }
                    return;
                } else if (this.naw != null) {
                    this.naw.dispose();
                    this.naw = null;
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
                if (this.naw != null) {
                    this.naw.dispose();
                    this.naw = null;
                    return;
                }
                return;
            }
            if (this.naw != null) {
                this.naw.dispose();
                this.naw = null;
            }
            this.nas = autoBang3;
            this.naw = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dJK()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nav != null) {
                        a.this.nav.a(0L, a.this.nar, a.this.d());
                    }
                    a.this.nas = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nav != null) {
                        a.this.nav.a(0L, a.this.nar, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dJg()).a(io.reactivex.a.b.a.dJg()).c(io.reactivex.a.b.a.dJg()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nav != null) {
                        a.this.nav.a(longValue, a.this.nar, a.this.d());
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

    public IconConfig.Config dDT() {
        return this.nau;
    }

    public String d() {
        if (this.nar == null) {
            return null;
        }
        return a(this.nar.mLevel);
    }

    public BangInfo dDU() {
        return this.nar;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nat.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
