package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFramePortraitVertical extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f57697b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f57698c;

    /* renamed from: d  reason: collision with root package name */
    public a f57699d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57700e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57701f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f57702g;

    /* renamed from: h  reason: collision with root package name */
    public b f57703h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f57704i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f57705j;
    public com.kwad.sdk.reward.a k;
    public View l;

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f57700e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.f57700e).a(this.f57703h).a(view == this.f57704i).a(view == this.f57704i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitVertical.this.f57699d != null) {
                        TailFramePortraitVertical.this.f57699d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_vertical, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.f57705j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f57701f) && !com.kwad.sdk.core.response.a.d.v(this.f57700e)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f57698c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f57700e);
            this.f57698c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f57697b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f57700e);
        this.f57697b.setVisibility(0);
        this.f57704i = this.f57697b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f57700e)) {
            d();
        }
        new f(this.f57704i, this);
    }

    private void d() {
        this.f57703h = new b(this.f57700e, this.f57702g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitVertical.this.f57701f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitVertical.this.f57700e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitVertical.this.f57701f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitVertical.this.f57701f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitVertical.this.f57697b.a(TailFramePortraitVertical.this.f57701f);
                TailFramePortraitVertical.this.f57704i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.f57703h = null;
    }

    public void a() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f57697b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.b();
            this.f57697b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f57698c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f57698c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f57700e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.a.setVisibility(8);
            this.f57705j.setVisibility(8);
        }
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57701f = j2;
        this.f57702g = jSONObject;
        this.f57699d = aVar;
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(j2), this.f57700e);
        this.f57705j.a(adTemplate);
        c();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f57700e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
