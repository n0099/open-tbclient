package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint pVl;
    public static RectF pVm;
    private static boolean pVn = true;
    private static boolean pVo = true;
    public static Paint pVk = new Paint();

    static {
        pVk.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        pVk.setColor(0);
        pVm = new RectF();
    }

    public static void aN(boolean z, boolean z2) {
        pVn = z;
        pVo = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (pVl == null) {
            pVl = new Paint();
            pVl.setColor(SupportMenu.CATEGORY_MASK);
            pVl.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (pVl.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, pVl);
    }

    public static void e(Canvas canvas) {
        if (pVn) {
            if (pVo) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        pVm.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, pVm);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        pVm.set(f, f2, f3, f4);
        c(canvas, pVm);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, pVk);
        }
    }
}
