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
    private BangInfo nqa;
    private AutoBang nqb;
    private final SparseArrayCompat<BangListInfo> nqc = new SparseArrayCompat<>();
    private IconConfig.Config nqd = new IconConfig.Config();
    private InterfaceC0824a nqe;
    private b nqf;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0824a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0824a interfaceC0824a) {
        this.nqe = interfaceC0824a;
    }

    public void a() {
        this.nqd = new IconConfig.Config();
        this.nqa = null;
        this.nqb = null;
        this.nqc.clear();
        if (this.nqf != null) {
            this.nqf.dispose();
            this.nqf = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nqc.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nqc.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nqd = config;
            if (this.nqe != null) {
                this.nqe.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nqa = bangInfo;
            if (this.nqe != null) {
                this.nqe.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nqb;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nqf != null) {
                        this.nqf.dispose();
                        this.nqf = null;
                        return;
                    }
                    return;
                } else if (this.nqf != null) {
                    this.nqf.dispose();
                    this.nqf = null;
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
                if (this.nqf != null) {
                    this.nqf.dispose();
                    this.nqf = null;
                    return;
                }
                return;
            }
            if (this.nqf != null) {
                this.nqf.dispose();
                this.nqf = null;
            }
            this.nqb = autoBang3;
            this.nqf = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dPX()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nqe != null) {
                        a.this.nqe.a(0L, a.this.nqa, a.this.d());
                    }
                    a.this.nqb = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nqe != null) {
                        a.this.nqe.a(0L, a.this.nqa, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dPs()).a(io.reactivex.a.b.a.dPs()).c(io.reactivex.a.b.a.dPs()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nqe != null) {
                        a.this.nqe.a(longValue, a.this.nqa, a.this.d());
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

    public IconConfig.Config dKF() {
        return this.nqd;
    }

    public String d() {
        if (this.nqa == null) {
            return null;
        }
        return a(this.nqa.mLevel);
    }

    public BangInfo dKG() {
        return this.nqa;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nqc.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
