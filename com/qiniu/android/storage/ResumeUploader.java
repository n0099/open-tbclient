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
    private final Client nCA;
    private final long nCZ;
    private final UpCompletionHandler nDN;
    private final UploadOptions nDO;
    private final Configuration nDP;
    private final byte[] nDQ;
    private final String[] nDR;
    private final StringMap nDS;
    private final long nDT;
    private final String nDU;
    private long nDV;
    private UpToken nDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nCA = client;
        this.nDP = configuration;
        this.f = file;
        this.nDU = str2;
        this.nCZ = file.length();
        this.key = str;
        this.nDS = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.nDN = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nDO = uploadOptions == null ? UploadOptions.dMS() : uploadOptions;
        this.nDQ = new byte[configuration.chunkSize];
        this.nDR = new String[(int) (((this.nCZ + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nDT = file.lastModified();
        this.nDW = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dMI() || ep(jSONObject));
    }

    private static boolean ep(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dMI() && !ep(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dMO = dMO();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dMO, 0, this.nDP.nDz.d(this.nDW.token, this.nDP.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nDN.a(this.key, ResponseInfo.a(e, this.nDW), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nDQ, 0, i2);
            this.nDV = Crc32.u(this.nDQ, 0, i2);
            a(String.format("%s%s", str, format), this.nDQ, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nDN.a(this.key, ResponseInfo.a(e, this.nDW), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nDQ, 0, i);
            this.nDV = Crc32.u(this.nDQ, 0, i);
            a(String.format("%s%s", str, format), this.nDQ, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nDN.a(this.key, ResponseInfo.a(e, this.nDW), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.RM(this.nDO.mimeType), UrlSafeBase64.RM(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.RM(this.key));
        }
        String str3 = "";
        if (this.nDO.params.size() != 0) {
            String[] strArr = new String[this.nDO.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nDO.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.RM(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nCZ), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nDR, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nCA.a(str, bArr, i, i2, this.nDS, this.nDW, this.nCZ, progressHandler, completionHandler, upCancellationSignal);
    }

    private long ge(long j) {
        long j2 = this.nCZ - j;
        return j2 < ((long) this.nDP.chunkSize) ? j2 : this.nDP.chunkSize;
    }

    private long gf(long j) {
        long j2 = this.nCZ - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nDO.nEn.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nDN.a(this.key, ResponseInfo.b(this.nDW), null);
        } else if (j == this.nCZ) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dMD() && !AndroidNetwork.dMT()) {
                        ResumeUploader.this.nDO.nEo.dMN();
                        if (!AndroidNetwork.dMT()) {
                            ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dMC()) {
                        ResumeUploader.this.dMP();
                        ResumeUploader.this.nDO.nEm.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dMG() || i >= ResumeUploader.this.nDP.nDw + 1 || (d = ResumeUploader.this.nDP.nDz.d(ResumeUploader.this.nDW.token, ResumeUploader.this.nDP.useHttps, str)) == null) {
                        ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nDO.nEn);
        } else {
            final int ge = (int) ge(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nDO.nEm.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dMD() && !AndroidNetwork.dMT()) {
                        ResumeUploader.this.nDO.nEo.dMN();
                        if (!AndroidNetwork.dMT()) {
                            ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nDP.nDz.d(ResumeUploader.this.nDW.token, ResumeUploader.this.nDP.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nDP.nDw) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dMG()) || i >= ResumeUploader.this.nDP.nDw)) {
                            ResumeUploader.this.nDN.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nDP.nDw) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nDP.nDz.d(ResumeUploader.this.nDW.token, ResumeUploader.this.nDP.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nDV) && i < ResumeUploader.this.nDP.nDw) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nDP.nDz.d(ResumeUploader.this.nDW.token, ResumeUploader.this.nDP.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nDR[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gg(j + ge);
                        ResumeUploader.this.a(j + ge, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gf(j), ge, progressHandler, completionHandler, this.nDO.nEn);
            } else {
                a(str, j, ge, this.nDR[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nDO.nEn);
            }
        }
    }

    private long dMO() {
        byte[] bArr;
        if (this.nDP.nDs == null || (bArr = this.nDP.nDs.get(this.nDU)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nDT || optLong3 != this.nCZ || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nDR[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMP() {
        if (this.nDP.nDs != null) {
            this.nDP.nDs.RH(this.nDU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(long j) {
        if (this.nDP.nDs != null && j != 0) {
            this.nDP.nDs.q(this.nDU, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nCZ), Long.valueOf(j), Long.valueOf(this.nDT), StringUtils.W(this.nDR)).getBytes());
        }
    }
}
