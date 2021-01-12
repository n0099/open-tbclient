package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.util.GDTLogger;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements e {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final b f11727a = new b();
    }

    private b() {
    }

    public static b a() {
        return a.f11727a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject optJSONObject = dVar.d().optJSONObject("adInfo");
        hVar.a(optJSONObject);
        JSONArray optJSONArray = optJSONObject.optJSONArray("click_domain_whitelist");
        if (optJSONArray == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < optJSONArray.length(); i++) {
            hashSet.add(optJSONArray.optString(i));
        }
        hVar.a((Set<String>) hashSet);
        GDTLogger.d("CurrentWhiteList: " + hashSet.toString());
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "addClickDomainWhiteList";
    }
}
