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
    public final String f66844a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f66845b;

    /* renamed from: c  reason: collision with root package name */
    public String f66846c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66847d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f66848e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f66849f;

    public d(String str, String str2, boolean z) throws IOException {
        this.f66846c = str2;
        this.f66847d = z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f66845b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f66845b.setDoOutput(true);
        this.f66845b.setDoInput(true);
        this.f66845b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f66845b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f66844a);
        if (z) {
            this.f66845b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f66849f = new GZIPOutputStream(this.f66845b.getOutputStream());
            return;
        }
        this.f66848e = new DataOutputStream(this.f66845b.getOutputStream());
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f66844a + "--" + Part.CRLF).getBytes();
        if (this.f66847d) {
            this.f66849f.write(bytes);
            this.f66849f.finish();
            this.f66849f.close();
        } else {
            this.f66848e.write(bytes);
            this.f66848e.flush();
            this.f66848e.close();
        }
        int responseCode = this.f66845b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f66845b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f66845b.disconnect();
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
        sb.append(this.f66844a);
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
        if (this.f66847d) {
            this.f66849f.write(sb.toString().getBytes());
        } else {
            this.f66848e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f66847d) {
                this.f66849f.write(bArr, 0, read);
            } else {
                this.f66848e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f66847d) {
            this.f66849f.write(Part.CRLF.getBytes());
            return;
        }
        this.f66848e.write(sb.toString().getBytes());
        this.f66848e.flush();
    }

    public void c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f66844a);
        sb.append(Part.CRLF);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(Part.CRLF);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.f66846c);
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        sb.append(str2);
        sb.append(Part.CRLF);
        try {
            if (this.f66847d) {
                this.f66849f.write(sb.toString().getBytes());
            } else {
                this.f66848e.write(sb.toString().getBytes());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
