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
/* loaded from: classes6.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36810a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36811b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36812c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f36813d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f36814e;

    /* renamed from: f  reason: collision with root package name */
    public b f36815f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f36816g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f36817h;
    public JSONObject i;
    public com.kwad.sdk.core.download.b.b j;
    public TextProgressBar k;
    public KsLogoView l;

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
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.f36810a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f36811b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.f36812c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        KSImageLoader.loadImage(this.f36810a, com.kwad.sdk.core.response.b.a.f(this.f36817h), this.f36816g);
        KSImageLoader.loadImage(this.f36811b, com.kwad.sdk.core.response.b.a.f(this.f36817h), this.f36816g);
        KSImageLoader.loadImage(this.f36812c, com.kwad.sdk.core.response.b.a.f(this.f36817h), this.f36816g);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f36817h)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f36814e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f36816g);
            this.f36814e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f36813d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f36816g);
        this.f36813d.setVisibility(0);
        this.k = this.f36813d.getTextProgressBar();
        f();
        this.k.setOnClickListener(this);
    }

    private void f() {
        this.j = new com.kwad.sdk.core.download.b.b(this.f36816g, this.i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.f36817h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeVertical.this.f36816g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.f36817h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeVertical.this.f36813d.a(TailFrameLandscapeVertical.this.f36817h);
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
        this.f36816g = adTemplate;
        this.f36817h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = jSONObject;
        this.f36815f = bVar;
        this.l.a(this.f36816g);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f36813d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f36813d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f36814e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f36814e.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36816g, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                if (TailFrameLandscapeVertical.this.f36815f != null) {
                    TailFrameLandscapeVertical.this.f36815f.a();
                }
            }
        }, this.j);
    }
}
