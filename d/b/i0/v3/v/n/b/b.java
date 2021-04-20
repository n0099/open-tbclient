package d.b.i0.v3.v.n.b;

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
    public Context f63586a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f63587b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f63588c = new Rect();

    public b(Context context) {
        this.f63586a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f63587b;
        if (bitmap == null) {
            return;
        }
        this.f63588c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f63588c.right = (int) (f2 + (this.f63587b.getWidth() / 2));
        this.f63588c.top = (int) (f3 - (this.f63587b.getHeight() / 2));
        this.f63588c.bottom = (int) (f3 + (this.f63587b.getHeight() / 2));
        canvas.drawBitmap(this.f63587b, (Rect) null, this.f63588c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f63588c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i) {
        this.f63587b = BitmapHelper.getResBitmap(this.f63586a, i);
    }
}
