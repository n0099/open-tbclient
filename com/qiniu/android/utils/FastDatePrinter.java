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
    private final String noA;
    private final TimeZone noB;
    private transient Rule[] noC;
    private transient int noD;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Rule {
        int dGi();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.noA = str;
        this.noB = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dGh = dGh();
        this.noC = (Rule[]) dGh.toArray(new Rule[dGh.size()]);
        int i = 0;
        int length = this.noC.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.noC[length].dGi();
            } else {
                this.noD = i;
                return;
            }
        }
    }

    protected List<Rule> dGh() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.noA.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.noA, iArr);
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
                        stringLiteral = ek(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = ek(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = ek(11, length2);
                        break;
                    case 'K':
                        stringLiteral = ek(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.noO;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.noQ;
                            break;
                        }
                    case 'S':
                        stringLiteral = ek(14, length2);
                        break;
                    case 'W':
                        stringLiteral = ek(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.Np(length2);
                        break;
                    case 'Y':
                    case 'y':
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.noP;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = ek(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.noM;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.noI;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.noL;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = ek(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(ek(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(ek(11, length2));
                        break;
                    case 'm':
                        stringLiteral = ek(12, length2);
                        break;
                    case 's':
                        stringLiteral = ek(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(ek(7, length2));
                        break;
                    case 'w':
                        stringLiteral = ek(3, length2);
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

    protected NumberRule ek(int i, int i2) {
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
            return this.noA.equals(fastDatePrinter.noA) && this.noB.equals(fastDatePrinter.noB) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.noA.hashCode() + ((this.noB.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.noA + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.noB.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        private final char noE;

        CharacterLiteral(char c) {
            this.noE = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
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
        public int dGi() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        private final int noJ;
        private final String[] noK;

        TextField(int i, String[] strArr) {
            this.noJ = i;
            this.noK = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            int i = 0;
            int length = this.noK.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.noK[i2].length();
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
        private final int noJ;

        UnpaddedNumberField(int i) {
            this.noJ = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField noQ = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int noJ;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.noJ = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int noJ;

        TwoDigitNumberField(int i) {
            this.noJ = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField noP = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField noO = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule noF;

        TwelveHourField(NumberRule numberRule) {
            this.noF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return this.noF.dGi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule noF;

        TwentyFourHourField(NumberRule numberRule) {
            this.noF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return this.noF.dGi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule noF;

        DayInWeekField(NumberRule numberRule) {
            this.noF = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return this.noF.dGi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule noL = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule noM = new TimeZoneNumberRule(false);
        final boolean noN;

        TimeZoneNumberRule(boolean z) {
            this.noN = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule noG = new Iso8601_Rule(3);
        static final Iso8601_Rule noH = new Iso8601_Rule(5);
        static final Iso8601_Rule noI = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule Np(int i) {
            switch (i) {
                case 1:
                    return noG;
                case 2:
                    return noH;
                case 3:
                    return noI;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGi() {
            return this.length;
        }
    }
}
