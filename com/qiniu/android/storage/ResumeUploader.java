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
    private final Client pvV;
    private final long pwv;
    private final UpCompletionHandler pxj;
    private final UploadOptions pxk;
    private final Configuration pxl;
    private final byte[] pxm;
    private final String[] pxn;
    private final StringMap pxo;
    private final long pxp;
    private final String pxq;
    private long pxr;
    private UpToken pxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.pvV = client;
        this.pxl = configuration;
        this.f = file;
        this.pxq = str2;
        this.pwv = file.length();
        this.key = str;
        this.pxo = new StringMap().O("Authorization", "UpToken " + upToken.token);
        this.pxj = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.pxk = uploadOptions == null ? UploadOptions.eum() : uploadOptions;
        this.pxm = new byte[configuration.chunkSize];
        this.pxn = new String[(int) (((this.pwv + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.pxp = file.lastModified();
        this.pxs = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.euc() || fb(jSONObject));
    }

    private static boolean fb(JSONObject jSONObject) {
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.euc() && !fb(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long eui = eui();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(eui, 0, this.pxl.pwV.d(this.pxs.token, this.pxl.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.pxj.a(this.key, ResponseInfo.a(e, this.pxs), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.pxm, 0, i2);
            this.pxr = Crc32.y(this.pxm, 0, i2);
            a(String.format("%s%s", str, format), this.pxm, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pxj.a(this.key, ResponseInfo.a(e, this.pxs), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.pxm, 0, i);
            this.pxr = Crc32.y(this.pxm, 0, i);
            a(String.format("%s%s", str, format), this.pxm, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.pxj.a(this.key, ResponseInfo.a(e, this.pxs), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.YF(this.pxk.mimeType), UrlSafeBase64.YF(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.YF(this.key));
        }
        String str3 = "";
        if (this.pxk.params.size() != 0) {
            String[] strArr = new String[this.pxk.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.pxk.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.YF(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.pwv), format, str2, str3);
        byte[] bytes = StringUtils.b(this.pxn, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.pvV.a(str, bArr, i, i2, this.pxo, this.pxs, this.pwv, progressHandler, completionHandler, upCancellationSignal);
    }

    private long hC(long j) {
        long j2 = this.pwv - j;
        return j2 < ((long) this.pxl.chunkSize) ? j2 : this.pxl.chunkSize;
    }

    private long hD(long j) {
        long j2 = this.pwv - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.pxk.pxJ.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.pxj.a(this.key, ResponseInfo.b(this.pxs), null);
        } else if (j == this.pwv) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.etX() && !AndroidNetwork.eun()) {
                        ResumeUploader.this.pxk.pxK.euh();
                        if (!AndroidNetwork.eun()) {
                            ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.etW()) {
                        ResumeUploader.this.euj();
                        ResumeUploader.this.pxk.pxI.d(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.eua() || i >= ResumeUploader.this.pxl.pwS + 1 || (d = ResumeUploader.this.pxl.pwV.d(ResumeUploader.this.pxs.token, ResumeUploader.this.pxl.useHttps, str)) == null) {
                        ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.pxk.pxJ);
        } else {
            final int hC = (int) hC(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.pxk.pxI.d(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.etX() && !AndroidNetwork.eun()) {
                        ResumeUploader.this.pxk.pxK.euh();
                        if (!AndroidNetwork.eun()) {
                            ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.pxl.pwV.d(ResumeUploader.this.pxs.token, ResumeUploader.this.pxl.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.pxl.pwS) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.eua()) || i >= ResumeUploader.this.pxl.pwS)) {
                            ResumeUploader.this.pxj.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.pxl.pwS) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pxl.pwV.d(ResumeUploader.this.pxs.token, ResumeUploader.this.pxl.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.pxr) && i < ResumeUploader.this.pxl.pwS) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.pxl.pwV.d(ResumeUploader.this.pxs.token, ResumeUploader.this.pxl.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.pxn[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.hE(j + hC);
                        ResumeUploader.this.a(j + hC, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) hD(j), hC, progressHandler, completionHandler, this.pxk.pxJ);
            } else {
                a(str, j, hC, this.pxn[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.pxk.pxJ);
            }
        }
    }

    private long eui() {
        byte[] bArr;
        if (this.pxl.pwO == null || (bArr = this.pxl.pwO.get(this.pxq)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.pxp || optLong3 != this.pwv || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.pxn[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euj() {
        if (this.pxl.pwO != null) {
            this.pxl.pwO.YA(this.pxq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE(long j) {
        if (this.pxl.pwO != null && j != 0) {
            this.pxl.pwO.q(this.pxq, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.pwv), Long.valueOf(j), Long.valueOf(this.pxp), StringUtils.Z(this.pxn)).getBytes());
        }
    }
}
