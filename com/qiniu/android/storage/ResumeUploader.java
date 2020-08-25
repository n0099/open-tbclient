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
    private final long ofG;
    private final Client ofh;
    private final long ogA;
    private final String ogB;
    private long ogC;
    private UpToken ogD;
    private final UpCompletionHandler ogu;
    private final UploadOptions ogv;
    private final Configuration ogw;
    private final byte[] ogx;
    private final String[] ogy;
    private final StringMap ogz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.ofh = client;
        this.ogw = configuration;
        this.f = file;
        this.ogB = str2;
        this.ofG = file.length();
        this.key = str;
        this.ogz = new StringMap().N("Authorization", "UpToken " + upToken.token);
        this.ogu = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.ogv = uploadOptions == null ? UploadOptions.ecv() : uploadOptions;
        this.ogx = new byte[configuration.chunkSize];
        this.ogy = new String[(int) (((this.ofG + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.ogA = file.lastModified();
        this.ogD = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.ecl() || eH(jSONObject));
    }

    private static boolean eH(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.ecl() && !eH(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long ecr = ecr();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(ecr, 0, this.ogw.ogg.d(this.ogD.token, this.ogw.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.ogu.a(this.key, ResponseInfo.a(e, this.ogD), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.ogx, 0, i2);
            this.ogC = Crc32.w(this.ogx, 0, i2);
            a(String.format("%s%s", str, format), this.ogx, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ogu.a(this.key, ResponseInfo.a(e, this.ogD), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.ogx, 0, i);
            this.ogC = Crc32.w(this.ogx, 0, i);
            a(String.format("%s%s", str, format), this.ogx, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ogu.a(this.key, ResponseInfo.a(e, this.ogD), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.VC(this.ogv.mimeType), UrlSafeBase64.VC(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.VC(this.key));
        }
        String str3 = "";
        if (this.ogv.params.size() != 0) {
            String[] strArr = new String[this.ogv.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.ogv.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.VC(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.ofG), format, str2, str3);
        byte[] bytes = StringUtils.b(this.ogy, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.ofh.a(str, bArr, i, i2, this.ogz, this.ogD, this.ofG, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gE(long j) {
        long j2 = this.ofG - j;
        return j2 < ((long) this.ogw.chunkSize) ? j2 : this.ogw.chunkSize;
    }

    private long gF(long j) {
        long j2 = this.ofG - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.ogv.ogU.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.ogu.a(this.key, ResponseInfo.b(this.ogD), null);
        } else if (j == this.ofG) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.ecg() && !AndroidNetwork.ecw()) {
                        ResumeUploader.this.ogv.ogV.ecq();
                        if (!AndroidNetwork.ecw()) {
                            ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.ecf()) {
                        ResumeUploader.this.ecs();
                        ResumeUploader.this.ogv.ogT.c(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.ecj() || i >= ResumeUploader.this.ogw.ogd + 1 || (d = ResumeUploader.this.ogw.ogg.d(ResumeUploader.this.ogD.token, ResumeUploader.this.ogw.useHttps, str)) == null) {
                        ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.ogv.ogU);
        } else {
            final int gE = (int) gE(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.ogv.ogT.c(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.ecg() && !AndroidNetwork.ecw()) {
                        ResumeUploader.this.ogv.ogV.ecq();
                        if (!AndroidNetwork.ecw()) {
                            ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.ogw.ogg.d(ResumeUploader.this.ogD.token, ResumeUploader.this.ogw.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.ogw.ogd) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.ecj()) || i >= ResumeUploader.this.ogw.ogd)) {
                            ResumeUploader.this.ogu.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.ogw.ogd) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ogw.ogg.d(ResumeUploader.this.ogD.token, ResumeUploader.this.ogw.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.ogC) && i < ResumeUploader.this.ogw.ogd) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ogw.ogg.d(ResumeUploader.this.ogD.token, ResumeUploader.this.ogw.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.ogy[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gG(j + gE);
                        ResumeUploader.this.a(j + gE, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gF(j), gE, progressHandler, completionHandler, this.ogv.ogU);
            } else {
                a(str, j, gE, this.ogy[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.ogv.ogU);
            }
        }
    }

    private long ecr() {
        byte[] bArr;
        if (this.ogw.ofZ == null || (bArr = this.ogw.ofZ.get(this.ogB)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.ogA || optLong3 != this.ofG || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.ogy[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecs() {
        if (this.ogw.ofZ != null) {
            this.ogw.ofZ.Vx(this.ogB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(long j) {
        if (this.ogw.ofZ != null && j != 0) {
            this.ogw.ofZ.q(this.ogB, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.ofG), Long.valueOf(j), Long.valueOf(this.ogA), StringUtils.V(this.ogy)).getBytes());
        }
    }
}
