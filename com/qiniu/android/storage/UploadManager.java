package com.qiniu.android.storage;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class UploadManager {
    private static OkHttpClient sClient;
    private final Client ngK;
    private final Configuration nhZ;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dIl() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dIg());
    }

    public UploadManager(Configuration configuration) {
        this.nhZ = configuration;
        this.ngK = new Client(configuration.nhE, configuration.connectTimeout, configuration.responseTimeout, configuration.nhH, configuration.nhI);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo QS;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            QS = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nim || upToken == null) {
            QS = ResponseInfo.QS("invalid token");
        } else {
            QS = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (QS != null) {
            upCompletionHandler.a(str, QS, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WarpHandler a(UpCompletionHandler upCompletionHandler, long j) {
        return new WarpHandler(upCompletionHandler, j);
    }

    /* renamed from: com.qiniu.android.storage.UploadManager$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Zone.QueryHandler {
        final /* synthetic */ byte[] bNE;
        final /* synthetic */ UploadOptions nhL;
        final /* synthetic */ UpToken nin;
        final /* synthetic */ UpCompletionHandler nio;
        final /* synthetic */ UploadManager nip;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nip.ngK, this.nip.nhZ, this.bNE, this.val$key, this.nin, this.nio, this.nhL);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void JA(int i) {
            ResponseInfo QS;
            if (ResponseInfo.JB(i)) {
                QS = ResponseInfo.a(i, this.nin);
            } else {
                QS = ResponseInfo.QS("invalid token");
            }
            this.nio.a(this.val$key, QS, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken QW = UpToken.QW(str2);
        if (!a(str, null, file, str2, QW, upCompletionHandler)) {
            this.nhZ.nhJ.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nhZ.nhF) {
                        FormUploader.a(UploadManager.this.ngK, UploadManager.this.nhZ, file, str, QW, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.I(new ResumeUploader(UploadManager.this.ngK, UploadManager.this.nhZ, file, str, QW, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nhZ.nhD.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void JA(int i) {
                    ResponseInfo QS;
                    if (ResponseInfo.JB(i)) {
                        QS = ResponseInfo.a(i, QW);
                    } else {
                        QS = ResponseInfo.QS("invalid token");
                    }
                    upCompletionHandler.a(str, QS, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler niq;
        final long nir = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.niq = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.ngu) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nhv, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dHV() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nir) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.I(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.niq.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
