package d.b.g0.a.e0.t;

import android.os.Environment;
import android.util.Log;
import d.b.g0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44672c = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public File f44673b = o();

    @Override // d.b.g0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar != null && this.f44673b.exists()) {
            File file = this.f44673b;
            File file2 = new File(file, cVar.f49315g + File.separator + cVar.p);
            if (file2.exists()) {
                try {
                    if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                        if (f44672c) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                        return false;
                    }
                    File j = j(cVar.f49316h, cVar.f49315g, cVar.i);
                    if (j == null) {
                        if (f44672c) {
                            Log.e("SdCardPresetController", "获取解压路径失败");
                        }
                        return false;
                    }
                    return n(new BufferedInputStream(new FileInputStream(file2)), j);
                } catch (IOException e2) {
                    if (f44672c) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.b.g0.a.e0.t.b
    public String f(String str) {
        if (this.f44673b.exists()) {
            File file = this.f44673b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (file2.exists()) {
                return d.b.g0.p.d.r(file2);
            }
            return null;
        }
        return null;
    }

    @Override // d.b.g0.a.e0.t.b
    public String i() {
        if (this.f44673b.exists()) {
            File file = new File(this.f44673b, "preset_list.json");
            if (file.exists()) {
                return d.b.g0.p.d.r(file);
            }
            return null;
        }
        return null;
    }

    public final File o() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
