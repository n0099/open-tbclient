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
    private final long ofY;
    private final Client ofz;
    private final UpCompletionHandler ogM;
    private final UploadOptions ogN;
    private final Configuration ogO;
    private final byte[] ogP;
    private final String[] ogQ;
    private final StringMap ogR;
    private final long ogS;
    private final String ogT;
    private long ogU;
    private UpToken ogV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.ofz = client;
        this.ogO = configuration;
        this.f = file;
        this.ogT = str2;
        this.ofY = file.length();
        this.key = str;
        this.ogR = new StringMap().N("Authorization", "UpToken " + upToken.token);
        this.ogM = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.ogN = uploadOptions == null ? UploadOptions.ecE() : uploadOptions;
        this.ogP = new byte[configuration.chunkSize];
        this.ogQ = new String[(int) (((this.ofY + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.ogS = file.lastModified();
        this.ogV = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.ecu() || eH(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.ecu() && !eH(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long ecA = ecA();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(ecA, 0, this.ogO.ogy.d(this.ogV.token, this.ogO.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.ogM.a(this.key, ResponseInfo.a(e, this.ogV), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.ogP, 0, i2);
            this.ogU = Crc32.w(this.ogP, 0, i2);
            a(String.format("%s%s", str, format), this.ogP, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ogM.a(this.key, ResponseInfo.a(e, this.ogV), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.ogP, 0, i);
            this.ogU = Crc32.w(this.ogP, 0, i);
            a(String.format("%s%s", str, format), this.ogP, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.ogM.a(this.key, ResponseInfo.a(e, this.ogV), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.VC(this.ogN.mimeType), UrlSafeBase64.VC(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.VC(this.key));
        }
        String str3 = "";
        if (this.ogN.params.size() != 0) {
            String[] strArr = new String[this.ogN.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.ogN.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.VC(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.ofY), format, str2, str3);
        byte[] bytes = StringUtils.b(this.ogQ, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.ofz.a(str, bArr, i, i2, this.ogR, this.ogV, this.ofY, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gG(long j) {
        long j2 = this.ofY - j;
        return j2 < ((long) this.ogO.chunkSize) ? j2 : this.ogO.chunkSize;
    }

    private long gH(long j) {
        long j2 = this.ofY - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.ogN.ohm.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.ogM.a(this.key, ResponseInfo.b(this.ogV), null);
        } else if (j == this.ofY) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.ecp() && !AndroidNetwork.ecF()) {
                        ResumeUploader.this.ogN.ohn.ecz();
                        if (!AndroidNetwork.ecF()) {
                            ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.eco()) {
                        ResumeUploader.this.ecB();
                        ResumeUploader.this.ogN.ohl.d(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.ecs() || i >= ResumeUploader.this.ogO.ogv + 1 || (d = ResumeUploader.this.ogO.ogy.d(ResumeUploader.this.ogV.token, ResumeUploader.this.ogO.useHttps, str)) == null) {
                        ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.ogN.ohm);
        } else {
            final int gG = (int) gG(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.ogN.ohl.d(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.ecp() && !AndroidNetwork.ecF()) {
                        ResumeUploader.this.ogN.ohn.ecz();
                        if (!AndroidNetwork.ecF()) {
                            ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.ogO.ogy.d(ResumeUploader.this.ogV.token, ResumeUploader.this.ogO.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.ogO.ogv) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.ecs()) || i >= ResumeUploader.this.ogO.ogv)) {
                            ResumeUploader.this.ogM.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.ogO.ogv) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ogO.ogy.d(ResumeUploader.this.ogV.token, ResumeUploader.this.ogO.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.ogU) && i < ResumeUploader.this.ogO.ogv) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.ogO.ogy.d(ResumeUploader.this.ogV.token, ResumeUploader.this.ogO.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.ogQ[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gI(j + gG);
                        ResumeUploader.this.a(j + gG, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gH(j), gG, progressHandler, completionHandler, this.ogN.ohm);
            } else {
                a(str, j, gG, this.ogQ[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.ogN.ohm);
            }
        }
    }

    private long ecA() {
        byte[] bArr;
        if (this.ogO.ogr == null || (bArr = this.ogO.ogr.get(this.ogT)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong("size", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.ogS || optLong3 != this.ofY || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.ogQ[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecB() {
        if (this.ogO.ogr != null) {
            this.ogO.ogr.Vx(this.ogT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(long j) {
        if (this.ogO.ogr != null && j != 0) {
            this.ogO.ogr.q(this.ogT, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.ofY), Long.valueOf(j), Long.valueOf(this.ogS), StringUtils.V(this.ogQ)).getBytes());
        }
    }
}
