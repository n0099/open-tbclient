package com.kwad.sdk.collector;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static final long serialVersionUID = 3026909056348431027L;
    public transient /* synthetic */ FieldHolder $fh;
    public AppStatusInfo data;

    /* loaded from: classes7.dex */
    public static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2403646317801179050L;
        public transient /* synthetic */ FieldHolder $fh;
        public Strategy strategy;
        public ArrayList<Target> target;

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
        }

        public Strategy getStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.strategy : (Strategy) invokeV.objValue;
        }

        public ArrayList<Target> getTarget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.target : (ArrayList) invokeV.objValue;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    Target target = new Target();
                    target.parseJson(jSONObject2);
                    this.target.add(target);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void setStrategy(Strategy strategy) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, strategy) == null) {
                this.strategy = strategy;
            }
        }

        public void setTarget(ArrayList<Target> arrayList) {
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
                o.a(jSONObject, "strategy", this.strategy);
                o.a(jSONObject, "target", this.target);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1387498537762043285L;
        public transient /* synthetic */ FieldHolder $fh;
        public long historyGranularity;
        public long scanInterval;
        public long startTime;

        public Strategy() {
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
            this.historyGranularity = 60000L;
        }

        public long getHistoryGranularity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.historyGranularity : invokeV.longValue;
        }

        public long getScanInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.scanInterval : invokeV.longValue;
        }

        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.startTime : invokeV.longValue;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.scanInterval = j;
            }
        }

        public void setStartTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.startTime = j;
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "startTime", this.startTime);
                o.a(jSONObject, "scanInterval", this.scanInterval);
                o.a(jSONObject, "historyGranularity", this.historyGranularity / 1000);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Target implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4726982809581153390L;
        public transient /* synthetic */ FieldHolder $fh;
        public String packageName;
        public ArrayList<String> paths;

        public Target() {
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
            this.paths = new ArrayList<>();
        }

        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.packageName : (String) invokeV.objValue;
        }

        public ArrayList<String> getPaths() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.paths : (ArrayList) invokeV.objValue;
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
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
                e2.printStackTrace();
            }
        }

        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.packageName = str;
            }
        }

        public void setPaths(ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
                this.paths = arrayList;
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "packageName", this.packageName);
                o.a(jSONObject, "paths", this.paths);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public AppStatusRules() {
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
        this.data = new AppStatusInfo();
    }

    @NonNull
    public static AppStatusRules createFromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
        return (AppStatusRules) invokeL.objValue;
    }

    @Nullable
    public ArrayList<Target> getTargetList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null) {
                return null;
            }
            return appStatusInfo.getTarget();
        }
        return (ArrayList) invokeV.objValue;
    }

    public long obtainHistoryGranularity() {
        InterceptResult invokeV;
        Strategy strategy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null || (strategy = appStatusInfo.getStrategy()) == null) {
                return 60000L;
            }
            return strategy.getHistoryGranularity();
        }
        return invokeV.longValue;
    }

    public long obtainScanInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppStatusInfo appStatusInfo = this.data;
            if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
                return 0L;
            }
            long scanInterval = this.data.getStrategy().getScanInterval();
            return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
        }
        return invokeV.longValue;
    }

    public long obtainStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
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
    }

    public boolean targetNotEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Target> targetList = getTargetList();
            return targetList != null && targetList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, "data", this.data);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
