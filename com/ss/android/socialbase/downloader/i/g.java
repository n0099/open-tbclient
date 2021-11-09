package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
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

    /* renamed from: a  reason: collision with root package name */
    public static Handler f69446a;
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
        f69446a = new Handler(Looper.getMainLooper());
    }

    public static com.ss.android.socialbase.downloader.model.a a(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, downloadTask)) == null) {
            if (downloadTask == null) {
                return null;
            }
            return new a.AbstractBinderC2007a(downloadTask) { // from class: com.ss.android.socialbase.downloader.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadTask f69447a;

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
                    this.f69447a = downloadTask;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public DownloadInfo a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69447a.getDownloadInfo() : (DownloadInfo) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? g.a(this.f69447a.getChunkStrategy()) : (com.ss.android.socialbase.downloader.depend.e) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public y c() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) ? g.a(this.f69447a.getNotificationEventListener()) : (y) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ae d() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? g.a(this.f69447a.getNotificationClickCallback()) : (ae) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g.a(this.f69447a.getInterceptor()) : (com.ss.android.socialbase.downloader.depend.h) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? g.a(this.f69447a.getDepend()) : (com.ss.android.socialbase.downloader.depend.f) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public u g() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? g.a(this.f69447a.getForbiddenHandler()) : (u) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ah h() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) ? g.a(this.f69447a.getRetryDelayTimeCalculator()) : (ah) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public p i() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048588, this)) == null) ? g.a(this.f69447a.getDiskSpaceHandler()) : (p) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048589, this)) == null) ? g.a(this.f69447a.getMonitorDepend()) : (com.ss.android.socialbase.downloader.depend.j) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) ? g.a(this.f69447a.getFileUriProvider()) : (com.ss.android.socialbase.downloader.depend.g) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int l() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) ? this.f69447a.getDownloadCompleteHandlers().size() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int a(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? this.f69447a.getDownloadListenerSize(f.e(i2)) : invokeI.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) {
                        return g.a(this.f69447a.getSingleDownloadListener(f.e(i2)), i2 != com.ss.android.socialbase.downloader.constants.f.f69186b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public l c(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048581, this, i2)) == null) ? g.a(this.f69447a.getDownloadCompleteHandlerByIndex(i2)) : (l) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                        return g.a(this.f69447a.getDownloadListenerByIndex(f.e(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.f.f69186b.ordinal());
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDownloadListener f69450a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f69451b;

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
                    this.f69450a = iDownloadListener;
                    this.f69451b = z;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public int a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f69450a.hashCode() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69468a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69469b;

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
                                    this.f69469b = this;
                                    this.f69468a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69469b.f69450a.onStart(this.f69468a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onStart(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69470a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69471b;

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
                                    this.f69471b = this;
                                    this.f69470a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69471b.f69450a.onProgress(this.f69470a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onProgress(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void d(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.7
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69472a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69473b;

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
                                    this.f69473b = this;
                                    this.f69472a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69473b.f69450a.onPause(this.f69472a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onPause(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void e(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69474a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69475b;

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
                                    this.f69475b = this;
                                    this.f69474a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69475b.f69450a.onSuccessed(this.f69474a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onSuccessed(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void f(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.10
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69454a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69455b;

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
                                    this.f69455b = this;
                                    this.f69454a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69455b.f69450a.onCanceled(this.f69454a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onCanceled(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void g(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.11
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69456a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69457b;

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
                                    this.f69457b = this;
                                    this.f69456a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69457b.f69450a.onFirstStart(this.f69456a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onFirstStart(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void h(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.12
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69458a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69459b;

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
                                    this.f69459b = this;
                                    this.f69458a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69459b.f69450a.onFirstSuccess(this.f69458a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onFirstSuccess(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void i(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, downloadInfo) == null) {
                        IDownloadListener iDownloadListener2 = this.f69450a;
                        if (iDownloadListener2 instanceof s) {
                            if (this.f69451b) {
                                g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ DownloadInfo f69466a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass12 f69467b;

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
                                        this.f69467b = this;
                                        this.f69466a = downloadInfo;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            ((s) this.f69467b.f69450a).a(this.f69466a);
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
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.i.g.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69452a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69453b;

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
                                    this.f69453b = this;
                                    this.f69452a = downloadInfo;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69453b.f69450a.onPrepare(this.f69452a);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onPrepare(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, baseException) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69460a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f69461b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69462c;

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
                                    this.f69462c = this;
                                    this.f69460a = downloadInfo;
                                    this.f69461b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69462c.f69450a.onRetry(this.f69460a, this.f69461b);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onRetry(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69463a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f69464b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69465c;

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
                                    this.f69465c = this;
                                    this.f69463a = downloadInfo;
                                    this.f69464b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69465c.f69450a.onRetryDelay(this.f69463a, this.f69464b);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onRetryDelay(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        if (this.f69451b) {
                            g.f69446a.post(new Runnable(this, downloadInfo, baseException) { // from class: com.ss.android.socialbase.downloader.i.g.12.9
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ DownloadInfo f69476a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ BaseException f69477b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f69478c;

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
                                    this.f69478c = this;
                                    this.f69476a = downloadInfo;
                                    this.f69477b = baseException;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f69478c.f69450a.onFailed(this.f69476a, this.f69477b);
                                    }
                                }
                            });
                        } else {
                            this.f69450a.onFailed(downloadInfo, baseException);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ z f69490a;

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
                    this.f69490a = zVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        this.f69490a.a(i2, downloadInfo, str, str2);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public boolean a(boolean z) throws RemoteException {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.f69490a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.y
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f69490a.a() : (String) invokeV.objValue;
                }
            };
        }
        return (y) invokeL.objValue;
    }

    public static ae a(af afVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, afVar)) == null) {
            if (afVar == null) {
                return null;
            }
            return new ae.a(afVar) { // from class: com.ss.android.socialbase.downloader.i.g.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ af f69493a;

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
                    this.f69493a = afVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) ? this.f69493a.a(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f69493a.b(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ae
                public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) ? this.f69493a.c(downloadInfo) : invokeL2.booleanValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.downloader.s f69494a;

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
                    this.f69494a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ah
                public long a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? this.f69494a.a(i2, i3) : invokeII.longValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f69495a;

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
                    this.f69495a = wVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public boolean a(t tVar) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, tVar)) == null) ? this.f69495a.a(g.a(tVar)) : invokeL2.booleanValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDownloadFileUriProvider f69496a;

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
                    this.f69496a = iDownloadFileUriProvider;
                }

                @Override // com.ss.android.socialbase.downloader.depend.g
                public Uri a(String str, String str2) throws RemoteException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? this.f69496a.getUriForFile(str, str2) : (Uri) invokeLL.objValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ t f69498a;

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
                    this.f69498a = tVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        try {
                            this.f69498a.a(list);
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
                            return this.f69498a.a();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ r f69499a;

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
                    this.f69499a = rVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.p
                public boolean a(long j, long j2, o oVar) throws RemoteException {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), oVar})) == null) ? this.f69499a.a(j, j2, g.a(oVar)) : invokeCommon.booleanValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ o f69486a;

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
                    this.f69486a = oVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.q
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69486a.a();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ n f69497a;

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
                    this.f69497a = nVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.f
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        this.f69497a.a(downloadInfo, baseException, i2);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ x f69500a;

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
                    this.f69500a = xVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public void a(String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        this.f69500a.a(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public int[] b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        x xVar2 = this.f69500a;
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
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f69500a.b() : (String) invokeV.objValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.downloader.h f69501a;

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
                    this.f69501a = hVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.e
                public int a(long j) throws RemoteException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) ? this.f69501a.a(j) : invokeJ.intValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IDownloadInterceptor f69502a;

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
                    this.f69502a = iDownloadInterceptor;
                }

                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f69502a.intercepte() : invokeV.booleanValue;
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
                com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f69185a.ordinal());
                if (b2 != null) {
                    downloadTask.mainThreadListenerWithHashCode(b2.hashCode(), a(b2));
                }
                com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f69186b.ordinal());
                if (b3 != null) {
                    downloadTask.subThreadListenerWithHashCode(b3.hashCode(), a(b3));
                }
                com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f69187c.ordinal());
                if (b4 != null) {
                    downloadTask.notificationListenerWithHashCode(b4.hashCode(), a(b4));
                }
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.f69185a);
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.f69186b);
                a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.f.f69187c);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ y f69503a;

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
                    this.f69503a = yVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        try {
                            this.f69503a.a(i2, downloadInfo, str, str2);
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
                            return this.f69503a.a(z);
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
                            return this.f69503a.a();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f69504a;

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
                    this.f69504a = lVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.m
                public void a(DownloadInfo downloadInfo) throws BaseException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f69504a.a(downloadInfo);
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
                            return this.f69504a.b(downloadInfo);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f69505a;

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
                    this.f69505a = mVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f69505a.a(downloadInfo);
                        } catch (BaseException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f69505a.b(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (l) invokeL.objValue;
    }

    public static af a(ae aeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aeVar)) == null) {
            if (aeVar == null) {
                return null;
            }
            return new af(aeVar) { // from class: com.ss.android.socialbase.downloader.i.g.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ae f69448a;

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
                    this.f69448a = aeVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean a(DownloadInfo downloadInfo) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) {
                        try {
                            return this.f69448a.a(downloadInfo);
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
                            return this.f69448a.b(downloadInfo);
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
                            return this.f69448a.c(downloadInfo);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e f69449a;

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
                    this.f69449a = eVar;
                }

                @Override // com.ss.android.socialbase.downloader.downloader.h
                public int a(long j) {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) {
                        try {
                            return this.f69449a.a(j);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f f69479a;

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
                    this.f69479a = fVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.n
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
                        return;
                    }
                    try {
                        this.f69479a.a(downloadInfo, baseException, i2);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j f69480a;

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
                    this.f69480a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.x
                public void a(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                        return;
                    }
                    try {
                        this.f69480a.a(jSONObject.toString());
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
                            return this.f69480a.a();
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
                            return this.f69480a.b();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ u f69481a;

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
                    this.f69481a = uVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.w
                public boolean a(v vVar) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, vVar)) == null) {
                        try {
                            return this.f69481a.a(g.a(vVar));
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ v f69482a;

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
                    this.f69482a = vVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.t
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.f69482a.a(list);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.t
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69482a.a() : invokeV.booleanValue;
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ak f69483a;

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
                    this.f69483a = akVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aj
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.f69483a.a(i2, i3);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ aj f69484a;

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
                    this.f69484a = ajVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ak
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        try {
                            this.f69484a.a(i2, i3);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f69485a;

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
                    this.f69485a = pVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.r
                public boolean a(long j, long j2, q qVar) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), qVar})) == null) {
                        try {
                            return this.f69485a.a(j, j2, g.a(qVar));
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f69487a;

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
                    this.f69487a = qVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.o
                public void a() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69487a.a();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ah f69488a;

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
                    this.f69488a = ahVar;
                }

                @Override // com.ss.android.socialbase.downloader.downloader.s
                public long a(int i2, int i3) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) {
                        try {
                            return this.f69488a.a(i2, i3);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h f69489a;

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
                    this.f69489a = hVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
                public boolean intercepte() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            return this.f69489a.a();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g f69491a;

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
                    this.f69491a = gVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
                public Uri getUriForFile(String str, String str2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) {
                        try {
                            return this.f69491a.a(str, str2);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i f69492a;

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
                    this.f69492a = iVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.s
                public void a(DownloadInfo downloadInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f69492a.i(downloadInfo);
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
                            this.f69492a.f(downloadInfo);
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
                            this.f69492a.a(downloadInfo, baseException);
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
                            this.f69492a.g(downloadInfo);
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
                            this.f69492a.h(downloadInfo);
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
                            this.f69492a.d(downloadInfo);
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
                            this.f69492a.a(downloadInfo);
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
                            this.f69492a.c(downloadInfo);
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
                            this.f69492a.b(downloadInfo, baseException);
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
                            this.f69492a.c(downloadInfo, baseException);
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
                            this.f69492a.b(downloadInfo);
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
                            this.f69492a.e(downloadInfo);
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
