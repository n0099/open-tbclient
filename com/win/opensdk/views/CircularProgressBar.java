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
/* loaded from: classes3.dex */
public class CircularProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private int f13763a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f76a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f13764b;

    /* renamed from: case  reason: not valid java name */
    private int f77case;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private String f78java;
    private final Paint qlB;
    private final RectF qlC;
    private final Paint qlG;

    public CircularProgressBar(Context context) {
        super(context);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f13763a = 0;
        this.qlC = new RectF();
        this.qlB = new Paint();
        this.qlG = new Paint();
        this.f76a = new Paint();
        this.f13764b = new Paint();
        eIX();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f13763a = 0;
        this.qlC = new RectF();
        this.qlB = new Paint();
        this.qlG = new Paint();
        this.f76a = new Paint();
        this.f13764b = new Paint();
        eIX();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f13763a = 0;
        this.qlC = new RectF();
        this.qlB = new Paint();
        this.qlG = new Paint();
        this.f76a = new Paint();
        this.f13764b = new Paint();
        eIX();
    }

    private void eIX() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f13763a = bi.k(getContext(), 2.5f) + 1;
        this.qlB.setColor(this.f77case);
        this.qlG.setColor(this.java);
        this.f76a.setColor(this.f77case);
        this.f13764b.setColor(this.java);
        this.qlB.setAntiAlias(true);
        this.qlB.setStyle(Paint.Style.STROKE);
        this.qlB.setStrokeWidth(this.f13763a);
        this.qlG.setAntiAlias(true);
        this.qlG.setStyle(Paint.Style.STROKE);
        this.qlG.setStrokeWidth(this.f13763a);
        this.f76a.setAntiAlias(true);
        this.f76a.setStyle(Paint.Style.FILL);
        this.f76a.setStrokeWidth(this.f13763a);
        this.f13764b.setTextSize(14.0f);
        this.f13764b.setStyle(Paint.Style.FILL);
        this.f13764b.setAntiAlias(true);
        this.f13764b.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawArc(this.qlC, 0.0f, 360.0f, false, this.f76a);
        canvas.drawArc(this.qlC, 0.0f, 360.0f, false, this.qlG);
        canvas.drawArc(this.qlC, 270.0f, -(getMax() > 0 ? (getProgress() / getMax()) * 360.0f : 0.0f), false, this.qlB);
        if (!TextUtils.isEmpty(this.f78java)) {
            canvas.drawText(this.f78java, (int) ((getMeasuredWidth() / 2) - (this.f13764b.measureText(this.f78java) / 2.0f)), (int) ((getMeasuredHeight() / 2) + (Math.abs(this.f13764b.descent() + this.f13764b.ascent()) / 2.0f)), this.f13764b);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension((this.f13763a * 2) + min, (this.f13763a * 2) + min);
        this.qlC.set(this.f13763a, this.f13763a, this.f13763a + min, min + this.f13763a);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    public synchronized void setTitle(String str) {
        if (str.equalsIgnoreCase("X")) {
            this.f78java = Html.fromHtml("&#xd7;").toString();
            this.f13764b.setTextSize(bi.k(getContext(), 24.0f));
        } else {
            this.f78java = str;
            this.f13764b.setTextSize(bi.k(getContext(), 14.0f));
        }
        invalidate();
    }

    public String getTitle() {
        return this.f78java;
    }
}
