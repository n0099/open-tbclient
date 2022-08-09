package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
@Deprecated(message = "废弃不再使用")
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u0011J3\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0017H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "getHidoDeviceId", "(Landroid/content/Context;)Ljava/lang/String;", "", "scode", "uri", "countName", "", "count", "", "reportCount", "(ILjava/lang/String;Ljava/lang/String;J)V", "times", "(ILjava/lang/String;Ljava/lang/String;JI)V", "timeConsumption", "code", "reportReturnCode", "(ILjava/lang/String;JLjava/lang/String;)V", "act", "", "map", "reportStatisticContent", "(Ljava/lang/String;Ljava/util/Map;)V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface IReporter {
    String getHidoDeviceId(Context context);

    void reportCount(int i, String str, String str2, long j);

    void reportCount(int i, String str, String str2, long j, int i2);

    void reportReturnCode(int i, String str, long j, String str2);

    void reportStatisticContent(String str, Map<String, String> map);
}
