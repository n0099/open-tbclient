package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static Handler a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479430456, "Lcom/ss/android/socialbase/downloader/i/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479430456, "Lcom/ss/android/socialbase/downloader/i/g;");
                return;
            }
        }
        a = new Handler(Looper.getMainLooper());
    }

    public static com.ss.android.socialbase.downloader.model.a a(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, downloadTask)) == null) {
            if (downloadTask == null) {
                return null;
            }
            return new a.AbstractBinderC2136a(downloadTask) { // from class: com.ss.android.socialbase.downloader.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadTask a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {downloadTask};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = downloadTask;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public DownloadInfo a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getDownloadInfo() : (DownloadInfo) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? g.a(this.a.getChunkStrategy()) : (com.ss.android.socialbase.downloader.depend.e) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public y c() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) ? g.a(this.a.getNotificationEventListener()) : (y) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ae d() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? g.a(this.a.getNotificationClickCallback()) : (ae) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g.a(this.a.getInterceptor()) : (com.ss.android.socialbase.downloader.depend.h) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? g.a(this.a.getDepend()) : (com.ss.android.socialbase.downloader.depend.f) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public u g() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? g.a(this.a.getForbiddenHandler()) : (u) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ah h() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) ? g.a(this.a.getRetryDelayTimeCalculator()) : (ah) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public p i() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048588, this)) == null) ? g.a(this.a.getDiskSpaceHandler()) : (p) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048589, this)) == null) ? g.a(this.a.getMonitorDepend()) : (com.ss.android.socialbase.downloader.depend.j) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) ? g.a(this.a.getFileUriProvider()) : (com.ss.android.socialbase.downloader.depend.g) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int l() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) ? this.a.getDownloadCompleteHandlers().size() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int a(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? this.a.getDownloadListenerSize(f.e(i2)) : invokeI.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) {
                        return g.a(this.a.getSingleDownloadListener(f.e(i2)), i2 != com.ss.android.socialbase.downloader.constants.f.f61676b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public l c(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048581, this, i2)) == null) ? g.a(this.a.getDownloadCompleteHandlerByIndex(i2)) : (l) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                        return g.a(this.a.getDownloadListenerByIndex(f.e(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.f.f61676b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeII.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.model.a) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.i a(IDownloadListener iDownloadListener, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, iDownloadListener, z)) == null) {
            if (iDownloadListener == null) {
                return null;
            }
            return new i.a(iDownloadListener, z) { // from class: com.ss.android.socialbase.downloader.i.g.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IDownloadListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f61890b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iDownloadListener, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = iDownloadListener;
                    this.f61890b = z;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public int a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.hashCode() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61900b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61900b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61900b.a.onStart(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onStart(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61901b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61901b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61901b.a.onProgress(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onProgress(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void d(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.7
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61902b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61902b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61902b.a.onPause(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onPause(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void e(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61903b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61903b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61903b.a.onSuccessed(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onSuccessed(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void f(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.10
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61892b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61892b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61892b.a.onCanceled(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onCanceled(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void g(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.11
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61893b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61893b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61893b.a.onFirstStart(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onFirstStart(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void h(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.12
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61894b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61894b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61894b.a.onFirstSuccess(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onFirstSuccess(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void i(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, downloadInfo) == null) {
                        IDownloadListener iDownloadListener2 = this.a;
                        if (iDownloadListener2 instanceof s) {
                            if (this.f61890b) {
                                g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DownloadInfo a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass12 f61899b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, downloadInfo};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f61899b = this;
                                        this.a = downloadInfo;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            ((s) this.f61899b.a).a(this.a);
                                        }
                                    }
                                });
                            } else {
                                ((s) iDownloadListener2).a(downloadInfo);
                            }
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61891b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61891b = this;
                                    this.a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61891b.a.onPrepare(this.a);
                                    }
                                }
                            });
                        } else {
                            this.a.onPrepare(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, baseException) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f61895b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61896c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo, baseException};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61896c = this;
                                    this.a = downloadInfo;
                                    this.f61895b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61896c.a.onRetry(this.a, this.f61895b);
                                    }
                                }
                            });
                        } else {
                            this.a.onRetry(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f61897b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61898c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo, baseException};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61898c = this;
                                    this.a = downloadInfo;
                                    this.f61897b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61898c.a.onRetryDelay(this.a, this.f61897b);
                                    }
                                }
                            });
                        } else {
                            this.a.onRetryDelay(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        if (this.f61890b) {
                            g.a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.9
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DownloadInfo a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f61904b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61905c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadInfo, baseException};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61905c = this;
                                    this.a = downloadInfo;
                                    this.f61904b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61905c.a.onFailed(this.a, this.f61904b);
                                    }
                                }
                            });
                        } else {
                            this.a.onFailed(downloadInfo, baseException);
                        }
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.i) invokeLZ.objValue;
    }

    public static y a(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, zVar)) == null) {
            if (zVar == null) {
                return null;
            }
            return new y.a(zVar) { // from class: com.ss.android.socialbase.downloader.i.g.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = zVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        this.a.a(i2, downloadInfo, str, str2);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public boolean a(boolean z) throws RemoteException {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.a() : (String) invokeV.objValue;
                }
            };
        }
        return (y) invokeL.objValue;
    }

    public static ae a(af afVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, afVar)) == null) {
            if (afVar == null) {
                return null;
            }
            return new ae.a(afVar) { // from class: com.ss.android.socialbase.downloader.i.g.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ af a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {afVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = afVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) ? this.a.a(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.a.b(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) ? this.a.c(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (ae) invokeL.objValue;
    }

    public static ah a(com.ss.android.socialbase.downloader.downloader.s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new ah.a(sVar) { // from class: com.ss.android.socialbase.downloader.i.g.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.downloader.s a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ah
                public long a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? this.a.a(i2, i3) : invokeII.longValue;
                }
            };
        }
        return (ah) invokeL.objValue;
    }

    public static u a(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, wVar)) == null) {
            if (wVar == null) {
                return null;
            }
            return new u.a(wVar) { // from class: com.ss.android.socialbase.downloader.i.g.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ w a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {wVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = wVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public boolean a(t tVar) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, tVar)) == null) ? this.a.a(g.a(tVar)) : invokeL2.booleanValue;
                }
            };
        }
        return (u) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.g a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, iDownloadFileUriProvider)) == null) {
            if (iDownloadFileUriProvider == null) {
                return null;
            }
            return new g.a(iDownloadFileUriProvider) { // from class: com.ss.android.socialbase.downloader.i.g.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IDownloadFileUriProvider a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iDownloadFileUriProvider};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = iDownloadFileUriProvider;
                }

                @Override // com.ss.android.socialbase.downloader.depend.g
                public Uri a(String str, String str2) throws RemoteException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? this.a.getUriForFile(str, str2) : (Uri) invokeLL.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.g) invokeL.objValue;
    }

    public static v a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, tVar)) == null) {
            if (tVar == null) {
                return null;
            }
            return new v(tVar) { // from class: com.ss.android.socialbase.downloader.i.g.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ t a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = tVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        try {
                            this.a.a(list);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        try {
                            return this.a.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeV.booleanValue;
                }
            };
        }
        return (v) invokeL.objValue;
    }

    public static p a(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, rVar)) == null) {
            if (rVar == null) {
                return null;
            }
            return new p.a(rVar) { // from class: com.ss.android.socialbase.downloader.i.g.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = rVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.p
                public boolean a(long j2, long j3, o oVar) throws RemoteException {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), oVar})) == null) ? this.a.a(j2, j3, g.a(oVar)) : invokeCommon.booleanValue;
                }
            };
        }
        return (p) invokeL.objValue;
    }

    public static q a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, oVar)) == null) {
            if (oVar == null) {
                return null;
            }
            return new q(oVar) { // from class: com.ss.android.socialbase.downloader.i.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ o a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {oVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = oVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.q
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.a.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
        }
        return (q) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.f a(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, nVar)) == null) {
            if (nVar == null) {
                return null;
            }
            return new f.a(nVar) { // from class: com.ss.android.socialbase.downloader.i.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ n a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = nVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.f
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        this.a.a(downloadInfo, baseException, i2);
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.f) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.j a(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, xVar)) == null) {
            if (xVar == null) {
                return null;
            }
            return new j.a(xVar) { // from class: com.ss.android.socialbase.downloader.i.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = xVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public void a(String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        this.a.a(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public int[] b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        x xVar2 = this.a;
                        if (xVar2 instanceof com.ss.android.socialbase.downloader.depend.c) {
                            return ((com.ss.android.socialbase.downloader.depend.c) xVar2).a();
                        }
                        return null;
                    }
                    return (int[]) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.b() : (String) invokeV.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.j) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.e a(com.ss.android.socialbase.downloader.downloader.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            return new e.a(hVar) { // from class: com.ss.android.socialbase.downloader.i.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.downloader.h a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = hVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.e
                public int a(long j2) throws RemoteException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) ? this.a.a(j2) : invokeJ.intValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.e) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.h a(IDownloadInterceptor iDownloadInterceptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, iDownloadInterceptor)) == null) {
            if (iDownloadInterceptor == null) {
                return null;
            }
            return new h.a(iDownloadInterceptor) { // from class: com.ss.android.socialbase.downloader.i.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IDownloadInterceptor a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iDownloadInterceptor};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = iDownloadInterceptor;
                }

                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.intercepte() : invokeV.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.h) invokeL.objValue;
    }

    public static DownloadTask a(com.ss.android.socialbase.downloader.model.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            try {
                DownloadTask downloadTask = new DownloadTask(aVar.a());
                downloadTask.chunkStategy(a(aVar.b())).notificationEventListener(a(aVar.c())).interceptor(a(aVar.e())).depend(a(aVar.f())).monitorDepend(a(aVar.j())).forbiddenHandler(a(aVar.g())).diskSpaceHandler(a(aVar.i())).fileUriProvider(a(aVar.k())).notificationClickCallback(a(aVar.d())).retryDelayTimeCalculator(a(aVar.h()));
                com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.f.a.ordinal());
                if (b2 != null) {
                    downloadTask.mainThreadListenerWithHashCode(b2.hashCode(), a(b2));
                }
                com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f61676b.ordinal());
                if (b3 != null) {
                    downloadTask.subThreadListenerWithHashCode(b3.hashCode(), a(b3));
                }
                com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f61677c.ordinal());
                if (b4 != null) {
                    downloadTask.notificationListenerWithHashCode(b4.hashCode(), a(b4));
                }
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.a);
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.f61676b);
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.f61677c);
                a(downloadTask, aVar);
                return downloadTask;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadTask) invokeL.objValue;
    }

    public static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar, com.ss.android.socialbase.downloader.constants.f fVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65571, null, downloadTask, aVar, fVar) == null) {
            SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < aVar.a(fVar.ordinal()); i2++) {
                com.ss.android.socialbase.downloader.depend.i a2 = aVar.a(fVar.ordinal(), i2);
                if (a2 != null) {
                    sparseArray.put(a2.a(), a(a2));
                }
            }
            downloadTask.setDownloadListeners(sparseArray, fVar);
        }
    }

    public static void a(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, downloadTask, aVar) == null) {
            for (int i2 = 0; i2 < aVar.l(); i2++) {
                l c2 = aVar.c(i2);
                if (c2 != null) {
                    downloadTask.addDownloadCompleteHandler(a(c2));
                }
            }
        }
    }

    public static z a(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, yVar)) == null) {
            if (yVar == null) {
                return null;
            }
            return new z(yVar) { // from class: com.ss.android.socialbase.downloader.i.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ y a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {yVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = yVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        try {
                            this.a.a(i2, downloadInfo, str, str2);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public boolean a(boolean z) {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                        try {
                            return this.a.a(z);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public String a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            return this.a.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return (String) invokeV.objValue;
                }
            };
        }
        return (z) invokeL.objValue;
    }

    public static m a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, lVar)) == null) {
            if (lVar == null) {
                return null;
            }
            return new m(lVar) { // from class: com.ss.android.socialbase.downloader.i.g.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = lVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.m
                public void a(DownloadInfo downloadInfo) throws BaseException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.a.a(downloadInfo);
                        } catch (RemoteException e2) {
                            throw new BaseException(1008, e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.m
                public boolean b(DownloadInfo downloadInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                        try {
                            return this.a.b(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeL2.booleanValue;
                }
            };
        }
        return (m) invokeL.objValue;
    }

    public static l a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, mVar)) == null) {
            if (mVar == null) {
                return null;
            }
            return new l.a(mVar) { // from class: com.ss.android.socialbase.downloader.i.g.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = mVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.a.a(downloadInfo);
                        } catch (BaseException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.a.b(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (l) invokeL.objValue;
    }

    public static af a(ae aeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aeVar)) == null) {
            if (aeVar == null) {
                return null;
            }
            return new af(aeVar) { // from class: com.ss.android.socialbase.downloader.i.g.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ae a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aeVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aeVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean a(DownloadInfo downloadInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) {
                        try {
                            return this.a.a(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean b(DownloadInfo downloadInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                        try {
                            return this.a.b(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean c(DownloadInfo downloadInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                        try {
                            return this.a.c(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeL2.booleanValue;
                }
            };
        }
        return (af) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.downloader.h a(com.ss.android.socialbase.downloader.depend.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.downloader.h(eVar) { // from class: com.ss.android.socialbase.downloader.i.g.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = eVar;
                }

                @Override // com.ss.android.socialbase.downloader.downloader.h
                public int a(long j2) {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) {
                        try {
                            return this.a.a(j2);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return 0;
                        }
                    }
                    return invokeJ.intValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.downloader.h) invokeL.objValue;
    }

    public static n a(com.ss.android.socialbase.downloader.depend.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            return new n(fVar) { // from class: com.ss.android.socialbase.downloader.i.g.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = fVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.n
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
                        return;
                    }
                    try {
                        this.a.a(downloadInfo, baseException, i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            };
        }
        return (n) invokeL.objValue;
    }

    public static x a(com.ss.android.socialbase.downloader.depend.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, jVar)) == null) {
            if (jVar == null) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.depend.c(jVar) { // from class: com.ss.android.socialbase.downloader.i.g.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.x
                public void a(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                        return;
                    }
                    try {
                        this.a.a(jSONObject.toString());
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.x
                public String b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        try {
                            return this.a.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return "";
                        }
                    }
                    return (String) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.c
                public int[] a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        try {
                            return this.a.b();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return (int[]) invokeV.objValue;
                }
            };
        }
        return (x) invokeL.objValue;
    }

    public static w a(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, uVar)) == null) {
            if (uVar == null) {
                return null;
            }
            return new w(uVar) { // from class: com.ss.android.socialbase.downloader.i.g.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ u a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {uVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = uVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.w
                public boolean a(v vVar) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, vVar)) == null) {
                        try {
                            return this.a.a(g.a(vVar));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeL2.booleanValue;
                }
            };
        }
        return (w) invokeL.objValue;
    }

    public static t a(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, vVar)) == null) {
            if (vVar == null) {
                return null;
            }
            return new t.a(vVar) { // from class: com.ss.android.socialbase.downloader.i.g.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ v a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = vVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.t
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.a.a(list);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.t
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a() : invokeV.booleanValue;
                }
            };
        }
        return (t) invokeL.objValue;
    }

    public static aj a(ak akVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, akVar)) == null) {
            if (akVar == null) {
                return null;
            }
            return new aj.a(akVar) { // from class: com.ss.android.socialbase.downloader.i.g.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ak a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {akVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = akVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aj
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.a.a(i2, i3);
                    }
                }
            };
        }
        return (aj) invokeL.objValue;
    }

    public static ak a(aj ajVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ajVar)) == null) {
            if (ajVar == null) {
                return null;
            }
            return new ak(ajVar) { // from class: com.ss.android.socialbase.downloader.i.g.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ aj a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ajVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = ajVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ak
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        try {
                            this.a.a(i2, i3);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
        }
        return (ak) invokeL.objValue;
    }

    public static r a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, pVar)) == null) {
            if (pVar == null) {
                return null;
            }
            return new r(pVar) { // from class: com.ss.android.socialbase.downloader.i.g.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {pVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = pVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.r
                public boolean a(long j2, long j3, q qVar) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), qVar})) == null) {
                        try {
                            return this.a.a(j2, j3, g.a(qVar));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeCommon.booleanValue;
                }
            };
        }
        return (r) invokeL.objValue;
    }

    public static o a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, qVar)) == null) {
            if (qVar == null) {
                return null;
            }
            return new o.a(qVar) { // from class: com.ss.android.socialbase.downloader.i.g.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ q a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {qVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = qVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.o
                public void a() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                    }
                }
            };
        }
        return (o) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.downloader.s a(ah ahVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, ahVar)) == null) {
            if (ahVar == null) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.downloader.s(ahVar) { // from class: com.ss.android.socialbase.downloader.i.g.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ah a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ahVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = ahVar;
                }

                @Override // com.ss.android.socialbase.downloader.downloader.s
                public long a(int i2, int i3) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) {
                        try {
                            return this.a.a(i2, i3);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return 0L;
                        }
                    }
                    return invokeII.longValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.downloader.s) invokeL.objValue;
    }

    public static IDownloadInterceptor a(com.ss.android.socialbase.downloader.depend.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            return new IDownloadInterceptor(hVar) { // from class: com.ss.android.socialbase.downloader.i.g.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = hVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
                public boolean intercepte() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            return this.a.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return invokeV.booleanValue;
                }
            };
        }
        return (IDownloadInterceptor) invokeL.objValue;
    }

    public static IDownloadFileUriProvider a(com.ss.android.socialbase.downloader.depend.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            return new IDownloadFileUriProvider(gVar) { // from class: com.ss.android.socialbase.downloader.i.g.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = gVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
                public Uri getUriForFile(String str, String str2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) {
                        try {
                            return this.a.a(str, str2);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return (Uri) invokeLL.objValue;
                }
            };
        }
        return (IDownloadFileUriProvider) invokeL.objValue;
    }

    public static IDownloadListener a(com.ss.android.socialbase.downloader.depend.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            return new s(iVar) { // from class: com.ss.android.socialbase.downloader.i.g.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = iVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.s
                public void a(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.a.i(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onCanceled(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                        try {
                            this.a.f(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        try {
                            this.a.a(downloadInfo, baseException);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onFirstStart(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        try {
                            this.a.g(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onFirstSuccess(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, downloadInfo) == null) {
                        try {
                            this.a.h(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onPause(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        try {
                            this.a.d(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onPrepare(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, downloadInfo) == null) {
                        try {
                            this.a.a(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onProgress(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        try {
                            this.a.c(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, baseException) == null) {
                        try {
                            this.a.b(downloadInfo, baseException);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048585, this, downloadInfo, baseException) == null) {
                        try {
                            this.a.c(downloadInfo, baseException);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onStart(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        try {
                            this.a.b(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onSuccessed(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        try {
                            this.a.e(downloadInfo);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
        }
        return (IDownloadListener) invokeL.objValue;
    }
}
