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
    private final Client ofz;
    private final Configuration ogO;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient ecD() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().ecy());
    }

    public UploadManager(Configuration configuration) {
        this.ogO = configuration;
        this.ofz = new Client(configuration.ogt, configuration.connectTimeout, configuration.responseTimeout, configuration.ogw, configuration.ogx);
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
        } else if (upToken == UpToken.oha || upToken == null) {
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
        final /* synthetic */ byte[] bYW;
        final /* synthetic */ UploadOptions ogA;
        final /* synthetic */ UpToken ohb;
        final /* synthetic */ UpCompletionHandler ohc;
        final /* synthetic */ UploadManager ohd;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.ohd.ofz, this.ohd.ogO, this.bYW, this.val$key, this.ohb, this.ohc, this.ogA);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo Vu;
            if (ResponseInfo.NF(i)) {
                Vu = ResponseInfo.a(i, this.ohb);
            } else {
                Vu = ResponseInfo.Vu("invalid token");
            }
            this.ohc.a(this.val$key, Vu, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Vy = UpToken.Vy(str2);
        if (!a(str, null, file, str2, Vy, upCompletionHandler)) {
            this.ogO.ogy.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.ogO.ogu) {
                        FormUploader.a(UploadManager.this.ofz, UploadManager.this.ogO, file, str, Vy, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.E(new ResumeUploader(UploadManager.this.ofz, UploadManager.this.ogO, file, str, Vy, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.ogO.ogs.r(str, file)));
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
        final UpCompletionHandler ohe;
        final long ohf = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.ohe = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.ofj) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.ogk, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String ecn() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.ohf) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.E(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.ohe.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
