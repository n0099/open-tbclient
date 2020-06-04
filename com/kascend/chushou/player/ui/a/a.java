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
    private BangInfo mUi;
    private AutoBang mUj;
    private final SparseArrayCompat<BangListInfo> mUl = new SparseArrayCompat<>();
    private IconConfig.Config mUm = new IconConfig.Config();
    private InterfaceC0805a mUn;
    private b mUo;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0805a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0805a interfaceC0805a) {
        this.mUn = interfaceC0805a;
    }

    public void a() {
        this.mUm = new IconConfig.Config();
        this.mUi = null;
        this.mUj = null;
        this.mUl.clear();
        if (this.mUo != null) {
            this.mUo.dispose();
            this.mUo = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.mUl.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.mUl.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.mUm = config;
            if (this.mUn != null) {
                this.mUn.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.mUi = bangInfo;
            if (this.mUn != null) {
                this.mUn.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.mUj;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.mUo != null) {
                        this.mUo.dispose();
                        this.mUo = null;
                        return;
                    }
                    return;
                } else if (this.mUo != null) {
                    this.mUo.dispose();
                    this.mUo = null;
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
                if (this.mUo != null) {
                    this.mUo.dispose();
                    this.mUo = null;
                    return;
                }
                return;
            }
            if (this.mUo != null) {
                this.mUo.dispose();
                this.mUo = null;
            }
            this.mUj = autoBang3;
            this.mUo = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.dLr()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mUn != null) {
                        a.this.mUn.a(0L, a.this.mUi, a.this.d());
                    }
                    a.this.mUj = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.mUn != null) {
                        a.this.mUn.a(0L, a.this.mUi, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.dKM()).a(io.reactivex.a.b.a.dKM()).c(io.reactivex.a.b.a.dKM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.mUn != null) {
                        a.this.mUn.a(longValue, a.this.mUi, a.this.d());
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

    public IconConfig.Config dFZ() {
        return this.mUm;
    }

    public String d() {
        if (this.mUi == null) {
            return null;
        }
        return a(this.mUi.mLevel);
    }

    public BangInfo dGa() {
        return this.mUi;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.mUl.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
