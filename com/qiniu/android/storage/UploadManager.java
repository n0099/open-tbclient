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
    private final Client nmh;
    private final Configuration nnw;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dEV() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dEQ());
    }

    public UploadManager(Configuration configuration) {
        this.nnw = configuration;
        this.nmh = new Client(configuration.nnb, configuration.connectTimeout, configuration.responseTimeout, configuration.nne, configuration.nnf);
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
        } else if (upToken == UpToken.nnI || upToken == null) {
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
        final /* synthetic */ UpToken nnJ;
        final /* synthetic */ UpCompletionHandler nnK;
        final /* synthetic */ UploadManager nnL;
        final /* synthetic */ UploadOptions nni;
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nnL.nmh, this.nnL.nnw, this.val$data, this.val$key, this.nnJ, this.nnK, this.nni);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Nk(int i) {
            ResponseInfo Rc;
            if (ResponseInfo.Nl(i)) {
                Rc = ResponseInfo.a(i, this.nnJ);
            } else {
                Rc = ResponseInfo.Rc("invalid token");
            }
            this.nnK.a(this.val$key, Rc, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Rg = UpToken.Rg(str2);
        if (!a(str, null, file, str2, Rg, upCompletionHandler)) {
            this.nnw.nng.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nnw.nnc) {
                        FormUploader.a(UploadManager.this.nmh, UploadManager.this.nnw, file, str, Rg, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.B(new ResumeUploader(UploadManager.this.nmh, UploadManager.this.nnw, file, str, Rg, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nnw.nna.q(str, file)));
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
        final UpCompletionHandler nnM;
        final long nnN = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nnM = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nlR) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nmS, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dEE() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nnN) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.B(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nnM.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
