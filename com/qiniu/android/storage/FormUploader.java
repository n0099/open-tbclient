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
        final UploadOptions egB = uploadOptions != null ? uploadOptions : UploadOptions.egB();
        stringMap.A(egB.params);
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
                UploadOptions.this.oqU.d(str, d <= 0.95d ? d : 0.95d);
            }
        };
        postArgs.data = bArr;
        postArgs.file = file;
        postArgs.mimeType = egB.mimeType;
        postArgs.opM = stringMap;
        String d = configuration.oqh.d(upToken.token, configuration.useHttps, null);
        Log.d("Qiniu.FormUploader", "upload use up host " + d);
        client.a(d, postArgs, upToken, progressHandler, new AnonymousClass2(egB, upCompletionHandler, str, configuration, upToken, d, client, postArgs, progressHandler), egB.oqV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.android.storage.FormUploader$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass2 implements CompletionHandler {
        final /* synthetic */ UploadOptions oqj;
        final /* synthetic */ UpCompletionHandler oqk;
        final /* synthetic */ Configuration oql;
        final /* synthetic */ UpToken oqm;
        final /* synthetic */ String oqn;
        final /* synthetic */ Client oqo;
        final /* synthetic */ PostArgs oqp;
        final /* synthetic */ ProgressHandler oqq;
        final /* synthetic */ String val$key;

        AnonymousClass2(UploadOptions uploadOptions, UpCompletionHandler upCompletionHandler, String str, Configuration configuration, UpToken upToken, String str2, Client client, PostArgs postArgs, ProgressHandler progressHandler) {
            this.oqj = uploadOptions;
            this.oqk = upCompletionHandler;
            this.val$key = str;
            this.oql = configuration;
            this.oqm = upToken;
            this.oqn = str2;
            this.oqo = client;
            this.oqp = postArgs;
            this.oqq = progressHandler;
        }

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo.egm() && !AndroidNetwork.egC()) {
                this.oqj.oqW.egw();
                if (!AndroidNetwork.egC()) {
                    this.oqk.a(this.val$key, responseInfo, jSONObject);
                    return;
                }
            }
            if (responseInfo.egl()) {
                this.oqj.oqU.d(this.val$key, 1.0d);
                this.oqk.a(this.val$key, responseInfo, jSONObject);
            } else if (responseInfo.egp()) {
                final String d = this.oql.oqh.d(this.oqm.token, this.oql.useHttps, this.oqn);
                Log.d("Qiniu.FormUploader", "retry upload first time use up host " + d);
                this.oqo.a(d, this.oqp, this.oqm, this.oqq, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1
                    @Override // com.qiniu.android.http.CompletionHandler
                    public void a(ResponseInfo responseInfo2, JSONObject jSONObject2) {
                        if (responseInfo2.egl()) {
                            AnonymousClass2.this.oqj.oqU.d(AnonymousClass2.this.val$key, 1.0d);
                            AnonymousClass2.this.oqk.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        } else if (responseInfo2.egp()) {
                            final String d2 = AnonymousClass2.this.oql.oqh.d(AnonymousClass2.this.oqm.token, AnonymousClass2.this.oql.useHttps, d);
                            Log.d("Qiniu.FormUploader", "retry upload second time use up host " + d2);
                            AnonymousClass2.this.oqo.a(d2, AnonymousClass2.this.oqp, AnonymousClass2.this.oqm, AnonymousClass2.this.oqq, new CompletionHandler() { // from class: com.qiniu.android.storage.FormUploader.2.1.1
                                @Override // com.qiniu.android.http.CompletionHandler
                                public void a(ResponseInfo responseInfo3, JSONObject jSONObject3) {
                                    if (responseInfo3.egl()) {
                                        AnonymousClass2.this.oqj.oqU.d(AnonymousClass2.this.val$key, 1.0d);
                                    } else if (responseInfo3.egp()) {
                                        AnonymousClass2.this.oql.oqh.VT(d2);
                                    }
                                    AnonymousClass2.this.oqk.a(AnonymousClass2.this.val$key, responseInfo3, jSONObject3);
                                }
                            }, AnonymousClass2.this.oqj.oqV);
                        } else {
                            AnonymousClass2.this.oqk.a(AnonymousClass2.this.val$key, responseInfo2, jSONObject2);
                        }
                    }
                }, this.oqj.oqV);
            } else {
                this.oqk.a(this.val$key, responseInfo, jSONObject);
            }
        }
    }
}
