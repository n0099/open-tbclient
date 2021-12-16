package com.yy.hiidostatis.message;

import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.defs.obj.Property;
import java.util.Map;
/* loaded from: classes4.dex */
public interface HApi {
    @Deprecated
    String getHdid(Context context);

    void reportAppsflyer(String str);

    void reportCountEvent(long j2, String str, double d2);

    void reportCountEvent(long j2, String str, double d2, String str2);

    void reportCountEvent(long j2, String str, double d2, String str2, Property property);

    void reportCrash(long j2, String str);

    void reportCrash(long j2, Throwable th);

    void reportCustomContent(long j2, String str, String str2);

    void reportErrorEvent(long j2, String str, String str2, String str3);

    void reportFailure(long j2, String str, String str2, String str3, String str4, String str5);

    boolean reportFeedBack(String str, String str2, String str3);

    void reportLocation(double d2, double d3, double d4);

    void reportLogin(long j2);

    void reportPushToken(String str);

    void reportReg(String str, String str2, String str3, Map<String, String> map);

    void reportStatisticContent(String str, StatisContent statisContent);

    void reportStatisticContent(String str, StatisContent statisContent, boolean z);

    void reportStatisticContentTemporary(String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent);

    void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z);

    void reportSuccess(long j2, String str, String str2, long j3, String str3);

    void reportTimesEvent(long j2, String str);

    void reportTimesEvent(long j2, String str, String str2);

    void reportTimesEvent(long j2, String str, String str2, Property property);
}
