package com.qq.e.comm.plugin.ab;

import android.net.Uri;
import com.qq.e.comm.util.GDTLogger;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f11996a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f11997b;

    public JSONObject a() {
        return this.f11997b;
    }

    public void a(Set<String> set) {
        this.f11996a = set;
    }

    public void a(JSONObject jSONObject) {
        this.f11997b = jSONObject;
    }

    public boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (this.f11996a == null || parse == null || !parse.isHierarchical()) {
            return false;
        }
        String authority = parse.getAuthority();
        GDTLogger.d("click url host is:" + authority);
        return this.f11996a.contains(authority);
    }
}
