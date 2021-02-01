package com.qq.e.comm.plugin.ab;

import android.net.Uri;
import com.qq.e.comm.util.GDTLogger;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f11699a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f11700b;

    public JSONObject a() {
        return this.f11700b;
    }

    public void a(Set<String> set) {
        this.f11699a = set;
    }

    public void a(JSONObject jSONObject) {
        this.f11700b = jSONObject;
    }

    public boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (this.f11699a == null || parse == null || !parse.isHierarchical()) {
            return false;
        }
        String authority = parse.getAuthority();
        GDTLogger.d("click url host is:" + authority);
        return this.f11699a.contains(authority);
    }
}
