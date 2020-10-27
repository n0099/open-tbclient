package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint pLR;
    public static RectF pLS;
    private static boolean pLT = true;
    private static boolean pLU = true;
    public static Paint pLQ = new Paint();

    static {
        pLQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        pLQ.setColor(0);
        pLS = new RectF();
    }

    public static void aN(boolean z, boolean z2) {
        pLT = z;
        pLU = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (pLR == null) {
            pLR = new Paint();
            pLR.setColor(SupportMenu.CATEGORY_MASK);
            pLR.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (pLR.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, pLR);
    }

    public static void e(Canvas canvas) {
        if (pLT) {
            if (pLU) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        pLS.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, pLS);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        pLS.set(f, f2, f3, f4);
        c(canvas, pLS);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, pLQ);
        }
    }
}
