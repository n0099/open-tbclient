package d.a.b0.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.prologue.service.network.Als;
import d.a.b0.b.f.f;
import d.a.b0.b.f.g;
import d.a.b0.b.f.i;
/* loaded from: classes2.dex */
public class e implements d.a.d0.a.g.a, d.a.d0.a.g.c {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final d.a.d0.a.g.b f39317e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f39318f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final g f39319g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final d.a.b0.b.f.b f39320h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public d f39321i;
    public long j;
    public long k;
    public boolean l = true;
    public d.a.b0.b.f.d m;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f39321i.b();
        }
    }

    public e(@NonNull d.a.d0.a.g.b bVar, @NonNull ViewGroup viewGroup, @NonNull g gVar) {
        this.f39317e = bVar;
        this.f39318f = viewGroup;
        this.f39319g = gVar;
        this.f39320h = new d.a.b0.b.f.b(gVar);
        d.a.b0.b.f.c.a(gVar);
    }

    public final void b(String str) {
        if (this.l) {
            this.l = false;
            this.f39320h.d(str, this.k);
        }
    }

    public void c(d.a.b0.b.f.d dVar) {
        this.m = dVar;
        d.a.d0.a.g.b bVar = this.f39317e;
        if (bVar != null) {
            dVar.i(bVar);
        }
    }

    public void d(@NonNull d dVar) {
        this.f39321i = dVar;
    }

    @Override // d.a.d0.a.g.a
    public void onAdClick() {
        Als.Area area;
        if (d.a.b0.a.b.a.f39288a.get() != null) {
            d.a.b0.c.d.a(d.a.b0.a.b.a.f39288a.get().o(), this.f39319g.o);
        }
        b(Als.CloseType.CLICK_AD_AREA.value);
        if (TextUtils.isEmpty(this.f39319g.e())) {
            this.f39320h.a(Als.Area.UNKNOW, "");
            return;
        }
        String e2 = this.f39319g.e();
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
        this.f39320h.a(area, "");
        d dVar = this.f39321i;
        if (dVar != null) {
            dVar.onAdClick();
        }
    }

    @Override // d.a.d0.a.g.c
    public void onAdError(String str) {
        this.k = System.currentTimeMillis() - this.j;
        d dVar = this.f39321i;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    @Override // d.a.d0.a.g.c
    public void onAdLoad() {
        d.a.b0.b.f.d dVar;
        if (this.f39321i == null || (dVar = this.m) == null) {
            return;
        }
        dVar.h(!this.f39319g.g());
        this.m.j(!this.f39319g.f());
        this.f39321i.c(this.m);
    }

    @Override // d.a.d0.a.g.a
    public void onAdLogoClick() {
    }

    @Override // d.a.d0.a.g.c
    public void onAdStart() {
        this.j = System.currentTimeMillis();
        this.f39320h.b();
        f.u(this.f39319g);
        i.c(this.f39319g);
        d dVar = this.f39321i;
        if (dVar != null) {
            dVar.onAdShow();
        }
    }

    @Override // d.a.d0.a.g.c
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
        if (this.f39321i != null) {
            d.a.d0.a.k.a.a(new a());
        }
    }

    @Override // d.a.d0.a.g.a
    public void onPermissionClick() {
    }

    @Override // d.a.d0.a.g.a
    public void onPrivacyClick() {
    }

    @Override // d.a.d0.a.g.a
    public void onSkipClick() {
        d dVar = this.f39321i;
        if (dVar != null) {
            dVar.onSkip();
        }
        b(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }
}
