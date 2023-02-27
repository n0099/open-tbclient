package com.yy.gslbsdk.protocol;

import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class DnsInfo {
    public static final String TAG = "DnsInfo";
    public CmdInfo cmd;
    public long endTime;
    public String host;
    public int nt;
    public long probeTime;
    public int ttl;
    public String uip;

    /* renamed from: view  reason: collision with root package name */
    public String f1088view;
    public LinkedList<String> ips = new LinkedList<>();
    public int source = 0;
    public int status = 0;

    public CmdInfo getCmd() {
        return this.cmd;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getHost() {
        return this.host;
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
        return this.f1088view;
    }

    public void cloneDnsInfo(DnsInfo dnsInfo) {
        this.host = dnsInfo.getHost();
        this.uip = dnsInfo.getUip();
        this.f1088view = dnsInfo.getView();
        this.ttl = dnsInfo.getTtl();
        this.probeTime = dnsInfo.getProbeTime();
        this.endTime = dnsInfo.getEndTime();
        this.cmd = dnsInfo.getCmd();
        this.ips = (LinkedList) dnsInfo.getIps().clone();
        this.source = dnsInfo.getSource();
        this.status = dnsInfo.status;
    }

    public String getCmdStr() {
        if (this.cmd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pe", this.cmd.isPe());
                jSONObject.put("re", this.cmd.isRe());
                return jSONObject.toString();
            } catch (Exception e) {
                LogTools.printError(TAG, "getCmdStr() exception:" + e.getMessage());
            }
        }
        return "";
    }

    public String toString() {
        return this.host + ":[" + getIPStr() + "],ttl=" + String.valueOf(this.ttl) + ", status=" + String.valueOf(this.status);
    }

    public String getIPStr() {
        LinkedList<String> linkedList = this.ips;
        if (linkedList != null && !linkedList.isEmpty()) {
            String str = "";
            for (int i = 0; i < this.ips.size(); i++) {
                str = str + this.ips.get(i);
                if (i != this.ips.size() - 1) {
                    str = str + ",";
                }
            }
            return str;
        }
        return null;
    }

    public void setCmd(CmdInfo cmdInfo) {
        this.cmd = cmdInfo;
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

    public void setNt(int i) {
        this.nt = i;
    }

    public void setProbeTime(long j) {
        this.probeTime = j;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTtl(int i) {
        this.ttl = i;
        float f = i;
        this.endTime = System.currentTimeMillis() + ((int) (GlobalTools.TTL_EXPIRED_FACTOR * f * 1000.0f));
        this.probeTime = System.currentTimeMillis() + ((int) (f * GlobalTools.TTL_PROBE_FACTOR * 1000.0f));
    }

    public void setUip(String str) {
        this.uip = str;
    }

    public void setView(String str) {
        this.f1088view = str;
    }

    public void setCmdStr(String str) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cmd = new CmdInfo();
                if (jSONObject.has("pe")) {
                    this.cmd.setPe(jSONObject.getBoolean("pe"));
                }
                if (jSONObject.has("re")) {
                    this.cmd.setRe(jSONObject.getBoolean("re"));
                }
            } catch (Exception e) {
                LogTools.printError(TAG, "setCmdStr() exception:" + e.getMessage());
            }
        }
    }
}
