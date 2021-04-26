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
    public final c f30302a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f30303b;

    /* renamed from: c  reason: collision with root package name */
    public final a f30304c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f30305a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30306b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30307c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30308d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30309e;

        /* renamed from: f  reason: collision with root package name */
        public final String f30310f;

        /* renamed from: g  reason: collision with root package name */
        public final List<String> f30311g;

        public a(int i2, String str, String str2, int i3, int i4, String str3, List<String> list) {
            this.f30305a = i2;
            this.f30306b = str;
            this.f30307c = str2;
            this.f30308d = i3;
            this.f30309e = i4;
            this.f30310f = str3;
            this.f30311g = list;
        }

        public static a a(c cVar, List<b> list) throws d {
            String str;
            int i2;
            int i3;
            int indexOf = cVar.f30315b.indexOf("?");
            if (indexOf != -1) {
                ArrayList arrayList = new ArrayList();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                int i4 = 0;
                for (String str5 : cVar.f30315b.substring(indexOf + 1).split("&")) {
                    String[] split = str5.split("=");
                    if (split.length == 2) {
                        if ("rk".equals(split[0])) {
                            str3 = Uri.decode(split[1]);
                        } else if (Config.APP_KEY.equals(split[0])) {
                            str4 = Uri.decode(split[1]);
                        } else if (split[0].startsWith("u")) {
                            arrayList.add(Uri.decode(split[1]));
                        } else if ("f".equals(split[0]) && com.bytedance.sdk.openadsdk.k.g.d.b(split[1]) == 1) {
                            i4 = 1;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    if (list != null) {
                        i3 = 0;
                        int i5 = 0;
                        for (b bVar : list) {
                            if (bVar != null && "Range".equalsIgnoreCase(bVar.f30312a)) {
                                int indexOf2 = bVar.f30313b.indexOf("=");
                                if (indexOf2 != -1) {
                                    if ("bytes".equalsIgnoreCase(bVar.f30313b.substring(0, indexOf2).trim())) {
                                        String substring = bVar.f30313b.substring(indexOf2 + 1);
                                        if (!substring.contains(",")) {
                                            int indexOf3 = substring.indexOf("-");
                                            if (indexOf3 != -1) {
                                                String trim = substring.substring(0, indexOf3).trim();
                                                String trim2 = substring.substring(indexOf3 + 1).trim();
                                                try {
                                                    if (trim.length() > 0) {
                                                        i3 = Integer.parseInt(trim);
                                                    }
                                                    if (trim2.length() > 0 && i3 > (i5 = Integer.parseInt(trim2))) {
                                                        throw new d("Range format error, Range: " + bVar.f30313b);
                                                    }
                                                    str2 = bVar.f30313b;
                                                } catch (NumberFormatException unused) {
                                                    throw new d("Range format error, Range: " + bVar.f30313b);
                                                }
                                            } else {
                                                throw new d("Range format error, Range: " + bVar.f30313b);
                                            }
                                        } else {
                                            throw new d("Range format error, Range: " + bVar.f30313b);
                                        }
                                    } else {
                                        throw new d("Range format error, Range: " + bVar.f30313b);
                                    }
                                } else {
                                    throw new d("Range format error, Range: " + bVar.f30313b);
                                }
                            }
                        }
                        i2 = i5;
                        str = str2;
                    } else {
                        str = null;
                        i2 = 0;
                        i3 = 0;
                    }
                    if (!arrayList.isEmpty()) {
                        return new a(i4, str3, str4, i3, i2, str, arrayList);
                    }
                    throw new d("no url found: path: " + cVar.f30315b);
                }
                throw new d("rawKey or key is empty, path: " + cVar.f30315b);
            }
            throw new d("path format error, path: " + cVar.f30315b);
        }

        public String toString() {
            return "Extra{flag=" + this.f30305a + ", rawKey='" + this.f30306b + "', key='" + this.f30307c + "', from=" + this.f30308d + ", to=" + this.f30309e + ", urls=" + this.f30311g + '}';
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f30312a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30313b;

        public b(String str, String str2) {
            this.f30312a = str;
            this.f30313b = str2;
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
            return "Header{name='" + this.f30312a + "', value='" + this.f30313b + "'}";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f30314a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30315b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30316c;

        public c(String str, String str2, String str3) {
            this.f30314a = str;
            this.f30315b = str2;
            this.f30316c = str3;
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
            return "RequestLine{method='" + this.f30314a + "', path='" + this.f30315b + "', version='" + this.f30316c + "'}";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends Exception {
        public d(String str) {
            super(str);
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        this.f30302a = cVar;
        this.f30303b = list;
        this.f30304c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.k.g.d.f30298a));
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
        return "Request{requestLine=" + this.f30302a + ", headers=" + this.f30303b + ", extra=" + this.f30304c + '}';
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
        for (int i2 = 0; i2 < size; i2++) {
            sb.append("&");
            sb.append("u");
            sb.append(i2);
            sb.append("=");
            sb.append(Uri.encode(list.get(i2)));
        }
        return sb.toString();
    }
}
