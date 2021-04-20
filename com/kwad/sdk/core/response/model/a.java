package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f34354a;

    /* renamed from: b  reason: collision with root package name */
    public String f34355b;

    /* renamed from: d  reason: collision with root package name */
    public int f34357d;

    /* renamed from: e  reason: collision with root package name */
    public String f34358e;

    /* renamed from: f  reason: collision with root package name */
    public String f34359f;
    public transient List<AdTemplate> k;

    /* renamed from: c  reason: collision with root package name */
    public int f34356c = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f34360g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f34361h = 1;
    public int i = 1;
    public int j = 1;

    public void a(@Nullable JSONObject jSONObject) {
        this.f34354a = jSONObject.optInt("entryType");
        this.f34355b = jSONObject.optString("sourceDesc");
        this.f34356c = jSONObject.optInt("sourceDescPos", this.f34356c);
        this.f34358e = jSONObject.optString("entryId");
        this.f34357d = jSONObject.optInt("likePos", this.f34357d);
        String optString = jSONObject.optString("entryTitle");
        this.f34359f = optString;
        if (TextUtils.isEmpty(optString)) {
            this.f34359f = "精彩短视频";
        }
        this.f34360g = jSONObject.optInt("entryTitlePos", this.f34360g);
        this.f34361h = jSONObject.optInt("videoDurationPos", this.f34361h);
        this.i = jSONObject.optInt("videoDescPos", this.i);
        this.j = jSONObject.optInt("commentsPos", this.j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "entryType", this.f34354a);
        o.a(jSONObject, "sourceDesc", this.f34355b);
        o.a(jSONObject, "sourceDescPos", this.f34356c);
        o.a(jSONObject, "entryId", this.f34358e);
        o.a(jSONObject, "likePos", this.f34357d);
        o.a(jSONObject, "entryTitle", this.f34359f);
        o.a(jSONObject, "entryTitlePos", this.f34360g);
        o.a(jSONObject, "videoDurationPos", this.f34361h);
        o.a(jSONObject, "videoDescPos", this.i);
        o.a(jSONObject, "commentsPos", this.j);
        return jSONObject;
    }
}
