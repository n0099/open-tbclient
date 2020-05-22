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
    private BangInfo mSW;
    private AutoBang mSX;
    private final SparseArrayCompat<BangListInfo> mSY = new SparseArrayCompat<>();
    private IconConfig.Config mSZ = new IconConfig.Config();
    private InterfaceC0804a mTa;
    private b mTb;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0804a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0804a interfaceC0804a) {
        this.mTa = interfaceC0804a;
    }

    public void a() {
        this.mSZ = new IconConfig.Config();
        this.mSW = null;
        this.mSX = null;
        this.mSY.clear();
        if (this.mTb != null) {
            this.mTb.dispose();
            this.mTb = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.mSY.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.mSY.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.mSZ = config;
            if (this.mTa != null) {
                this.mTa.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.mSW = bangInfo;
            if (this.mTa != null) {
                this.mTa.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.mSX;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.mTb != null) {
                        this.mTb.dispose();
                        this.mTb = null;
                        return;
                    }
                    return;
                } else if (this.mTb != null) {
                    this.mTb.dispose();
                    this.mTb = null;
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
                if (this.mTb != null) {
                    this.mTb.dispose();
                    this.mTb = null;
                    return;
                }
                return;
            }
            if (this.mTb != null) {
                this.mTb.dispose();
                this.mTb = null;
            }
            this.mSX = autoBang3;
            this.mTb = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dLd()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mTa != null) {
                        a.this.mTa.a(0L, a.this.mSW, a.this.d());
                    }
                    a.this.mSX = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mTa != null) {
                        a.this.mTa.a(0L, a.this.mSW, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dKy()).a(io.reactivex.a.b.a.dKy()).c(io.reactivex.a.b.a.dKy()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.mTa != null) {
                        a.this.mTa.a(longValue, a.this.mSW, a.this.d());
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

    public IconConfig.Config dFL() {
        return this.mSZ;
    }

    public String d() {
        if (this.mSW == null) {
            return null;
        }
        return a(this.mSW.mLevel);
    }

    public BangInfo dFM() {
        return this.mSW;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.mSY.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
