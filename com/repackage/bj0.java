package com.repackage;

import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface bj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "downloadCreator");

    IAdDownloader a();
}
