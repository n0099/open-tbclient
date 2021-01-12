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
    private final String f7679a = "AAA" + System.currentTimeMillis() + "AAA";

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f7680b;
    private String c;
    private boolean d;
    private DataOutputStream plQ;
    private GZIPOutputStream plR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        this.f7680b = (HttpURLConnection) new URL(str).openConnection();
        this.f7680b.setUseCaches(false);
        this.f7680b.setDoOutput(true);
        this.f7680b.setDoInput(true);
        this.f7680b.setRequestMethod("POST");
        this.f7680b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f7679a);
        if (z) {
            this.f7680b.setRequestProperty("Content-Encoding", "gzip");
            this.plR = new GZIPOutputStream(this.f7680b.getOutputStream());
            return;
        }
        this.plQ = new DataOutputStream(this.f7680b.getOutputStream());
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7679a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.c).append("\r\n").append("\r\n").append(str2).append("\r\n");
        try {
            if (this.d) {
                this.plR.write(sb.toString().getBytes());
            } else {
                this.plQ.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f7679a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.d) {
            this.plR.write(sb.toString().getBytes());
        } else {
            this.plQ.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.plR.write(bArr, 0, read);
            } else {
                this.plQ.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.plR.write("\r\n".getBytes());
            return;
        }
        this.plQ.write(sb.toString().getBytes());
        this.plQ.flush();
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f7679a + "--\r\n").getBytes();
        if (this.d) {
            this.plR.write(bytes);
            this.plR.finish();
            this.plR.close();
        } else {
            this.plQ.write(bytes);
            this.plQ.flush();
            this.plQ.close();
        }
        int responseCode = this.f7680b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7680b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f7680b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
