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
    private final String noC;
    private final TimeZone noD;
    private transient Rule[] noE;
    private transient int noF;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Rule {
        int dGk();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.noC = str;
        this.noD = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dGj = dGj();
        this.noE = (Rule[]) dGj.toArray(new Rule[dGj.size()]);
        int i = 0;
        int length = this.noE.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.noE[length].dGk();
            } else {
                this.noF = i;
                return;
            }
        }
    }

    protected List<Rule> dGj() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.noC.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.noC, iArr);
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
                            stringLiteral = TwoDigitMonthField.noQ;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.noS;
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
                            stringLiteral = TwoDigitYearField.noR;
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
                            stringLiteral = TimeZoneNumberRule.noO;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.noK;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.noN;
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
            return this.noC.equals(fastDatePrinter.noC) && this.noD.equals(fastDatePrinter.noD) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.noC.hashCode() + ((this.noD.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.noC + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.noD.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        private final char noG;

        CharacterLiteral(char c) {
            this.noG = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
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
        public int dGk() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        private final int noL;
        private final String[] noM;

        TextField(int i, String[] strArr) {
            this.noL = i;
            this.noM = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            int i = 0;
            int length = this.noM.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.noM[i2].length();
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
        private final int noL;

        UnpaddedNumberField(int i) {
            this.noL = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField noS = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int noL;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.noL = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int noL;

        TwoDigitNumberField(int i) {
            this.noL = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField noR = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField noQ = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule noH;

        TwelveHourField(NumberRule numberRule) {
            this.noH = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return this.noH.dGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule noH;

        TwentyFourHourField(NumberRule numberRule) {
            this.noH = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return this.noH.dGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule noH;

        DayInWeekField(NumberRule numberRule) {
            this.noH = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return this.noH.dGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule noN = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule noO = new TimeZoneNumberRule(false);
        final boolean noP;

        TimeZoneNumberRule(boolean z) {
            this.noP = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule noI = new Iso8601_Rule(3);
        static final Iso8601_Rule noJ = new Iso8601_Rule(5);
        static final Iso8601_Rule noK = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule Np(int i) {
            switch (i) {
                case 1:
                    return noI;
                case 2:
                    return noJ;
                case 3:
                    return noK;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dGk() {
            return this.length;
        }
    }
}
