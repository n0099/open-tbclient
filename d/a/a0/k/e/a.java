package d.a.a0.k.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.mobstat.Config;
import d.a.a0.k.d.d;
import d.a.a0.k.f.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.a0.k.f.a f39138a;

    public a(Context context) {
        File b2 = b(context, "bitmap");
        if (!b2.exists()) {
            b2.mkdirs();
        }
        try {
            this.f39138a = d.a.a0.k.f.a.q(b2, 1, 1, Config.FULL_TRACE_LOG_LIMIT);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap a(String str, int i2, int i3) {
        if (this.f39138a == null) {
            return null;
        }
        a.e D = this.f39138a.D(d.a.a0.k.g.b.b(str));
        if (D != null) {
            FileInputStream fileInputStream = (FileInputStream) D.c(0);
            if (i2 > 0 && i3 > 0) {
                return d.a.a0.k.g.a.b(fileInputStream.getFD(), i2, i3);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File b(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    public void c(String str) {
        if (this.f39138a == null) {
            return;
        }
        try {
            a.c B = this.f39138a.B(d.a.a0.k.g.b.b(str));
            if (B == null) {
                return;
            }
            if (d.a(str, B.e(0))) {
                B.f();
            } else {
                B.c();
            }
            this.f39138a.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
