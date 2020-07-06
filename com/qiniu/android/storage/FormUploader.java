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
        final UploadOptions dMW = uploadOptions != null ? uploadOptions : UploadOptions.dMW();
        stringMap.A(dMW.params);
        long j = 0;
        if (file != null) {
            try {
                j = Crc32.an(file);
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
                UploadOptions.this.nEp.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dMW.mimeType;
        postArgs.nDh = stringMap;
        String d = configuration.nDC.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dMW, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dMW.nEq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nDE;
        final /* synthetic */ UpCompletionHandler nDF;
        final /* synthetic */ Configuration nDG;
        final /* synthetic */ UpToken nDH;
        final /* synthetic */ String nDI;
        final /* synthetic */ Client nDJ;
        final /* synthetic */ PostArgs nDK;
        final /* synthetic */ ProgressHandler nDL;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nDE = uploadOptions;
            this.nDF = upCompletionHandler;
            this.val$key = str;
            this.nDG = configuration;
            this.nDH = upToken;
            this.nDI = str2;
            this.nDJ = client;
            this.nDK = postArgs;
            this.nDL = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dMH() && !AndroidNetwork.dMX()) {
                this.nDE.nEr.dMR();
                if (!AndroidNetwork.dMX()) {
                    this.nDF.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dMG()) {
                this.nDE.nEp.b(this.val$key, 1.0d);
                this.nDF.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dMK()) {
                final String d = this.nDG.nDC.d(this.nDH.token, this.nDG.useHttps, this.nDI);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nDJ.a(d, this.nDK, this.nDH, this.nDL, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dMG()) {
                            AnonymousClass2.this.nDE.nEp.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nDF.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dMK()) {
                            final String d2 = AnonymousClass2.this.nDG.nDC.d(AnonymousClass2.this.nDH.token, AnonymousClass2.this.nDG.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nDJ.a(d2, AnonymousClass2.this.nDK, AnonymousClass2.this.nDH, AnonymousClass2.this.nDL, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dMG()) {
                                        AnonymousClass2.this.nDE.nEp.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dMK()) {
                                        AnonymousClass2.this.nDG.nDC.RC(d2);
                                    }
                                    AnonymousClass2.this.nDF.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nDE.nEq);
                        } else {
                            AnonymousClass2.this.nDF.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nDE.nEq);
            } else {
                this.nDF.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
