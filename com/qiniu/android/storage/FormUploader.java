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
/* loaded from: classes4.dex */
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
            stringMap.H("key", str);
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
        stringMap.H("token", upToken.token);
        final UploadOptions dEU = uploadOptions != null ? uploadOptions : UploadOptions.dEU();
        stringMap.B(dEU.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.al(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.az(bArr);
        }
        stringMap.H("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.nnO.a(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dEU.mimeType;
        postArgs.nmG = stringMap;
        String d = configuration.nnb.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dEU, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dEU.nnP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nnd;
        final /* synthetic */ UpCompletionHandler nne;
        final /* synthetic */ Configuration nnf;
        final /* synthetic */ UpToken nng;
        final /* synthetic */ String nnh;
        final /* synthetic */ Client nni;
        final /* synthetic */ PostArgs nnj;
        final /* synthetic */ ProgressHandler nnk;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nnd = uploadOptions;
            this.nne = upCompletionHandler;
            this.val$key = str;
            this.nnf = configuration;
            this.nng = upToken;
            this.nnh = str2;
            this.nni = client;
            this.nnj = postArgs;
            this.nnk = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dEE() && !AndroidNetwork.dEV()) {
                this.nnd.nnQ.dEP();
                if (!AndroidNetwork.dEV()) {
                    this.nne.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dED()) {
                this.nnd.nnO.a(this.val$key, 1.0d);
                this.nne.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dEH()) {
                final String d = this.nnf.nnb.d(this.nng.token, this.nnf.useHttps, this.nnh);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nni.a(d, this.nnj, this.nng, this.nnk, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dED()) {
                            AnonymousClass2.this.nnd.nnO.a(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nne.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dEH()) {
                            final String d2 = AnonymousClass2.this.nnf.nnb.d(AnonymousClass2.this.nng.token, AnonymousClass2.this.nnf.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nni.a(d2, AnonymousClass2.this.nnj, AnonymousClass2.this.nng, AnonymousClass2.this.nnk, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dED()) {
                                        AnonymousClass2.this.nnd.nnO.a(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dEH()) {
                                        AnonymousClass2.this.nnf.nnb.QZ(d2);
                                    }
                                    AnonymousClass2.this.nne.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nnd.nnP);
                        } else {
                            AnonymousClass2.this.nne.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nnd.nnP);
            } else {
                this.nne.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
