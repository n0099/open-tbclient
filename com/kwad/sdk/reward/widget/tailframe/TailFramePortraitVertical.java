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
    public ImageView f34688a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f34689b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f34690c;

    /* renamed from: d  reason: collision with root package name */
    public b f34691d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34692e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34693f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f34694g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34695h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f34696i;
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
        this.f34688a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f34693f)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f34690c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f34692e);
            this.f34690c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f34689b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f34692e);
        this.f34689b.setVisibility(0);
        this.f34696i = this.f34689b.getTextProgressBar();
        e();
        this.f34696i.setOnClickListener(this);
    }

    private void e() {
        this.f34695h = new com.kwad.sdk.core.download.b.b(this.f34692e, this.f34694g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitVertical.this.f34693f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitVertical.this.f34692e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitVertical.this.f34693f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.j(TailFramePortraitVertical.this.f34693f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitVertical.this.f34689b.a(TailFramePortraitVertical.this.f34693f);
                TailFramePortraitVertical.this.f34696i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f34695h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f34692e = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34693f = g2;
        this.f34694g = jSONObject;
        this.f34691d = bVar;
        KSImageLoader.loadImage(this.f34688a, com.kwad.sdk.core.response.b.a.f(g2), this.f34692e);
        this.j.a(adTemplate);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f34689b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.a();
            this.f34689b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f34690c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f34690c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34692e, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (TailFramePortraitVertical.this.f34691d != null) {
                    TailFramePortraitVertical.this.f34691d.a();
                }
            }
        }, this.f34695h, view == this.f34696i);
    }
}
