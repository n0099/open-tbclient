package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import java.io.File;
/* loaded from: classes10.dex */
public final class r {
    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(s.getFileMD5(file).toLowerCase());
    }

    public static boolean k(File file) {
        if (file != null && file.exists() && file.length() > 0 && file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
            return true;
        }
        return false;
    }
}
