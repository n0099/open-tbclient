package d.b.c.b.e;

import d.b.c.b.d.k;
import d.b.c.b.d.q;
import d.b.c.b.f.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class c {
    public static long a(String str) {
        try {
            return f().parse(str).getTime();
        } catch (Throwable th) {
            q.b(th, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static b.a b(k kVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = kVar.f69525c;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i3 = 0;
            j = 0;
            j2 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long a4 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j * 1000);
            if (i2 != 0) {
                j5 = j4;
            } else {
                Long.signum(j2);
                j5 = (j2 * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a2 <= 0 || a3 < a2) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a3 - a2);
                j3 = j4;
            }
        }
        b.a aVar = new b.a();
        aVar.f69564a = kVar.f69523a;
        aVar.f69565b = kVar.f69524b;
        aVar.f69566c = str5;
        aVar.f69570g = j4;
        aVar.f69569f = j3;
        aVar.f69567d = a2;
        aVar.f69568e = a4;
        aVar.f69571h = map;
        aVar.f69572i = kVar.f69526d;
        return aVar;
    }

    public static String c(long j) {
        return f().format(new Date(j));
    }

    public static String d(Map<String, String> map) {
        return e(map, "UTF-8");
    }

    public static String e(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static SimpleDateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static Map<String, String> g(List<d.b.c.b.d.a> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (list != null) {
            for (d.b.c.b.d.a aVar : list) {
                treeMap.put(aVar.a(), aVar.b());
            }
        }
        return treeMap;
    }

    public static List<d.b.c.b.d.a> h(Map<String, String> map) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new d.b.c.b.d.a(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
