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
import com.baidu.tieba.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class KSCouponLabelTextView extends TextView implements b {
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f41436b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public int f41437c;

    /* renamed from: d  reason: collision with root package name */
    public float f41438d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f41439e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f41440f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f41441g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41442h;
    public final RectF i;
    public final Path j;
    public Path k;
    public Path l;
    public final RectF m;
    public boolean n;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.f41439e = new Paint();
        this.f41440f = new Rect();
        this.f41441g = new RectF();
        this.f41442h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41439e = new Paint();
        this.f41440f = new Rect();
        this.f41441g = new RectF();
        this.f41442h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41439e = new Paint();
        this.f41440f = new Rect();
        this.f41441g = new RectF();
        this.f41442h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, i);
    }

    private void a() {
        this.f41439e.setColor(this.f41437c);
        this.f41439e.setStrokeWidth(this.f41436b);
        this.f41439e.setStyle(Paint.Style.STROKE);
        this.f41439e.setAntiAlias(true);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040318, R.attr.obfuscated_res_0x7f040325, R.attr.obfuscated_res_0x7f04032e, R.attr.obfuscated_res_0x7f04032f}, i, 0);
        int color = context.getResources().getColor(R.color.obfuscated_res_0x7f060757);
        this.a = obtainStyledAttributes.getDimension(0, 8.0f);
        this.f41436b = obtainStyledAttributes.getDimension(3, 2.0f);
        this.f41437c = obtainStyledAttributes.getColor(2, color);
        this.f41438d = obtainStyledAttributes.getDimension(1, 16.0f);
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
        float f3 = this.f41438d;
        float f4 = f2 - f3;
        rectF2.left = f4;
        rectF2.right = f4 + (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.f41438d;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.right;
        float f3 = this.f41438d;
        float f4 = f2 + f3;
        rectF2.right = f4;
        rectF2.left = f4 - (f3 * 2.0f);
        float height = rectF.height();
        float f5 = this.f41438d;
        float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
        rectF2.top = f6;
        rectF2.bottom = f6 + (f5 * 2.0f);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        int color = getResources().getColor(com.kwad.sdk.core.config.b.aM() ? R.color.obfuscated_res_0x7f060757 : R.color.obfuscated_res_0x7f060758);
        this.f41437c = color;
        setTextColor(color);
        a();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f41440f.setEmpty();
        getDrawingRect(this.f41440f);
        float f2 = this.f41436b / 2.0f;
        this.f41441g.set(this.f41440f);
        RectF rectF = this.f41441g;
        rectF.left += f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        a(rectF, this.f41442h);
        b(this.f41441g, this.i);
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
            a(this.j, this.k, this.l, this.f41441g, this.f41442h, this.i);
        } else {
            a(this.j, this.f41441g, this.f41442h, this.i);
        }
        canvas.drawPath(this.j, this.f41439e);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.n) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }
}
