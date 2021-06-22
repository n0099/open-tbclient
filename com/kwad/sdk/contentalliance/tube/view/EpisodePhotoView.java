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
    public ImageView f34043a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34044b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34045c;

    /* renamed from: d  reason: collision with root package name */
    public PhotoInfo f34046d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f34047e;

    /* renamed from: f  reason: collision with root package name */
    public int f34048f;

    /* renamed from: g  reason: collision with root package name */
    public long f34049g;

    /* renamed from: h  reason: collision with root package name */
    public float f34050h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f34051i;
    public Path j;

    public EpisodePhotoView(@NonNull Context context) {
        super(context);
        setLayerType(1, null);
        this.f34050h = ao.a(context, 4.0f);
    }

    public EpisodePhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        this.f34050h = ao.a(context, 4.0f);
    }

    private void c() {
        String g2 = d.g(this.f34046d);
        if (TextUtils.isEmpty(g2)) {
            g2 = d.d(this.f34046d);
        }
        KSImageLoader.loadImage(this.f34043a, g2, this.f34045c, KSImageLoader.IMGOPTION_TUBE);
    }

    private void d() {
        this.f34047e.setVisibility(8);
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        e.a(this.f34045c);
    }

    public void a(int i2, long j) {
        this.f34048f = i2;
        this.f34049g = j;
    }

    public void b() {
        this.f34043a = (ImageView) findViewById(R.id.ksad_tube_trend_episode_cover);
        this.f34047e = (FrameLayout) findViewById(R.id.ksad_tube_trend_episode_more);
        this.f34044b = (TextView) findViewById(R.id.ksad_tube_trend_episode_name);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = this.f34051i;
        if (rectF == null) {
            this.j = new Path();
            this.f34051i = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.f34051i.bottom = canvas.getHeight();
            this.j.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f34050h;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.j.addRoundRect(this.f34051i, fArr, Path.Direction.CW);
        canvas.clipPath(this.j);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public int getPosition() {
        return this.f34048f;
    }

    public AdTemplate getTemplateData() {
        return this.f34045c;
    }

    public long getTubeId() {
        return this.f34049g;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setLookMoreVisibility(boolean z) {
        if (z) {
            this.f34047e.setVisibility(0);
            this.f34044b.setVisibility(8);
            return;
        }
        this.f34047e.setVisibility(8);
        this.f34044b.setVisibility(0);
    }

    public void setRadius(float f2) {
        this.f34050h = f2;
        invalidate();
    }

    public void setTemplateData(@NonNull AdTemplate adTemplate) {
        this.f34045c = adTemplate;
        PhotoInfo k = c.k(adTemplate);
        this.f34046d = k;
        if (k == null) {
            return;
        }
        d();
        c();
        this.f34044b.setText(d.B(this.f34046d));
        this.f34044b.setVisibility(0);
    }
}
