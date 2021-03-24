package d.b.s.a.a;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import d.b.s.a.g.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class c {
    public static IMPushPb.Action b(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
    }

    public static IMPushPb.Action d(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build();
    }

    public static void e(Context context, Connection connection) {
        try {
            HashSet hashSet = new HashSet(d.c(context));
            hashSet.add(Base64.encodeToString(d(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId).toByteArray(), 0));
            d.t(context, hashSet);
        } catch (Exception e2) {
            d.b.s.a.g.d.c("TrackPbGenerator", "putIMConnectionToActions :", e2);
        }
    }

    public static void f(Context context, Request request) {
        try {
            HashSet hashSet = new HashSet(d.g(context));
            hashSet.add(Base64.encodeToString(b(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId).toByteArray(), 0));
            d.A(context, hashSet);
        } catch (Exception e2) {
            d.b.s.a.g.d.c("TrackPbGenerator", "putIMRequestToActions :", e2);
        }
    }

    public byte[] a(Context context, @NonNull IMPushPb.Action action) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(action);
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.e(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(arrayList).build().toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] c(Context context) {
        try {
            Set<String> g2 = d.g(context);
            HashSet<String> hashSet = new HashSet(g2);
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (g2.size() <= 4000 && g2.size() >= 1) {
                for (String str : hashSet) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str, 0)));
                }
            }
            Set<String> c2 = d.c(context);
            HashSet<String> hashSet2 = new HashSet(c2);
            if (c2.size() <= 4000 - g2.size() && c2.size() >= 1) {
                for (String str2 : hashSet2) {
                    copyOnWriteArrayList.add(IMPushPb.Action.parseFrom(Base64.decode(str2, 0)));
                }
            }
            return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, e.e(context))).setSdkName("lcp").setSdkVersion(2240016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
        } catch (Exception e2) {
            d.b.s.a.g.d.c("TrackPbGenerator", "generateTrackClient :", e2);
            return null;
        }
    }
}
