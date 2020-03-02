package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nEV;
    public static RectF nEW;
    private static boolean nEX = true;
    private static boolean nEY = true;
    public static Paint nEU = new Paint();

    static {
        nEU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nEU.setColor(0);
        nEW = new RectF();
    }

    public static void aA(boolean z, boolean z2) {
        nEX = z;
        nEY = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nEV == null) {
            nEV = new Paint();
            nEV.setColor(SupportMenu.CATEGORY_MASK);
            nEV.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nEV.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nEV);
    }

    public static void e(Canvas canvas) {
        if (nEX) {
            if (nEY) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nEW.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nEW);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nEW.set(f, f2, f3, f4);
        a(canvas, nEW);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nEU);
        }
    }
}
