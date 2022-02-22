package com.kwad.sdk.core.response.model;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class PhotoAd extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 3907193550069150451L;
    public boolean requestAggregateAd;
    public boolean requestBannerAd;
    public boolean requestDynamicRewardAd = true;
    public boolean requestInsertScreenAd;
    public boolean requestPatchAd;
    public boolean requestPatchEc;
    public boolean requestWidgetAd;
    @Deprecated
    public int widgetAdPosition;
}
