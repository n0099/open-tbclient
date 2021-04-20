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
    public boolean f33957a;

    /* renamed from: b  reason: collision with root package name */
    public int f33958b;

    /* renamed from: c  reason: collision with root package name */
    public int f33959c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f33960d;

    public j() {
        this.f33960d = new ArrayList();
    }

    public j(int i) {
        this.f33960d = new ArrayList();
        this.f33957a = true;
        this.f33958b = i;
    }

    public j(List<AdTemplate> list) {
        this.f33960d = new ArrayList();
        this.f33957a = false;
        if (list != null) {
            this.f33959c = list.size();
            for (AdTemplate adTemplate : list) {
                this.f33960d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "preload", this.f33957a);
        if (this.f33957a) {
            o.a(jSONObject, "requestVideoCount", this.f33958b);
        } else {
            o.a(jSONObject, "preloadedVideoCount", this.f33959c);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f33960d) {
                jSONArray.put(l);
            }
            o.a(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
