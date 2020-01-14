package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes4.dex */
public class d {
    public static Paint nEb;
    public static RectF nEc;
    private static boolean nEd = true;
    private static boolean nEe = true;
    public static Paint nEa = new Paint();

    static {
        nEa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nEa.setColor(0);
        nEc = new RectF();
    }

    public static void ay(boolean z, boolean z2) {
        nEd = z;
        nEe = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nEb == null) {
            nEb = new Paint();
            nEb.setColor(SupportMenu.CATEGORY_MASK);
            nEb.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nEb.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nEb);
    }

    public static void e(Canvas canvas) {
        if (nEd) {
            if (nEe) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nEc.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nEc);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nEc.set(f, f2, f3, f4);
        a(canvas, nEc);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nEa);
        }
    }
}
