package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes6.dex */
public class d {
    public static Paint ovi;
    public static RectF ovj;
    private static boolean ovk = true;
    private static boolean ovl = true;
    public static Paint ovh = new Paint();

    static {
        ovh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        ovh.setColor(0);
        ovj = new RectF();
    }

    public static void aG(boolean z, boolean z2) {
        ovk = z;
        ovl = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (ovi == null) {
            ovi = new Paint();
            ovi.setColor(SupportMenu.CATEGORY_MASK);
            ovi.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (ovi.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, ovi);
    }

    public static void e(Canvas canvas) {
        if (ovk) {
            if (ovl) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        ovj.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        c(canvas, ovj);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        ovj.set(f, f2, f3, f4);
        c(canvas, ovj);
    }

    private static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, ovh);
        }
    }
}
