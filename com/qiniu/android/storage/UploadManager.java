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
    private final Client pvV;
    private final Configuration pxl;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient eul() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().eug());
    }

    public UploadManager(Configuration configuration) {
        this.pxl = configuration;
        this.pvV = new Client(configuration.pwQ, configuration.connectTimeout, configuration.responseTimeout, configuration.pwT, configuration.pwU);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Yx;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Yx = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.pxx || upToken == null) {
            Yx = ResponseInfo.Yx("invalid token");
        } else {
            Yx = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Yx != null) {
            upCompletionHandler.a(str, Yx, null);
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
        final /* synthetic */ byte[] cvQ;
        final /* synthetic */ UploadOptions pwX;
        final /* synthetic */ UploadManager pxA;
        final /* synthetic */ UpToken pxy;
        final /* synthetic */ UpCompletionHandler pxz;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.pxA.pvV, this.pxA.pxl, this.cvQ, this.val$key, this.pxy, this.pxz, this.pwX);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onFailure(int i) {
            ResponseInfo Yx;
            if (ResponseInfo.QH(i)) {
                Yx = ResponseInfo.a(i, this.pxy);
            } else {
                Yx = ResponseInfo.Yx("invalid token");
            }
            this.pxz.a(this.val$key, Yx, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken YB = UpToken.YB(str2);
        if (!a(str, null, file, str2, YB, upCompletionHandler)) {
            this.pxl.pwV.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.pxl.pwR) {
                        FormUploader.a(UploadManager.this.pvV, UploadManager.this.pxl, file, str, YB, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.G(new ResumeUploader(UploadManager.this.pvV, UploadManager.this.pxl, file, str, YB, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.pxl.pwP.q(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onFailure(int i) {
                    ResponseInfo Yx;
                    if (ResponseInfo.QH(i)) {
                        Yx = ResponseInfo.a(i, YB);
                    } else {
                        Yx = ResponseInfo.Yx("invalid token");
                    }
                    upCompletionHandler.a(str, Yx, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler pxB;
        final long pxC = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.pxB = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.pvF) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.pwH, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String etV() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.pxC) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.G(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.pxB.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
