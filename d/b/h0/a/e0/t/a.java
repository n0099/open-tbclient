package d.b.h0.a.e0.t;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.i2.g;
import d.b.h0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44994b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f44995c = "swan_preset" + File.separator + "preset_list.json";

    @Override // d.b.h0.a.e0.t.b
    public boolean e(c cVar) {
        if (cVar == null) {
            return false;
        }
        Context appContext = AppRuntime.getAppContext();
        String str = "swan_preset" + File.separator + cVar.f49644g + File.separator + cVar.p;
        try {
            File j = j(cVar.f49645h, cVar.f49644g, cVar.i);
            if (j == null) {
                if (f44994b) {
                    Log.e("AssetPresetController", "获取解压路径失败");
                }
                return false;
            }
            return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
        } catch (IOException e2) {
            if (f44994b) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.b.h0.a.e0.t.b
    public String f(String str) {
        Application c2 = d.b.h0.a.w0.a.c();
        return g.b(c2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // d.b.h0.a.e0.t.b
    public String i() {
        return g.b(d.b.h0.a.w0.a.c(), f44995c);
    }
}
