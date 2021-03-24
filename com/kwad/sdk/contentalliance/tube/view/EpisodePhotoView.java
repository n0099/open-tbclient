package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class EpisodePhotoView extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33329a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33330b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33331c;

    /* renamed from: d  reason: collision with root package name */
    public PhotoInfo f33332d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f33333e;

    /* renamed from: f  reason: collision with root package name */
    public int f33334f;

    /* renamed from: g  reason: collision with root package name */
    public long f33335g;

    /* renamed from: h  reason: collision with root package name */
    public float f33336h;
    public RectF i;
    public Path j;

    public EpisodePhotoView(@NonNull Context context) {
        super(context);
        setLayerType(1, null);
        this.f33336h = ao.a(context, 4.0f);
    }

    public EpisodePhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        this.f33336h = ao.a(context, 4.0f);
    }

    private void c() {
        String g2 = d.g(this.f33332d);
        if (TextUtils.isEmpty(g2)) {
            g2 = d.d(this.f33332d);
        }
        KSImageLoader.loadImage(this.f33329a, g2, this.f33331c, KSImageLoader.IMGOPTION_TUBE);
    }

    private void d() {
        this.f33333e.setVisibility(8);
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        e.a(this.f33331c);
    }

    public void a(int i, long j) {
        this.f33334f = i;
        this.f33335g = j;
    }

    public void b() {
        this.f33329a = (ImageView) findViewById(R.id.ksad_tube_trend_episode_cover);
        this.f33333e = (FrameLayout) findViewById(R.id.ksad_tube_trend_episode_more);
        this.f33330b = (TextView) findViewById(R.id.ksad_tube_trend_episode_name);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = this.i;
        if (rectF == null) {
            this.j = new Path();
            this.i = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.i.bottom = canvas.getHeight();
            this.j.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f33336h;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.j.addRoundRect(this.i, fArr, Path.Direction.CW);
        canvas.clipPath(this.j);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public int getPosition() {
        return this.f33334f;
    }

    public AdTemplate getTemplateData() {
        return this.f33331c;
    }

    public long getTubeId() {
        return this.f33335g;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setLookMoreVisibility(boolean z) {
        if (z) {
            this.f33333e.setVisibility(0);
            this.f33330b.setVisibility(8);
            return;
        }
        this.f33333e.setVisibility(8);
        this.f33330b.setVisibility(0);
    }

    public void setRadius(float f2) {
        this.f33336h = f2;
        invalidate();
    }

    public void setTemplateData(@NonNull AdTemplate adTemplate) {
        this.f33331c = adTemplate;
        PhotoInfo k = c.k(adTemplate);
        this.f33332d = k;
        if (k == null) {
            return;
        }
        d();
        c();
        this.f33330b.setText(d.B(this.f33332d));
        this.f33330b.setVisibility(0);
    }
}
