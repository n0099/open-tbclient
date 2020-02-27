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
    private final Client nmI;
    private final Configuration nnX;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dGc() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dFX());
    }

    public UploadManager(Configuration configuration) {
        this.nnX = configuration;
        this.nmI = new Client(configuration.nnC, configuration.connectTimeout, configuration.responseTimeout, configuration.nnF, configuration.nnG);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Rn;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Rn = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.noj || upToken == null) {
            Rn = ResponseInfo.Rn("invalid token");
        } else {
            Rn = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Rn != null) {
            upCompletionHandler.a(str, Rn, null);
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
        final /* synthetic */ UploadOptions nnJ;
        final /* synthetic */ UpToken nok;
        final /* synthetic */ UpCompletionHandler nol;
        final /* synthetic */ UploadManager nom;
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nom.nmI, this.nom.nnX, this.val$data, this.val$key, this.nok, this.nol, this.nnJ);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Nn(int i) {
            ResponseInfo Rn;
            if (ResponseInfo.No(i)) {
                Rn = ResponseInfo.a(i, this.nok);
            } else {
                Rn = ResponseInfo.Rn("invalid token");
            }
            this.nol.a(this.val$key, Rn, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Rr = UpToken.Rr(str2);
        if (!a(str, null, file, str2, Rr, upCompletionHandler)) {
            this.nnX.nnH.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nnX.nnD) {
                        FormUploader.a(UploadManager.this.nmI, UploadManager.this.nnX, file, str, Rr, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.B(new ResumeUploader(UploadManager.this.nmI, UploadManager.this.nnX, file, str, Rr, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nnX.nnB.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Nn(int i) {
                    ResponseInfo Rn;
                    if (ResponseInfo.No(i)) {
                        Rn = ResponseInfo.a(i, Rr);
                    } else {
                        Rn = ResponseInfo.Rn("invalid token");
                    }
                    upCompletionHandler.a(str, Rn, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler non;
        final long noo = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.non = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nms) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nnt, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dFL() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.noo) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.B(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.non.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
