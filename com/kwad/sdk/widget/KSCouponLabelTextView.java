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
/* loaded from: classes5.dex */
public class KSCouponLabelTextView extends TextView implements b {
    public float a;
    public float b;
    @ColorInt
    public int c;
    public float d;
    public final Paint e;
    public final Rect f;
    public final RectF g;
    public final RectF h;
    public final RectF i;
    public final Path j;
    public Path k;
    public Path l;
    public final RectF m;
    public boolean n;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.e = new Paint();
        this.f = new Rect();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Paint();
        this.f = new Rect();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Paint();
        this.f = new Rect();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, i);
    }

    private void a() {
        this.e.setColor(this.c);
        this.e.setStrokeWidth(this.b);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040368, R.attr.obfuscated_res_0x7f040375, R.attr.obfuscated_res_0x7f04037e, R.attr.obfuscated_res_0x7f04037f}, i, 0);
        int color = context.getResources().getColor(R.color.obfuscated_res_0x7f060761);
        this.a = obtainStyledAttributes.getDimension(0, 8.0f);
        this.b = obtainStyledAttributes.getDimension(3, 2.0f);
        this.c = obtainStyledAttributes.getColor(2, color);
        this.d = obtainStyledAttributes.getDimension(1, 16.0f);
        obtainStyledAttributes.recycle();
        a();
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
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
        float f = rectF4.top;
        float f2 = this.a;
        rectF4.bottom = f + (f2 * 2.0f);
        rectF4.right = rectF4.left + (f2 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.a, rectF.top);
        this.m.set(rectF);
        RectF rectF5 = this.m;
        float f3 = rectF5.right;
        float f4 = this.a;
        rectF5.left = f3 - (f4 * 2.0f);
        rectF5.bottom = rectF5.top + (f4 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.a);
        this.m.set(rectF);
        RectF rectF6 = this.m;
        float f5 = rectF6.right;
        float f6 = this.a;
        rectF6.left = f5 - (f6 * 2.0f);
        rectF6.top = rectF6.bottom - (f6 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.a, rectF.bottom);
        this.m.set(rectF);
        RectF rectF7 = this.m;
        float f7 = rectF7.left;
        float f8 = this.a;
        rectF7.right = f7 + (f8 * 2.0f);
        rectF7.top = rectF7.bottom - (f8 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.left;
        float f2 = this.d;
        float f3 = f - f2;
        rectF2.left = f3;
        rectF2.right = f3 + (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.d;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.right;
        float f2 = this.d;
        float f3 = f + f2;
        rectF2.right = f3;
        rectF2.left = f3 - (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.d;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        int color = getResources().getColor(com.kwad.sdk.core.config.b.aM() ? R.color.obfuscated_res_0x7f060761 : R.color.obfuscated_res_0x7f060762);
        this.c = color;
        setTextColor(color);
        a();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f.setEmpty();
        getDrawingRect(this.f);
        float f = this.b / 2.0f;
        this.g.set(this.f);
        RectF rectF = this.g;
        rectF.left += f;
        rectF.top += f;
        rectF.right -= f;
        rectF.bottom -= f;
        a(rectF, this.h);
        b(this.g, this.i);
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
            a(this.j, this.k, this.l, this.g, this.h, this.i);
        } else {
            a(this.j, this.g, this.h, this.i);
        }
        canvas.drawPath(this.j, this.e);
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
