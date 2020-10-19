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
    private BangInfo osk;
    private AutoBang osl;
    private final SparseArrayCompat<BangListInfo> osm = new SparseArrayCompat<>();
    private IconConfig.Config osn = new IconConfig.Config();
    private InterfaceC0907a oso;
    private b osp;

    /* renamed from: com.kascend.chushou.player.ui.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0907a {
        void a(long j, BangInfo bangInfo, String str);

        void a(BangInfo bangInfo, String str);

        void a(IconConfig.Config config);
    }

    public a(InterfaceC0907a interfaceC0907a) {
        this.oso = interfaceC0907a;
    }

    public void a() {
        this.osn = new IconConfig.Config();
        this.osk = null;
        this.osl = null;
        this.osm.clear();
        if (this.osp != null) {
            this.osp.dispose();
            this.osp = null;
        }
    }

    public void b() {
        a();
    }

    public void a(SparseArrayCompat<BangListInfo> sparseArrayCompat) {
        if (sparseArrayCompat != null) {
            this.osm.clear();
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                this.osm.put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    public void a(IconConfig.Config config) {
        if (config != null) {
            this.osn = config;
            if (this.oso != null) {
                this.oso.a(config);
            }
        }
    }

    public void a(BangInfo bangInfo) {
        if (bangInfo != null) {
            this.osk = bangInfo;
            if (this.oso != null) {
                this.oso.a(bangInfo, a(bangInfo.mLevel));
            }
        }
    }

    public void a(AutoBang autoBang) {
        if (autoBang != null && autoBang.bangTime != 0) {
            AutoBang autoBang2 = this.osl;
            if (autoBang.isDone) {
                if (autoBang2 != null) {
                    if (autoBang.bangTime >= autoBang2.currentTime && this.osp != null) {
                        this.osp.dispose();
                        this.osp = null;
                        return;
                    }
                    return;
                } else if (this.osp != null) {
                    this.osp.dispose();
                    this.osp = null;
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
                if (this.osp != null) {
                    this.osp.dispose();
                    this.osp = null;
                    return;
                }
                return;
            }
            if (this.osp != null) {
                this.osp.dispose();
                this.osp = null;
            }
            this.osl = autoBang3;
            this.osp = g.a(1L, j, 1L, 1L, TimeUnit.SECONDS).b(io.reactivex.f.a.ens()).b(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.oso != null) {
                        a.this.oso.a(0L, a.this.osk, a.this.d());
                    }
                    a.this.osl = null;
                }
            }).a(new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // io.reactivex.c.a
                public void run() throws Exception {
                    if (a.this.oso != null) {
                        a.this.oso.a(0L, a.this.osk, a.this.d());
                    }
                }
            }).b(io.reactivex.a.b.a.emM()).a(io.reactivex.a.b.a.emM()).c(io.reactivex.a.b.a.emM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    long longValue = j - l.longValue();
                    if (a.this.oso != null) {
                        a.this.oso.a(longValue, a.this.osk, a.this.d());
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

    public IconConfig.Config ehZ() {
        return this.osn;
    }

    public String d() {
        if (this.osk == null) {
            return null;
        }
        return a(this.osk.mLevel);
    }

    public BangInfo eia() {
        return this.osk;
    }

    private String a(int i) {
        BangListInfo bangListInfo = this.osm.get(i);
        if (bangListInfo != null) {
            return bangListInfo.icon;
        }
        return null;
    }
}
