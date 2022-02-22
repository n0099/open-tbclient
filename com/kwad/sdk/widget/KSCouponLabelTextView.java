package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class KSCouponLabelTextView extends TextView implements b {
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f58203b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public int f58204c;

    /* renamed from: d  reason: collision with root package name */
    public float f58205d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f58206e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f58207f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f58208g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f58209h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f58210i;

    /* renamed from: j  reason: collision with root package name */
    public final Path f58211j;
    public Path k;
    public Path l;
    public final RectF m;
    public boolean n;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.f58206e = new Paint();
        this.f58207f = new Rect();
        this.f58208g = new RectF();
        this.f58209h = new RectF();
        this.f58210i = new RectF();
        this.f58211j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f58206e = new Paint();
        this.f58207f = new Rect();
        this.f58208g = new RectF();
        this.f58209h = new RectF();
        this.f58210i = new RectF();
        this.f58211j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f58206e = new Paint();
        this.f58207f = new Rect();
        this.f58208g = new RectF();
        this.f58209h = new RectF();
        this.f58210i = new RectF();
        this.f58211j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, i2);
    }

    private void a() {
        this.f58206e.setColor(this.f58204c);
        this.f58206e.setStrokeWidth(this.f58203b);
        this.f58206e.setStyle(Paint.Style.STROKE);
        this.f58206e.setAntiAlias(true);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i2, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.a = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.f58203b = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.f58204c = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.f58205d = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        a();
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f2 = this.a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.k, Path.Op.DIFFERENCE);
        path.op(this.l, Path.Op.DIFFERENCE);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.a);
        this.m.set(rectF);
        RectF rectF4 = this.m;
        float f2 = rectF4.top;
        float f3 = this.a;
        rectF4.bottom = f2 + (f3 * 2.0f);
        rectF4.right = rectF4.left + (f3 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.a, rectF.top);
        this.m.set(rectF);
        RectF rectF5 = this.m;
        float f4 = rectF5.right;
        float f5 = this.a;
        rectF5.left = f4 - (f5 * 2.0f);
        rectF5.bottom = rectF5.top + (f5 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.a);
        this.m.set(rectF);
        RectF rectF6 = this.m;
        float f6 = rectF6.right;
        float f7 = this.a;
        rectF6.left = f6 - (f7 * 2.0f);
        rectF6.top = rectF6.bottom - (f7 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.a, rectF.bottom);
        this.m.set(rectF);
        RectF rectF7 = this.m;
        float f8 = rectF7.left;
        float f9 = this.a;
        rectF7.right = f8 + (f9 * 2.0f);
        rectF7.top = rectF7.bottom - (f9 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.left;
        float f3 = this.f58205d;
        float f4 = f2 - f3;
        rectF2.left = f4;
        rectF2.right = f4 + (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.f58205d;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.right;
        float f3 = this.f58205d;
        float f4 = f2 + f3;
        rectF2.right = f4;
        rectF2.left = f4 - (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.f58205d;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        int color = getResources().getColor(com.kwad.sdk.core.config.b.aM() ? R.color.ksad_reward_main_color : R.color.ksad_reward_main_color_orange);
        this.f58204c = color;
        setTextColor(color);
        a();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f58207f.setEmpty();
        getDrawingRect(this.f58207f);
        float f2 = this.f58203b / 2.0f;
        this.f58208g.set(this.f58207f);
        RectF rectF = this.f58208g;
        rectF.left += f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        a(rectF, this.f58209h);
        b(this.f58208g, this.f58210i);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.k;
            if (path == null) {
                this.k = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.l;
            if (path2 == null) {
                this.l = new Path();
            } else {
                path2.reset();
            }
            a(this.f58211j, this.k, this.l, this.f58208g, this.f58209h, this.f58210i);
        } else {
            a(this.f58211j, this.f58208g, this.f58209h, this.f58210i);
        }
        canvas.drawPath(this.f58211j, this.f58206e);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.n) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }
}
