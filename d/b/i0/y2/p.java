package d.b.i0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes4.dex */
public class p implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static String f64212a = "2301";

    /* renamed from: b  reason: collision with root package name */
    public static String f64213b = "1";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            return f64213b.equals(uBCManager.getUploadType(f64212a)) ? f64212a : "";
        }
        return "";
    }
}
