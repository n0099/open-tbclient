package com.qiniu.android.storage;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
final class ResumeUploader implements Runnable {
    private File f;
    private RandomAccessFile file = null;
    private final String key;
    private final long nLM;
    private final Client nLn;
    private final UpCompletionHandler nMA;
    private final UploadOptions nMB;
    private final Configuration nMC;
    private final byte[] nMD;
    private final String[] nME;
    private final StringMap nMF;
    private final long nMG;
    private final String nMH;
    private long nMI;
    private UpToken nMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nLn = client;
        this.nMC = configuration;
        this.f = file;
        this.nMH = str2;
        this.nLM = file.length();
        this.key = str;
        this.nMF = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.nMA = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
            @Override // com.qiniu.android.storage.UpCompletionHandler
            public void a(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                if (ResumeUploader.this.file != null) {
                    try {
                        ResumeUploader.this.file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                upCompletionHandler.a(str3, responseInfo, jSONObject);
            }
        };
        this.nMB = uploadOptions == null ? UploadOptions.dQt() : uploadOptions;
        this.nMD = new byte[configuration.chunkSize];
        this.nME = new String[(int) (((this.nLM + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nMG = file.lastModified();
        this.nMJ = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dQj() || ew(jSONObject));
    }

    private static boolean ew(JSONObject jSONObject) {
        try {
            jSONObject.getString("ctx");
            jSONObject.getLong("crc32");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dQj() && !ew(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dQp = dQp();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dQp, 0, this.nMC.nMm.d(this.nMJ.token, this.nMC.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nMA.a(this.key, ResponseInfo.a(e, this.nMJ), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nMD, 0, i2);
            this.nMI = Crc32.v(this.nMD, 0, i2);
            a(String.format("%s%s", str, format), this.nMD, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nMA.a(this.key, ResponseInfo.a(e, this.nMJ), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nMD, 0, i);
            this.nMI = Crc32.v(this.nMD, 0, i);
            a(String.format("%s%s", str, format), this.nMD, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nMA.a(this.key, ResponseInfo.a(e, this.nMJ), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Sy(this.nMB.mimeType), UrlSafeBase64.Sy(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Sy(this.key));
        }
        String str3 = "";
        if (this.nMB.params.size() != 0) {
            String[] strArr = new String[this.nMB.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nMB.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Sy(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nLM), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nME, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nLn.a(str, bArr, i, i2, this.nMF, this.nMJ, this.nLM, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gr(long j) {
        long j2 = this.nLM - j;
        return j2 < ((long) this.nMC.chunkSize) ? j2 : this.nMC.chunkSize;
    }

    private long gs(long j) {
        long j2 = this.nLM - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nMB.nNa.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nMA.a(this.key, ResponseInfo.b(this.nMJ), null);
        } else if (j == this.nLM) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dQe() && !AndroidNetwork.dQu()) {
                        ResumeUploader.this.nMB.nNb.dQo();
                        if (!AndroidNetwork.dQu()) {
                            ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dQd()) {
                        ResumeUploader.this.dQq();
                        ResumeUploader.this.nMB.nMZ.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dQh() || i >= ResumeUploader.this.nMC.nMj + 1 || (d = ResumeUploader.this.nMC.nMm.d(ResumeUploader.this.nMJ.token, ResumeUploader.this.nMC.useHttps, str)) == null) {
                        ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nMB.nNa);
        } else {
            final int gr = (int) gr(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nMB.nMZ.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dQe() && !AndroidNetwork.dQu()) {
                        ResumeUploader.this.nMB.nNb.dQo();
                        if (!AndroidNetwork.dQu()) {
                            ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nMC.nMm.d(ResumeUploader.this.nMJ.token, ResumeUploader.this.nMC.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nMC.nMj) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dQh()) || i >= ResumeUploader.this.nMC.nMj)) {
                            ResumeUploader.this.nMA.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nMC.nMj) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nMC.nMm.d(ResumeUploader.this.nMJ.token, ResumeUploader.this.nMC.useHttps, str));
                            return;
                        }
                        try {
                            str3 = jSONObject.getString("ctx");
                            str2 = str3;
                            j2 = jSONObject.getLong("crc32");
                        } catch (Exception e) {
                            e.printStackTrace();
                            str2 = str3;
                            j2 = 0;
                        }
                        if ((str2 == null || j2 != ResumeUploader.this.nMI) && i < ResumeUploader.this.nMC.nMj) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nMC.nMm.d(ResumeUploader.this.nMJ.token, ResumeUploader.this.nMC.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nME[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gt(j + gr);
                        ResumeUploader.this.a(j + gr, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gs(j), gr, progressHandler, completionHandler, this.nMB.nNa);
            } else {
                a(str, j, gr, this.nME[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nMB.nNa);
            }
        }
    }

    private long dQp() {
        byte[] bArr;
        if (this.nMC.nMf == null || (bArr = this.nMC.nMf.get(this.nMH)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nMG || optLong3 != this.nLM || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nME[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQq() {
        if (this.nMC.nMf != null) {
            this.nMC.nMf.St(this.nMH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(long j) {
        if (this.nMC.nMf != null && j != 0) {
            this.nMC.nMf.q(this.nMH, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nLM), Long.valueOf(j), Long.valueOf(this.nMG), StringUtils.U(this.nME)).getBytes());
        }
    }
}
