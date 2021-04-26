package d.a.j0.v3.u.n.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f62254a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f62255b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f62256c = new Rect();

    public b(Context context) {
        this.f62254a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f62255b;
        if (bitmap == null) {
            return;
        }
        this.f62256c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f62256c.right = (int) (f2 + (this.f62255b.getWidth() / 2));
        this.f62256c.top = (int) (f3 - (this.f62255b.getHeight() / 2));
        this.f62256c.bottom = (int) (f3 + (this.f62255b.getHeight() / 2));
        canvas.drawBitmap(this.f62255b, (Rect) null, this.f62256c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f62256c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i2) {
        this.f62255b = BitmapHelper.getResBitmap(this.f62254a, i2);
    }
}
