package d.a.l0.a.h0.r;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import d.a.l0.a.v2.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46217b = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f46218c = "swan_preset" + File.separator + "preset_list.json";

    @Override // d.a.l0.a.h0.r.b
    public boolean e(c cVar) {
        if (cVar == null) {
            return false;
        }
        Context appContext = AppRuntime.getAppContext();
        String str = "swan_preset" + File.separator + cVar.f51686g + File.separator + cVar.q;
        try {
            File j = j(cVar.f51687h, cVar.f51686g, cVar.f51688i);
            if (j == null) {
                if (f46217b) {
                    Log.e("AssetPresetController", "获取解压路径失败");
                }
                return false;
            }
            return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
        } catch (IOException e2) {
            if (f46217b) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.a.l0.a.h0.r.b
    public String f(String str) {
        Application b2 = d.a.l0.a.c1.a.b();
        return h.b(b2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
    }

    @Override // d.a.l0.a.h0.r.b
    public String i() {
        return h.b(d.a.l0.a.c1.a.b(), f46218c);
    }
}
