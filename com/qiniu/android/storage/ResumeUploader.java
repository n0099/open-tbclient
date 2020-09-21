package com.qiniu.android.storage;

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
    private final long opH;
    private final Client oph;
    private final StringMap oqA;
    private final long oqB;
    private final String oqC;
    private long oqD;
    private UpToken oqE;
    private final UpCompletionHandler oqv;
    private final UploadOptions oqw;
    private final Configuration oqx;
    private final byte[] oqy;
    private final String[] oqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.oph = client;
        this.oqx = configuration;
        this.f = file;
        this.oqC = str2;
        this.opH = file.length();
        this.key = str;
        this.oqA = new StringMap().N("Authorization", "UpToken " + upToken.token);
        this.oqv = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.oqw = uploadOptions == null ? UploadOptions.egB() : uploadOptions;
        this.oqy = new byte[configuration.chunkSize];
        this.oqz = new String[(int) (((this.opH + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.oqB = file.lastModified();
        this.oqE = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.egr() || eP(jSONObject));
    }

    private static boolean eP(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.egr() && !eP(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long egx = egx();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(egx, 0, this.oqx.oqh.d(this.oqE.token, this.oqx.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.oqv.a(this.key, ResponseInfo.a(e, this.oqE), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.oqy, 0, i2);
            this.oqD = Crc32.w(this.oqy, 0, i2);
            a(String.format("%s%s", str, format), this.oqy, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.oqv.a(this.key, ResponseInfo.a(e, this.oqE), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.oqy, 0, i);
            this.oqD = Crc32.w(this.oqy, 0, i);
            a(String.format("%s%s", str, format), this.oqy, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.oqv.a(this.key, ResponseInfo.a(e, this.oqE), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.We(this.oqw.mimeType), UrlSafeBase64.We(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.We(this.key));
        }
        String str3 = "";
        if (this.oqw.params.size() != 0) {
            String[] strArr = new String[this.oqw.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.oqw.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.We(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.opH), format, str2, str3);
        byte[] bytes = StringUtils.b(this.oqz, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.oph.a(str, bArr, i, i2, this.oqA, this.oqE, this.opH, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gU(long j) {
        long j2 = this.opH - j;
        return j2 < ((long) this.oqx.chunkSize) ? j2 : this.oqx.chunkSize;
    }

    private long gV(long j) {
        long j2 = this.opH - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.oqw.oqV.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.oqv.a(this.key, ResponseInfo.b(this.oqE), null);
        } else if (j == this.opH) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.egm() && !AndroidNetwork.egC()) {
                        ResumeUploader.this.oqw.oqW.egw();
                        if (!AndroidNetwork.egC()) {
                            ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.egl()) {
                        ResumeUploader.this.egy();
                        ResumeUploader.this.oqw.oqU.d(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.egp() || i >= ResumeUploader.this.oqx.oqe + 1 || (d = ResumeUploader.this.oqx.oqh.d(ResumeUploader.this.oqE.token, ResumeUploader.this.oqx.useHttps, str)) == null) {
                        ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.oqw.oqV);
        } else {
            final int gU = (int) gU(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.oqw.oqU.d(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.egm() && !AndroidNetwork.egC()) {
                        ResumeUploader.this.oqw.oqW.egw();
                        if (!AndroidNetwork.egC()) {
                            ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.oqx.oqh.d(ResumeUploader.this.oqE.token, ResumeUploader.this.oqx.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.oqx.oqe) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.egp()) || i >= ResumeUploader.this.oqx.oqe)) {
                            ResumeUploader.this.oqv.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.oqx.oqe) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.oqx.oqh.d(ResumeUploader.this.oqE.token, ResumeUploader.this.oqx.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.oqD) && i < ResumeUploader.this.oqx.oqe) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.oqx.oqh.d(ResumeUploader.this.oqE.token, ResumeUploader.this.oqx.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.oqz[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gW(j + gU);
                        ResumeUploader.this.a(j + gU, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gV(j), gU, progressHandler, completionHandler, this.oqw.oqV);
            } else {
                a(str, j, gU, this.oqz[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.oqw.oqV);
            }
        }
    }

    private long egx() {
        byte[] bArr;
        if (this.oqx.oqa == null || (bArr = this.oqx.oqa.get(this.oqC)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.oqB || optLong3 != this.opH || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.oqz[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egy() {
        if (this.oqx.oqa != null) {
            this.oqx.oqa.VZ(this.oqC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gW(long j) {
        if (this.oqx.oqa != null && j != 0) {
            this.oqx.oqa.q(this.oqC, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.opH), Long.valueOf(j), Long.valueOf(this.oqB), StringUtils.V(this.oqz)).getBytes());
        }
    }
}
