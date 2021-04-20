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
/* loaded from: classes6.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36820a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f36821b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f36822c;

    /* renamed from: d  reason: collision with root package name */
    public b f36823d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36824e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f36825f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f36826g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36827h;
    public TextProgressBar i;
    public KsLogoView j;

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
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
        this.f36820a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f36825f);
        int i = E.width;
        int i2 = E.height;
        int c2 = ao.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.f36820a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i2 / i));
        KSImageLoader.loadImage(this.f36820a, E.coverUrl, this.f36824e);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f36825f)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f36822c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f36824e);
            this.f36822c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f36821b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f36824e);
        this.f36821b.setVisibility(0);
        this.i = this.f36821b.getTextProgressBar();
        f();
        this.i.setOnClickListener(this);
    }

    private void f() {
        this.f36827h = new com.kwad.sdk.core.download.b.b(this.f36824e, this.f36826g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.c(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f36825f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitHorizontal.this.f36824e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f36825f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitHorizontal.this.f36821b.a(TailFramePortraitHorizontal.this.f36825f);
                TailFramePortraitHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.f36827h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f36824e = adTemplate;
        this.f36825f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36826g = jSONObject;
        this.f36823d = bVar;
        this.j.a(this.f36824e);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f36821b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.a();
            this.f36821b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f36822c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f36822c.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f36827h, view == this.i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36824e, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                if (TailFramePortraitHorizontal.this.f36823d != null) {
                    TailFramePortraitHorizontal.this.f36823d.a();
                }
            }
        }, this.f36827h);
    }
}
