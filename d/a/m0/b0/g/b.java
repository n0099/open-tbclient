package d.a.m0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes3.dex */
public abstract class b {
    public abstract String a();

    public abstract Bitmap b(Bitmap bitmap, boolean z) throws Exception;

    public Bitmap c(String str) throws Exception {
        return b(BitmapHelper.loadBitmap(str), true);
    }

    public abstract void d(String str);
}
