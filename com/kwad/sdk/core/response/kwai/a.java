package com.kwad.sdk.core.response.kwai;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.kwai.dd;
import com.kwad.sdk.core.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements b {
    public static final List WHITE_LIST;
    public List mHolders;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("com.kwad.sdk.core.report.BaseReportAction");
    }

    private d getHolder(Class cls) {
        if (a.class.equals(cls) || WHITE_LIST.contains(cls.getName())) {
            return null;
        }
        return dd.getHolder(cls);
    }

    private List getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                d holder = getHolder(cls);
                if (holder != null) {
                    this.mHolders.add(0, holder);
                }
            }
        }
        List list = this.mHolders;
        if (list == null || list.isEmpty()) {
            com.kwad.sdk.core.e.b.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
        }
        return this.mHolders;
    }

    public void afterParseJson(JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void beforeToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        List holders = getHolders();
        for (int size = holders.size() - 1; size >= 0; size--) {
            ((d) holders.get(size)).a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        beforeToJson(jSONObject);
        if (holders == null) {
            return jSONObject;
        }
        for (int size = holders.size() - 1; size >= 0; size--) {
            d dVar = (d) holders.get(size);
            if (dVar != null) {
                dVar.b(this, jSONObject);
            }
        }
        afterToJson(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
