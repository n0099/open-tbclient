package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.q;
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
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static String SUFFIX_ALL_CHILDREN = "/*";
    public static String SUFFIX_ALL_FILE = "*";
    public static final long serialVersionUID = 3026909056348431027L;
    public transient /* synthetic */ FieldHolder $fh;
    public AppStatusInfo data;

    /* renamed from: com.kwad.sdk.collector.AppStatusRules$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2403646317801179050L;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<Strategy> namedStrategy;
        public Strategy strategy;
        public ArrayList<com.kwad.sdk.collector.model.d> target;
        public UploadConfig uploadConfig;
        public ArrayList<com.kwad.sdk.collector.model.d> uploadTarget;

        public AppStatusInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.strategy = new Strategy();
            this.target = new ArrayList<>();
            this.namedStrategy = new ArrayList<>();
            this.uploadTarget = new ArrayList<>();
            this.uploadConfig = new UploadConfig();
        }

        public /* synthetic */ AppStatusInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        private void duplicateTarget() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                Set<String> targetPackages = this.strategy.getTargetPackages();
                HashSet hashSet = new HashSet();
                Iterator<Strategy> it = this.namedStrategy.iterator();
                while (it.hasNext()) {
                    hashSet.addAll(it.next().getTargetPackages());
                }
                targetPackages.retainAll(hashSet);
                this.strategy.removeTargetsByPackage(targetPackages);
            }
        }

        public Strategy getStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.strategy : (Strategy) invokeV.objValue;
        }

        public ArrayList<com.kwad.sdk.collector.model.d> getTarget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.target : (ArrayList) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("namedStrategy")) {
                    this.namedStrategy = Strategy.createFromJSONArray(jSONObject.getJSONArray("namedStrategy"));
                }
                if (jSONObject.has("uploadTarget")) {
                    this.uploadTarget = com.kwad.sdk.collector.model.c.a(jSONObject.optJSONArray("uploadTarget"));
                }
                if (jSONObject.has("uploadConfig")) {
                    this.uploadConfig.parseJson(jSONObject.optJSONObject("uploadConfig"));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                ArrayList<com.kwad.sdk.collector.model.d> a2 = com.kwad.sdk.collector.model.c.a(optJSONArray);
                this.target = a2;
                this.strategy.setTarget(a2);
                duplicateTarget();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        public void setStrategy(Strategy strategy) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, strategy) == null) {
                this.strategy = strategy;
            }
        }

        public void setTarget(ArrayList<com.kwad.sdk.collector.model.d> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
                this.target = arrayList;
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "strategy", this.strategy);
                q.a(jSONObject, "target", this.target);
                q.a(jSONObject, "namedStrategy", this.namedStrategy);
                q.a(jSONObject, "uploadTarget", this.uploadTarget);
                q.a(jSONObject, "uploadConfig", this.uploadConfig);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static Strategy LOCAL_DEFAULT = null;
        public static final long serialVersionUID = -1387498537762043285L;
        public transient /* synthetic */ FieldHolder $fh;
        public long historyGranularity;
        public long minLaunchInterval;
        public String name;
        public boolean needLaunch;
        public long needSaveLaunchTime;
        public long scanInterval;
        public long startTime;
        public HashMap<String, com.kwad.sdk.collector.model.d> targetMap;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1843778267, "Lcom/kwad/sdk/collector/AppStatusRules$Strategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1843778267, "Lcom/kwad/sdk/collector/AppStatusRules$Strategy;");
                    return;
                }
            }
            Strategy strategy = new Strategy();
            LOCAL_DEFAULT = strategy;
            strategy.setStartTime(86400000L);
            LOCAL_DEFAULT.setHistoryGranularity(60000L);
        }

        public Strategy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.startTime = 86400000L;
            this.historyGranularity = 60000L;
            this.name = null;
            this.targetMap = new HashMap<>();
            this.needLaunch = true;
            this.needSaveLaunchTime = -1L;
        }

        public static ArrayList<Strategy> createFromJSONArray(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
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
            return (ArrayList) invokeL.objValue;
        }

        public long getHistoryGranularity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.historyGranularity : invokeV.longValue;
        }

        public long getMinLaunchIntervalWithMS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.minLaunchInterval * 1000 : invokeV.longValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public long getNeedSaveLaunchTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.needSaveLaunchTime : invokeV.longValue;
        }

        public long getScanInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.scanInterval : invokeV.longValue;
        }

        public long getStartTimeWithMS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.startTime * 1000 : invokeV.longValue;
        }

        public ArrayList<com.kwad.sdk.collector.model.d> getTarget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ArrayList<>(this.targetMap.values()) : (ArrayList) invokeV.objValue;
        }

        public Set<String> getTargetPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Collection<com.kwad.sdk.collector.model.d> values = this.targetMap.values();
                HashSet hashSet = new HashSet();
                for (com.kwad.sdk.collector.model.d dVar : values) {
                    hashSet.add(com.kwad.sdk.collector.model.c.a(dVar));
                }
                return hashSet;
            }
            return (Set) invokeV.objValue;
        }

        public boolean isNeedLaunch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.needLaunch : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
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
                this.needSaveLaunchTime = jSONObject.optLong("needSaveLaunchTime");
                this.needLaunch = jSONObject.optBoolean("needLaunch");
                setTarget(com.kwad.sdk.collector.model.c.a(jSONObject.optJSONArray("target")));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        public void removeTargetsByPackage(Collection<String> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, collection) == null) {
                for (String str : collection) {
                    this.targetMap.remove(str);
                }
            }
        }

        public void setHistoryGranularity(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
                this.historyGranularity = j;
            }
        }

        public void setNeedLaunch(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
                this.needLaunch = z;
            }
        }

        public void setNeedSaveLaunchTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                this.needSaveLaunchTime = j;
            }
        }

        public void setScanInterval(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
                this.scanInterval = j;
            }
        }

        public void setStartTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
                this.startTime = j;
            }
        }

        public void setTarget(ArrayList<com.kwad.sdk.collector.model.d> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
                if (arrayList == null) {
                    this.targetMap.clear();
                    return;
                }
                Iterator<com.kwad.sdk.collector.model.d> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.collector.model.d next = it.next();
                    this.targetMap.put(com.kwad.sdk.collector.model.c.a(next), next);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "startTime", this.startTime);
                q.a(jSONObject, "scanInterval", this.scanInterval);
                q.a(jSONObject, "historyGranularity", this.historyGranularity / 1000);
                q.a(jSONObject, "name", this.name);
                q.a(jSONObject, "target", getTarget());
                q.a(jSONObject, "minLaunchInterval", this.minLaunchInterval);
                q.a(jSONObject, "needSaveLaunchTime", this.needSaveLaunchTime);
                q.a(jSONObject, "needLaunch", this.needLaunch);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class UploadConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_FILE_MAX_SIZE = 102400;
        public static final long serialVersionUID = 8541150615721258815L;
        public transient /* synthetic */ FieldHolder $fh;
        public long fileMaxSize;

        public UploadConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.afterParseJson(jSONObject);
                if (this.fileMaxSize < 0) {
                    this.fileMaxSize = ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1359837530, "Lcom/kwad/sdk/collector/AppStatusRules;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1359837530, "Lcom/kwad/sdk/collector/AppStatusRules;");
        }
    }

    public AppStatusRules() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = new AppStatusInfo(null);
    }

    @NonNull
    public static AppStatusRules createFromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
        return (AppStatusRules) invokeL.objValue;
    }

    public static boolean isAppStatusTargetNotEmpty(AppStatusRules appStatusRules) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, appStatusRules)) == null) {
            if (appStatusRules == null) {
                return false;
            }
            boolean targetNotEmpty = appStatusRules.targetNotEmpty();
            List<Strategy> obtainNamedStrategyList = appStatusRules.obtainNamedStrategyList();
            return targetNotEmpty || (obtainNamedStrategyList != null && obtainNamedStrategyList.size() > 0);
        }
        return invokeL.booleanValue;
    }

    public static boolean isUploadTargetNotEmpty(AppStatusRules appStatusRules) {
        InterceptResult invokeL;
        List<com.kwad.sdk.collector.model.d> uploadTargets;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, appStatusRules)) == null) ? (appStatusRules == null || (uploadTargets = appStatusRules.getUploadTargets()) == null || uploadTargets.size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public ArrayList<Strategy> getAllStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<Strategy> arrayList = new ArrayList<>();
            if (this.data.strategy != null) {
                arrayList.add(this.data.strategy);
            }
            if (this.data.namedStrategy != null) {
                arrayList.addAll(this.data.namedStrategy);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public List<com.kwad.sdk.collector.model.d> getUploadTargets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null) {
                return null;
            }
            return appStatusInfo.uploadTarget;
        }
        return (List) invokeV.objValue;
    }

    public void initStatus(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Iterator<Strategy> it = getAllStrategy().iterator();
            while (it.hasNext()) {
                Strategy next = it.next();
                next.setNeedLaunch(h.a(context, next));
            }
        }
    }

    public long obtainDefaultScanInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
                return 0L;
            }
            long scanInterval = this.data.getStrategy().getScanInterval();
            return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
        }
        return invokeV.longValue;
    }

    public Strategy obtainDefaultStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null) {
                return null;
            }
            return appStatusInfo.strategy;
        }
        return (Strategy) invokeV.objValue;
    }

    public List<Strategy> obtainNamedStrategyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null) {
                return null;
            }
            return appStatusInfo.namedStrategy;
        }
        return (List) invokeV.objValue;
    }

    public long obtainUploadConfigFileMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            return (appStatusInfo == null || appStatusInfo.uploadConfig == null) ? ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT : this.data.uploadConfig.fileMaxSize;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
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
    }

    public boolean targetNotEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            return (appStatusInfo == null || appStatusInfo.target == null || this.data.target.size() <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject json = super.toJson();
            q.a(json, "data", this.data);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
