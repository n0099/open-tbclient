package com.kwad.components.ad.adbit;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
@KsJson
/* loaded from: classes8.dex */
public class AdBid extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -3937320872050889919L;
    public int bidEcpm;
    public long creativeId;
    public long ecpm;
    public String materialId;
    public String winNoticeUrl;
}
