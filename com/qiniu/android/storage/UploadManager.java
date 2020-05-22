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
    private final Client nfA;
    private final Configuration ngP;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dHX() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dHS());
    }

    public UploadManager(Configuration configuration) {
        this.ngP = configuration;
        this.nfA = new Client(configuration.ngu, configuration.connectTimeout, configuration.responseTimeout, configuration.ngx, configuration.ngy);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo QR;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            QR = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nhb || upToken == null) {
            QR = ResponseInfo.QR("invalid token");
        } else {
            QR = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (QR != null) {
            upCompletionHandler.a(str, QR, null);
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
        final /* synthetic */ UploadOptions ngB;
        final /* synthetic */ UpToken nhc;
        final /* synthetic */ UpCompletionHandler nhd;
        final /* synthetic */ UploadManager nhe;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nhe.nfA, this.nhe.ngP, this.bNE, this.val$key, this.nhc, this.nhd, this.ngB);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Jy(int i) {
            ResponseInfo QR;
            if (ResponseInfo.Jz(i)) {
                QR = ResponseInfo.a(i, this.nhc);
            } else {
                QR = ResponseInfo.QR("invalid token");
            }
            this.nhd.a(this.val$key, QR, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken QV = UpToken.QV(str2);
        if (!a(str, null, file, str2, QV, upCompletionHandler)) {
            this.ngP.ngz.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.ngP.ngv) {
                        FormUploader.a(UploadManager.this.nfA, UploadManager.this.ngP, file, str, QV, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.I(new ResumeUploader(UploadManager.this.nfA, UploadManager.this.ngP, file, str, QV, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.ngP.ngt.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Jy(int i) {
                    ResponseInfo QR;
                    if (ResponseInfo.Jz(i)) {
                        QR = ResponseInfo.a(i, QV);
                    } else {
                        QR = ResponseInfo.QR("invalid token");
                    }
                    upCompletionHandler.a(str, QR, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nhf;
        final long nhg = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nhf = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nfk) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.ngl, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dHH() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nhg) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.I(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nhf.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
