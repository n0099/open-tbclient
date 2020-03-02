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
        final UploadOptions dGf = uploadOptions != null ? uploadOptions : UploadOptions.dGf();
        stringMap.B(dGf.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.an(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.aE(bArr);
        }
        stringMap.H("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.noy.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dGf.mimeType;
        postArgs.nno = stringMap;
        String d = configuration.nnJ.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dGf, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dGf.noz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nnL;
        final /* synthetic */ UpCompletionHandler nnM;
        final /* synthetic */ Configuration nnN;
        final /* synthetic */ UpToken nnO;
        final /* synthetic */ String nnP;
        final /* synthetic */ Client nnQ;
        final /* synthetic */ PostArgs nnR;
        final /* synthetic */ ProgressHandler nnS;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nnL = uploadOptions;
            this.nnM = upCompletionHandler;
            this.val$key = str;
            this.nnN = configuration;
            this.nnO = upToken;
            this.nnP = str2;
            this.nnQ = client;
            this.nnR = postArgs;
            this.nnS = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dFP() && !AndroidNetwork.dGg()) {
                this.nnL.noA.dGa();
                if (!AndroidNetwork.dGg()) {
                    this.nnM.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dFO()) {
                this.nnL.noy.b(this.val$key, 1.0d);
                this.nnM.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dFS()) {
                final String d = this.nnN.nnJ.d(this.nnO.token, this.nnN.useHttps, this.nnP);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nnQ.a(d, this.nnR, this.nnO, this.nnS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dFO()) {
                            AnonymousClass2.this.nnL.noy.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nnM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dFS()) {
                            final String d2 = AnonymousClass2.this.nnN.nnJ.d(AnonymousClass2.this.nnO.token, AnonymousClass2.this.nnN.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nnQ.a(d2, AnonymousClass2.this.nnR, AnonymousClass2.this.nnO, AnonymousClass2.this.nnS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dFO()) {
                                        AnonymousClass2.this.nnL.noy.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dFS()) {
                                        AnonymousClass2.this.nnN.nnJ.Rk(d2);
                                    }
                                    AnonymousClass2.this.nnM.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nnL.noz);
                        } else {
                            AnonymousClass2.this.nnM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nnL.noz);
            } else {
                this.nnM.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
