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
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.f;
/* loaded from: classes7.dex */
public class b extends KSFrameLayout implements CompoundButton.OnCheckedChangeListener, com.kwad.sdk.widget.d {
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public View f40229b;

    /* renamed from: c  reason: collision with root package name */
    public KSFrameLayout f40230c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f40231d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f40232e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f40233f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f40234g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f40235h;
    public ViewGroup i;
    public CompoundButton j;
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

    /* loaded from: classes7.dex */
    public static class a {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40236b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f40237c = 0;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40238d = true;

        public int a() {
            return this.f40237c;
        }

        public void a(int i) {
            this.f40237c = i;
        }

        public void a(boolean z) {
            this.a = z;
        }

        public void b(boolean z) {
            this.f40236b = z;
        }

        public boolean b() {
            return this.f40238d;
        }

        public void c(boolean z) {
            this.f40238d = z;
        }
    }

    public b(@NonNull Context context, a aVar) {
        super(context);
        this.a = "%s秒后进入试玩页";
        this.u = false;
        this.t = aVar == null ? new a() : aVar;
        FrameLayout.inflate(context, this.t.b() ? R.layout.obfuscated_res_0x7f0d0449 : R.layout.obfuscated_res_0x7f0d0448, this);
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
        } else if (view.equals(this.f40235h)) {
            d dVar7 = this.s;
            if (dVar7 != null) {
                dVar7.h(view);
            }
        } else if (view.equals(this.f40233f)) {
            d dVar8 = this.s;
            if (dVar8 != null) {
                dVar8.c(view);
            }
        } else if (view.equals(this.l)) {
            d dVar9 = this.s;
            if (dVar9 != null) {
                dVar9.f(view);
            }
        } else if (view.equals(this.f40230c)) {
            d dVar10 = this.s;
            if (dVar10 != null) {
                dVar10.d(view);
            }
        } else if (view.equals(this.f40232e)) {
            d dVar11 = this.s;
            if (dVar11 != null) {
                dVar11.e(view);
            }
        } else if (!view.equals(this.i) || (dVar = this.s) == null) {
        } else {
            dVar.g(view);
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.f40230c.setWidthBasedRatio(!z);
    }

    private void c(boolean z) {
        setClickable(true);
        this.f40230c = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0910a1);
        this.f40229b = findViewById(R.id.obfuscated_res_0x7f09109c);
        this.f40232e = (ImageView) findViewById(R.id.obfuscated_res_0x7f09116e);
        this.f40231d = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09101f);
        this.f40234g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910a4);
        this.f40235h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910a2);
        this.f40233f = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09109b);
        this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091015);
        this.k = findViewById(R.id.obfuscated_res_0x7f091098);
        this.f40233f.setTextDimen(bb.a(getContext(), 10.0f));
        this.f40233f.setTextColor(-1);
        this.j = (CompoundButton) findViewById(R.id.obfuscated_res_0x7f09109e);
        this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091099);
        this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f09109d);
        this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09109f);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09109a);
        this.q = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091033);
        this.l = findViewById(R.id.obfuscated_res_0x7f091018);
        new f(this, this);
        new f(this.f40232e, this);
        new f(this.f40233f, this);
        new f(this.q, this);
        new f(this.k, this);
        new f(this.f40235h, this);
        new f(this.m, this);
        new f(this.l, this);
        new f(this.i, this);
        this.j.setOnCheckedChangeListener(this);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0910a3);
        a(this.f40230c, z);
    }

    public void a(float f2, com.kwad.sdk.core.video.videoview.b bVar) {
        this.f40230c.setRatio(f2);
        this.f40230c.addView(bVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        bVar.setLayoutParams(layoutParams);
    }

    public void a(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
        requestLayout();
    }

    public void a(AdTemplate adTemplate) {
        this.f40231d.a(adTemplate);
    }

    public void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String at;
        if (com.kwad.sdk.core.response.a.a.B(adInfo)) {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b9a);
            KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.a.au(adInfo), adTemplate, 4);
            textView = this.o;
            at = com.kwad.sdk.core.response.a.a.t(adInfo);
        } else {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b9a);
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
        if (!this.t.f40236b || this.u || this.m.getVisibility() == 0) {
            return;
        }
        this.m.setVisibility(0);
    }

    public void a(String str, int i) {
        TextProgressBar textProgressBar = this.f40233f;
        if (textProgressBar != null) {
            textProgressBar.a(str, i);
        }
        TextProgressBar textProgressBar2 = this.q;
        if (textProgressBar2 != null) {
            textProgressBar2.a(str, i);
        }
    }

    public void a(String str, AdTemplate adTemplate) {
        if (at.a(str)) {
            return;
        }
        this.f40232e.setImageDrawable(null);
        KSImageLoader.loadImage(this.f40232e, str, adTemplate);
    }

    public void a(boolean z) {
        if (this.f40234g != null) {
            this.f40234g.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, int i) {
        TextView textView = this.r;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
        if (i >= 0) {
            this.r.setText(String.format(this.a, String.valueOf(i)));
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.f40232e != null) {
            this.f40232e.setVisibility(z ? 0 : 8);
            this.f40232e.setClickable(z2);
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
        CompoundButton compoundButton = this.j;
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
        this.f40235h.setVisibility(0);
    }

    @Nullable
    public View getBlurBgView() {
        return this.f40229b;
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
