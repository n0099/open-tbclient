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
    private BangInfo myV;
    private AutoBang myW;
    private final SparseArrayCompat<BangListInfo> myX = new SparseArrayCompat<>();
    private IconConfig.Config myY = new IconConfig.Config();
    private InterfaceC0746a myZ;
    private b mza;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0746a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0746a interfaceC0746a) {
        this.myZ = interfaceC0746a;
    }

    public void a() {
        this.myY = new IconConfig.Config();
        this.myV = null;
        this.myW = null;
        this.myX.clear();
        if (this.mza != null) {
            this.mza.dispose();
            this.mza = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.myX.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.myX.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.myY = config;
            if (this.myZ != null) {
                this.myZ.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.myV = bangInfo;
            if (this.myZ != null) {
                this.myZ.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.myW;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.mza != null) {
                        this.mza.dispose();
                        this.mza = null;
                        return;
                    }
                    return;
                } else if (this.mza != null) {
                    this.mza.dispose();
                    this.mza = null;
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
                if (this.mza != null) {
                    this.mza.dispose();
                    this.mza = null;
                    return;
                }
                return;
            }
            if (this.mza != null) {
                this.mza.dispose();
                this.mza = null;
            }
            this.myW = autoBang3;
            this.mza = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dDi()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.myZ != null) {
                        a.this.myZ.a(0L, a.this.myV, a.this.d());
                    }
                    a.this.myW = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.myZ != null) {
                        a.this.myZ.a(0L, a.this.myV, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dCD()).a(io.reactivex.a.b.a.dCD()).c(io.reactivex.a.b.a.dCD()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.myZ != null) {
                        a.this.myZ.a(longValue, a.this.myV, a.this.d());
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

    public IconConfig.Config dys() {
        return this.myY;
    }

    public String d() {
        if (this.myV == null) {
            return null;
        }
        return a(this.myV.mLevel);
    }

    public BangInfo dyt() {
        return this.myV;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.myX.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
