package com.bytedance.sdk.openadsdk.n.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.openadsdk.n.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes9.dex */
public class c extends com.bytedance.sdk.openadsdk.n.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final File f68149a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap<String, File> f68150b;

    /* renamed from: c  reason: collision with root package name */
    public final ReentrantReadWriteLock f68151c;

    /* renamed from: d  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f68152d;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f68153e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<a> f68154f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f68155g;

    /* renamed from: h  reason: collision with root package name */
    public volatile float f68156h;

    /* renamed from: i  reason: collision with root package name */
    public final b f68157i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f68158j;
    public final Handler k;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, Integer> f68167a;

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
                    return;
                }
            }
            this.f68167a = new HashMap();
        }

        public synchronized void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this) {
                    if (!TextUtils.isEmpty(str)) {
                        Integer num = this.f68167a.get(str);
                        if (num == null) {
                            this.f68167a.put(str, 1);
                        } else {
                            this.f68167a.put(str, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            }
        }

        public synchronized void b(String str) {
            Integer num;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (!TextUtils.isEmpty(str) && (num = this.f68167a.get(str)) != null) {
                        if (num.intValue() == 1) {
                            this.f68167a.remove(str);
                        } else {
                            this.f68167a.put(str, Integer.valueOf(num.intValue() - 1));
                        }
                    }
                }
            }
        }

        public synchronized boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                synchronized (this) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return this.f68167a.containsKey(str);
                }
            }
            return invokeL.booleanValue;
        }
    }

    public c(File file) throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68150b = new LinkedHashMap<>(0, 0.75f, true);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f68151c = reentrantReadWriteLock;
        this.f68152d = reentrantReadWriteLock.readLock();
        this.f68153e = this.f68151c.writeLock();
        this.f68154f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f68155g = 104857600L;
        this.f68156h = 0.5f;
        this.f68157i = new b();
        this.f68158j = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.n.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f68159a;

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
                this.f68159a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    e.a(new g(this, "cleanupCmd", 1) { // from class: com.bytedance.sdk.openadsdk.n.a.c.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f68160a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, r9, Integer.valueOf(r10)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    Object[] objArr3 = newInitContext2.callArgs;
                                    super((String) objArr3[0], ((Integer) objArr3[1]).intValue());
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f68160a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                c cVar = this.f68160a.f68159a;
                                cVar.b(cVar.f68155g);
                            }
                        }
                    });
                }
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f68149a = file;
            e.a(new g(this, "DiskLruCache", 5) { // from class: com.bytedance.sdk.openadsdk.n.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f68161a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            Object[] objArr3 = newInitContext2.callArgs;
                            super((String) objArr3[0], ((Integer) objArr3[1]).intValue());
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f68161a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68161a.b();
                    }
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  " + str);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.k.removeCallbacks(this.f68158j);
            this.k.postDelayed(this.f68158j, 10000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.n.a.a
    public File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.f68152d.tryLock()) {
                File file = this.f68150b.get(str);
                this.f68152d.unlock();
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f68153e.lock();
            try {
                File[] listFiles = this.f68149a.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    HashMap hashMap = new HashMap(listFiles.length);
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            arrayList.add(file);
                            hashMap.put(file, Long.valueOf(file.lastModified()));
                        }
                    }
                    Collections.sort(arrayList, new Comparator<File>(this, hashMap) { // from class: com.bytedance.sdk.openadsdk.n.a.c.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ HashMap f68162a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f68163b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, hashMap};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68163b = this;
                            this.f68162a = hashMap;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(File file2, File file3) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, file3)) == null) {
                                int i2 = ((((Long) this.f68162a.get(file2)).longValue() - ((Long) this.f68162a.get(file3)).longValue()) > 0L ? 1 : ((((Long) this.f68162a.get(file2)).longValue() - ((Long) this.f68162a.get(file3)).longValue()) == 0L ? 0 : -1));
                                if (i2 < 0) {
                                    return -1;
                                }
                                return i2 > 0 ? 1 : 0;
                            }
                            return invokeLL.intValue;
                        }
                    });
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        File file2 = (File) it.next();
                        this.f68150b.put(a(file2), file2);
                    }
                }
                this.f68153e.unlock();
                c();
            } catch (Throwable th) {
                this.f68153e.unlock();
                throw th;
            }
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f68154f.add(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.n.a.a
    public File c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f68152d.lock();
            File file = this.f68150b.get(str);
            this.f68152d.unlock();
            if (file != null) {
                return file;
            }
            File file2 = new File(this.f68149a, str);
            this.f68153e.lock();
            this.f68150b.put(str, file2);
            this.f68153e.unlock();
            for (a aVar : this.f68154f) {
                aVar.a(str);
            }
            c();
            return file2;
        }
        return (File) invokeL.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f68155g = j2;
            c();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.c().d();
            Context a2 = com.bytedance.sdk.openadsdk.n.e.a();
            if (a2 != null) {
                com.bytedance.sdk.openadsdk.n.b.c.a(a2).a(0);
            }
            this.k.removeCallbacks(this.f68158j);
            e.a(new g(this, "clear", 1) { // from class: com.bytedance.sdk.openadsdk.n.a.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f68164a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68164a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68164a.b(0L);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.n.a.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68157i.a(str);
    }

    private String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, file)) == null) ? file.getName() : (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.a.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68157i.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8 A[LOOP:3: B:43:0x00e2->B:45:0x00e8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            HashSet hashSet = new HashSet();
            this.f68153e.lock();
            long j3 = 0;
            HashSet hashSet2 = null;
            try {
                for (Map.Entry<String, File> entry : this.f68150b.entrySet()) {
                    j3 += entry.getValue().length();
                }
            } catch (Throwable th) {
                th = th;
            }
            if (j3 <= j2) {
                return;
            }
            long j4 = ((float) j2) * this.f68156h;
            HashSet hashSet3 = new HashSet();
            try {
                for (Map.Entry<String, File> entry2 : this.f68150b.entrySet()) {
                    File value = entry2.getValue();
                    if (value != null && value.exists()) {
                        if (!this.f68157i.c(a(value))) {
                            long length = value.length();
                            File file = new File(value.getAbsolutePath() + "-tmp");
                            if (value.renameTo(file)) {
                                hashSet.add(file);
                                j3 -= length;
                                hashSet3.add(entry2.getKey());
                            }
                        }
                    } else {
                        hashSet3.add(entry2.getKey());
                    }
                    if (j3 <= j4) {
                        break;
                    }
                }
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    this.f68150b.remove((String) it.next());
                }
            } catch (Throwable th2) {
                th = th2;
                hashSet2 = hashSet3;
                try {
                    th.printStackTrace();
                    this.f68153e.unlock();
                    hashSet3 = hashSet2;
                    while (r13.hasNext()) {
                    }
                    e.a(new g(this, "trimSize", 1, hashSet) { // from class: com.bytedance.sdk.openadsdk.n.a.c.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ HashSet f68165a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f68166b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, Integer.valueOf(r10), hashSet};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68166b = this;
                            this.f68165a = hashSet;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Iterator it2 = this.f68165a.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        ((File) it2.next()).delete();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    });
                } finally {
                    this.f68153e.unlock();
                }
            }
            for (a aVar : this.f68154f) {
                aVar.a(hashSet3);
            }
            e.a(new g(this, "trimSize", 1, hashSet) { // from class: com.bytedance.sdk.openadsdk.n.a.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HashSet f68165a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f68166b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, r9, Integer.valueOf(r10), hashSet};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68166b = this;
                    this.f68165a = hashSet;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator it2 = this.f68165a.iterator();
                        while (it2.hasNext()) {
                            try {
                                ((File) it2.next()).delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            });
        }
    }
}
