package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint obk;
    public static RectF obl;
    private static boolean obm = true;
    private static boolean obn = true;
    public static Paint obi = new Paint();

    static {
        obi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        obi.setColor(0);
        obl = new RectF();
    }

    public static void aA(boolean z, boolean z2) {
        obm = z;
        obn = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (obk == null) {
            obk = new Paint();
            obk.setColor(SupportMenu.CATEGORY_MASK);
            obk.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (obk.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, obk);
    }

    public static void e(Canvas canvas) {
        if (obm) {
            if (obn) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        obl.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, obl);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        obl.set(f, f2, f3, f4);
        a(canvas, obl);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, obi);
        }
    }
}
