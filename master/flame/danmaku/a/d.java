package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes4.dex */
public class d {
    public static Paint nDW;
    public static RectF nDX;
    private static boolean nDY = true;
    private static boolean nDZ = true;
    public static Paint nDV = new Paint();

    static {
        nDV.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nDV.setColor(0);
        nDX = new RectF();
    }

    public static void ay(boolean z, boolean z2) {
        nDY = z;
        nDZ = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nDW == null) {
            nDW = new Paint();
            nDW.setColor(SupportMenu.CATEGORY_MASK);
            nDW.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nDW.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nDW);
    }

    public static void e(Canvas canvas) {
        if (nDY) {
            if (nDZ) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nDX.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nDX);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nDX.set(f, f2, f3, f4);
        a(canvas, nDX);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nDV);
        }
    }
}
