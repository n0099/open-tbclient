package d.b.i0.s2.a0.m;

import com.android.internal.http.multipart.Part;
import d.b.c.e.p.k;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f61577a = "";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f61578b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<BasicNameValuePair> f61579c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, byte[]> f61580d = new HashMap<>();

    public void a(String str, String str2) {
        Map<String, String> map = this.f61578b;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void b(BasicNameValuePair basicNameValuePair) {
        this.f61579c.add(basicNameValuePair);
    }

    public String c(e eVar) {
        if (this.f61579c.size() == 0) {
            if (eVar != null) {
                eVar.f61566a = this.f61577a.length();
            }
            return this.f61577a;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append(this.f61577a);
        if (this.f61577a.indexOf("?") < 0) {
            sb.append("?");
        } else if (!this.f61577a.endsWith("?") && !this.f61577a.endsWith("&")) {
            sb.append("&");
        }
        for (int i = 0; i < this.f61579c.size(); i++) {
            if (i != 0) {
                sb.append("&");
            }
            sb.append(this.f61579c.get(i).getName());
            sb.append("=");
            sb.append(k.getUrlEncode(this.f61579c.get(i).getValue()));
        }
        if (eVar != null) {
            eVar.f61566a = sb.length();
        }
        return sb.toString();
    }

    public String d(String str) {
        Map<String, String> map = this.f61578b;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public String e() {
        return this.f61577a;
    }

    public boolean f() {
        HashMap<String, byte[]> hashMap = this.f61580d;
        return hashMap != null && hashMap.size() > 0;
    }

    public final StringBuilder g() {
        StringBuilder sb = new StringBuilder(1024);
        LinkedList<BasicNameValuePair> linkedList = this.f61579c;
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

    public void h() {
    }

    public void i(String str) {
        if (str == null) {
            this.f61577a = "";
        } else {
            this.f61577a = str;
        }
    }

    public void j(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.f61578b) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void k(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        int i;
        if (httpURLConnection != null) {
            String sb = g().toString();
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
        if (eVar != null) {
            eVar.f61566a = i;
        }
    }

    public void l(HttpURLConnection httpURLConnection, String str, e eVar) throws Exception {
        int i;
        h();
        if (httpURLConnection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                if (this.f61579c != null) {
                    Iterator<BasicNameValuePair> it = this.f61579c.iterator();
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
                if (this.f61580d != null) {
                    for (Map.Entry<String, byte[]> entry : this.f61580d.entrySet()) {
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
        if (eVar != null) {
            eVar.f61566a = i;
        }
    }
}
