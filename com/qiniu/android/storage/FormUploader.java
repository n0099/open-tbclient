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
        final UploadOptions dMS = uploadOptions != null ? uploadOptions : UploadOptions.dMS();
        stringMap.A(dMS.params);
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
                UploadOptions.this.nEm.b(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = dMS.mimeType;
        postArgs.nDe = stringMap;
        String d = configuration.nDz.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(dMS, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), dMS.nEn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions nDB;
        final /* synthetic */ UpCompletionHandler nDC;
        final /* synthetic */ Configuration nDD;
        final /* synthetic */ UpToken nDE;
        final /* synthetic */ String nDF;
        final /* synthetic */ Client nDG;
        final /* synthetic */ PostArgs nDH;
        final /* synthetic */ ProgressHandler nDI;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.nDB = uploadOptions;
            this.nDC = upCompletionHandler;
            this.val$key = str;
            this.nDD = configuration;
            this.nDE = upToken;
            this.nDF = str2;
            this.nDG = client;
            this.nDH = postArgs;
            this.nDI = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.dMD() && !AndroidNetwork.dMT()) {
                this.nDB.nEo.dMN();
                if (!AndroidNetwork.dMT()) {
                    this.nDC.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.dMC()) {
                this.nDB.nEm.b(this.val$key, 1.0d);
                this.nDC.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.dMG()) {
                final String d = this.nDD.nDz.d(this.nDE.token, this.nDD.useHttps, this.nDF);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.nDG.a(d, this.nDH, this.nDE, this.nDI, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.dMC()) {
                            AnonymousClass2.this.nDB.nEm.b(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.nDC.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.dMG()) {
                            final String d2 = AnonymousClass2.this.nDD.nDz.d(AnonymousClass2.this.nDE.token, AnonymousClass2.this.nDD.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.nDG.a(d2, AnonymousClass2.this.nDH, AnonymousClass2.this.nDE, AnonymousClass2.this.nDI, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.dMC()) {
                                        AnonymousClass2.this.nDB.nEm.b(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.dMG()) {
                                        AnonymousClass2.this.nDD.nDz.RB(d2);
                                    }
                                    AnonymousClass2.this.nDC.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.nDB.nEn);
                        } else {
                            AnonymousClass2.this.nDC.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.nDB.nEn);
            } else {
                this.nDC.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
