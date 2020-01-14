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
        final UploadOptions dEW = uploadOptions != null ? uploadOptions : UploadOptions.dEW();
        stringMap.B(dEW.params);
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
                UploadOptions.this.nnT.a(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dEW.mimeType;
        postArgs.nmL = stringMap;
        String d = configuration.nng.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dEW, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dEW.nnU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nni;
        final /* synthetic */ UpCompletionHandler nnj;
        final /* synthetic */ Configuration nnk;
        final /* synthetic */ UpToken nnl;
        final /* synthetic */ String nnm;
        final /* synthetic */ Client nnn;
        final /* synthetic */ PostArgs nno;
        final /* synthetic */ ProgressHandler nnp;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nni = uploadOptions;
            this.nnj = upCompletionHandler;
            this.val$key = str;
            this.nnk = configuration;
            this.nnl = upToken;
            this.nnm = str2;
            this.nnn = client;
            this.nno = postArgs;
            this.nnp = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dEG() && !AndroidNetwork.dEX()) {
                this.nni.nnV.dER();
                if (!AndroidNetwork.dEX()) {
                    this.nnj.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dEF()) {
                this.nni.nnT.a(this.val$key, 1.0d);
                this.nnj.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dEJ()) {
                final String d = this.nnk.nng.d(this.nnl.token, this.nnk.useHttps, this.nnm);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nnn.a(d, this.nno, this.nnl, this.nnp, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dEF()) {
                            AnonymousClass2.this.nni.nnT.a(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nnj.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dEJ()) {
                            final String d2 = AnonymousClass2.this.nnk.nng.d(AnonymousClass2.this.nnl.token, AnonymousClass2.this.nnk.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nnn.a(d2, AnonymousClass2.this.nno, AnonymousClass2.this.nnl, AnonymousClass2.this.nnp, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dEF()) {
                                        AnonymousClass2.this.nni.nnT.a(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dEJ()) {
                                        AnonymousClass2.this.nnk.nng.QZ(d2);
                                    }
                                    AnonymousClass2.this.nnj.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nni.nnU);
                        } else {
                            AnonymousClass2.this.nnj.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nni.nnU);
            } else {
                this.nnj.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
