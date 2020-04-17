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
    private final Client mLt;
    private final Configuration mMI;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dAH() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dAC());
    }

    public UploadManager(Configuration configuration) {
        this.mMI = configuration;
        this.mLt = new Client(configuration.mMn, configuration.connectTimeout, configuration.responseTimeout, configuration.mMq, configuration.mMr);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo OY;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            OY = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.mMU || upToken == null) {
            OY = ResponseInfo.OY("invalid token");
        } else {
            OY = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (OY != null) {
            upCompletionHandler.a(str, OY, null);
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
        final /* synthetic */ byte[] bEH;
        final /* synthetic */ UpToken mMV;
        final /* synthetic */ UpCompletionHandler mMW;
        final /* synthetic */ UploadManager mMX;
        final /* synthetic */ UploadOptions mMu;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.mMX.mLt, this.mMX.mMI, this.bEH, this.val$key, this.mMV, this.mMW, this.mMu);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void IN(int i) {
            ResponseInfo OY;
            if (ResponseInfo.IO(i)) {
                OY = ResponseInfo.a(i, this.mMV);
            } else {
                OY = ResponseInfo.OY("invalid token");
            }
            this.mMW.a(this.val$key, OY, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Pc = UpToken.Pc(str2);
        if (!a(str, null, file, str2, Pc, upCompletionHandler)) {
            this.mMI.mMs.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.mMI.mMo) {
                        FormUploader.a(UploadManager.this.mLt, UploadManager.this.mMI, file, str, Pc, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.G(new ResumeUploader(UploadManager.this.mLt, UploadManager.this.mMI, file, str, Pc, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.mMI.mMm.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void IN(int i) {
                    ResponseInfo OY;
                    if (ResponseInfo.IO(i)) {
                        OY = ResponseInfo.a(i, Pc);
                    } else {
                        OY = ResponseInfo.OY("invalid token");
                    }
                    upCompletionHandler.a(str, OY, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler mMY;
        final long mMZ = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.mMY = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.mLd) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.mMe, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dAr() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.mMZ) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.G(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.mMY.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
