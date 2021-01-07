package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
import com.qq.e.comm.util.GDTLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g extends ImageView implements com.qq.e.comm.plugin.ac.g {

    /* renamed from: a  reason: collision with root package name */
    private int f12812a;

    /* renamed from: b  reason: collision with root package name */
    private int f12813b;
    private int c;
    private int d;
    private int e;
    private Movie f;
    private int g;
    private long h;
    private float i;
    private float j;
    private Bitmap k;

    public g(Context context) {
        super(context);
        this.h = -1L;
        this.i = -1.0f;
        this.j = 0.0f;
    }

    private void a(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.h < 0) {
            this.h = currentTimeMillis;
        }
        this.f.setTime(((int) (currentTimeMillis - this.h)) % this.g);
        if (this.i < 0.0f) {
            if (Double.valueOf(this.d).doubleValue() / this.e < Double.valueOf(this.f12812a).doubleValue() / this.f12813b) {
                this.i = this.e / this.f12813b;
            } else {
                this.i = this.d / this.f12812a;
                this.j = (-(((this.f12813b * this.i) - this.e) / 2.0f)) / this.i;
            }
        }
        canvas.scale(this.i, this.i);
        this.f.draw(canvas, this.j, 0.0f);
        invalidate();
    }

    @Override // com.qq.e.comm.plugin.ac.g
    public void a(Movie movie) {
        if (movie == null) {
            GDTLogger.e("movie is null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f = movie;
        this.g = this.f.duration();
        if (this.g == 0) {
            this.g = TbConfig.NOTIFY_YUN_PUSH;
            GDTLogger.e("gif duration = 0, reset to 2500");
        }
        this.f12813b = movie.width();
        this.f12812a = movie.height();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null || !this.k.isRecycled()) {
            this.d = getHeight();
            this.e = getWidth();
            if (this.e == 0 || this.f12813b == 0) {
                super.onDraw(canvas);
            } else if (this.f != null) {
                a(canvas);
                super.onDraw(canvas);
            } else {
                if (Double.valueOf(this.d).doubleValue() / this.e < Double.valueOf(this.f12812a).doubleValue() / this.f12813b) {
                    this.c = (this.f12812a * this.e) / this.f12813b;
                    getDrawable().setBounds(0, 0, this.e, this.c);
                } else {
                    this.c = (((this.f12813b * this.d) / this.f12812a) - this.e) / 2;
                    getDrawable().setBounds(-this.c, 0, this.e + this.c, this.d);
                }
                super.onDraw(canvas);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f12812a = bitmap.getHeight();
            this.f12813b = bitmap.getWidth();
            this.k = bitmap;
            super.setImageBitmap(bitmap);
        }
    }
}
