package com.win.opensdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.win.opensdk.G;
/* loaded from: classes7.dex */
public class CircularProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public int f40069a;

    /* renamed from: b  reason: collision with root package name */
    public int f40070b;

    /* renamed from: c  reason: collision with root package name */
    public String f40071c;

    /* renamed from: d  reason: collision with root package name */
    public int f40072d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f40073e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f40074f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f40075g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f40076h;
    public final Paint i;

    public CircularProgressBar(Context context) {
        super(context);
        this.f40069a = Color.parseColor("#787878");
        this.f40070b = Color.parseColor("#ffffff");
        this.f40071c = "";
        this.f40072d = 0;
        this.f40073e = new RectF();
        this.f40074f = new Paint();
        this.f40075g = new Paint();
        this.f40076h = new Paint();
        this.i = new Paint();
        a();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40069a = Color.parseColor("#787878");
        this.f40070b = Color.parseColor("#ffffff");
        this.f40071c = "";
        this.f40072d = 0;
        this.f40073e = new RectF();
        this.f40074f = new Paint();
        this.f40075g = new Paint();
        this.f40076h = new Paint();
        this.i = new Paint();
        a();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40069a = Color.parseColor("#787878");
        this.f40070b = Color.parseColor("#ffffff");
        this.f40071c = "";
        this.f40072d = 0;
        this.f40073e = new RectF();
        this.f40074f = new Paint();
        this.f40075g = new Paint();
        this.f40076h = new Paint();
        this.i = new Paint();
        a();
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f40072d = G.b(getContext(), 2.5f) + 1;
        this.f40074f.setColor(this.f40070b);
        this.f40075g.setColor(this.f40069a);
        this.f40076h.setColor(this.f40070b);
        this.i.setColor(this.f40069a);
        this.f40074f.setAntiAlias(true);
        this.f40074f.setStyle(Paint.Style.STROKE);
        this.f40074f.setStrokeWidth(this.f40072d);
        this.f40075g.setAntiAlias(true);
        this.f40075g.setStyle(Paint.Style.STROKE);
        this.f40075g.setStrokeWidth(this.f40072d);
        this.f40076h.setAntiAlias(true);
        this.f40076h.setStyle(Paint.Style.FILL);
        this.f40076h.setStrokeWidth(this.f40072d);
        this.i.setTextSize(14.0f);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.i.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
    }

    public String getTitle() {
        return this.f40071c;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        canvas.drawArc(this.f40073e, 0.0f, 360.0f, false, this.f40076h);
        canvas.drawArc(this.f40073e, 0.0f, 360.0f, false, this.f40075g);
        canvas.drawArc(this.f40073e, 270.0f, -(getMax() > 0 ? (getProgress() / getMax()) * 360.0f : 0.0f), false, this.f40074f);
        if (!TextUtils.isEmpty(this.f40071c)) {
            canvas.drawText(this.f40071c, (int) ((getMeasuredWidth() / 2) - (this.i.measureText(this.f40071c) / 2.0f)), (int) ((Math.abs(this.i.ascent() + this.i.descent()) / 2.0f) + (getMeasuredHeight() / 2)), this.i);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        int min = Math.min(ProgressBar.getDefaultSize(getSuggestedMinimumWidth(), i), ProgressBar.getDefaultSize(getSuggestedMinimumHeight(), i2));
        int i3 = (this.f40072d * 2) + min;
        setMeasuredDimension(i3, i3);
        RectF rectF = this.f40073e;
        int i4 = this.f40072d;
        float f2 = i4;
        float f3 = min + i4;
        rectF.set(f2, f2, f3, f3);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    public synchronized void setTitle(String str) {
        Paint paint;
        int b2;
        if (str.equalsIgnoreCase("X")) {
            this.f40071c = Html.fromHtml("&#xd7;").toString();
            paint = this.i;
            b2 = G.b(getContext(), 24.0f);
        } else {
            this.f40071c = str;
            paint = this.i;
            b2 = G.b(getContext(), 14.0f);
        }
        paint.setTextSize(b2);
        invalidate();
    }
}
