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
    private final Client noK;
    private final Configuration npZ;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dGF() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dGA());
    }

    public UploadManager(Configuration configuration) {
        this.npZ = configuration;
        this.noK = new Client(configuration.npE, configuration.connectTimeout, configuration.responseTimeout, configuration.npH, configuration.npI);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Ro;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Ro = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.nql || upToken == null) {
            Ro = ResponseInfo.Ro("invalid token");
        } else {
            Ro = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Ro != null) {
            upCompletionHandler.a(str, Ro, null);
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
        final /* synthetic */ UploadOptions npL;
        final /* synthetic */ UpToken nqm;
        final /* synthetic */ UpCompletionHandler nqn;
        final /* synthetic */ UploadManager nqo;
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.nqo.noK, this.nqo.npZ, this.val$data, this.val$key, this.nqm, this.nqn, this.npL);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Nt(int i) {
            ResponseInfo Ro;
            if (ResponseInfo.Nu(i)) {
                Ro = ResponseInfo.a(i, this.nqm);
            } else {
                Ro = ResponseInfo.Ro("invalid token");
            }
            this.nqn.a(this.val$key, Ro, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Rs = UpToken.Rs(str2);
        if (!a(str, null, file, str2, Rs, upCompletionHandler)) {
            this.npZ.npJ.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.npZ.npF) {
                        FormUploader.a(UploadManager.this.noK, UploadManager.this.npZ, file, str, Rs, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.B(new ResumeUploader(UploadManager.this.noK, UploadManager.this.npZ, file, str, Rs, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.npZ.npD.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Nt(int i) {
                    ResponseInfo Ro;
                    if (ResponseInfo.Nu(i)) {
                        Ro = ResponseInfo.a(i, Rs);
                    } else {
                        Ro = ResponseInfo.Ro("invalid token");
                    }
                    upCompletionHandler.a(str, Ro, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler nqp;
        final long nqq = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.nqp = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nos) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.npv, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dGo() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.nqq) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.B(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.nqp.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
