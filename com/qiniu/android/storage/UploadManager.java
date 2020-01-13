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
/* loaded from: classes4.dex */
public final class UploadManager {
    private static OkHttpClient sClient;
    private final Client nmc;
    private final Configuration nnr;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dET() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dEO());
    }

    public UploadManager(Configuration configuration) {
        this.nnr = configuration;
        this.nmc = new Client(configuration.nmW, configuration.connectTimeout, configuration.responseTimeout, configuration.nmZ, configuration.nna);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Rc;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Rc = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nnD || upToken == null) {
            Rc = ResponseInfo.Rc("invalid token");
        } else {
            Rc = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Rc != null) {
            upCompletionHandler.a(str, Rc, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WarpHandler a(UpCompletionHandler upCompletionHandler, long j) {
        return new WarpHandler(upCompletionHandler, j);
    }

    /* renamed from: com.qiniu.android.storage.UploadManager$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Zone.QueryHandler {
        final /* synthetic */ UpToken nnE;
        final /* synthetic */ UpCompletionHandler nnF;
        final /* synthetic */ UploadManager nnG;
        final /* synthetic */ UploadOptions nnd;
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nnG.nmc, this.nnG.nnr, this.val$data, this.val$key, this.nnE, this.nnF, this.nnd);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Nk(int i) {
            ResponseInfo Rc;
            if (ResponseInfo.Nl(i)) {
                Rc = ResponseInfo.a(i, this.nnE);
            } else {
                Rc = ResponseInfo.Rc("invalid token");
            }
            this.nnF.a(this.val$key, Rc, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Rg = UpToken.Rg(str2);
        if (!a(str, null, file, str2, Rg, upCompletionHandler)) {
            this.nnr.nnb.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nnr.nmX) {
                        FormUploader.a(UploadManager.this.nmc, UploadManager.this.nnr, file, str, Rg, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.B(new ResumeUploader(UploadManager.this.nmc, UploadManager.this.nnr, file, str, Rg, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nnr.nmV.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Nk(int i) {
                    ResponseInfo Rc;
                    if (ResponseInfo.Nl(i)) {
                        Rc = ResponseInfo.a(i, Rg);
                    } else {
                        Rc = ResponseInfo.Rc("invalid token");
                    }
                    upCompletionHandler.a(str, Rc, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nnH;
        final long nnI = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nnH = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nlM) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nmN, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dEC() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nnI) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.B(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nnH.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
