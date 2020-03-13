package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nFg;
    public static RectF nFh;
    private static boolean nFi = true;
    private static boolean nFj = true;
    public static Paint nFf = new Paint();

    static {
        nFf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nFf.setColor(0);
        nFh = new RectF();
    }

    public static void aA(boolean z, boolean z2) {
        nFi = z;
        nFj = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nFg == null) {
            nFg = new Paint();
            nFg.setColor(SupportMenu.CATEGORY_MASK);
            nFg.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nFg.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nFg);
    }

    public static void e(Canvas canvas) {
        if (nFi) {
            if (nFj) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nFh.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nFh);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nFh.set(f, f2, f3, f4);
        a(canvas, nFh);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nFf);
        }
    }
}
