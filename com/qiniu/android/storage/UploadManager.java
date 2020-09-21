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
    private final Client oph;
    private final Configuration oqx;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient egA() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().egv());
    }

    public UploadManager(Configuration configuration) {
        this.oqx = configuration;
        this.oph = new Client(configuration.oqc, configuration.connectTimeout, configuration.responseTimeout, configuration.oqf, configuration.oqg);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo VW;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            VW = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.oqJ || upToken == null) {
            VW = ResponseInfo.VW("invalid token");
        } else {
            VW = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (VW != null) {
            upCompletionHandler.a(str, VW, null);
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
        final /* synthetic */ byte[] caX;
        final /* synthetic */ UpToken oqK;
        final /* synthetic */ UpCompletionHandler oqL;
        final /* synthetic */ UploadManager oqM;
        final /* synthetic */ UploadOptions oqj;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.oqM.oph, this.oqM.oqx, this.caX, this.val$key, this.oqK, this.oqL, this.oqj);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo VW;
            if (ResponseInfo.Ok(i)) {
                VW = ResponseInfo.a(i, this.oqK);
            } else {
                VW = ResponseInfo.VW("invalid token");
            }
            this.oqL.a(this.val$key, VW, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Wa = UpToken.Wa(str2);
        if (!a(str, null, file, str2, Wa, upCompletionHandler)) {
            this.oqx.oqh.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.oqx.oqd) {
                        FormUploader.a(UploadManager.this.oph, UploadManager.this.oqx, file, str, Wa, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.E(new ResumeUploader(UploadManager.this.oph, UploadManager.this.oqx, file, str, Wa, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.oqx.oqb.r(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onFailure(int i) {
                    ResponseInfo VW;
                    if (ResponseInfo.Ok(i)) {
                        VW = ResponseInfo.a(i, Wa);
                    } else {
                        VW = ResponseInfo.VW("invalid token");
                    }
                    upCompletionHandler.a(str, VW, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler oqN;
        final long oqO = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.oqN = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.ooR) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.opT, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String egk() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.oqO) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.E(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.oqN.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
