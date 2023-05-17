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
/* loaded from: classes9.dex */
public class KsSplashSlidePathView extends ImageView {
    public Path Be;
    public Paint Bf;
    public float Bg;
    public float Bh;
    public float Bi;
    public float Bj;
    public int Bk;
    public a Bl;
    public GestureDetector kE;

    /* loaded from: classes9.dex */
    public interface a {
        void a(float f, float f2, float f3, float f4);

        void kt();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.Bk = Color.parseColor("#66ffffff");
        init();
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bk = Color.parseColor("#66ffffff");
        init();
    }

    private void a(MotionEvent motionEvent) {
        if (this.kE.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Be.reset();
            this.Bg = motionEvent.getX();
            float y = motionEvent.getY();
            this.Bh = y;
            float f = this.Bg;
            this.Bi = f;
            this.Bj = y;
            this.Be.moveTo(f, y);
            invalidate();
            if (this.Bl != null) {
            }
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            b(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else {
            this.Be.reset();
            invalidate();
            a aVar = this.Bl;
            if (aVar != null) {
                aVar.a(this.Bg, this.Bh, motionEvent.getX(), motionEvent.getY());
            }
        }
    }

    private void b(float f, float f2) {
        float abs = Math.abs(f - this.Bi);
        float abs2 = Math.abs(f2 - this.Bj);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.Be;
            float f3 = this.Bi;
            float f4 = this.Bj;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.Bi = f;
            this.Bj = f2;
        }
    }

    private void init() {
        this.Be = new Path();
        Paint paint = new Paint();
        this.Bf = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.Bf.setStrokeWidth(com.kwad.sdk.b.kwai.a.a(getContext(), 15.0f));
        this.Bf.setStyle(Paint.Style.STROKE);
        this.Bf.setColor(this.Bk);
        this.Bf.setDither(true);
        this.kE = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
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
                if (KsSplashSlidePathView.this.Bl != null) {
                    KsSplashSlidePathView.this.Bl.kt();
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.Be, this.Bf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.Bl = aVar;
    }
}
