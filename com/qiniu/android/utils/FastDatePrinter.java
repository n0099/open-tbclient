package com.qiniu.android.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class FastDatePrinter {
    private final Locale mLocale;
    private final String nNd;
    private final TimeZone nNe;
    private transient Rule[] nNf;
    private transient int nNg;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface Rule {
        int dQy();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.nNd = str;
        this.nNe = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dQx = dQx();
        this.nNf = (Rule[]) dQx.toArray(new Rule[dQx.size()]);
        int i = 0;
        int length = this.nNf.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.nNf[length].dQy();
            } else {
                this.nNg = i;
                return;
            }
        }
    }

    protected List<Rule> dQx() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.nNd.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.nNd, iArr);
            int i2 = iArr[0];
            int length2 = c.length();
            if (length2 != 0) {
                switch (c.charAt(0)) {
                    case '\'':
                        String substring = c.substring(1);
                        if (substring.length() == 1) {
                            stringLiteral = new CharacterLiteral(substring.charAt(0));
                            break;
                        } else {
                            stringLiteral = new StringLiteral(substring);
                            break;
                        }
                    case 'D':
                        stringLiteral = dN(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = dN(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = dN(11, length2);
                        break;
                    case 'K':
                        stringLiteral = dN(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.nNr;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.nNt;
                            break;
                        }
                    case 'S':
                        stringLiteral = dN(14, length2);
                        break;
                    case 'W':
                        stringLiteral = dN(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.Ld(length2);
                        break;
                    case 'Y':
                    case 'y':
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.nNs;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = dN(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.nNp;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.nNl;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.nNo;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = dN(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(dN(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(dN(11, length2));
                        break;
                    case 'm':
                        stringLiteral = dN(12, length2);
                        break;
                    case 's':
                        stringLiteral = dN(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(dN(7, length2));
                        break;
                    case 'w':
                        stringLiteral = dN(3, length2);
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal pattern component: " + c);
                }
                arrayList.add(stringLiteral);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    protected String c(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (i + 1 < length && str.charAt(i + 1) == charAt) {
                sb.append(charAt);
                i++;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 == '\'') {
                    if (i + 1 < length && str.charAt(i + 1) == '\'') {
                        i++;
                        sb.append(charAt2);
                    } else {
                        z = !z;
                    }
                } else if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                    i--;
                    break;
                } else {
                    sb.append(charAt2);
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    protected NumberRule dN(int i, int i2) {
        switch (i2) {
            case 1:
                return new UnpaddedNumberField(i);
            case 2:
                return new TwoDigitNumberField(i);
            default:
                return new PaddedNumberField(i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof FastDatePrinter) {
            FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
            return this.nNd.equals(fastDatePrinter.nNd) && this.nNe.equals(fastDatePrinter.nNe) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.nNd.hashCode() + ((this.nNe.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.nNd + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.nNe.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class CharacterLiteral implements Rule {
        private final char nNh;

        CharacterLiteral(char c) {
            this.nNh = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TextField implements Rule {
        private final int nNm;
        private final String[] nNn;

        TextField(int i, String[] strArr) {
            this.nNm = i;
            this.nNn = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            int i = 0;
            int length = this.nNn.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.nNn[i2].length();
                    if (length2 <= i) {
                        length2 = i;
                    }
                    i = length2;
                    length = i2;
                } else {
                    return i;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int nNm;

        UnpaddedNumberField(int i) {
            this.nNm = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField nNt = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int nNm;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.nNm = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int nNm;

        TwoDigitNumberField(int i) {
            this.nNm = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField nNs = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField nNr = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule nNi;

        TwelveHourField(NumberRule numberRule) {
            this.nNi = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.nNi.dQy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule nNi;

        TwentyFourHourField(NumberRule numberRule) {
            this.nNi = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.nNi.dQy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule nNi;

        DayInWeekField(NumberRule numberRule) {
            this.nNi = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.nNi.dQy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule nNo = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule nNp = new TimeZoneNumberRule(false);
        final boolean nNq;

        TimeZoneNumberRule(boolean z) {
            this.nNq = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule nNj = new Iso8601_Rule(3);
        static final Iso8601_Rule nNk = new Iso8601_Rule(5);
        static final Iso8601_Rule nNl = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule Ld(int i) {
            switch (i) {
                case 1:
                    return nNj;
                case 2:
                    return nNk;
                case 3:
                    return nNl;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dQy() {
            return this.length;
        }
    }
}
