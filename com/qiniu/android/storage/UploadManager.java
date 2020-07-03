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
    private final Client nCA;
    private final Configuration nDP;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dMR() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dMM());
    }

    public UploadManager(Configuration configuration) {
        this.nDP = configuration;
        this.nCA = new Client(configuration.nDu, configuration.connectTimeout, configuration.responseTimeout, configuration.nDx, configuration.nDy);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo RE;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            RE = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nEb || upToken == null) {
            RE = ResponseInfo.RE("invalid token");
        } else {
            RE = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (RE != null) {
            upCompletionHandler.a(str, RE, null);
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
        final /* synthetic */ byte[] bSs;
        final /* synthetic */ UploadOptions nDB;
        final /* synthetic */ UpToken nEc;
        final /* synthetic */ UpCompletionHandler nEd;
        final /* synthetic */ UploadManager nEe;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nEe.nCA, this.nEe.nDP, this.bSs, this.val$key, this.nEc, this.nEd, this.nDB);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void KH(int i) {
            ResponseInfo RE;
            if (ResponseInfo.KI(i)) {
                RE = ResponseInfo.a(i, this.nEc);
            } else {
                RE = ResponseInfo.RE("invalid token");
            }
            this.nEd.a(this.val$key, RE, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken RI = UpToken.RI(str2);
        if (!a(str, null, file, str2, RI, upCompletionHandler)) {
            this.nDP.nDz.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nDP.nDv) {
                        FormUploader.a(UploadManager.this.nCA, UploadManager.this.nDP, file, str, RI, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.I(new ResumeUploader(UploadManager.this.nCA, UploadManager.this.nDP, file, str, RI, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nDP.nDt.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void KH(int i) {
                    ResponseInfo RE;
                    if (ResponseInfo.KI(i)) {
                        RE = ResponseInfo.a(i, RI);
                    } else {
                        RE = ResponseInfo.RE("invalid token");
                    }
                    upCompletionHandler.a(str, RE, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nEf;
        final long nEg = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nEf = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nCk) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nDl, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dMB() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nEg) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.I(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nEf.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
