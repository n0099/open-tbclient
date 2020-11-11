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
    private final Client pFp;
    private final Configuration pGE;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient eya() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().exV());
    }

    public UploadManager(Configuration configuration) {
        this.pGE = configuration;
        this.pFp = new Client(configuration.pGj, configuration.connectTimeout, configuration.responseTimeout, configuration.pGm, configuration.pGn);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Zb;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Zb = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.pGQ || upToken == null) {
            Zb = ResponseInfo.Zb("invalid token");
        } else {
            Zb = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Zb != null) {
            upCompletionHandler.a(str, Zb, null);
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
        final /* synthetic */ byte[] cBJ;
        final /* synthetic */ UpToken pGR;
        final /* synthetic */ UpCompletionHandler pGS;
        final /* synthetic */ UploadManager pGT;
        final /* synthetic */ UploadOptions pGq;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.pGT.pFp, this.pGT.pGE, this.cBJ, this.val$key, this.pGR, this.pGS, this.pGq);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo Zb;
            if (ResponseInfo.Rc(i)) {
                Zb = ResponseInfo.a(i, this.pGR);
            } else {
                Zb = ResponseInfo.Zb("invalid token");
            }
            this.pGS.a(this.val$key, Zb, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Zf = UpToken.Zf(str2);
        if (!a(str, null, file, str2, Zf, upCompletionHandler)) {
            this.pGE.pGo.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.pGE.pGk) {
                        FormUploader.a(UploadManager.this.pFp, UploadManager.this.pGE, file, str, Zf, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.G(new ResumeUploader(UploadManager.this.pFp, UploadManager.this.pGE, file, str, Zf, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.pGE.pGi.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onFailure(int i) {
                    ResponseInfo Zb;
                    if (ResponseInfo.Rc(i)) {
                        Zb = ResponseInfo.a(i, Zf);
                    } else {
                        Zb = ResponseInfo.Zb("invalid token");
                    }
                    upCompletionHandler.a(str, Zb, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler pGU;
        final long pGV = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.pGU = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.pEZ) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.pGa, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String exK() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.pGV) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.G(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.pGU.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
