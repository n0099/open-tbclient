package common.network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class InetAddressValidator implements Serializable {
    public static final int BASE_16 = 16;
    public static final int IPV4_MAX_OCTET_VALUE = 255;
    public static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    public static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    public static final int IPV6_MAX_HEX_GROUPS = 8;
    public static final int MAX_UNSIGNED_SHORT = 65535;
    public static final InetAddressValidator VALIDATOR = new InetAddressValidator();
    public static final long serialVersionUID = -919201640201914789L;
    public final RegexValidator ipv4Validator = new RegexValidator(IPV4_REGEX);

    public static InetAddressValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isValid(String str) {
        return isValidInet4Address(str) || isValidInet6Address(str);
    }

    public boolean isValidInet4Address(String str) {
        String[] match = this.ipv4Validator.match(str);
        if (match == null) {
            return false;
        }
        for (String str2 : match) {
            if (str2 != null && str2.length() != 0) {
                try {
                    if (Integer.parseInt(str2) > 255) {
                        return false;
                    }
                    if (str2.length() > 1 && str2.startsWith("0")) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean isValidInet6Address(String str) {
        boolean contains = str.contains("::");
        if (!contains || str.indexOf("::") == str.lastIndexOf("::")) {
            if ((!str.startsWith(":") || str.startsWith("::")) && (!str.endsWith(":") || str.endsWith("::"))) {
                String[] split = str.split(":");
                if (contains) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(split));
                    if (str.endsWith("::")) {
                        arrayList.add("");
                    } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                        arrayList.remove(0);
                    }
                    split = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                if (split.length > 8) {
                    return false;
                }
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < split.length; i4++) {
                    String str2 = split[i4];
                    if (str2.length() == 0) {
                        if (i3 + 1 > 1) {
                            return false;
                        }
                    } else if (i4 == split.length - 1 && str2.contains(".")) {
                        if (!isValidInet4Address(str2)) {
                            return false;
                        }
                        i2 += 2;
                        i3 = 0;
                    } else if (str2.length() > 4) {
                        return false;
                    } else {
                        try {
                            int parseInt = Integer.parseInt(str2, 16);
                            i3 = (parseInt >= 0 && parseInt <= 65535) ? 0 : 0;
                        } catch (NumberFormatException unused) {
                        }
                        return false;
                    }
                    i2++;
                }
                return i2 <= 8 && (i2 >= 8 || contains);
            }
            return false;
        }
        return false;
    }
}
