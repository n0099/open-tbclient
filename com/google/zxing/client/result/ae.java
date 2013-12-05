package com.google.zxing.client.result;

import com.baidu.location.BDLocation;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class ae extends t {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2843a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern c = Pattern.compile("\r\n[ \t]");
    private static final Pattern d = Pattern.compile("\\\\[nN]");
    private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f = Pattern.compile("=");
    private static final Pattern g = Pattern.compile(";");
    private static final Pattern h = Pattern.compile("(?<!\\\\);+");
    private static final Pattern i = Pattern.compile(",");
    private static final Pattern j = Pattern.compile("[;,]");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public d b(com.google.zxing.h hVar) {
        String c2 = c(hVar);
        Matcher matcher = f2843a.matcher(c2);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> a2 = a((CharSequence) "FN", c2, true, false);
        if (a2 == null) {
            a2 = a((CharSequence) "N", c2, true, false);
            a((Iterable<List<String>>) a2);
        }
        List<List<String>> list = a2;
        List<String> b2 = b((CharSequence) "NICKNAME", c2, true, false);
        String[] split = b2 == null ? null : i.split(b2.get(0));
        List<List<String>> a3 = a((CharSequence) "TEL", c2, true, false);
        List<List<String>> a4 = a((CharSequence) "EMAIL", c2, true, false);
        List<String> b3 = b((CharSequence) "NOTE", c2, false, false);
        List<List<String>> a5 = a((CharSequence) "ADR", c2, true, true);
        List<String> b4 = b((CharSequence) "ORG", c2, true, true);
        List<String> b5 = b((CharSequence) "BDAY", c2, true, false);
        List<String> list2 = (b5 == null || a(b5.get(0))) ? b5 : null;
        List<String> b6 = b((CharSequence) "TITLE", c2, true, false);
        List<List<String>> a6 = a((CharSequence) "URL", c2, true, false);
        List<String> b7 = b((CharSequence) "IMPP", c2, true, false);
        List<String> b8 = b((CharSequence) "GEO", c2, true, false);
        String[] split2 = b8 == null ? null : j.split(b8.get(0));
        if (split2 != null && split2.length != 2) {
            split2 = null;
        }
        return new d(a((Collection<List<String>>) list), split, null, a((Collection<List<String>>) a3), b(a3), a((Collection<List<String>>) a4), b(a4), a(b7), a(b3), a((Collection<List<String>>) a5), b(a5), a(b4), a(list2), a(b6), a((Collection<List<String>>) a6), split2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        r0 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<List<String>> a(CharSequence charSequence, String str, boolean z, boolean z2) {
        String str2;
        ArrayList arrayList;
        int indexOf;
        String replaceAll;
        boolean z3;
        int i2 = 0;
        int length = str.length();
        ArrayList arrayList2 = null;
        while (i2 < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i2 > 0) {
                i2--;
            }
            if (!matcher.find(i2)) {
                break;
            }
            int end = matcher.end(0);
            String group = matcher.group(1);
            ArrayList arrayList3 = null;
            boolean z4 = false;
            String str3 = null;
            if (group == null) {
                str2 = null;
                arrayList = null;
            } else {
                String[] split = g.split(group);
                int length2 = split.length;
                int i3 = 0;
                while (i3 < length2) {
                    String str4 = split[i3];
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList(1);
                    }
                    arrayList3.add(str4);
                    String[] split2 = f.split(str4, 2);
                    if (split2.length > 1) {
                        String str5 = split2[0];
                        String str6 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str3 = str6;
                            z3 = z4;
                        }
                        i3++;
                        z4 = z3;
                    }
                    z3 = z4;
                    i3++;
                    z4 = z3;
                }
                str2 = str3;
                arrayList = arrayList3;
            }
            int i4 = end;
            while (true) {
                indexOf = str.indexOf(10, i4);
                if (indexOf < 0) {
                    break;
                } else if (indexOf < str.length() - 1 && (str.charAt(indexOf + 1) == ' ' || str.charAt(indexOf + 1) == '\t')) {
                    i4 = indexOf + 2;
                } else if (!z4 || ((indexOf < 1 || str.charAt(indexOf - 1) != '=') && (indexOf < 2 || str.charAt(indexOf - 2) != '='))) {
                    break;
                } else {
                    i4 = indexOf + 1;
                }
            }
            if (indexOf > end) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (indexOf >= 1 && str.charAt(indexOf - 1) == '\r') {
                    indexOf--;
                }
                String substring = str.substring(end, indexOf);
                if (z) {
                    substring = substring.trim();
                }
                if (z4) {
                    replaceAll = a(substring, str2);
                    if (z2) {
                        replaceAll = h.matcher(replaceAll).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        substring = h.matcher(substring).replaceAll("\n").trim();
                    }
                    replaceAll = e.matcher(d.matcher(c.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (arrayList == null) {
                    ArrayList arrayList4 = new ArrayList(1);
                    arrayList4.add(replaceAll);
                    arrayList2.add(arrayList4);
                } else {
                    arrayList.add(0, replaceAll);
                    arrayList2.add(arrayList);
                }
                i2 = indexOf + 1;
            } else {
                i2 = indexOf + 1;
            }
        }
        return arrayList2;
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            switch (charAt2) {
                case '\n':
                case '\r':
                    break;
                case BDLocation.TypeGpsLocation /* 61 */:
                    if (i2 < length - 2 && (charAt = charSequence.charAt(i2 + 1)) != '\r' && charAt != '\n') {
                        char charAt3 = charSequence.charAt(i2 + 2);
                        int a2 = a(charAt);
                        int a3 = a(charAt3);
                        if (a2 >= 0 && a3 >= 0) {
                            byteArrayOutputStream.write((a2 << 4) + a3);
                        }
                        i2 += 2;
                        break;
                    }
                    break;
                default:
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                    break;
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException e2) {
                    str2 = new String(byteArray);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> a2 = a(charSequence, str, z, z2);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && str.length() > 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static String[] b(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    str = null;
                    break;
                }
                str = list.get(i3);
                int indexOf = str.indexOf(61);
                if (indexOf >= 0) {
                    if (!"TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        i2 = i3 + 1;
                    } else {
                        str = str.substring(indexOf + 1);
                        break;
                    }
                } else {
                    break;
                }
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static boolean a(CharSequence charSequence) {
        return charSequence == null || b.matcher(charSequence).matches();
    }

    private static void a(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < strArr.length - 1 && (indexOf = str.indexOf(59, i3)) > 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                a(strArr, 3, sb);
                a(strArr, 1, sb);
                a(strArr, 2, sb);
                a(strArr, 0, sb);
                a(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] != null) {
            sb.append(' ');
            sb.append(strArr[i2]);
        }
    }
}
