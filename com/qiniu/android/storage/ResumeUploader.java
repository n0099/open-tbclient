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
    private final long nmB;
    private final Client nmc;
    private final UpCompletionHandler nnp;
    private final UploadOptions nnq;
    private final Configuration nnr;
    private final byte[] nns;
    private final String[] nnt;
    private final StringMap nnu;
    private final long nnv;
    private final String nnw;
    private long nnx;
    private UpToken nny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nmc = client;
        this.nnr = configuration;
        this.f = file;
        this.nnw = str2;
        this.nmB = file.length();
        this.key = str;
        this.nnu = new StringMap().H("Authorization", "UpToken " + upToken.token);
        this.nnp = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nnq = uploadOptions == null ? UploadOptions.dEU() : uploadOptions;
        this.nns = new byte[configuration.chunkSize];
        this.nnt = new String[(int) (((this.nmB + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nnv = file.lastModified();
        this.nny = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dEJ() || dV(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dEJ() && !dV(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dEQ = dEQ();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dEQ, 0, this.nnr.nnb.d(this.nny.token, this.nnr.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nnp.a(this.key, ResponseInfo.a(e, this.nny), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nns, 0, i2);
            this.nnx = Crc32.E(this.nns, 0, i2);
            a(String.format("%s%s", str, format), this.nns, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnp.a(this.key, ResponseInfo.a(e, this.nny), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nns, 0, i);
            this.nnx = Crc32.E(this.nns, 0, i);
            a(String.format("%s%s", str, format), this.nns, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnp.a(this.key, ResponseInfo.a(e, this.nny), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Rk(this.nnq.mimeType), UrlSafeBase64.Rk(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Rk(this.key));
        }
        String str3 = "";
        if (this.nnq.params.size() != 0) {
            String[] strArr = new String[this.nnq.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nnq.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Rk(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nmB), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nnt, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nmc.a(str, bArr, i, i2, this.nnu, this.nny, this.nmB, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gY(long j) {
        long j2 = this.nmB - j;
        return j2 < ((long) this.nnr.chunkSize) ? j2 : this.nnr.chunkSize;
    }

    private long gZ(long j) {
        long j2 = this.nmB - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nnq.nnP.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nnp.a(this.key, ResponseInfo.b(this.nny), null);
        } else if (j == this.nmB) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dEE() && !AndroidNetwork.dEV()) {
                        ResumeUploader.this.nnq.nnQ.dEP();
                        if (!AndroidNetwork.dEV()) {
                            ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dED()) {
                        ResumeUploader.this.dER();
                        ResumeUploader.this.nnq.nnO.a(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dEH() || i >= ResumeUploader.this.nnr.nmY + 1 || (d = ResumeUploader.this.nnr.nnb.d(ResumeUploader.this.nny.token, ResumeUploader.this.nnr.useHttps, str)) == null) {
                        ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nnq.nnP);
        } else {
            final int gY = (int) gY(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nnq.nnO.a(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dEE() && !AndroidNetwork.dEV()) {
                        ResumeUploader.this.nnq.nnQ.dEP();
                        if (!AndroidNetwork.dEV()) {
                            ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nnr.nnb.d(ResumeUploader.this.nny.token, ResumeUploader.this.nnr.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nnr.nmY) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dEH()) || i >= ResumeUploader.this.nnr.nmY)) {
                            ResumeUploader.this.nnp.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nnr.nmY) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnr.nnb.d(ResumeUploader.this.nny.token, ResumeUploader.this.nnr.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nnx) && i < ResumeUploader.this.nnr.nmY) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnr.nnb.d(ResumeUploader.this.nny.token, ResumeUploader.this.nnr.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nnt[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.ha(j + gY);
                        ResumeUploader.this.a(j + gY, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gZ(j), gY, progressHandler, completionHandler, this.nnq.nnP);
            } else {
                a(str, j, gY, this.nnt[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nnq.nnP);
            }
        }
    }

    private long dEQ() {
        byte[] bArr;
        if (this.nnr.nmU == null || (bArr = this.nnr.nmU.get(this.nnw)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nnv || optLong3 != this.nmB || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nnt[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dER() {
        if (this.nnr.nmU != null) {
            this.nnr.nmU.Rf(this.nnw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(long j) {
        if (this.nnr.nmU != null && j != 0) {
            this.nnr.nmU.q(this.nnw, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nmB), Long.valueOf(j), Long.valueOf(this.nnv), StringUtils.U(this.nnt)).getBytes());
        }
    }
}
