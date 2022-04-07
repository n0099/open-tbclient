package com.kwad.sdk.ec.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.ec.kwai.b;
import com.kwad.sdk.ec.model.EcKwaiInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.u;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public enum EcKwaiInfoManager {
    INSTAANCE;
    
    public static final int MESSAGE_DOWNLOAD_DOWN = 3;
    public static final int MESSAGE_RELEASE = 2;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_RUNNING = 1;
    public String mAdLogStr;
    public int mAdPos;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.ec.download.a mApkDownloadHelper;
    public Context mAppContext;
    public int mContentType;
    public EcKwaiInfo mEcKwaiInfo;
    public long mPosId;
    public final Handler mHandler = new a();
    public int status = 0;
    public int mDownloadSource = 0;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 2) {
                EcKwaiInfoManager.this.release();
            } else if (i != 3) {
            } else {
                EcKwaiInfoManager.this.onDownloadEnd((EcKwaiInfo) message.obj);
            }
        }
    }

    EcKwaiInfoManager() {
    }

    private i<d, BaseResultData> createPullNewRequest(final String str) {
        return new i<d, BaseResultData>() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public d b() {
                return new d() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5.2
                    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                    public String a() {
                        return str;
                    }
                };
            }

            @Override // com.kwad.sdk.core.network.i
            @NonNull
            public BaseResultData b(String str2) {
                return new BaseResultData() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5.1
                };
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean g() {
                return false;
            }
        };
    }

    private i<b, EcKwaiInfo> createRequest() {
        return new i<b, EcKwaiInfo>() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public b b() {
                return new b();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public EcKwaiInfo b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                EcKwaiInfo ecKwaiInfo = new EcKwaiInfo();
                ecKwaiInfo.parseJson(jSONObject);
                return ecKwaiInfo;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
        r4 = com.kwad.sdk.utils.aa.a(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String generatePullNewUrl(String str) {
        String d;
        String a2;
        String pullNewUrl = EcKwaiInfo.getPullNewUrl(this.mEcKwaiInfo);
        Uri.Builder builder = new Uri.Builder();
        Uri parse = Uri.parse(pullNewUrl);
        builder.scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath());
        for (String str2 : parse.getQueryParameterNames()) {
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3367) {
                if (hashCode != 3236040) {
                    if (hashCode != 1131700202) {
                        if (hashCode == 2099989403 && str2.equals("siteSet")) {
                            c = 2;
                        }
                    } else if (str2.equals("androidId")) {
                        c = 1;
                    }
                } else if (str2.equals("imei")) {
                    c = 0;
                }
            } else if (str2.equals("ip")) {
                c = 3;
            }
            if (c != 0) {
                if (c == 1) {
                    d = av.t(this.mAppContext);
                } else if (c == 2) {
                    a2 = KsAdSDKImpl.get().getAppId() + "_" + str;
                } else if (c == 3) {
                    a2 = av.s(this.mAppContext);
                    if (!TextUtils.isEmpty(a2)) {
                    }
                }
                a2 = parse.getQueryParameter(str2);
            } else {
                d = av.d(this.mAppContext);
            }
            builder.appendQueryParameter(str2, a2);
        }
        return builder.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadEnd(EcKwaiInfo ecKwaiInfo) {
        if (ecKwaiInfo != null) {
            this.mEcKwaiInfo = ecKwaiInfo;
            this.status = 2;
            saveInfo();
        } else if (this.mEcKwaiInfo != null) {
            this.status = 2;
        } else {
            this.status = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadReport(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("referElementType", Integer.valueOf(this.mDownloadSource));
        hashMap.put("adLogStr", this.mAdLogStr);
        hashMap.put("deeplinkAppName", "kuaishou");
        hashMap.put("contentStyle", Integer.valueOf(this.mContentType));
        hashMap.put("position", Integer.valueOf(this.mAdPos + 1));
        hashMap.put("posId", Long.valueOf(this.mPosId));
        if (i == 32) {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
            hashMap.put("isPackageChanged", Integer.valueOf(ag.b(j.downloadId, com.kwad.sdk.core.response.a.a.v(j))));
        }
        if (i == 40) {
            hashMap.put("downloadFailedReason", this.mApkDownloadHelper.a);
        }
        f.a(new m(i, hashMap));
    }

    private void performDownload(Context context, String str, final String str2) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            this.mAdTemplate = this.mEcKwaiInfo.generateAdTemplate(str);
        } else {
            com.kwad.sdk.core.response.a.d.j(adTemplate).adConversionInfo.deeplinkUrl = str;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
        if (j.status == 12) {
            j.status = 0;
        }
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.sdk.ec.download.a(this.mAdTemplate, new e() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.3
                @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    EcKwaiInfoManager.this.mHandler.sendEmptyMessage(2);
                    EcKwaiInfoManager.this.onDownloadReport(40);
                }

                @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    EcKwaiInfoManager.this.onDownloadReport(32);
                }

                @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    EcKwaiInfoManager.this.onDownloadReport(30);
                    EcKwaiInfoManager.this.reportPullNew(str2);
                }

                @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    EcKwaiInfoManager.this.mHandler.sendEmptyMessage(2);
                }
            });
        }
        this.mApkDownloadHelper.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDownloadEndMessage(EcKwaiInfo ecKwaiInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = this.status;
        obtain.obj = ecKwaiInfo;
        this.mHandler.sendMessage(obtain);
    }

    private void readCache(Context context) {
        String string = context.getSharedPreferences("ksadsdk_pref", 0).getString("ksadsdk_kwai_download", "");
        if (string.isEmpty()) {
            return;
        }
        try {
            this.mEcKwaiInfo = EcKwaiInfo.fromJson(new JSONObject(string));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mApkDownloadHelper.e();
        this.mApkDownloadHelper = null;
        this.mAdTemplate = null;
        this.mDownloadSource = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPullNew(String str) {
        createPullNewRequest(generatePullNewUrl(str)).a(new j<d, BaseResultData>() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.4
        });
    }

    private void saveInfo() {
        Context context = this.mAppContext;
        if (context != null) {
            context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("ksadsdk_kwai_download", this.mEcKwaiInfo.toString()).apply();
        }
    }

    public String getAppName() {
        EcKwaiInfo ecKwaiInfo = this.mEcKwaiInfo;
        return ecKwaiInfo == null ? "" : ecKwaiInfo.getAppName();
    }

    public void init(Context context) {
        if (this.status > 0) {
            return;
        }
        this.status = 1;
        this.mAppContext = context.getApplicationContext();
        readCache(context);
        createRequest().a(new j<b, EcKwaiInfo>() { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, int i, String str) {
                EcKwaiInfoManager.this.postDownloadEndMessage(null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, @NonNull EcKwaiInfo ecKwaiInfo) {
                EcKwaiInfoManager.this.postDownloadEndMessage(ecKwaiInfo);
            }
        });
    }

    public void startDownload(Context context, AdTemplate adTemplate, String str, int i, int i2, String str2) {
        if (this.mDownloadSource == 0) {
            this.mDownloadSource = i;
        }
        if (!TextUtils.isEmpty(adTemplate.photoInfo.productInfo.shennongjiaLog)) {
            this.mAdLogStr = adTemplate.photoInfo.productInfo.shennongjiaLog;
            this.mAdPos = adTemplate.getShowPosition();
            this.mContentType = 1;
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                this.mPosId = sceneImpl.getPosId();
            }
        }
        if (this.mAdLogStr == null) {
            this.mAdLogStr = adTemplate.mLiveInfo.shennongjiaLog;
            this.mAdPos = adTemplate.getShowPosition();
            this.mContentType = 2;
            SceneImpl sceneImpl2 = adTemplate.mAdScene;
            if (sceneImpl2 != null) {
                this.mPosId = sceneImpl2.getPosId();
            }
        }
        if (this.status == 2) {
            performDownload(context, str, str2);
            return;
        }
        u.a(context, context.getString(R.string.obfuscated_res_0x7f0f098f), 0);
        init(context);
    }
}
