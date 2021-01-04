package com.kuaishou.aegon.httpdns;

import androidx.annotation.Keep;
import java.util.List;
@Keep
/* loaded from: classes5.dex */
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
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("host : ").append(this.host).append("\n");
        sb.append("success : ").append(this.success).append("\n");
        sb.append("total cost : ").append(this.totalCostMs).append("\n");
        sb.append("network cost : ").append(this.networkCostMs).append("\n");
        sb.append("local cost : ").append(this.localCostMs).append("\n");
        sb.append("ping cost : ").append(this.pingCostMs).append("\n");
        sb.append("network nodes : ").append(this.networkResults).append("\n");
        sb.append("local nodes : ").append(this.localResults).append("\n");
        sb.append("ping details : ").append(this.pingDetails).append("\n");
        sb.append("ping nodes : ").append(this.pingResults).append("\n}");
        sb.append("client ip : ").append(this.clientIp).append("\n}");
        return sb.toString();
    }
}
