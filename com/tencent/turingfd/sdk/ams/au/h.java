package com.tencent.turingfd.sdk.ams.au;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final long f13527a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public static String f13528b = "";

    /* JADX WARN: Removed duplicated region for block: B:47:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, boolean z, int i, boolean z2, boolean z3) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("T:");
        sb.append(f13527a);
        sb.append(",");
        sb.append("LT:");
        sb.append("" + (System.currentTimeMillis() - f13527a));
        sb.append(",");
        sb.append("F:");
        sb.append(z ? "1" : "0");
        sb.append(",");
        sb.append("PT:");
        sb.append("" + i);
        sb.append(",");
        sb.append("WF:");
        sb.append("0");
        sb.append(",");
        sb.append("PKG:");
        sb.append(z2 ? "1" : "0");
        sb.append(",");
        sb.append("SC:");
        sb.append(z3 ? "1" : "0");
        String b2 = f.f13522a.b(context);
        if (!TextUtils.isEmpty(b2)) {
            sb.append(",");
            sb.append("CL:");
            sb.append(b2);
        }
        String a2 = c.a(context, "204");
        if (TextUtils.isEmpty(a2)) {
            a2 = "0";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(",");
            sb.append("R:");
            sb.append(a2);
        }
        int i2 = bh.a(context).getInt("301", 0);
        if (i2 > 0) {
            sb.append(",");
            sb.append("RB:");
            sb.append(i2);
        }
        if (!TextUtils.isEmpty(c.a(context, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN))) {
            sb.append(",");
            sb.append("TAT:");
            sb.append("1");
        }
        if (TextUtils.isEmpty(f13528b)) {
            String str2 = "";
            int myPid = Process.myPid();
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                    str2 = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str2;
                }
            } catch (Throwable th) {
            }
            f13528b = str2;
            sb.append(",");
            sb.append("P:");
            sb.append(f13528b);
        }
        String a3 = g.a().a("3");
        if (!TextUtils.isEmpty(a3)) {
            byte[] a4 = aj.a(a3);
            if (a4.length != 0) {
                byte[] b3 = aj.b(a4, ".turingdebug".getBytes());
                try {
                    new File(a3).deleteOnExit();
                } catch (Throwable th2) {
                }
                try {
                    str = new String(b3);
                } catch (Throwable th3) {
                }
                if (TextUtils.isEmpty(str)) {
                    sb.append(",");
                    sb.append("RD:");
                    sb.append(str);
                }
                sb.append(",");
                sb.append("US:");
                sb.append(c.a(context));
                return sb.toString();
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
        }
        sb.append(",");
        sb.append("US:");
        sb.append(c.a(context));
        return sb.toString();
    }
}
