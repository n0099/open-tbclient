package org.acra;

import android.content.Context;
import cn.jingling.lib.file.Shared;
import com.baidu.location.BDLocation;
import com.baidu.zeus.WebChromeClient;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Map;
import org.acra.collector.CrashReportData;
/* loaded from: classes.dex */
final class l {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.a = context;
    }

    public CrashReportData a(String str) {
        CrashReportData a;
        FileInputStream openFileInput = this.a.openFileInput(str);
        if (openFileInput == null) {
            throw new IllegalArgumentException("Invalid crash report fileName : " + str);
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput, 8192);
            bufferedInputStream.mark(Shared.INFINITY);
            boolean a2 = a(bufferedInputStream);
            bufferedInputStream.reset();
            if (!a2) {
                a = a(new InputStreamReader(bufferedInputStream, "ISO8859-1"));
            } else {
                a = a(new InputStreamReader(bufferedInputStream));
            }
            return a;
        } finally {
            openFileInput.close();
        }
    }

    public void a(CrashReportData crashReportData, String str) {
        FileOutputStream openFileOutput = this.a.openFileOutput(str, 0);
        try {
            StringBuilder sb = new StringBuilder(200);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput, "ISO8859_1");
            for (Map.Entry entry : crashReportData.entrySet()) {
                a(sb, ((ReportField) entry.getKey()).toString(), true);
                sb.append('=');
                a(sb, (String) entry.getValue(), false);
                sb.append("\n");
                outputStreamWriter.write(sb.toString());
                sb.setLength(0);
            }
            outputStreamWriter.flush();
        } finally {
            openFileOutput.close();
        }
    }

    private boolean a(BufferedInputStream bufferedInputStream) {
        byte read;
        do {
            read = (byte) bufferedInputStream.read();
            if (read == -1 || read == 35 || read == 10 || read == 61) {
                return false;
            }
        } while (read != 21);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized CrashReportData a(Reader reader) {
        CrashReportData crashReportData;
        char c;
        int i;
        int i2;
        char c2;
        char c3;
        char[] cArr = new char[40];
        int i3 = 0;
        int i4 = -1;
        crashReportData = new CrashReportData();
        BufferedReader bufferedReader = new BufferedReader(reader, 8192);
        boolean z = true;
        int i5 = 0;
        char c4 = 0;
        int i6 = 0;
        while (true) {
            int read = bufferedReader.read();
            if (read != -1) {
                char c5 = (char) read;
                if (i3 == cArr.length) {
                    char[] cArr2 = new char[cArr.length * 2];
                    System.arraycopy(cArr, 0, cArr2, 0, i3);
                    cArr = cArr2;
                }
                if (c4 == 2) {
                    int digit = Character.digit(c5, 16);
                    if (digit >= 0) {
                        int i7 = digit + (i5 << 4);
                        i2 = i6 + 1;
                        if (i2 < 4) {
                            i6 = i2;
                            i5 = i7;
                        } else {
                            i = i7;
                        }
                    } else if (i6 <= 4) {
                        throw new IllegalArgumentException("luni.09");
                    } else {
                        i = i5;
                        i2 = i6;
                    }
                    int i8 = i3 + 1;
                    cArr[i3] = (char) i;
                    if (c5 == '\n' || c5 == 133) {
                        i3 = i8;
                        c = 0;
                    } else {
                        i3 = i8;
                        i6 = i2;
                        i5 = i;
                        c4 = 0;
                    }
                } else {
                    int i9 = i6;
                    c = c4;
                    i = i5;
                    i2 = i9;
                }
                if (c == 1) {
                    switch (c5) {
                        case '\n':
                        case 133:
                            int i10 = i2;
                            i5 = i;
                            c4 = 5;
                            i6 = i10;
                            break;
                        case '\r':
                            int i11 = i2;
                            i5 = i;
                            c4 = 3;
                            i6 = i11;
                            break;
                        case 'b':
                            c5 = '\b';
                            char c6 = c5;
                            c2 = 0;
                            c3 = c6;
                            if (c2 == 4) {
                                c2 = 0;
                                i4 = i3;
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                        case WebChromeClient.STRING_DLG_TITLE_WEEK /* 102 */:
                            c5 = '\f';
                            char c62 = c5;
                            c2 = 0;
                            c3 = c62;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                        case 'n':
                            c5 = '\n';
                            char c622 = c5;
                            c2 = 0;
                            c3 = c622;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                        case 'r':
                            c5 = '\r';
                            char c6222 = c5;
                            c2 = 0;
                            c3 = c6222;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                        case 't':
                            c5 = '\t';
                            char c62222 = c5;
                            c2 = 0;
                            c3 = c62222;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                        case 'u':
                            i5 = 0;
                            c4 = 2;
                            i6 = 0;
                            break;
                        default:
                            char c622222 = c5;
                            c2 = 0;
                            c3 = c622222;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                    }
                } else {
                    switch (c5) {
                        case '\n':
                            if (c == 3) {
                                int i12 = i2;
                                i5 = i;
                                c4 = 5;
                                i6 = i12;
                                break;
                            } else {
                                if (i3 <= 0 || (i3 == 0 && i4 == 0)) {
                                    if (i4 == -1) {
                                        i4 = i3;
                                    }
                                    String str = new String(cArr, 0, i3);
                                    crashReportData.put((CrashReportData) Enum.valueOf(ReportField.class, str.substring(0, i4)), (Enum) str.substring(i4));
                                }
                                i4 = -1;
                                i3 = 0;
                                z = true;
                                int i13 = i2;
                                i5 = i;
                                c4 = 0;
                                i6 = i13;
                                break;
                            }
                        case '\r':
                        case 133:
                            if (i3 <= 0) {
                            }
                            if (i4 == -1) {
                            }
                            String str2 = new String(cArr, 0, i3);
                            crashReportData.put((CrashReportData) Enum.valueOf(ReportField.class, str2.substring(0, i4)), (Enum) str2.substring(i4));
                            i4 = -1;
                            i3 = 0;
                            z = true;
                            int i132 = i2;
                            i5 = i;
                            c4 = 0;
                            i6 = i132;
                            break;
                        case '!':
                        case '#':
                            if (!z) {
                                if (Character.isWhitespace(c5)) {
                                    if (c == 3) {
                                        c = 5;
                                    }
                                    if (i3 != 0 && i3 != i4) {
                                        if (c == 5) {
                                            int i14 = i2;
                                            i5 = i;
                                            c4 = c;
                                            i6 = i14;
                                            break;
                                        } else if (i4 == -1) {
                                            int i15 = i2;
                                            i5 = i;
                                            c4 = 4;
                                            i6 = i15;
                                            break;
                                        }
                                    }
                                    int i16 = i2;
                                    i5 = i;
                                    c4 = c;
                                    i6 = i16;
                                    break;
                                }
                                if (c != 5 || c == 3) {
                                    c2 = 0;
                                    c3 = c5;
                                } else {
                                    c2 = c;
                                    c3 = c5;
                                }
                                if (c2 == 4) {
                                }
                                cArr[i3] = c3;
                                i3++;
                                i6 = i2;
                                z = false;
                                i5 = i;
                                c4 = c2;
                                break;
                            } else {
                                while (true) {
                                    int read2 = bufferedReader.read();
                                    if (read2 != -1) {
                                        char c7 = (char) read2;
                                        if (c7 != '\r' && c7 != '\n') {
                                            if (c7 == 133) {
                                                int i17 = i2;
                                                i5 = i;
                                                c4 = c;
                                                i6 = i17;
                                                break;
                                            }
                                        }
                                    } else {
                                        int i18 = i2;
                                        i5 = i;
                                        c4 = c;
                                        i6 = i18;
                                        break;
                                    }
                                }
                            }
                            break;
                        case ':':
                        case BDLocation.TypeGpsLocation /* 61 */:
                            if (i4 == -1) {
                                i4 = i3;
                                int i19 = i2;
                                i5 = i;
                                c4 = 0;
                                i6 = i19;
                                break;
                            } else {
                                if (Character.isWhitespace(c5)) {
                                }
                                if (c != 5) {
                                    break;
                                }
                                c2 = 0;
                                c3 = c5;
                                if (c2 == 4) {
                                }
                                cArr[i3] = c3;
                                i3++;
                                i6 = i2;
                                z = false;
                                i5 = i;
                                c4 = c2;
                                break;
                            }
                            break;
                        case '\\':
                            i4 = c == 4 ? i3 : i4;
                            int i20 = i2;
                            i5 = i;
                            c4 = 1;
                            i6 = i20;
                            break;
                        default:
                            if (Character.isWhitespace(c5)) {
                            }
                            if (c != 5) {
                            }
                            c2 = 0;
                            c3 = c5;
                            if (c2 == 4) {
                            }
                            cArr[i3] = c3;
                            i3++;
                            i6 = i2;
                            z = false;
                            i5 = i;
                            c4 = c2;
                            break;
                    }
                }
            } else if (c4 == 2 && i6 <= 4) {
                throw new IllegalArgumentException("luni.08");
            } else {
                if (i4 == -1 && i3 > 0) {
                    i4 = i3;
                }
                if (i4 >= 0) {
                    String str3 = new String(cArr, 0, i3);
                    ReportField reportField = (ReportField) Enum.valueOf(ReportField.class, str3.substring(0, i4));
                    String substring = str3.substring(i4);
                    if (c4 == 1) {
                        substring = substring + "\u0000";
                    }
                    crashReportData.put((CrashReportData) reportField, (ReportField) substring);
                }
            }
        }
        return crashReportData;
    }

    private void a(StringBuilder sb, String str, boolean z) {
        int i;
        if (z || 0 >= str.length() || str.charAt(0) != ' ') {
            i = 0;
        } else {
            sb.append("\\ ");
            i = 1;
        }
        while (i < str.length()) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case 11:
                default:
                    if ("\\#!=:".indexOf(charAt) >= 0 || (z && charAt == ' ')) {
                        sb.append('\\');
                    }
                    if (charAt >= ' ' && charAt <= '~') {
                        sb.append(charAt);
                        break;
                    } else {
                        String hexString = Integer.toHexString(charAt);
                        sb.append("\\u");
                        for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                            sb.append("0");
                        }
                        sb.append(hexString);
                        break;
                    }
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
            }
            i++;
        }
    }
}
