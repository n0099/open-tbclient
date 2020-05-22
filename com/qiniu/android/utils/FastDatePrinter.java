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
    private final String nhq;
    private final TimeZone nhr;
    private transient Rule[] nhs;
    private transient int nht;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Rule {
        int dId();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.nhq = str;
        this.nhr = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dIc = dIc();
        this.nhs = (Rule[]) dIc.toArray(new Rule[dIc.size()]);
        int i = 0;
        int length = this.nhs.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.nhs[length].dId();
            } else {
                this.nht = i;
                return;
            }
        }
    }

    protected List<Rule> dIc() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.nhq.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.nhq, iArr);
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
                        stringLiteral = dC(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = dC(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = dC(11, length2);
                        break;
                    case 'K':
                        stringLiteral = dC(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.nhE;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.nhG;
                            break;
                        }
                    case 'S':
                        stringLiteral = dC(14, length2);
                        break;
                    case 'W':
                        stringLiteral = dC(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.JA(length2);
                        break;
                    case 'Y':
                    case 'y':
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.nhF;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = dC(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.nhC;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.nhy;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.nhB;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = dC(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(dC(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(dC(11, length2));
                        break;
                    case 'm':
                        stringLiteral = dC(12, length2);
                        break;
                    case 's':
                        stringLiteral = dC(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(dC(7, length2));
                        break;
                    case 'w':
                        stringLiteral = dC(3, length2);
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

    protected NumberRule dC(int i, int i2) {
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
            return this.nhq.equals(fastDatePrinter.nhq) && this.nhr.equals(fastDatePrinter.nhr) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.nhq.hashCode() + ((this.nhr.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.nhq + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.nhr.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        private final char nhu;

        CharacterLiteral(char c) {
            this.nhu = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
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
        public int dId() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        private final String[] nhA;
        private final int nhz;

        TextField(int i, String[] strArr) {
            this.nhz = i;
            this.nhA = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            int i = 0;
            int length = this.nhA.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.nhA[i2].length();
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
        private final int nhz;

        UnpaddedNumberField(int i) {
            this.nhz = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField nhG = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int nhz;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.nhz = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int nhz;

        TwoDigitNumberField(int i) {
            this.nhz = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField nhF = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField nhE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule nhv;

        TwelveHourField(NumberRule numberRule) {
            this.nhv = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return this.nhv.dId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule nhv;

        TwentyFourHourField(NumberRule numberRule) {
            this.nhv = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return this.nhv.dId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule nhv;

        DayInWeekField(NumberRule numberRule) {
            this.nhv = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return this.nhv.dId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule nhB = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule nhC = new TimeZoneNumberRule(false);
        final boolean nhD;

        TimeZoneNumberRule(boolean z) {
            this.nhD = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule nhw = new Iso8601_Rule(3);
        static final Iso8601_Rule nhx = new Iso8601_Rule(5);
        static final Iso8601_Rule nhy = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule JA(int i) {
            switch (i) {
                case 1:
                    return nhw;
                case 2:
                    return nhx;
                case 3:
                    return nhy;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dId() {
            return this.length;
        }
    }
}
