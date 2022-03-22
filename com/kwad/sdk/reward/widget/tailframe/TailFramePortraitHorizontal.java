package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f41168b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f41169c;

    /* renamed from: d  reason: collision with root package name */
    public a f41170d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41171e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f41172f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f41173g;

    /* renamed from: h  reason: collision with root package name */
    public b f41174h;
    public TextProgressBar i;
    public KsLogoView j;
    public com.kwad.sdk.reward.a k;
    public View l;
    public View m;

    public TailFramePortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f41171e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41171e).a(this.f41174h).a(view == this.i).a(view == this.i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitHorizontal.this.f41170d != null) {
                        TailFramePortraitHorizontal.this.f41170d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0486, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091183);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091180);
        this.m = findViewById(R.id.obfuscated_res_0x7f09231e);
    }

    private void c() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f41172f);
        int i = J.width;
        int i2 = J.height;
        int c2 = com.kwad.sdk.a.kwai.a.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i2 / i));
        KSImageLoader.loadImage(this.a, J.coverUrl, this.f41171e);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f41172f) && !com.kwad.sdk.core.response.a.d.v(this.f41171e)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.obfuscated_res_0x7f09116f);
            this.f41169c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f41171e);
            this.f41169c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.obfuscated_res_0x7f091159);
        this.f41168b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f41171e);
        this.f41168b.setVisibility(0);
        this.i = this.f41168b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f41171e)) {
            e();
        }
        new f(this.i, this);
    }

    private void e() {
        this.f41174h = new b(this.f41171e, this.f41173g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f41172f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitHorizontal.this.f41171e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f41172f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitHorizontal.this.f41172f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitHorizontal.this.f41168b.a(TailFramePortraitHorizontal.this.f41172f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f41174h = null;
    }

    public void a() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f41168b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.b();
            this.f41168b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f41169c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f41169c.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f41171e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.m.setVisibility(8);
            this.j.setVisibility(8);
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06075b));
        }
        this.f41172f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41173g = jSONObject;
        this.f41170d = aVar;
        this.j.a(this.f41171e);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f41171e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
