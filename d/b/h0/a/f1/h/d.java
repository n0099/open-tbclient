package d.b.h0.a.f1.h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class d extends a {
    @Override // d.b.h0.a.f1.h.a
    public boolean a(Bitmap bitmap, Rect rect) {
        if (a.f45168c) {
            Log.d("SolidErrorPageParser", "SolidErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int i = 0;
        for (int i2 = rect.left + 1; i2 < rect.right - 1; i2++) {
            for (int i3 = rect.top + 1; i3 < rect.bottom - 1; i3++) {
                int pixel = bitmap.getPixel(i2, i3);
                if (i == 0) {
                    i = pixel;
                }
                if (i != pixel && pixel != 0) {
                    if (k.f45772a) {
                        Log.d("SolidErrorPageParser", "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i2 + "," + i3 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return false;
                }
            }
        }
        if (a.f45168c) {
            Log.d("SolidErrorPageParser", "color = " + i + "图片大小 " + rect.width() + " x " + rect.height());
        }
        return true;
    }
}
