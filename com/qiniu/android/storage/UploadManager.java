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
    private final Client nmV;
    private final Configuration nok;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dGf() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dGa());
    }

    public UploadManager(Configuration configuration) {
        this.nok = configuration;
        this.nmV = new Client(configuration.nnP, configuration.connectTimeout, configuration.responseTimeout, configuration.nnS, configuration.nnT);
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
        } else if (upToken == UpToken.noy || upToken == null) {
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
        final /* synthetic */ UploadOptions nnW;
        final /* synthetic */ UpCompletionHandler noA;
        final /* synthetic */ UploadManager noB;
        final /* synthetic */ UpToken noz;
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.noB.nmV, this.noB.nok, this.val$data, this.val$key, this.noz, this.noA, this.nnW);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void Nn(int i) {
            ResponseInfo Ro;
            if (ResponseInfo.No(i)) {
                Ro = ResponseInfo.a(i, this.noz);
            } else {
                Ro = ResponseInfo.Ro("invalid token");
            }
            this.noA.a(this.val$key, Ro, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Rs = UpToken.Rs(str2);
        if (!a(str, null, file, str2, Rs, upCompletionHandler)) {
            this.nok.nnU.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.nok.nnQ) {
                        FormUploader.a(UploadManager.this.nmV, UploadManager.this.nok, file, str, Rs, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.B(new ResumeUploader(UploadManager.this.nmV, UploadManager.this.nok, file, str, Rs, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.nok.nnO.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void Nn(int i) {
                    ResponseInfo Ro;
                    if (ResponseInfo.No(i)) {
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
        final UpCompletionHandler noC;
        final long noD = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.noC = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.nmF) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.nnG, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dFO() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.noD) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.B(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.noC.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
