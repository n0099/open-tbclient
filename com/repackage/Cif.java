package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.List;
/* renamed from: com.repackage.if  reason: invalid class name */
/* loaded from: classes6.dex */
public interface Cif {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "IHttpsExperiment");

    List<rf> getHttpsWhileList();

    boolean isFullHttps();

    boolean isIpv6();

    boolean isSwitchOn();
}
