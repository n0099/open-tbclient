package com.bytedance.tea.crash.upload;

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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f7979a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f7980b;
    private String c;
    private boolean d;
    private DataOutputStream pqv;
    private GZIPOutputStream pqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        this.f7980b = (HttpURLConnection) new URL(str).openConnection();
        this.f7980b.setUseCaches(false);
        this.f7980b.setDoOutput(true);
        this.f7980b.setDoInput(true);
        this.f7980b.setRequestMethod("POST");
        this.f7980b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f7979a);
        if (z) {
            this.f7980b.setRequestProperty("Content-Encoding", "gzip");
            this.pqw = new GZIPOutputStream(this.f7980b.getOutputStream());
            return;
        }
        this.pqv = new DataOutputStream(this.f7980b.getOutputStream());
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7979a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.c).append("\r\n").append("\r\n").append(str2).append("\r\n");
        try {
            if (this.d) {
                this.pqw.write(sb.toString().getBytes());
            } else {
                this.pqv.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7979a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.d) {
            this.pqw.write(sb.toString().getBytes());
        } else {
            this.pqv.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.pqw.write(bArr, 0, read);
            } else {
                this.pqv.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.pqw.write("\r\n".getBytes());
            return;
        }
        this.pqv.write(sb.toString().getBytes());
        this.pqv.flush();
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f7979a + "--\r\n").getBytes();
        if (this.d) {
            this.pqw.write(bytes);
            this.pqw.finish();
            this.pqw.close();
        } else {
            this.pqv.write(bytes);
            this.pqv.flush();
            this.pqv.close();
        }
        int responseCode = this.f7980b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7980b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f7980b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
