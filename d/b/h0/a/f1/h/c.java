package d.b.h0.a.f1.h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.h0.a.k;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class c extends a {
    @Override // d.b.h0.a.f1.h.a
    public boolean a(Bitmap bitmap, Rect rect) {
        Set<Integer> set;
        if (a.f45168c) {
            Log.d("SimpleErrorPageParser", "SimpleErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        try {
            int pixel = bitmap.getPixel(rect.left + 1, rect.top + 1);
            boolean z = pixel == -1 || pixel == -657931;
            if (!z && (set = this.f45170b) != null) {
                Iterator<Integer> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().intValue() == pixel) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                for (int i = rect.left + 1; i < rect.right - 1; i++) {
                    for (int i2 = rect.top + 1; i2 < rect.bottom - 1; i2++) {
                        if (pixel != bitmap.getPixel(i, i2)) {
                            if (k.f45772a) {
                                Log.d("SimpleErrorPageParser", "非白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
                            }
                            return false;
                        }
                    }
                }
                if (a.f45168c) {
                    Log.d("SimpleErrorPageParser", "白屏, 图片大小 " + rect.width() + " x " + rect.height());
                }
                return true;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            if (a.f45168c) {
                Log.d("SimpleErrorPageParser", "W:" + bitmap.getWidth() + "; H:" + bitmap.getHeight());
                e2.printStackTrace();
            }
            return false;
        }
    }
}
