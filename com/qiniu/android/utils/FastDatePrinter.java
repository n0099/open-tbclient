package com.qiniu.android.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class FastDatePrinter {
    private final Locale mLocale;
    private final String nqA;
    private final TimeZone nqB;
    private transient Rule[] nqC;
    private transient int nqD;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Rule {
        int dGL();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.nqA = str;
        this.nqB = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dGK = dGK();
        this.nqC = (Rule[]) dGK.toArray(new Rule[dGK.size()]);
        int i = 0;
        int length = this.nqC.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.nqC[length].dGL();
            } else {
                this.nqD = i;
                return;
            }
        }
    }

    protected List<Rule> dGK() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.nqA.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.nqA, iArr);
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
                        stringLiteral = el(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = el(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = el(11, length2);
                        break;
                    case 'K':
                        stringLiteral = el(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.nqO;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.nqQ;
                            break;
                        }
                    case 'S':
                        stringLiteral = el(14, length2);
                        break;
                    case 'W':
                        stringLiteral = el(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.Nv(length2);
                        break;
                    case 'Y':
                    case 'y':
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.nqP;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = el(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.nqM;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.nqI;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.nqL;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = el(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(el(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(el(11, length2));
                        break;
                    case 'm':
                        stringLiteral = el(12, length2);
                        break;
                    case 's':
                        stringLiteral = el(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(el(7, length2));
                        break;
                    case 'w':
                        stringLiteral = el(3, length2);
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

    protected NumberRule el(int i, int i2) {
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
            return this.nqA.equals(fastDatePrinter.nqA) && this.nqB.equals(fastDatePrinter.nqB) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.nqA.hashCode() + ((this.nqB.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.nqA + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.nqB.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        private final char nqE;

        CharacterLiteral(char c) {
            this.nqE = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        private final int nqJ;
        private final String[] nqK;

        TextField(int i, String[] strArr) {
            this.nqJ = i;
            this.nqK = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            int i = 0;
            int length = this.nqK.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.nqK[i2].length();
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
    /* loaded from: classes5.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int nqJ;

        UnpaddedNumberField(int i) {
            this.nqJ = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField nqQ = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int nqJ;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.nqJ = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int nqJ;

        TwoDigitNumberField(int i) {
            this.nqJ = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField nqP = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField nqO = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule nqF;

        TwelveHourField(NumberRule numberRule) {
            this.nqF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.nqF.dGL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule nqF;

        TwentyFourHourField(NumberRule numberRule) {
            this.nqF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.nqF.dGL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule nqF;

        DayInWeekField(NumberRule numberRule) {
            this.nqF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.nqF.dGL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule nqL = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule nqM = new TimeZoneNumberRule(false);
        final boolean nqN;

        TimeZoneNumberRule(boolean z) {
            this.nqN = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule nqG = new Iso8601_Rule(3);
        static final Iso8601_Rule nqH = new Iso8601_Rule(5);
        static final Iso8601_Rule nqI = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule Nv(int i) {
            switch (i) {
                case 1:
                    return nqG;
                case 2:
                    return nqH;
                case 3:
                    return nqI;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGL() {
            return this.length;
        }
    }
}
