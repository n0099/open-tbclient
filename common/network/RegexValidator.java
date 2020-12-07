package common.network;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes25.dex */
public class RegexValidator implements Serializable {
    private static final long serialVersionUID = -8832409930574867162L;
    private final Pattern[] patterns;

    public RegexValidator(String str) {
        this(str, true);
    }

    public RegexValidator(String str, boolean z) {
        this(new String[]{str}, z);
    }

    public RegexValidator(String[] strArr) {
        this(strArr, true);
    }

    public RegexValidator(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        this.patterns = new Pattern[strArr.length];
        int i = z ? 0 : 2;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] == null || strArr[i2].length() == 0) {
                throw new IllegalArgumentException("Regular expression[" + i2 + "] is missing");
            }
            this.patterns[i2] = Pattern.compile(strArr[i2], i);
        }
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < this.patterns.length; i++) {
            if (this.patterns[i].matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public String[] match(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < this.patterns.length; i++) {
            Matcher matcher = this.patterns[i].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                String[] strArr = new String[groupCount];
                for (int i2 = 0; i2 < groupCount; i2++) {
                    strArr[i2] = matcher.group(i2 + 1);
                }
                return strArr;
            }
        }
        return null;
    }

    public String validate(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < this.patterns.length; i++) {
            Matcher matcher = this.patterns[i].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                if (groupCount == 1) {
                    return matcher.group(1);
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < groupCount; i2++) {
                    String group = matcher.group(i2 + 1);
                    if (group != null) {
                        sb.append(group);
                    }
                }
                return sb.toString();
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegexValidator{");
        for (int i = 0; i < this.patterns.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(this.patterns[i].pattern());
        }
        sb.append("}");
        return sb.toString();
    }
}
