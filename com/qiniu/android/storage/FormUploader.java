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
        final UploadOptions eyb = uploadOptions != null ? uploadOptions : UploadOptions.eyb();
        stringMap.K(eyb.params);
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
                UploadOptions.this.pHb.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = eyb.mimeType;
        postArgs.pFT = stringMap;
        String d = configuration.pGo.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(eyb, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), eyb.pHc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions pGq;
        final /* synthetic */ UpCompletionHandler pGr;
        final /* synthetic */ Configuration pGs;
        final /* synthetic */ UpToken pGt;
        final /* synthetic */ String pGu;
        final /* synthetic */ Client pGv;
        final /* synthetic */ PostArgs pGw;
        final /* synthetic */ ProgressHandler pGx;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.pGq = uploadOptions;
            this.pGr = upCompletionHandler;
            this.val$key = str;
            this.pGs = configuration;
            this.pGt = upToken;
            this.pGu = str2;
            this.pGv = client;
            this.pGw = postArgs;
            this.pGx = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.exM() && !AndroidNetwork.eyc()) {
                this.pGq.pHd.exW();
                if (!AndroidNetwork.eyc()) {
                    this.pGr.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.exL()) {
                this.pGq.pHb.d(this.val$key, 1.0d);
                this.pGr.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.exP()) {
                final String d = this.pGs.pGo.d(this.pGt.token, this.pGs.useHttps, this.pGu);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.pGv.a(d, this.pGw, this.pGt, this.pGx, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.exL()) {
                            AnonymousClass2.this.pGq.pHb.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.pGr.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.exP()) {
                            final String d2 = AnonymousClass2.this.pGs.pGo.d(AnonymousClass2.this.pGt.token, AnonymousClass2.this.pGs.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.pGv.a(d2, AnonymousClass2.this.pGw, AnonymousClass2.this.pGt, AnonymousClass2.this.pGx, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.exL()) {
                                        AnonymousClass2.this.pGq.pHb.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.exP()) {
                                        AnonymousClass2.this.pGs.pGo.YY(d2);
                                    }
                                    AnonymousClass2.this.pGr.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.pGq.pHc);
                        } else {
                            AnonymousClass2.this.pGr.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.pGq.pHc);
            } else {
                this.pGr.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
