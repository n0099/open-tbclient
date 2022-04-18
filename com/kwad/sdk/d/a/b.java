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
/* loaded from: classes5.dex */
public class b extends KSFrameLayout implements CompoundButton.OnCheckedChangeListener, com.kwad.sdk.widget.d {
    public String a;
    @Nullable
    public View b;
    public KSFrameLayout c;
    public KsLogoView d;
    public ImageView e;
    public TextProgressBar f;
    public ViewGroup g;
    public ViewGroup h;
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

    /* loaded from: classes5.dex */
    public static class a {
        public boolean a = false;
        public boolean b = false;
        public int c = 0;
        public boolean d = true;

        public int a() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }

        public void a(boolean z) {
            this.a = z;
        }

        public void b(boolean z) {
            this.b = z;
        }

        public boolean b() {
            return this.d;
        }

        public void c(boolean z) {
            this.d = z;
        }
    }

    public b(@NonNull Context context, a aVar) {
        super(context);
        this.a = "%s秒后进入试玩页";
        this.u = false;
        this.t = aVar == null ? new a() : aVar;
        FrameLayout.inflate(context, this.t.b() ? R.layout.obfuscated_res_0x7f0d0444 : R.layout.obfuscated_res_0x7f0d0443, this);
        c(this.t.a);
    }

    private void a(View view2, boolean z) {
        d dVar;
        d dVar2;
        d dVar3 = this.s;
        if (dVar3 != null) {
            dVar3.b(z);
        }
        if (view2.equals(this)) {
            d dVar4 = this.s;
            if (dVar4 != null) {
                dVar4.a(this);
            }
        } else if (view2.equals(this.k)) {
            if (!(1 == this.t.a()) || (dVar2 = this.s) == null) {
                return;
            }
            dVar2.a();
        } else if (view2.equals(this.m)) {
            d dVar5 = this.s;
            if (dVar5 != null) {
                dVar5.b();
            }
        } else if (view2.equals(this.q)) {
            d dVar6 = this.s;
            if (dVar6 != null) {
                dVar6.b(view2);
            }
        } else if (view2.equals(this.h)) {
            d dVar7 = this.s;
            if (dVar7 != null) {
                dVar7.h(view2);
            }
        } else if (view2.equals(this.f)) {
            d dVar8 = this.s;
            if (dVar8 != null) {
                dVar8.c(view2);
            }
        } else if (view2.equals(this.l)) {
            d dVar9 = this.s;
            if (dVar9 != null) {
                dVar9.f(view2);
            }
        } else if (view2.equals(this.c)) {
            d dVar10 = this.s;
            if (dVar10 != null) {
                dVar10.d(view2);
            }
        } else if (view2.equals(this.e)) {
            d dVar11 = this.s;
            if (dVar11 != null) {
                dVar11.e(view2);
            }
        } else if (!view2.equals(this.i) || (dVar = this.s) == null) {
        } else {
            dVar.g(view2);
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.c.setWidthBasedRatio(!z);
    }

    private void c(boolean z) {
        setClickable(true);
        this.c = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09109b);
        this.b = findViewById(R.id.obfuscated_res_0x7f091096);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091168);
        this.d = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091019);
        this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09109e);
        this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09109c);
        this.f = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091095);
        this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09100f);
        this.k = findViewById(R.id.obfuscated_res_0x7f091092);
        this.f.setTextDimen(bb.a(getContext(), 10.0f));
        this.f.setTextColor(-1);
        this.j = (CompoundButton) findViewById(R.id.obfuscated_res_0x7f091098);
        this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091093);
        this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091097);
        this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f091099);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f091094);
        this.q = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09102d);
        this.l = findViewById(R.id.obfuscated_res_0x7f091012);
        new f(this, this);
        new f(this.e, this);
        new f(this.f, this);
        new f(this.q, this);
        new f(this.k, this);
        new f(this.h, this);
        new f(this.m, this);
        new f(this.l, this);
        new f(this.i, this);
        this.j.setOnCheckedChangeListener(this);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09109d);
        a(this.c, z);
    }

    public void a(float f, com.kwad.sdk.core.video.videoview.b bVar) {
        this.c.setRatio(f);
        this.c.addView(bVar);
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
        this.d.a(adTemplate);
    }

    public void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String at;
        if (com.kwad.sdk.core.response.a.a.B(adInfo)) {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b9f);
            KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.a.au(adInfo), adTemplate, 4);
            textView = this.o;
            at = com.kwad.sdk.core.response.a.a.t(adInfo);
        } else {
            this.n.setVisibility(0);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b9f);
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
        if (!this.t.b || this.u || this.m.getVisibility() == 0) {
            return;
        }
        this.m.setVisibility(0);
    }

    public void a(String str, int i) {
        TextProgressBar textProgressBar = this.f;
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
        this.e.setImageDrawable(null);
        KSImageLoader.loadImage(this.e, str, adTemplate);
    }

    public void a(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
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
        if (this.e != null) {
            this.e.setVisibility(z ? 0 : 8);
            this.e.setClickable(z2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.v)) {
            a(view2, false);
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
        this.h.setVisibility(0);
    }

    @Nullable
    public View getBlurBgView() {
        return this.b;
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
