package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint oFg;
    public static RectF oFh;
    private static boolean oFi = true;
    private static boolean oFj = true;
    public static Paint oFf = new Paint();

    static {
        oFf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        oFf.setColor(0);
        oFh = new RectF();
    }

    public static void aI(boolean z, boolean z2) {
        oFi = z;
        oFj = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (oFg == null) {
            oFg = new Paint();
            oFg.setColor(SupportMenu.CATEGORY_MASK);
            oFg.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (oFg.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, oFg);
    }

    public static void e(Canvas canvas) {
        if (oFi) {
            if (oFj) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        oFh.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, oFh);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        oFh.set(f, f2, f3, f4);
        c(canvas, oFh);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, oFf);
        }
    }
}
