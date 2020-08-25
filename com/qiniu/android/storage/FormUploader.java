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
        final UploadOptions ecv = uploadOptions != null ? uploadOptions : UploadOptions.ecv();
        stringMap.A(ecv.params);
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
                UploadOptions.this.ogT.c(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = ecv.mimeType;
        postArgs.ofL = stringMap;
        String d = configuration.ogg.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(ecv, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), ecv.ogU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions ogi;
        final /* synthetic */ UpCompletionHandler ogj;
        final /* synthetic */ Configuration ogk;
        final /* synthetic */ UpToken ogl;
        final /* synthetic */ String ogm;
        final /* synthetic */ Client ogn;
        final /* synthetic */ PostArgs ogo;
        final /* synthetic */ ProgressHandler ogp;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.ogi = uploadOptions;
            this.ogj = upCompletionHandler;
            this.val$key = str;
            this.ogk = configuration;
            this.ogl = upToken;
            this.ogm = str2;
            this.ogn = client;
            this.ogo = postArgs;
            this.ogp = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.ecg() && !AndroidNetwork.ecw()) {
                this.ogi.ogV.ecq();
                if (!AndroidNetwork.ecw()) {
                    this.ogj.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.ecf()) {
                this.ogi.ogT.c(this.val$key, 1.0d);
                this.ogj.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.ecj()) {
                final String d = this.ogk.ogg.d(this.ogl.token, this.ogk.useHttps, this.ogm);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.ogn.a(d, this.ogo, this.ogl, this.ogp, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.ecf()) {
                            AnonymousClass2.this.ogi.ogT.c(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.ogj.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.ecj()) {
                            final String d2 = AnonymousClass2.this.ogk.ogg.d(AnonymousClass2.this.ogl.token, AnonymousClass2.this.ogk.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.ogn.a(d2, AnonymousClass2.this.ogo, AnonymousClass2.this.ogl, AnonymousClass2.this.ogp, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.ecf()) {
                                        AnonymousClass2.this.ogi.ogT.c(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.ecj()) {
                                        AnonymousClass2.this.ogk.ogg.Vr(d2);
                                    }
                                    AnonymousClass2.this.ogj.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.ogi.ogU);
                        } else {
                            AnonymousClass2.this.ogj.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.ogi.ogU);
            } else {
                this.ogj.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
