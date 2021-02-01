package com.yy.mediaframework;

import com.yy.mediaframework.model.ExternalYYMediaSample;
/* loaded from: classes4.dex */
public class ExternalInterface {

    /* loaded from: classes4.dex */
    public interface IExternalCameraData {
        void onCameraDataProcessCallback(ExternalYYMediaSample externalYYMediaSample);
    }

    /* loaded from: classes4.dex */
    public interface IExternalDecode {
        void onExternalDecodeCallback(ExternalYYMediaSample externalYYMediaSample);
    }
}
