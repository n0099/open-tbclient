package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34799a;

    /* renamed from: b  reason: collision with root package name */
    public String f34800b;

    /* renamed from: d  reason: collision with root package name */
    public int f34802d;

    /* renamed from: e  reason: collision with root package name */
    public String f34803e;

    /* renamed from: f  reason: collision with root package name */
    public String f34804f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34801c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34805g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34806h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f34807i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34799a = jSONObject.optInt("entryType");
        this.f34800b = jSONObject.optString("sourceDesc");
        this.f34801c = jSONObject.optInt("sourceDescPos", this.f34801c);
        this.f34803e = jSONObject.optString("entryId");
        this.f34802d = jSONObject.optInt("likePos", this.f34802d);
        String optString = jSONObject.optString("entryTitle");
        this.f34804f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34804f = "精彩短视频";
        }
        this.f34805g = jSONObject.optInt("entryTitlePos", this.f34805g);
        this.f34806h = jSONObject.optInt("videoDurationPos", this.f34806h);
        this.f34807i = jSONObject.optInt("videoDescPos", this.f34807i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34799a);
        o.a(jSONObject, "sourceDesc", this.f34800b);
        o.a(jSONObject, "sourceDescPos", this.f34801c);
        o.a(jSONObject, "entryId", this.f34803e);
        o.a(jSONObject, "likePos", this.f34802d);
        o.a(jSONObject, "entryTitle", this.f34804f);
        o.a(jSONObject, "entryTitlePos", this.f34805g);
        o.a(jSONObject, "videoDurationPos", this.f34806h);
        o.a(jSONObject, "videoDescPos", this.f34807i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
