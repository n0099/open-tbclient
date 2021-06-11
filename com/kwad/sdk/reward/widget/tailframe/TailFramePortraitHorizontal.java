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
/* loaded from: classes7.dex */
public class TailFramePortraitHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37280a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitHorizontal f37281b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitHorizontal f37282c;

    /* renamed from: d  reason: collision with root package name */
    public b f37283d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37284e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f37285f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f37286g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37287h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f37288i;
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
        this.f37280a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f37285f);
        int i2 = E.width;
        int i3 = E.height;
        int c2 = ao.c(getContext());
        ViewGroup.LayoutParams layoutParams = this.f37280a.getLayoutParams();
        layoutParams.width = c2;
        layoutParams.height = (int) (c2 * (i3 / i2));
        KSImageLoader.loadImage(this.f37280a, E.coverUrl, this.f37284e);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f37285f)) {
            TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = (TailFrameBarH5PortraitHorizontal) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f37282c = tailFrameBarH5PortraitHorizontal;
            tailFrameBarH5PortraitHorizontal.setModel(this.f37284e);
            this.f37282c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = (TailFrameBarAppPortraitHorizontal) findViewById(R.id.ksad_video_app_tail_frame);
        this.f37281b = tailFrameBarAppPortraitHorizontal;
        tailFrameBarAppPortraitHorizontal.a(this.f37284e);
        this.f37281b.setVisibility(0);
        this.f37288i = this.f37281b.getTextProgressBar();
        f();
        this.f37288i.setOnClickListener(this);
    }

    private void f() {
        this.f37287h = new com.kwad.sdk.core.download.b.b(this.f37284e, this.f37286g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f37285f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitHorizontal.this.f37284e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitHorizontal.this.f37285f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFramePortraitHorizontal.this.f37281b.a(TailFramePortraitHorizontal.this.f37285f);
                TailFramePortraitHorizontal.this.f37288i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.f37287h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f37284e = adTemplate;
        this.f37285f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37286g = jSONObject;
        this.f37283d = bVar;
        this.j.a(this.f37284e);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitHorizontal tailFrameBarAppPortraitHorizontal = this.f37281b;
        if (tailFrameBarAppPortraitHorizontal != null) {
            tailFrameBarAppPortraitHorizontal.a();
            this.f37281b.setVisibility(8);
        }
        TailFrameBarH5PortraitHorizontal tailFrameBarH5PortraitHorizontal = this.f37282c;
        if (tailFrameBarH5PortraitHorizontal != null) {
            tailFrameBarH5PortraitHorizontal.a();
            this.f37282c.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f37287h, view == this.f37288i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37284e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (TailFramePortraitHorizontal.this.f37283d != null) {
                    TailFramePortraitHorizontal.this.f37283d.a();
                }
            }
        }, this.f37287h);
    }
}
