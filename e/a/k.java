package e.a;

import android.util.Log;
import dxm.sasdk.DxmSdkSensorsDataAPI;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static DxmSdkSensorsDataAPI f68251a;

    public static void a(String str, String str2) {
        try {
            if (f68251a.y()) {
                Log.i(str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str, String str2) {
        try {
            if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                Log.i(str, str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, String str2, Throwable th) {
        try {
            if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                Log.i(str, str2, th);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
        f68251a = dxmSdkSensorsDataAPI;
    }
}
