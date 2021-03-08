package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f7054a;
    private TailFrameBarAppPortraitHorizontal b;
    private TailFrameBarH5PortraitHorizontal c;
    private b d;
    private AdTemplate e;
    private AdInfo f;
    private JSONObject g;
    private com.kwad.sdk.core.download.b.b h;
    private TextProgressBar i;
    private KsLogoView j;

    public TailFramePortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
        this.f7054a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f);
        int i = E.width;
        int i2 = E.height;
        int c = ao.c(getContext());
        float f = i2 / i;
        ViewGroup.LayoutParams layoutParams = this.f7054a.getLayoutParams();
        layoutParams.width = c;
        layoutParams.height = (int) (f * c);
        KSImageLoader.loadImage(this.f7054a, E.coverUrl, this.e);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f)) {
            this.c = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.c.setModel(this.e);
            this.c.setVisibility(0);
            return;
        }
        this.b = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.b.a(this.e);
        this.b.setVisibility(0);
        this.i = this.b.getTextProgressBar();
        f();
        this.i.setOnClickListener(this);
    }

    private void f() {
        this.h = new com.kwad.sdk.core.download.b.b(this.e, this.g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.c(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitHorizontal.this.e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitHorizontal.this.b.a(TailFramePortraitHorizontal.this.f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void g() {
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
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        if (this.b != null) {
            this.b.a();
            this.b.setVisibility(8);
        }
        if (this.c != null) {
            this.c.a();
            this.c.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.h, view == this.i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.e, new a.InterfaceC1111a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
            public void a() {
                if (TailFramePortraitHorizontal.this.d != null) {
                    TailFramePortraitHorizontal.this.d.a();
                }
            }
        }, this.h);
    }
}
