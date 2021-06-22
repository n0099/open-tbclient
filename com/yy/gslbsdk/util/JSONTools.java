package com.yy.gslbsdk.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class JSONTools {
    public static void doFill(StringBuilder sb, int i2, String str) {
        sb.append("\n");
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(str);
        }
    }

    public static String formatJson(String str, String str2) {
        int i2;
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (str.length() > 0) {
            String token = getToken(str);
            str = str.substring(token.length());
            arrayList.add(token.trim());
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            int length = ((String) arrayList.get(i5)).getBytes().length;
            if (length > i4 && i5 < arrayList.size() - 1 && ((String) arrayList.get(i5 + 1)).equals(":")) {
                i4 = length;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        while (i3 < arrayList.size()) {
            String str3 = (String) arrayList.get(i3);
            if (str3.equals(",")) {
                sb.append(str3);
                doFill(sb, i6, str2);
            } else if (str3.equals(":")) {
                sb.append("");
                sb.append(str3);
                sb.append(" ");
            } else if (str3.equals(StringUtil.ARRAY_START)) {
                i2 = i3 + 1;
                if (((String) arrayList.get(i2)).equals("}")) {
                    sb.append("{ }");
                    i3 = i2;
                } else {
                    i6++;
                    sb.append(str3);
                    doFill(sb, i6, str2);
                }
            } else if (str3.equals("}")) {
                i6--;
                doFill(sb, i6, str2);
                sb.append(str3);
            } else if (str3.equals(PreferencesUtil.LEFT_MOUNT)) {
                i2 = i3 + 1;
                if (((String) arrayList.get(i2)).equals(PreferencesUtil.RIGHT_MOUNT)) {
                    sb.append("[ ]");
                    i3 = i2;
                } else {
                    i6++;
                    sb.append(str3);
                    doFill(sb, i6, str2);
                }
            } else if (str3.equals(PreferencesUtil.RIGHT_MOUNT)) {
                i6--;
                doFill(sb, i6, str2);
                sb.append(str3);
            } else {
                sb.append(str3);
            }
            i3++;
        }
        return sb.toString();
    }

    public static String getToken(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (str.length() > 0) {
            String substring = str.substring(0, 1);
            str = str.substring(1);
            if (!z && (substring.equals(":") || substring.equals(StringUtil.ARRAY_START) || substring.equals("}") || substring.equals(PreferencesUtil.LEFT_MOUNT) || substring.equals(PreferencesUtil.RIGHT_MOUNT) || substring.equals(","))) {
                if (sb.toString().trim().length() == 0) {
                    sb.append(substring);
                }
            } else if (substring.equals(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                sb.append(substring);
                sb.append(str.substring(0, 1));
                str = str.substring(1);
            } else if (substring.equals("\"")) {
                sb.append(substring);
                if (z) {
                    break;
                }
                z = true;
            } else {
                sb.append(substring);
            }
        }
        return sb.toString();
    }
}
