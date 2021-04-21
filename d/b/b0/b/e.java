package d.b.b0.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.prologue.service.network.Als;
import d.b.b0.b.f.f;
import d.b.b0.b.f.g;
import d.b.b0.b.f.i;
/* loaded from: classes2.dex */
public class e implements d.b.d0.a.g.a, d.b.d0.a.g.c {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final d.b.d0.a.g.b f42135e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f42136f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final g f42137g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final d.b.b0.b.f.b f42138h;
    @Nullable
    public d i;
    public long j;
    public long k;
    public boolean l = true;
    public d.b.b0.b.f.d m;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.i.c();
        }
    }

    public e(@NonNull d.b.d0.a.g.b bVar, @NonNull ViewGroup viewGroup, @NonNull g gVar) {
        this.f42135e = bVar;
        this.f42136f = viewGroup;
        this.f42137g = gVar;
        this.f42138h = new d.b.b0.b.f.b(gVar);
        d.b.b0.b.f.c.a(gVar);
    }

    public final void b(String str) {
        if (this.l) {
            this.l = false;
            this.f42138h.d(str, this.k);
        }
    }

    public void c(d.b.b0.b.f.d dVar) {
        this.m = dVar;
        d.b.d0.a.g.b bVar = this.f42135e;
        if (bVar != null) {
            dVar.i(bVar);
        }
    }

    public void d(@NonNull d dVar) {
        this.i = dVar;
    }

    @Override // d.b.d0.a.g.a
    public void onAdClick() {
        Als.Area area;
        if (d.b.b0.a.b.a.f42106a.get() != null) {
            d.b.b0.c.d.a(d.b.b0.a.b.a.f42106a.get().y(), this.f42137g.o);
        }
        b(Als.CloseType.CLICK_AD_AREA.value);
        if (TextUtils.isEmpty(this.f42137g.e())) {
            this.f42138h.a(Als.Area.UNKNOW, "");
            return;
        }
        String e2 = this.f42137g.e();
        char c2 = 65535;
        int hashCode = e2.hashCode();
        if (hashCode != 102340) {
            if (hashCode != 100313435) {
                if (hashCode == 112202875 && e2.equals("video")) {
                    c2 = 1;
                }
            } else if (e2.equals("image")) {
                c2 = 0;
            }
        } else if (e2.equals("gif")) {
            c2 = 2;
        }
        if (c2 == 0) {
            area = Als.Area.IMAGE;
        } else if (c2 == 1) {
            area = Als.Area.VIDEO;
        } else if (c2 != 2) {
            area = Als.Area.UNKNOW;
        } else {
            area = Als.Area.GIF;
        }
        this.f42138h.a(area, "");
        d dVar = this.i;
        if (dVar != null) {
            dVar.onAdClick();
        }
    }

    @Override // d.b.d0.a.g.c
    public void onAdError(String str) {
        this.k = System.currentTimeMillis() - this.j;
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    @Override // d.b.d0.a.g.c
    public void onAdLoad() {
        d.b.b0.b.f.d dVar;
        if (this.i == null || (dVar = this.m) == null) {
            return;
        }
        dVar.h(!this.f42137g.g());
        this.m.j(!this.f42137g.f());
        this.i.d(this.m);
    }

    @Override // d.b.d0.a.g.a
    public void onAdLogoClick() {
    }

    @Override // d.b.d0.a.g.c
    public void onAdStart() {
        this.j = System.currentTimeMillis();
        this.f42138h.b();
        f.u(this.f42137g);
        i.c(this.f42137g);
        d dVar = this.i;
        if (dVar != null) {
            dVar.onAdShow();
        }
    }

    @Override // d.b.d0.a.g.c
    public void onAdStop(String str) {
        this.k = System.currentTimeMillis() - this.j;
        if ("time_end".equals(str)) {
            b(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
        } else if ("click_skip_button".equals(str)) {
            b(Als.CloseType.CLICK_SKIP_BUTTON.value);
        } else if ("click_ad_area".equals(str)) {
            b(Als.CloseType.CLICK_AD_AREA.value);
        } else {
            b(Als.CloseType.OTHER.value);
        }
        if (this.i != null) {
            d.b.d0.a.k.a.a(new a());
        }
    }

    @Override // d.b.d0.a.g.a
    public void onPermissionClick() {
    }

    @Override // d.b.d0.a.g.a
    public void onPrivacyClick() {
    }

    @Override // d.b.d0.a.g.a
    public void onSkipClick() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.onSkip();
        }
        b(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }
}
