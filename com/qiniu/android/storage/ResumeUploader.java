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
    private final Client ngK;
    private final UpCompletionHandler nhX;
    private final UploadOptions nhY;
    private final Configuration nhZ;
    private final long nhj;
    private final byte[] nia;
    private final String[] nib;
    private final StringMap nic;
    private final long nie;
    private final String nif;
    private long nig;
    private UpToken nih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.ngK = client;
        this.nhZ = configuration;
        this.f = file;
        this.nif = str2;
        this.nhj = file.length();
        this.key = str;
        this.nic = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.nhX = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nhY = uploadOptions == null ? UploadOptions.dIm() : uploadOptions;
        this.nia = new byte[configuration.chunkSize];
        this.nib = new String[(int) (((this.nhj + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nie = file.lastModified();
        this.nih = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dIc() || ef(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dIc() && !ef(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dIi = dIi();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dIi, 0, this.nhZ.nhJ.d(this.nih.token, this.nhZ.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nhX.a(this.key, ResponseInfo.a(e, this.nih), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nia, 0, i2);
            this.nig = Crc32.u(this.nia, 0, i2);
            a(String.format("%s%s", str, format), this.nia, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nhX.a(this.key, ResponseInfo.a(e, this.nih), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nia, 0, i);
            this.nig = Crc32.u(this.nia, 0, i);
            a(String.format("%s%s", str, format), this.nia, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nhX.a(this.key, ResponseInfo.a(e, this.nih), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Ra(this.nhY.mimeType), UrlSafeBase64.Ra(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Ra(this.key));
        }
        String str3 = "";
        if (this.nhY.params.size() != 0) {
            String[] strArr = new String[this.nhY.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nhY.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Ra(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nhj), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nib, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.ngK.a(str, bArr, i, i2, this.nic, this.nih, this.nhj, progressHandler, completionHandler, upCancellationSignal);
    }

    private long fZ(long j) {
        long j2 = this.nhj - j;
        return j2 < ((long) this.nhZ.chunkSize) ? j2 : this.nhZ.chunkSize;
    }

    private long ga(long j) {
        long j2 = this.nhj - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nhY.niy.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nhX.a(this.key, ResponseInfo.b(this.nih), null);
        } else if (j == this.nhj) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dHX() && !AndroidNetwork.dIn()) {
                        ResumeUploader.this.nhY.niz.dIh();
                        if (!AndroidNetwork.dIn()) {
                            ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dHW()) {
                        ResumeUploader.this.dIj();
                        ResumeUploader.this.nhY.nix.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dIa() || i >= ResumeUploader.this.nhZ.nhG + 1 || (d = ResumeUploader.this.nhZ.nhJ.d(ResumeUploader.this.nih.token, ResumeUploader.this.nhZ.useHttps, str)) == null) {
                        ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nhY.niy);
        } else {
            final int fZ = (int) fZ(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nhY.nix.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dHX() && !AndroidNetwork.dIn()) {
                        ResumeUploader.this.nhY.niz.dIh();
                        if (!AndroidNetwork.dIn()) {
                            ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nhZ.nhJ.d(ResumeUploader.this.nih.token, ResumeUploader.this.nhZ.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nhZ.nhG) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dIa()) || i >= ResumeUploader.this.nhZ.nhG)) {
                            ResumeUploader.this.nhX.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nhZ.nhG) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nhZ.nhJ.d(ResumeUploader.this.nih.token, ResumeUploader.this.nhZ.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nig) && i < ResumeUploader.this.nhZ.nhG) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nhZ.nhJ.d(ResumeUploader.this.nih.token, ResumeUploader.this.nhZ.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nib[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gb(j + fZ);
                        ResumeUploader.this.a(j + fZ, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) ga(j), fZ, progressHandler, completionHandler, this.nhY.niy);
            } else {
                a(str, j, fZ, this.nib[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nhY.niy);
            }
        }
    }

    private long dIi() {
        byte[] bArr;
        if (this.nhZ.nhC == null || (bArr = this.nhZ.nhC.get(this.nif)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nie || optLong3 != this.nhj || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nib[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIj() {
        if (this.nhZ.nhC != null) {
            this.nhZ.nhC.QV(this.nif);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(long j) {
        if (this.nhZ.nhC != null && j != 0) {
            this.nhZ.nhC.q(this.nif, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nhj), Long.valueOf(j), Long.valueOf(this.nie), StringUtils.X(this.nib)).getBytes());
        }
    }
}
