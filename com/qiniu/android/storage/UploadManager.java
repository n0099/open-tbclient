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
    private final Client nCD;
    private final Configuration nDS;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dMV() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dMQ());
    }

    public UploadManager(Configuration configuration) {
        this.nDS = configuration;
        this.nCD = new Client(configuration.nDx, configuration.connectTimeout, configuration.responseTimeout, configuration.nDA, configuration.nDB);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo RF;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            RF = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nEe || upToken == null) {
            RF = ResponseInfo.RF("invalid token");
        } else {
            RF = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (RF != null) {
            upCompletionHandler.a(str, RF, null);
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
        final /* synthetic */ UploadOptions nDE;
        final /* synthetic */ UpToken nEf;
        final /* synthetic */ UpCompletionHandler nEg;
        final /* synthetic */ UploadManager nEh;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nEh.nCD, this.nEh.nDS, this.bSs, this.val$key, this.nEf, this.nEg, this.nDE);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void KH(int i) {
            ResponseInfo RF;
            if (ResponseInfo.KI(i)) {
                RF = ResponseInfo.a(i, this.nEf);
            } else {
                RF = ResponseInfo.RF("invalid token");
            }
            this.nEg.a(this.val$key, RF, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken RJ = UpToken.RJ(str2);
        if (!a(str, null, file, str2, RJ, upCompletionHandler)) {
            this.nDS.nDC.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nDS.nDy) {
                        FormUploader.a(UploadManager.this.nCD, UploadManager.this.nDS, file, str, RJ, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.I(new ResumeUploader(UploadManager.this.nCD, UploadManager.this.nDS, file, str, RJ, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nDS.nDw.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void KH(int i) {
                    ResponseInfo RF;
                    if (ResponseInfo.KI(i)) {
                        RF = ResponseInfo.a(i, RJ);
                    } else {
                        RF = ResponseInfo.RF("invalid token");
                    }
                    upCompletionHandler.a(str, RF, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nEi;
        final long nEj = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nEi = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nCn) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nDo, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dMF() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nEj) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.I(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nEi.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
