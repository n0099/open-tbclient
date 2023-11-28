package com.yy.gslbsdk.protocol;

import com.yy.gslbsdk.device.NetStatusInfo;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ResInfo {
    public LinkedHashMap<String, DnsInfo> dns;
    public HttpDnsInfo httpdns;
    public NetStatusInfo netInfo;
    public String userIp;
    public String userView;
    public List<Map<String, String>> listRefresh = new LinkedList();
    public int status = 2;

    public LinkedHashMap<String, DnsInfo> getDns() {
        return this.dns;
    }

    public HttpDnsInfo getHttpdns() {
        return this.httpdns;
    }

    public List<Map<String, String>> getListRefresh() {
        return this.listRefresh;
    }

    public NetStatusInfo getNetInfo() {
        return this.netInfo;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public String getUserView() {
        return this.userView;
    }

    public void addRefresh(Map<String, String> map) {
        if (this.listRefresh == null) {
            this.listRefresh = new LinkedList();
        }
        this.listRefresh.add(map);
    }

    public void setDns(LinkedHashMap<String, DnsInfo> linkedHashMap) {
        this.dns = linkedHashMap;
    }

    public void setHttpdns(HttpDnsInfo httpDnsInfo) {
        this.httpdns = httpDnsInfo;
    }

    public void setNetInfo(NetStatusInfo netStatusInfo) {
        this.netInfo = netStatusInfo;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUserIp(String str) {
        this.userIp = str;
    }

    public void setUserView(String str) {
        this.userView = str;
    }

    public void updateResInfo(ResInfo resInfo) {
        this.status = resInfo.getStatus();
        this.userView = resInfo.getUserView();
        this.userIp = resInfo.getUserIp();
        this.dns = resInfo.getDns();
        this.httpdns = resInfo.getHttpdns();
        this.netInfo = resInfo.getNetInfo();
    }
}
