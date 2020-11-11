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
    private final long pFO;
    private final Client pFp;
    private final UpCompletionHandler pGC;
    private final UploadOptions pGD;
    private final Configuration pGE;
    private final byte[] pGF;
    private final String[] pGG;
    private final StringMap pGH;
    private final long pGI;
    private final String pGJ;
    private long pGK;
    private UpToken pGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.pFp = client;
        this.pGE = configuration;
        this.f = file;
        this.pGJ = str2;
        this.pFO = file.length();
        this.key = str;
        this.pGH = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.pGC = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.pGD = uploadOptions == null ? UploadOptions.eyb() : uploadOptions;
        this.pGF = new byte[configuration.chunkSize];
        this.pGG = new String[(int) (((this.pFO + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.pGI = file.lastModified();
        this.pGL = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.exR() || fh(jSONObject));
    }

    private static boolean fh(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.exR() && !fh(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long exX = exX();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(exX, 0, this.pGE.pGo.d(this.pGL.token, this.pGE.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.pGC.a(this.key, ResponseInfo.a(e, this.pGL), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.pGF, 0, i2);
            this.pGK = Crc32.y(this.pGF, 0, i2);
            a(String.format("%s%s", str, format), this.pGF, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pGC.a(this.key, ResponseInfo.a(e, this.pGL), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.pGF, 0, i);
            this.pGK = Crc32.y(this.pGF, 0, i);
            a(String.format("%s%s", str, format), this.pGF, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pGC.a(this.key, ResponseInfo.a(e, this.pGL), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Zj(this.pGD.mimeType), UrlSafeBase64.Zj(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Zj(this.key));
        }
        String str3 = "";
        if (this.pGD.params.size() != 0) {
            String[] strArr = new String[this.pGD.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.pGD.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Zj(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.pFO), format, str2, str3);
        byte[] bytes = StringUtils.b(this.pGG, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.pFp.a(str, bArr, i, i2, this.pGH, this.pGL, this.pFO, progressHandler, completionHandler, upCancellationSignal);
    }

    private long hY(long j) {
        long j2 = this.pFO - j;
        return j2 < ((long) this.pGE.chunkSize) ? j2 : this.pGE.chunkSize;
    }

    private long hZ(long j) {
        long j2 = this.pFO - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.pGD.pHc.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.pGC.a(this.key, ResponseInfo.b(this.pGL), null);
        } else if (j == this.pFO) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.exM() && !AndroidNetwork.eyc()) {
                        ResumeUploader.this.pGD.pHd.exW();
                        if (!AndroidNetwork.eyc()) {
                            ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.exL()) {
                        ResumeUploader.this.exY();
                        ResumeUploader.this.pGD.pHb.d(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.exP() || i >= ResumeUploader.this.pGE.pGl + 1 || (d = ResumeUploader.this.pGE.pGo.d(ResumeUploader.this.pGL.token, ResumeUploader.this.pGE.useHttps, str)) == null) {
                        ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.pGD.pHc);
        } else {
            final int hY = (int) hY(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.pGD.pHb.d(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.exM() && !AndroidNetwork.eyc()) {
                        ResumeUploader.this.pGD.pHd.exW();
                        if (!AndroidNetwork.eyc()) {
                            ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.pGE.pGo.d(ResumeUploader.this.pGL.token, ResumeUploader.this.pGE.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.pGE.pGl) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.exP()) || i >= ResumeUploader.this.pGE.pGl)) {
                            ResumeUploader.this.pGC.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.pGE.pGl) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pGE.pGo.d(ResumeUploader.this.pGL.token, ResumeUploader.this.pGE.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.pGK) && i < ResumeUploader.this.pGE.pGl) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pGE.pGo.d(ResumeUploader.this.pGL.token, ResumeUploader.this.pGE.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.pGG[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.ia(j + hY);
                        ResumeUploader.this.a(j + hY, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) hZ(j), hY, progressHandler, completionHandler, this.pGD.pHc);
            } else {
                a(str, j, hY, this.pGG[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.pGD.pHc);
            }
        }
    }

    private long exX() {
        byte[] bArr;
        if (this.pGE.pGh == null || (bArr = this.pGE.pGh.get(this.pGJ)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.pGI || optLong3 != this.pFO || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.pGG[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exY() {
        if (this.pGE.pGh != null) {
            this.pGE.pGh.Ze(this.pGJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(long j) {
        if (this.pGE.pGh != null && j != 0) {
            this.pGE.pGh.q(this.pGJ, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.pFO), Long.valueOf(j), Long.valueOf(this.pGI), StringUtils.aa(this.pGG)).getBytes());
        }
    }
}
