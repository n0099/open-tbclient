package com.dxmpay.apollon.downloadmanager;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes2.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static ApollonDownloadManager f53534f;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadManager a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Long, b> f53535b;

    /* renamed from: c  reason: collision with root package name */
    public final String f53536c;

    /* renamed from: d  reason: collision with root package name */
    public Context f53537d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f53538e;

    /* loaded from: classes2.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DownloadItemInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<DownloadListener> f53539b;

        /* renamed from: c  reason: collision with root package name */
        public long f53540c;

        /* renamed from: d  reason: collision with root package name */
        public long f53541d;

        /* renamed from: e  reason: collision with root package name */
        public int f53542e;

        /* renamed from: f  reason: collision with root package name */
        public Context f53543f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ApollonDownloadManager f53544g;

        public /* synthetic */ b(ApollonDownloadManager apollonDownloadManager, Context context, long j2, a aVar) {
            this(apollonDownloadManager, context, j2);
        }

        public void b(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.a = downloadItemInfo;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53539b.isEmpty() : invokeV.booleanValue;
        }

        public final synchronized boolean d(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f53539b.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public final synchronized void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f53539b.clear();
                }
            }
        }

        public final synchronized boolean g(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f53539b.remove(downloadListener);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                super.onChange(z);
                if (this.f53544g.d(this.a)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f53542e == this.a.getDownloadState() && this.f53540c == this.a.getCurrentBytes()) || this.f53541d == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.a.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.a;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f53540c) * 1000) / (currentTimeMillis - this.f53541d));
                    } else {
                        this.a.setSpeed(0L);
                    }
                    this.f53540c = this.a.getCurrentBytes();
                    this.f53542e = this.a.getDownloadState();
                    this.f53541d = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f53539b.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f53539b.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.a);
                        }
                    }
                    if ((this.a.getDownloadState() & 24) != 0) {
                        this.f53544g.unregisterObserver(this.f53543f, this.a.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApollonDownloadManager apollonDownloadManager, Context context, long j2) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apollonDownloadManager, context, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53544g = apollonDownloadManager;
            this.f53539b = new HashSet<>();
            this.f53540c = 0L;
            this.f53541d = 0L;
            this.f53542e = 1;
            this.a = new DownloadItemInfo(j2);
            this.f53543f = context.getApplicationContext();
        }
    }

    public ApollonDownloadManager(Context context) {
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
        this.f53535b = new HashMap<>();
        this.f53538e = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f53537d = applicationContext;
        this.a = (DownloadManager) applicationContext.getSystemService("download");
        this.f53536c = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f53534f == null) {
                f53534f = new ApollonDownloadManager(context);
            }
            return f53534f;
        }
        return (ApollonDownloadManager) invokeL.objValue;
    }

    public final DownloadManager.Request a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str3));
            if (z3) {
                request.setAllowedNetworkTypes(2);
            } else {
                request.setAllowedNetworkTypes(3);
            }
            request.setShowRunningNotification(z);
            request.setVisibleInDownloadsUi(z2);
            request.setDestinationInExternalPublicDir(str, str2 + str4);
            return request;
        }
        return (DownloadManager.Request) invokeCommon.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = str.startsWith(this.f53536c) ? null : this.f53536c;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f53536c.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void cancelDownload(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.a.remove(j2);
        }
    }

    public int createTask(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1;
            }
            if ((str3.startsWith("http://") || str3.startsWith("https://")) && (b2 = b(str2)) != null) {
                DownloadManager.Request a2 = a(str, b2, str3, z, z2, z3, str4);
                int hashCode = a2.hashCode();
                this.f53538e.put(hashCode, a2);
                return hashCode;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (0 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(DownloadItemInfo downloadItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadItemInfo)) == null) {
            if (-1 == downloadItemInfo.getDownloadId()) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = this.a.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
            } catch (Exception unused) {
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst()) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                int columnIndex = cursor.getColumnIndex("status");
                long j2 = cursor.getLong(columnIndexOrThrow);
                long j3 = cursor.getLong(columnIndexOrThrow2);
                int i2 = cursor.getInt(columnIndex);
                downloadItemInfo.setTotalBytes(j2);
                downloadItemInfo.setCurrentBytes(j3);
                downloadItemInfo.setDownloadState(i2);
                if (cursor != null) {
                    cursor.close();
                }
                return true;
            }
            downloadItemInfo.setCurrentBytes(0L);
            downloadItemInfo.setTotalBytes(-1L);
            downloadItemInfo.setDownloadState(1);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public long doDownload(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                return this.a.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public DownloadItemInfo queryDownloadData(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
            if (j2 == -1) {
                return null;
            }
            DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j2);
            d(downloadItemInfo);
            return downloadItemInfo;
        }
        return (DownloadItemInfo) invokeJ.objValue;
    }

    public synchronized void registerObserver(Context context, long j2, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) {
            synchronized (this) {
                if (downloadListener == null || -1 == j2) {
                    return;
                }
                b bVar = this.f53535b.get(Long.valueOf(j2));
                if (bVar == null) {
                    bVar = new b(this, context, j2, null);
                    this.f53535b.put(Long.valueOf(j2), bVar);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, bVar);
                }
                bVar.d(downloadListener);
            }
        }
    }

    public void unregisterObserver(Context context, long j2, DownloadListener downloadListener) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) || j2 == -1 || (bVar = this.f53535b.get(Long.valueOf(j2))) == null) {
            return;
        }
        bVar.g(downloadListener);
        if (bVar.c()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f53535b.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }

    public synchronized long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str3) && (str3.startsWith("http://") || str3.startsWith("https://"))) {
                    return this.a.enqueue(a(str, str2, str3, z, z2, z3, str4));
                }
                return -1L;
            }
        }
        return invokeCommon.longValue;
    }

    public ApollonDownloadManager(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53535b = new HashMap<>();
        this.f53538e = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f53537d = applicationContext;
        this.a = (DownloadManager) applicationContext.getSystemService("download");
        this.f53536c = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public void unregisterObserver(Context context, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048586, this, context, j2) == null) || j2 == -1 || (bVar = this.f53535b.get(Long.valueOf(j2))) == null) {
            return;
        }
        bVar.f();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f53535b.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    public void doDownload(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || -1 == i2) {
            return;
        }
        DownloadManager.Request request = this.f53538e.get(i2, null);
        if (request != null) {
            this.f53538e.delete(i2);
        }
        ContentResolver contentResolver = this.f53537d.getContentResolver();
        b remove = this.f53535b.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.a.enqueue(request);
        this.f53535b.put(Long.valueOf(enqueue), remove);
        remove.b(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }
}
