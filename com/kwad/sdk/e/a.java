package com.kwad.sdk.e;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a implements c {
    public List<e<a>> mHolders;

    private List<e<a>> getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                e<a> holder = getHolderMananger().getHolder(cls);
                if (holder != null) {
                    this.mHolders.add(0, holder);
                }
            }
        }
        return this.mHolders;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public abstract b getHolderMananger();

    @Override // com.kwad.sdk.e.c
    public void parseJson(@Nullable JSONObject jSONObject) {
        List<e<a>> holders = getHolders();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.e.c
    public JSONObject toJson() {
        List<e<a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).b(this, jSONObject);
        }
        afterToJson(jSONObject);
        return jSONObject;
    }
}
