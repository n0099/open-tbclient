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
    private final String nEt;
    private final TimeZone nEu;
    private transient Rule[] nEv;
    private transient int nEw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Rule {
        int dNb();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.nEt = str;
        this.nEu = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> dNa = dNa();
        this.nEv = (Rule[]) dNa.toArray(new Rule[dNa.size()]);
        int i = 0;
        int length = this.nEv.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.nEv[length].dNb();
            } else {
                this.nEw = i;
                return;
            }
        }
    }

    protected List<Rule> dNa() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.nEt.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.nEt, iArr);
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
                        stringLiteral = dL(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = dL(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = dL(11, length2);
                        break;
                    case 'K':
                        stringLiteral = dL(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.nEH;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.nEJ;
                            break;
                        }
                    case 'S':
                        stringLiteral = dL(14, length2);
                        break;
                    case 'W':
                        stringLiteral = dL(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.KJ(length2);
                        break;
                    case 'Y':
                    case 'y':
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.nEI;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = dL(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.nEF;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.nEB;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.nEE;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = dL(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(dL(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(dL(11, length2));
                        break;
                    case 'm':
                        stringLiteral = dL(12, length2);
                        break;
                    case 's':
                        stringLiteral = dL(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(dL(7, length2));
                        break;
                    case 'w':
                        stringLiteral = dL(3, length2);
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

    protected NumberRule dL(int i, int i2) {
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
            return this.nEt.equals(fastDatePrinter.nEt) && this.nEu.equals(fastDatePrinter.nEu) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.nEt.hashCode() + ((this.nEu.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.nEt + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + Constants.ACCEPT_TIME_SEPARATOR_SP + this.nEu.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        private final char nEx;

        CharacterLiteral(char c) {
            this.nEx = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
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
        public int dNb() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        private final int nEC;
        private final String[] nED;

        TextField(int i, String[] strArr) {
            this.nEC = i;
            this.nED = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            int i = 0;
            int length = this.nED.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.nED[i2].length();
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
        private final int nEC;

        UnpaddedNumberField(int i) {
            this.nEC = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField nEJ = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int nEC;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.nEC = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int nEC;

        TwoDigitNumberField(int i) {
            this.nEC = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField nEI = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField nEH = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule nEy;

        TwelveHourField(NumberRule numberRule) {
            this.nEy = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return this.nEy.dNb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule nEy;

        TwentyFourHourField(NumberRule numberRule) {
            this.nEy = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return this.nEy.dNb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule nEy;

        DayInWeekField(NumberRule numberRule) {
            this.nEy = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return this.nEy.dNb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule nEE = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule nEF = new TimeZoneNumberRule(false);
        final boolean nEG;

        TimeZoneNumberRule(boolean z) {
            this.nEG = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule nEz = new Iso8601_Rule(3);
        static final Iso8601_Rule nEA = new Iso8601_Rule(5);
        static final Iso8601_Rule nEB = new Iso8601_Rule(6);

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule KJ(int i) {
            switch (i) {
                case 1:
                    return nEz;
                case 2:
                    return nEA;
                case 3:
                    return nEB;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int dNb() {
            return this.length;
        }
    }
}
