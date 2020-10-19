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
    private final Client oEz;
    private final Configuration oFO;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient ekl() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().ekg());
    }

    public UploadManager(Configuration configuration) {
        this.oFO = configuration;
        this.oEz = new Client(configuration.oFt, configuration.connectTimeout, configuration.responseTimeout, configuration.oFw, configuration.oFx);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo WK;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            WK = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.oGa || upToken == null) {
            WK = ResponseInfo.WK("invalid token");
        } else {
            WK = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (WK != null) {
            upCompletionHandler.a(str, WK, null);
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
        final /* synthetic */ byte[] cnm;
        final /* synthetic */ UploadOptions oFA;
        final /* synthetic */ UpToken oGb;
        final /* synthetic */ UpCompletionHandler oGc;
        final /* synthetic */ UploadManager oGd;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.oGd.oEz, this.oGd.oFO, this.cnm, this.val$key, this.oGb, this.oGc, this.oFA);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo WK;
            if (ResponseInfo.OQ(i)) {
                WK = ResponseInfo.a(i, this.oGb);
            } else {
                WK = ResponseInfo.WK("invalid token");
            }
            this.oGc.a(this.val$key, WK, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken WO = UpToken.WO(str2);
        if (!a(str, null, file, str2, WO, upCompletionHandler)) {
            this.oFO.oFy.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.oFO.oFu) {
                        FormUploader.a(UploadManager.this.oEz, UploadManager.this.oFO, file, str, WO, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.E(new ResumeUploader(UploadManager.this.oEz, UploadManager.this.oFO, file, str, WO, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.oFO.oFs.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onFailure(int i) {
                    ResponseInfo WK;
                    if (ResponseInfo.OQ(i)) {
                        WK = ResponseInfo.a(i, WO);
                    } else {
                        WK = ResponseInfo.WK("invalid token");
                    }
                    upCompletionHandler.a(str, WK, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler oGe;
        final long oGf = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.oGe = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.oEj) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.oFk, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String ejV() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.oGf) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.E(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.oGe.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
