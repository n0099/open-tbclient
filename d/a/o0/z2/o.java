package d.a.o0.z2;

import android.os.Looper;
import android.util.Printer;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
@Singleton
@Service
/* loaded from: classes5.dex */
public class o implements ILooperNeedContext {
    @Override // com.baidu.searchbox.looper.ioc.ILooperNeedContext
    public void addLooperPrinter(Printer printer) {
        if (printer != null) {
            Looper.getMainLooper().setMessageLogging(printer);
        }
    }

    @Override // com.baidu.searchbox.looper.ioc.ILooperNeedContext
    public void removeLooperPrinter(Printer printer) {
        Looper.getMainLooper().setMessageLogging(null);
    }
}
