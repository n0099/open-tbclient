package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static String SUFFIX_ALL_CHILDREN = "/*";
    public static String SUFFIX_ALL_FILE = "*";
    public static final long serialVersionUID = 3026909056348431027L;
    public AppStatusInfo data = new AppStatusInfo();

    /* loaded from: classes6.dex */
    public static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -2403646317801179050L;
        public Strategy strategy = new Strategy();
        public ArrayList<Target> target = new ArrayList<>();
        public ArrayList<Strategy> namedStrategy = new ArrayList<>();
        public ArrayList<Target> uploadTarget = new ArrayList<>();
        public UploadConfig uploadConfig = new UploadConfig();

        private void duplicateTarget() {
            Set<String> targetPackages = this.strategy.getTargetPackages();
            HashSet hashSet = new HashSet();
            Iterator<Strategy> it = this.namedStrategy.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().getTargetPackages());
            }
            targetPackages.retainAll(hashSet);
            this.strategy.removeTargetsByPackage(targetPackages);
        }

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
                if (jSONObject.has("namedStrategy")) {
                    this.namedStrategy = Strategy.createFromJSONArray(jSONObject.getJSONArray("namedStrategy"));
                }
                if (jSONObject.has("uploadTarget")) {
                    this.uploadTarget = Target.createFromJsonArray(jSONObject.optJSONArray("uploadTarget"));
                }
                if (jSONObject.has("uploadConfig")) {
                    this.uploadConfig.parseJson(jSONObject.optJSONObject("uploadConfig"));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                ArrayList<Target> createFromJsonArray = Target.createFromJsonArray(optJSONArray);
                this.target = createFromJsonArray;
                this.strategy.setTarget(createFromJsonArray);
                duplicateTarget();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
            o.a(jSONObject, "uploadTarget", this.uploadTarget);
            o.a(jSONObject, "uploadConfig", this.uploadConfig);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static Strategy LOCAL_DEFAULT = null;
        public static final long serialVersionUID = -1387498537762043285L;
        public long minLaunchInterval;
        public long scanInterval;
        public long startTime = 86400000;
        public long historyGranularity = 60000;
        public String name = null;
        public HashMap<String, Target> targetMap = new HashMap<>();
        public boolean needLaunch = true;
        public long needSaveLaunchTime = -1;

        static {
            Strategy strategy = new Strategy();
            LOCAL_DEFAULT = strategy;
            strategy.setStartTime(86400000L);
            LOCAL_DEFAULT.setHistoryGranularity(60000L);
        }

        public static ArrayList<Strategy> createFromJSONArray(JSONArray jSONArray) {
            ArrayList<Strategy> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONArray.getJSONObject(i2);
                    } catch (JSONException unused) {
                    }
                    if (jSONObject != null) {
                        Strategy strategy = new Strategy();
                        strategy.parseJson(jSONObject);
                        arrayList.add(strategy);
                    }
                }
            }
            return arrayList;
        }

        public long getHistoryGranularity() {
            return this.historyGranularity;
        }

        public long getMinLaunchIntervalWithMS() {
            return this.minLaunchInterval * 1000;
        }

        public String getName() {
            return this.name;
        }

        public long getNeedSaveLaunchTime() {
            return this.needSaveLaunchTime;
        }

        public long getScanInterval() {
            return this.scanInterval;
        }

        public long getStartTimeWithMS() {
            return this.startTime * 1000;
        }

        public ArrayList<Target> getTarget() {
            return new ArrayList<>(this.targetMap.values());
        }

        public Set<String> getTargetPackages() {
            Collection<Target> values = this.targetMap.values();
            HashSet hashSet = new HashSet();
            for (Target target : values) {
                hashSet.add(target.getPackageName());
            }
            return hashSet;
        }

        public boolean isNeedLaunch() {
            return this.needLaunch;
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
                this.name = jSONObject.optString("name");
                this.minLaunchInterval = jSONObject.optLong("minLaunchInterval");
                setTarget(Target.createFromJsonArray(jSONObject.optJSONArray("target")));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        public void removeTargetsByPackage(Collection<String> collection) {
            for (String str : collection) {
                this.targetMap.remove(str);
            }
        }

        public void setHistoryGranularity(long j) {
            this.historyGranularity = j;
        }

        public void setNeedLaunch(boolean z) {
            this.needLaunch = z;
        }

        public void setNeedSaveLaunchTime(long j) {
            this.needSaveLaunchTime = j;
        }

        public void setScanInterval(long j) {
            this.scanInterval = j;
        }

        public void setStartTime(long j) {
            this.startTime = j;
        }

        public void setTarget(ArrayList<Target> arrayList) {
            if (arrayList == null) {
                this.targetMap.clear();
                return;
            }
            Iterator<Target> it = arrayList.iterator();
            while (it.hasNext()) {
                Target next = it.next();
                this.targetMap.put(next.getPackageName(), next);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "startTime", this.startTime);
            o.a(jSONObject, "scanInterval", this.scanInterval);
            o.a(jSONObject, "historyGranularity", this.historyGranularity / 1000);
            o.a(jSONObject, "name", this.name);
            o.a(jSONObject, "target", getTarget());
            o.a(jSONObject, "minLaunchInterval", this.minLaunchInterval);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class Target implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -4726982809581153390L;
        public String packageName;
        public ArrayList<String> paths = new ArrayList<>();

        public static ArrayList<Target> createFromJsonArray(JSONArray jSONArray) {
            JSONObject jSONObject;
            if (jSONArray == null) {
                return null;
            }
            ArrayList<Target> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    jSONObject = jSONArray.getJSONObject(i2);
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    Target target = new Target();
                    target.parseJson(jSONObject);
                    arrayList.add(target);
                }
            }
            return arrayList;
        }

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
                this.packageName = jSONObject.optString("packageName");
                JSONArray optJSONArray = jSONObject.optJSONArray("paths");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.paths.add(optJSONArray.getString(i2));
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
            o.a(jSONObject, "packageName", this.packageName);
            o.a(jSONObject, "paths", this.paths);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class UploadConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final int DEFAULT_FILE_MAX_SIZE = 102400;
        public static final long serialVersionUID = 8541150615721258815L;
        public long fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (this.fileMaxSize < 0) {
                this.fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
            }
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
            com.kwad.sdk.core.d.a.a(e2);
        }
        return appStatusRules;
    }

    public ArrayList<Strategy> getAllStrategy() {
        ArrayList<Strategy> arrayList = new ArrayList<>();
        if (this.data.strategy != null) {
            arrayList.add(this.data.strategy);
        }
        if (this.data.namedStrategy != null) {
            arrayList.addAll(this.data.namedStrategy);
        }
        return arrayList;
    }

    @Nullable
    public ArrayList<Target> getDefaultTargetList() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.getTarget();
    }

    @Nullable
    public List<Target> getUploadTargets() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.uploadTarget;
    }

    public void initStatus(Context context) {
        Iterator<Strategy> it = getAllStrategy().iterator();
        while (it.hasNext()) {
            Strategy next = it.next();
            next.setNeedLaunch(g.a(context, next));
        }
    }

    public long obtainDefaultScanInterval() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
            return 0L;
        }
        long scanInterval = this.data.getStrategy().getScanInterval();
        return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
    }

    public Strategy obtainDefaultStrategy() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.strategy;
    }

    public List<Strategy> obtainNamedStrategyList() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.namedStrategy;
    }

    public long obtainUploadConfigFileMaxSize() {
        AppStatusInfo appStatusInfo = this.data;
        return (appStatusInfo == null || appStatusInfo.uploadConfig == null) ? ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT : this.data.uploadConfig.fileMaxSize;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(com.kwad.sdk.core.b.d.b(jSONObject.optString("data"))));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public boolean targetNotEmpty() {
        ArrayList<Target> defaultTargetList = getDefaultTargetList();
        return defaultTargetList != null && defaultTargetList.size() > 0;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "data", this.data);
        return json;
    }
}
