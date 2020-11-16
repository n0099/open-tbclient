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
    private final Client pGS;
    private final long pHr;
    private final UpCompletionHandler pIf;
    private final UploadOptions pIg;
    private final Configuration pIh;
    private final byte[] pIi;
    private final String[] pIj;
    private final StringMap pIk;
    private final long pIl;
    private final String pIm;
    private long pIn;
    private UpToken pIo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.pGS = client;
        this.pIh = configuration;
        this.f = file;
        this.pIm = str2;
        this.pHr = file.length();
        this.key = str;
        this.pIk = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.pIf = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.pIg = uploadOptions == null ? UploadOptions.eyc() : uploadOptions;
        this.pIi = new byte[configuration.chunkSize];
        this.pIj = new String[(int) (((this.pHr + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.pIl = file.lastModified();
        this.pIo = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.exS() || fc(jSONObject));
    }

    private static boolean fc(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.exS() && !fc(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long exY = exY();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(exY, 0, this.pIh.pHR.d(this.pIo.token, this.pIh.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.pIf.a(this.key, ResponseInfo.a(e, this.pIo), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.pIi, 0, i2);
            this.pIn = Crc32.y(this.pIi, 0, i2);
            a(String.format("%s%s", str, format), this.pIi, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pIf.a(this.key, ResponseInfo.a(e, this.pIo), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.pIi, 0, i);
            this.pIn = Crc32.y(this.pIi, 0, i);
            a(String.format("%s%s", str, format), this.pIi, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pIf.a(this.key, ResponseInfo.a(e, this.pIo), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.YU(this.pIg.mimeType), UrlSafeBase64.YU(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.YU(this.key));
        }
        String str3 = "";
        if (this.pIg.params.size() != 0) {
            String[] strArr = new String[this.pIg.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.pIg.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.YU(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.pHr), format, str2, str3);
        byte[] bytes = StringUtils.b(this.pIj, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.pGS.a(str, bArr, i, i2, this.pIk, this.pIo, this.pHr, progressHandler, completionHandler, upCancellationSignal);
    }

    private long ib(long j) {
        long j2 = this.pHr - j;
        return j2 < ((long) this.pIh.chunkSize) ? j2 : this.pIh.chunkSize;
    }

    private long ic(long j) {
        long j2 = this.pHr - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.pIg.pIF.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.pIf.a(this.key, ResponseInfo.b(this.pIo), null);
        } else if (j == this.pHr) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.exN() && !AndroidNetwork.eyd()) {
                        ResumeUploader.this.pIg.pIG.exX();
                        if (!AndroidNetwork.eyd()) {
                            ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.exM()) {
                        ResumeUploader.this.exZ();
                        ResumeUploader.this.pIg.pIE.d(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.exQ() || i >= ResumeUploader.this.pIh.pHO + 1 || (d = ResumeUploader.this.pIh.pHR.d(ResumeUploader.this.pIo.token, ResumeUploader.this.pIh.useHttps, str)) == null) {
                        ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.pIg.pIF);
        } else {
            final int ib = (int) ib(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.pIg.pIE.d(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.exN() && !AndroidNetwork.eyd()) {
                        ResumeUploader.this.pIg.pIG.exX();
                        if (!AndroidNetwork.eyd()) {
                            ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.pIh.pHR.d(ResumeUploader.this.pIo.token, ResumeUploader.this.pIh.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.pIh.pHO) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.exQ()) || i >= ResumeUploader.this.pIh.pHO)) {
                            ResumeUploader.this.pIf.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.pIh.pHO) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pIh.pHR.d(ResumeUploader.this.pIo.token, ResumeUploader.this.pIh.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.pIn) && i < ResumeUploader.this.pIh.pHO) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pIh.pHR.d(ResumeUploader.this.pIo.token, ResumeUploader.this.pIh.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.pIj[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.id(j + ib);
                        ResumeUploader.this.a(j + ib, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) ic(j), ib, progressHandler, completionHandler, this.pIg.pIF);
            } else {
                a(str, j, ib, this.pIj[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.pIg.pIF);
            }
        }
    }

    private long exY() {
        byte[] bArr;
        if (this.pIh.pHK == null || (bArr = this.pIh.pHK.get(this.pIm)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.pIl || optLong3 != this.pHr || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.pIj[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exZ() {
        if (this.pIh.pHK != null) {
            this.pIh.pHK.YP(this.pIm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id(long j) {
        if (this.pIh.pHK != null && j != 0) {
            this.pIh.pHK.q(this.pIm, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.pHr), Long.valueOf(j), Long.valueOf(this.pIl), StringUtils.ab(this.pIj)).getBytes());
        }
    }
}
