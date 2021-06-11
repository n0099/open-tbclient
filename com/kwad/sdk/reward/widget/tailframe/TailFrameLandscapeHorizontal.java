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
/* loaded from: classes7.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37258a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f37259b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f37260c;

    /* renamed from: d  reason: collision with root package name */
    public b f37261d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37262e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f37263f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f37264g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37265h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f37266i;
    public KsLogoView j;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.f37258a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f37263f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f37260c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f37262e);
            this.f37260c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f37259b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f37262e);
        this.f37259b.setVisibility(0);
        this.f37266i = this.f37259b.getTextProgressBar();
        e();
        this.f37266i.setOnClickListener(this);
    }

    private void e() {
        this.f37265h = new com.kwad.sdk.core.download.b.b(this.f37262e, this.f37264g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f37259b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37262e));
                TailFrameLandscapeHorizontal.this.f37266i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f37263f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f37259b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37262e));
                TailFrameLandscapeHorizontal.this.f37266i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f37262e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f37259b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37262e));
                TailFrameLandscapeHorizontal.this.f37266i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f37263f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f37259b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37262e));
                TailFrameLandscapeHorizontal.this.f37266i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f37259b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37262e));
                TailFrameLandscapeHorizontal.this.f37266i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f37265h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f37262e = adTemplate;
        this.f37263f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37264g = jSONObject;
        this.f37261d = bVar;
        this.j.a(this.f37262e);
        KSImageLoader.loadImage(this.f37258a, com.kwad.sdk.core.response.b.a.f(this.f37263f), this.f37262e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f37259b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f37259b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f37260c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f37260c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f37265h, view == this.f37266i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37262e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f37261d != null) {
                    TailFrameLandscapeHorizontal.this.f37261d.a();
                }
            }
        }, this.f37265h);
    }
}
