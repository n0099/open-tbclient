package d.b.i0.u3.v.n.b;

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
    public Context f61847a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f61848b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f61849c = new Rect();

    public b(Context context) {
        this.f61847a = context;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Bitmap bitmap = this.f61848b;
        if (bitmap == null) {
            return;
        }
        this.f61849c.left = (int) (f2 - (bitmap.getWidth() / 2));
        this.f61849c.right = (int) (f2 + (this.f61848b.getWidth() / 2));
        this.f61849c.top = (int) (f3 - (this.f61848b.getHeight() / 2));
        this.f61849c.bottom = (int) (f3 + (this.f61848b.getHeight() / 2));
        canvas.drawBitmap(this.f61848b, (Rect) null, this.f61849c, (Paint) null);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        Rect rect = this.f61849c;
        return motionEvent.getX(0) >= ((float) rect.left) && motionEvent.getX(0) <= ((float) rect.right) && motionEvent.getY(0) >= ((float) rect.top) && motionEvent.getY(0) <= ((float) rect.bottom);
    }

    public void c(int i) {
        this.f61848b = BitmapHelper.getResBitmap(this.f61847a, i);
    }
}
