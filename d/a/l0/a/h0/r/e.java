package d.a.l0.a.h0.r;

import android.os.Environment;
import android.util.Log;
import d.a.l0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46224c = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public File f46225b = o();

    @Override // d.a.l0.a.h0.r.b
    public boolean e(c cVar) {
        if (cVar != null && this.f46225b.exists()) {
            File file = this.f46225b;
            File file2 = new File(file, cVar.f51686g + File.separator + cVar.q);
            if (file2.exists()) {
                try {
                    if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                        if (f46224c) {
                            Log.e("SdCardPresetController", "校验签名失败");
                        }
                        return false;
                    }
                    File j = j(cVar.f51687h, cVar.f51686g, cVar.f51688i);
                    if (j == null) {
                        if (f46224c) {
                            Log.e("SdCardPresetController", "获取解压路径失败");
                        }
                        return false;
                    }
                    return n(new BufferedInputStream(new FileInputStream(file2)), j);
                } catch (IOException e2) {
                    if (f46224c) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.l0.a.h0.r.b
    public String f(String str) {
        if (this.f46225b.exists()) {
            File file = this.f46225b;
            File file2 = new File(file, str + File.separator + "app_info.json");
            if (file2.exists()) {
                return d.a.l0.t.d.D(file2);
            }
            return null;
        }
        return null;
    }

    @Override // d.a.l0.a.h0.r.b
    public String i() {
        if (this.f46225b.exists()) {
            File file = new File(this.f46225b, "preset_list.json");
            if (file.exists()) {
                return d.a.l0.t.d.D(file);
            }
            return null;
        }
        return null;
    }

    public final File o() {
        return new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/");
    }
}
