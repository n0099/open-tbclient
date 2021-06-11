package d.b.d.b.n;

import com.android.internal.http.multipart.Part;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f69711a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f69712b;

    /* renamed from: c  reason: collision with root package name */
    public String f69713c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69714d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f69715e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f69716f;

    public d(String str, String str2, boolean z) throws IOException {
        this.f69713c = str2;
        this.f69714d = z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f69712b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f69712b.setDoOutput(true);
        this.f69712b.setDoInput(true);
        this.f69712b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f69712b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f69711a);
        if (z) {
            this.f69712b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f69716f = new GZIPOutputStream(this.f69712b.getOutputStream());
            return;
        }
        this.f69715e = new DataOutputStream(this.f69712b.getOutputStream());
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f69711a + "--" + Part.CRLF).getBytes();
        if (this.f69714d) {
            this.f69716f.write(bytes);
            this.f69716f.finish();
            this.f69716f.close();
        } else {
            this.f69715e.write(bytes);
            this.f69715e.flush();
            this.f69715e.close();
        }
        int responseCode = this.f69712b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f69712b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f69712b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }

    public void b(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f69711a);
        sb.append(Part.CRLF);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        sb.append(Part.CRLF);
        sb.append("Content-Transfer-Encoding: binary");
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        if (this.f69714d) {
            this.f69716f.write(sb.toString().getBytes());
        } else {
            this.f69715e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f69714d) {
                this.f69716f.write(bArr, 0, read);
            } else {
                this.f69715e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f69714d) {
            this.f69716f.write(Part.CRLF.getBytes());
            return;
        }
        this.f69715e.write(sb.toString().getBytes());
        this.f69715e.flush();
    }

    public void c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f69711a);
        sb.append(Part.CRLF);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(Part.CRLF);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.f69713c);
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        sb.append(str2);
        sb.append(Part.CRLF);
        try {
            if (this.f69714d) {
                this.f69716f.write(sb.toString().getBytes());
            } else {
                this.f69715e.write(sb.toString().getBytes());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
