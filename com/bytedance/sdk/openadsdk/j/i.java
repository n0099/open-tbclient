package com.bytedance.sdk.openadsdk.j;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final c f7297a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f7298b;
    public final a c;

    public i(c cVar, List<b> list, a aVar) {
        this.f7297a = cVar;
        this.f7298b = list;
        this.c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.j.g.d.f7293a));
        c cVar = null;
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (cVar == null) {
                cVar = c.a(trim);
            } else {
                arrayList.add(b.a(trim));
            }
        }
        if (cVar == null) {
            throw new d("request line is null");
        }
        return new i(cVar, arrayList, a.a(cVar, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final String f7303a;

        /* renamed from: b  reason: collision with root package name */
        final String f7304b;
        final String c;

        private c(String str, String str2, String str3) {
            this.f7303a = str;
            this.f7304b = str2;
            this.c = str3;
        }

        static c a(String str) throws d {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new d("request line format error, line: " + str);
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf <= indexOf) {
                throw new d("request line format error, line: " + str);
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
            String trim3 = str.substring(lastIndexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0 || trim3.length() == 0) {
                throw new d("request line format error, line: " + str);
            }
            return new c(trim, trim2, trim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.f7303a + "', path='" + this.f7304b + "', version='" + this.c + "'}";
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f7301a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7302b;

        public b(String str, String str2) {
            this.f7301a = str;
            this.f7302b = str2;
        }

        static b a(String str) throws d {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                throw new d("request header format error, header: " + str);
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0) {
                throw new d("request header format error, header: " + str);
            }
            return new b(trim, trim2);
        }

        public String toString() {
            return "Header{name='" + this.f7301a + "', value='" + this.f7302b + "'}";
        }
    }

    /* loaded from: classes4.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f7299a;

        /* renamed from: b  reason: collision with root package name */
        final String f7300b;
        final String c;
        final int d;
        final int e;
        final String f;
        final List<String> g;

        private a(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.f7299a = i;
            this.f7300b = str;
            this.c = str2;
            this.d = i2;
            this.e = i3;
            this.f = str3;
            this.g = list;
        }

        static a a(c cVar, List<b> list) throws d {
            int i;
            int i2;
            String str;
            int i3;
            String str2 = null;
            int indexOf = cVar.f7304b.indexOf("?");
            if (indexOf == -1) {
                throw new d("path format error, path: " + cVar.f7304b);
            }
            ArrayList arrayList = new ArrayList();
            String[] split = cVar.f7304b.substring(indexOf + 1).split(ETAG.ITEM_SEPARATOR);
            String str3 = null;
            String str4 = null;
            int i4 = 0;
            for (String str5 : split) {
                String[] split2 = str5.split("=");
                if (split2.length == 2) {
                    if ("rk".equals(split2[0])) {
                        str4 = Uri.decode(split2[1]);
                    } else if ("k".equals(split2[0])) {
                        str3 = Uri.decode(split2[1]);
                    } else if (split2[0].startsWith("u")) {
                        arrayList.add(Uri.decode(split2[1]));
                    } else if ("f".equals(split2[0]) && com.bytedance.sdk.openadsdk.j.g.d.b(split2[1]) == 1) {
                        i4 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                throw new d("rawKey or key is empty, path: " + cVar.f7304b);
            }
            if (list != null) {
                i = 0;
                int i5 = 0;
                for (b bVar : list) {
                    if (bVar != null) {
                        if (Headers.RANGE.equalsIgnoreCase(bVar.f7301a)) {
                            int indexOf2 = bVar.f7302b.indexOf("=");
                            if (indexOf2 == -1) {
                                throw new d("Range format error, Range: " + bVar.f7302b);
                            }
                            if (!"bytes".equalsIgnoreCase(bVar.f7302b.substring(0, indexOf2).trim())) {
                                throw new d("Range format error, Range: " + bVar.f7302b);
                            }
                            String substring = bVar.f7302b.substring(indexOf2 + 1);
                            if (substring.contains(",")) {
                                throw new d("Range format error, Range: " + bVar.f7302b);
                            }
                            int indexOf3 = substring.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (indexOf3 == -1) {
                                throw new d("Range format error, Range: " + bVar.f7302b);
                            }
                            String trim = substring.substring(0, indexOf3).trim();
                            String trim2 = substring.substring(indexOf3 + 1).trim();
                            try {
                                int parseInt = trim.length() > 0 ? Integer.parseInt(trim) : i5;
                                if (trim2.length() > 0) {
                                    i3 = Integer.parseInt(trim2);
                                    if (parseInt > i3) {
                                        throw new d("Range format error, Range: " + bVar.f7302b);
                                    }
                                } else {
                                    i3 = i;
                                }
                                str = bVar.f7302b;
                                i5 = parseInt;
                            } catch (NumberFormatException e) {
                                throw new d("Range format error, Range: " + bVar.f7302b);
                            }
                        } else {
                            str = str2;
                            i3 = i;
                        }
                        str2 = str;
                        i = i3;
                    }
                }
                i2 = i5;
            } else {
                i = 0;
                i2 = 0;
            }
            if (arrayList.isEmpty()) {
                throw new d("no url found: path: " + cVar.f7304b);
            }
            return new a(i4, str4, str3, i2, i, str2, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.f7299a + ", rawKey='" + this.f7300b + "', key='" + this.c + "', from=" + this.d + ", to=" + this.e + ", urls=" + this.g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = a(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    private static String a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk").append("=").append(Uri.encode(str));
        sb.append(ETAG.ITEM_SEPARATOR).append("k").append("=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(ETAG.ITEM_SEPARATOR).append("u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.f7297a + ", headers=" + this.f7298b + ", extra=" + this.c + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class d extends Exception {
        d(String str) {
            super(str);
        }
    }
}
