package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nGT;
    public static RectF nGU;
    private static boolean nGV = true;
    private static boolean nGW = true;
    public static Paint nGS = new Paint();

    static {
        nGS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nGS.setColor(0);
        nGU = new RectF();
    }

    public static void aA(boolean z, boolean z2) {
        nGV = z;
        nGW = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nGT == null) {
            nGT = new Paint();
            nGT.setColor(SupportMenu.CATEGORY_MASK);
            nGT.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nGT.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nGT);
    }

    public static void e(Canvas canvas) {
        if (nGV) {
            if (nGW) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nGU.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nGU);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nGU.set(f, f2, f3, f4);
        a(canvas, nGU);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nGS);
        }
    }
}
