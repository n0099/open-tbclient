package com.xiaomi.push.mpcd.job;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class b extends g {
    public b(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 5;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) this.d.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(10)) {
                if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                    if (sb.length() > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    sb.append(runningTaskInfo.topActivity.getPackageName());
                }
            }
        } catch (Throwable th) {
        }
        if (TextUtils.isEmpty(sb)) {
            return null;
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.AppActiveList;
    }
}
