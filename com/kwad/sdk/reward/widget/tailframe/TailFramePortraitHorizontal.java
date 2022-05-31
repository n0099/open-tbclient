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
/* loaded from: classes5.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements d {
    public ImageView a;
    public TailFrameBarAppPortraitHorizontal b;
    public TailFrameBarH5PortraitHorizontal c;
    public a d;
    public AdTemplate e;
    public AdInfo f;
    public JSONObject g;
    public b h;
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

    private void a(View view2, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(view2.getContext()).a(this.e).a(this.h).a(view2 == this.i).a(view2 == this.i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitHorizontal.this.d != null) {
                        TailFramePortraitHorizontal.this.d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d046b, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09114e);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09114b);
        this.m = findViewById(R.id.obfuscated_res_0x7f0922f9);
    }

    private void c() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f);
        int i = J.width;
        int i2 = J.height;
        int c = com.kwad.sdk.a.kwai.a.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = c;
        layoutParams.height = (int) (c * (i2 / i));
        KSImageLoader.loadImage(this.a, J.coverUrl, this.e);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f) && !com.kwad.sdk.core.response.a.d.v(this.e)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.obfuscated_res_0x7f09113a);
            this.c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.e);
            this.c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.obfuscated_res_0x7f091124);
        this.b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.e);
        this.b.setVisibility(0);
        this.i = this.b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.e)) {
            e();
        }
        new f(this.i, this);
    }

    private void e() {
        this.h = new b(this.e, this.g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitHorizontal.this.e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.h = null;
    }

    public void a() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.b();
            this.b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.c.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.m.setVisibility(8);
            this.j.setVisibility(8);
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060767));
        }
        this.f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.g = jSONObject;
        this.d = aVar;
        this.j.a(this.e);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.e)) {
            a(view2, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
