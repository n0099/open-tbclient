package d.b.g0.a.e0.t;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.i2.g;
import d.b.g0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44273b = k.f45051a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f44274c = "swan_preset" + File.separator + "preset_list.json";

    @Override // d.b.g0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar == null) {
            return false;
        }
        Context appContext = AppRuntime.getAppContext();
        String str = "swan_preset" + File.separator + cVar.f48923g + File.separator + cVar.p;
        try {
            File j = j(cVar.f48924h, cVar.f48923g, cVar.i);
            if (j == null) {
                if (f44273b) {
                    Log.e("AssetPresetController", "获取解压路径失败");
                }
                return false;
            }
            return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
        } catch (IOException e2) {
            if (f44273b) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.b.g0.a.e0.t.b
    public String f(String str) {
        Application c2 = d.b.g0.a.w0.a.c();
        return g.b(c2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // d.b.g0.a.e0.t.b
    public String i() {
        return g.b(d.b.g0.a.w0.a.c(), f44274c);
    }
}
