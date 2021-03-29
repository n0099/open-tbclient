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
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TailFramePortraitVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36541a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f36542b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f36543c;

    /* renamed from: d  reason: collision with root package name */
    public b f36544d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36545e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f36546f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f36547g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36548h;
    public TextProgressBar i;
    public KsLogoView j;

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_portrait_vertical, this);
        this.f36541a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f36546f)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f36543c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f36545e);
            this.f36543c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_video_app_tail_frame);
        this.f36542b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f36545e);
        this.f36542b.setVisibility(0);
        this.i = this.f36542b.getTextProgressBar();
        e();
        this.i.setOnClickListener(this);
    }

    private void e() {
        this.f36548h = new com.kwad.sdk.core.download.b.b(this.f36545e, this.f36547g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.c(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f36546f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFramePortraitVertical.this.f36545e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFramePortraitVertical.this.f36546f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitVertical.this.f36542b.a(TailFramePortraitVertical.this.f36546f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f36548h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f36545e = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36546f = j;
        this.f36547g = jSONObject;
        this.f36544d = bVar;
        KSImageLoader.loadImage(this.f36541a, com.kwad.sdk.core.response.b.a.f(j), this.f36545e);
        this.j.a(adTemplate);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f36542b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.a();
            this.f36542b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f36543c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f36543c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f36548h, view == this.i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36545e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (TailFramePortraitVertical.this.f36544d != null) {
                    TailFramePortraitVertical.this.f36544d.a();
                }
            }
        }, this.f36548h);
    }
}
