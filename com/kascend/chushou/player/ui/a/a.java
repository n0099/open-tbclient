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
/* loaded from: classes4.dex */
public class a {
    private BangInfo mZJ;
    private AutoBang mZK;
    private final SparseArrayCompat<BangListInfo> mZL = new SparseArrayCompat<>();
    private IconConfig.Config mZM = new IconConfig.Config();
    private InterfaceC0692a mZN;
    private b mZO;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0692a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0692a interfaceC0692a) {
        this.mZN = interfaceC0692a;
    }

    public void a() {
        this.mZM = new IconConfig.Config();
        this.mZJ = null;
        this.mZK = null;
        this.mZL.clear();
        if (this.mZO != null) {
            this.mZO.dispose();
            this.mZO = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.mZL.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.mZL.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.mZM = config;
            if (this.mZN != null) {
                this.mZN.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.mZJ = bangInfo;
            if (this.mZN != null) {
                this.mZN.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.mZK;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.mZO != null) {
                        this.mZO.dispose();
                        this.mZO = null;
                        return;
                    }
                    return;
                } else if (this.mZO != null) {
                    this.mZO.dispose();
                    this.mZO = null;
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
                if (this.mZO != null) {
                    this.mZO.dispose();
                    this.mZO = null;
                    return;
                }
                return;
            }
            if (this.mZO != null) {
                this.mZO.dispose();
                this.mZO = null;
            }
            this.mZK = autoBang3;
            this.mZO = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dIB()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mZN != null) {
                        a.this.mZN.a(0L, a.this.mZJ, a.this.d());
                    }
                    a.this.mZK = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mZN != null) {
                        a.this.mZN.a(0L, a.this.mZJ, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dHX()).a(io.reactivex.a.b.a.dHX()).c(io.reactivex.a.b.a.dHX()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.mZN != null) {
                        a.this.mZN.a(longValue, a.this.mZJ, a.this.d());
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

    public IconConfig.Config dCL() {
        return this.mZM;
    }

    public String d() {
        if (this.mZJ == null) {
            return null;
        }
        return a(this.mZJ.mLevel);
    }

    public BangInfo dCM() {
        return this.mZJ;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.mZL.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
