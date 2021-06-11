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
/* loaded from: classes7.dex */
public class TailFramePortraitVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37291a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f37292b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f37293c;

    /* renamed from: d  reason: collision with root package name */
    public b f37294d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37295e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f37296f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f37297g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37298h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f37299i;
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
        this.f37291a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f37296f)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f37293c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f37295e);
            this.f37293c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f37292b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f37295e);
        this.f37292b.setVisibility(0);
        this.f37299i = this.f37292b.getTextProgressBar();
        e();
        this.f37299i.setOnClickListener(this);
    }

    private void e() {
        this.f37298h = new com.kwad.sdk.core.download.b.b(this.f37295e, this.f37297g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f37296f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitVertical.this.f37295e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f37296f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitVertical.this.f37292b.a(TailFramePortraitVertical.this.f37296f);
                TailFramePortraitVertical.this.f37299i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f37298h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f37295e = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37296f = j;
        this.f37297g = jSONObject;
        this.f37294d = bVar;
        KSImageLoader.loadImage(this.f37291a, com.kwad.sdk.core.response.b.a.f(j), this.f37295e);
        this.j.a(adTemplate);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f37292b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.a();
            this.f37292b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f37293c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f37293c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f37298h, view == this.f37299i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37295e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (TailFramePortraitVertical.this.f37294d != null) {
                    TailFramePortraitVertical.this.f37294d.a();
                }
            }
        }, this.f37298h);
    }
}
