package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint ovA;
    public static RectF ovB;
    private static boolean ovC = true;
    private static boolean ovD = true;
    public static Paint ovz = new Paint();

    static {
        ovz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ovz.setColor(0);
        ovB = new RectF();
    }

    public static void aG(boolean z, boolean z2) {
        ovC = z;
        ovD = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (ovA == null) {
            ovA = new Paint();
            ovA.setColor(SupportMenu.CATEGORY_MASK);
            ovA.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (ovA.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, ovA);
    }

    public static void e(Canvas canvas) {
        if (ovC) {
            if (ovD) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        ovB.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, ovB);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        ovB.set(f, f2, f3, f4);
        c(canvas, ovB);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, ovz);
        }
    }
}
