package d.a.j0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes3.dex */
public class f extends b {

    /* renamed from: a  reason: collision with root package name */
    public float f48918a;

    @Override // d.a.j0.b0.g.b
    public String a() {
        return "round_corner";
    }

    @Override // d.a.j0.b0.g.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        if (this.f48918a <= 0.0f) {
            return bitmap;
        }
        d.a.j0.a0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.getRoundedCornerBitmap(bitmap, this.f48918a, z);
    }

    @Override // d.a.j0.b0.g.b
    public void d(String str) {
        if (str == null) {
            return;
        }
        this.f48918a = d.a.c.e.m.b.c(str, 0.0f);
    }
}
