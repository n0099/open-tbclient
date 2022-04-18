package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
/* loaded from: classes7.dex */
public interface s49 {
    public static final ServiceReference a = new ServiceReference(UBCCloudControlProcessor.UBC_KEY, "yalog");

    void a(String str, String str2);

    void b(String str, String str2);
}
