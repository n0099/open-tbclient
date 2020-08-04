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
        final UploadOptions dQt = uploadOptions != null ? uploadOptions : UploadOptions.dQt();
        stringMap.A(dQt.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.aq(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.at(bArr);
        }
        stringMap.O("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.nMZ.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dQt.mimeType;
        postArgs.nLR = stringMap;
        String d = configuration.nMm.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dQt, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dQt.nNa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nMo;
        final /* synthetic */ UpCompletionHandler nMp;
        final /* synthetic */ Configuration nMq;
        final /* synthetic */ UpToken nMr;
        final /* synthetic */ String nMs;
        final /* synthetic */ Client nMt;
        final /* synthetic */ PostArgs nMu;
        final /* synthetic */ ProgressHandler nMv;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nMo = uploadOptions;
            this.nMp = upCompletionHandler;
            this.val$key = str;
            this.nMq = configuration;
            this.nMr = upToken;
            this.nMs = str2;
            this.nMt = client;
            this.nMu = postArgs;
            this.nMv = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dQe() && !AndroidNetwork.dQu()) {
                this.nMo.nNb.dQo();
                if (!AndroidNetwork.dQu()) {
                    this.nMp.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dQd()) {
                this.nMo.nMZ.b(this.val$key, 1.0d);
                this.nMp.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dQh()) {
                final String d = this.nMq.nMm.d(this.nMr.token, this.nMq.useHttps, this.nMs);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nMt.a(d, this.nMu, this.nMr, this.nMv, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dQd()) {
                            AnonymousClass2.this.nMo.nMZ.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nMp.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dQh()) {
                            final String d2 = AnonymousClass2.this.nMq.nMm.d(AnonymousClass2.this.nMr.token, AnonymousClass2.this.nMq.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nMt.a(d2, AnonymousClass2.this.nMu, AnonymousClass2.this.nMr, AnonymousClass2.this.nMv, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dQd()) {
                                        AnonymousClass2.this.nMo.nMZ.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dQh()) {
                                        AnonymousClass2.this.nMq.nMm.Sn(d2);
                                    }
                                    AnonymousClass2.this.nMp.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nMo.nNa);
                        } else {
                            AnonymousClass2.this.nMp.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nMo.nNa);
            } else {
                this.nMp.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
