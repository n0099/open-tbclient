package d.a.o0.w3.u.n.b;

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
    public Context f66927a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f66928b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f66929c = new Rect();

    public b(Context context) {
        this.f66927a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f66928b;
        if (bitmap == null) {
            return;
        }
        this.f66929c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f66929c.right = (int) (f2 + (this.f66928b.getWidth() / 2));
        this.f66929c.top = (int) (f3 - (this.f66928b.getHeight() / 2));
        this.f66929c.bottom = (int) (f3 + (this.f66928b.getHeight() / 2));
        canvas.drawBitmap(this.f66928b, (Rect) null, this.f66929c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f66929c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i2) {
        this.f66928b = BitmapHelper.getResBitmap(this.f66927a, i2);
    }
}
