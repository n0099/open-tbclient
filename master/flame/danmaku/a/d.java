package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint oUv;
    public static RectF oUw;
    private static boolean oUx = true;
    private static boolean oUy = true;
    public static Paint oUu = new Paint();

    static {
        oUu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        oUu.setColor(0);
        oUw = new RectF();
    }

    public static void aH(boolean z, boolean z2) {
        oUx = z;
        oUy = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (oUv == null) {
            oUv = new Paint();
            oUv.setColor(SupportMenu.CATEGORY_MASK);
            oUv.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (oUv.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, oUv);
    }

    public static void e(Canvas canvas) {
        if (oUx) {
            if (oUy) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        oUw.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, oUw);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        oUw.set(f, f2, f3, f4);
        c(canvas, oUw);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, oUu);
        }
    }
}
