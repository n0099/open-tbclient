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
/* loaded from: classes3.dex */
public class EpisodePhotoView extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8999a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f9000b;
    private AdTemplate c;
    private PhotoInfo d;
    private FrameLayout e;
    private int f;
    private long g;
    private float h;
    private RectF i;
    private Path j;

    public EpisodePhotoView(@NonNull Context context) {
        super(context);
        setLayerType(1, null);
        this.h = ao.a(context, 4.0f);
    }

    public EpisodePhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        this.h = ao.a(context, 4.0f);
    }

    private void c() {
        String g = d.g(this.d);
        if (TextUtils.isEmpty(g)) {
            g = d.d(this.d);
        }
        KSImageLoader.loadImage(this.f8999a, g, this.c, KSImageLoader.IMGOPTION_TUBE);
    }

    private void d() {
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        e.a(this.c);
    }

    public void a(int i, long j) {
        this.f = i;
        this.g = j;
    }

    protected void b() {
        this.f8999a = (ImageView) findViewById(R.id.ksad_tube_trend_episode_cover);
        this.e = (FrameLayout) findViewById(R.id.ksad_tube_trend_episode_more);
        this.f9000b = (TextView) findViewById(R.id.ksad_tube_trend_episode_name);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        if (this.i == null) {
            this.j = new Path();
            this.i = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            this.i.right = canvas.getWidth();
            this.i.bottom = canvas.getHeight();
            this.j.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        fArr[0] = this.h;
        fArr[1] = this.h;
        fArr[2] = this.h;
        fArr[3] = this.h;
        fArr[4] = this.h;
        fArr[5] = this.h;
        fArr[6] = this.h;
        fArr[7] = this.h;
        this.j.addRoundRect(this.i, fArr, Path.Direction.CW);
        canvas.clipPath(this.j);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public int getPosition() {
        return this.f;
    }

    public AdTemplate getTemplateData() {
        return this.c;
    }

    public long getTubeId() {
        return this.g;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setLookMoreVisibility(boolean z) {
        if (z) {
            this.e.setVisibility(0);
            this.f9000b.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.f9000b.setVisibility(0);
    }

    public void setRadius(float f) {
        this.h = f;
        invalidate();
    }

    public void setTemplateData(@NonNull AdTemplate adTemplate) {
        this.c = adTemplate;
        this.d = c.k(this.c);
        if (this.d == null) {
            return;
        }
        d();
        c();
        this.f9000b.setText(d.B(this.d));
        this.f9000b.setVisibility(0);
    }
}
