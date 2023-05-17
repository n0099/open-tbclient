package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
/* loaded from: classes10.dex */
public class DoubleMetaphone implements StringEncoder {
    public static final String VOWELS = "AEIOUY";
    public int maxCodeLen = 4;
    public static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    public static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, " "};
    public static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    public static final String[] L_T_K_S_N_M_B_Z = {"L", ExifInterface.GPS_DIRECTION_TRUE, "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};

    /* loaded from: classes10.dex */
    public class DoubleMetaphoneResult {
        public final StringBuffer alternate;
        public final int maxLength;
        public final StringBuffer primary;

        public DoubleMetaphoneResult(int i) {
            this.primary = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i;
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            if (this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength) {
                return true;
            }
            return false;
        }
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    private boolean isSilentStart(String str) {
        for (String str2 : SILENT_START) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        if (str.indexOf(87) <= -1 && str.indexOf(75) <= -1 && str.indexOf("CZ") <= -1 && str.indexOf("WITZ") <= -1) {
            return false;
        }
        return true;
    }

    private boolean isVowel(char c) {
        if (VOWELS.indexOf(c) != -1) {
            return true;
        }
        return false;
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    private boolean conditionC0(String str, int i) {
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        if ((charAt != 'I' && charAt != 'E') || contains(str, i2, 6, "BACHER", "MACHER")) {
            return true;
        }
        return false;
    }

    private boolean conditionL0(String str, int i) {
        if (i == str.length() - 3 && contains(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        if ((contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && contains(str, i - 1, 4, "ALLE")) {
            return true;
        }
        return false;
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        if ((!contains(str, i2, 5, "HARAC", "HARIS") && !contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) || contains(str, 0, 5, "CHORE")) {
            return false;
        }
        return true;
    }

    private boolean conditionM0(String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        if (contains(str, i - 1, 3, "UMB") && (i2 == str.length() - 1 || contains(str, i + 2, 2, "ER"))) {
            return true;
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    public char charAt(String str, int i) {
        if (i >= 0 && i < str.length()) {
            return str.charAt(i);
        }
        return (char) 0;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = i + 2;
            if (!contains(str, i2, 1, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH)) {
                if (!contains(str, i - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) && i != 0) {
                    return false;
                }
                if (!contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) && i + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean contains(String str, int i, int i2, String str2) {
        return contains(str, i, i2, new String[]{str2});
    }

    public static boolean contains(String str, int i, int i2, String str2, String str3) {
        return contains(str, i, i2, new String[]{str2, str3});
    }

    public static boolean contains(String str, int i, int i2, String str2, String str3, String str4) {
        return contains(str, i, i2, new String[]{str2, str3, str4});
    }

    public static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5});
    }

    public static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5, str6});
    }

    public static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5, str6, str7});
    }

    public static boolean contains(String str, int i, int i2, String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (conditionC0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (i == 0 && contains(str, i, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
        } else if (contains(str, i, 2, "CH")) {
            return handleCH(str, doubleMetaphoneResult, i);
        } else {
            if (contains(str, i, 2, "CZ") && !contains(str, i - 2, 4, "WICZ")) {
                doubleMetaphoneResult.append('S', 'X');
            } else {
                int i2 = i + 1;
                if (contains(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X');
                } else if (contains(str, i, 2, "CC") && (i != 1 || charAt(str, 0) != 'M')) {
                    return handleCC(str, doubleMetaphoneResult, i);
                } else {
                    if (contains(str, i, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K');
                    } else if (contains(str, i, 2, "CI", "CE", "CY")) {
                        if (contains(str, i, 3, "CIO", "CIE", "CIA")) {
                            doubleMetaphoneResult.append('S', 'X');
                        } else {
                            doubleMetaphoneResult.append('S');
                        }
                    } else {
                        doubleMetaphoneResult.append('K');
                        if (!contains(str, i2, 2, " C", " Q", " G")) {
                            if (!contains(str, i2, 1, "C", "K", "Q") || contains(str, i2, 2, "CE", "CI")) {
                                return i2;
                            }
                        }
                    }
                }
                return i + 3;
            }
        }
        return i + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, IEruptionStrategyGroup.STRATEGY_MODIFIER_H) && !contains(str, i2, 2, "HU")) {
            if ((i == 1 && charAt(str, i - 1) == 'A') || contains(str, i - 1, 5, "UCCEE", "UCCES")) {
                doubleMetaphoneResult.append(GlobalSetting.KS_SDK_WRAPPER);
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i + 3;
        }
        doubleMetaphoneResult.append('K');
        return i2;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && contains(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else if (conditionCH0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (conditionCH1(str, i)) {
            doubleMetaphoneResult.append('K');
        } else {
            if (i > 0) {
                if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i + 2;
        }
        return i + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
                doubleMetaphoneResult.append('J');
                return i + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        } else if (contains(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return 2 + i;
        } else {
            doubleMetaphoneResult.append('T');
            return i + 1;
        }
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!contains(str, i - 3, 3, "IAU", "EAU") && !contains(str, i - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append(GlobalSetting.KS_SDK_WRAPPER);
        }
        int i2 = i + 1;
        if (contains(str, i2, 1, "C", "X")) {
            return i + 2;
        }
        return i2;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2;
        int i3 = i + 1;
        if (charAt(str, i3) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i);
        }
        if (charAt(str, i3) == 'N') {
            if (i == 1 && isVowel(charAt(str, 0)) && !z) {
                doubleMetaphoneResult.append("KN", "N");
            } else if (!contains(str, i + 2, 2, "EY") && charAt(str, i3) != 'Y' && !z) {
                doubleMetaphoneResult.append("N", "KN");
            } else {
                doubleMetaphoneResult.append("KN");
            }
        } else if (contains(str, i3, 2, "LI") && !z) {
            doubleMetaphoneResult.append("KL", "L");
        } else if (i == 0 && (charAt(str, i3) == 'Y' || contains(str, i3, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K', 'J');
        } else {
            if (!contains(str, i3, 2, "ER") && charAt(str, i3) != 'Y') {
                i2 = 3;
            } else {
                i2 = 3;
                if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i4 = i - 1;
                    if (!contains(str, i4, 1, ExifInterface.LONGITUDE_EAST, "I") && !contains(str, i4, 3, "RGY", "OGY")) {
                        doubleMetaphoneResult.append('K', 'J');
                    }
                }
            }
            if (!contains(str, i3, 1, ExifInterface.LONGITUDE_EAST, "I", "Y") && !contains(str, i - 1, 4, "AGGI", "OGGI")) {
                if (charAt(str, i3) == 'G') {
                    int i5 = i + 2;
                    doubleMetaphoneResult.append('K');
                    return i5;
                }
                doubleMetaphoneResult.append('K');
                return i3;
            } else if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, i2, "SCH") && !contains(str, i3, 2, "ET")) {
                if (contains(str, i3, i2, "IER")) {
                    doubleMetaphoneResult.append('J');
                } else {
                    doubleMetaphoneResult.append('J', 'K');
                }
            } else {
                doubleMetaphoneResult.append('K');
            }
        }
        return i + 2;
    }

    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (!contains(str, i - 1, 3, "ISL", "YSL")) {
            if (i == 0 && contains(str, i, 5, "SUGAR")) {
                doubleMetaphoneResult.append('X', 'S');
            } else {
                if (contains(str, i, 2, "SH")) {
                    if (contains(str, i + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('X');
                    }
                } else if (!contains(str, i, 3, "SIO", "SIA") && !contains(str, i, 4, "SIAN")) {
                    if (i != 0 || !contains(str, i + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
                        int i2 = i + 1;
                        if (!contains(str, i2, 1, "Z")) {
                            if (contains(str, i, 2, "SC")) {
                                return handleSC(str, doubleMetaphoneResult, i);
                            }
                            if (i == str.length() - 1 && contains(str, i - 2, 2, "AI", "OI")) {
                                doubleMetaphoneResult.appendAlternate('S');
                            } else {
                                doubleMetaphoneResult.append('S');
                            }
                            if (!contains(str, i2, 1, ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i2;
                            }
                        }
                    }
                    doubleMetaphoneResult.append('S', 'X');
                    int i3 = i + 1;
                    if (!contains(str, i3, 1, "Z")) {
                        return i3;
                    }
                } else {
                    if (z) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('S', 'X');
                    }
                    return i + 3;
                }
                return i + 2;
            }
        }
        return i + 1;
    }

    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && !isVowel(charAt(str, i - 1))) {
            doubleMetaphoneResult.append('K');
        } else if (i == 0) {
            int i2 = i + 2;
            if (charAt(str, i2) == 'I') {
                doubleMetaphoneResult.append('J');
                return i2;
            }
            doubleMetaphoneResult.append('K');
            return i2;
        } else if ((i <= 1 || !contains(str, i - 2, 1, "B", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, "D")) && ((i <= 2 || !contains(str, i - 3, 1, "B", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, "D")) && (i <= 3 || !contains(str, i - 4, 1, "B", IEruptionStrategyGroup.STRATEGY_MODIFIER_H)))) {
            if (i > 2 && charAt(str, i - 1) == 'U' && contains(str, i - 3, 1, "C", "G", "L", "R", ExifInterface.GPS_DIRECTION_TRUE)) {
                doubleMetaphoneResult.append('F');
            } else if (i > 0 && charAt(str, i - 1) != 'I') {
                doubleMetaphoneResult.append('K');
            }
        }
        return i + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i == 0 || isVowel(charAt(str, i - 1))) && isVowel(charAt(str, i + 1))) {
            doubleMetaphoneResult.append('H');
            return i + 2;
        }
        return i + 1;
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, i)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return i + 2;
        }
        doubleMetaphoneResult.append('L');
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    private int handleJ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (!contains(str, i, 4, "JOSE") && !contains(str, 0, 4, "SAN ")) {
            if (i == 0 && !contains(str, i, 4, "JOSE")) {
                doubleMetaphoneResult.append('J', 'A');
            } else {
                int i2 = i - 1;
                if (isVowel(charAt(str, i2)) && !z) {
                    int i3 = i + 1;
                    if (charAt(str, i3) == 'A' || charAt(str, i3) == 'O') {
                        doubleMetaphoneResult.append('J', 'H');
                    }
                }
                if (i == str.length() - 1) {
                    doubleMetaphoneResult.append('J', WebvttCueParser.CHAR_SPACE);
                } else if (!contains(str, i + 1, 1, L_T_K_S_N_M_B_Z) && !contains(str, i2, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                    doubleMetaphoneResult.append('J');
                }
            }
            int i4 = i + 1;
            if (charAt(str, i4) == 'J') {
                return i + 2;
            }
            return i4;
        }
        if ((i != 0 || charAt(str, i + 4) != ' ') && str.length() != 4 && !contains(str, 0, 4, "SAN ")) {
            doubleMetaphoneResult.append('J', 'H');
        } else {
            doubleMetaphoneResult.append('H');
        }
        return i + 1;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i == str.length() - 1 && !z && contains(str, i - 2, 2, "IE") && !contains(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.appendAlternate('R');
        } else {
            doubleMetaphoneResult.append('R');
        }
        int i2 = i + 1;
        if (charAt(str, i2) == 'R') {
            return i + 2;
        }
        return i2;
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (charAt(str, i2) == 'H') {
            int i3 = i + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i == 0 && !isVowel(charAt(str, 3)) && charAt(str, 3) != 'W') {
                doubleMetaphoneResult.append('X', 'S');
            } else {
                doubleMetaphoneResult.append('X');
            }
        } else if (contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return i + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
        } else if (contains(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
        } else if (!contains(str, i, 2, "TH") && !contains(str, i, 3, "TTH")) {
            doubleMetaphoneResult.append('T');
            int i2 = i + 1;
            if (contains(str, i2, 1, ExifInterface.GPS_DIRECTION_TRUE, "D")) {
                return i + 2;
            }
            return i2;
        } else {
            int i3 = i + 2;
            if (!contains(str, i3, 2, "OM", "AM") && !contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append(TransactionIdCreater.FILL_BYTE, 'T');
                return i3;
            }
            doubleMetaphoneResult.append('T');
            return i3;
        }
        return i + 3;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = 2;
        if (contains(str, i, 2, "WR")) {
            doubleMetaphoneResult.append('R');
        } else {
            if (i == 0) {
                int i3 = i + 1;
                if (isVowel(charAt(str, i3)) || contains(str, i, 2, "WH")) {
                    if (isVowel(charAt(str, i3))) {
                        doubleMetaphoneResult.append('A', 'F');
                    } else {
                        doubleMetaphoneResult.append('A');
                    }
                    return i3;
                }
            }
            if ((i != str.length() - 1 || !isVowel(charAt(str, i - 1))) && !contains(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !contains(str, 0, 3, "SCH")) {
                i2 = 4;
                if (contains(str, i, 4, "WICZ", "WITZ")) {
                    doubleMetaphoneResult.append("TS", "FX");
                }
            } else {
                doubleMetaphoneResult.appendAlternate('F');
            }
            return i + 1;
        }
        return i + i2;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (!contains(str, i2, 2, "ZO", "ZI", "ZA") && (!z || i <= 0 || charAt(str, i - 1) == 'T')) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append(ExifInterface.LATITUDE_SOUTH, "TS");
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0019 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public String doubleMetaphone(String str, boolean z) {
        int i;
        ?? cleanInput = cleanInput(str);
        if (cleanInput == 0) {
            return null;
        }
        boolean isSlavoGermanic = isSlavoGermanic(cleanInput);
        ?? isSilentStart = isSilentStart(cleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && isSilentStart <= cleanInput.length() - 1) {
            char charAt = cleanInput.charAt(isSilentStart);
            if (charAt != 199) {
                if (charAt != 209) {
                    switch (charAt) {
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                        case 'Y':
                            isSilentStart = handleAEIOUY(doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'B':
                            doubleMetaphoneResult.append('P');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'B') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'C':
                            isSilentStart = handleC(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'D':
                            isSilentStart = handleD(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'F':
                            doubleMetaphoneResult.append('F');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'F') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'G':
                            isSilentStart = handleG(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                            break;
                        case 'H':
                            isSilentStart = handleH(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'J':
                            isSilentStart = handleJ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                            break;
                        case 'K':
                            doubleMetaphoneResult.append('K');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'K') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'L':
                            isSilentStart = handleL(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'M':
                            doubleMetaphoneResult.append('M');
                            if (!conditionM0(cleanInput, isSilentStart)) {
                                break;
                            } else {
                                isSilentStart += 2;
                                break;
                            }
                        case 'N':
                            doubleMetaphoneResult.append('N');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'N') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'P':
                            isSilentStart = handleP(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'Q':
                            doubleMetaphoneResult.append('K');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'Q') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'R':
                            isSilentStart = handleR(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                            break;
                        case 'S':
                            isSilentStart = handleS(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                            break;
                        case 'T':
                            isSilentStart = handleT(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'V':
                            doubleMetaphoneResult.append('F');
                            i = isSilentStart + 1;
                            if (charAt(cleanInput, i) == 'V') {
                                isSilentStart += 2;
                                break;
                            } else {
                                isSilentStart = i;
                                break;
                            }
                        case 'W':
                            isSilentStart = handleW(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'X':
                            isSilentStart = handleX(cleanInput, doubleMetaphoneResult, isSilentStart);
                            break;
                        case 'Z':
                            isSilentStart = handleZ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                            break;
                    }
                } else {
                    doubleMetaphoneResult.append('N');
                }
            } else {
                doubleMetaphoneResult.append('S');
            }
            isSilentStart++;
        }
        if (z) {
            return doubleMetaphoneResult.getAlternate();
        }
        return doubleMetaphoneResult.getPrimary();
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return doubleMetaphone(str);
    }
}
