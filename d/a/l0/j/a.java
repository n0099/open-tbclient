package d.a.l0.j;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class a {
    static {
        SDKInitializer.initialize(AppRuntime.getAppContext());
        SDKInitializer.setCoordType(CoordType.GCJ02);
        SDKInitializer.setHttpsEnable(true);
    }

    public static void a() {
    }
}
