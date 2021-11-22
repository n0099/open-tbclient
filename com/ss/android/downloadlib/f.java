package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f69695a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f69696b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ss.android.downloadlib.addownload.f> f69697c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, com.ss.android.downloadlib.addownload.f> f69698d;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f69699e;

    /* renamed from: f  reason: collision with root package name */
    public long f69700f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1020732220, "Lcom/ss/android/downloadlib/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1020732220, "Lcom/ss/android/downloadlib/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69697c = new CopyOnWriteArrayList();
        this.f69698d = new ConcurrentHashMap();
        this.f69699e = new CopyOnWriteArrayList<>();
        this.f69696b = new Handler(Looper.getMainLooper());
    }

    private synchronized void b(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i2, downloadStatusChangeListener, downloadModel) == null) {
            synchronized (this) {
                if (this.f69697c.size() <= 0) {
                    c(context, i2, downloadStatusChangeListener, downloadModel);
                } else {
                    com.ss.android.downloadlib.addownload.f remove = this.f69697c.remove(0);
                    remove.b(context).b(i2, downloadStatusChangeListener).b(downloadModel).a();
                    this.f69698d.put(downloadModel.getDownloadUrl(), remove);
                }
            }
        }
    }

    private void c(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(AdIconUtil.BAIDU_LOGO_ID, this, context, i2, downloadStatusChangeListener, downloadModel) == null) || downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i2, downloadStatusChangeListener).b(downloadModel).a();
        this.f69698d.put(downloadModel.getDownloadUrl(), eVar);
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (com.ss.android.downloadlib.addownload.f fVar : this.f69697c) {
                if (!fVar.b() && currentTimeMillis - fVar.d() > 300000) {
                    fVar.h();
                    arrayList.add(fVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f69697c.removeAll(arrayList);
        }
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f69695a == null) {
                synchronized (f.class) {
                    if (f69695a == null) {
                        f69695a = new f();
                    }
                }
            }
            return f69695a;
        }
        return (f) invokeV.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f69700f < 300000) {
                return;
            }
            this.f69700f = currentTimeMillis;
            if (this.f69697c.isEmpty()) {
                return;
            }
            d();
        }
    }

    public void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, downloadStatusChangeListener, downloadModel) == null) || downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        com.ss.android.downloadlib.addownload.f fVar = this.f69698d.get(downloadModel.getDownloadUrl());
        if (fVar != null) {
            fVar.b(context).b(i2, downloadStatusChangeListener).b(downloadModel).a();
        } else if (!this.f69697c.isEmpty()) {
            b(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            c(context, i2, downloadStatusChangeListener, downloadModel);
        }
    }

    public void b(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, downloadInfo, str) == null) {
            this.f69696b.post(new Runnable(this, downloadInfo, str) { // from class: com.ss.android.downloadlib.f.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69712a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f69713b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f69714c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69714c = this;
                    this.f69712a = downloadInfo;
                    this.f69713b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f69714c.f69699e.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next instanceof com.ss.android.download.api.download.a.a) {
                                ((com.ss.android.download.api.download.a.a) next).b(this.f69712a, this.f69713b);
                            } else if (next instanceof SoftReference) {
                                SoftReference softReference = (SoftReference) next;
                                if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                                    ((com.ss.android.download.api.download.a.a) softReference.get()).b(this.f69712a, this.f69713b);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f69696b : (Handler) invokeV.objValue;
    }

    public com.ss.android.downloadlib.addownload.e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, com.ss.android.downloadlib.addownload.f> map = this.f69698d;
            if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.addownload.f fVar = this.f69698d.get(str);
                if (fVar instanceof com.ss.android.downloadlib.addownload.e) {
                    return (com.ss.android.downloadlib.addownload.e) fVar;
                }
            }
            return null;
        }
        return (com.ss.android.downloadlib.addownload.e) invokeL.objValue;
    }

    public void a(String str, int i2) {
        com.ss.android.downloadlib.addownload.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || TextUtils.isEmpty(str) || (fVar = this.f69698d.get(str)) == null) {
            return;
        }
        if (fVar.a(i2)) {
            this.f69697c.add(fVar);
            this.f69698d.remove(str);
        }
        c();
    }

    public void a(String str, boolean z) {
        com.ss.android.downloadlib.addownload.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) || TextUtils.isEmpty(str) || (fVar = this.f69698d.get(str)) == null) {
            return;
        }
        fVar.a(z);
    }

    public void a(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController}) == null) {
            a(str, j, i2, downloadEventConfig, downloadController, null, null);
        }
    }

    public void a(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, u uVar, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener}) == null) || TextUtils.isEmpty(str) || (fVar = this.f69698d.get(str)) == null) {
            return;
        }
        fVar.a(j).b(downloadEventConfig).b(downloadController).a(uVar).a(iDownloadButtonClickListener).b(i2);
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_listener_oom", false)) {
            this.f69699e.add(new SoftReference(aVar));
        } else {
            this.f69699e.add(aVar);
        }
    }

    public void a(DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, downloadModel, downloadController, downloadEventConfig) == null) {
            this.f69696b.post(new Runnable(this, downloadModel, downloadController, downloadEventConfig) { // from class: com.ss.android.downloadlib.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f69701a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DownloadController f69702b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f69703c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f69704d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadModel, downloadController, downloadEventConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69704d = this;
                    this.f69701a = downloadModel;
                    this.f69702b = downloadController;
                    this.f69703c = downloadEventConfig;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f69704d.f69699e.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next instanceof com.ss.android.download.api.download.a.a) {
                                ((com.ss.android.download.api.download.a.a) next).a(this.f69701a, this.f69702b, this.f69703c);
                            } else if (next instanceof SoftReference) {
                                SoftReference softReference = (SoftReference) next;
                                if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                                    ((com.ss.android.download.api.download.a.a) softReference.get()).a(this.f69701a, this.f69702b, this.f69703c);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadInfo, baseException, str) == null) {
            this.f69696b.post(new Runnable(this, downloadInfo, baseException, str) { // from class: com.ss.android.downloadlib.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69705a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BaseException f69706b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f69707c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f69708d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo, baseException, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69708d = this;
                    this.f69705a = downloadInfo;
                    this.f69706b = baseException;
                    this.f69707c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f69708d.f69699e.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next instanceof com.ss.android.download.api.download.a.a) {
                                ((com.ss.android.download.api.download.a.a) next).a(this.f69705a, this.f69706b, this.f69707c);
                            } else if (next instanceof SoftReference) {
                                SoftReference softReference = (SoftReference) next;
                                if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                                    ((com.ss.android.download.api.download.a.a) softReference.get()).a(this.f69705a, this.f69706b, this.f69707c);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, str) == null) {
            this.f69696b.post(new Runnable(this, downloadInfo, str) { // from class: com.ss.android.downloadlib.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69709a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f69710b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ f f69711c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69711c = this;
                    this.f69709a = downloadInfo;
                    this.f69710b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f69711c.f69699e.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next instanceof com.ss.android.download.api.download.a.a) {
                                ((com.ss.android.download.api.download.a.a) next).a(this.f69709a, this.f69710b);
                            } else if (next instanceof SoftReference) {
                                SoftReference softReference = (SoftReference) next;
                                if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                                    ((com.ss.android.download.api.download.a.a) softReference.get()).a(this.f69709a, this.f69710b);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            this.f69696b.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.downloadlib.f.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69715a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f69716b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69716b = this;
                    this.f69715a = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it = this.f69716b.f69699e.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (next instanceof com.ss.android.download.api.download.a.a) {
                                ((com.ss.android.download.api.download.a.a) next).a(this.f69715a);
                            } else if (next instanceof SoftReference) {
                                SoftReference softReference = (SoftReference) next;
                                if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                                    ((com.ss.android.download.api.download.a.a) softReference.get()).a(this.f69715a);
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
