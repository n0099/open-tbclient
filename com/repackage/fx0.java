package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface fx0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "adRequester");

    void a(@NonNull RequestParameters requestParameters, @NonNull NadRequester.b bVar);
}
