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
/* loaded from: classes6.dex */
public final class UploadManager {
    private static OkHttpClient sClient;
    private final Client nLl;
    private final Configuration nMA;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dQr() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dQm());
    }

    public UploadManager(Configuration configuration) {
        this.nMA = configuration;
        this.nLl = new Client(configuration.nMf, configuration.connectTimeout, configuration.responseTimeout, configuration.nMi, configuration.nMj);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Sq;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Sq = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nMM || upToken == null) {
            Sq = ResponseInfo.Sq("invalid token");
        } else {
            Sq = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Sq != null) {
            upCompletionHandler.a(str, Sq, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WarpHandler a(UpCompletionHandler upCompletionHandler, long j) {
        return new WarpHandler(upCompletionHandler, j);
    }

    /* renamed from: com.qiniu.android.storage.UploadManager$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Zone.QueryHandler {
        final /* synthetic */ byte[] bTk;
        final /* synthetic */ UpToken nMN;
        final /* synthetic */ UpCompletionHandler nMO;
        final /* synthetic */ UploadManager nMP;
        final /* synthetic */ UploadOptions nMm;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nMP.nLl, this.nMP.nMA, this.bTk, this.val$key, this.nMN, this.nMO, this.nMm);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Lb(int i) {
            ResponseInfo Sq;
            if (ResponseInfo.Lc(i)) {
                Sq = ResponseInfo.a(i, this.nMN);
            } else {
                Sq = ResponseInfo.Sq("invalid token");
            }
            this.nMO.a(this.val$key, Sq, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Su = UpToken.Su(str2);
        if (!a(str, null, file, str2, Su, upCompletionHandler)) {
            this.nMA.nMk.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nMA.nMg) {
                        FormUploader.a(UploadManager.this.nLl, UploadManager.this.nMA, file, str, Su, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.H(new ResumeUploader(UploadManager.this.nLl, UploadManager.this.nMA, file, str, Su, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nMA.nMe.r(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Lb(int i) {
                    ResponseInfo Sq;
                    if (ResponseInfo.Lc(i)) {
                        Sq = ResponseInfo.a(i, Su);
                    } else {
                        Sq = ResponseInfo.Sq("invalid token");
                    }
                    upCompletionHandler.a(str, Sq, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nMQ;
        final long nMR = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nMQ = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nKV) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nLW, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dQb() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nMR) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.H(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nMQ.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
