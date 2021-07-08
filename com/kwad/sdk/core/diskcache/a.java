package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.f;
import com.kwad.sdk.core.i.b;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f34225g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Future f34226a;

    /* renamed from: b  reason: collision with root package name */
    public File f34227b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f34228c;

    /* renamed from: d  reason: collision with root package name */
    public PackageManager f34229d;

    /* renamed from: e  reason: collision with root package name */
    public final f f34230e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f34231f;

    /* renamed from: h  reason: collision with root package name */
    public final Callable<PackageInfo> f34232h;

    public a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34228c = b.k();
        this.f34231f = false;
        this.f34232h = new Callable<PackageInfo>(this) { // from class: com.kwad.sdk.core.diskcache.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34233a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34233a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public PackageInfo call() {
                InterceptResult invokeV;
                PackageInfo a2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (a.class) {
                        if (this.f34233a.f34227b != null && this.f34233a.f34227b.exists()) {
                            for (File file : this.f34233a.b(this.f34233a.f34227b)) {
                                if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.a().a(file.getAbsolutePath()) != null && (a2 = this.f34233a.a(file)) != null) {
                                    this.f34233a.f34230e.a(file);
                                    return a2;
                                }
                            }
                            return null;
                        }
                        return null;
                    }
                }
                return (PackageInfo) invokeV.objValue;
            }
        };
        this.f34230e = new com.kwad.sdk.core.download.c.a(context);
        try {
            this.f34227b = al.c(context);
            this.f34229d = context.getPackageManager();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.f34231f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
            if (file != null && file.exists()) {
                try {
                    if (file.exists() & (!file.isDirectory())) {
                        PackageInfo packageArchiveInfo = this.f34229d.getPackageArchiveInfo(file.getPath(), 65);
                        if (this.f34229d.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                            return null;
                        }
                        return packageArchiveInfo;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            return null;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static a a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f34225g == null) {
                synchronized (a.class) {
                    if (f34225g == null) {
                        f34225g = new a(context);
                    }
                }
            }
            return f34225g;
        }
        return (a) invokeL.objValue;
    }

    private void a(List<File> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
            Collections.sort(list, new Comparator<File>(this) { // from class: com.kwad.sdk.core.diskcache.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34234a;

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
                    this.f34234a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, file2)) == null) {
                        if (file.lastModified() >= file2.lastModified()) {
                            return file.lastModified() == file2.lastModified() ? 0 : 1;
                        }
                        return -1;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> b(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, file)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            arrayList.addAll(Arrays.asList(listFiles));
            a(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void a() {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f34231f && (file = this.f34227b) != null && file.exists()) {
            Future future = this.f34226a;
            if (future == null || future.isDone()) {
                this.f34226a = this.f34228c.submit(this.f34232h);
            }
        }
    }
}
