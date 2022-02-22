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
import com.kwad.sdk.R;
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
/* loaded from: classes4.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f57898b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f57899c;

    /* renamed from: d  reason: collision with root package name */
    public a f57900d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57901e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57902f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f57903g;

    /* renamed from: h  reason: collision with root package name */
    public b f57904h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f57905i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f57906j;
    public com.kwad.sdk.reward.a k;
    public View l;
    public View m;

    public TailFramePortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f57901e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(this.f57901e).a(this.f57904h).a(view == this.f57905i).a(view == this.f57905i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitHorizontal.this.f57900d != null) {
                        TailFramePortraitHorizontal.this.f57900d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.f57906j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        this.m = findViewById(R.id.video_cover);
    }

    private void c() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f57902f);
        int i2 = J.width;
        int i3 = J.height;
        int c2 = com.kwad.sdk.a.kwai.a.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i3 / i2));
        KSImageLoader.loadImage(this.a, J.coverUrl, this.f57901e);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f57902f) && !com.kwad.sdk.core.response.a.d.v(this.f57901e)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f57899c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f57901e);
            this.f57899c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f57898b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f57901e);
        this.f57898b.setVisibility(0);
        this.f57905i = this.f57898b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f57901e)) {
            e();
        }
        new f(this.f57905i, this);
    }

    private void e() {
        this.f57904h = new b(this.f57901e, this.f57903g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f57902f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitHorizontal.this.f57901e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f57902f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitHorizontal.this.f57902f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitHorizontal.this.f57898b.a(TailFramePortraitHorizontal.this.f57902f);
                TailFramePortraitHorizontal.this.f57905i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f57904h = null;
    }

    public void a() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f57898b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.b();
            this.f57898b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f57899c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f57899c.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f57901e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.m.setVisibility(8);
            this.f57906j.setVisibility(8);
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        }
        this.f57902f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57903g = jSONObject;
        this.f57900d = aVar;
        this.f57906j.a(this.f57901e);
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
        if (com.kwad.sdk.core.response.a.c.g(this.f57901e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
