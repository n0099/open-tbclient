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
    public ImageView f33922a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f33923b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f33924c;

    /* renamed from: d  reason: collision with root package name */
    public b f33925d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33926e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33927f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f33928g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33929h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f33930i;
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
        this.f33922a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f33927f);
        int i2 = C.width;
        int i3 = C.height;
        int c2 = an.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.f33922a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i3 / i2));
        KSImageLoader.loadImage(this.f33922a, C.coverUrl, this.f33926e);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f33927f)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f33924c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f33926e);
            this.f33924c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f33923b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f33926e);
        this.f33923b.setVisibility(0);
        this.f33930i = this.f33923b.getTextProgressBar();
        f();
        this.f33930i.setOnClickListener(this);
    }

    private void f() {
        this.f33929h = new com.kwad.sdk.core.download.b.b(this.f33926e, this.f33928g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitHorizontal.this.f33927f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitHorizontal.this.f33926e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.u(TailFramePortraitHorizontal.this.f33927f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.j(TailFramePortraitHorizontal.this.f33927f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitHorizontal.this.f33923b.a(TailFramePortraitHorizontal.this.f33927f);
                TailFramePortraitHorizontal.this.f33930i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.f33929h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f33926e = adTemplate;
        this.f33927f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33928g = jSONObject;
        this.f33925d = bVar;
        this.j.a(this.f33926e);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f33923b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.a();
            this.f33923b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f33924c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f33924c.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33926e, new a.InterfaceC0363a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                if (TailFramePortraitHorizontal.this.f33925d != null) {
                    TailFramePortraitHorizontal.this.f33925d.a();
                }
            }
        }, this.f33929h, view == this.f33930i);
    }
}
