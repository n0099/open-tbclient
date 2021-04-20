package d.b.h0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
/* loaded from: classes3.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f50196a;

    /* renamed from: b  reason: collision with root package name */
    public int f50197b;

    public static ImageOperation g(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "resize";
        imageOperation.actionParam = i + "," + i2;
        return imageOperation;
    }

    @Override // d.b.h0.b0.g.b
    public String a() {
        return "resize";
    }

    @Override // d.b.h0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        d.b.h0.a0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.resizeBitmap(bitmap, this.f50196a, this.f50197b, z);
    }

    @Override // d.b.h0.b0.g.b
    public Bitmap c(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, this.f50196a, this.f50197b), true);
    }

    @Override // d.b.h0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return;
        }
        this.f50196a = d.b.c.e.m.b.d(split[0], 0);
        this.f50197b = d.b.c.e.m.b.d(split[1], 0);
    }

    public int e() {
        return this.f50197b;
    }

    public int f() {
        return this.f50196a;
    }
}
