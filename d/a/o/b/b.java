package d.a.o.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes2.dex */
public class b implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static String f54901a = "1";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            return f54901a.equals(uBCManager.getUploadType("2301")) ? "2301" : "";
        }
        return "";
    }
}
