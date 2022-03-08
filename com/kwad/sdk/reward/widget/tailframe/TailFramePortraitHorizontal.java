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
/* loaded from: classes8.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f56248b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f56249c;

    /* renamed from: d  reason: collision with root package name */
    public a f56250d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56251e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f56252f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f56253g;

    /* renamed from: h  reason: collision with root package name */
    public b f56254h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f56255i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f56256j;
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
        if (com.kwad.sdk.core.response.a.d.v(this.f56251e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(this.f56251e).a(this.f56254h).a(view == this.f56255i).a(view == this.f56255i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitHorizontal.this.f56250d != null) {
                        TailFramePortraitHorizontal.this.f56250d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.f56256j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        this.m = findViewById(R.id.video_cover);
    }

    private void c() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f56252f);
        int i2 = J.width;
        int i3 = J.height;
        int c2 = com.kwad.sdk.a.kwai.a.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i3 / i2));
        KSImageLoader.loadImage(this.a, J.coverUrl, this.f56251e);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f56252f) && !com.kwad.sdk.core.response.a.d.v(this.f56251e)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f56249c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f56251e);
            this.f56249c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f56248b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f56251e);
        this.f56248b.setVisibility(0);
        this.f56255i = this.f56248b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f56251e)) {
            e();
        }
        new f(this.f56255i, this);
    }

    private void e() {
        this.f56254h = new b(this.f56251e, this.f56253g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f56252f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitHorizontal.this.f56251e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitHorizontal.this.f56252f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitHorizontal.this.f56252f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitHorizontal.this.f56248b.a(TailFramePortraitHorizontal.this.f56252f);
                TailFramePortraitHorizontal.this.f56255i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f56254h = null;
    }

    public void a() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f56248b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.b();
            this.f56248b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f56249c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f56249c.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f56251e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.m.setVisibility(8);
            this.f56256j.setVisibility(8);
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        }
        this.f56252f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56253g = jSONObject;
        this.f56250d = aVar;
        this.f56256j.a(this.f56251e);
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
        if (com.kwad.sdk.core.response.a.c.g(this.f56251e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
