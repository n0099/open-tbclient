package com.qq.e.comm.pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public interface NSPVI extends LADI {
    public static final Map<String, String> ext = new HashMap();

    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    @Deprecated
    void setAdLogoMargin(int i2, int i3);

    void setDeveloperLogo(int i2);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i2);

    void setFloatView(View view);

    void setLoadAdParams(LoadAdParams loadAdParams);

    @Deprecated
    void setPreloadView(View view);

    @Deprecated
    void setSkipView(View view);

    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void showFullScreenAd(ViewGroup viewGroup);

    void zoomOutAnimationFinish();
}
