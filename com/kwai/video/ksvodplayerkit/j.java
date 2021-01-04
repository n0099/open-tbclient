package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwai.video.player.KsMediaPlayerInitConfig;
/* loaded from: classes5.dex */
public class j {
    public static void a(@NonNull Context context) {
        a(context, h.a(context));
    }

    public static void a(@NonNull Context context, @NonNull String str) {
        a(context, str, true, null);
    }

    public static void a(@NonNull Context context, String str, boolean z, String str2) {
        KsMediaPlayerInitConfig.setReady();
        h.a(context, str, str2);
        if (z && TextUtils.isEmpty(str2)) {
            h.a(context, "{\"enable_quic\":true,\"quic_hints\":[[\"g-br-cdn.kwai.net\",80,443],[\"tx-br-cdn.kwai.net\",80,443],[\"g-ind-cdn.kwai.net\",80,443],[\"tx-ind-cdn.kwai.net\",80,443]],\"quic_idle_timeout_sec\":30,\"preconnect_urls\":[\"http:\\/\\/g-api.kwai.com\"],\"preconnect_num_streams\":3,\"preconnect_non_altsvc\":true,\"altsvc_broken_time_base\":300,\"altsvc_broken_time_max\":86400}");
        }
        com.kwai.video.ksvodplayerkit.HttpDns.e.a().b("{\"defaultPingConfig\":{\"mIcmpPingUseCmd\":false},\"defaultResolveConfig\":{},\"feedTimeout\":600000,\"hosts\":{\"ks.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ws.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":1,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws01.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":2,\"resolveConfig\":{},\"vendor\":\"ws\"},\"aliimg.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":7,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"bd.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":12,\"resolveConfig\":{},\"vendor\":\"bd\"},\"ws02.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":3,\"resolveConfig\":{},\"vendor\":\"ws\"},\"tx.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":10,\"resolveConfig\":{},\"vendor\":\"tx\"},\"xy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":11,\"resolveConfig\":{},\"vendor\":\"xy\"},\"ali.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"ali\"},\"js.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":0,\"resolveConfig\":{},\"vendor\":\"ks\"},\"tx2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"tx\"},\"alimov2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":6,\"resolveConfig\":{},\"vendor\":\"ali\"}},\"parallelism\":1,\"pauseOnBackground\":false}");
    }

    @WorkerThread
    public static void a(String str) {
        i.a().a(str);
    }
}
