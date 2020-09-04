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
            stringMap.N("key", str);
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
        stringMap.N("token", upToken.token);
        final UploadOptions ecE = uploadOptions != null ? uploadOptions : UploadOptions.ecE();
        stringMap.A(ecE.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.ar(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            j = Crc32.au(bArr);
        }
        stringMap.N("crc32", "" + j);
        ProgressHandler progressHandler = new ProgressHandler() { // from class: com.qiniu.android.storage.FormUploader.1
            @Override // com.qiniu.android.http.ProgressHandler
            public void onProgress(long j2, long j3) {
                double d = j2 / j3;
                UploadOptions.this.ohl.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = ecE.mimeType;
        postArgs.ogd = stringMap;
        String d = configuration.ogy.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(ecE, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), ecE.ohm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions ogA;
        final /* synthetic */ UpCompletionHandler ogB;
        final /* synthetic */ Configuration ogC;
        final /* synthetic */ UpToken ogD;
        final /* synthetic */ String ogE;
        final /* synthetic */ Client ogF;
        final /* synthetic */ PostArgs ogG;
        final /* synthetic */ ProgressHandler ogH;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.ogA = uploadOptions;
            this.ogB = upCompletionHandler;
            this.val$key = str;
            this.ogC = configuration;
            this.ogD = upToken;
            this.ogE = str2;
            this.ogF = client;
            this.ogG = postArgs;
            this.ogH = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.ecp() && !AndroidNetwork.ecF()) {
                this.ogA.ohn.ecz();
                if (!AndroidNetwork.ecF()) {
                    this.ogB.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.eco()) {
                this.ogA.ohl.d(this.val$key, 1.0d);
                this.ogB.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.ecs()) {
                final String d = this.ogC.ogy.d(this.ogD.token, this.ogC.useHttps, this.ogE);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.ogF.a(d, this.ogG, this.ogD, this.ogH, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.eco()) {
                            AnonymousClass2.this.ogA.ohl.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.ogB.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.ecs()) {
                            final String d2 = AnonymousClass2.this.ogC.ogy.d(AnonymousClass2.this.ogD.token, AnonymousClass2.this.ogC.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.ogF.a(d2, AnonymousClass2.this.ogG, AnonymousClass2.this.ogD, AnonymousClass2.this.ogH, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.eco()) {
                                        AnonymousClass2.this.ogA.ohl.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.ecs()) {
                                        AnonymousClass2.this.ogC.ogy.Vr(d2);
                                    }
                                    AnonymousClass2.this.ogB.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.ogA.ohm);
                        } else {
                            AnonymousClass2.this.ogB.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.ogA.ohm);
            } else {
                this.ogB.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
