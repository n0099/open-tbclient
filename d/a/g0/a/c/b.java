package d.a.g0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import d.a.d0.b.g.i;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f43589a;

    public b(Context context) {
        this.f43589a = context;
    }

    public Bitmap a(String str, d.a.g0.a.e.a aVar) {
        File a2 = i.a(str);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return BitmapFactory.decodeFile(a2.getAbsolutePath());
        }
        return MaterialLoader.k(this.f43589a).i(str, aVar);
    }

    public String b(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        try {
            File a2 = i.a(str);
            if (a2 != null && a2.exists() && a2.isFile()) {
                return a2.getAbsolutePath();
            }
            return MaterialLoader.k(this.f43589a).m(str, materialCacheType);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean c(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        return MaterialLoader.k(this.f43589a).o(str, materialCacheType) || d(str);
    }

    public final boolean d(String str) {
        File a2 = i.a(str);
        return a2 != null && a2.exists() && a2.isFile();
    }
}
