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
import com.win.opensdk.v;
/* loaded from: classes14.dex */
public class CircularProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public int f8176a;
    public int b;
    public String c;
    public int d;
    public final RectF e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final Paint i;

    public CircularProgressBar(Context context) {
        super(context);
        this.f8176a = Color.parseColor("#787878");
        this.b = Color.parseColor("#ffffff");
        this.c = "";
        this.d = 0;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        a();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8176a = Color.parseColor("#787878");
        this.b = Color.parseColor("#ffffff");
        this.c = "";
        this.d = 0;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        a();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8176a = Color.parseColor("#787878");
        this.b = Color.parseColor("#ffffff");
        this.c = "";
        this.d = 0;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        a();
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.d = v.b(getContext(), 2.5f) + 1;
        this.f.setColor(this.b);
        this.g.setColor(this.f8176a);
        this.h.setColor(this.b);
        this.i.setColor(this.f8176a);
        this.f.setAntiAlias(true);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(this.d);
        this.g.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.d);
        this.h.setAntiAlias(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setStrokeWidth(this.d);
        this.i.setTextSize(14.0f);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.i.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
    }

    public String getTitle() {
        return this.c;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        canvas.drawArc(this.e, 0.0f, 360.0f, false, this.h);
        canvas.drawArc(this.e, 0.0f, 360.0f, false, this.g);
        canvas.drawArc(this.e, 270.0f, -(getMax() > 0 ? (getProgress() / getMax()) * 360.0f : 0.0f), false, this.f);
        if (!TextUtils.isEmpty(this.c)) {
            canvas.drawText(this.c, (int) ((getMeasuredWidth() / 2) - (this.i.measureText(this.c) / 2.0f)), (int) ((getMeasuredHeight() / 2) + (Math.abs(this.i.descent() + this.i.ascent()) / 2.0f)), this.i);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        int min = Math.min(ProgressBar.getDefaultSize(getSuggestedMinimumWidth(), i), ProgressBar.getDefaultSize(getSuggestedMinimumHeight(), i2));
        int i3 = this.d;
        setMeasuredDimension((i3 * 2) + min, (i3 * 2) + min);
        RectF rectF = this.e;
        int i4 = this.d;
        rectF.set(i4, i4, min + i4, min + i4);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    public synchronized void setTitle(String str) {
        if (str.equalsIgnoreCase("X")) {
            this.c = Html.fromHtml("&#xd7;").toString();
            this.i.setTextSize(v.b(getContext(), 24.0f));
        } else {
            this.c = str;
            this.i.setTextSize(v.b(getContext(), 14.0f));
        }
        invalidate();
    }
}
