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
        final UploadOptions ekm = uploadOptions != null ? uploadOptions : UploadOptions.ekm();
        stringMap.K(ekm.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.au(file);
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
                UploadOptions.this.oGl.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = ekm.mimeType;
        postArgs.oFd = stringMap;
        String d = configuration.oFy.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(ekm, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), ekm.oGm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions oFA;
        final /* synthetic */ UpCompletionHandler oFB;
        final /* synthetic */ Configuration oFC;
        final /* synthetic */ UpToken oFD;
        final /* synthetic */ String oFE;
        final /* synthetic */ Client oFF;
        final /* synthetic */ PostArgs oFG;
        final /* synthetic */ ProgressHandler oFH;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.oFA = uploadOptions;
            this.oFB = upCompletionHandler;
            this.val$key = str;
            this.oFC = configuration;
            this.oFD = upToken;
            this.oFE = str2;
            this.oFF = client;
            this.oFG = postArgs;
            this.oFH = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.ejX() && !AndroidNetwork.ekn()) {
                this.oFA.oGn.ekh();
                if (!AndroidNetwork.ekn()) {
                    this.oFB.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.ejW()) {
                this.oFA.oGl.d(this.val$key, 1.0d);
                this.oFB.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.eka()) {
                final String d = this.oFC.oFy.d(this.oFD.token, this.oFC.useHttps, this.oFE);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.oFF.a(d, this.oFG, this.oFD, this.oFH, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.ejW()) {
                            AnonymousClass2.this.oFA.oGl.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.oFB.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.eka()) {
                            final String d2 = AnonymousClass2.this.oFC.oFy.d(AnonymousClass2.this.oFD.token, AnonymousClass2.this.oFC.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.oFF.a(d2, AnonymousClass2.this.oFG, AnonymousClass2.this.oFD, AnonymousClass2.this.oFH, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.ejW()) {
                                        AnonymousClass2.this.oFA.oGl.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.eka()) {
                                        AnonymousClass2.this.oFC.oFy.WH(d2);
                                    }
                                    AnonymousClass2.this.oFB.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.oFA.oGm);
                        } else {
                            AnonymousClass2.this.oFB.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.oFA.oGm);
            } else {
                this.oFB.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
