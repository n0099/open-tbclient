package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
@KsJson
/* loaded from: classes10.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    public static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public AdVideoPreCacheConfig(int i, boolean z) {
        this.adVideoPreCacheSize = 800;
        this.adVideoPreCacheSize = i;
        this.continueLoadingAll = z;
    }

    public void setAdVideoPreCacheSize(int i) {
        this.adVideoPreCacheSize = i;
    }

    public void setContinueLoadingAll(boolean z) {
        this.continueLoadingAll = z;
    }
}
