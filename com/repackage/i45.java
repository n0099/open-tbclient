package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface i45 {
    @NonNull
    public static final ServiceReference a;
    @NonNull
    public static final i45 b;

    static {
        ServiceReference serviceReference = new ServiceReference("tbBaseEmotion", "EmotionService");
        a = serviceReference;
        b = (i45) ServiceManager.getService(serviceReference);
    }

    boolean a(@NonNull String str);

    @NonNull
    String b(@NonNull String str);

    @NonNull
    String c();

    @NonNull
    String d(@NonNull String str, boolean z);

    @NonNull
    String e(@NonNull String str, @NonNull String str2);
}
