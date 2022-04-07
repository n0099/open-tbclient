package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(int i, @Nullable String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
            boolean q = ga8.q(i);
            boolean z = i == 1000;
            sc8 sc8Var = new sc8();
            if (q) {
                sc8Var.c(z ? "APP" : "URL");
                if (!z) {
                    sc8Var.l(i);
                }
            } else {
                sc8Var.c("DOWNLOAD_BUTTON");
            }
            sc8Var.i(q ? 706 : 2);
            sc8Var.h(q ? "DEEPLINK" : "DOWNLOAD_PAGE");
            if (!TextUtils.isEmpty(str)) {
                DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
                downloadStaticsData.setApk_name(str);
                sc8Var.t(downloadStaticsData);
            }
            if (!TextUtils.isEmpty(str2)) {
                sc8Var.v(str2);
            }
            uc8.b().d(sc8Var);
        }
    }

    public void b(int i, @Nullable String str, String str2, @NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, adDownloadData}) == null) {
            c(adDownloadData.getPage(), i, str, str2, adDownloadData.getDownloadUrl(), TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(adDownloadData.adId(), 0L));
        }
    }

    public void c(String str, int i, @Nullable String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), str2, str3, str4, Long.valueOf(j)}) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(i);
            if (TextUtils.isEmpty(str)) {
                str = "DOWNLOAD_PAGE";
            }
            sc8Var.h(str);
            sc8Var.c("DOWNLOAD_BUTTON");
            if (!TextUtils.isEmpty(str2)) {
                DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
                downloadStaticsData.setApk_name(str2);
                sc8Var.t(downloadStaticsData);
            }
            if (!TextUtils.isEmpty(str3)) {
                sc8Var.v(str3);
            }
            sc8Var.k(str2);
            sc8Var.q(str4);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_download_content_length", j);
                sc8Var.s(jSONObject.toString());
            } catch (JSONException e) {
                if (vm4.e()) {
                    throw new IllegalArgumentException(e);
                }
            }
            uc8.b().d(sc8Var);
        }
    }
}
