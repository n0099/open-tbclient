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
import com.win.opensdk.bi;
/* loaded from: classes4.dex */
public class CircularProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private int f14061a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f77a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f14062b;

    /* renamed from: case  reason: not valid java name */
    private int f78case;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private String f79java;
    private final Paint qfC;
    private final Paint qfx;
    private final RectF qfy;

    public CircularProgressBar(Context context) {
        super(context);
        this.java = Color.parseColor("#787878");
        this.f78case = Color.parseColor("#ffffff");
        this.f79java = "";
        this.f14061a = 0;
        this.qfy = new RectF();
        this.qfx = new Paint();
        this.qfC = new Paint();
        this.f77a = new Paint();
        this.f14062b = new Paint();
        eKp();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.java = Color.parseColor("#787878");
        this.f78case = Color.parseColor("#ffffff");
        this.f79java = "";
        this.f14061a = 0;
        this.qfy = new RectF();
        this.qfx = new Paint();
        this.qfC = new Paint();
        this.f77a = new Paint();
        this.f14062b = new Paint();
        eKp();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.java = Color.parseColor("#787878");
        this.f78case = Color.parseColor("#ffffff");
        this.f79java = "";
        this.f14061a = 0;
        this.qfy = new RectF();
        this.qfx = new Paint();
        this.qfC = new Paint();
        this.f77a = new Paint();
        this.f14062b = new Paint();
        eKp();
    }

    private void eKp() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f14061a = bi.k(getContext(), 2.5f) + 1;
        this.qfx.setColor(this.f78case);
        this.qfC.setColor(this.java);
        this.f77a.setColor(this.f78case);
        this.f14062b.setColor(this.java);
        this.qfx.setAntiAlias(true);
        this.qfx.setStyle(Paint.Style.STROKE);
        this.qfx.setStrokeWidth(this.f14061a);
        this.qfC.setAntiAlias(true);
        this.qfC.setStyle(Paint.Style.STROKE);
        this.qfC.setStrokeWidth(this.f14061a);
        this.f77a.setAntiAlias(true);
        this.f77a.setStyle(Paint.Style.FILL);
        this.f77a.setStrokeWidth(this.f14061a);
        this.f14062b.setTextSize(14.0f);
        this.f14062b.setStyle(Paint.Style.FILL);
        this.f14062b.setAntiAlias(true);
        this.f14062b.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawArc(this.qfy, 0.0f, 360.0f, false, this.f77a);
        canvas.drawArc(this.qfy, 0.0f, 360.0f, false, this.qfC);
        canvas.drawArc(this.qfy, 270.0f, -(getMax() > 0 ? (getProgress() / getMax()) * 360.0f : 0.0f), false, this.qfx);
        if (!TextUtils.isEmpty(this.f79java)) {
            canvas.drawText(this.f79java, (int) ((getMeasuredWidth() / 2) - (this.f14062b.measureText(this.f79java) / 2.0f)), (int) ((getMeasuredHeight() / 2) + (Math.abs(this.f14062b.descent() + this.f14062b.ascent()) / 2.0f)), this.f14062b);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension((this.f14061a * 2) + min, (this.f14061a * 2) + min);
        this.qfy.set(this.f14061a, this.f14061a, this.f14061a + min, min + this.f14061a);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    public synchronized void setTitle(String str) {
        if (str.equalsIgnoreCase("X")) {
            this.f79java = Html.fromHtml("&#xd7;").toString();
            this.f14062b.setTextSize(bi.k(getContext(), 24.0f));
        } else {
            this.f79java = str;
            this.f14062b.setTextSize(bi.k(getContext(), 14.0f));
        }
        invalidate();
    }

    public String getTitle() {
        return this.f79java;
    }
}
