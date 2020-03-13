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
    private final Client nmV;
    private final long nnu;
    private final UpCompletionHandler noi;
    private final UploadOptions noj;
    private final Configuration nok;
    private final byte[] nol;
    private final String[] nom;
    private final StringMap non;
    private final long noo;
    private final String nop;
    private long noq;
    private UpToken nor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nmV = client;
        this.nok = configuration;
        this.f = file;
        this.nop = str2;
        this.nnu = file.length();
        this.key = str;
        this.non = new StringMap().H("Authorization", "UpToken " + upToken.token);
        this.noi = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.noj = uploadOptions == null ? UploadOptions.dGg() : uploadOptions;
        this.nol = new byte[configuration.chunkSize];
        this.nom = new String[(int) (((this.nnu + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.noo = file.lastModified();
        this.nor = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dFV() || dV(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dFV() && !dV(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dGc = dGc();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dGc, 0, this.nok.nnU.d(this.nor.token, this.nok.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.noi.a(this.key, ResponseInfo.a(e, this.nor), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nol, 0, i2);
            this.noq = Crc32.I(this.nol, 0, i2);
            a(String.format("%s%s", str, format), this.nol, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.noi.a(this.key, ResponseInfo.a(e, this.nor), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nol, 0, i);
            this.noq = Crc32.I(this.nol, 0, i);
            a(String.format("%s%s", str, format), this.nol, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.noi.a(this.key, ResponseInfo.a(e, this.nor), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Rw(this.noj.mimeType), UrlSafeBase64.Rw(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Rw(this.key));
        }
        String str3 = "";
        if (this.noj.params.size() != 0) {
            String[] strArr = new String[this.noj.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.noj.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Rw(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nnu), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nom, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nmV.a(str, bArr, i, i2, this.non, this.nor, this.nnu, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gW(long j) {
        long j2 = this.nnu - j;
        return j2 < ((long) this.nok.chunkSize) ? j2 : this.nok.chunkSize;
    }

    private long gX(long j) {
        long j2 = this.nnu - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.noj.noK.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.noi.a(this.key, ResponseInfo.b(this.nor), null);
        } else if (j == this.nnu) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dFQ() && !AndroidNetwork.dGh()) {
                        ResumeUploader.this.noj.noL.dGb();
                        if (!AndroidNetwork.dGh()) {
                            ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dFP()) {
                        ResumeUploader.this.dGd();
                        ResumeUploader.this.noj.noJ.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dFT() || i >= ResumeUploader.this.nok.nnR + 1 || (d = ResumeUploader.this.nok.nnU.d(ResumeUploader.this.nor.token, ResumeUploader.this.nok.useHttps, str)) == null) {
                        ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.noj.noK);
        } else {
            final int gW = (int) gW(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.noj.noJ.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dFQ() && !AndroidNetwork.dGh()) {
                        ResumeUploader.this.noj.noL.dGb();
                        if (!AndroidNetwork.dGh()) {
                            ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nok.nnU.d(ResumeUploader.this.nor.token, ResumeUploader.this.nok.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nok.nnR) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dFT()) || i >= ResumeUploader.this.nok.nnR)) {
                            ResumeUploader.this.noi.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nok.nnR) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nok.nnU.d(ResumeUploader.this.nor.token, ResumeUploader.this.nok.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.noq) && i < ResumeUploader.this.nok.nnR) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nok.nnU.d(ResumeUploader.this.nor.token, ResumeUploader.this.nok.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nom[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gY(j + gW);
                        ResumeUploader.this.a(j + gW, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gX(j), gW, progressHandler, completionHandler, this.noj.noK);
            } else {
                a(str, j, gW, this.nom[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.noj.noK);
            }
        }
    }

    private long dGc() {
        byte[] bArr;
        if (this.nok.nnN == null || (bArr = this.nok.nnN.get(this.nop)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.noo || optLong3 != this.nnu || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nom[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGd() {
        if (this.nok.nnN != null) {
            this.nok.nnN.Rr(this.nop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(long j) {
        if (this.nok.nnN != null && j != 0) {
            this.nok.nnN.q(this.nop, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nnu), Long.valueOf(j), Long.valueOf(this.noo), StringUtils.V(this.nom)).getBytes());
        }
    }
}
