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
    private BangInfo nqd;
    private AutoBang nqe;
    private final SparseArrayCompat<BangListInfo> nqf = new SparseArrayCompat<>();
    private IconConfig.Config nqg = new IconConfig.Config();
    private InterfaceC0825a nqh;
    private b nqi;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0825a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0825a interfaceC0825a) {
        this.nqh = interfaceC0825a;
    }

    public void a() {
        this.nqg = new IconConfig.Config();
        this.nqd = null;
        this.nqe = null;
        this.nqf.clear();
        if (this.nqi != null) {
            this.nqi.dispose();
            this.nqi = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nqf.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nqf.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nqg = config;
            if (this.nqh != null) {
                this.nqh.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nqd = bangInfo;
            if (this.nqh != null) {
                this.nqh.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nqe;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nqi != null) {
                        this.nqi.dispose();
                        this.nqi = null;
                        return;
                    }
                    return;
                } else if (this.nqi != null) {
                    this.nqi.dispose();
                    this.nqi = null;
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
                if (this.nqi != null) {
                    this.nqi.dispose();
                    this.nqi = null;
                    return;
                }
                return;
            }
            if (this.nqi != null) {
                this.nqi.dispose();
                this.nqi = null;
            }
            this.nqe = autoBang3;
            this.nqi = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dQb()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nqh != null) {
                        a.this.nqh.a(0L, a.this.nqd, a.this.d());
                    }
                    a.this.nqe = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nqh != null) {
                        a.this.nqh.a(0L, a.this.nqd, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dPw()).a(io.reactivex.a.b.a.dPw()).c(io.reactivex.a.b.a.dPw()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nqh != null) {
                        a.this.nqh.a(longValue, a.this.nqd, a.this.d());
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

    public IconConfig.Config dKJ() {
        return this.nqg;
    }

    public String d() {
        if (this.nqd == null) {
            return null;
        }
        return a(this.nqd.mLevel);
    }

    public BangInfo dKK() {
        return this.nqd;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nqf.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
