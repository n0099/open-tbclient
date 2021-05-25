package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class DownloadProgressView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextProgressBar f34111a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34112b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34113c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f34114d;

    /* renamed from: e  reason: collision with root package name */
    public final KsAppDownloadListener f34115e;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34115e = new c() { // from class: com.kwad.sdk.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i3) {
                DownloadProgressView.this.f34112b.setVisibility(8);
                DownloadProgressView.this.f34111a.setVisibility(0);
                DownloadProgressView.this.f34111a.a(a.a(), i3);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                DownloadProgressView.this.f34112b.setText(a.u(DownloadProgressView.this.f34114d));
                DownloadProgressView.this.f34112b.setVisibility(0);
                DownloadProgressView.this.f34111a.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                DownloadProgressView.this.f34112b.setVisibility(8);
                DownloadProgressView.this.f34111a.setVisibility(0);
                DownloadProgressView.this.f34111a.a(a.a(DownloadProgressView.this.f34113c), DownloadProgressView.this.f34111a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                DownloadProgressView.this.f34112b.setText(a.u(DownloadProgressView.this.f34114d));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                DownloadProgressView.this.f34112b.setVisibility(8);
                DownloadProgressView.this.f34111a.setVisibility(0);
                DownloadProgressView.this.f34111a.a(a.j(DownloadProgressView.this.f34114d), DownloadProgressView.this.f34111a.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i3) {
                DownloadProgressView.this.f34112b.setVisibility(8);
                DownloadProgressView.this.f34111a.setVisibility(0);
                DownloadProgressView.this.f34111a.a(a.a(i3), i3);
            }
        };
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.f34111a = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 11.0f));
        this.f34111a.a(-1, -45056);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.f34112b = textView;
        textView.setVisibility(0);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public void a(AdTemplate adTemplate) {
        this.f34113c = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34114d = g2;
        this.f34112b.setText(a.u(g2));
        this.f34111a.setVisibility(8);
        this.f34112b.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.f34115e;
    }
}
