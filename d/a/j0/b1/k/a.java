package d.a.j0.b1.k;

import android.graphics.Bitmap;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
/* loaded from: classes3.dex */
public class a implements ImageAssetDelegate {

    /* renamed from: d  reason: collision with root package name */
    public static final String f49059d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    /* renamed from: a  reason: collision with root package name */
    public String f49060a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f49061b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49062c = false;

    public static String a() {
        return f49059d + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public boolean b() {
        return this.f49062c;
    }

    public void c(boolean z) {
        this.f49062c = z;
    }

    public void d(String str) {
        this.f49060a = a() + str + "/";
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        if (k.isEmpty(this.f49060a)) {
            return null;
        }
        String str = this.f49060a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
        d.a.c.j.d.a aVar = (d.a.c.j.d.a) d.h().n(str, 36, new Object[0]);
        if (aVar == null && b()) {
            if (this.f49061b == null) {
                this.f49061b = new LocalFileImageLoaderProc();
            }
            aVar = this.f49061b.getBitmapFromFile(str, 0, 0);
        }
        if (aVar != null && aVar.p() != null) {
            Bitmap p = aVar.p();
            try {
                return p.copy(p.getConfig(), false);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                BdLog.e(e2);
            }
        }
        d.h().m(str, 36, null, null);
        return null;
    }
}
