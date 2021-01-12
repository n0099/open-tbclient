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
/* loaded from: classes4.dex */
public class TailFramePortraitVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f10689a;

    /* renamed from: b  reason: collision with root package name */
    private TailFrameBarAppPortraitVertical f10690b;
    private TailFrameBarH5PortraitVertical c;
    private b d;
    private AdTemplate e;
    private AdInfo f;
    private JSONObject g;
    private com.kwad.sdk.core.download.b.b h;
    private TextProgressBar i;
    private KsLogoView j;

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        inflate(getContext(), R.layout.ksad_video_tf_view_portrait_vertical, this);
        this.f10689a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f)) {
            this.c = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.c.a(this.e);
            this.c.setVisibility(0);
            return;
        }
        this.f10690b = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f10690b.a(this.e);
        this.f10690b.setVisibility(0);
        this.i = this.f10690b.getTextProgressBar();
        e();
        this.i.setOnClickListener(this);
    }

    private void e() {
        this.h = new com.kwad.sdk.core.download.b.b(this.e, this.g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.c(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitVertical.this.e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitVertical.this.f10690b.a(TailFramePortraitVertical.this.f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.e = adTemplate;
        this.f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.g = jSONObject;
        this.d = bVar;
        KSImageLoader.loadImage(this.f10689a, com.kwad.sdk.core.response.b.a.f(this.f), this.e);
        this.j.a(adTemplate);
        d();
        setOnClickListener(this);
    }

    public void b() {
        if (this.f10690b != null) {
            this.f10690b.a();
            this.f10690b.setVisibility(8);
        }
        if (this.c != null) {
            this.c.a();
            this.c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.h, view == this.i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.e, new a.InterfaceC1088a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
            public void a() {
                if (TailFramePortraitVertical.this.d != null) {
                    TailFramePortraitVertical.this.d.a();
                }
            }
        }, this.h);
    }
}
