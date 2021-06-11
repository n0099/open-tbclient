package com.yy.gslbsdk.device;

import com.yy.gslbsdk.control.NetworkStatus;
import com.yy.gslbsdk.util.GlobalTools;
/* loaded from: classes7.dex */
public class NetStatusInfo {
    public int netType = 1;
    public int isp = 0;
    public String ssid = null;
    public NetworkStatus networkStatus = NetworkStatus.getInstanceClone();

    public int getIsp() {
        return this.isp;
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
        int i2 = this.netType;
        return (i2 == 0 || i2 == 1 || i2 == 2 || this.isp == 0) ? false : true;
    }

    public void resetVal(NetStatusInfo netStatusInfo) {
        this.netType = netStatusInfo.netType;
        this.isp = netStatusInfo.isp;
        this.ssid = netStatusInfo.ssid;
        this.networkStatus = netStatusInfo.networkStatus.m630clone();
    }

    public void setIsp(int i2) {
        this.isp = i2;
    }

    public void setNetType(int i2) {
        this.netType = i2;
    }

    public void setNetworkStatus(NetworkStatus networkStatus) {
        this.networkStatus = networkStatus;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }
}
