package com.yy.hiidostatis.inner.util.hdid;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class Device {
    public static final int HFROM_NEW_INNER = 4;
    public static final int HFROM_NEW_OUTER = 5;
    public static final int HFROM_NEW_SETTING = 6;
    public static final int HFROM_OLD_INNER = 1;
    public static final int HFROM_OLD_NEW = 0;
    public static final int HFROM_OLD_OUT1 = 2;
    public static final int HFROM_OLD_OUT2 = 3;
    public String arid;
    public int hFrom;
    public String hdid;
    public String imei;
    public JSONObject json;
    public String mac;
    public String sdPermission;
    public String type = "0";
    public long crtTime = 0;

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || hashCode() != obj.hashCode()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%s,%s,%s", this.hdid + "", this.imei + "", this.mac + "");
    }
}
