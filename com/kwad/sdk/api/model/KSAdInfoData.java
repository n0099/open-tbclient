package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;
import java.util.List;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public class KSAdInfoData implements Serializable {
    public static final long serialVersionUID = 689744866207726843L;
    public String adDescription;
    public String adSource;
    public String appIconUrl;
    public String appName;
    public List<String> imageUrlArray;
    public int interactionType;
    public int materialType;
    public String productName;
    public String videoCoverImageUrl;
    public String videoUrl;

    public static KSAdInfoData obtain() {
        return new KSAdInfoData();
    }

    public KSAdInfoData setAdDescription(String str) {
        this.adDescription = str;
        return this;
    }

    public KSAdInfoData setAdSource(String str) {
        this.adSource = str;
        return this;
    }

    public KSAdInfoData setAppIconUrl(String str) {
        this.appIconUrl = str;
        return this;
    }

    public KSAdInfoData setAppName(String str) {
        this.appName = str;
        return this;
    }

    public KSAdInfoData setImageList(List<String> list) {
        this.imageUrlArray = list;
        return this;
    }

    public KSAdInfoData setInteractionType(int i) {
        this.interactionType = i;
        return this;
    }

    public KSAdInfoData setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public KSAdInfoData setProductName(String str) {
        this.productName = str;
        return this;
    }

    public KSAdInfoData setVideoCoverImageUrl(String str) {
        this.videoCoverImageUrl = str;
        return this;
    }

    public KSAdInfoData setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public String toString() {
        return "KSAdInfoData{adDescription='" + this.adDescription + "', productName='" + this.productName + "', adSource='" + this.adSource + "', imageUrlArray=" + this.imageUrlArray + ", videoUrl='" + this.videoUrl + "', videoCoverImageUrl='" + this.videoCoverImageUrl + "', materialType=" + this.materialType + ", appIconUrl='" + this.appIconUrl + "', appName='" + this.appName + "', interactionType=" + this.interactionType + '}';
    }
}
