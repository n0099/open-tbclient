package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nwJ;
    public static RectF nwK;
    private static boolean nwL = true;
    private static boolean nwM = true;
    public static Paint nwI = new Paint();

    static {
        nwI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nwI.setColor(0);
        nwK = new RectF();
    }

    public static void ay(boolean z, boolean z2) {
        nwL = z;
        nwM = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nwJ == null) {
            nwJ = new Paint();
            nwJ.setColor(SupportMenu.CATEGORY_MASK);
            nwJ.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nwJ.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nwJ);
    }

    public static void e(Canvas canvas) {
        if (nwL) {
            if (nwM) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nwK.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nwK);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nwK.set(f, f2, f3, f4);
        a(canvas, nwK);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nwI);
        }
    }
}
