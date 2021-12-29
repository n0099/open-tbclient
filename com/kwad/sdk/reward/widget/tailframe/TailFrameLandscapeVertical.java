package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59945b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59946c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f59947d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f59948e;

    /* renamed from: f  reason: collision with root package name */
    public a f59949f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f59950g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f59951h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f59952i;

    /* renamed from: j  reason: collision with root package name */
    public b f59953j;

    /* renamed from: k  reason: collision with root package name */
    public TextProgressBar f59954k;
    public KsLogoView l;
    public com.kwad.sdk.reward.a m;
    public View n;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f59950g)) {
            this.m.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59950g).a(this.f59953j).a(view == this.f59954k).a(view == this.f59954k ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeVertical.this.f59949f != null) {
                        TailFrameLandscapeVertical.this.f59949f.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f59945b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.f59946c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        this.n = findViewById(R.id.ksad_video_thumb_container);
    }

    private void c() {
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f59951h), this.f59950g);
        KSImageLoader.loadImage(this.f59945b, com.kwad.sdk.core.response.a.a.h(this.f59951h), this.f59950g);
        KSImageLoader.loadImage(this.f59946c, com.kwad.sdk.core.response.a.a.h(this.f59951h), this.f59950g);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f59951h) && !com.kwad.sdk.core.response.a.d.v(this.f59950g)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f59948e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f59950g);
            this.f59948e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f59947d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f59950g);
        this.f59947d.setVisibility(0);
        this.f59954k = this.f59947d.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f59950g)) {
            e();
        }
        new f(this.f59954k, this);
    }

    private void e() {
        this.f59953j = new b(this.f59950g, this.f59952i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f59951h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeVertical.this.f59950g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f59951h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeVertical.this.f59951h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeVertical.this.f59947d.a(TailFrameLandscapeVertical.this.f59951h);
                TailFrameLandscapeVertical.this.f59954k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f59953j = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f59947d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f59947d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f59948e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f59948e.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f59950g = adTemplate;
        this.f59951h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59952i = jSONObject;
        this.f59949f = aVar;
        this.l.a(this.f59950g);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f59950g)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.m = aVar;
    }
}
