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
    private int f14060a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f76a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f14061b;

    /* renamed from: case  reason: not valid java name */
    private int f77case;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private String f78java;
    private final Paint qdP;
    private final RectF qdQ;
    private final Paint qdU;

    public CircularProgressBar(Context context) {
        super(context);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f14060a = 0;
        this.qdQ = new RectF();
        this.qdP = new Paint();
        this.qdU = new Paint();
        this.f76a = new Paint();
        this.f14061b = new Paint();
        eJL();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f14060a = 0;
        this.qdQ = new RectF();
        this.qdP = new Paint();
        this.qdU = new Paint();
        this.f76a = new Paint();
        this.f14061b = new Paint();
        eJL();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.java = Color.parseColor("#787878");
        this.f77case = Color.parseColor("#ffffff");
        this.f78java = "";
        this.f14060a = 0;
        this.qdQ = new RectF();
        this.qdP = new Paint();
        this.qdU = new Paint();
        this.f76a = new Paint();
        this.f14061b = new Paint();
        eJL();
    }

    private void eJL() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f14060a = bi.k(getContext(), 2.5f) + 1;
        this.qdP.setColor(this.f77case);
        this.qdU.setColor(this.java);
        this.f76a.setColor(this.f77case);
        this.f14061b.setColor(this.java);
        this.qdP.setAntiAlias(true);
        this.qdP.setStyle(Paint.Style.STROKE);
        this.qdP.setStrokeWidth(this.f14060a);
        this.qdU.setAntiAlias(true);
        this.qdU.setStyle(Paint.Style.STROKE);
        this.qdU.setStrokeWidth(this.f14060a);
        this.f76a.setAntiAlias(true);
        this.f76a.setStyle(Paint.Style.FILL);
        this.f76a.setStrokeWidth(this.f14060a);
        this.f14061b.setTextSize(14.0f);
        this.f14061b.setStyle(Paint.Style.FILL);
        this.f14061b.setAntiAlias(true);
        this.f14061b.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawArc(this.qdQ, 0.0f, 360.0f, false, this.f76a);
        canvas.drawArc(this.qdQ, 0.0f, 360.0f, false, this.qdU);
        canvas.drawArc(this.qdQ, 270.0f, -(getMax() > 0 ? (getProgress() / getMax()) * 360.0f : 0.0f), false, this.qdP);
        if (!TextUtils.isEmpty(this.f78java)) {
            canvas.drawText(this.f78java, (int) ((getMeasuredWidth() / 2) - (this.f14061b.measureText(this.f78java) / 2.0f)), (int) ((getMeasuredHeight() / 2) + (Math.abs(this.f14061b.descent() + this.f14061b.ascent()) / 2.0f)), this.f14061b);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension((this.f14060a * 2) + min, (this.f14060a * 2) + min);
        this.qdQ.set(this.f14060a, this.f14060a, this.f14060a + min, min + this.f14060a);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    public synchronized void setTitle(String str) {
        if (str.equalsIgnoreCase("X")) {
            this.f78java = Html.fromHtml("&#xd7;").toString();
            this.f14061b.setTextSize(bi.k(getContext(), 24.0f));
        } else {
            this.f78java = str;
            this.f14061b.setTextSize(bi.k(getContext(), 14.0f));
        }
        invalidate();
    }

    public String getTitle() {
        return this.f78java;
    }
}
