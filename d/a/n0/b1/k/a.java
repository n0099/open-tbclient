package d.a.n0.b1.k;

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
    public static final String f52865d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    /* renamed from: a  reason: collision with root package name */
    public String f52866a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f52867b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52868c = false;

    public static String a() {
        return f52865d + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public boolean b() {
        return this.f52868c;
    }

    public void c(boolean z) {
        this.f52868c = z;
    }

    public void d(String str) {
        this.f52866a = a() + str + "/";
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        if (k.isEmpty(this.f52866a)) {
            return null;
        }
        String str = this.f52866a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
        d.a.c.k.d.a aVar = (d.a.c.k.d.a) d.h().n(str, 36, new Object[0]);
        if (aVar == null && b()) {
            if (this.f52867b == null) {
                this.f52867b = new LocalFileImageLoaderProc();
            }
            aVar = this.f52867b.getBitmapFromFile(str, 0, 0);
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
