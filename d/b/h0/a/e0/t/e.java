package d.b.h0.a.e0.t;

import android.os.Environment;
import android.util.Log;
import d.b.h0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45001c = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public File f45002b = o();

    @Override // d.b.h0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar != null && this.f45002b.exists()) {
            File file = this.f45002b;
            File file2 = new File(file, cVar.f49644g + File.separator + cVar.p);
            if (file2.exists()) {
                try {
                    if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                        if (f45001c) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                        return false;
                    }
                    File j = j(cVar.f49645h, cVar.f49644g, cVar.i);
                    if (j == null) {
                        if (f45001c) {
                            Log.e("SdCardPresetController", "获取解压路径失败");
                        }
                        return false;
                    }
                    return n(new BufferedInputStream(new FileInputStream(file2)), j);
                } catch (IOException e2) {
                    if (f45001c) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.b.h0.a.e0.t.b
    public String f(String str) {
        if (this.f45002b.exists()) {
            File file = this.f45002b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (file2.exists()) {
                return d.b.h0.p.d.r(file2);
            }
            return null;
        }
        return null;
    }

    @Override // d.b.h0.a.e0.t.b
    public String i() {
        if (this.f45002b.exists()) {
            File file = new File(this.f45002b, "preset_list.json");
            if (file.exists()) {
                return d.b.h0.p.d.r(file);
            }
            return null;
        }
        return null;
    }

    public final File o() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
