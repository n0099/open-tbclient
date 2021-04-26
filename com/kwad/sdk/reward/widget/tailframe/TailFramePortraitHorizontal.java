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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34677a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f34678b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f34679c;

    /* renamed from: d  reason: collision with root package name */
    public b f34680d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34681e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34682f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f34683g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34684h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f34685i;
    public KsLogoView j;

    public TailFramePortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_horizontal, this);
        this.f34677a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f34682f);
        int i2 = C.width;
        int i3 = C.height;
        int c2 = an.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.f34677a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i3 / i2));
        KSImageLoader.loadImage(this.f34677a, C.coverUrl, this.f34681e);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f34682f)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f34679c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f34681e);
            this.f34679c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f34678b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f34681e);
        this.f34678b.setVisibility(0);
        this.f34685i = this.f34678b.getTextProgressBar();
        f();
        this.f34685i.setOnClickListener(this);
    }

    private void f() {
        this.f34684h = new com.kwad.sdk.core.download.b.b(this.f34681e, this.f34683g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitHorizontal.this.f34682f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitHorizontal.this.f34681e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitHorizontal.this.f34682f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.j(TailFramePortraitHorizontal.this.f34682f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitHorizontal.this.f34678b.a(TailFramePortraitHorizontal.this.f34682f);
                TailFramePortraitHorizontal.this.f34685i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.f34684h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f34681e = adTemplate;
        this.f34682f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34683g = jSONObject;
        this.f34680d = bVar;
        this.j.a(this.f34681e);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f34678b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.a();
            this.f34678b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f34679c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f34679c.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34681e, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (TailFramePortraitHorizontal.this.f34680d != null) {
                    TailFramePortraitHorizontal.this.f34680d.a();
                }
            }
        }, this.f34684h, view == this.f34685i);
    }
}
