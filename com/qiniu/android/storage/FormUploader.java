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
            stringMap.L("key", str);
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
        stringMap.L("token", upToken.token);
        final UploadOptions dAI = uploadOptions != null ? uploadOptions : UploadOptions.dAI();
        stringMap.z(dAI.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.ai(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.ak(bArr);
        }
        stringMap.L("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.mNf.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dAI.mimeType;
        postArgs.mLX = stringMap;
        String d = configuration.mMs.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dAI, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dAI.mNg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ PostArgs mMA;
        final /* synthetic */ ProgressHandler mMB;
        final /* synthetic */ UploadOptions mMu;
        final /* synthetic */ UpCompletionHandler mMv;
        final /* synthetic */ Configuration mMw;
        final /* synthetic */ UpToken mMx;
        final /* synthetic */ String mMy;
        final /* synthetic */ Client mMz;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.mMu = uploadOptions;
            this.mMv = upCompletionHandler;
            this.val$key = str;
            this.mMw = configuration;
            this.mMx = upToken;
            this.mMy = str2;
            this.mMz = client;
            this.mMA = postArgs;
            this.mMB = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dAt() && !AndroidNetwork.dAJ()) {
                this.mMu.mNh.dAD();
                if (!AndroidNetwork.dAJ()) {
                    this.mMv.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dAs()) {
                this.mMu.mNf.b(this.val$key, 1.0d);
                this.mMv.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dAw()) {
                final String d = this.mMw.mMs.d(this.mMx.token, this.mMw.useHttps, this.mMy);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.mMz.a(d, this.mMA, this.mMx, this.mMB, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dAs()) {
                            AnonymousClass2.this.mMu.mNf.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.mMv.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dAw()) {
                            final String d2 = AnonymousClass2.this.mMw.mMs.d(AnonymousClass2.this.mMx.token, AnonymousClass2.this.mMw.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.mMz.a(d2, AnonymousClass2.this.mMA, AnonymousClass2.this.mMx, AnonymousClass2.this.mMB, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dAs()) {
                                        AnonymousClass2.this.mMu.mNf.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dAw()) {
                                        AnonymousClass2.this.mMw.mMs.OV(d2);
                                    }
                                    AnonymousClass2.this.mMv.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.mMu.mNg);
                        } else {
                            AnonymousClass2.this.mMv.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.mMu.mNg);
            } else {
                this.mMv.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
