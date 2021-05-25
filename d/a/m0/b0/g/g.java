package d.a.m0.b0.g;

import android.graphics.Bitmap;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class g extends b {

    /* renamed from: a  reason: collision with root package name */
    public String f48944a = "";

    @Override // d.a.m0.b0.g.b
    public String a() {
        return FaceItem.DIR_STICKER;
    }

    @Override // d.a.m0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        d.a.m0.a0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.loadResizedBitmap(this.f48944a, l.k(TbadkCoreApplication.getInst()), l.i(TbadkCoreApplication.getInst()));
    }

    @Override // d.a.m0.b0.g.b
    public Bitmap c(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, l.k(TbadkCoreApplication.getInst()), l.i(TbadkCoreApplication.getInst())), true);
    }

    @Override // d.a.m0.b0.g.b
    public void d(String str) {
    }

    public void e(String str) {
        this.f48944a = str;
    }
}
