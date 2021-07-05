package com.kuaishou.aegon.httpdns;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class ResolveFinishedInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String clientIp;
    public String errorMessage;
    public String host;
    public long localCostMs;
    public List<ResolvedIP> localResults;
    public long networkCostMs;
    public List<ResolvedIP> networkResults;
    public long pingCostMs;
    public String pingDetails;
    public long pingIpTimeout;
    public List<ResolvedIP> pingResults;
    public long resolveIpTimeout;
    public boolean success;
    public long totalCostMs;
    public long ttl;

    @Keep
    public ResolveFinishedInfo(String str, boolean z, long j, String str2, long j2, long j3, long j4, List<ResolvedIP> list, List<ResolvedIP> list2, List<ResolvedIP> list3, String str3, long j5, long j6, long j7, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Long.valueOf(j), str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), list, list2, list3, str3, Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.success = false;
        this.totalCostMs = 0L;
        this.errorMessage = null;
        this.host = str;
        this.success = z;
        this.totalCostMs = j;
        this.errorMessage = str2;
        this.networkCostMs = j2;
        this.localCostMs = j3;
        this.pingCostMs = j4;
        this.networkResults = list;
        this.localResults = list2;
        this.pingResults = list3;
        this.pingDetails = str3;
        this.resolveIpTimeout = j5;
        this.pingIpTimeout = j6;
        this.ttl = j7;
        this.clientIp = str4;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{\nhost : " + this.host + "\nsuccess : " + this.success + "\ntotal cost : " + this.totalCostMs + "\nnetwork cost : " + this.networkCostMs + "\nlocal cost : " + this.localCostMs + "\nping cost : " + this.pingCostMs + "\nnetwork nodes : " + this.networkResults + "\nlocal nodes : " + this.localResults + "\nping details : " + this.pingDetails + "\nping nodes : " + this.pingResults + "\n}client ip : " + this.clientIp + "\n}";
        }
        return (String) invokeV.objValue;
    }
}
