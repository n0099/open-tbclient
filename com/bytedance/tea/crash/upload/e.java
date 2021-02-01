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
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f7681a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f7682b;
    private String c;
    private boolean d;
    private DataOutputStream pwg;
    private GZIPOutputStream pwh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        this.f7682b = (HttpURLConnection) new URL(str).openConnection();
        this.f7682b.setUseCaches(false);
        this.f7682b.setDoOutput(true);
        this.f7682b.setDoInput(true);
        this.f7682b.setRequestMethod("POST");
        this.f7682b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f7681a);
        if (z) {
            this.f7682b.setRequestProperty("Content-Encoding", "gzip");
            this.pwh = new GZIPOutputStream(this.f7682b.getOutputStream());
            return;
        }
        this.pwg = new DataOutputStream(this.f7682b.getOutputStream());
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7681a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.c).append("\r\n").append("\r\n").append(str2).append("\r\n");
        try {
            if (this.d) {
                this.pwh.write(sb.toString().getBytes());
            } else {
                this.pwg.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7681a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.d) {
            this.pwh.write(sb.toString().getBytes());
        } else {
            this.pwg.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.pwh.write(bArr, 0, read);
            } else {
                this.pwg.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.pwh.write("\r\n".getBytes());
            return;
        }
        this.pwg.write(sb.toString().getBytes());
        this.pwg.flush();
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f7681a + "--\r\n").getBytes();
        if (this.d) {
            this.pwh.write(bytes);
            this.pwh.finish();
            this.pwh.close();
        } else {
            this.pwg.write(bytes);
            this.pwg.flush();
            this.pwg.close();
        }
        int responseCode = this.f7682b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7682b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f7682b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
