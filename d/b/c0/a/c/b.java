package d.b.c0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import d.b.a0.b.f.h;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f42981a;

    public b(Context context) {
        this.f42981a = context;
    }

    public Bitmap a(String str, d.b.c0.a.e.a aVar) {
        File a2 = h.a(str);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return BitmapFactory.decodeFile(a2.getAbsolutePath());
        }
        return MaterialLoader.k(this.f42981a).i(str, aVar);
    }

    public String b(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        try {
            File a2 = h.a(str);
            if (a2 != null && a2.exists() && a2.isFile()) {
                return a2.getAbsolutePath();
            }
            return MaterialLoader.k(this.f42981a).m(str, materialCacheType);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean c(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        return MaterialLoader.k(this.f42981a).o(str, materialCacheType) || d(str);
    }

    public final boolean d(String str) {
        File a2 = h.a(str);
        return a2 != null && a2.exists() && a2.isFile();
    }
}
