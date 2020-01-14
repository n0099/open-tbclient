package tv.chushou.widget.ninepatch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
/* loaded from: classes4.dex */
public class a {
    public final Bitmap bitmap;
    public final NinePatchChunk nVq;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        this.bitmap = bitmap;
        this.nVq = ninePatchChunk;
    }

    public NinePatchDrawable b(Resources resources, String str) {
        if (this.bitmap == null) {
            return null;
        }
        if (this.nVq == null) {
            return new NinePatchDrawable(resources, this.bitmap, null, new Rect(), str);
        }
        return new NinePatchDrawable(resources, this.bitmap, this.nVq.toBytes(), this.nVq.padding, str);
    }
}
