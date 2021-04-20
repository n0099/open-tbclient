package com.bytedance.sdk.openadsdk.k;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final c f29391a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f29392b;

    /* renamed from: c  reason: collision with root package name */
    public final a f29393c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f29394a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29395b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29396c;

        /* renamed from: d  reason: collision with root package name */
        public final int f29397d;

        /* renamed from: e  reason: collision with root package name */
        public final int f29398e;

        /* renamed from: f  reason: collision with root package name */
        public final String f29399f;

        /* renamed from: g  reason: collision with root package name */
        public final List<String> f29400g;

        public a(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.f29394a = i;
            this.f29395b = str;
            this.f29396c = str2;
            this.f29397d = i2;
            this.f29398e = i3;
            this.f29399f = str3;
            this.f29400g = list;
        }

        public static a a(c cVar, List<b> list) throws d {
            String str;
            int i;
            int i2;
            int indexOf = cVar.f29404b.indexOf("?");
            if (indexOf != -1) {
                ArrayList arrayList = new ArrayList();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                int i3 = 0;
                for (String str5 : cVar.f29404b.substring(indexOf + 1).split("&")) {
                    String[] split = str5.split("=");
                    if (split.length == 2) {
                        if ("rk".equals(split[0])) {
                            str3 = Uri.decode(split[1]);
                        } else if (Config.APP_KEY.equals(split[0])) {
                            str4 = Uri.decode(split[1]);
                        } else if (split[0].startsWith("u")) {
                            arrayList.add(Uri.decode(split[1]));
                        } else if ("f".equals(split[0]) && com.bytedance.sdk.openadsdk.k.g.d.b(split[1]) == 1) {
                            i3 = 1;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    if (list != null) {
                        i2 = 0;
                        int i4 = 0;
                        for (b bVar : list) {
                            if (bVar != null && "Range".equalsIgnoreCase(bVar.f29401a)) {
                                int indexOf2 = bVar.f29402b.indexOf("=");
                                if (indexOf2 != -1) {
                                    if ("bytes".equalsIgnoreCase(bVar.f29402b.substring(0, indexOf2).trim())) {
                                        String substring = bVar.f29402b.substring(indexOf2 + 1);
                                        if (!substring.contains(",")) {
                                            int indexOf3 = substring.indexOf("-");
                                            if (indexOf3 != -1) {
                                                String trim = substring.substring(0, indexOf3).trim();
                                                String trim2 = substring.substring(indexOf3 + 1).trim();
                                                try {
                                                    if (trim.length() > 0) {
                                                        i2 = Integer.parseInt(trim);
                                                    }
                                                    if (trim2.length() > 0 && i2 > (i4 = Integer.parseInt(trim2))) {
                                                        throw new d("Range format error, Range: " + bVar.f29402b);
                                                    }
                                                    str2 = bVar.f29402b;
                                                } catch (NumberFormatException unused) {
                                                    throw new d("Range format error, Range: " + bVar.f29402b);
                                                }
                                            } else {
                                                throw new d("Range format error, Range: " + bVar.f29402b);
                                            }
                                        } else {
                                            throw new d("Range format error, Range: " + bVar.f29402b);
                                        }
                                    } else {
                                        throw new d("Range format error, Range: " + bVar.f29402b);
                                    }
                                } else {
                                    throw new d("Range format error, Range: " + bVar.f29402b);
                                }
                            }
                        }
                        i = i4;
                        str = str2;
                    } else {
                        str = null;
                        i = 0;
                        i2 = 0;
                    }
                    if (!arrayList.isEmpty()) {
                        return new a(i3, str3, str4, i2, i, str, arrayList);
                    }
                    throw new d("no url found: path: " + cVar.f29404b);
                }
                throw new d("rawKey or key is empty, path: " + cVar.f29404b);
            }
            throw new d("path format error, path: " + cVar.f29404b);
        }

        public String toString() {
            return "Extra{flag=" + this.f29394a + ", rawKey='" + this.f29395b + "', key='" + this.f29396c + "', from=" + this.f29397d + ", to=" + this.f29398e + ", urls=" + this.f29400g + '}';
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f29401a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29402b;

        public b(String str, String str2) {
            this.f29401a = str;
            this.f29402b = str2;
        }

        public static b a(String str) throws d {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                String trim = str.substring(0, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim.length() != 0 && trim2.length() != 0) {
                    return new b(trim, trim2);
                }
                throw new d("request header format error, header: " + str);
            }
            throw new d("request header format error, header: " + str);
        }

        public String toString() {
            return "Header{name='" + this.f29401a + "', value='" + this.f29402b + "'}";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f29403a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29404b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29405c;

        public c(String str, String str2, String str3) {
            this.f29403a = str;
            this.f29404b = str2;
            this.f29405c = str3;
        }

        public static c a(String str) throws d {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int lastIndexOf = str.lastIndexOf(32);
                if (lastIndexOf > indexOf) {
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
                    String trim3 = str.substring(lastIndexOf + 1).trim();
                    if (trim.length() != 0 && trim2.length() != 0 && trim3.length() != 0) {
                        return new c(trim, trim2, trim3);
                    }
                    throw new d("request line format error, line: " + str);
                }
                throw new d("request line format error, line: " + str);
            }
            throw new d("request line format error, line: " + str);
        }

        public String toString() {
            return "RequestLine{method='" + this.f29403a + "', path='" + this.f29404b + "', version='" + this.f29405c + "'}";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends Exception {
        public d(String str) {
            super(str);
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        this.f29391a = cVar;
        this.f29392b = list;
        this.f29393c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.k.g.d.f29387a));
        ArrayList arrayList = new ArrayList();
        c cVar = null;
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
        if (cVar != null) {
            return new i(cVar, arrayList, a.a(cVar, arrayList));
        }
        throw new d("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.f29391a + ", headers=" + this.f29392b + ", extra=" + this.f29393c + '}';
    }

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

    public static String a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        sb.append("=");
        sb.append(Uri.encode(str));
        sb.append("&");
        sb.append(Config.APP_KEY);
        sb.append("=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&");
            sb.append("u");
            sb.append(i);
            sb.append("=");
            sb.append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }
}
