package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33668a;

    /* renamed from: b  reason: collision with root package name */
    public int f33669b;

    /* renamed from: c  reason: collision with root package name */
    public int f33670c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f33671d;

    public j() {
        this.f33671d = new ArrayList();
    }

    public j(int i) {
        this.f33671d = new ArrayList();
        this.f33668a = true;
        this.f33669b = i;
    }

    public j(List<AdTemplate> list) {
        this.f33671d = new ArrayList();
        this.f33668a = false;
        if (list != null) {
            this.f33670c = list.size();
            for (AdTemplate adTemplate : list) {
                this.f33671d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "preload", this.f33668a);
        if (this.f33668a) {
            o.a(jSONObject, "requestVideoCount", this.f33669b);
        } else {
            o.a(jSONObject, "preloadedVideoCount", this.f33670c);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f33671d) {
                jSONArray.put(l);
            }
            o.a(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
