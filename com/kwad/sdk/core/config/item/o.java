package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.ReportInfo;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o extends b<List<ReportInfo>> {
    public o() {
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

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        List<ReportInfo> a = a();
        if (ae.a(a)) {
            JSONArray jSONArray = new JSONArray();
            for (ReportInfo reportInfo : a) {
                jSONArray.put(reportInfo.toJson());
            }
            editor.putString("reportItems", jSONArray.toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        try {
            String string = sharedPreferences.getString("reportItems", "");
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        ReportInfo reportInfo = new ReportInfo();
                        reportInfo.parseJson(optJSONObject);
                        arrayList.add(reportInfo);
                    }
                    if (arrayList.size() > 0) {
                        a((o) arrayList);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        a((o) c());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("reportItems")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ReportInfo reportInfo = new ReportInfo();
                    reportInfo.parseJson(optJSONObject);
                    arrayList.add(reportInfo);
                }
            }
            if (arrayList.size() > 0) {
                a((o) arrayList);
                return;
            }
        }
        a((o) c());
    }
}
