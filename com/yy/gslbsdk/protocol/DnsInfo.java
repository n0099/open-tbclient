package com.yy.gslbsdk.protocol;

import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class DnsInfo {
    public static final String TAG = "DnsInfo";
    public CmdInfo cmd;
    public long endTime;
    public String host;
    public int nt;
    public long probeTime;
    public int ttl;
    public String uip;
    public String view;
    public LinkedList<String> ips = new LinkedList<>();
    public int source = 0;
    public int status = 0;

    public void cloneDnsInfo(DnsInfo dnsInfo) {
        this.host = dnsInfo.getHost();
        this.uip = dnsInfo.getUip();
        this.view = dnsInfo.getView();
        this.ttl = dnsInfo.getTtl();
        this.probeTime = dnsInfo.getProbeTime();
        this.endTime = dnsInfo.getEndTime();
        this.cmd = dnsInfo.getCmd();
        this.ips = (LinkedList) dnsInfo.getIps().clone();
        this.source = dnsInfo.getSource();
        this.status = dnsInfo.status;
    }

    public CmdInfo getCmd() {
        return this.cmd;
    }

    public String getCmdStr() {
        if (this.cmd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pe", this.cmd.isPe());
                jSONObject.put("re", this.cmd.isRe());
                return jSONObject.toString();
            } catch (Exception e2) {
                LogTools.printError(TAG, "getCmdStr() exception:" + e2.getMessage());
            }
        }
        return "";
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getHost() {
        return this.host;
    }

    public String getIPStr() {
        LinkedList<String> linkedList = this.ips;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        String str = "";
        for (int i2 = 0; i2 < this.ips.size(); i2++) {
            str = str + this.ips.get(i2);
            if (i2 != this.ips.size() - 1) {
                str = str + ",";
            }
        }
        return str;
    }

    public LinkedList<String> getIps() {
        return this.ips;
    }

    public int getNt() {
        return this.nt;
    }

    public long getProbeTime() {
        return this.probeTime;
    }

    public int getSource() {
        return this.source;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTtl() {
        return this.ttl;
    }

    public String getUip() {
        return this.uip;
    }

    public String getView() {
        return this.view;
    }

    public void setCmd(CmdInfo cmdInfo) {
        this.cmd = cmdInfo;
    }

    public void setCmdStr(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.cmd = new CmdInfo();
            if (jSONObject.has("pe")) {
                this.cmd.setPe(jSONObject.getBoolean("pe"));
            }
            if (jSONObject.has("re")) {
                this.cmd.setRe(jSONObject.getBoolean("re"));
            }
        } catch (Exception e2) {
            LogTools.printError(TAG, "setCmdStr() exception:" + e2.getMessage());
        }
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setIPStr(String str) {
        String[] split;
        if (str != null) {
            for (String str2 : str.split(",")) {
                if (str2 != null) {
                    if (this.ips == null) {
                        this.ips = new LinkedList<>();
                    }
                    this.ips.add(str2);
                }
            }
        }
    }

    public void setIps(LinkedList<String> linkedList) {
        if (linkedList == null) {
            return;
        }
        this.ips = linkedList;
    }

    public void setNt(int i2) {
        this.nt = i2;
    }

    public void setProbeTime(long j) {
        this.probeTime = j;
    }

    public void setSource(int i2) {
        this.source = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTtl(int i2) {
        this.ttl = i2;
        float f2 = i2;
        this.endTime = System.currentTimeMillis() + ((int) (GlobalTools.TTL_EXPIRED_FACTOR * f2 * 1000.0f));
        this.probeTime = System.currentTimeMillis() + ((int) (f2 * GlobalTools.TTL_PROBE_FACTOR * 1000.0f));
    }

    public void setUip(String str) {
        this.uip = str;
    }

    public void setView(String str) {
        this.view = str;
    }

    public String toString() {
        return this.host + ":[" + getIPStr() + "],ttl=" + String.valueOf(this.ttl) + ", status=" + String.valueOf(this.status);
    }
}
