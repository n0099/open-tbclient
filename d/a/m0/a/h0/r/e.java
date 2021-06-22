package d.a.m0.a.h0.r;

import android.os.Environment;
import android.util.Log;
import d.a.m0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46332c = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public File f46333b = o();

    @Override // d.a.m0.a.h0.r.b
    public boolean e(c cVar) {
        if (cVar != null && this.f46333b.exists()) {
            File file = this.f46333b;
            File file2 = new File(file, cVar.f51794g + File.separator + cVar.q);
            if (file2.exists()) {
                try {
                    if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                        if (f46332c) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                        return false;
                    }
                    File j = j(cVar.f51795h, cVar.f51794g, cVar.f51796i);
                    if (j == null) {
                        if (f46332c) {
                            Log.e("SdCardPresetController", "获取解压路径失败");
                        }
                        return false;
                    }
                    return n(new BufferedInputStream(new FileInputStream(file2)), j);
                } catch (IOException e2) {
                    if (f46332c) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.m0.a.h0.r.b
    public String f(String str) {
        if (this.f46333b.exists()) {
            File file = this.f46333b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (file2.exists()) {
                return d.a.m0.t.d.D(file2);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.m0.a.h0.r.b
    public String i() {
        if (this.f46333b.exists()) {
            File file = new File(this.f46333b, "preset_list.json");
            if (file.exists()) {
                return d.a.m0.t.d.D(file);
            }
            return null;
        }
        return null;
    }

    public final File o() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
