package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34065a;

    /* renamed from: b  reason: collision with root package name */
    public String f34066b;

    /* renamed from: d  reason: collision with root package name */
    public int f34068d;

    /* renamed from: e  reason: collision with root package name */
    public String f34069e;

    /* renamed from: f  reason: collision with root package name */
    public String f34070f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34067c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34071g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34072h = 1;
    public int i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34065a = jSONObject.optInt("entryType");
        this.f34066b = jSONObject.optString("sourceDesc");
        this.f34067c = jSONObject.optInt("sourceDescPos", this.f34067c);
        this.f34069e = jSONObject.optString("entryId");
        this.f34068d = jSONObject.optInt("likePos", this.f34068d);
        String optString = jSONObject.optString("entryTitle");
        this.f34070f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34070f = "精彩短视频";
        }
        this.f34071g = jSONObject.optInt("entryTitlePos", this.f34071g);
        this.f34072h = jSONObject.optInt("videoDurationPos", this.f34072h);
        this.i = jSONObject.optInt("videoDescPos", this.i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34065a);
        o.a(jSONObject, "sourceDesc", this.f34066b);
        o.a(jSONObject, "sourceDescPos", this.f34067c);
        o.a(jSONObject, "entryId", this.f34069e);
        o.a(jSONObject, "likePos", this.f34068d);
        o.a(jSONObject, "entryTitle", this.f34070f);
        o.a(jSONObject, "entryTitlePos", this.f34071g);
        o.a(jSONObject, "videoDurationPos", this.f34072h);
        o.a(jSONObject, "videoDescPos", this.i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
