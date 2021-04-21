package d.c.c.b.e;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<String>> f66700a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public String f66701b;

    public g(String str) {
        this.f66701b = str;
    }

    public String a() {
        StringBuilder sb;
        String str;
        if (this.f66700a.isEmpty()) {
            return this.f66701b;
        }
        String b2 = b(this.f66700a, "UTF-8");
        String str2 = this.f66701b;
        if (str2 == null || str2.length() == 0) {
            return b2;
        }
        if (this.f66701b.indexOf(63) >= 0) {
            sb = new StringBuilder();
            sb.append(this.f66701b);
            str = "&";
        } else {
            sb = new StringBuilder();
            sb.append(this.f66701b);
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
        List<String> list = this.f66700a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d2));
        this.f66700a.put(str, list);
    }

    public void d(String str, int i) {
        List<String> list = this.f66700a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i));
        this.f66700a.put(str, list);
    }

    public void e(String str, String str2) {
        List<String> list = this.f66700a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.f66700a.put(str, list);
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
