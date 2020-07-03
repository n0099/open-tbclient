package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nSv;
    public static RectF nSw;
    private static boolean nSx = true;
    private static boolean nSy = true;
    public static Paint nSu = new Paint();

    static {
        nSu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nSu.setColor(0);
        nSw = new RectF();
    }

    public static void az(boolean z, boolean z2) {
        nSx = z;
        nSy = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nSv == null) {
            nSv = new Paint();
            nSv.setColor(SupportMenu.CATEGORY_MASK);
            nSv.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nSv.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nSv);
    }

    public static void e(Canvas canvas) {
        if (nSx) {
            if (nSy) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nSw.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nSw);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nSw.set(f, f2, f3, f4);
        a(canvas, nSw);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nSu);
        }
    }
}
