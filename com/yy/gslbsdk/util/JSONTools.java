package com.yy.gslbsdk.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class JSONTools {
    public static void doFill(StringBuilder sb, int i, String str) {
        sb.append("\n");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
    }

    public static String formatJson(String str, String str2) {
        int i;
        if (str != null && str.trim().length() != 0) {
            ArrayList arrayList = new ArrayList();
            while (str.length() > 0) {
                String token = getToken(str);
                str = str.substring(token.length());
                arrayList.add(token.trim());
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                int length = ((String) arrayList.get(i4)).getBytes().length;
                if (length > i3 && i4 < arrayList.size() - 1 && ((String) arrayList.get(i4 + 1)).equals(":")) {
                    i3 = length;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            while (i2 < arrayList.size()) {
                String str3 = (String) arrayList.get(i2);
                if (str3.equals(",")) {
                    sb.append(str3);
                    doFill(sb, i5, str2);
                } else if (str3.equals(":")) {
                    sb.append("");
                    sb.append(str3);
                    sb.append(" ");
                } else if (str3.equals("{")) {
                    i = i2 + 1;
                    if (((String) arrayList.get(i)).equals("}")) {
                        sb.append("{ }");
                        i2 = i;
                    } else {
                        i5++;
                        sb.append(str3);
                        doFill(sb, i5, str2);
                    }
                } else if (str3.equals("}")) {
                    i5--;
                    doFill(sb, i5, str2);
                    sb.append(str3);
                } else if (str3.equals(PreferencesUtil.LEFT_MOUNT)) {
                    i = i2 + 1;
                    if (((String) arrayList.get(i)).equals(PreferencesUtil.RIGHT_MOUNT)) {
                        sb.append("[ ]");
                        i2 = i;
                    } else {
                        i5++;
                        sb.append(str3);
                        doFill(sb, i5, str2);
                    }
                } else if (str3.equals(PreferencesUtil.RIGHT_MOUNT)) {
                    i5--;
                    doFill(sb, i5, str2);
                    sb.append(str3);
                } else {
                    sb.append(str3);
                }
                i2++;
            }
            return sb.toString();
        }
        return null;
    }

    public static String getToken(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (str.length() > 0) {
            String substring = str.substring(0, 1);
            str = str.substring(1);
            if (!z && (substring.equals(":") || substring.equals("{") || substring.equals("}") || substring.equals(PreferencesUtil.LEFT_MOUNT) || substring.equals(PreferencesUtil.RIGHT_MOUNT) || substring.equals(","))) {
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
