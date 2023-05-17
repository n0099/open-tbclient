package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.kwai.a;
import java.io.Serializable;
@KsJson
/* loaded from: classes9.dex */
public class HybridLoadMsg extends a implements Serializable {
    public static final int FAIL = 2;
    public static final int SUCCESS = 1;
    public static final long serialVersionUID = -8132509704708242619L;
    public String failReason;
    public int failState;
    public String h5Version;
    public String interval;
    public int loadType;
    public String packageUrl;
    public double ratioCount;
    public String sceneId;
    public int state;
    public String url;

    public HybridLoadMsg setFailReason(String str) {
        this.failReason = str;
        return this;
    }

    public HybridLoadMsg setFailState(int i) {
        this.failState = i;
        return this;
    }

    public HybridLoadMsg setH5Version(String str) {
        this.h5Version = str;
        return this;
    }

    public HybridLoadMsg setInterval(String str) {
        this.interval = str;
        return this;
    }

    public HybridLoadMsg setLoadType(int i) {
        this.loadType = i;
        return this;
    }

    public HybridLoadMsg setPackageUrl(String str) {
        this.packageUrl = str;
        return this;
    }

    public HybridLoadMsg setRatioCount(double d) {
        this.ratioCount = d;
        return this;
    }

    public HybridLoadMsg setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public HybridLoadMsg setState(int i) {
        this.state = i;
        return this;
    }

    public HybridLoadMsg setUrl(String str) {
        this.url = str;
        return this;
    }
}
