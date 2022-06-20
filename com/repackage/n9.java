package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface n9 {
    @NonNull
    public static final ServiceReference a;
    @Nullable
    public static final n9 b;

    static {
        ServiceReference serviceReference = new ServiceReference("DebugProcessor", "DebugService4Adp");
        a = serviceReference;
        b = (n9) ServiceManager.getService(serviceReference);
    }

    void a(int i, @NonNull String str, @Nullable Object obj);
}
