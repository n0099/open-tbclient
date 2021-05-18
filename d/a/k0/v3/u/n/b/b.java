package d.a.k0.v3.u.n.b;

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
    public Context f62978a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f62979b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f62980c = new Rect();

    public b(Context context) {
        this.f62978a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f62979b;
        if (bitmap == null) {
            return;
        }
        this.f62980c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f62980c.right = (int) (f2 + (this.f62979b.getWidth() / 2));
        this.f62980c.top = (int) (f3 - (this.f62979b.getHeight() / 2));
        this.f62980c.bottom = (int) (f3 + (this.f62979b.getHeight() / 2));
        canvas.drawBitmap(this.f62979b, (Rect) null, this.f62980c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f62980c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i2) {
        this.f62979b = BitmapHelper.getResBitmap(this.f62978a, i2);
    }
}
