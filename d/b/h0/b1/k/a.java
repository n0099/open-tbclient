package d.b.h0.b1.k;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import d.a.a.g;
import d.b.c.e.l.d;
import d.b.c.e.p.k;
/* loaded from: classes3.dex */
public class a implements d.a.a.b {

    /* renamed from: d  reason: collision with root package name */
    public static final String f50331d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    /* renamed from: a  reason: collision with root package name */
    public String f50332a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f50333b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50334c = false;

    public static String b() {
        return f50331d + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    @Override // d.a.a.b
    public Bitmap a(g gVar) {
        if (k.isEmpty(this.f50332a)) {
            return null;
        }
        String str = this.f50332a + gVar.b().replace("/", "") + "/" + gVar.c();
        d.b.c.j.d.a aVar = (d.b.c.j.d.a) d.h().n(str, 36, new Object[0]);
        if (aVar == null && c()) {
            if (this.f50333b == null) {
                this.f50333b = new LocalFileImageLoaderProc();
            }
            aVar = this.f50333b.getBitmapFromFile(str, 0, 0);
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

    public boolean c() {
        return this.f50334c;
    }

    public void d(boolean z) {
        this.f50334c = z;
    }

    public void e(String str) {
        this.f50332a = b() + str + "/";
    }
}
