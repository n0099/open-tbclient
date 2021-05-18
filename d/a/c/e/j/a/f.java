package d.a.c.e.j.a;

import com.android.internal.http.multipart.Part;
import com.baidu.adp.framework.task.HttpMessageTask;
import d.a.c.e.p.k;
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
    public HttpMessageTask.HTTP_METHOD f38971b;

    /* renamed from: a  reason: collision with root package name */
    public String f38970a = "";

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f38972c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f38973d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, byte[]> f38974e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f38975f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38976g = false;

    public void a(String str, String str2) {
        Map<String, String> map = this.f38972c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void b(String str, String str2) {
        this.f38973d.add(new BasicNameValuePair(str, str2));
    }

    public void c(String str, byte[] bArr) {
        this.f38974e.put(str, bArr);
    }

    public void d(BasicNameValuePair basicNameValuePair) {
        this.f38973d.add(basicNameValuePair);
    }

    public boolean e() {
        return this.f38975f;
    }

    public String f(d dVar) {
        if (this.f38973d.size() == 0) {
            if (dVar != null) {
                dVar.f38957a = this.f38970a.length();
            }
            return this.f38970a;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.f38970a);
        if (this.f38970a.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.f38970a.endsWith("?") && !this.f38970a.endsWith("&")) {
            sb.append("&");
        }
        for (int i2 = 0; i2 < this.f38973d.size(); i2++) {
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(this.f38973d.get(i2).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.f38973d.get(i2).getValue()));
        }
        if (dVar != null) {
            dVar.f38957a = sb.length();
        }
        return sb.toString();
    }

    public String g(String str) {
        Map<String, String> map = this.f38972c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public HttpMessageTask.HTTP_METHOD h() {
        return this.f38971b;
    }

    public String i() {
        return this.f38970a;
    }

    public boolean j() {
        HashMap<String, byte[]> hashMap = this.f38974e;
        return hashMap != null && hashMap.size() > 0;
    }

    public boolean k() {
        return this.f38976g;
    }

    public final StringBuilder l() {
        StringBuilder sb = new StringBuilder(1024);
        LinkedList<BasicNameValuePair> linkedList = this.f38973d;
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

    public void m() {
    }

    public void n(boolean z) {
        this.f38976g = z;
    }

    public void o(boolean z) {
        this.f38975f = z;
    }

    public void p(HashMap<String, String> hashMap) {
        this.f38972c = hashMap;
    }

    public void q(HttpMessageTask.HTTP_METHOD http_method) {
        this.f38971b = http_method;
    }

    public void r(List<Map.Entry<String, Object>> list) {
        if (list != null) {
            for (Map.Entry<String, Object> entry : list) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof String) {
                        this.f38973d.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                    } else if (value instanceof byte[]) {
                        this.f38974e.put(entry.getKey(), (byte[]) entry.getValue());
                    } else {
                        throw new UnsupportedOperationException("post type is not String and byte[]");
                    }
                }
            }
        }
    }

    public void s(String str) {
        if (str == null) {
            this.f38970a = "";
        } else {
            this.f38970a = str;
        }
    }

    public void t(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.f38972c) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void u(HttpURLConnection httpURLConnection, d dVar) throws Exception {
        int i2;
        if (httpURLConnection != null) {
            String sb = l().toString();
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
        if (dVar != null) {
            dVar.f38957a = i2;
        }
    }

    public void v(HttpURLConnection httpURLConnection, String str, d dVar) throws Exception {
        int i2;
        m();
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.f38973d != null) {
                    Iterator<BasicNameValuePair> it = this.f38973d.iterator();
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
                if (this.f38974e != null) {
                    for (Map.Entry<String, byte[]> entry : this.f38974e.entrySet()) {
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
        if (dVar != null) {
            dVar.f38957a = i2;
        }
    }
}
