package org.apache.commons.codec.language;

import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
/* loaded from: classes9.dex */
public class Metaphone implements StringEncoder {
    public static final String FRONTV = "EIY";
    public static final String VARSON = "CSPTG";
    public static final String VOWELS = "AEIOU";
    public int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    private boolean isNextChar(StringBuffer stringBuffer, int i, char c) {
        if (i < 0 || i >= stringBuffer.length() - 1 || stringBuffer.charAt(i + 1) != c) {
            return false;
        }
        return true;
    }

    private boolean isPreviousChar(StringBuffer stringBuffer, int i, char c) {
        if (i <= 0 || i >= stringBuffer.length() || stringBuffer.charAt(i - 1) != c) {
            return false;
        }
        return true;
    }

    private boolean regionMatch(StringBuffer stringBuffer, int i, String str) {
        if (i >= 0 && (str.length() + i) - 1 < stringBuffer.length()) {
            return stringBuffer.substring(i, str.length() + i).equals(str);
        }
        return false;
    }

    private boolean isVowel(StringBuffer stringBuffer, int i) {
        if (VOWELS.indexOf(stringBuffer.charAt(i)) >= 0) {
            return true;
        }
        return false;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }

    public String metaphone(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() == 1) {
                return str.toUpperCase(Locale.ENGLISH);
            }
            char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
            StringBuffer stringBuffer = new StringBuffer(40);
            StringBuffer stringBuffer2 = new StringBuffer(10);
            int i = 0;
            char c = charArray[0];
            if (c != 'A') {
                if (c != 'G' && c != 'K' && c != 'P') {
                    if (c != 'W') {
                        if (c != 'X') {
                            stringBuffer.append(charArray);
                        } else {
                            charArray[0] = 'S';
                            stringBuffer.append(charArray);
                        }
                    } else if (charArray[1] == 'R') {
                        stringBuffer.append(charArray, 1, charArray.length - 1);
                    } else if (charArray[1] == 'H') {
                        stringBuffer.append(charArray, 1, charArray.length - 1);
                        stringBuffer.setCharAt(0, 'W');
                    } else {
                        stringBuffer.append(charArray);
                    }
                } else if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (charArray[1] == 'E') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
            } else {
                stringBuffer.append(charArray);
            }
            int length = stringBuffer.length();
            while (stringBuffer2.length() < getMaxCodeLen() && i < length) {
                char charAt = stringBuffer.charAt(i);
                if (charAt != 'C' && isPreviousChar(stringBuffer, i, charAt)) {
                    i++;
                } else {
                    switch (charAt) {
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                            if (i == 0) {
                                stringBuffer2.append(charAt);
                                break;
                            }
                            break;
                        case 'B':
                            if (!isPreviousChar(stringBuffer, i, 'M') || !isLastChar(length, i)) {
                                stringBuffer2.append(charAt);
                                break;
                            }
                            break;
                        case 'C':
                            if (!isPreviousChar(stringBuffer, i, 'S') || isLastChar(length, i) || FRONTV.indexOf(stringBuffer.charAt(i + 1)) < 0) {
                                if (regionMatch(stringBuffer, i, "CIA")) {
                                    stringBuffer2.append('X');
                                    break;
                                } else if (!isLastChar(length, i) && FRONTV.indexOf(stringBuffer.charAt(i + 1)) >= 0) {
                                    stringBuffer2.append('S');
                                    break;
                                } else if (isPreviousChar(stringBuffer, i, 'S') && isNextChar(stringBuffer, i, 'H')) {
                                    stringBuffer2.append('K');
                                    break;
                                } else if (isNextChar(stringBuffer, i, 'H')) {
                                    if (i == 0 && length >= 3 && isVowel(stringBuffer, 2)) {
                                        stringBuffer2.append('K');
                                        break;
                                    } else {
                                        stringBuffer2.append('X');
                                        break;
                                    }
                                } else {
                                    stringBuffer2.append('K');
                                    break;
                                }
                            }
                            break;
                        case 'D':
                            if (!isLastChar(length, i + 1) && isNextChar(stringBuffer, i, 'G')) {
                                int i2 = i + 2;
                                if (FRONTV.indexOf(stringBuffer.charAt(i2)) >= 0) {
                                    stringBuffer2.append('J');
                                    i = i2;
                                    break;
                                }
                            }
                            stringBuffer2.append('T');
                            break;
                        case 'F':
                        case 'J':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'R':
                            stringBuffer2.append(charAt);
                            break;
                        case 'G':
                            int i3 = i + 1;
                            if ((!isLastChar(length, i3) || !isNextChar(stringBuffer, i, 'H')) && ((isLastChar(length, i3) || !isNextChar(stringBuffer, i, 'H') || isVowel(stringBuffer, i + 2)) && (i <= 0 || (!regionMatch(stringBuffer, i, "GN") && !regionMatch(stringBuffer, i, "GNED"))))) {
                                boolean isPreviousChar = isPreviousChar(stringBuffer, i, 'G');
                                if (!isLastChar(length, i) && FRONTV.indexOf(stringBuffer.charAt(i3)) >= 0 && !isPreviousChar) {
                                    stringBuffer2.append('J');
                                    break;
                                } else {
                                    stringBuffer2.append('K');
                                    break;
                                }
                            }
                            break;
                        case 'H':
                            if (!isLastChar(length, i) && ((i <= 0 || VARSON.indexOf(stringBuffer.charAt(i - 1)) < 0) && isVowel(stringBuffer, i + 1))) {
                                stringBuffer2.append('H');
                                break;
                            }
                            break;
                        case 'K':
                            if (i > 0) {
                                if (!isPreviousChar(stringBuffer, i, 'C')) {
                                    stringBuffer2.append(charAt);
                                    break;
                                }
                            } else {
                                stringBuffer2.append(charAt);
                                break;
                            }
                            break;
                        case 'P':
                            if (isNextChar(stringBuffer, i, 'H')) {
                                stringBuffer2.append('F');
                                break;
                            } else {
                                stringBuffer2.append(charAt);
                                break;
                            }
                        case 'Q':
                            stringBuffer2.append('K');
                            break;
                        case 'S':
                            if (!regionMatch(stringBuffer, i, "SH") && !regionMatch(stringBuffer, i, "SIO") && !regionMatch(stringBuffer, i, "SIA")) {
                                stringBuffer2.append('S');
                                break;
                            } else {
                                stringBuffer2.append('X');
                                break;
                            }
                            break;
                        case 'T':
                            if (!regionMatch(stringBuffer, i, "TIA") && !regionMatch(stringBuffer, i, "TIO")) {
                                if (!regionMatch(stringBuffer, i, "TCH")) {
                                    if (regionMatch(stringBuffer, i, "TH")) {
                                        stringBuffer2.append(TransactionIdCreater.FILL_BYTE);
                                        break;
                                    } else {
                                        stringBuffer2.append('T');
                                        break;
                                    }
                                }
                            } else {
                                stringBuffer2.append('X');
                                break;
                            }
                            break;
                        case 'V':
                            stringBuffer2.append('F');
                            break;
                        case 'W':
                        case 'Y':
                            if (!isLastChar(length, i) && isVowel(stringBuffer, i + 1)) {
                                stringBuffer2.append(charAt);
                                break;
                            }
                            break;
                        case 'X':
                            stringBuffer2.append('K');
                            stringBuffer2.append('S');
                            break;
                        case 'Z':
                            stringBuffer2.append('S');
                            break;
                    }
                    i++;
                }
                if (stringBuffer2.length() > getMaxCodeLen()) {
                    stringBuffer2.setLength(getMaxCodeLen());
                }
            }
            return stringBuffer2.toString();
        }
        return "";
    }
}
