package d.c.d.b.n;

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
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f66749a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f66750b;

    /* renamed from: c  reason: collision with root package name */
    public String f66751c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66752d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f66753e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f66754f;

    public d(String str, String str2, boolean z) throws IOException {
        this.f66751c = str2;
        this.f66752d = z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f66750b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f66750b.setDoOutput(true);
        this.f66750b.setDoInput(true);
        this.f66750b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f66750b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f66749a);
        if (z) {
            this.f66750b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f66754f = new GZIPOutputStream(this.f66750b.getOutputStream());
            return;
        }
        this.f66753e = new DataOutputStream(this.f66750b.getOutputStream());
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f66749a + "--" + Part.CRLF).getBytes();
        if (this.f66752d) {
            this.f66754f.write(bytes);
            this.f66754f.finish();
            this.f66754f.close();
        } else {
            this.f66753e.write(bytes);
            this.f66753e.flush();
            this.f66753e.close();
        }
        int responseCode = this.f66750b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f66750b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f66750b.disconnect();
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
        sb.append(this.f66749a);
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
        if (this.f66752d) {
            this.f66754f.write(sb.toString().getBytes());
        } else {
            this.f66753e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f66752d) {
                this.f66754f.write(bArr, 0, read);
            } else {
                this.f66753e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f66752d) {
            this.f66754f.write(Part.CRLF.getBytes());
            return;
        }
        this.f66753e.write(sb.toString().getBytes());
        this.f66753e.flush();
    }

    public void c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f66749a);
        sb.append(Part.CRLF);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(Part.CRLF);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.f66751c);
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        sb.append(str2);
        sb.append(Part.CRLF);
        try {
            if (this.f66752d) {
                this.f66754f.write(sb.toString().getBytes());
            } else {
                this.f66753e.write(sb.toString().getBytes());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
