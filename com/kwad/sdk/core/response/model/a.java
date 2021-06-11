package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34701a;

    /* renamed from: b  reason: collision with root package name */
    public String f34702b;

    /* renamed from: d  reason: collision with root package name */
    public int f34704d;

    /* renamed from: e  reason: collision with root package name */
    public String f34705e;

    /* renamed from: f  reason: collision with root package name */
    public String f34706f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34703c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34707g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34708h = 1;

    /* renamed from: i  reason: collision with root package name */
    public int f34709i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34701a = jSONObject.optInt("entryType");
        this.f34702b = jSONObject.optString("sourceDesc");
        this.f34703c = jSONObject.optInt("sourceDescPos", this.f34703c);
        this.f34705e = jSONObject.optString("entryId");
        this.f34704d = jSONObject.optInt("likePos", this.f34704d);
        String optString = jSONObject.optString("entryTitle");
        this.f34706f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34706f = "精彩短视频";
        }
        this.f34707g = jSONObject.optInt("entryTitlePos", this.f34707g);
        this.f34708h = jSONObject.optInt("videoDurationPos", this.f34708h);
        this.f34709i = jSONObject.optInt("videoDescPos", this.f34709i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34701a);
        o.a(jSONObject, "sourceDesc", this.f34702b);
        o.a(jSONObject, "sourceDescPos", this.f34703c);
        o.a(jSONObject, "entryId", this.f34705e);
        o.a(jSONObject, "likePos", this.f34704d);
        o.a(jSONObject, "entryTitle", this.f34706f);
        o.a(jSONObject, "entryTitlePos", this.f34707g);
        o.a(jSONObject, "videoDurationPos", this.f34708h);
        o.a(jSONObject, "videoDescPos", this.f34709i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
