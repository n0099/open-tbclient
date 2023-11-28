package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class KsSplashSlidePathView extends ImageView {
    public Path GL;
    public Paint GM;
    public float GN;
    public float GO;
    public float GP;
    public float GQ;
    public int GR;
    public a GS;
    public GestureDetector GT;

    /* loaded from: classes10.dex */
    public interface a {
        void a(float f, float f2, float f3, float f4);

        void ln();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.GR = Color.parseColor("#66ffffff");
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.GL, this.GM);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.GS = aVar;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GR = Color.parseColor("#66ffffff");
        init();
    }

    private void c(float f, float f2) {
        float abs = Math.abs(f - this.GP);
        float abs2 = Math.abs(f2 - this.GQ);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.GL;
            float f3 = this.GP;
            float f4 = this.GQ;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.GP = f;
            this.GQ = f2;
        }
    }

    private void b(MotionEvent motionEvent) {
        if (this.GT.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    c(motionEvent.getX(), motionEvent.getY());
                    invalidate();
                    return;
                }
                return;
            }
            this.GL.reset();
            invalidate();
            a aVar = this.GS;
            if (aVar != null) {
                aVar.a(this.GN, this.GO, motionEvent.getX(), motionEvent.getY());
                return;
            }
            return;
        }
        this.GL.reset();
        this.GN = motionEvent.getX();
        float y = motionEvent.getY();
        this.GO = y;
        float f = this.GN;
        this.GP = f;
        this.GQ = y;
        this.GL.moveTo(f, y);
        invalidate();
        if (this.GS != null) {
        }
    }

    private void init() {
        this.GL = new Path();
        Paint paint = new Paint();
        this.GM = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.GM.setStrokeWidth(com.kwad.sdk.d.a.a.a(getContext(), 15.0f));
        this.GM.setStyle(Paint.Style.STROKE);
        this.GM.setColor(this.GR);
        this.GM.setDither(true);
        this.GT = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.GS != null) {
                    KsSplashSlidePathView.this.GS.ln();
                    return true;
                }
                return false;
            }
        });
    }
}
