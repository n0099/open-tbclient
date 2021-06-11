package d.b.c.b.e;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<String>> f69561a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public String f69562b;

    public g(String str) {
        this.f69562b = str;
    }

    public String a() {
        StringBuilder sb;
        String str;
        if (this.f69561a.isEmpty()) {
            return this.f69562b;
        }
        String b2 = b(this.f69561a, "UTF-8");
        String str2 = this.f69562b;
        if (str2 == null || str2.length() == 0) {
            return b2;
        }
        if (this.f69562b.indexOf(63) >= 0) {
            sb = new StringBuilder();
            sb.append(this.f69562b);
            str = "&";
        } else {
            sb = new StringBuilder();
            sb.append(this.f69562b);
            str = "?";
        }
        sb.append(str);
        sb.append(b2);
        return sb.toString();
    }

    public String b(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String f2 = f(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String f3 = next != null ? f(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(f2);
                    if (!f3.isEmpty()) {
                        sb.append("=");
                        sb.append(f3);
                    }
                }
            }
        }
        return sb.toString();
    }

    public void c(String str, double d2) {
        List<String> list = this.f69561a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d2));
        this.f69561a.put(str, list);
    }

    public void d(String str, int i2) {
        List<String> list = this.f69561a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i2));
        this.f69561a.put(str, list);
    }

    public void e(String str, String str2) {
        List<String> list = this.f69561a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.f69561a.put(str, list);
    }

    public final String f(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public String toString() {
        return a();
    }
}
