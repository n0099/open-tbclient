package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint pWO;
    public static RectF pWP;
    private static boolean pWQ = true;
    private static boolean pWR = true;
    public static Paint pWN = new Paint();

    static {
        pWN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        pWN.setColor(0);
        pWP = new RectF();
    }

    public static void aL(boolean z, boolean z2) {
        pWQ = z;
        pWR = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (pWO == null) {
            pWO = new Paint();
            pWO.setColor(SupportMenu.CATEGORY_MASK);
            pWO.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (pWO.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, pWO);
    }

    public static void e(Canvas canvas) {
        if (pWQ) {
            if (pWR) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        pWP.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, pWP);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        pWP.set(f, f2, f3, f4);
        c(canvas, pWP);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, pWN);
        }
    }
}
