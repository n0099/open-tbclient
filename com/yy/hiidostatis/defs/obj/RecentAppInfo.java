package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RecentAppInfo {
    public long lastModified;
    public String name;
    public String pkg;
    public int type;

    public static RecentAppInfo fromJson(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("pkg");
            Long valueOf = Long.valueOf(jSONObject.getLong("ts"));
            int i2 = jSONObject.getInt("type");
            if (string2 == null || string2.isEmpty() || valueOf == null) {
                return null;
            }
            RecentAppInfo recentAppInfo = new RecentAppInfo();
            recentAppInfo.setLastModified(valueOf.longValue());
            recentAppInfo.setPkg(string2);
            recentAppInfo.setName(string);
            recentAppInfo.setType(i2);
            return recentAppInfo;
        } catch (Throwable th) {
            L.debug("RecentAppInfo", th.getMessage(), new Object[0]);
            return null;
        }
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getName() {
        return this.name;
    }

    public String getPkg() {
        return this.pkg;
    }

    public int getType() {
        return this.type;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPkg(String str) {
        this.pkg = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.name != null) {
                jSONObject.put("name", this.name);
            }
            jSONObject.put("pkg", this.pkg);
            jSONObject.put("ts", this.lastModified);
            jSONObject.put("type", this.type);
            return jSONObject;
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            return null;
        }
    }
}
