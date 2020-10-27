package com.qiniu.android.utils;

import com.baidu.android.imsdk.internal.Constants;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class FastDatePrinter {
    private final Locale mLocale;
    private final String pxM;
    private final TimeZone pxN;
    private transient Rule[] pxO;
    private transient int pxP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface Rule {
        int eur();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.pxM = str;
        this.pxN = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> euq = euq();
        this.pxO = (Rule[]) euq.toArray(new Rule[euq.size()]);
        int i = 0;
        int length = this.pxO.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.pxO[length].eur();
            } else {
                this.pxP = i;
                return;
            }
        }
    }

    protected List<Rule> euq() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.pxM.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.pxM, iArr);
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
                        stringLiteral = eh(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = eh(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = eh(11, length2);
                        break;
                    case 'K':
                        stringLiteral = eh(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.pya;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.pyc;
                            break;
                        }
                    case 'S':
                        stringLiteral = eh(14, length2);
                        break;
                    case 'W':
                        stringLiteral = eh(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.QI(length2);
                        break;
                    case 'Y':
                    case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.pyb;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = eh(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.pxY;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.pxU;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.pxX;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = eh(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(eh(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(eh(11, length2));
                        break;
                    case 'm':
                        stringLiteral = eh(12, length2);
                        break;
                    case 's':
                        stringLiteral = eh(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(eh(7, length2));
                        break;
                    case 'w':
                        stringLiteral = eh(3, length2);
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

    protected NumberRule eh(int i, int i2) {
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
            return this.pxM.equals(fastDatePrinter.pxM) && this.pxN.equals(fastDatePrinter.pxN) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.pxM.hashCode() + ((this.pxN.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.pxM + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.pxN.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class CharacterLiteral implements Rule {
        private final char pxQ;

        CharacterLiteral(char c) {
            this.pxQ = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
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
        public int eur() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TextField implements Rule {
        private final int pxV;
        private final String[] pxW;

        TextField(int i, String[] strArr) {
            this.pxV = i;
            this.pxW = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            int i = 0;
            int length = this.pxW.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.pxW[i2].length();
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
        private final int pxV;

        UnpaddedNumberField(int i) {
            this.pxV = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField pyc = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int pxV;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.pxV = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int pxV;

        TwoDigitNumberField(int i) {
            this.pxV = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField pyb = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField pya = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule pxR;

        TwelveHourField(NumberRule numberRule) {
            this.pxR = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return this.pxR.eur();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule pxR;

        TwentyFourHourField(NumberRule numberRule) {
            this.pxR = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return this.pxR.eur();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule pxR;

        DayInWeekField(NumberRule numberRule) {
            this.pxR = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return this.pxR.eur();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule pxX = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule pxY = new TimeZoneNumberRule(false);
        final boolean pxZ;

        TimeZoneNumberRule(boolean z) {
            this.pxZ = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule pxS = new Iso8601_Rule(3);
        static final Iso8601_Rule pxT = new Iso8601_Rule(5);
        static final Iso8601_Rule pxU = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule QI(int i) {
            switch (i) {
                case 1:
                    return pxS;
                case 2:
                    return pxT;
                case 3:
                    return pxU;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int eur() {
            return this.length;
        }
    }
}
