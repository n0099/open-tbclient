package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TrendInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static Comparator<TrendInfo> mTrendsComparator = new Comparator<TrendInfo>() { // from class: com.kwad.sdk.core.response.model.TrendInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrendInfo trendInfo, TrendInfo trendInfo2) {
            int i2 = trendInfo.rank;
            int i3 = trendInfo2.rank;
            if (i2 == i3) {
                return 0;
            }
            return i2 > i3 ? 1 : -1;
        }
    };
    public static final long serialVersionUID = 8690126962689904212L;
    public String coverUrl;
    public String iconUrl;
    public String name;
    public long offlineTime;
    public int photoCount;
    public int rank;
    public long trendId;
    public long viewCount;

    public static List<TrendInfo> asList(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                TrendInfo trendInfo = new TrendInfo();
                trendInfo.parseJson(new JSONObject(jSONArray.optString(i2)));
                arrayList.add(trendInfo);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return arrayList;
    }

    public static String toString(@NonNull List<TrendInfo> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            jSONArray.put(list.get(i2).toJson().toString());
        }
        return jSONArray.toString();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof TrendInfo) && ((TrendInfo) obj).trendId == this.trendId;
    }
}
