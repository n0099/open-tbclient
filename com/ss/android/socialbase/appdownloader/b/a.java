package com.ss.android.socialbase.appdownloader.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes4.dex */
public class a {
    public static final String a;

    static {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        z = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
        sb.append("AppDownloader");
        if (z2) {
            sb.append("/");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        if (z || z3) {
            sb.append(";");
            if (z) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        a = sb.toString();
    }
}
