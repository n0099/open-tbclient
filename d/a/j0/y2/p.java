package d.a.j0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes5.dex */
public class p implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static String f62916a = "2301";

    /* renamed from: b  reason: collision with root package name */
    public static String f62917b = "1";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            return f62917b.equals(uBCManager.getUploadType(f62916a)) ? f62916a : "";
        }
        return "";
    }
}
