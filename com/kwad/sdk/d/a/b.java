package com.kwad.sdk.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.f;
/* loaded from: classes4.dex */
public class b extends KSFrameLayout implements CompoundButton.OnCheckedChangeListener, com.kwad.sdk.widget.d {
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public View f56806b;

    /* renamed from: c  reason: collision with root package name */
    public KSFrameLayout f56807c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f56808d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56809e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f56810f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f56811g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f56812h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f56813i;

    /* renamed from: j  reason: collision with root package name */
    public CompoundButton f56814j;
    public View k;
    public View l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public TextProgressBar q;
    public TextView r;
    public d s;
    public final a t;
    public boolean u;
    public AdTemplate v;

    /* loaded from: classes4.dex */
    public static class a {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f56815b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f56816c = 0;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56817d = true;

        public int a() {
            return this.f56816c;
        }

        public void a(int i2) {
            this.f56816c = i2;
        }

        public void a(boolean z) {
            this.a = z;
        }

        public void b(boolean z) {
            this.f56815b = z;
        }

        public boolean b() {
            return this.f56817d;
        }

        public void c(boolean z) {
            this.f56817d = z;
        }
    }

    public b(@NonNull Context context, a aVar) {
        super(context);
        this.a = "%s秒后进入试玩页";
        this.u = false;
        this.t = aVar == null ? new a() : aVar;
        FrameLayout.inflate(context, this.t.b() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        c(this.t.a);
    }

    private void a(View view, boolean z) {
        d dVar;
        d dVar2;
        d dVar3 = this.s;
        if (dVar3 != null) {
            dVar3.b(z);
        }
        if (view.equals(this)) {
            d dVar4 = this.s;
            if (dVar4 != null) {
                dVar4.a(this);
            }
        } else if (view.equals(this.k)) {
            if (!(1 == this.t.a()) || (dVar2 = this.s) == null) {
                return;
            }
            dVar2.a();
        } else if (view.equals(this.m)) {
            d dVar5 = this.s;
            if (dVar5 != null) {
                dVar5.b();
            }
        } else if (view.equals(this.q)) {
            d dVar6 = this.s;
            if (dVar6 != null) {
                dVar6.b(view);
            }
        } else if (view.equals(this.f56812h)) {
            d dVar7 = this.s;
            if (dVar7 != null) {
                dVar7.h(view);
            }
        } else if (view.equals(this.f56810f)) {
            d dVar8 = this.s;
            if (dVar8 != null) {
                dVar8.c(view);
            }
        } else if (view.equals(this.l)) {
            d dVar9 = this.s;
            if (dVar9 != null) {
                dVar9.f(view);
            }
        } else if (view.equals(this.f56807c)) {
            d dVar10 = this.s;
            if (dVar10 != null) {
                dVar10.d(view);
            }
        } else if (view.equals(this.f56809e)) {
            d dVar11 = this.s;
            if (dVar11 != null) {
                dVar11.e(view);
            }
        } else if (!view.equals(this.f56813i) || (dVar = this.s) == null) {
        } else {
            dVar.g(view);
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.f56807c.setWidthBasedRatio(!z);
    }

    private void c(boolean z) {
        setClickable(true);
        this.f56807c = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.f56806b = findViewById(R.id.ksad_interstitial_full_bg);
        this.f56809e = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.f56808d = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.f56811g = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.f56812h = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.f56810f = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.f56813i = (ViewGroup) findViewById(R.id.ksad_ad_desc_layout);
        this.k = findViewById(R.id.ksad_interstitial_close_outer);
        this.f56810f.setTextDimen(bb.a(getContext(), 10.0f));
        this.f56810f.setTextColor(-1);
        this.f56814j = (CompoundButton) findViewById(R.id.ksad_interstitial_mute);
        this.m = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.n = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.o = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.p = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.q = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.l = findViewById(R.id.ksad_ad_download_container);
        new f(this, this);
        new f(this.f56809e, this);
        new f(this.f56810f, this);
        new f(this.q, this);
        new f(this.k, this);
        new f(this.f56812h, this);
        new f(this.m, this);
        new f(this.l, this);
        new f(this.f56813i, this);
        this.f56814j.setOnCheckedChangeListener(this);
        this.r = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.f56807c, z);
    }

    public void a(float f2, com.kwad.sdk.core.video.videoview.b bVar) {
        this.f56807c.setRatio(f2);
        this.f56807c.addView(bVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        bVar.setLayoutParams(layoutParams);
    }

    public void a(int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i2;
        marginLayoutParams.height = i3;
        setLayoutParams(marginLayoutParams);
        requestLayout();
    }

    public void a(AdTemplate adTemplate) {
        this.f56808d.a(adTemplate);
    }

    public void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String at;
        if (com.kwad.sdk.core.response.a.a.B(adInfo)) {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.a.au(adInfo), adTemplate, 4);
            textView = this.o;
            at = com.kwad.sdk.core.response.a.a.t(adInfo);
        } else {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.d.o(adTemplate), adTemplate, 4);
            textView = this.o;
            at = com.kwad.sdk.core.response.a.a.at(adInfo);
        }
        textView.setText(at);
        this.p.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
        this.q.a(com.kwad.sdk.core.response.a.a.A(adInfo), 0);
    }

    public void a(String str) {
        TextView textView = this.m;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.t.f56815b || this.u || this.m.getVisibility() == 0) {
            return;
        }
        this.m.setVisibility(0);
    }

    public void a(String str, int i2) {
        TextProgressBar textProgressBar = this.f56810f;
        if (textProgressBar != null) {
            textProgressBar.a(str, i2);
        }
        TextProgressBar textProgressBar2 = this.q;
        if (textProgressBar2 != null) {
            textProgressBar2.a(str, i2);
        }
    }

    public void a(String str, AdTemplate adTemplate) {
        if (at.a(str)) {
            return;
        }
        this.f56809e.setImageDrawable(null);
        KSImageLoader.loadImage(this.f56809e, str, adTemplate);
    }

    public void a(boolean z) {
        if (this.f56811g != null) {
            this.f56811g.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, int i2) {
        TextView textView = this.r;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
        if (i2 >= 0) {
            this.r.setText(String.format(this.a, String.valueOf(i2)));
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.f56809e != null) {
            this.f56809e.setVisibility(z ? 0 : 8);
            this.f56809e.setClickable(z2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.v)) {
            a(view, false);
        }
    }

    public void b(boolean z) {
        CompoundButton compoundButton = this.f56814j;
        if (compoundButton != null) {
            compoundButton.setChecked(z);
        }
    }

    public void c() {
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(8);
            this.u = true;
        }
    }

    public void d() {
        a(false);
        this.f56812h.setVisibility(0);
    }

    @Nullable
    public View getBlurBgView() {
        return this.f56806b;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        d dVar = this.s;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.v = adTemplate;
    }

    public void setViewListener(d dVar) {
        this.s = dVar;
    }
}
