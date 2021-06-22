package d.a.m0.a.m1.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class d extends a {
    @Override // d.a.m0.a.m1.i.a
    public boolean a(Bitmap bitmap, Rect rect) {
        if (a.f47274c) {
            Log.d("SolidErrorPageParser", "SolidErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int i2 = 0;
        for (int i3 = rect.left + 1; i3 < rect.right - 1; i3++) {
            for (int i4 = rect.top + 1; i4 < rect.bottom - 1; i4++) {
                int pixel = bitmap.getPixel(i3, i4);
                if (i2 == 0) {
                    i2 = pixel;
                }
                if (i2 != pixel && pixel != 0) {
                    if (k.f46983a) {
                        Log.d("SolidErrorPageParser", "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i3 + "," + i4 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return false;
                }
            }
        }
        if (a.f47274c) {
            Log.d("SolidErrorPageParser", "color = " + i2 + "图片大小 " + rect.width() + " x " + rect.height());
        }
        return true;
    }
}
