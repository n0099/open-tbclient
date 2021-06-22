package d.a.m0.a.k2.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.v1.a.a.a {
    public static void e(@NonNull AshmemFileDescriptor ashmemFileDescriptor) {
        if (ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
            bundle.putParcelable("result", ashmemFileDescriptor);
            d.a.m0.a.v1.c.d.b.a(bundle, b.class);
        }
    }

    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        bundle.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
        AshmemFileDescriptor ashmemFileDescriptor = (AshmemFileDescriptor) bundle.getParcelable("result");
        if (ashmemFileDescriptor != null) {
            f.b(ashmemFileDescriptor);
        }
    }
}
