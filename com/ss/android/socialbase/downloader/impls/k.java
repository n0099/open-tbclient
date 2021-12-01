package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<DownloadInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f61945b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f61946c;

    public k() {
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
        this.a = new SparseArray<>();
        this.f61945b = new SparseArray<>();
        this.f61946c = new SparseArray<>();
    }

    public SparseArray<DownloadInfo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (SparseArray) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i2) {
        InterceptResult invokeI;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this) {
                try {
                    downloadInfo = this.a.get(i2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    downloadInfo = null;
                }
            }
            return downloadInfo;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, list) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (this.a.size() == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                        arrayList.add(downloadInfo);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (this.a.size() == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                        arrayList.add(downloadInfo);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            synchronized (this) {
                this.a.remove(i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f61945b : (SparseArray) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setStatus(2);
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setStatus(5);
                b2.setFirstDownload(false);
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setStatus(1);
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setStatus(-7);
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        InterceptResult invokeI;
        Map<Long, com.ss.android.socialbase.downloader.f.i> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            synchronized (this) {
                map = this.f61946c.get(i2);
            }
            return map;
        }
        return (Map) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            synchronized (this) {
                this.f61946c.remove(i2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            synchronized (this) {
                Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f61946c.get(i2);
                if (map != null && !map.isEmpty()) {
                    return new ArrayList(map.values());
                }
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                try {
                    int size = this.a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        DownloadInfo valueAt = this.a.valueAt(i2);
                        if (str != null && str.equals(valueAt.getUrl())) {
                            arrayList.add(valueAt);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            e(i2);
            d(i2);
            m(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (this.a.size() == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                        arrayList.add(downloadInfo);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            int k2 = bVar.k();
            List<com.ss.android.socialbase.downloader.model.b> list = this.f61945b.get(k2);
            if (list == null) {
                list = new ArrayList<>();
                this.f61945b.put(k2, list);
            }
            list.add(bVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        r0.b(r7);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
                if (c2 == null) {
                    return;
                }
                Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.ss.android.socialbase.downloader.model.b next = it.next();
                    if (next != null && next.s() == i3) {
                        break;
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        List<com.ss.android.socialbase.downloader.model.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            synchronized (this) {
                list = this.f61945b.get(i2);
            }
            return list;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            synchronized (this) {
                this.f61945b.remove(i2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this) {
                this.a.clear();
                this.f61945b.clear();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setCurBytes(j2, false);
                b2.setStatus(-2);
            }
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.a.size() == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.a.size());
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    DownloadInfo valueAt = this.a.valueAt(i2);
                    if (valueAt != null) {
                        arrayList.add(valueAt);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setCurBytes(j2, false);
                b2.setStatus(-3);
                b2.setFirstDownload(false);
                b2.setFirstSuccess(false);
            }
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0.g() != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
        r5 = r0.g().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
        if (r5.hasNext() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
        r7 = r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        if (r7 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
        if (r7.s() != r6) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        r7.b(r8);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
                if (c2 == null) {
                    return;
                }
                Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.ss.android.socialbase.downloader.model.b next = it.next();
                    if (next != null && next.s() == i4 && !next.f()) {
                        break;
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setCurBytes(j2, false);
                b2.setStatus(-1);
                b2.setFirstDownload(false);
            }
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadInfo) == null) {
            a(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            synchronized (this) {
                b2 = b(i2);
                if (b2 != null) {
                    b2.setChunkCount(i3);
                }
            }
            return b2;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadInfo)) == null) {
            synchronized (this) {
                boolean z = true;
                if (downloadInfo == null) {
                    return true;
                }
                if (this.a.get(downloadInfo.getId()) == null) {
                    z = false;
                }
                this.a.put(downloadInfo.getId(), downloadInfo);
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setTotalBytes(j2);
                b2.seteTag(str);
                if (TextUtils.isEmpty(b2.getName()) && !TextUtils.isEmpty(str2)) {
                    b2.setName(str2);
                }
                b2.setStatus(3);
            }
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = b(i2);
            if (b2 != null) {
                b2.setCurBytes(j2, false);
                if (b2.getStatus() != -3 && b2.getStatus() != -2 && !DownloadStatus.isFailedStatus(b2.getStatus()) && b2.getStatus() != -4) {
                    b2.setStatus(4);
                }
            }
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
            synchronized (this) {
                if (list == null) {
                    return;
                }
                d(i2);
                for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.f()) {
                            for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.g()) {
                                a(bVar2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, map)) == null) {
            synchronized (this) {
                this.f61946c.put(i2, map);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
