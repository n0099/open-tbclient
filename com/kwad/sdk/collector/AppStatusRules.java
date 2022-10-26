package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.r;
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
/* loaded from: classes7.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b {
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static String SUFFIX_ALL_CHILDREN = "/*";
    public static String SUFFIX_ALL_FILE = "*";
    public static final long serialVersionUID = 3026909056348431027L;
    public AppStatusInfo data = new AppStatusInfo();

    /* loaded from: classes7.dex */
    public class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -2403646317801179050L;
        public ArrayList namedStrategy;
        public Strategy strategy;
        public ArrayList target;
        public UploadConfig uploadConfig;
        public ArrayList uploadTarget;

        public AppStatusInfo() {
            this.strategy = new Strategy();
            this.target = new ArrayList();
            this.namedStrategy = new ArrayList();
            this.uploadTarget = new ArrayList();
            this.uploadConfig = new UploadConfig();
        }

        private void duplicateTarget() {
            Set targetPackages = this.strategy.getTargetPackages();
            HashSet hashSet = new HashSet();
            Iterator it = this.namedStrategy.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((Strategy) it.next()).getTargetPackages());
            }
            targetPackages.retainAll(hashSet);
            this.strategy.removeTargetsByPackage(targetPackages);
        }

        public Strategy getStrategy() {
            return this.strategy;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("namedStrategy")) {
                    this.namedStrategy = Strategy.createFromJSONArray(jSONObject.getJSONArray("namedStrategy"));
                }
                if (jSONObject.has("uploadTarget")) {
                    this.uploadTarget = com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("uploadTarget"));
                }
                if (jSONObject.has("uploadConfig")) {
                    this.uploadConfig.parseJson(jSONObject.optJSONObject("uploadConfig"));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                ArrayList d = com.kwad.sdk.collector.model.c.d(optJSONArray);
                this.target = d;
                this.strategy.setTarget(d);
                duplicateTarget();
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "strategy", this.strategy);
            r.putValue(jSONObject, "target", this.target);
            r.putValue(jSONObject, "namedStrategy", this.namedStrategy);
            r.putValue(jSONObject, "uploadTarget", this.uploadTarget);
            r.a(jSONObject, "uploadConfig", this.uploadConfig);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static Strategy LOCAL_DEFAULT = null;
        public static final long serialVersionUID = -1387498537762043285L;
        public long minLaunchInterval;
        public long scanInterval;
        public long startTime = 86400000;
        public long historyGranularity = 60000;
        public String name = null;
        public HashMap targetMap = new HashMap();
        public boolean needLaunch = true;
        public long needSaveLaunchTime = -1;

        static {
            Strategy strategy = new Strategy();
            LOCAL_DEFAULT = strategy;
            strategy.setStartTime(86400000L);
            LOCAL_DEFAULT.setHistoryGranularity(60000L);
        }

        public static ArrayList createFromJSONArray(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = jSONArray.getJSONObject(i);
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

        public ArrayList getTarget() {
            return new ArrayList(this.targetMap.values());
        }

        public Set getTargetPackages() {
            Collection<com.kwad.sdk.collector.model.d> values = this.targetMap.values();
            HashSet hashSet = new HashSet();
            for (com.kwad.sdk.collector.model.d dVar : values) {
                hashSet.add(com.kwad.sdk.collector.model.c.a(dVar));
            }
            return hashSet;
        }

        public boolean isNeedLaunch() {
            return this.needLaunch;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.startTime = jSONObject.optLong(FetchLog.START_TIME);
                this.scanInterval = jSONObject.optLong("scanInterval");
                int optInt = jSONObject.optInt("historyGranularity");
                if (optInt > 0) {
                    this.historyGranularity = optInt * 1000;
                }
                this.name = jSONObject.optString("name");
                this.minLaunchInterval = jSONObject.optLong("minLaunchInterval");
                this.needSaveLaunchTime = jSONObject.optLong("needSaveLaunchTime");
                this.needLaunch = jSONObject.optBoolean("needLaunch");
                setTarget(com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("target")));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }

        public void removeTargetsByPackage(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.targetMap.remove((String) it.next());
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

        public void setTarget(ArrayList arrayList) {
            if (arrayList == null) {
                this.targetMap.clear();
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.collector.model.d dVar = (com.kwad.sdk.collector.model.d) it.next();
                this.targetMap.put(com.kwad.sdk.collector.model.c.a(dVar), dVar);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, FetchLog.START_TIME, this.startTime);
            r.putValue(jSONObject, "scanInterval", this.scanInterval);
            r.putValue(jSONObject, "historyGranularity", this.historyGranularity / 1000);
            r.putValue(jSONObject, "name", this.name);
            r.putValue(jSONObject, "target", getTarget());
            r.putValue(jSONObject, "minLaunchInterval", this.minLaunchInterval);
            r.putValue(jSONObject, "needSaveLaunchTime", this.needSaveLaunchTime);
            r.putValue(jSONObject, "needLaunch", this.needLaunch);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public class UploadConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final int DEFAULT_FILE_MAX_SIZE = 102400;
        public static final long serialVersionUID = 8541150615721258815L;
        public long fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (this.fileMaxSize < 0) {
                this.fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.fileMaxSize = jSONObject.optLong("fileMaxSize");
            }
            super.afterParseJson(jSONObject);
        }

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, "fileMaxSize", this.fileMaxSize);
            return jSONObject;
        }
    }

    public static AppStatusRules createFromJson(String str) {
        AppStatusRules appStatusRules = new AppStatusRules();
        if (TextUtils.isEmpty(str)) {
            return appStatusRules;
        }
        try {
            appStatusRules.parseJson(new JSONObject(str));
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        return appStatusRules;
    }

    public static boolean isAppStatusTargetNotEmpty(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return false;
        }
        boolean targetNotEmpty = appStatusRules.targetNotEmpty();
        List obtainNamedStrategyList = appStatusRules.obtainNamedStrategyList();
        return targetNotEmpty || (obtainNamedStrategyList != null && obtainNamedStrategyList.size() > 0);
    }

    public static boolean isUploadTargetNotEmpty(AppStatusRules appStatusRules) {
        List uploadTargets;
        return (appStatusRules == null || (uploadTargets = appStatusRules.getUploadTargets()) == null || uploadTargets.size() <= 0) ? false : true;
    }

    public ArrayList getAllStrategy() {
        ArrayList arrayList = new ArrayList();
        if (this.data.strategy != null) {
            arrayList.add(this.data.strategy);
        }
        if (this.data.namedStrategy != null) {
            arrayList.addAll(this.data.namedStrategy);
        }
        return arrayList;
    }

    public List getUploadTargets() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.uploadTarget;
    }

    public void initStatus(Context context) {
        Iterator it = getAllStrategy().iterator();
        while (it.hasNext()) {
            Strategy strategy = (Strategy) it.next();
            strategy.setNeedLaunch(i.a(context, strategy));
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

    public List obtainNamedStrategyList() {
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

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"))));
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public boolean targetNotEmpty() {
        AppStatusInfo appStatusInfo = this.data;
        return (appStatusInfo == null || appStatusInfo.target == null || this.data.target.size() <= 0) ? false : true;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        r.a(json, "data", this.data);
        return json;
    }
}
