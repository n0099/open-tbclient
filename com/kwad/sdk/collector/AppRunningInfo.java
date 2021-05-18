package com.kwad.sdk.collector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppRunningInfo implements Serializable, Cloneable, Comparable<AppRunningInfo> {
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    public static final long serialVersionUID = 7014997764778342190L;
    public long granularity;
    public String name = "";
    public String packageName = "";
    public long lastRunningTime = -1;

    public AppRunningInfo(long j) {
        this.granularity = 60000L;
        if (j > 0) {
            this.granularity = j;
        }
    }

    public static AppRunningInfo createInstance(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        AppRunningInfo appRunningInfo = new AppRunningInfo(strategy == null ? -1L : strategy.getHistoryGranularity());
        appRunningInfo.setPackageName(appPackageInfo.packageName);
        appRunningInfo.setName(appPackageInfo.appName);
        return appRunningInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public AppRunningInfo m43clone() {
        AppRunningInfo appRunningInfo = new AppRunningInfo(this.granularity);
        appRunningInfo.setName(this.name);
        appRunningInfo.setLastRunningTime(this.lastRunningTime);
        appRunningInfo.setPackageName(this.packageName);
        return appRunningInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(AppRunningInfo appRunningInfo) {
        if (appRunningInfo == null) {
            return 1;
        }
        int i2 = ((this.lastRunningTime - appRunningInfo.getLastRunningTime()) > 0L ? 1 : ((this.lastRunningTime - appRunningInfo.getLastRunningTime()) == 0L ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppRunningInfo.class != obj.getClass()) {
            return false;
        }
        AppRunningInfo appRunningInfo = (AppRunningInfo) obj;
        long j = this.granularity;
        if (j == appRunningInfo.granularity && this.lastRunningTime / j == appRunningInfo.getLastRunningTime() / j && this.name.equals(appRunningInfo.name)) {
            return this.packageName.equals(appRunningInfo.packageName);
        }
        return false;
    }

    public String formatTime(long j) {
        return format.format(new Date(j));
    }

    public String getFormattedLastRunningTime() {
        return formatTime(getLastRunningTime());
    }

    public long getLastRunningTime() {
        return this.lastRunningTime;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        long j = this.lastRunningTime / this.granularity;
        return (((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public void setLastRunningTime(long j) {
        this.lastRunningTime = j;
    }

    public void setName(String str) {
        if (str != null) {
            this.name = str;
        }
    }

    public void setPackageName(String str) {
        if (str != null) {
            this.packageName = str;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "name", this.name);
        o.a(jSONObject, "packageName", this.packageName);
        o.a(jSONObject, "lastRunningTime", this.lastRunningTime);
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + this.packageName + "', lastRunningTime=" + formatTime(this.lastRunningTime) + '}';
    }
}
