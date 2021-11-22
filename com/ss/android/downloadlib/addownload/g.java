package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69574a;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.b.e f69575b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69576c;

    /* renamed from: d  reason: collision with root package name */
    public e f69577d;

    /* renamed from: e  reason: collision with root package name */
    public b f69578e;

    /* loaded from: classes2.dex */
    public static class a extends com.ss.android.socialbase.downloader.depend.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f69584a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69584a = mVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.s
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                a(downloadInfo, 11);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                a(downloadInfo, -4);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                a(downloadInfo, -1);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
                a(downloadInfo, -2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
                a(downloadInfo, 1);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
                a(downloadInfo, 4);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
                a(downloadInfo, 2);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) {
                a(downloadInfo, -3);
            }
        }

        private void a(DownloadInfo downloadInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65537, this, downloadInfo, i2) == null) {
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = downloadInfo;
                obtain.arg1 = i2;
                this.f69584a.sendMessage(obtain);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69576c = false;
        this.f69577d = eVar;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? d() && e() : invokeV.booleanValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            DownloadModel downloadModel = this.f69575b.f69434b;
            return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f69575b.f69434b.getDownloadUrl())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f69575b.f69436d.isAddToDownloadManage() : invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b) && h.a(this.f69575b.f69436d.getLinkMode()) : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
        }
    }

    private boolean e(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, downloadInfo)) == null) ? !com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b) && f(downloadInfo) : invokeL.booleanValue;
    }

    private boolean f(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, downloadInfo)) == null) ? downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getSavePath(), downloadInfo.getName()) : invokeL.booleanValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f69574a = j;
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(j);
            this.f69575b = e2;
            if (e2.x()) {
                com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
            }
        }
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadInfo) == null) || (bVar = this.f69578e) == null) {
            return;
        }
        bVar.a(downloadInfo);
        this.f69578e = null;
    }

    public void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, downloadInfo) == null) && h.a(this.f69575b.f69434b) && !this.f69576c) {
            com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.l.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f69575b);
            this.f69576c = true;
        }
    }

    public boolean d(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadInfo)) == null) ? f() || e(downloadInfo) : invokeL.booleanValue;
    }

    private void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, sVar) == null) {
            if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
                com.ss.android.downloadlib.g.j.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new j.a(this, sVar) { // from class: com.ss.android.downloadlib.addownload.g.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ s f69581a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ g f69582b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69582b = this;
                        this.f69581a = sVar;
                    }

                    @Override // com.ss.android.downloadlib.g.j.a
                    public void a() {
                        s sVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (sVar2 = this.f69581a) == null) {
                            return;
                        }
                        sVar2.a();
                    }

                    @Override // com.ss.android.downloadlib.g.j.a
                    public void a(String str) {
                        s sVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (sVar2 = this.f69581a) == null) {
                            return;
                        }
                        sVar2.a(str);
                    }
                });
            } else if (sVar != null) {
                sVar.a();
            }
        }
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
            this.f69576c = false;
            b(downloadInfo);
        }
    }

    public boolean a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b)) {
                com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.f69575b.f69433a);
                if (d2 != null) {
                    com.ss.android.socialbase.downloader.notification.b.a().f(d2.s());
                }
                return com.ss.android.downloadlib.b.a.a(this.f69575b);
            } else if (a(i2) && !TextUtils.isEmpty(this.f69575b.f69434b.getPackageName()) && j.i().optInt("disable_market") != 1) {
                return com.ss.android.downloadlib.b.a.a(this.f69575b, i2);
            } else {
                if (z && this.f69575b.f69436d.getDownloadMode() == 4 && !this.f69577d.e()) {
                    this.f69577d.c(true);
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            File externalFilesDir = j.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDir != null) {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                if (externalFilesDir.exists()) {
                    return externalFilesDir.getAbsolutePath();
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.a> b(Map<Integer, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    if (obj instanceof com.ss.android.download.api.download.a) {
                        arrayList.add((com.ss.android.download.api.download.a) obj);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a) {
                            arrayList.add((com.ss.android.download.api.download.a) softReference.get());
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (this.f69575b.f69436d.getDownloadMode() == 2 && i2 == 2) {
                return true;
            }
            return this.f69575b.f69436d.getDownloadMode() == 2 && i2 == 1 && j.i().optInt("disable_lp_if_market", 0) == 1;
        }
        return invokeI.booleanValue;
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) ? !z && this.f69575b.f69436d.getDownloadMode() == 1 : invokeZ.booleanValue;
    }

    public void a(@NonNull s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            if (!TextUtils.isEmpty(this.f69575b.f69434b.getFilePath())) {
                String filePath = this.f69575b.f69434b.getFilePath();
                if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                    sVar.a();
                    return;
                }
                try {
                    if (filePath.startsWith(j.getContext().getExternalCacheDir().getParent())) {
                        sVar.a();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            b(new s(this, sVar) { // from class: com.ss.android.downloadlib.addownload.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ s f69579a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f69580b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69580b = this;
                    this.f69579a = sVar;
                }

                @Override // com.ss.android.download.api.config.s
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69579a.a();
                    }
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        j.c().a(1, j.getContext(), this.f69580b.f69575b.f69434b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                        com.ss.android.downloadlib.d.a.a().b(this.f69580b.f69574a, 1);
                        this.f69579a.a(str);
                    }
                }
            });
        }
    }

    public void a(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, message, downloadShortInfo, map) == null) && message != null && message.what == 3) {
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            int i2 = message.arg1;
            if (i2 != 1 && i2 != 6 && i2 == 2) {
                if (downloadInfo.getIsFirstDownload()) {
                    com.ss.android.downloadlib.f a2 = com.ss.android.downloadlib.f.a();
                    com.ss.android.downloadlib.addownload.b.e eVar = this.f69575b;
                    a2.a(eVar.f69434b, eVar.f69436d, eVar.f69435c);
                    downloadInfo.setFirstDownload(false);
                }
                com.ss.android.downloadlib.d.a.a().a(downloadInfo);
            }
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            i.a(downloadShortInfo);
            int a3 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
            long totalBytes = downloadInfo.getTotalBytes();
            int i3 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
            int curBytes = i3 > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
            if ((i3 > 0 || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) && (bVar = this.f69578e) != null) {
                bVar.a(downloadInfo);
                this.f69578e = null;
            }
            for (DownloadStatusChangeListener downloadStatusChangeListener : a(map)) {
                if (a3 != 1) {
                    if (a3 == 2) {
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
                    } else if (a3 == 3) {
                        if (downloadInfo.getStatus() == -4) {
                            downloadStatusChangeListener.onIdle();
                        } else if (downloadInfo.getStatus() == -1) {
                            downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        } else if (downloadInfo.getStatus() == -3) {
                            if (com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b)) {
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                            } else {
                                downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                            }
                        }
                    }
                } else if (downloadInfo.getStatus() != 11) {
                    downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
                } else {
                    for (com.ss.android.download.api.download.a aVar : b(map)) {
                        aVar.a(downloadInfo);
                    }
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f69578e == null) {
            this.f69578e = new b(this) { // from class: com.ss.android.downloadlib.addownload.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f69583a;

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
                    this.f69583a = this;
                }

                @Override // com.ss.android.downloadlib.addownload.g.b
                public void a(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        com.ss.android.downloadlib.d.a.a().a(this.f69583a.f69574a, 2, downloadInfo);
                    }
                }
            };
        }
    }

    public int a(Context context, IDownloadListener iDownloadListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, iDownloadListener)) == null) {
            if (context == null) {
                return 0;
            }
            Map<String, String> headers = this.f69575b.f69434b.getHeaders();
            ArrayList arrayList = new ArrayList();
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    if (entry != null) {
                        arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                    }
                }
            }
            String a2 = com.ss.android.downloadlib.g.d.a(String.valueOf(this.f69575b.f69434b.getId()), this.f69575b.f69434b.getNotificationJumpUrl(), this.f69575b.f69434b.isShowToast(), String.valueOf(this.f69575b.f69434b.getModelType()));
            com.ss.android.socialbase.downloader.g.a b2 = com.ss.android.downloadlib.g.e.b(this.f69575b.f69434b);
            JSONObject a3 = com.ss.android.downloadlib.g.e.a(this.f69575b.f69434b);
            if (!this.f69575b.f69436d.enableAH()) {
                a3 = com.ss.android.downloadlib.g.l.a(a3);
                com.ss.android.downloadlib.g.l.a(a3, "ah_plans", new JSONArray());
            }
            this.f69575b.f69434b.getExecutorGroup();
            int i2 = (this.f69575b.f69434b.isAd() || h.b(this.f69575b.f69434b)) ? 4 : 4;
            String a4 = a(b2);
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.c.a(this.f69575b.f69434b.getDownloadUrl(), a4));
            if (downloadInfo != null && 3 == this.f69575b.f69434b.getModelType()) {
                downloadInfo.setFirstDownload(true);
            }
            com.ss.android.socialbase.appdownloader.f o = new com.ss.android.socialbase.appdownloader.f(context, this.f69575b.f69434b.getDownloadUrl()).b(this.f69575b.f69434b.getBackupUrls()).a(this.f69575b.f69434b.getName()).d(a2).a(arrayList).a(this.f69575b.f69434b.isShowNotification()).c(this.f69575b.f69434b.isNeedWifi()).b(this.f69575b.f69434b.getFileName()).c(a4).j(this.f69575b.f69434b.getAppIcon()).g(this.f69575b.f69434b.getMd5()).i(this.f69575b.f69434b.getSdkMonitorScene()).a(this.f69575b.f69434b.getExpectFileLength()).a(iDownloadListener).l(this.f69575b.f69434b.needIndependentProcess() || b2.a("need_independent_process", 0) == 1).a(this.f69575b.f69434b.getDownloadFileUriProvider()).b(this.f69575b.f69434b.autoInstallWithoutNotification()).f(this.f69575b.f69434b.getPackageName()).d(1000).e(100).a(a3).i(true).j(true).b(b2.a("retry_count", 5)).c(b2.a("backup_url_retry_count", 0)).j(true).m(b2.a("need_head_connection", 0) == 1).d(b2.a("need_https_to_http_retry", 0) == 1).h(b2.a("need_chunk_downgrade_retry", 1) == 1).g(b2.a("need_retry_delay", 0) == 1).h(b2.c("retry_delay_time_array")).k(b2.a("need_reuse_runnable", 0) == 1).f(i2).p(this.f69575b.f69434b.isAutoInstall()).o(this.f69575b.f69434b.distinctDir());
            if (!TextUtils.isEmpty(this.f69575b.f69434b.getMimeType())) {
                o.e(this.f69575b.f69434b.getMimeType());
            } else {
                o.e("application/vnd.android.package-archive");
            }
            if (b2.a("notification_opt_2", 0) == 1) {
                o.a(false);
                o.b(true);
            }
            com.ss.android.downloadlib.addownload.c.a aVar = null;
            if (b2.a("clear_space_use_disk_handler", 0) == 1) {
                aVar = new com.ss.android.downloadlib.addownload.c.a();
                o.a(aVar);
            }
            int a5 = h.a(this.f69575b, c(), o);
            if (aVar != null) {
                aVar.a(a5);
            }
            return a5;
        }
        return invokeLL.intValue;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (!TextUtils.isEmpty(this.f69575b.f69434b.getFilePath())) {
                return this.f69575b.f69434b.getFilePath();
            }
            DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), this.f69575b.f69434b.getDownloadUrl());
            boolean b2 = com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE");
            String b3 = b();
            if (a2 != null && !TextUtils.isEmpty(a2.getSavePath())) {
                String savePath = a2.getSavePath();
                if (b2 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                    return savePath;
                }
                try {
                    if (!TextUtils.isEmpty(b3)) {
                        if (savePath.startsWith(b3)) {
                            return savePath;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(a2.getId());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("ttdownloader_code", Integer.valueOf(b2 ? 1 : 2));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.f69575b);
            String str = null;
            try {
                str = com.ss.android.socialbase.appdownloader.c.b();
            } catch (Exception unused) {
            }
            int a3 = com.ss.android.downloadlib.g.e.a(aVar);
            if (a3 != 0) {
                if (a3 != 4 && (b2 || a3 != 2)) {
                    if ((a3 == 3 || (!b2 && a3 == 1)) && !TextUtils.isEmpty(b3)) {
                        return b3;
                    }
                } else {
                    File filesDir = j.getContext().getFilesDir();
                    if (!filesDir.exists()) {
                        filesDir.mkdirs();
                    }
                    if (filesDir.exists()) {
                        return filesDir.getAbsolutePath();
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void a(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, z) == null) || this.f69575b.f69434b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (h.a(this.f69575b.f69434b)) {
                com.ss.android.downloadlib.d.a.a().a(this.f69574a, 2);
            } else if (z && com.ss.android.downloadlib.d.c.a().c() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.d.a.a().a(this.f69574a, 2);
            }
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.f69574a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                a();
                com.ss.android.downloadlib.addownload.b.f a2 = com.ss.android.downloadlib.addownload.b.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f69575b;
                a2.a(new com.ss.android.downloadad.api.a.b(eVar.f69434b, eVar.f69435c, eVar.f69436d, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a(this.f69574a, 5, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.f69574a, this.f69575b.f69434b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.f69574a, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.f69574a, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.f69574a, this.f69575b.f69434b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.f69574a, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.d.a.a().a(this.f69574a, 3, downloadInfo);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, downloadInfo, downloadShortInfo, list) == null) || list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (downloadInfo.getTotalBytes() > 0) {
                i2 = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
                int i3 = i2 >= 0 ? i2 : 0;
                downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
                i.a(downloadShortInfo);
                for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                    switch (downloadInfo.getStatus()) {
                        case -4:
                        case 0:
                            if (com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b)) {
                                downloadShortInfo.status = -3;
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onIdle();
                                break;
                            }
                        case -3:
                            if (com.ss.android.downloadlib.g.l.a(this.f69575b.f69434b)) {
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                                break;
                            }
                        case -2:
                            downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                            break;
                        case -1:
                            downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                            break;
                        case 11:
                            if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.a) {
                                ((com.ss.android.download.api.download.a) downloadStatusChangeListener).a(downloadInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                                break;
                            }
                    }
                }
                return;
            }
            i2 = 0;
            if (i2 >= 0) {
            }
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            i.a(downloadShortInfo);
            while (r9.hasNext()) {
            }
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener2 : list) {
            downloadStatusChangeListener2.onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> a(Map<Integer, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    if (obj instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) obj);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
