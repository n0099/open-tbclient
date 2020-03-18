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
    private final Client noK;
    private final UpCompletionHandler npX;
    private final UploadOptions npY;
    private final Configuration npZ;
    private final long npj;
    private final byte[] nqa;
    private final String[] nqb;
    private final StringMap nqc;
    private final long nqd;
    private final String nqe;
    private long nqf;
    private UpToken nqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.noK = client;
        this.npZ = configuration;
        this.f = file;
        this.nqe = str2;
        this.npj = file.length();
        this.key = str;
        this.nqc = new StringMap().H("Authorization", "UpToken " + upToken.token);
        this.npX = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.npY = uploadOptions == null ? UploadOptions.dGG() : uploadOptions;
        this.nqa = new byte[configuration.chunkSize];
        this.nqb = new String[(int) (((this.npj + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nqd = file.lastModified();
        this.nqg = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dGv() || dV(jSONObject));
    }

    private static boolean dV(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dGv() && !dV(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dGC = dGC();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dGC, 0, this.npZ.npJ.d(this.nqg.token, this.npZ.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.npX.a(this.key, ResponseInfo.a(e, this.nqg), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nqa, 0, i2);
            this.nqf = Crc32.I(this.nqa, 0, i2);
            a(String.format("%s%s", str, format), this.nqa, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.npX.a(this.key, ResponseInfo.a(e, this.nqg), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nqa, 0, i);
            this.nqf = Crc32.I(this.nqa, 0, i);
            a(String.format("%s%s", str, format), this.nqa, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.npX.a(this.key, ResponseInfo.a(e, this.nqg), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Rv(this.npY.mimeType), UrlSafeBase64.Rv(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Rv(this.key));
        }
        String str3 = "";
        if (this.npY.params.size() != 0) {
            String[] strArr = new String[this.npY.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.npY.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Rv(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.npj), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nqb, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.noK.a(str, bArr, i, i2, this.nqc, this.nqg, this.npj, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gX(long j) {
        long j2 = this.npj - j;
        return j2 < ((long) this.npZ.chunkSize) ? j2 : this.npZ.chunkSize;
    }

    private long gY(long j) {
        long j2 = this.npj - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.npY.nqx.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.npX.a(this.key, ResponseInfo.b(this.nqg), null);
        } else if (j == this.npj) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dGq() && !AndroidNetwork.dGH()) {
                        ResumeUploader.this.npY.nqy.dGB();
                        if (!AndroidNetwork.dGH()) {
                            ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dGp()) {
                        ResumeUploader.this.dGD();
                        ResumeUploader.this.npY.nqw.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dGt() || i >= ResumeUploader.this.npZ.npG + 1 || (d = ResumeUploader.this.npZ.npJ.d(ResumeUploader.this.nqg.token, ResumeUploader.this.npZ.useHttps, str)) == null) {
                        ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.npY.nqx);
        } else {
            final int gX = (int) gX(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.npY.nqw.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dGq() && !AndroidNetwork.dGH()) {
                        ResumeUploader.this.npY.nqy.dGB();
                        if (!AndroidNetwork.dGH()) {
                            ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.npZ.npJ.d(ResumeUploader.this.nqg.token, ResumeUploader.this.npZ.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.npZ.npG) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dGt()) || i >= ResumeUploader.this.npZ.npG)) {
                            ResumeUploader.this.npX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.npZ.npG) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.npZ.npJ.d(ResumeUploader.this.nqg.token, ResumeUploader.this.npZ.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nqf) && i < ResumeUploader.this.npZ.npG) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.npZ.npJ.d(ResumeUploader.this.nqg.token, ResumeUploader.this.npZ.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nqb[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gZ(j + gX);
                        ResumeUploader.this.a(j + gX, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gY(j), gX, progressHandler, completionHandler, this.npY.nqx);
            } else {
                a(str, j, gX, this.nqb[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.npY.nqx);
            }
        }
    }

    private long dGC() {
        byte[] bArr;
        if (this.npZ.npC == null || (bArr = this.npZ.npC.get(this.nqe)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nqd || optLong3 != this.npj || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nqb[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGD() {
        if (this.npZ.npC != null) {
            this.npZ.npC.Rq(this.nqe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ(long j) {
        if (this.npZ.npC != null && j != 0) {
            this.npZ.npC.q(this.nqe, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.npj), Long.valueOf(j), Long.valueOf(this.nqd), StringUtils.V(this.nqb)).getBytes());
        }
    }
}
