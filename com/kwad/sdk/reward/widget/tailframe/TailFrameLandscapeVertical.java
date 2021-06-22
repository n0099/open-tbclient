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
public class TailFrameLandscapeVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37367a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37368b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37369c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f37370d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f37371e;

    /* renamed from: f  reason: collision with root package name */
    public b f37372f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f37373g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f37374h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f37375i;
    public com.kwad.sdk.core.download.b.b j;
    public TextProgressBar k;
    public KsLogoView l;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.f37367a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f37368b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.f37369c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        KSImageLoader.loadImage(this.f37367a, com.kwad.sdk.core.response.b.a.f(this.f37374h), this.f37373g);
        KSImageLoader.loadImage(this.f37368b, com.kwad.sdk.core.response.b.a.f(this.f37374h), this.f37373g);
        KSImageLoader.loadImage(this.f37369c, com.kwad.sdk.core.response.b.a.f(this.f37374h), this.f37373g);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f37374h)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f37371e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f37373g);
            this.f37371e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f37370d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f37373g);
        this.f37370d.setVisibility(0);
        this.k = this.f37370d.getTextProgressBar();
        f();
        this.k.setOnClickListener(this);
    }

    private void f() {
        this.j = new com.kwad.sdk.core.download.b.b(this.f37373g, this.f37375i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.f37374h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeVertical.this.f37373g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeVertical.this.f37374h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeVertical.this.f37370d.a(TailFrameLandscapeVertical.this.f37374h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
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
        this.f37373g = adTemplate;
        this.f37374h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37375i = jSONObject;
        this.f37372f = bVar;
        this.l.a(this.f37373g);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f37370d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f37370d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f37371e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f37371e.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37373g, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (TailFrameLandscapeVertical.this.f37372f != null) {
                    TailFrameLandscapeVertical.this.f37372f.a();
                }
            }
        }, this.j);
    }
}
