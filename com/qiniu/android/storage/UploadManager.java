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
    private final Client ofh;
    private final Configuration ogw;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient ecu() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().ecp());
    }

    public UploadManager(Configuration configuration) {
        this.ogw = configuration;
        this.ofh = new Client(configuration.ogb, configuration.connectTimeout, configuration.responseTimeout, configuration.oge, configuration.ogf);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Vu;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Vu = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.ogI || upToken == null) {
            Vu = ResponseInfo.Vu("invalid token");
        } else {
            Vu = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Vu != null) {
            upCompletionHandler.a(str, Vu, null);
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
        final /* synthetic */ byte[] bYS;
        final /* synthetic */ UpToken ogJ;
        final /* synthetic */ UpCompletionHandler ogK;
        final /* synthetic */ UploadManager ogL;
        final /* synthetic */ UploadOptions ogi;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.ogL.ofh, this.ogL.ogw, this.bYS, this.val$key, this.ogJ, this.ogK, this.ogi);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo Vu;
            if (ResponseInfo.NF(i)) {
                Vu = ResponseInfo.a(i, this.ogJ);
            } else {
                Vu = ResponseInfo.Vu("invalid token");
            }
            this.ogK.a(this.val$key, Vu, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Vy = UpToken.Vy(str2);
        if (!a(str, null, file, str2, Vy, upCompletionHandler)) {
            this.ogw.ogg.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.ogw.ogc) {
                        FormUploader.a(UploadManager.this.ofh, UploadManager.this.ogw, file, str, Vy, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.E(new ResumeUploader(UploadManager.this.ofh, UploadManager.this.ogw, file, str, Vy, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.ogw.oga.r(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onFailure(int i) {
                    ResponseInfo Vu;
                    if (ResponseInfo.NF(i)) {
                        Vu = ResponseInfo.a(i, Vy);
                    } else {
                        Vu = ResponseInfo.Vu("invalid token");
                    }
                    upCompletionHandler.a(str, Vu, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler ogM;
        final long ogN = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.ogM = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.oeQ) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.ofS, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String ece() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.ogN) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.E(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.ogM.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
