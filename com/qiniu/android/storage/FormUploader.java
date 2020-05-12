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
        final UploadOptions dAF = uploadOptions != null ? uploadOptions : UploadOptions.dAF();
        stringMap.z(dAF.params);
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
                UploadOptions.this.mNi.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dAF.mimeType;
        postArgs.mMa = stringMap;
        String d = configuration.mMv.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dAF, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dAF.mNj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UpToken mMA;
        final /* synthetic */ String mMB;
        final /* synthetic */ Client mMC;
        final /* synthetic */ PostArgs mMD;
        final /* synthetic */ ProgressHandler mME;
        final /* synthetic */ UploadOptions mMx;
        final /* synthetic */ UpCompletionHandler mMy;
        final /* synthetic */ Configuration mMz;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.mMx = uploadOptions;
            this.mMy = upCompletionHandler;
            this.val$key = str;
            this.mMz = configuration;
            this.mMA = upToken;
            this.mMB = str2;
            this.mMC = client;
            this.mMD = postArgs;
            this.mME = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dAq() && !AndroidNetwork.dAG()) {
                this.mMx.mNk.dAA();
                if (!AndroidNetwork.dAG()) {
                    this.mMy.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dAp()) {
                this.mMx.mNi.b(this.val$key, 1.0d);
                this.mMy.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dAt()) {
                final String d = this.mMz.mMv.d(this.mMA.token, this.mMz.useHttps, this.mMB);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.mMC.a(d, this.mMD, this.mMA, this.mME, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dAp()) {
                            AnonymousClass2.this.mMx.mNi.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.mMy.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dAt()) {
                            final String d2 = AnonymousClass2.this.mMz.mMv.d(AnonymousClass2.this.mMA.token, AnonymousClass2.this.mMz.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.mMC.a(d2, AnonymousClass2.this.mMD, AnonymousClass2.this.mMA, AnonymousClass2.this.mME, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dAp()) {
                                        AnonymousClass2.this.mMx.mNi.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dAt()) {
                                        AnonymousClass2.this.mMz.mMv.OY(d2);
                                    }
                                    AnonymousClass2.this.mMy.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.mMx.mNj);
                        } else {
                            AnonymousClass2.this.mMy.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.mMx.mNj);
            } else {
                this.mMy.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
