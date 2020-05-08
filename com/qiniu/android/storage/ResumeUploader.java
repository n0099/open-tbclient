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
    private final long mLV;
    private final Client mLw;
    private final UpCompletionHandler mMJ;
    private final UploadOptions mMK;
    private final Configuration mML;
    private final byte[] mMM;
    private final String[] mMN;
    private final StringMap mMO;
    private final long mMP;
    private final String mMQ;
    private long mMR;
    private UpToken mMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.mLw = client;
        this.mML = configuration;
        this.f = file;
        this.mMQ = str2;
        this.mLV = file.length();
        this.key = str;
        this.mMO = new StringMap().L("Authorization", "UpToken " + upToken.token);
        this.mMJ = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.mMK = uploadOptions == null ? UploadOptions.dAE() : uploadOptions;
        this.mMM = new byte[configuration.chunkSize];
        this.mMN = new String[(int) (((this.mLV + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.mMP = file.lastModified();
        this.mMS = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dAu() || dY(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dAu() && !dY(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dAA = dAA();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dAA, 0, this.mML.mMv.d(this.mMS.token, this.mML.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.mMJ.a(this.key, ResponseInfo.a(e, this.mMS), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.mMM, 0, i2);
            this.mMR = Crc32.t(this.mMM, 0, i2);
            a(String.format("%s%s", str, format), this.mMM, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.mMJ.a(this.key, ResponseInfo.a(e, this.mMS), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.mMM, 0, i);
            this.mMR = Crc32.t(this.mMM, 0, i);
            a(String.format("%s%s", str, format), this.mMM, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.mMJ.a(this.key, ResponseInfo.a(e, this.mMS), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Pj(this.mMK.mimeType), UrlSafeBase64.Pj(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Pj(this.key));
        }
        String str3 = "";
        if (this.mMK.params.size() != 0) {
            String[] strArr = new String[this.mMK.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.mMK.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Pj(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.mLV), format, str2, str3);
        byte[] bytes = StringUtils.b(this.mMN, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.mLw.a(str, bArr, i, i2, this.mMO, this.mMS, this.mLV, progressHandler, completionHandler, upCancellationSignal);
    }

    private long fZ(long j) {
        long j2 = this.mLV - j;
        return j2 < ((long) this.mML.chunkSize) ? j2 : this.mML.chunkSize;
    }

    private long ga(long j) {
        long j2 = this.mLV - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.mMK.mNj.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.mMJ.a(this.key, ResponseInfo.b(this.mMS), null);
        } else if (j == this.mLV) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dAp() && !AndroidNetwork.dAF()) {
                        ResumeUploader.this.mMK.mNk.dAz();
                        if (!AndroidNetwork.dAF()) {
                            ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dAo()) {
                        ResumeUploader.this.dAB();
                        ResumeUploader.this.mMK.mNi.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dAs() || i >= ResumeUploader.this.mML.mMs + 1 || (d = ResumeUploader.this.mML.mMv.d(ResumeUploader.this.mMS.token, ResumeUploader.this.mML.useHttps, str)) == null) {
                        ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.mMK.mNj);
        } else {
            final int fZ = (int) fZ(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.mMK.mNi.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dAp() && !AndroidNetwork.dAF()) {
                        ResumeUploader.this.mMK.mNk.dAz();
                        if (!AndroidNetwork.dAF()) {
                            ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.mML.mMv.d(ResumeUploader.this.mMS.token, ResumeUploader.this.mML.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.mML.mMs) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dAs()) || i >= ResumeUploader.this.mML.mMs)) {
                            ResumeUploader.this.mMJ.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.mML.mMs) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.mML.mMv.d(ResumeUploader.this.mMS.token, ResumeUploader.this.mML.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.mMR) && i < ResumeUploader.this.mML.mMs) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.mML.mMv.d(ResumeUploader.this.mMS.token, ResumeUploader.this.mML.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.mMN[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gb(j + fZ);
                        ResumeUploader.this.a(j + fZ, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) ga(j), fZ, progressHandler, completionHandler, this.mMK.mNj);
            } else {
                a(str, j, fZ, this.mMN[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.mMK.mNj);
            }
        }
    }

    private long dAA() {
        byte[] bArr;
        if (this.mML.mMo == null || (bArr = this.mML.mMo.get(this.mMQ)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.mMP || optLong3 != this.mLV || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mMN[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAB() {
        if (this.mML.mMo != null) {
            this.mML.mMo.Pe(this.mMQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(long j) {
        if (this.mML.mMo != null && j != 0) {
            this.mML.mMo.q(this.mMQ, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.mLV), Long.valueOf(j), Long.valueOf(this.mMP), StringUtils.U(this.mMN)).getBytes());
        }
    }
}
