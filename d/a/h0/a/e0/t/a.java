package d.a.h0.a.e0.t;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.i2.g;
import d.a.h0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42299b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f42300c = "swan_preset" + File.separator + "preset_list.json";

    @Override // d.a.h0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar == null) {
            return false;
        }
        Context appContext = AppRuntime.getAppContext();
        String str = "swan_preset" + File.separator + cVar.f47153g + File.separator + cVar.p;
        try {
            File j = j(cVar.f47154h, cVar.f47153g, cVar.f47155i);
            if (j == null) {
                if (f42299b) {
                    Log.e("AssetPresetController", "获取解压路径失败");
                }
                return false;
            }
            return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
        } catch (IOException e2) {
            if (f42299b) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.a.h0.a.e0.t.b
    public String f(String str) {
        Application c2 = d.a.h0.a.w0.a.c();
        return g.b(c2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // d.a.h0.a.e0.t.b
    public String i() {
        return g.b(d.a.h0.a.w0.a.c(), f42300c);
    }
}
