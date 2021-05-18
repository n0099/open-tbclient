package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TailFramePortraitVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33933a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f33934b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f33935c;

    /* renamed from: d  reason: collision with root package name */
    public b f33936d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33937e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33938f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f33939g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33940h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f33941i;
    public KsLogoView j;

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_vertical, this);
        this.f33933a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f33938f)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f33935c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f33937e);
            this.f33935c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f33934b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f33937e);
        this.f33934b.setVisibility(0);
        this.f33941i = this.f33934b.getTextProgressBar();
        e();
        this.f33941i.setOnClickListener(this);
    }

    private void e() {
        this.f33940h = new com.kwad.sdk.core.download.b.b(this.f33937e, this.f33939g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitVertical.this.f33938f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitVertical.this.f33937e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitVertical.this.f33938f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.j(TailFramePortraitVertical.this.f33938f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitVertical.this.f33934b.a(TailFramePortraitVertical.this.f33938f);
                TailFramePortraitVertical.this.f33941i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f33940h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f33937e = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33938f = g2;
        this.f33939g = jSONObject;
        this.f33936d = bVar;
        KSImageLoader.loadImage(this.f33933a, com.kwad.sdk.core.response.b.a.f(g2), this.f33937e);
        this.j.a(adTemplate);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f33934b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.a();
            this.f33934b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f33935c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f33935c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33937e, new a.InterfaceC0363a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                if (TailFramePortraitVertical.this.f33936d != null) {
                    TailFramePortraitVertical.this.f33936d.a();
                }
            }
        }, this.f33940h, view == this.f33941i);
    }
}
