package com.yy.gslbsdk.device;

import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.util.GlobalTools;
/* loaded from: classes10.dex */
public class NetStatusInfo {
    public int netType = 1;
    public int isp = 0;
    public String ssid = null;
    public NetworkStatus networkStatus = NetworkStatus.getInstanceClone();

    public int getIsp() {
        return this.isp;
    }

    public int getNetType() {
        return this.netType;
    }

    public NetworkStatus getNetworkStatus() {
        return this.networkStatus;
    }

    public String getSsid() {
        return this.ssid;
    }

    public boolean isKnowIsp() {
        int i = this.netType;
        if (i == 0 || i == 1 || i == 2 || this.isp == 0) {
            return false;
        }
        return true;
    }

    public String getNetStatusID() {
        try {
            if (this.netType != 0 && this.netType != 1) {
                if (this.netType == 2) {
                    return String.valueOf(this.netType) + "-" + this.ssid + "-" + GlobalTools.APP_LOCALIZE_CODE;
                }
                return String.valueOf(this.netType) + "-" + this.isp + "-" + GlobalTools.APP_LOCALIZE_CODE;
            }
            return String.valueOf(this.netType) + "-" + GlobalTools.APP_LOCALIZE_CODE;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public void resetVal(NetStatusInfo netStatusInfo) {
        this.netType = netStatusInfo.netType;
        this.isp = netStatusInfo.isp;
        this.ssid = netStatusInfo.ssid;
        this.networkStatus = netStatusInfo.networkStatus.m844clone();
    }

    public void setIsp(int i) {
        this.isp = i;
    }

    public void setNetType(int i) {
        this.netType = i;
    }

    public void setNetworkStatus(NetworkStatus networkStatus) {
        this.networkStatus = networkStatus;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }
}
