package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f6255a;
    public String b;
    public int d;
    public String e;
    public String f;
    public transient List<AdTemplate> k;
    public int c = 1;
    public int g = 1;
    public int h = 1;
    public int i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f6255a = jSONObject.optInt("entryType");
        this.b = jSONObject.optString("sourceDesc");
        this.c = jSONObject.optInt("sourceDescPos", this.c);
        this.e = jSONObject.optString("entryId");
        this.d = jSONObject.optInt("likePos", this.d);
        this.f = jSONObject.optString("entryTitle");
        if (TextUtils.isEmpty(this.f)) {
            this.f = "精彩短视频";
        }
        this.g = jSONObject.optInt("entryTitlePos", this.g);
        this.h = jSONObject.optInt("videoDurationPos", this.h);
        this.i = jSONObject.optInt("videoDescPos", this.i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f6255a);
        o.a(jSONObject, "sourceDesc", this.b);
        o.a(jSONObject, "sourceDescPos", this.c);
        o.a(jSONObject, "entryId", this.e);
        o.a(jSONObject, "likePos", this.d);
        o.a(jSONObject, "entryTitle", this.f);
        o.a(jSONObject, "entryTitlePos", this.g);
        o.a(jSONObject, "videoDurationPos", this.h);
        o.a(jSONObject, "videoDescPos", this.i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
