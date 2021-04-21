package d.b.c.e.j.a;

import com.android.internal.http.multipart.Part;
import com.baidu.adp.framework.task.HttpMessageTask;
import d.b.c.e.p.k;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageTask.HTTP_METHOD f42528b;

    /* renamed from: a  reason: collision with root package name */
    public String f42527a = "";

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f42529c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f42530d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, byte[]> f42531e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f42532f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42533g = false;

    public void a(String str, String str2) {
        Map<String, String> map = this.f42529c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void b(String str, String str2) {
        this.f42530d.add(new BasicNameValuePair(str, str2));
    }

    public void c(String str, byte[] bArr) {
        this.f42531e.put(str, bArr);
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        this.f42530d.add(basicNameValuePair);
    }

    public boolean e() {
        return this.f42532f;
    }

    public String f(d dVar) {
        if (this.f42530d.size() == 0) {
            if (dVar != null) {
                dVar.f42515a = this.f42527a.length();
            }
            return this.f42527a;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.f42527a);
        if (this.f42527a.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.f42527a.endsWith("?") && !this.f42527a.endsWith("&")) {
            sb.append("&");
        }
        for (int i = 0; i < this.f42530d.size(); i++) {
            if (i != 0) {
                sb.append("&");
            }
            sb.append(this.f42530d.get(i).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.f42530d.get(i).getValue()));
        }
        if (dVar != null) {
            dVar.f42515a = sb.length();
        }
        return sb.toString();
    }

    public String g(String str) {
        Map<String, String> map = this.f42529c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public HttpMessageTask.HTTP_METHOD h() {
        return this.f42528b;
    }

    public String i() {
        return this.f42527a;
    }

    public boolean j() {
        HashMap<String, byte[]> hashMap = this.f42531e;
        return hashMap != null && hashMap.size() > 0;
    }

    public boolean k() {
        return this.f42533g;
    }

    public final StringBuilder l() {
        StringBuilder sb = new StringBuilder(1024);
        LinkedList<BasicNameValuePair> linkedList = this.f42530d;
        if (linkedList != null) {
            int i = 0;
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null) {
                    String name = next.getName();
                    String value = next.getValue();
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(name + "=");
                    sb.append(k.getUrlEncode(value));
                    i++;
                }
            }
        }
        return sb;
    }

    public void m() {
    }

    public void n(boolean z) {
        this.f42533g = z;
    }

    public void o(boolean z) {
        this.f42532f = z;
    }

    public void p(HashMap<String, String> hashMap) {
        this.f42529c = hashMap;
    }

    public void q(HttpMessageTask.HTTP_METHOD http_method) {
        this.f42528b = http_method;
    }

    public void r(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.f42530d.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.f42531e.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void s(String str) {
        if (str == null) {
            this.f42527a = "";
        } else {
            this.f42527a = str;
        }
    }

    public void t(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.f42529c) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void u(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i;
        if (httpURLConnection != null) {
            String sb = l().toString();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes(sb);
                dataOutputStream.flush();
                d.b.c.e.m.a.d(dataOutputStream);
                i = sb.length();
            } catch (Throwable th) {
                d.b.c.e.m.a.d(dataOutputStream);
                throw th;
            }
        } else {
            i = 0;
        }
        if (dVar != null) {
            dVar.f42515a = i;
        }
    }

    public void v(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        int i;
        m();
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.f42530d != null) {
                    Iterator<BasicNameValuePair> it = this.f42530d.iterator();
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
                if (this.f42531e != null) {
                    for (Map.Entry<String, byte[]> entry : this.f42531e.entrySet()) {
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
                i = dataOutputStream.size();
            } finally {
                d.b.c.e.m.a.d(dataOutputStream);
            }
        } else {
            i = 0;
        }
        if (dVar != null) {
            dVar.f42515a = i;
        }
    }
}
