package d.a.n0.w3.u.n.b;

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
    public Context f66802a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f66803b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f66804c = new Rect();

    public b(Context context) {
        this.f66802a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f66803b;
        if (bitmap == null) {
            return;
        }
        this.f66804c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f66804c.right = (int) (f2 + (this.f66803b.getWidth() / 2));
        this.f66804c.top = (int) (f3 - (this.f66803b.getHeight() / 2));
        this.f66804c.bottom = (int) (f3 + (this.f66803b.getHeight() / 2));
        canvas.drawBitmap(this.f66803b, (Rect) null, this.f66804c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f66804c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i2) {
        this.f66803b = BitmapHelper.getResBitmap(this.f66802a, i2);
    }
}
