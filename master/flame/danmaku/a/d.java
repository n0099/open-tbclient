package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static RectF nvA;
    private static boolean nvB = true;
    private static boolean nvC = true;
    public static Paint nvy = new Paint();
    public static Paint nvz;

    static {
        nvy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nvy.setColor(0);
        nvA = new RectF();
    }

    public static void ay(boolean z, boolean z2) {
        nvB = z;
        nvC = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nvz == null) {
            nvz = new Paint();
            nvz.setColor(SupportMenu.CATEGORY_MASK);
            nvz.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nvz.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nvz);
    }

    public static void e(Canvas canvas) {
        if (nvB) {
            if (nvC) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nvA.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nvA);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nvA.set(f, f2, f3, f4);
        a(canvas, nvA);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nvy);
        }
    }
}
