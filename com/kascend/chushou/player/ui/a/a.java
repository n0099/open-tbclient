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
    private BangInfo nSW;
    private AutoBang nSX;
    private final SparseArrayCompat<BangListInfo> nSY = new SparseArrayCompat<>();
    private IconConfig.Config nSZ = new IconConfig.Config();
    private InterfaceC0892a nTa;
    private b nTb;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0892a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0892a interfaceC0892a) {
        this.nTa = interfaceC0892a;
    }

    public void a() {
        this.nSZ = new IconConfig.Config();
        this.nSW = null;
        this.nSX = null;
        this.nSY.clear();
        if (this.nTb != null) {
            this.nTb.dispose();
            this.nTb = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.nSY.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.nSY.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.nSZ = config;
            if (this.nTa != null) {
                this.nTa.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.nSW = bangInfo;
            if (this.nTa != null) {
                this.nTa.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.nSX;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.nTb != null) {
                        this.nTb.dispose();
                        this.nTb = null;
                        return;
                    }
                    return;
                } else if (this.nTb != null) {
                    this.nTb.dispose();
                    this.nTb = null;
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
                if (this.nTb != null) {
                    this.nTb.dispose();
                    this.nTb = null;
                    return;
                }
                return;
            }
            if (this.nTb != null) {
                this.nTb.dispose();
                this.nTb = null;
            }
            this.nSX = autoBang3;
            this.nTb = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.efJ()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nTa != null) {
                        a.this.nTa.a(0L, a.this.nSW, a.this.d());
                    }
                    a.this.nSX = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.nTa != null) {
                        a.this.nTa.a(0L, a.this.nSW, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.efe()).a(io.reactivex.a.b.a.efe()).c(io.reactivex.a.b.a.efe()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.nTa != null) {
                        a.this.nTa.a(longValue, a.this.nSW, a.this.d());
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

    public IconConfig.Config eaq() {
        return this.nSZ;
    }

    public String d() {
        if (this.nSW == null) {
            return null;
        }
        return a(this.nSW.mLevel);
    }

    public BangInfo ear() {
        return this.nSW;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.nSY.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
