package d.b.h0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f49805a = 0;

    public static ImageOperation e(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // d.b.h0.b0.g.b
    public String a() {
        return "rotate";
    }

    @Override // d.b.h0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        d.b.h0.a0.c.j().h(BitmapHelper.getBitmapSize(bitmap) * 2);
        int i = this.f49805a;
        if (i == 0 || i == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.f49805a);
        }
        return (i == 2 || i == 3) ? BitmapHelper.reversalBitmap(bitmap, this.f49805a) : bitmap;
    }

    @Override // d.b.h0.b0.g.b
    public Bitmap c(String str) throws Exception {
        int max = Math.max(l.k(TbadkCoreApplication.getInst().getApp()), l.i(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }

    @Override // d.b.h0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        this.f49805a = Integer.parseInt(str);
    }
}
