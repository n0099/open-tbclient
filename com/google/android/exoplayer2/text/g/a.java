package com.google.android.exoplayer2.text.g;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.google.android.exoplayer2.util.l;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
final class a {
    private static final Pattern mCc = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final l mCd = new l();
    private final StringBuilder mCe = new StringBuilder();

    public d W(l lVar) {
        this.mCe.setLength(0);
        int position = lVar.getPosition();
        aa(lVar);
        this.mCd.I(lVar.data, lVar.getPosition());
        this.mCd.setPosition(position);
        String a = a(this.mCd, this.mCe);
        if (a == null || !"{".equals(b(this.mCd, this.mCe))) {
            return null;
        }
        d dVar = new d();
        a(dVar, a);
        boolean z = false;
        String str = null;
        while (!z) {
            int position2 = this.mCd.getPosition();
            str = b(this.mCd, this.mCe);
            z = str == null || "}".equals(str);
            if (!z) {
                this.mCd.setPosition(position2);
                a(this.mCd, dVar, this.mCe);
            }
        }
        if ("}".equals(str)) {
            return dVar;
        }
        return null;
    }

    private static String a(l lVar, StringBuilder sb) {
        Y(lVar);
        if (lVar.dzu() >= 5 && "::cue".equals(lVar.LU(5))) {
            int position = lVar.getPosition();
            String b = b(lVar, sb);
            if (b != null) {
                if ("{".equals(b)) {
                    lVar.setPosition(position);
                    return "";
                }
                String X = "(".equals(b) ? X(lVar) : null;
                String b2 = b(lVar, sb);
                if (!")".equals(b2) || b2 == null) {
                    return null;
                }
                return X;
            }
            return null;
        }
        return null;
    }

    private static String X(l lVar) {
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        int i = position;
        boolean z = false;
        while (i < dzv && !z) {
            int i2 = i + 1;
            z = ((char) lVar.data[i]) == ')';
            i = i2;
        }
        return lVar.LU((i - 1) - lVar.getPosition()).trim();
    }

    private static void a(l lVar, d dVar, StringBuilder sb) {
        Y(lVar);
        String d = d(lVar, sb);
        if (!"".equals(d) && ":".equals(b(lVar, sb))) {
            Y(lVar);
            String c = c(lVar, sb);
            if (c != null && !"".equals(c)) {
                int position = lVar.getPosition();
                String b = b(lVar, sb);
                if (!ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR.equals(b)) {
                    if ("}".equals(b)) {
                        lVar.setPosition(position);
                    } else {
                        return;
                    }
                }
                if ("color".equals(d)) {
                    dVar.LB(com.google.android.exoplayer2.util.d.Qo(c));
                } else if ("background-color".equals(d)) {
                    dVar.LC(com.google.android.exoplayer2.util.d.Qo(c));
                } else if ("text-decoration".equals(d)) {
                    if ("underline".equals(c)) {
                        dVar.vP(true);
                    }
                } else if ("font-family".equals(d)) {
                    dVar.Qg(c);
                } else if ("font-weight".equals(d)) {
                    if ("bold".equals(c)) {
                        dVar.vQ(true);
                    }
                } else if ("font-style".equals(d) && "italic".equals(c)) {
                    dVar.vR(true);
                }
            }
        }
    }

    static void Y(l lVar) {
        boolean z = true;
        while (lVar.dzu() > 0 && z) {
            z = Z(lVar) || ab(lVar);
        }
    }

    static String b(l lVar, StringBuilder sb) {
        Y(lVar);
        if (lVar.dzu() == 0) {
            return null;
        }
        String d = d(lVar, sb);
        return "".equals(d) ? "" + ((char) lVar.readUnsignedByte()) : d;
    }

    private static boolean Z(l lVar) {
        switch (r(lVar, lVar.getPosition())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                lVar.skipBytes(1);
                return true;
            default:
                return false;
        }
    }

    static void aa(l lVar) {
        do {
        } while (!TextUtils.isEmpty(lVar.readLine()));
    }

    private static char r(l lVar, int i) {
        return (char) lVar.data[i];
    }

    private static String c(l lVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int position = lVar.getPosition();
            String b = b(lVar, sb);
            if (b == null) {
                return null;
            }
            if ("}".equals(b) || ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR.equals(b)) {
                lVar.setPosition(position);
                z = true;
            } else {
                sb2.append(b);
            }
        }
        return sb2.toString();
    }

    private static boolean ab(l lVar) {
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        byte[] bArr = lVar.data;
        if (position + 2 <= dzv) {
            int i = position + 1;
            if (bArr[position] == 47) {
                int i2 = i + 1;
                if (bArr[i] == 42) {
                    while (true) {
                        int i3 = i2;
                        if (i3 + 1 < dzv) {
                            i2 = i3 + 1;
                            if (((char) bArr[i3]) == '*' && ((char) bArr[i2]) == '/') {
                                dzv = i2 + 1;
                                i2 = dzv;
                            }
                        } else {
                            lVar.skipBytes(dzv - lVar.getPosition());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static String d(l lVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int position = lVar.getPosition();
        int dzv = lVar.dzv();
        while (position < dzv && !z) {
            char c = (char) lVar.data[position];
            if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                position++;
                sb.append(c);
            } else {
                z = true;
            }
        }
        lVar.skipBytes(position - lVar.getPosition());
        return sb.toString();
    }

    private void a(d dVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = mCc.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.Qf(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.Qe(str2.substring(0, indexOf2));
                dVar.Qd(str2.substring(indexOf2 + 1));
            } else {
                dVar.Qe(str2);
            }
            if (split.length > 1) {
                dVar.T((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }
}
