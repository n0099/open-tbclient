package com.kwad.sdk.collector;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static final long serialVersionUID = 3026909056348431027L;
    public AppStatusInfo data = new AppStatusInfo();

    /* loaded from: classes6.dex */
    public static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -2403646317801179050L;
        public Strategy strategy = new Strategy();
        public ArrayList<Target> target = new ArrayList<>();

        public Strategy getStrategy() {
            return this.strategy;
        }

        public ArrayList<Target> getTarget() {
            return this.target;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Target target = new Target();
                    target.parseJson(jSONObject2);
                    this.target.add(target);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public void setTarget(ArrayList<Target> arrayList) {
            this.target = arrayList;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "strategy", this.strategy);
            o.a(jSONObject, "target", this.target);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -1387498537762043285L;
        public long historyGranularity = 60000;
        public long scanInterval;
        public long startTime;

        public long getHistoryGranularity() {
            return this.historyGranularity;
        }

        public long getScanInterval() {
            return this.scanInterval;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.startTime = jSONObject.optLong("startTime");
                this.scanInterval = jSONObject.optLong("scanInterval");
                int optInt = jSONObject.optInt("historyGranularity");
                if (optInt > 0) {
                    this.historyGranularity = optInt * 1000;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void setScanInterval(long j) {
            this.scanInterval = j;
        }

        public void setStartTime(long j) {
            this.startTime = j;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "startTime", this.startTime);
            o.a(jSONObject, "scanInterval", this.scanInterval);
            o.a(jSONObject, "historyGranularity", this.historyGranularity / 1000);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class Target implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -4726982809581153390L;
        public String packageName;
        public ArrayList<String> paths = new ArrayList<>();

        public String getPackageName() {
            return this.packageName;
        }

        public ArrayList<String> getPaths() {
            return this.paths;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.packageName = jSONObject.optString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
                JSONArray optJSONArray = jSONObject.optJSONArray("paths");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.paths.add(optJSONArray.getString(i));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPaths(ArrayList<String> arrayList) {
            this.paths = arrayList;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.packageName);
            o.a(jSONObject, "paths", this.paths);
            return jSONObject;
        }
    }

    @NonNull
    public static AppStatusRules createFromJson(String str) {
        AppStatusRules appStatusRules = new AppStatusRules();
        if (TextUtils.isEmpty(str)) {
            return appStatusRules;
        }
        try {
            appStatusRules.parseJson(new JSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return appStatusRules;
    }

    @Nullable
    public ArrayList<Target> getTargetList() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.getTarget();
    }

    public long obtainHistoryGranularity() {
        Strategy strategy;
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || (strategy = appStatusInfo.getStrategy()) == null) {
            return 60000L;
        }
        return strategy.getHistoryGranularity();
    }

    public long obtainScanInterval() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
            return 0L;
        }
        long scanInterval = this.data.getStrategy().getScanInterval();
        return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
    }

    public long obtainStartTime() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
            return 86400000L;
        }
        long startTime = this.data.getStrategy().getStartTime();
        if (startTime <= 0) {
            return 86400000L;
        }
        return startTime * 1000;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(d.b(jSONObject.optString("data"))));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean targetNotEmpty() {
        ArrayList<Target> targetList = getTargetList();
        return targetList != null && targetList.size() > 0;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "data", this.data);
        return json;
    }
}
