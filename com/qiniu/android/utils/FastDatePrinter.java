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
    private final String ogX;
    private final TimeZone ogY;
    private transient Rule[] ogZ;
    private transient int oha;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface NumberRule extends Rule {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface Rule {
        int ecA();
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.ogX = str;
        this.ogY = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> ecz = ecz();
        this.ogZ = (Rule[]) ecz.toArray(new Rule[ecz.size()]);
        int i = 0;
        int length = this.ogZ.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.ogZ[length].ecA();
            } else {
                this.oha = i;
                return;
            }
        }
    }

    protected List<Rule> ecz() {
        Rule stringLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.ogX.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String c = c(this.ogX, iArr);
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
                        stringLiteral = dV(6, length2);
                        break;
                    case 'E':
                        stringLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                        break;
                    case 'F':
                        stringLiteral = dV(8, length2);
                        break;
                    case 'G':
                        stringLiteral = new TextField(0, eras);
                        break;
                    case 'H':
                        stringLiteral = dV(11, length2);
                        break;
                    case 'K':
                        stringLiteral = dV(10, length2);
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            stringLiteral = new TextField(2, months);
                            break;
                        } else if (length2 == 3) {
                            stringLiteral = new TextField(2, shortMonths);
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = TwoDigitMonthField.ohl;
                            break;
                        } else {
                            stringLiteral = UnpaddedMonthField.ohn;
                            break;
                        }
                    case 'S':
                        stringLiteral = dV(14, length2);
                        break;
                    case 'W':
                        stringLiteral = dV(4, length2);
                        break;
                    case 'X':
                        stringLiteral = Iso8601_Rule.NG(length2);
                        break;
                    case 'Y':
                    case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                        if (length2 == 2) {
                            stringLiteral = TwoDigitYearField.ohm;
                            break;
                        } else {
                            if (length2 < 4) {
                                length2 = 4;
                            }
                            stringLiteral = dV(1, length2);
                            break;
                        }
                    case 'Z':
                        if (length2 == 1) {
                            stringLiteral = TimeZoneNumberRule.ohj;
                            break;
                        } else if (length2 == 2) {
                            stringLiteral = Iso8601_Rule.ohf;
                            break;
                        } else {
                            stringLiteral = TimeZoneNumberRule.ohi;
                            break;
                        }
                    case 'a':
                        stringLiteral = new TextField(9, amPmStrings);
                        break;
                    case 'd':
                        stringLiteral = dV(5, length2);
                        break;
                    case 'h':
                        stringLiteral = new TwelveHourField(dV(10, length2));
                        break;
                    case 'k':
                        stringLiteral = new TwentyFourHourField(dV(11, length2));
                        break;
                    case 'm':
                        stringLiteral = dV(12, length2);
                        break;
                    case 's':
                        stringLiteral = dV(13, length2);
                        break;
                    case 'u':
                        stringLiteral = new DayInWeekField(dV(7, length2));
                        break;
                    case 'w':
                        stringLiteral = dV(3, length2);
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

    protected NumberRule dV(int i, int i2) {
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
            return this.ogX.equals(fastDatePrinter.ogX) && this.ogY.equals(fastDatePrinter.ogY) && this.mLocale.equals(fastDatePrinter.mLocale);
        }
        return false;
    }

    public int hashCode() {
        return this.ogX.hashCode() + ((this.ogY.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.ogX + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.mLocale + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + this.ogY.getID() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class CharacterLiteral implements Rule {
        private final char ohb;

        CharacterLiteral(char c) {
            this.ohb = c;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
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
        public int ecA() {
            return this.mValue.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TextField implements Rule {
        private final int ohg;
        private final String[] ohh;

        TextField(int i, String[] strArr) {
            this.ohg = i;
            this.ohh = strArr;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            int i = 0;
            int length = this.ohh.length;
            while (true) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    int length2 = this.ohh[i2].length();
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
        private final int ohg;

        UnpaddedNumberField(int i) {
            this.ohg = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField ohn = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mSize;
        private final int ohg;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.ohg = i;
            this.mSize = i2;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return this.mSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int ohg;

        TwoDigitNumberField(int i) {
            this.ohg = i;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField ohm = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField ohl = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule ohc;

        TwelveHourField(NumberRule numberRule) {
            this.ohc = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return this.ohc.ecA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule ohc;

        TwentyFourHourField(NumberRule numberRule) {
            this.ohc = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return this.ohc.ecA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule ohc;

        DayInWeekField(NumberRule numberRule) {
            this.ohc = numberRule;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return this.ohc.ecA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule ohi = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule ohj = new TimeZoneNumberRule(false);
        final boolean ohk;

        TimeZoneNumberRule(boolean z) {
            this.ohk = z;
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Iso8601_Rule implements Rule {
        static final Iso8601_Rule ohd = new Iso8601_Rule(3);
        static final Iso8601_Rule ohe = new Iso8601_Rule(5);
        static final Iso8601_Rule ohf = new Iso8601_Rule(6);
        final int length;

        Iso8601_Rule(int i) {
            this.length = i;
        }

        static Iso8601_Rule NG(int i) {
            switch (i) {
                case 1:
                    return ohd;
                case 2:
                    return ohe;
                case 3:
                    return ohf;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }

        @Override // com.qiniu.android.utils.FastDatePrinter.Rule
        public int ecA() {
            return this.length;
        }
    }
}
