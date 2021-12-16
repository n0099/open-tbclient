package com.kuaishou.tachikoma.api.trace;
/* loaded from: classes3.dex */
public interface IGetBundleTraceCallback {
    void onBundleInfoLoadOver();

    void onLoadBundleError(String str, String str2);

    void onReadJsStringOver();
}
