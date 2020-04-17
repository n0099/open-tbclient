package master.flame.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
/* loaded from: classes5.dex */
public class d {
    public static Paint nat;
    public static RectF nau;
    private static boolean nav = true;
    private static boolean naw = true;
    public static Paint nas = new Paint();

    static {
        nas.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        nas.setColor(0);
        nau = new RectF();
    }

    public static void av(boolean z, boolean z2) {
        nav = z;
        naw = z2;
    }

    public static void c(Canvas canvas, String str) {
        if (nat == null) {
            nat = new Paint();
            nat.setColor(SupportMenu.CATEGORY_MASK);
            nat.setTextSize(30.0f);
        }
        int height = canvas.getHeight() - 50;
        a(canvas, 10.0f, height - 50, (int) (nat.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height, nat);
    }

    public static void e(Canvas canvas) {
        if (nav) {
            if (naw) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                return;
            } else {
                canvas.drawColor(0);
                return;
            }
        }
        nau.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        a(canvas, nau);
    }

    public static void a(Canvas canvas, float f, float f2, float f3, float f4) {
        nau.set(f, f2, f3, f4);
        a(canvas, nau);
    }

    private static void a(Canvas canvas, RectF rectF) {
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            canvas.drawRect(rectF, nas);
        }
    }
}
