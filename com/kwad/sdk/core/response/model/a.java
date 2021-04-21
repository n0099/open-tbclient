package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34449a;

    /* renamed from: b  reason: collision with root package name */
    public String f34450b;

    /* renamed from: d  reason: collision with root package name */
    public int f34452d;

    /* renamed from: e  reason: collision with root package name */
    public String f34453e;

    /* renamed from: f  reason: collision with root package name */
    public String f34454f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34451c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34455g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34456h = 1;
    public int i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34449a = jSONObject.optInt("entryType");
        this.f34450b = jSONObject.optString("sourceDesc");
        this.f34451c = jSONObject.optInt("sourceDescPos", this.f34451c);
        this.f34453e = jSONObject.optString("entryId");
        this.f34452d = jSONObject.optInt("likePos", this.f34452d);
        String optString = jSONObject.optString("entryTitle");
        this.f34454f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34454f = "精彩短视频";
        }
        this.f34455g = jSONObject.optInt("entryTitlePos", this.f34455g);
        this.f34456h = jSONObject.optInt("videoDurationPos", this.f34456h);
        this.i = jSONObject.optInt("videoDescPos", this.i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34449a);
        o.a(jSONObject, "sourceDesc", this.f34450b);
        o.a(jSONObject, "sourceDescPos", this.f34451c);
        o.a(jSONObject, "entryId", this.f34453e);
        o.a(jSONObject, "likePos", this.f34452d);
        o.a(jSONObject, "entryTitle", this.f34454f);
        o.a(jSONObject, "entryTitlePos", this.f34455g);
        o.a(jSONObject, "videoDurationPos", this.f34456h);
        o.a(jSONObject, "videoDescPos", this.i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
