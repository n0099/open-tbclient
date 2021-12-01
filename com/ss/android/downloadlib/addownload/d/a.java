package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public static com.ss.android.downloadlib.addownload.a.c a;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static com.ss.android.downloadlib.addownload.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (com.ss.android.downloadlib.addownload.a.c) invokeV.objValue;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        InterceptResult invokeLIL;
        DownloadInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, cVar)) == null) {
            if (bVar == null || bVar.ac() || !a(bVar) || (a2 = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a())) == null) {
                return false;
            }
            long a3 = i.a(a2.getId(), a2.getCurBytes(), a2.getTotalBytes());
            long totalBytes = a2.getTotalBytes();
            if (a3 <= 0 || totalBytes <= 0 || totalBytes > a(bVar.s())) {
                return false;
            }
            a = new com.ss.android.downloadlib.addownload.a.c(this, bVar, cVar) { // from class: com.ss.android.downloadlib.addownload.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f61287b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61288c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61288c = this;
                    this.a = bVar;
                    this.f61287b = cVar;
                }

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.downloadlib.addownload.a.c unused = a.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "apk_size");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, this.a);
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.a.c
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.ss.android.downloadlib.addownload.a.c unused = a.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "apk_size");
                            jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, this.a);
                        this.f61287b.a(this.a);
                    }
                }
            };
            TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", a(totalBytes - a3)), "继续", "暂停");
            bVar.n(true);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_apk_size", 100) * 1024 * 1024 : invokeI.intValue;
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aVar)) == null) ? com.ss.android.downloadlib.g.e.a(aVar).a("pause_optimise_apk_size_switch", 0) == 1 && aVar.q() : invokeL.booleanValue;
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (j2 >= 1073741824) {
                return (j2 / 1073741824) + "G";
            } else if (j2 >= 1048576) {
                return (j2 / 1048576) + "M";
            } else {
                return decimalFormat.format(((float) j2) / 1048576.0f) + "M";
            }
        }
        return (String) invokeJ.objValue;
    }
}
