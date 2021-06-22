package d.a.o0.t2.c0.m;

import com.android.internal.http.multipart.Part;
import d.a.c.e.p.k;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f64831a = "";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f64832b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f64833c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, byte[]> f64834d = new HashMap<>();

    public void a(String str, String str2) {
        Map<String, String> map = this.f64832b;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void b(BasicNameValuePair basicNameValuePair) {
        this.f64833c.add(basicNameValuePair);
    }

    public String c(e eVar) {
        if (this.f64833c.size() == 0) {
            if (eVar != null) {
                eVar.f64819a = this.f64831a.length();
            }
            return this.f64831a;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.f64831a);
        if (this.f64831a.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.f64831a.endsWith("?") && !this.f64831a.endsWith("&")) {
            sb.append("&");
        }
        for (int i2 = 0; i2 < this.f64833c.size(); i2++) {
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.f64833c.get(i2).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.f64833c.get(i2).getValue()));
        }
        if (eVar != null) {
            eVar.f64819a = sb.length();
        }
        return sb.toString();
    }

    public String d(String str) {
        Map<String, String> map = this.f64832b;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public String e() {
        return this.f64831a;
    }

    public boolean f() {
        HashMap<String, byte[]> hashMap = this.f64834d;
        return hashMap != null && hashMap.size() > 0;
    }

    public final StringBuilder g() {
        StringBuilder sb = new StringBuilder(1024);
        LinkedList<BasicNameValuePair> linkedList = this.f64833c;
        if (linkedList != null) {
            int i2 = 0;
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(k.getUrlEncode(value));
                    i2++;
                }
            }
        }
        return sb;
    }

    public void h() {
    }

    public void i(String str) {
        if (str == null) {
            this.f64831a = "";
        } else {
            this.f64831a = str;
        }
    }

    public void j(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.f64832b) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void k(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i2;
        if (httpURLConnection != null) {
            String sb = g().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                d.a.c.e.m.a.d(dataOutputStream);
                i2 = sb.length();
            } catch (Throwable th) {
                d.a.c.e.m.a.d(dataOutputStream);
                throw th;
            }
        } else {
            i2 = 0;
        }
        if (eVar != null) {
            eVar.f64819a = i2;
        }
    }

    public void l(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        int i2;
        h();
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.f64833c != null) {
                    Iterator<BasicNameValuePair> it = this.f64833c.iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("--" + str + Part.CRLF);
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + Part.CRLF);
                                dataOutputStream.writeBytes(Part.CRLF);
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes(Part.CRLF);
                            }
                        }
                    }
                }
                if (this.f64834d != null) {
                    for (Map.Entry<String, byte[]> entry : this.f64834d.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("--" + str + Part.CRLF);
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + Part.CRLF);
                            dataOutputStream.writeBytes(Part.CRLF);
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes(Part.CRLF);
                        }
                    }
                }
                dataOutputStream.writeBytes("--" + str + "--" + Part.CRLF);
                dataOutputStream.flush();
                i2 = dataOutputStream.size();
            } finally {
                d.a.c.e.m.a.d(dataOutputStream);
            }
        } else {
            i2 = 0;
        }
        if (eVar != null) {
            eVar.f64819a = i2;
        }
    }
}
