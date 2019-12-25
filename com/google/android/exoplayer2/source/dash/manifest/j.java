package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;
/* loaded from: classes4.dex */
public final class j {
    private final String[] mqT;
    private final int[] mqU;
    private final String[] mqV;
    private final int mqW;

    public static j Pk(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new j(strArr, iArr, strArr2, a(str, strArr, iArr, strArr2));
    }

    private j(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.mqT = strArr;
        this.mqU = iArr;
        this.mqV = strArr2;
        this.mqW = i;
    }

    public String a(String str, int i, int i2, long j) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.mqW; i3++) {
            sb.append(this.mqT[i3]);
            if (this.mqU[i3] == 1) {
                sb.append(str);
            } else if (this.mqU[i3] == 2) {
                sb.append(String.format(Locale.US, this.mqV[i3], Integer.valueOf(i)));
            } else if (this.mqU[i3] == 3) {
                sb.append(String.format(Locale.US, this.mqV[i3], Integer.valueOf(i2)));
            } else if (this.mqU[i3] == 4) {
                sb.append(String.format(Locale.US, this.mqV[i3], Long.valueOf(j)));
            }
        }
        sb.append(this.mqT[this.mqW]);
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str, String[] strArr, int[] iArr, String[] strArr2) {
        boolean z;
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            if (indexOf == -1) {
                strArr[i] = strArr[i] + str.substring(i2);
                i2 = str.length();
            } else if (indexOf != i2) {
                strArr[i] = strArr[i] + str.substring(i2, indexOf);
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                strArr[i] = strArr[i] + "$";
                i2 += 2;
            } else {
                int indexOf2 = str.indexOf("$", i2 + 1);
                String substring = str.substring(i2 + 1, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    String str2 = "%01d";
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    }
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            iArr[i] = 2;
                            break;
                        case true:
                            iArr[i] = 3;
                            break;
                        case true:
                            iArr[i] = 4;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i] = str2;
                }
                i++;
                strArr[i] = "";
                i2 = indexOf2 + 1;
            }
        }
        return i;
    }
}
