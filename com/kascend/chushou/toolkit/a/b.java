package com.kascend.chushou.toolkit.a;

import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.swan.games.utils.so.SoUtils;
import com.tencent.connect.common.Constants;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class b {
    public static String a(String str) {
        if (h.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = '\t';
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 0;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c = 5;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 11;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c = '\f';
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c = 4;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c = 14;
                    break;
                }
                break;
            case 1570:
                if (str.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                    c = 1;
                    break;
                }
                break;
            case 1573:
                if (str.equals(Constants.VIA_REPORT_TYPE_START_WAP)) {
                    c = '\r';
                    break;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    c = 15;
                    break;
                }
                break;
            case 1599:
                if (str.equals(Constants.VIA_REPORT_TYPE_QQFAVORITES)) {
                    c = 3;
                    break;
                }
                break;
            case 1600:
                if (str.equals(Constants.VIA_REPORT_TYPE_DATALINE)) {
                    c = 16;
                    break;
                }
                break;
            case 1602:
                if (str.equals(SoUtils.SO_EVENT_ID_DEFAULT)) {
                    c = 17;
                    break;
                }
                break;
            case 1603:
                if (str.equals(SoUtils.SO_EVENT_ID_NEW_SO)) {
                    c = 6;
                    break;
                }
                break;
            case 1604:
                if (str.equals("26")) {
                    c = 7;
                    break;
                }
                break;
            case 1605:
                if (str.equals("27")) {
                    c = 18;
                    break;
                }
                break;
            case 1606:
                if (str.equals(Constants.VIA_ACT_TYPE_TWENTY_EIGHT)) {
                    c = '\b';
                    break;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    c = 19;
                    break;
                }
                break;
            case 1629:
                if (str.equals("30")) {
                    c = 20;
                    break;
                }
                break;
            case 2127025805:
                if (str.equals("HEADER")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
                return "3";
            case '\n':
                return "50";
            case 11:
                return "51";
            case '\f':
                return "52";
            case '\r':
                return "53";
            case 14:
                return "58";
            case 15:
                return BaseUtils.METHOD_SENDMESSAGE;
            case 16:
                return "59";
            case 17:
                return "60";
            case 18:
                return "61";
            case 19:
                return "62";
            case 20:
                return "63";
            default:
                return null;
        }
    }
}
