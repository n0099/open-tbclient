package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    private static boolean nSA = true;
    private static boolean nSB = true;
    public static Paint nSx = new Paint();
    public static Paint nSy;
    public static RectF nSz;

    static {
        nSx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nSx.setColor(0);
        nSz = new RectF();
    }

    public static void az(boolean z, boolean z2) {
        nSA = z;
        nSB = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nSy == null) {
            nSy = new Paint();
            nSy.setColor(SupportMenu.CATEGORY_MASK);
            nSy.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nSy.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nSy);
    }

    public static void e(Canvas canvas) {
        if (nSA) {
            if (nSB) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nSz.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nSz);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nSz.set(f, f2, f3, f4);
        a(canvas, nSz);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nSx);
        }
    }
}
