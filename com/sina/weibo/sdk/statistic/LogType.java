package com.sina.weibo.sdk.statistic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public enum LogType {
    SESSION_START,
    SESSION_END,
    FRAGMENT,
    EVENT,
    ACTIVITY,
    APP_AD_START;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static LogType[] valuesCustom() {
        LogType[] valuesCustom = values();
        int length = valuesCustom.length;
        LogType[] logTypeArr = new LogType[length];
        System.arraycopy(valuesCustom, 0, logTypeArr, 0, length);
        return logTypeArr;
    }
}
