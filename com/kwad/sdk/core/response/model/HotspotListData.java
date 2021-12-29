package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotspotListData extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 5720793773714140339L;
    @NonNull
    public List<HotspotInfo> trends = new ArrayList();
    public List<TabInfo> tabList = new ArrayList();
}
