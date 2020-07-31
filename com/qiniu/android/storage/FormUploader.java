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
        final UploadOptions dQs = uploadOptions != null ? uploadOptions : UploadOptions.dQs();
        stringMap.A(dQs.params);
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
                UploadOptions.this.nMX.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dQs.mimeType;
        postArgs.nLP = stringMap;
        String d = configuration.nMk.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dQs, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dQs.nMY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nMm;
        final /* synthetic */ UpCompletionHandler nMn;
        final /* synthetic */ Configuration nMo;
        final /* synthetic */ UpToken nMp;
        final /* synthetic */ String nMq;
        final /* synthetic */ Client nMr;
        final /* synthetic */ PostArgs nMs;
        final /* synthetic */ ProgressHandler nMt;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nMm = uploadOptions;
            this.nMn = upCompletionHandler;
            this.val$key = str;
            this.nMo = configuration;
            this.nMp = upToken;
            this.nMq = str2;
            this.nMr = client;
            this.nMs = postArgs;
            this.nMt = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dQd() && !AndroidNetwork.dQt()) {
                this.nMm.nMZ.dQn();
                if (!AndroidNetwork.dQt()) {
                    this.nMn.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dQc()) {
                this.nMm.nMX.b(this.val$key, 1.0d);
                this.nMn.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dQg()) {
                final String d = this.nMo.nMk.d(this.nMp.token, this.nMo.useHttps, this.nMq);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nMr.a(d, this.nMs, this.nMp, this.nMt, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dQc()) {
                            AnonymousClass2.this.nMm.nMX.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nMn.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dQg()) {
                            final String d2 = AnonymousClass2.this.nMo.nMk.d(AnonymousClass2.this.nMp.token, AnonymousClass2.this.nMo.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nMr.a(d2, AnonymousClass2.this.nMs, AnonymousClass2.this.nMp, AnonymousClass2.this.nMt, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dQc()) {
                                        AnonymousClass2.this.nMm.nMX.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dQg()) {
                                        AnonymousClass2.this.nMo.nMk.Sn(d2);
                                    }
                                    AnonymousClass2.this.nMn.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nMm.nMY);
                        } else {
                            AnonymousClass2.this.nMn.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nMm.nMY);
            } else {
                this.nMn.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
