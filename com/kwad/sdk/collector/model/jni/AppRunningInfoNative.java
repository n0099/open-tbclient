package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        int i = ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative)) > 0L ? 1 : ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative)) == 0L ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i > 0 ? 1 : -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    public String a(long j) {
        return a.format(new Date(j));
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppRunningInfoNative.class != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / appRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (appRunningInfoGetLastRunningTime ^ (appRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        t.a(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        t.a(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + a(c.c(this)) + '}';
    }
}
