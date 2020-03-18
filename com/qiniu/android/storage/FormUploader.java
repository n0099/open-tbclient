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
        final UploadOptions dGG = uploadOptions != null ? uploadOptions : UploadOptions.dGG();
        stringMap.B(dGG.params);
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
                UploadOptions.this.nqw.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dGG.mimeType;
        postArgs.npo = stringMap;
        String d = configuration.npJ.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dGG, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dGG.nqx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions npL;
        final /* synthetic */ UpCompletionHandler npM;
        final /* synthetic */ Configuration npN;
        final /* synthetic */ UpToken npO;
        final /* synthetic */ String npP;
        final /* synthetic */ Client npQ;
        final /* synthetic */ PostArgs npR;
        final /* synthetic */ ProgressHandler npS;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.npL = uploadOptions;
            this.npM = upCompletionHandler;
            this.val$key = str;
            this.npN = configuration;
            this.npO = upToken;
            this.npP = str2;
            this.npQ = client;
            this.npR = postArgs;
            this.npS = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dGq() && !AndroidNetwork.dGH()) {
                this.npL.nqy.dGB();
                if (!AndroidNetwork.dGH()) {
                    this.npM.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dGp()) {
                this.npL.nqw.b(this.val$key, 1.0d);
                this.npM.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dGt()) {
                final String d = this.npN.npJ.d(this.npO.token, this.npN.useHttps, this.npP);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.npQ.a(d, this.npR, this.npO, this.npS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dGp()) {
                            AnonymousClass2.this.npL.nqw.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.npM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dGt()) {
                            final String d2 = AnonymousClass2.this.npN.npJ.d(AnonymousClass2.this.npO.token, AnonymousClass2.this.npN.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.npQ.a(d2, AnonymousClass2.this.npR, AnonymousClass2.this.npO, AnonymousClass2.this.npS, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dGp()) {
                                        AnonymousClass2.this.npL.nqw.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dGt()) {
                                        AnonymousClass2.this.npN.npJ.Rk(d2);
                                    }
                                    AnonymousClass2.this.npM.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.npL.nqx);
                        } else {
                            AnonymousClass2.this.npM.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.npL.nqx);
            } else {
                this.npM.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
