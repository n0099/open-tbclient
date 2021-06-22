package d.a.n0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
/* loaded from: classes3.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f52721a;

    /* renamed from: b  reason: collision with root package name */
    public int f52722b;

    public static ImageOperation g(int i2, int i3) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "resize";
        imageOperation.actionParam = i2 + "," + i3;
        return imageOperation;
    }

    @Override // d.a.n0.b0.g.b
    public String a() {
        return "resize";
    }

    @Override // d.a.n0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        d.a.n0.a0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.resizeBitmap(bitmap, this.f52721a, this.f52722b, z);
    }

    @Override // d.a.n0.b0.g.b
    public Bitmap c(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, this.f52721a, this.f52722b), true);
    }

    @Override // d.a.n0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return;
        }
        this.f52721a = d.a.c.e.m.b.d(split[0], 0);
        this.f52722b = d.a.c.e.m.b.d(split[1], 0);
    }

    public int e() {
        return this.f52722b;
    }

    public int f() {
        return this.f52721a;
    }
}
