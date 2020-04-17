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
    private final long mLS;
    private final Client mLt;
    private final UpCompletionHandler mMG;
    private final UploadOptions mMH;
    private final Configuration mMI;
    private final byte[] mMJ;
    private final String[] mMK;
    private final StringMap mML;
    private final long mMM;
    private final String mMN;
    private long mMO;
    private UpToken mMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.mLt = client;
        this.mMI = configuration;
        this.f = file;
        this.mMN = str2;
        this.mLS = file.length();
        this.key = str;
        this.mML = new StringMap().L("Authorization", "UpToken " + upToken.token);
        this.mMG = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.mMH = uploadOptions == null ? UploadOptions.dAI() : uploadOptions;
        this.mMJ = new byte[configuration.chunkSize];
        this.mMK = new String[(int) (((this.mLS + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.mMM = file.lastModified();
        this.mMP = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dAy() || dY(jSONObject));
    }

    private static boolean dY(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dAy() && !dY(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dAE = dAE();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dAE, 0, this.mMI.mMs.d(this.mMP.token, this.mMI.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.mMG.a(this.key, ResponseInfo.a(e, this.mMP), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.mMJ, 0, i2);
            this.mMO = Crc32.t(this.mMJ, 0, i2);
            a(String.format("%s%s", str, format), this.mMJ, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.mMG.a(this.key, ResponseInfo.a(e, this.mMP), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.mMJ, 0, i);
            this.mMO = Crc32.t(this.mMJ, 0, i);
            a(String.format("%s%s", str, format), this.mMJ, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.mMG.a(this.key, ResponseInfo.a(e, this.mMP), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Pg(this.mMH.mimeType), UrlSafeBase64.Pg(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Pg(this.key));
        }
        String str3 = "";
        if (this.mMH.params.size() != 0) {
            String[] strArr = new String[this.mMH.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.mMH.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Pg(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.mLS), format, str2, str3);
        byte[] bytes = StringUtils.b(this.mMK, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.mLt.a(str, bArr, i, i2, this.mML, this.mMP, this.mLS, progressHandler, completionHandler, upCancellationSignal);
    }

    private long fZ(long j) {
        long j2 = this.mLS - j;
        return j2 < ((long) this.mMI.chunkSize) ? j2 : this.mMI.chunkSize;
    }

    private long ga(long j) {
        long j2 = this.mLS - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.mMH.mNg.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.mMG.a(this.key, ResponseInfo.b(this.mMP), null);
        } else if (j == this.mLS) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dAt() && !AndroidNetwork.dAJ()) {
                        ResumeUploader.this.mMH.mNh.dAD();
                        if (!AndroidNetwork.dAJ()) {
                            ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dAs()) {
                        ResumeUploader.this.dAF();
                        ResumeUploader.this.mMH.mNf.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dAw() || i >= ResumeUploader.this.mMI.mMp + 1 || (d = ResumeUploader.this.mMI.mMs.d(ResumeUploader.this.mMP.token, ResumeUploader.this.mMI.useHttps, str)) == null) {
                        ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.mMH.mNg);
        } else {
            final int fZ = (int) fZ(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.mMH.mNf.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dAt() && !AndroidNetwork.dAJ()) {
                        ResumeUploader.this.mMH.mNh.dAD();
                        if (!AndroidNetwork.dAJ()) {
                            ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.mMI.mMs.d(ResumeUploader.this.mMP.token, ResumeUploader.this.mMI.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.mMI.mMp) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dAw()) || i >= ResumeUploader.this.mMI.mMp)) {
                            ResumeUploader.this.mMG.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.mMI.mMp) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.mMI.mMs.d(ResumeUploader.this.mMP.token, ResumeUploader.this.mMI.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.mMO) && i < ResumeUploader.this.mMI.mMp) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.mMI.mMs.d(ResumeUploader.this.mMP.token, ResumeUploader.this.mMI.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.mMK[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gb(j + fZ);
                        ResumeUploader.this.a(j + fZ, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) ga(j), fZ, progressHandler, completionHandler, this.mMH.mNg);
            } else {
                a(str, j, fZ, this.mMK[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.mMH.mNg);
            }
        }
    }

    private long dAE() {
        byte[] bArr;
        if (this.mMI.mMl == null || (bArr = this.mMI.mMl.get(this.mMN)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.mMM || optLong3 != this.mLS || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mMK[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAF() {
        if (this.mMI.mMl != null) {
            this.mMI.mMl.Pb(this.mMN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(long j) {
        if (this.mMI.mMl != null && j != 0) {
            this.mMI.mMl.q(this.mMN, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.mLS), Long.valueOf(j), Long.valueOf(this.mMM), StringUtils.U(this.mMK)).getBytes());
        }
    }
}
