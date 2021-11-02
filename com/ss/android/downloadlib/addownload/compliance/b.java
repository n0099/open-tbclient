package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.f;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.l;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<Activity> f68582a;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f68591a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(213185075, "Lcom/ss/android/downloadlib/addownload/compliance/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(213185075, "Lcom/ss/android/downloadlib/addownload/compliance/b$a;");
                    return;
                }
            }
            f68591a = new b();
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            com.ss.android.downloadlib.addownload.e a2 = f.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j).f68515b.getDownloadUrl());
            if (a2 != null) {
                a2.a(true, true);
                return;
            }
            e.a(11, j);
            com.ss.android.downloadlib.e.c.a().b("startDownload handler null");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f68591a : (b) invokeV.objValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            TTDelegateActivity.a(j);
        }
    }

    public boolean a(DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadModel)) == null) {
            if (downloadModel.isAd() && j.i().optInt("ad_lp_show_app_dialog") != 0) {
                String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
                return (TextUtils.isEmpty(webUrl) || Pattern.compile(j.i().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Activity b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = this.f68582a.get();
            this.f68582a = null;
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    public boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        InterceptResult invokeL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            if (!TextUtils.isEmpty(eVar.f68515b.getLogExtra())) {
                try {
                    j = l.a(new JSONObject(eVar.f68515b.getLogExtra()), "convert_id");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    e.a(3, eVar);
                }
                j2 = j;
            } else {
                e.a(9, eVar);
                com.ss.android.downloadlib.e.c.a().a("requestAppInfo getLogExtra null");
                j2 = 0;
            }
            long j3 = eVar.f68514a;
            com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(j2, j3);
            if (a2 != null) {
                d.a().a(a2.a(), j3, a2.f68490d);
                a(a2.a());
                e.a("lp_app_dialog_try_show", eVar);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            if (j2 > 0) {
                sb.append("convert_id=");
                sb.append(j2);
            }
            if (!TextUtils.isEmpty(eVar.f68515b.getPackageName())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(eVar.f68515b.getPackageName());
            }
            if (sb.length() <= 0) {
                e.a(6, eVar);
                return false;
            }
            long j4 = j2;
            com.ss.android.downloadlib.g.c.a((c.a<String, R>) new c.a<String, Boolean>(this, j4, j3) { // from class: com.ss.android.downloadlib.addownload.compliance.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f68586a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68587b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f68588c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j4), Long.valueOf(j3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68588c = this;
                    this.f68586a = j4;
                    this.f68587b = j3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.ss.android.downloadlib.g.c.a
                public Boolean a(String str) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        boolean[] zArr = {false};
                        j.d().a("GET", str, new HashMap(), new q(this, zArr) { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ boolean[] f68589a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f68590b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, zArr};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68590b = this;
                                this.f68589a = zArr;
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(String str2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                    boolean[] zArr2 = this.f68589a;
                                    AnonymousClass2 anonymousClass2 = this.f68590b;
                                    zArr2[0] = anonymousClass2.f68588c.a(anonymousClass2.f68586a, anonymousClass2.f68587b, str2);
                                }
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(Throwable th) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                    e.a(2, this.f68590b.f68587b);
                                    this.f68589a[0] = false;
                                }
                            }
                        });
                        return Boolean.valueOf(zArr[0]);
                    }
                    return (Boolean) invokeL2.objValue;
                }
            }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).a(new c.a<Boolean, Object>(this, j4, j3) { // from class: com.ss.android.downloadlib.addownload.compliance.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f68583a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68584b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f68585c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j4), Long.valueOf(j3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68585c = this;
                    this.f68583a = j4;
                    this.f68584b = j3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Boolean bool) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, bool)) == null) {
                        if (bool.booleanValue()) {
                            this.f68585c.a(com.ss.android.downloadlib.addownload.b.b.a(this.f68583a, this.f68584b));
                            e.b("lp_app_dialog_try_show", this.f68584b);
                            return null;
                        }
                        this.f68585c.b(this.f68584b);
                        return null;
                    }
                    return invokeL2.objValue;
                }
            }).a();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                    bVar.f68487a = j;
                    bVar.f68488b = j2;
                    bVar.f68490d = optJSONObject.optString("icon_url");
                    bVar.f68491e = optJSONObject.optString("app_name");
                    bVar.f68489c = optJSONObject.optString("package_name");
                    bVar.f68492f = optJSONObject.optString("version_name");
                    bVar.f68493g = optJSONObject.optString("developer_name");
                    bVar.f68495i = optJSONObject.optString("policy_url");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                            bVar.f68494h.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                        }
                    }
                    c.a().a(bVar);
                    d.a().a(bVar.a(), j2, bVar.f68490d);
                    return true;
                }
                e.a(7, j2);
                return false;
            } catch (Exception e2) {
                com.ss.android.downloadlib.e.c.a().a(e2, "AdLpComplianceManager parseResponse");
                e.a(7, j2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.f68582a = new SoftReference<>(activity);
        }
    }
}
