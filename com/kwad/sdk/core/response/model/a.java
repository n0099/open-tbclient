package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34064a;

    /* renamed from: b  reason: collision with root package name */
    public String f34065b;

    /* renamed from: d  reason: collision with root package name */
    public int f34067d;

    /* renamed from: e  reason: collision with root package name */
    public String f34068e;

    /* renamed from: f  reason: collision with root package name */
    public String f34069f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34066c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34070g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34071h = 1;
    public int i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34064a = jSONObject.optInt("entryType");
        this.f34065b = jSONObject.optString("sourceDesc");
        this.f34066c = jSONObject.optInt("sourceDescPos", this.f34066c);
        this.f34068e = jSONObject.optString("entryId");
        this.f34067d = jSONObject.optInt("likePos", this.f34067d);
        String optString = jSONObject.optString("entryTitle");
        this.f34069f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34069f = "精彩短视频";
        }
        this.f34070g = jSONObject.optInt("entryTitlePos", this.f34070g);
        this.f34071h = jSONObject.optInt("videoDurationPos", this.f34071h);
        this.i = jSONObject.optInt("videoDescPos", this.i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34064a);
        o.a(jSONObject, "sourceDesc", this.f34065b);
        o.a(jSONObject, "sourceDescPos", this.f34066c);
        o.a(jSONObject, "entryId", this.f34068e);
        o.a(jSONObject, "likePos", this.f34067d);
        o.a(jSONObject, "entryTitle", this.f34069f);
        o.a(jSONObject, "entryTitlePos", this.f34070g);
        o.a(jSONObject, "videoDurationPos", this.f34071h);
        o.a(jSONObject, "videoDescPos", this.i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
