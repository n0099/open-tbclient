package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.List;
/* loaded from: classes6.dex */
public interface lf {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IHttpsExperiment");

    List<uf> getHttpsWhileList();

    boolean isFullHttps();

    boolean isIpv6();

    boolean isSwitchOn();
}
