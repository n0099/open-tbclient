package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint naw;
    public static RectF nax;
    private static boolean nay = true;
    private static boolean naz = true;
    public static Paint nav = new Paint();

    static {
        nav.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nav.setColor(0);
        nax = new RectF();
    }

    public static void av(boolean z, boolean z2) {
        nay = z;
        naz = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (naw == null) {
            naw = new Paint();
            naw.setColor(SupportMenu.CATEGORY_MASK);
            naw.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (naw.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, naw);
    }

    public static void e(Canvas canvas) {
        if (nay) {
            if (naz) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nax.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nax);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nax.set(f, f2, f3, f4);
        a(canvas, nax);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nav);
        }
    }
}
