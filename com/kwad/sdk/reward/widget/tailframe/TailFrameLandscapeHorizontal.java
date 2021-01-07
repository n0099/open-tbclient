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
/* loaded from: classes5.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f10977a;

    /* renamed from: b  reason: collision with root package name */
    private TailFrameBarAppLandscape f10978b;
    private TailFrameBarH5Landscape c;
    private b d;
    private AdTemplate e;
    private AdInfo f;
    private JSONObject g;
    private com.kwad.sdk.core.download.b.b h;
    private TextProgressBar i;
    private KsLogoView j;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.f10977a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f)) {
            this.c = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.c.setModel(this.e);
            this.c.setVisibility(0);
            return;
        }
        this.f10978b = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f10978b.setModel(this.e);
        this.f10978b.setVisibility(0);
        this.i = this.f10978b.getTextProgressBar();
        e();
        this.i.setOnClickListener(this);
    }

    private void e() {
        this.h = new com.kwad.sdk.core.download.b.b(this.e, this.g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f10978b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f10978b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f10978b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f10978b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeHorizontal.this.f10978b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
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
        this.j.a(this.e);
        KSImageLoader.loadImage(this.f10977a, com.kwad.sdk.core.response.b.a.f(this.f), this.e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        if (this.f10978b != null) {
            this.f10978b.a();
            this.f10978b.setVisibility(8);
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
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.e, new a.InterfaceC1105a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.d != null) {
                    TailFrameLandscapeHorizontal.this.d.a();
                }
            }
        }, this.h);
    }
}
