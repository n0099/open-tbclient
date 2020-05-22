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
/* loaded from: classes5.dex */
final class ResumeUploader implements Runnable {
    private File f;
    private RandomAccessFile file = null;
    private final String key;
    private final Client nfA;
    private final long nfZ;
    private final UpCompletionHandler ngN;
    private final UploadOptions ngO;
    private final Configuration ngP;
    private final byte[] ngQ;
    private final String[] ngR;
    private final StringMap ngS;
    private final long ngT;
    private final String ngU;
    private long ngV;
    private UpToken ngW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nfA = client;
        this.ngP = configuration;
        this.f = file;
        this.ngU = str2;
        this.nfZ = file.length();
        this.key = str;
        this.ngS = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.ngN = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.ngO = uploadOptions == null ? UploadOptions.dHY() : uploadOptions;
        this.ngQ = new byte[configuration.chunkSize];
        this.ngR = new String[(int) (((this.nfZ + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.ngT = file.lastModified();
        this.ngW = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dHO() || ef(jSONObject));
    }

    private static boolean ef(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dHO() && !ef(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dHU = dHU();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dHU, 0, this.ngP.ngz.d(this.ngW.token, this.ngP.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.ngN.a(this.key, ResponseInfo.a(e, this.ngW), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.ngQ, 0, i2);
            this.ngV = Crc32.u(this.ngQ, 0, i2);
            a(String.format("%s%s", str, format), this.ngQ, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ngN.a(this.key, ResponseInfo.a(e, this.ngW), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.ngQ, 0, i);
            this.ngV = Crc32.u(this.ngQ, 0, i);
            a(String.format("%s%s", str, format), this.ngQ, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ngN.a(this.key, ResponseInfo.a(e, this.ngW), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.QZ(this.ngO.mimeType), UrlSafeBase64.QZ(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.QZ(this.key));
        }
        String str3 = "";
        if (this.ngO.params.size() != 0) {
            String[] strArr = new String[this.ngO.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.ngO.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.QZ(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nfZ), format, str2, str3);
        byte[] bytes = StringUtils.b(this.ngR, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nfA.a(str, bArr, i, i2, this.ngS, this.ngW, this.nfZ, progressHandler, completionHandler, upCancellationSignal);
    }

    private long fZ(long j) {
        long j2 = this.nfZ - j;
        return j2 < ((long) this.ngP.chunkSize) ? j2 : this.ngP.chunkSize;
    }

    private long ga(long j) {
        long j2 = this.nfZ - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.ngO.nhn.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.ngN.a(this.key, ResponseInfo.b(this.ngW), null);
        } else if (j == this.nfZ) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dHJ() && !AndroidNetwork.dHZ()) {
                        ResumeUploader.this.ngO.nho.dHT();
                        if (!AndroidNetwork.dHZ()) {
                            ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dHI()) {
                        ResumeUploader.this.dHV();
                        ResumeUploader.this.ngO.nhm.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dHM() || i >= ResumeUploader.this.ngP.ngw + 1 || (d = ResumeUploader.this.ngP.ngz.d(ResumeUploader.this.ngW.token, ResumeUploader.this.ngP.useHttps, str)) == null) {
                        ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.ngO.nhn);
        } else {
            final int fZ = (int) fZ(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.ngO.nhm.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dHJ() && !AndroidNetwork.dHZ()) {
                        ResumeUploader.this.ngO.nho.dHT();
                        if (!AndroidNetwork.dHZ()) {
                            ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.ngP.ngz.d(ResumeUploader.this.ngW.token, ResumeUploader.this.ngP.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.ngP.ngw) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dHM()) || i >= ResumeUploader.this.ngP.ngw)) {
                            ResumeUploader.this.ngN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.ngP.ngw) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ngP.ngz.d(ResumeUploader.this.ngW.token, ResumeUploader.this.ngP.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.ngV) && i < ResumeUploader.this.ngP.ngw) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ngP.ngz.d(ResumeUploader.this.ngW.token, ResumeUploader.this.ngP.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.ngR[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gb(j + fZ);
                        ResumeUploader.this.a(j + fZ, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) ga(j), fZ, progressHandler, completionHandler, this.ngO.nhn);
            } else {
                a(str, j, fZ, this.ngR[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.ngO.nhn);
            }
        }
    }

    private long dHU() {
        byte[] bArr;
        if (this.ngP.ngs == null || (bArr = this.ngP.ngs.get(this.ngU)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.ngT || optLong3 != this.nfZ || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.ngR[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHV() {
        if (this.ngP.ngs != null) {
            this.ngP.ngs.QU(this.ngU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(long j) {
        if (this.ngP.ngs != null && j != 0) {
            this.ngP.ngs.q(this.ngU, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nfZ), Long.valueOf(j), Long.valueOf(this.ngT), StringUtils.X(this.ngR)).getBytes());
        }
    }
}
