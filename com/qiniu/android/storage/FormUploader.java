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
        final UploadOptions eum = uploadOptions != null ? uploadOptions : UploadOptions.eum();
        stringMap.K(eum.params);
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
                UploadOptions.this.pxI.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = eum.mimeType;
        postArgs.pwA = stringMap;
        String d = configuration.pwV.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(eum, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), eum.pxJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions pwX;
        final /* synthetic */ UpCompletionHandler pwY;
        final /* synthetic */ Configuration pwZ;
        final /* synthetic */ UpToken pxa;
        final /* synthetic */ String pxb;
        final /* synthetic */ Client pxc;
        final /* synthetic */ PostArgs pxd;
        final /* synthetic */ ProgressHandler pxe;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.pwX = uploadOptions;
            this.pwY = upCompletionHandler;
            this.val$key = str;
            this.pwZ = configuration;
            this.pxa = upToken;
            this.pxb = str2;
            this.pxc = client;
            this.pxd = postArgs;
            this.pxe = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.etX() && !AndroidNetwork.eun()) {
                this.pwX.pxK.euh();
                if (!AndroidNetwork.eun()) {
                    this.pwY.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.etW()) {
                this.pwX.pxI.d(this.val$key, 1.0d);
                this.pwY.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.eua()) {
                final String d = this.pwZ.pwV.d(this.pxa.token, this.pwZ.useHttps, this.pxb);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.pxc.a(d, this.pxd, this.pxa, this.pxe, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.etW()) {
                            AnonymousClass2.this.pwX.pxI.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.pwY.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.eua()) {
                            final String d2 = AnonymousClass2.this.pwZ.pwV.d(AnonymousClass2.this.pxa.token, AnonymousClass2.this.pwZ.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.pxc.a(d2, AnonymousClass2.this.pxd, AnonymousClass2.this.pxa, AnonymousClass2.this.pxe, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.etW()) {
                                        AnonymousClass2.this.pwX.pxI.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.eua()) {
                                        AnonymousClass2.this.pwZ.pwV.Yu(d2);
                                    }
                                    AnonymousClass2.this.pwY.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.pwX.pxJ);
                        } else {
                            AnonymousClass2.this.pwY.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.pwX.pxJ);
            } else {
                this.pwY.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
