package tv.chushou.zues.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import tv.chushou.zues.b;
/* loaded from: classes5.dex */
public class b {
    public static String n(long j, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (!z) {
            int i = (int) (j / 1000);
            int i2 = i % 60;
            int i3 = i / 60;
            sb.append(i3 < 10 ? "0" + i3 : Integer.valueOf(i3));
            sb.append(":");
            sb.append(i2 < 10 ? "0" + i2 : Integer.valueOf(i2));
            return sb.toString();
        }
        if (j > 0) {
            str = "+";
        } else if (j < 0) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            j = 0 - j;
        } else {
            str = "";
        }
        int i4 = (int) (j / 1000);
        int i5 = i4 % 60;
        int i6 = i4 / 60;
        sb.append("[");
        sb.append(str);
        sb.append(i6 < 10 ? "0" + i6 : Integer.valueOf(i6));
        sb.append(":");
        sb.append(i5 < 10 ? "0" + i5 : Integer.valueOf(i5));
        sb.append("]");
        return sb.toString();
    }

    public static String formatNumber(String str) {
        return bR(str, 1);
    }

    public static String bR(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            long parseLong = Long.parseLong(str);
            Resources dJU = h.dJU();
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            switch (i) {
                case 1:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) >= 10000.0f) {
                            return decimalFormat.format(((float) parseLong) / 10000.0f) + dJU.getString(b.g.zues_str_wan);
                        }
                        return str;
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                case 2:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) >= 1000000.0f) {
                            return decimalFormat.format(((float) parseLong) / 1000000.0f) + dJU.getString(b.g.zues_str_bai_wan);
                        }
                        return str;
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                case 3:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) < 1000000.0f) {
                            if (((float) parseLong) < 10000.0f) {
                                if (((float) parseLong) >= 1000.0f) {
                                    return decimalFormat.format(((float) parseLong) / 1000.0f) + dJU.getString(b.g.zues_str_qian);
                                }
                                return str;
                            }
                            return decimalFormat.format(((float) parseLong) / 10000.0f) + dJU.getString(b.g.zues_str_wan);
                        }
                        return decimalFormat.format(((float) parseLong) / 1000000.0f) + dJU.getString(b.g.zues_str_bai_wan);
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                default:
                    return str;
            }
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static String bS(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            long parseLong = Long.parseLong(str);
            Resources dJU = h.dJU();
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            switch (i) {
                case 1:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) >= 10000.0f) {
                            return decimalFormat.format(((float) parseLong) / 10000.0f) + dJU.getString(b.g.zues_str_wan);
                        }
                        return str;
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                case 2:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) >= 1000000.0f) {
                            return decimalFormat.format(((float) parseLong) / 1000000.0f) + dJU.getString(b.g.zues_str_bai_wan);
                        }
                        return str;
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                case 3:
                    if (((float) parseLong) < 1.0E8f) {
                        if (((float) parseLong) < 1000000.0f) {
                            if (((float) parseLong) >= 10000.0f) {
                                return decimalFormat.format(((float) parseLong) / 10000.0f) + dJU.getString(b.g.zues_str_wan);
                            }
                            return str;
                        }
                        return decimalFormat.format(((float) parseLong) / 1000000.0f) + dJU.getString(b.g.zues_str_bai_wan);
                    }
                    return decimalFormat.format(((float) parseLong) / 1.0E8f) + dJU.getString(b.g.zues_str_yi);
                default:
                    return str;
            }
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static String JN(int i) {
        return i > 99 ? "99+" : String.valueOf(i);
    }
}
