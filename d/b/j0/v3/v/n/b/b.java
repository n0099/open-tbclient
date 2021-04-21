package d.b.j0.v3.v.n.b;

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
    public Context f64007a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f64008b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f64009c = new Rect();

    public b(Context context) {
        this.f64007a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f64008b;
        if (bitmap == null) {
            return;
        }
        this.f64009c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f64009c.right = (int) (f2 + (this.f64008b.getWidth() / 2));
        this.f64009c.top = (int) (f3 - (this.f64008b.getHeight() / 2));
        this.f64009c.bottom = (int) (f3 + (this.f64008b.getHeight() / 2));
        canvas.drawBitmap(this.f64008b, (Rect) null, this.f64009c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f64009c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i) {
        this.f64008b = BitmapHelper.getResBitmap(this.f64007a, i);
    }
}
