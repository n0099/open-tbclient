package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
/* loaded from: classes8.dex */
public class c extends ImageView {
    public final String a;
    public boolean b;
    public Matrix c;
    public Matrix d;
    public int e;
    public float f;
    public float g;
    public Bitmap h;
    public boolean i;
    public float j;
    public float k;
    public PointF l;
    public PointF m;
    public float n;
    public float o;
    public Rect p;

    private void a() {
    }

    public c(Context context) {
        super(context);
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private void a(PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        float f4 = this.p.left - f;
        float f5 = 1.0f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f6 = (f + width) - this.p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float width2 = this.p.width() * f4;
        Rect rect = this.p;
        float f7 = (width2 / (f6 + f4)) + rect.left;
        float f8 = rect.top - f2;
        float f9 = (f2 + height) - rect.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        if (f9 > 1.0f) {
            f5 = f9;
        }
        pointF.set(f7, ((this.p.height() * f8) / (f5 + f8)) + this.p.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Rect rect;
        boolean z;
        if (this.h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        Animation animation = null;
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            Matrix matrix = this.c;
            PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.m;
            animation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.o = f10;
                Matrix matrix2 = this.c;
                PointF pointF3 = this.m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.o;
                PointF pointF4 = this.m;
                animation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                int i = this.p.left;
                float f12 = i - f;
                float f13 = rect.top - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = this.p.top;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = this.p.left - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = this.p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    animation = new TranslateAnimation(fArr[2] - f, 0.0f, fArr[5] - f2, 0.0f);
                } else {
                    setImageMatrix(this.c);
                }
            }
        }
        if (animation != null) {
            this.i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        this.c.getValues(r0);
        float max = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * max) - this.p.height()) / 2.0f);
        this.k = height;
        float[] fArr = {max, 0.0f, this.j, 0.0f, max, height};
        this.c.setValues(fArr);
        float min = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = min;
        this.g = max;
        if (min < max) {
            this.f = max;
        }
        setImageMatrix(this.c);
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 6) goto L14;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 5) {
                        float a = a(motionEvent);
                        this.n = a;
                        if (a > 10.0f) {
                            this.d.set(this.c);
                            a(this.m);
                            this.e = 2;
                        }
                    }
                } else {
                    int i = this.e;
                    if (i == 1) {
                        this.c.set(this.d);
                        this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                        setImageMatrix(this.c);
                    } else if (i == 2) {
                        Matrix matrix = this.c;
                        matrix.set(matrix);
                        float a2 = a(motionEvent);
                        if (a2 > 10.0f) {
                            this.c.set(this.d);
                            float f = a2 / this.n;
                            Matrix matrix2 = this.c;
                            PointF pointF = this.m;
                            matrix2.postScale(f, f, pointF.x, pointF.y);
                        }
                        setImageMatrix(this.c);
                    }
                }
            }
            b();
            this.e = 0;
        } else {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        }
        this.b = true;
        return true;
    }
}
