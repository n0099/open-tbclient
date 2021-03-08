package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ss.android.downloadlib.f.i;
/* loaded from: classes6.dex */
public class ClipImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7736a;
    private Path b;
    private RectF c;
    private Paint d;
    private float[] e;

    public ClipImageView(Context context) {
        super(context);
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    protected void a(Context context) {
        this.b = new Path();
        this.c = new RectF();
        this.d = new Paint(1);
        this.d.setStrokeWidth(i.a(context, 0.5f));
        this.d.setColor(Color.parseColor("#dddddd"));
    }

    public void setRadius(float[] fArr) {
        if (fArr != null && fArr.length == 8) {
            this.e = fArr;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7736a) {
            this.b.reset();
            this.c.set(0.0f, 0.0f, getWidth(), getHeight());
            if (this.e != null) {
                this.b.addRoundRect(this.c, this.e, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.b);
        }
        super.onDraw(canvas);
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            setRadius(new float[]{i, i, i, i, i, i, i, i});
        }
    }

    public void setClip(boolean z) {
        this.f7736a = z;
    }
}
