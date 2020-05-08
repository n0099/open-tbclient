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
    private final Client mLw;
    private final Configuration mML;

    public static void a(OkHttpClient okHttpClient) {
        sClient = okHttpClient;
    }

    public static OkHttpClient dAD() {
        return sClient;
    }

    public UploadManager() {
        this(new Configuration.Builder().dAy());
    }

    public UploadManager(Configuration configuration) {
        this.mML = configuration;
        this.mLw = new Client(configuration.mMq, configuration.connectTimeout, configuration.responseTimeout, configuration.mMt, configuration.mMu);
    }

    private static boolean a(String str, byte[] bArr, File file, String str2, UpToken upToken, UpCompletionHandler upCompletionHandler) {
        String str3;
        ResponseInfo Pb;
        if (upCompletionHandler == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            Pb = ResponseInfo.a(str3, upToken);
        } else if (upToken == UpToken.mMX || upToken == null) {
            Pb = ResponseInfo.Pb("invalid token");
        } else {
            Pb = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : ResponseInfo.a(upToken);
        }
        if (Pb != null) {
            upCompletionHandler.a(str, Pb, null);
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
        final /* synthetic */ byte[] bEM;
        final /* synthetic */ UpToken mMY;
        final /* synthetic */ UpCompletionHandler mMZ;
        final /* synthetic */ UploadOptions mMx;
        final /* synthetic */ UploadManager mNa;
        final /* synthetic */ String val$key;

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void onSuccess() {
            FormUploader.a(this.mNa.mLw, this.mNa.mML, this.bEM, this.val$key, this.mMY, this.mMZ, this.mMx);
        }

        @Override // com.qiniu.android.common.Zone.QueryHandler
        public void IN(int i) {
            ResponseInfo Pb;
            if (ResponseInfo.IO(i)) {
                Pb = ResponseInfo.a(i, this.mMY);
            } else {
                Pb = ResponseInfo.Pb("invalid token");
            }
            this.mMZ.a(this.val$key, Pb, null);
        }
    }

    public void a(final File file, final String str, String str2, final UpCompletionHandler upCompletionHandler, final UploadOptions uploadOptions) {
        final UpToken Pf = UpToken.Pf(str2);
        if (!a(str, null, file, str2, Pf, upCompletionHandler)) {
            this.mML.mMv.a(str2, new Zone.QueryHandler() { // from class: com.qiniu.android.storage.UploadManager.2
                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void onSuccess() {
                    if (file.length() <= UploadManager.this.mML.mMr) {
                        FormUploader.a(UploadManager.this.mLw, UploadManager.this.mML, file, str, Pf, upCompletionHandler, uploadOptions);
                        return;
                    }
                    AsyncRun.G(new ResumeUploader(UploadManager.this.mLw, UploadManager.this.mML, file, str, Pf, UploadManager.a(upCompletionHandler, file != null ? file.length() : 0L), uploadOptions, UploadManager.this.mML.mMp.p(str, file)));
                }

                @Override // com.qiniu.android.common.Zone.QueryHandler
                public void IN(int i) {
                    ResponseInfo Pb;
                    if (ResponseInfo.IO(i)) {
                        Pb = ResponseInfo.a(i, Pf);
                    } else {
                        Pb = ResponseInfo.Pb("invalid token");
                    }
                    upCompletionHandler.a(str, Pb, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WarpHandler implements UpCompletionHandler {
        final UpCompletionHandler mNb;
        final long mNc = System.currentTimeMillis();
        final long size;

        WarpHandler(UpCompletionHandler upCompletionHandler, long j) {
            this.mNb = upCompletionHandler;
            this.size = j;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void a(final String str, final ResponseInfo responseInfo, final JSONObject jSONObject) {
            if (Config.mLg) {
                final long currentTimeMillis = System.currentTimeMillis();
                UploadInfoCollector.b(responseInfo.mMh, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.1
                    @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                    public String dAn() {
                        return StringUtils.b(new String[]{responseInfo.statusCode + "", responseInfo.reqId, responseInfo.host, responseInfo.ip, responseInfo.port + "", (currentTimeMillis - WarpHandler.this.mNc) + "", responseInfo.timeStamp + "", WarpHandler.this.size + "", "block", WarpHandler.this.size + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                });
            }
            AsyncRun.G(new Runnable() { // from class: com.qiniu.android.storage.UploadManager.WarpHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WarpHandler.this.mNb.a(str, responseInfo, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
