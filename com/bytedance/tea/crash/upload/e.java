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
    private final String f5197a = "AAA" + System.currentTimeMillis() + "AAA";
    private String c;
    private boolean d;
    private HttpURLConnection pyK;
    private DataOutputStream pyL;
    private GZIPOutputStream pyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        this.pyK = (HttpURLConnection) new URL(str).openConnection();
        this.pyK.setUseCaches(false);
        this.pyK.setDoOutput(true);
        this.pyK.setDoInput(true);
        this.pyK.setRequestMethod("POST");
        this.pyK.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f5197a);
        if (z) {
            this.pyK.setRequestProperty("Content-Encoding", "gzip");
            this.pyM = new GZIPOutputStream(this.pyK.getOutputStream());
            return;
        }
        this.pyL = new DataOutputStream(this.pyK.getOutputStream());
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f5197a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.c).append("\r\n").append("\r\n").append(str2).append("\r\n");
        try {
            if (this.d) {
                this.pyM.write(sb.toString().getBytes());
            } else {
                this.pyL.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.f5197a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.d) {
            this.pyM.write(sb.toString().getBytes());
        } else {
            this.pyL.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.pyM.write(bArr, 0, read);
            } else {
                this.pyL.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.pyM.write("\r\n".getBytes());
            return;
        }
        this.pyL.write(sb.toString().getBytes());
        this.pyL.flush();
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f5197a + "--\r\n").getBytes();
        if (this.d) {
            this.pyM.write(bytes);
            this.pyM.finish();
            this.pyM.close();
        } else {
            this.pyL.write(bytes);
            this.pyL.flush();
            this.pyL.close();
        }
        int responseCode = this.pyK.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.pyK.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.pyK.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
