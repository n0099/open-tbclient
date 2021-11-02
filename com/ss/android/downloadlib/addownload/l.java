package com.ss.android.downloadlib.addownload;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static com.ss.android.downloadlib.addownload.a.c f68675a;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ss.android.downloadlib.addownload.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f68675a : (com.ss.android.downloadlib.addownload.a.c) invokeV.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 : invokeI.booleanValue;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cVar) == null) {
            f68675a = cVar;
        }
    }

    public static boolean a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, int i2, com.ss.android.downloadlib.addownload.d.c cVar) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, bVar, downloadInfo, i2, cVar)) == null) {
            if (bVar == null) {
                com.ss.android.downloadlib.e.c.a().a("tryReverseWifi nativeModel null");
                return false;
            } else if (downloadInfo == null) {
                com.ss.android.downloadlib.e.c.a().a("tryReverseWifi info null");
                return false;
            } else {
                int id = downloadInfo.getId();
                boolean b2 = com.ss.android.downloadlib.g.e.b(bVar);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("switch_status", Integer.valueOf(b2 ? 1 : 0));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
                if (b2 && a(i2) && !com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && !downloadInfo.hasPauseReservedOnWifi()) {
                    a(new com.ss.android.downloadlib.addownload.a.c(id, bVar, cVar) { // from class: com.ss.android.downloadlib.addownload.l.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f68676a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadad.api.a.b f68677b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ com.ss.android.downloadlib.addownload.d.c f68678c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {Integer.valueOf(id), bVar, cVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68676a = id;
                            this.f68677b = bVar;
                            this.f68678c = cVar;
                        }

                        @Override // com.ss.android.downloadlib.addownload.a.c
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                l.a((com.ss.android.downloadlib.addownload.a.c) null);
                                DownloadInfo downloadInfo2 = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f68676a);
                                if (downloadInfo2 != null) {
                                    downloadInfo2.startPauseReserveOnWifi();
                                    r.a().a(downloadInfo2);
                                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", this.f68677b);
                                }
                                this.f68678c.a(this.f68677b);
                            }
                        }

                        @Override // com.ss.android.downloadlib.addownload.a.c
                        public void b() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                l.a((com.ss.android.downloadlib.addownload.a.c) null);
                                DownloadInfo downloadInfo2 = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f68676a);
                                if (downloadInfo2 != null) {
                                    downloadInfo2.stopPauseReserveOnWifi();
                                }
                                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", this.f68677b);
                                this.f68678c.a(this.f68677b);
                            }
                        }
                    });
                    TTDelegateActivity.b(bVar);
                    return true;
                }
                return false;
            }
        }
        return invokeLLIL.booleanValue;
    }
}
