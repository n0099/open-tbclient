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
        final UploadOptions dIm = uploadOptions != null ? uploadOptions : UploadOptions.dIm();
        stringMap.z(dIm.params);
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
                UploadOptions.this.nix.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dIm.mimeType;
        postArgs.nho = stringMap;
        String d = configuration.nhJ.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dIm, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dIm.niy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nhL;
        final /* synthetic */ UpCompletionHandler nhM;
        final /* synthetic */ Configuration nhN;
        final /* synthetic */ UpToken nhO;
        final /* synthetic */ String nhP;
        final /* synthetic */ Client nhQ;
        final /* synthetic */ PostArgs nhR;
        final /* synthetic */ ProgressHandler nhS;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nhL = uploadOptions;
            this.nhM = upCompletionHandler;
            this.val$key = str;
            this.nhN = configuration;
            this.nhO = upToken;
            this.nhP = str2;
            this.nhQ = client;
            this.nhR = postArgs;
            this.nhS = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dHX() && !AndroidNetwork.dIn()) {
                this.nhL.niz.dIh();
                if (!AndroidNetwork.dIn()) {
                    this.nhM.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dHW()) {
                this.nhL.nix.b(this.val$key, 1.0d);
                this.nhM.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dIa()) {
                final String d = this.nhN.nhJ.d(this.nhO.token, this.nhN.useHttps, this.nhP);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nhQ.a(d, this.nhR, this.nhO, this.nhS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dHW()) {
                            AnonymousClass2.this.nhL.nix.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nhM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dIa()) {
                            final String d2 = AnonymousClass2.this.nhN.nhJ.d(AnonymousClass2.this.nhO.token, AnonymousClass2.this.nhN.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nhQ.a(d2, AnonymousClass2.this.nhR, AnonymousClass2.this.nhO, AnonymousClass2.this.nhS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dHW()) {
                                        AnonymousClass2.this.nhL.nix.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dIa()) {
                                        AnonymousClass2.this.nhN.nhJ.QP(d2);
                                    }
                                    AnonymousClass2.this.nhM.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nhL.niy);
                        } else {
                            AnonymousClass2.this.nhM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nhL.niy);
            } else {
                this.nhM.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
