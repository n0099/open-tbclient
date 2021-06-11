package d.a.m0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f52616a = 0;

    public static ImageOperation e(int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i2);
        return imageOperation;
    }

    @Override // d.a.m0.b0.g.b
    public String a() {
        return "rotate";
    }

    @Override // d.a.m0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        d.a.m0.a0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
        int i2 = this.f52616a;
        if (i2 == 0 || i2 == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.f52616a);
        }
        return (i2 == 2 || i2 == 3) ? BitmapHelper.reversalBitmap(bitmap, this.f52616a) : bitmap;
    }

    @Override // d.a.m0.b0.g.b
    public Bitmap c(String str) throws Exception {
        int max = Math.max(l.k(TbadkCoreApplication.getInst().getApp()), l.i(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }

    @Override // d.a.m0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        this.f52616a = Integer.parseInt(str);
    }
}
