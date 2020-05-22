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
/* loaded from: classes5.dex */
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
        final UploadOptions dHY = uploadOptions != null ? uploadOptions : UploadOptions.dHY();
        stringMap.z(dHY.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.am(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.ar(bArr);
        }
        stringMap.O("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.nhm.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dHY.mimeType;
        postArgs.nge = stringMap;
        String d = configuration.ngz.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dHY, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dHY.nhn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions ngB;
        final /* synthetic */ UpCompletionHandler ngC;
        final /* synthetic */ Configuration ngD;
        final /* synthetic */ UpToken ngE;
        final /* synthetic */ String ngF;
        final /* synthetic */ Client ngG;
        final /* synthetic */ PostArgs ngH;
        final /* synthetic */ ProgressHandler ngI;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.ngB = uploadOptions;
            this.ngC = upCompletionHandler;
            this.val$key = str;
            this.ngD = configuration;
            this.ngE = upToken;
            this.ngF = str2;
            this.ngG = client;
            this.ngH = postArgs;
            this.ngI = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dHJ() && !AndroidNetwork.dHZ()) {
                this.ngB.nho.dHT();
                if (!AndroidNetwork.dHZ()) {
                    this.ngC.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dHI()) {
                this.ngB.nhm.b(this.val$key, 1.0d);
                this.ngC.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dHM()) {
                final String d = this.ngD.ngz.d(this.ngE.token, this.ngD.useHttps, this.ngF);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.ngG.a(d, this.ngH, this.ngE, this.ngI, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dHI()) {
                            AnonymousClass2.this.ngB.nhm.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.ngC.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dHM()) {
                            final String d2 = AnonymousClass2.this.ngD.ngz.d(AnonymousClass2.this.ngE.token, AnonymousClass2.this.ngD.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.ngG.a(d2, AnonymousClass2.this.ngH, AnonymousClass2.this.ngE, AnonymousClass2.this.ngI, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dHI()) {
                                        AnonymousClass2.this.ngB.nhm.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dHM()) {
                                        AnonymousClass2.this.ngD.ngz.QO(d2);
                                    }
                                    AnonymousClass2.this.ngC.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.ngB.nhn);
                        } else {
                            AnonymousClass2.this.ngC.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.ngB.nhn);
            } else {
                this.ngC.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
