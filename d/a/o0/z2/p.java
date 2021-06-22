package d.a.o0.z2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes5.dex */
public class p implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static String f67647a = "2301";

    /* renamed from: b  reason: collision with root package name */
    public static String f67648b = "1";

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            return f67648b.equals(uBCManager.getUploadType(f67647a)) ? f67647a : "";
        }
        return "";
    }
}
