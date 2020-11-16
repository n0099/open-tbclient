package com.qiniu.android.storage;

import android.util.Log;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.PostArgs;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringMap;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
final class FormUploader {
    FormUploader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Client client, Configuration configuration, byte[] bArr, String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions) {
        a(bArr, null, str, upToken, upCompletionHandler, uploadOptions, client, configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Client client, Configuration configuration, File file, String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions) {
        a(null, file, str, upToken, upCompletionHandler, uploadOptions, client, configuration);
    }

    private static void a(byte[] bArr, File file, final String str, UpToken upToken, UpCompletionHandler upCompletionHandler, UploadOptions uploadOptions, Client client, Configuration configuration) {
        int lastIndexOf;
        StringMap stringMap = new StringMap();
        PostArgs postArgs = new PostArgs();
        if (str != null) {
            stringMap.O("key", str);
            postArgs.fileName = str;
        } else {
            postArgs.fileName = "?";
        }
        if (file != null) {
            postArgs.fileName = file.getName();
        }
        String str2 = postArgs.fileName;
        if (str2 != null && str2.length() > 0 && (lastIndexOf = str2.lastIndexOf(".")) > 0) {
            postArgs.fileName = String.valueOf(Math.abs((str2.substring(0, lastIndexOf) + System.currentTimeMillis()).hashCode())) + str2.substring(lastIndexOf);
        }
        stringMap.O("token", upToken.token);
        final UploadOptions eyc = uploadOptions != null ? uploadOptions : UploadOptions.eyc();
        stringMap.K(eyc.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.av(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.au(bArr);
        }
        stringMap.O("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.pIE.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = eyc.mimeType;
        postArgs.pHw = stringMap;
        String d = configuration.pHR.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(eyc, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), eyc.pIF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions pHT;
        final /* synthetic */ UpCompletionHandler pHU;
        final /* synthetic */ Configuration pHV;
        final /* synthetic */ UpToken pHW;
        final /* synthetic */ String pHX;
        final /* synthetic */ Client pHY;
        final /* synthetic */ PostArgs pHZ;
        final /* synthetic */ ProgressHandler pIa;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.pHT = uploadOptions;
            this.pHU = upCompletionHandler;
            this.val$key = str;
            this.pHV = configuration;
            this.pHW = upToken;
            this.pHX = str2;
            this.pHY = client;
            this.pHZ = postArgs;
            this.pIa = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.exN() && !AndroidNetwork.eyd()) {
                this.pHT.pIG.exX();
                if (!AndroidNetwork.eyd()) {
                    this.pHU.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.exM()) {
                this.pHT.pIE.d(this.val$key, 1.0d);
                this.pHU.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.exQ()) {
                final String d = this.pHV.pHR.d(this.pHW.token, this.pHV.useHttps, this.pHX);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.pHY.a(d, this.pHZ, this.pHW, this.pIa, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.exM()) {
                            AnonymousClass2.this.pHT.pIE.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.pHU.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.exQ()) {
                            final String d2 = AnonymousClass2.this.pHV.pHR.d(AnonymousClass2.this.pHW.token, AnonymousClass2.this.pHV.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.pHY.a(d2, AnonymousClass2.this.pHZ, AnonymousClass2.this.pHW, AnonymousClass2.this.pIa, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.exM()) {
                                        AnonymousClass2.this.pHT.pIE.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.exQ()) {
                                        AnonymousClass2.this.pHV.pHR.YJ(d2);
                                    }
                                    AnonymousClass2.this.pHU.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.pHT.pIF);
                        } else {
                            AnonymousClass2.this.pHU.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.pHT.pIF);
            } else {
                this.pHU.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
