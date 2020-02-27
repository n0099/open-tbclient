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
    private final Client nmI;
    private final UpCompletionHandler nnV;
    private final UploadOptions nnW;
    private final Configuration nnX;
    private final byte[] nnY;
    private final String[] nnZ;
    private final long nnh;
    private final StringMap noa;
    private final long nob;
    private final String noc;
    private long nod;
    private UpToken noe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResumeUploader(Client client, Configuration configuration, File file, String str, UpToken upToken, final UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, String str2) {
        this.nmI = client;
        this.nnX = configuration;
        this.f = file;
        this.noc = str2;
        this.nnh = file.length();
        this.key = str;
        this.noa = new StringMap().H("Authorization", "UpToken " + upToken.token);
        this.nnV = new UpCompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.1
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
        this.nnW = uploadOptions == null ? UploadOptions.dGd() : uploadOptions;
        this.nnY = new byte[configuration.chunkSize];
        this.nnZ = new String[(int) (((this.nnh + ImageUploadStrategy.FILE_SIZE_4M) - 1) / ImageUploadStrategy.FILE_SIZE_4M)];
        this.nob = file.lastModified();
        this.noe = upToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ResponseInfo responseInfo, JSONObject jSONObject) {
        return responseInfo.statusCode == 200 && responseInfo.error == null && (responseInfo.dFS() || dV(jSONObject));
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
        return responseInfo.statusCode < 500 && responseInfo.statusCode >= 200 && !responseInfo.dFS() && !dV(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long dFZ = dFZ();
        try {
            this.file = new RandomAccessFile(this.f, "r");
            a(dFZ, 0, this.nnX.nnH.d(this.noe.token, this.nnX.useHttps, null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.nnV.a(this.key, ResponseInfo.a(e, this.noe), null);
        }
    }

    private void a(String str, long j, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.file.seek(j);
            this.file.read(this.nnY, 0, i2);
            this.nod = Crc32.I(this.nnY, 0, i2);
            a(String.format("%s%s", str, format), this.nnY, 0, i2, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnV.a(this.key, ResponseInfo.a(e, this.noe), null);
        }
    }

    private void a(String str, long j, int i, String str2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String format = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % ImageUploadStrategy.FILE_SIZE_4M)));
        try {
            this.file.seek(j);
            this.file.read(this.nnY, 0, i);
            this.nod = Crc32.I(this.nnY, 0, i);
            a(String.format("%s%s", str, format), this.nnY, 0, i, progressHandler, completionHandler, upCancellationSignal);
        } catch (IOException e) {
            this.nnV.a(this.key, ResponseInfo.a(e, this.noe), null);
        }
    }

    private void a(String str, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        String str2;
        String format = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", UrlSafeBase64.Rv(this.nnW.mimeType), UrlSafeBase64.Rv(this.f.getName()));
        if (this.key == null) {
            str2 = "";
        } else {
            str2 = String.format("/key/%s", UrlSafeBase64.Rv(this.key));
        }
        String str3 = "";
        if (this.nnW.params.size() != 0) {
            String[] strArr = new String[this.nnW.params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.nnW.params.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), UrlSafeBase64.Rv(entry.getValue()));
                i++;
            }
            str3 = "/" + StringUtils.b(strArr, "/");
        }
        String format2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.nnh), format, str2, str3);
        byte[] bytes = StringUtils.b(this.nnZ, Constants.ACCEPT_TIME_SEPARATOR_SP).getBytes();
        a(String.format("%s%s", str, format2), bytes, 0, bytes.length, (ProgressHandler) null, completionHandler, upCancellationSignal);
    }

    private void a(String str, byte[] bArr, int i, int i2, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        this.nmI.a(str, bArr, i, i2, this.noa, this.noe, this.nnh, progressHandler, completionHandler, upCancellationSignal);
    }

    private long gW(long j) {
        long j2 = this.nnh - j;
        return j2 < ((long) this.nnX.chunkSize) ? j2 : this.nnX.chunkSize;
    }

    private long gX(long j) {
        long j2 = this.nnh - j;
        return j2 < ImageUploadStrategy.FILE_SIZE_4M ? j2 : ImageUploadStrategy.FILE_SIZE_4M;
    }

    private boolean isCancelled() {
        return this.nnW.nox.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final int i, final String str) {
        if (isCancelled()) {
            this.nnV.a(this.key, ResponseInfo.b(this.noe), null);
        } else if (j == this.nnh) {
            a(str, new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.2
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String d;
                    if (responseInfo.dFN() && !AndroidNetwork.dGe()) {
                        ResumeUploader.this.nnW.noy.dFY();
                        if (!AndroidNetwork.dGe()) {
                            ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.dFM()) {
                        ResumeUploader.this.dGa();
                        ResumeUploader.this.nnW.nov.b(ResumeUploader.this.key, 1.0d);
                        ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!responseInfo.dFQ() || i >= ResumeUploader.this.nnX.nnE + 1 || (d = ResumeUploader.this.nnX.nnH.d(ResumeUploader.this.noe.token, ResumeUploader.this.nnX.useHttps, str)) == null) {
                        ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else {
                        ResumeUploader.this.a(j, i + 1, d);
                    }
                }
            }, this.nnW.nox);
        } else {
            final int gW = (int) gW(j);
            ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.ResumeUploader.3
                @Override // com.qiniu.android.http.ProgressHandler
                public void onProgress(long j2, long j3) {
                    double d = (j + j2) / j3;
                    ResumeUploader.this.nnW.nov.b(ResumeUploader.this.key, d <= 0.95d ? d : 0.95d);
                }
            };
            CompletionHandler completionHandler = new CompletionHandler() { // from class: com.qiniu.android.storage.ResumeUploader.4
                @Override // com.qiniu.android.http.CompletionHandler
                public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
                    String str2;
                    long j2;
                    if (responseInfo.dFN() && !AndroidNetwork.dGe()) {
                        ResumeUploader.this.nnW.noy.dFY();
                        if (!AndroidNetwork.dGe()) {
                            ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                            return;
                        }
                    }
                    if (responseInfo.isCancelled()) {
                        ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                    } else if (!ResumeUploader.b(responseInfo, jSONObject)) {
                        String d = ResumeUploader.this.nnX.nnH.d(ResumeUploader.this.noe.token, ResumeUploader.this.nnX.useHttps, str);
                        if (responseInfo.statusCode == 701 && i < ResumeUploader.this.nnX.nnE) {
                            ResumeUploader.this.a((j / ImageUploadStrategy.FILE_SIZE_4M) * ImageUploadStrategy.FILE_SIZE_4M, i + 1, str);
                        } else if (d == null || ((!ResumeUploader.c(responseInfo, jSONObject) && !responseInfo.dFQ()) || i >= ResumeUploader.this.nnX.nnE)) {
                            ResumeUploader.this.nnV.a(ResumeUploader.this.key, responseInfo, jSONObject);
                        } else {
                            ResumeUploader.this.a(j, i + 1, d);
                        }
                    } else {
                        String str3 = null;
                        if (jSONObject == null && i < ResumeUploader.this.nnX.nnE) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnX.nnH.d(ResumeUploader.this.noe.token, ResumeUploader.this.nnX.useHttps, str));
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
                        if ((str2 == null || j2 != ResumeUploader.this.nod) && i < ResumeUploader.this.nnX.nnE) {
                            ResumeUploader.this.a(j, i + 1, ResumeUploader.this.nnX.nnH.d(ResumeUploader.this.noe.token, ResumeUploader.this.nnX.useHttps, str));
                            return;
                        }
                        ResumeUploader.this.nnZ[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)] = str2;
                        ResumeUploader.this.gY(j + gW);
                        ResumeUploader.this.a(j + gW, i, str);
                    }
                }
            };
            if (j % ImageUploadStrategy.FILE_SIZE_4M == 0) {
                a(str, j, (int) gX(j), gW, progressHandler, completionHandler, this.nnW.nox);
            } else {
                a(str, j, gW, this.nnZ[(int) (j / ImageUploadStrategy.FILE_SIZE_4M)], progressHandler, completionHandler, this.nnW.nox);
            }
        }
    }

    private long dFZ() {
        byte[] bArr;
        if (this.nnX.nnA == null || (bArr = this.nnX.nnA.get(this.noc)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            long optLong = jSONObject.optLong("offset", 0L);
            long optLong2 = jSONObject.optLong("modify_time", 0L);
            long optLong3 = jSONObject.optLong(TiebaInitialize.LogFields.SIZE, 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
            if (optLong == 0 || optLong2 != this.nob || optLong3 != this.nnh || optJSONArray == null || optJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.nnZ[i] = optJSONArray.optString(i);
            }
            return optLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGa() {
        if (this.nnX.nnA != null) {
            this.nnX.nnA.Rq(this.noc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(long j) {
        if (this.nnX.nnA != null && j != 0) {
            this.nnX.nnA.q(this.noc, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.nnh), Long.valueOf(j), Long.valueOf(this.nob), StringUtils.V(this.nnZ)).getBytes());
        }
    }
}
