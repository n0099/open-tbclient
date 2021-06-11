package d.a.d0.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.prologue.service.network.Als;
import d.a.d0.b.g.h;
import d.a.d0.b.g.j;
/* loaded from: classes2.dex */
public class e implements d.a.f0.a.g.a, d.a.f0.a.g.c {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final d.a.f0.a.g.b f43308e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f43309f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final h f43310g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final d.a.d0.b.g.b f43311h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public d f43312i;
    public long j;
    public long k;
    public boolean l = true;
    public d.a.d0.b.g.d m;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f43312i.b();
        }
    }

    public e(@NonNull d.a.f0.a.g.b bVar, @NonNull ViewGroup viewGroup, @NonNull h hVar) {
        this.f43308e = bVar;
        this.f43309f = viewGroup;
        this.f43310g = hVar;
        this.f43311h = new d.a.d0.b.g.b(hVar);
        d.a.d0.b.g.c.a(hVar);
    }

    public final void b(String str) {
        if (this.l) {
            this.l = false;
            this.f43311h.d(str, this.k);
        }
    }

    public void c(d.a.d0.b.g.d dVar) {
        this.m = dVar;
        d.a.f0.a.g.b bVar = this.f43308e;
        if (bVar != null) {
            dVar.i(bVar);
        }
    }

    public void d(@NonNull d dVar) {
        this.f43312i = dVar;
    }

    @Override // d.a.f0.a.g.a
    public void onAdClick() {
        Als.Area area;
        if (d.a.d0.a.b.a.f43271a.get() != null) {
            d.a.d0.c.d.a(d.a.d0.a.b.a.f43271a.get().o(), this.f43310g.o);
        }
        b(Als.CloseType.CLICK_AD_AREA.value);
        if (TextUtils.isEmpty(this.f43310g.e())) {
            this.f43311h.a(Als.Area.UNKNOW, "");
            return;
        }
        String e2 = this.f43310g.e();
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
        this.f43311h.a(area, "");
        d dVar = this.f43312i;
        if (dVar != null) {
            dVar.onAdClick();
        }
    }

    @Override // d.a.f0.a.g.c
    public void onAdError(String str) {
        this.k = System.currentTimeMillis() - this.j;
        d dVar = this.f43312i;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    @Override // d.a.f0.a.g.c
    public void onAdLoad() {
        d.a.d0.b.g.d dVar;
        if (this.f43312i == null || (dVar = this.m) == null) {
            return;
        }
        dVar.h(!this.f43310g.g());
        this.m.j(!this.f43310g.f());
        this.f43312i.c(this.m);
    }

    @Override // d.a.f0.a.g.a
    public void onAdLogoClick() {
    }

    @Override // d.a.f0.a.g.c
    public void onAdStart() {
        this.j = System.currentTimeMillis();
        this.f43311h.b();
        d.a.d0.b.g.f.y(this.f43310g);
        j.c(this.f43310g);
        d dVar = this.f43312i;
        if (dVar != null) {
            dVar.onAdShow();
        }
    }

    @Override // d.a.f0.a.g.c
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
        if (this.f43312i != null) {
            d.a.f0.a.k.a.a(new a());
        }
    }

    @Override // d.a.f0.a.g.a
    public void onPermissionClick() {
    }

    @Override // d.a.f0.a.g.a
    public void onPrivacyClick() {
    }

    @Override // d.a.f0.a.g.a
    public void onSkipClick() {
        d dVar = this.f43312i;
        if (dVar != null) {
            dVar.onSkip();
        }
        b(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }
}
