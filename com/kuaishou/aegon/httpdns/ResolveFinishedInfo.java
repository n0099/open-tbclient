package com.kuaishou.aegon.httpdns;

import androidx.annotation.Keep;
import java.util.List;
@Keep
/* loaded from: classes6.dex */
public class ResolveFinishedInfo {
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
        return "{\nhost : " + this.host + "\nsuccess : " + this.success + "\ntotal cost : " + this.totalCostMs + "\nnetwork cost : " + this.networkCostMs + "\nlocal cost : " + this.localCostMs + "\nping cost : " + this.pingCostMs + "\nnetwork nodes : " + this.networkResults + "\nlocal nodes : " + this.localResults + "\nping details : " + this.pingDetails + "\nping nodes : " + this.pingResults + "\n}client ip : " + this.clientIp + "\n}";
    }
}
