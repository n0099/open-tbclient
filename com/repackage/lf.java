package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface lf {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IHttpsExperiment");

    boolean isIpv6();

    boolean isSwitchOn();
}
