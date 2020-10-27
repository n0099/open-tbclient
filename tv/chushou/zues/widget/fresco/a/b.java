package tv.chushou.zues.widget.fresco.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.facebook.cache.common.g;
/* loaded from: classes6.dex */
public class b extends com.facebook.imagepipeline.request.a {
    private static final b qff = new b();
    private static final com.facebook.cache.common.b qfe = new g("GrayPostprocessor");

    public static b eEr() {
        return qff;
    }

    private b() {
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public String getName() {
        return "GrayPostprocessor";
    }

    @Override // com.facebook.imagepipeline.request.a
    public void al(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b ene() {
        return qfe;
    }
}
