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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f10683a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f10684b;
    private ImageView c;
    private TailFrameBarAppLandscape d;
    private TailFrameBarH5Landscape e;
    private b f;
    private AdTemplate g;
    private AdInfo h;
    private JSONObject i;
    private com.kwad.sdk.core.download.b.b j;
    private TextProgressBar k;
    private KsLogoView l;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.f10683a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f10684b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        KSImageLoader.loadImage(this.f10683a, com.kwad.sdk.core.response.b.a.f(this.h), this.g);
        KSImageLoader.loadImage(this.f10684b, com.kwad.sdk.core.response.b.a.f(this.h), this.g);
        KSImageLoader.loadImage(this.c, com.kwad.sdk.core.response.b.a.f(this.h), this.g);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.h)) {
            this.e = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.e.setModel(this.g);
            this.e.setVisibility(0);
            return;
        }
        this.d = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.d.setModel(this.g);
        this.d.setVisibility(0);
        this.k = this.d.getTextProgressBar();
        f();
        this.k.setOnClickListener(this);
    }

    private void f() {
        this.j = new com.kwad.sdk.core.download.b.b(this.g, this.i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeVertical.this.g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.j = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.g = adTemplate;
        this.h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = jSONObject;
        this.f = bVar;
        this.l.a(this.g);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        if (this.d != null) {
            this.d.a();
            this.d.setVisibility(8);
        }
        if (this.e != null) {
            this.e.a();
            this.e.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.g, new a.InterfaceC1092a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1092a
            public void a() {
                if (TailFrameLandscapeVertical.this.f != null) {
                    TailFrameLandscapeVertical.this.f.a();
                }
            }
        }, this.j);
    }
}
