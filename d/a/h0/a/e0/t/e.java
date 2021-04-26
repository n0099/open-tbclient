package d.a.h0.a.e0.t;

import android.os.Environment;
import android.util.Log;
import d.a.h0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42306c = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public File f42307b = o();

    @Override // d.a.h0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar != null && this.f42307b.exists()) {
            File file = this.f42307b;
            File file2 = new File(file, cVar.f47153g + File.separator + cVar.p);
            if (file2.exists()) {
                try {
                    if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                        if (f42306c) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                        return false;
                    }
                    File j = j(cVar.f47154h, cVar.f47153g, cVar.f47155i);
                    if (j == null) {
                        if (f42306c) {
                            Log.e("SdCardPresetController", "获取解压路径失败");
                        }
                        return false;
                    }
                    return n(new BufferedInputStream(new FileInputStream(file2)), j);
                } catch (IOException e2) {
                    if (f42306c) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.h0.a.e0.t.b
    public String f(String str) {
        if (this.f42307b.exists()) {
            File file = this.f42307b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (file2.exists()) {
                return d.a.h0.p.d.r(file2);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.h0.a.e0.t.b
    public String i() {
        if (this.f42307b.exists()) {
            File file = new File(this.f42307b, "preset_list.json");
            if (file.exists()) {
                return d.a.h0.p.d.r(file);
            }
            return null;
        }
        return null;
    }

    public final File o() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
