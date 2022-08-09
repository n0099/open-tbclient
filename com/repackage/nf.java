package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface nf {
    @NonNull
    public static final ServiceReference a = new ServiceReference("tbadkcore", "INetExperiment");

    boolean netABTest();

    boolean netBdABTest();

    boolean qaHttpsTest();
}
