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
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f65251a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f65252b;

    /* renamed from: c  reason: collision with root package name */
    public String f65253c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65254d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f65255e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f65256f;

    public d(String str, String str2, boolean z) throws IOException {
        this.f65253c = str2;
        this.f65254d = z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f65252b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f65252b.setDoOutput(true);
        this.f65252b.setDoInput(true);
        this.f65252b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f65252b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f65251a);
        if (z) {
            this.f65252b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f65256f = new GZIPOutputStream(this.f65252b.getOutputStream());
            return;
        }
        this.f65255e = new DataOutputStream(this.f65252b.getOutputStream());
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f65251a + "--" + Part.CRLF).getBytes();
        if (this.f65254d) {
            this.f65256f.write(bytes);
            this.f65256f.finish();
            this.f65256f.close();
        } else {
            this.f65255e.write(bytes);
            this.f65255e.flush();
            this.f65255e.close();
        }
        int responseCode = this.f65252b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f65252b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f65252b.disconnect();
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
        sb.append(this.f65251a);
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
        if (this.f65254d) {
            this.f65256f.write(sb.toString().getBytes());
        } else {
            this.f65255e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f65254d) {
                this.f65256f.write(bArr, 0, read);
            } else {
                this.f65255e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f65254d) {
            this.f65256f.write(Part.CRLF.getBytes());
            return;
        }
        this.f65255e.write(sb.toString().getBytes());
        this.f65255e.flush();
    }

    public void c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f65251a);
        sb.append(Part.CRLF);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(Part.CRLF);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.f65253c);
        sb.append(Part.CRLF);
        sb.append(Part.CRLF);
        sb.append(str2);
        sb.append(Part.CRLF);
        try {
            if (this.f65254d) {
                this.f65256f.write(sb.toString().getBytes());
            } else {
                this.f65255e.write(sb.toString().getBytes());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
