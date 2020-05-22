package com.kascend.cstvsdk.bean;

import android.support.annotation.Keep;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@Keep
@h
/* loaded from: classes5.dex */
public final class ShareParam {
    public static final Companion Companion = new Companion(null);
    public static final int PLATFORM_OTHER = 100;
    public static final int PLATFORM_QQ = 2;
    public static final int PLATFORM_QZone = 3;
    public static final int PLATFORM_WECHAT = 4;
    public static final int PLATFORM_WECHATMOMENTS = 5;
    public static final int PLATFORM_WEIBO = 1;
    private String content;
    private String pic;
    private String thumbnail;
    private String title;
    private String url;

    public ShareParam() {
        this(null, null, null, null, null, 31, null);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.thumbnail;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.pic;
    }

    public final ShareParam copy(String str, String str2, String str3, String str4, String str5) {
        return new ShareParam(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ShareParam) {
                ShareParam shareParam = (ShareParam) obj;
                if (!q.l((Object) this.title, (Object) shareParam.title) || !q.l((Object) this.thumbnail, (Object) shareParam.thumbnail) || !q.l((Object) this.content, (Object) shareParam.content) || !q.l((Object) this.url, (Object) shareParam.url) || !q.l((Object) this.pic, (Object) shareParam.pic)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.thumbnail;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.content;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.url;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.pic;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ShareParam(title=" + this.title + ", thumbnail=" + this.thumbnail + ", content=" + this.content + ", url=" + this.url + ", pic=" + this.pic + ")";
    }

    public ShareParam(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.thumbnail = str2;
        this.content = str3;
        this.url = str4;
        this.pic = str5;
    }

    public /* synthetic */ ShareParam(String str, String str2, String str3, String str4, String str5, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getPic() {
        return this.pic;
    }

    public final void setPic(String str) {
        this.pic = str;
    }

    @Keep
    @h
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }
}
