package common.network;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class RegexValidator implements Serializable {
    public static final long serialVersionUID = -8832409930574867162L;
    public final Pattern[] patterns;

    public RegexValidator(String str) {
        this(str, true);
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i2 >= patternArr.length) {
                return false;
            }
            if (patternArr[i2].matcher(str).matches()) {
                return true;
            }
            i2++;
        }
    }

    public String[] match(String str) {
        if (str == null) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i3 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i3].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                String[] strArr = new String[groupCount];
                while (i2 < groupCount) {
                    int i4 = i2 + 1;
                    strArr[i2] = matcher.group(i4);
                    i2 = i4;
                }
                return strArr;
            }
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegexValidator{");
        for (int i2 = 0; i2 < this.patterns.length; i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(this.patterns[i2].pattern());
        }
        sb.append("}");
        return sb.toString();
    }

    public String validate(String str) {
        if (str == null) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i3 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i3].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                if (groupCount == 1) {
                    return matcher.group(1);
                }
                StringBuilder sb = new StringBuilder();
                while (i2 < groupCount) {
                    i2++;
                    String group = matcher.group(i2);
                    if (group != null) {
                        sb.append(group);
                    }
                }
                return sb.toString();
            }
            i3++;
        }
    }

    public RegexValidator(String str, boolean z) {
        this(new String[]{str}, z);
    }

    public RegexValidator(String[] strArr) {
        this(strArr, true);
    }

    public RegexValidator(String[] strArr, boolean z) {
        if (strArr != null && strArr.length != 0) {
            this.patterns = new Pattern[strArr.length];
            int i2 = z ? 0 : 2;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (strArr[i3] != null && strArr[i3].length() != 0) {
                    this.patterns[i3] = Pattern.compile(strArr[i3], i2);
                } else {
                    throw new IllegalArgumentException("Regular expression[" + i3 + "] is missing");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Regular expressions are missing");
    }
}
