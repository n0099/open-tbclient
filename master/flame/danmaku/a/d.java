package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nET;
    public static RectF nEU;
    private static boolean nEV = true;
    private static boolean nEW = true;
    public static Paint nES = new Paint();

    static {
        nES.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nES.setColor(0);
        nEU = new RectF();
    }

    public static void aA(boolean z, boolean z2) {
        nEV = z;
        nEW = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nET == null) {
            nET = new Paint();
            nET.setColor(SupportMenu.CATEGORY_MASK);
            nET.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nET.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nET);
    }

    public static void e(Canvas canvas) {
        if (nEV) {
            if (nEW) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nEU.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nEU);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nEU.set(f, f2, f3, f4);
        a(canvas, nEU);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nES);
        }
    }
}
