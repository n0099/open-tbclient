package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TrendInfo implements com.kwad.sdk.core.b, Serializable {
    public static Comparator<TrendInfo> mTrendsComparator = new Comparator<TrendInfo>() { // from class: com.kwad.sdk.core.response.model.TrendInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrendInfo trendInfo, TrendInfo trendInfo2) {
            if (trendInfo.rank == trendInfo2.rank) {
                return 0;
            }
            return trendInfo.rank > trendInfo2.rank ? 1 : -1;
        }
    };
    private static final long serialVersionUID = 8690126962689904212L;
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
            for (int i = 0; i < jSONArray.length(); i++) {
                TrendInfo trendInfo = new TrendInfo();
                trendInfo.parseJson(new JSONObject(jSONArray.optString(i)));
                arrayList.add(trendInfo);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return arrayList;
    }

    public static String toString(@NonNull List<TrendInfo> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return jSONArray.toString();
            }
            jSONArray.put(list.get(i2).toJson().toString());
            i = i2 + 1;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof TrendInfo) && ((TrendInfo) obj).trendId == this.trendId;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.trendId = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        this.name = jSONObject.optString("name");
        this.viewCount = jSONObject.optLong("viewCount");
        this.offlineTime = jSONObject.optLong("offlineTime");
        this.photoCount = jSONObject.optInt("photoCount");
        this.coverUrl = jSONObject.optString("coverUrl");
        this.iconUrl = jSONObject.optString("iconUrl");
        this.rank = jSONObject.optInt("rank");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, URLPackage.KEY_TREND_ID, this.trendId);
        o.a(jSONObject, "name", this.name);
        o.a(jSONObject, "viewCount", this.viewCount);
        o.a(jSONObject, "offlineTime", this.offlineTime);
        o.a(jSONObject, "photoCount", this.photoCount);
        o.a(jSONObject, "coverUrl", this.coverUrl);
        o.a(jSONObject, "iconUrl", this.iconUrl);
        o.a(jSONObject, "rank", this.rank);
        return jSONObject;
    }
}
