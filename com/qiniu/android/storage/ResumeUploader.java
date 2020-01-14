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
/* loaded from: classes4.dex */
final class ResumeUploader implements Runnable {
    private File f;
    private RandomAccessFile file = null;
    private final String key;
    private final long nmG;
    private final Client nmh;
    private final long nnA;
    private final String nnB;
    private long nnC;
    private UpToken nnD;
    private final UpCompletionHandler nnu;
    private final UploadOptions nnv;
    private final Configuration nnw;
    private final byte[] nnx;
    private final String[] nny;
    private final StringMap nnz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nmh = client;
        this.nnw = configuration;
        this.f = file;
        this.nnB = str2;
        this.nmG = file.length();
        this.key = str;
        this.nnz = new StringMap().H("Authorization", "UpToken " + upToken.token);
        this.nnu = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nnv = uploadOptions == null ? UploadOptions.dEW() : uploadOptions;
        this.nnx = new byte[configuration.chunkSize];
        this.nny = new String[(int) (((this.nmG + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nnA = file.lastModified();
        this.nnD = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dEL() || dV(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dEL() && !dV(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dES = dES();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dES, 0, this.nnw.nng.d(this.nnD.token, this.nnw.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nnu.a(this.key, ResponseInfo.a(e, this.nnD), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nnx, 0, i2);
            this.nnC = Crc32.E(this.nnx, 0, i2);
            a(String.format("%s%s", str, format), this.nnx, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnu.a(this.key, ResponseInfo.a(e, this.nnD), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nnx, 0, i);
            this.nnC = Crc32.E(this.nnx, 0, i);
            a(String.format("%s%s", str, format), this.nnx, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnu.a(this.key, ResponseInfo.a(e, this.nnD), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Rk(this.nnv.mimeType), UrlSafeBase64.Rk(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Rk(this.key));
        }
        String str3 = "";
        if (this.nnv.params.size() != 0) {
            String[] strArr = new String[this.nnv.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nnv.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Rk(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nmG), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nny, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nmh.a(str, bArr, i, i2, this.nnz, this.nnD, this.nmG, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gY(long j) {
        long j2 = this.nmG - j;
        return j2 < ((long) this.nnw.chunkSize) ? j2 : this.nnw.chunkSize;
    }

    private long gZ(long j) {
        long j2 = this.nmG - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nnv.nnU.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nnu.a(this.key, ResponseInfo.b(this.nnD), null);
        } else if (j == this.nmG) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dEG() && !AndroidNetwork.dEX()) {
                        ResumeUploader.this.nnv.nnV.dER();
                        if (!AndroidNetwork.dEX()) {
                            ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dEF()) {
                        ResumeUploader.this.dET();
                        ResumeUploader.this.nnv.nnT.a(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dEJ() || i >= ResumeUploader.this.nnw.nnd + 1 || (d = ResumeUploader.this.nnw.nng.d(ResumeUploader.this.nnD.token, ResumeUploader.this.nnw.useHttps, str)) == null) {
                        ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nnv.nnU);
        } else {
            final int gY = (int) gY(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nnv.nnT.a(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dEG() && !AndroidNetwork.dEX()) {
                        ResumeUploader.this.nnv.nnV.dER();
                        if (!AndroidNetwork.dEX()) {
                            ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nnw.nng.d(ResumeUploader.this.nnD.token, ResumeUploader.this.nnw.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nnw.nnd) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dEJ()) || i >= ResumeUploader.this.nnw.nnd)) {
                            ResumeUploader.this.nnu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nnw.nnd) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnw.nng.d(ResumeUploader.this.nnD.token, ResumeUploader.this.nnw.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nnC) && i < ResumeUploader.this.nnw.nnd) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnw.nng.d(ResumeUploader.this.nnD.token, ResumeUploader.this.nnw.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nny[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.ha(j + gY);
                        ResumeUploader.this.a(j + gY, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gZ(j), gY, progressHandler, completionHandler, this.nnv.nnU);
            } else {
                a(str, j, gY, this.nny[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nnv.nnU);
            }
        }
    }

    private long dES() {
        byte[] bArr;
        if (this.nnw.nmZ == null || (bArr = this.nnw.nmZ.get(this.nnB)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nnA || optLong3 != this.nmG || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nny[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dET() {
        if (this.nnw.nmZ != null) {
            this.nnw.nmZ.Rf(this.nnB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(long j) {
        if (this.nnw.nmZ != null && j != 0) {
            this.nnw.nmZ.q(this.nnB, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nmG), Long.valueOf(j), Long.valueOf(this.nnA), StringUtils.U(this.nny)).getBytes());
        }
    }
}
