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
/* loaded from: classes10.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    public static SimpleDateFormat anb = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: zI */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j);
            this.mPtr = 0L;
        }
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
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        t.putValue(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        t.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + X(c.c(this)) + '}';
    }

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }

    public static String X(long j) {
        return anb.format(new Date(j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
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
        if (i > 0) {
            return 1;
        }
        return -1;
    }

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
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
        if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity || !appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return false;
        }
        return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
    }
}
