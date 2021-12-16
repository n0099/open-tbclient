package com.kwad.sdk.ec.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
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
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class EcKwaiInfoManager {
    public static final /* synthetic */ EcKwaiInfoManager[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final EcKwaiInfoManager INSTAANCE;
    public static final int MESSAGE_DOWNLOAD_DOWN = 3;
    public static final int MESSAGE_RELEASE = 2;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_RUNNING = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdLogStr;
    public int mAdPos;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.ec.download.a mApkDownloadHelper;
    public Context mAppContext;
    public int mContentType;
    public int mDownloadSource;
    public EcKwaiInfo mEcKwaiInfo;
    public final Handler mHandler;
    public long mPosId;
    public int status;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EcKwaiInfoManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EcKwaiInfoManager ecKwaiInfoManager) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ecKwaiInfoManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ecKwaiInfoManager;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.a.release();
                } else if (i2 != 3) {
                } else {
                    this.a.onDownloadEnd((EcKwaiInfo) message.obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1136681759, "Lcom/kwad/sdk/ec/download/EcKwaiInfoManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1136681759, "Lcom/kwad/sdk/ec/download/EcKwaiInfoManager;");
                return;
            }
        }
        EcKwaiInfoManager ecKwaiInfoManager = new EcKwaiInfoManager("INSTAANCE", 0);
        INSTAANCE = ecKwaiInfoManager;
        $VALUES = new EcKwaiInfoManager[]{ecKwaiInfoManager};
    }

    public EcKwaiInfoManager(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHandler = new a(this);
        this.status = 0;
        this.mDownloadSource = 0;
    }

    private i<d, BaseResultData> createPullNewRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) ? new i<d, BaseResultData>(this, str) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EcKwaiInfoManager f58998b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58998b = this;
                this.a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public d b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new d(this) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass5 f58999b;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58999b = this;
                    }

                    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                    public String a() {
                        InterceptResult invokeV2;
                        Interceptable interceptable3 = $ic;
                        return (interceptable3 == null || (invokeV2 = interceptable3.invokeV(1048576, this)) == null) ? this.f58999b.a : (String) invokeV2.objValue;
                    }
                } : (d) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.i
            @NonNull
            public BaseResultData b(String str2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2)) == null) ? new BaseResultData(this) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass5 this$1;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }
                } : (BaseResultData) invokeL2.objValue;
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean g() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        } : (i) invokeL.objValue;
    }

    private i<b, EcKwaiInfo> createRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new i<b, EcKwaiInfo>(this) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EcKwaiInfoManager a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public b b() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? new b() : (b) invokeV2.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public EcKwaiInfo b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    EcKwaiInfo ecKwaiInfo = new EcKwaiInfo();
                    ecKwaiInfo.parseJson(jSONObject);
                    return ecKwaiInfo;
                }
                return (EcKwaiInfo) invokeL.objValue;
            }
        } : (i) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cf, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
        r4 = com.kwad.sdk.utils.aa.a(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String generatePullNewUrl(String str) {
        InterceptResult invokeL;
        String d2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            String pullNewUrl = EcKwaiInfo.getPullNewUrl(this.mEcKwaiInfo);
            Uri.Builder builder = new Uri.Builder();
            Uri parse = Uri.parse(pullNewUrl);
            builder.scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath());
            for (String str2 : parse.getQueryParameterNames()) {
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 3367) {
                    if (hashCode != 3236040) {
                        if (hashCode != 1131700202) {
                            if (hashCode == 2099989403 && str2.equals("siteSet")) {
                                c2 = 2;
                            }
                        } else if (str2.equals("androidId")) {
                            c2 = 1;
                        }
                    } else if (str2.equals("imei")) {
                        c2 = 0;
                    }
                } else if (str2.equals("ip")) {
                    c2 = 3;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        d2 = av.t(this.mAppContext);
                    } else if (c2 == 2) {
                        a2 = KsAdSDKImpl.get().getAppId() + "_" + str;
                    } else if (c2 == 3) {
                        a2 = av.s(this.mAppContext);
                        if (!TextUtils.isEmpty(a2)) {
                        }
                    }
                    a2 = parse.getQueryParameter(str2);
                } else {
                    d2 = av.d(this.mAppContext);
                }
                builder.appendQueryParameter(str2, a2);
            }
            return builder.build().toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadEnd(EcKwaiInfo ecKwaiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, ecKwaiInfo) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadReport(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("referElementType", Integer.valueOf(this.mDownloadSource));
            hashMap.put("adLogStr", this.mAdLogStr);
            hashMap.put("deeplinkAppName", "kuaishou");
            hashMap.put("contentStyle", Integer.valueOf(this.mContentType));
            hashMap.put("position", Integer.valueOf(this.mAdPos + 1));
            hashMap.put("posId", Long.valueOf(this.mPosId));
            if (i2 == 32) {
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
                hashMap.put("isPackageChanged", Integer.valueOf(ag.b(j2.downloadId, com.kwad.sdk.core.response.a.a.v(j2))));
            }
            if (i2 == 40) {
                hashMap.put("downloadFailedReason", this.mApkDownloadHelper.a);
            }
            f.a(new m(i2, hashMap));
        }
    }

    private void performDownload(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, context, str, str2) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                this.mAdTemplate = this.mEcKwaiInfo.generateAdTemplate(str);
            } else {
                com.kwad.sdk.core.response.a.d.j(adTemplate).adConversionInfo.deeplinkUrl = str;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
            if (j2.status == 12) {
                j2.status = 0;
            }
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.sdk.ec.download.a(this.mAdTemplate, new e(this, str2) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ EcKwaiInfoManager f58997b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58997b = this;
                        this.a = str2;
                    }

                    @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f58997b.mHandler.sendEmptyMessage(2);
                            this.f58997b.onDownloadReport(40);
                        }
                    }

                    @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f58997b.onDownloadReport(32);
                        }
                    }

                    @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadStarted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f58997b.onDownloadReport(30);
                            this.f58997b.reportPullNew(this.a);
                        }
                    }

                    @Override // com.kwad.sdk.core.download.a.e, com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f58997b.mHandler.sendEmptyMessage(2);
                        }
                    }
                });
            }
            this.mApkDownloadHelper.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDownloadEndMessage(EcKwaiInfo ecKwaiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, ecKwaiInfo) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = this.status;
            obtain.obj = ecKwaiInfo;
            this.mHandler.sendMessage(obtain);
        }
    }

    private void readCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, context) == null) {
            String string = context.getSharedPreferences("ksadsdk_pref", 0).getString("ksadsdk_kwai_download", "");
            if (string.isEmpty()) {
                return;
            }
            try {
                this.mEcKwaiInfo = EcKwaiInfo.fromJson(new JSONObject(string));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mApkDownloadHelper.e();
            this.mApkDownloadHelper = null;
            this.mAdTemplate = null;
            this.mDownloadSource = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPullNew(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            createPullNewRequest(generatePullNewUrl(str)).a(new j<d, BaseResultData>(this) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EcKwaiInfoManager a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }
            });
        }
    }

    private void saveInfo() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (context = this.mAppContext) == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putString("ksadsdk_kwai_download", this.mEcKwaiInfo.toString()).apply();
    }

    public static EcKwaiInfoManager valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? (EcKwaiInfoManager) Enum.valueOf(EcKwaiInfoManager.class, str) : (EcKwaiInfoManager) invokeL.objValue;
    }

    public static EcKwaiInfoManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (EcKwaiInfoManager[]) $VALUES.clone() : (EcKwaiInfoManager[]) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            EcKwaiInfo ecKwaiInfo = this.mEcKwaiInfo;
            return ecKwaiInfo == null ? "" : ecKwaiInfo.getAppName();
        }
        return (String) invokeV.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || this.status > 0) {
            return;
        }
        this.status = 1;
        this.mAppContext = context.getApplicationContext();
        readCache(context);
        createRequest().a(new j<b, EcKwaiInfo>(this) { // from class: com.kwad.sdk.ec.download.EcKwaiInfoManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EcKwaiInfoManager a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bVar, i2, str) == null) {
                    this.a.postDownloadEndMessage(null);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull b bVar, @NonNull EcKwaiInfo ecKwaiInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, bVar, ecKwaiInfo) == null) {
                    this.a.postDownloadEndMessage(ecKwaiInfo);
                }
            }
        });
    }

    public void startDownload(Context context, AdTemplate adTemplate, String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, adTemplate, str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            if (this.mDownloadSource == 0) {
                this.mDownloadSource = i2;
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
            u.a(context, context.getString(R.string.ksad_download_kwai_waiting), 0);
            init(context);
        }
    }
}
