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
    private final long nLK;
    private final Client nLl;
    private final Configuration nMA;
    private final byte[] nMB;
    private final String[] nMC;
    private final StringMap nMD;
    private final long nME;
    private final String nMF;
    private long nMG;
    private UpToken nMH;
    private final UpCompletionHandler nMy;
    private final UploadOptions nMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nLl = client;
        this.nMA = configuration;
        this.f = file;
        this.nMF = str2;
        this.nLK = file.length();
        this.key = str;
        this.nMD = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.nMy = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nMz = uploadOptions == null ? UploadOptions.dQs() : uploadOptions;
        this.nMB = new byte[configuration.chunkSize];
        this.nMC = new String[(int) (((this.nLK + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nME = file.lastModified();
        this.nMH = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dQi() || ew(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dQi() && !ew(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dQo = dQo();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dQo, 0, this.nMA.nMk.d(this.nMH.token, this.nMA.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nMy.a(this.key, ResponseInfo.a(e, this.nMH), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nMB, 0, i2);
            this.nMG = Crc32.v(this.nMB, 0, i2);
            a(String.format("%s%s", str, format), this.nMB, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nMy.a(this.key, ResponseInfo.a(e, this.nMH), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nMB, 0, i);
            this.nMG = Crc32.v(this.nMB, 0, i);
            a(String.format("%s%s", str, format), this.nMB, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nMy.a(this.key, ResponseInfo.a(e, this.nMH), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Sy(this.nMz.mimeType), UrlSafeBase64.Sy(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Sy(this.key));
        }
        String str3 = "";
        if (this.nMz.params.size() != 0) {
            String[] strArr = new String[this.nMz.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nMz.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Sy(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nLK), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nMC, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nLl.a(str, bArr, i, i2, this.nMD, this.nMH, this.nLK, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gr(long j) {
        long j2 = this.nLK - j;
        return j2 < ((long) this.nMA.chunkSize) ? j2 : this.nMA.chunkSize;
    }

    private long gs(long j) {
        long j2 = this.nLK - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nMz.nMY.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nMy.a(this.key, ResponseInfo.b(this.nMH), null);
        } else if (j == this.nLK) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dQd() && !AndroidNetwork.dQt()) {
                        ResumeUploader.this.nMz.nMZ.dQn();
                        if (!AndroidNetwork.dQt()) {
                            ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dQc()) {
                        ResumeUploader.this.dQp();
                        ResumeUploader.this.nMz.nMX.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dQg() || i >= ResumeUploader.this.nMA.nMh + 1 || (d = ResumeUploader.this.nMA.nMk.d(ResumeUploader.this.nMH.token, ResumeUploader.this.nMA.useHttps, str)) == null) {
                        ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nMz.nMY);
        } else {
            final int gr = (int) gr(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nMz.nMX.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dQd() && !AndroidNetwork.dQt()) {
                        ResumeUploader.this.nMz.nMZ.dQn();
                        if (!AndroidNetwork.dQt()) {
                            ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nMA.nMk.d(ResumeUploader.this.nMH.token, ResumeUploader.this.nMA.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nMA.nMh) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dQg()) || i >= ResumeUploader.this.nMA.nMh)) {
                            ResumeUploader.this.nMy.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nMA.nMh) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nMA.nMk.d(ResumeUploader.this.nMH.token, ResumeUploader.this.nMA.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nMG) && i < ResumeUploader.this.nMA.nMh) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nMA.nMk.d(ResumeUploader.this.nMH.token, ResumeUploader.this.nMA.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nMC[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gt(j + gr);
                        ResumeUploader.this.a(j + gr, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gs(j), gr, progressHandler, completionHandler, this.nMz.nMY);
            } else {
                a(str, j, gr, this.nMC[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nMz.nMY);
            }
        }
    }

    private long dQo() {
        byte[] bArr;
        if (this.nMA.nMd == null || (bArr = this.nMA.nMd.get(this.nMF)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nME || optLong3 != this.nLK || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nMC[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQp() {
        if (this.nMA.nMd != null) {
            this.nMA.nMd.St(this.nMF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(long j) {
        if (this.nMA.nMd != null && j != 0) {
            this.nMA.nMd.q(this.nMF, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nLK), Long.valueOf(j), Long.valueOf(this.nME), StringUtils.U(this.nMC)).getBytes());
        }
    }
}
