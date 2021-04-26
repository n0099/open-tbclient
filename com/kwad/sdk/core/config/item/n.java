package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.ReportInfo;
import com.kwad.sdk.utils.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n extends a<List<ReportInfo>> {
    public n() {
        super("reportItems", d());
    }

    public static ArrayList<ReportInfo> d() {
        ArrayList<ReportInfo> arrayList = new ArrayList<>();
        arrayList.add(new ReportInfo(1, "违法违规"));
        arrayList.add(new ReportInfo(2, "色情低俗"));
        arrayList.add(new ReportInfo(3, "作者举报"));
        arrayList.add(new ReportInfo(4, "封面党"));
        arrayList.add(new ReportInfo(5, "不适合未成年"));
        return arrayList;
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences.Editor editor) {
        List<ReportInfo> b2 = b();
        if (u.a(b2)) {
            JSONArray jSONArray = new JSONArray();
            for (ReportInfo reportInfo : b2) {
                jSONArray.put(reportInfo.toJson());
            }
            editor.putString("reportItems", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("reportItems", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        ReportInfo reportInfo = new ReportInfo();
                        reportInfo.parseJson(optJSONObject);
                        arrayList.add(reportInfo);
                    }
                    if (arrayList.size() > 0) {
                        a((n) arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        a((n) c());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("reportItems")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    ReportInfo reportInfo = new ReportInfo();
                    reportInfo.parseJson(optJSONObject);
                    arrayList.add(reportInfo);
                }
            }
            if (arrayList.size() > 0) {
                a((n) arrayList);
                return;
            }
        }
        a((n) c());
    }
}
