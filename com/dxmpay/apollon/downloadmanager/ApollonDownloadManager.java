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
/* loaded from: classes11.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static ApollonDownloadManager f62086f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadManager f62087a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Long, b> f62088b;

    /* renamed from: c  reason: collision with root package name */
    public final String f62089c;

    /* renamed from: d  reason: collision with root package name */
    public Context f62090d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f62091e;

    /* loaded from: classes11.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public DownloadItemInfo f62092a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<DownloadListener> f62093b;

        /* renamed from: c  reason: collision with root package name */
        public long f62094c;

        /* renamed from: d  reason: collision with root package name */
        public long f62095d;

        /* renamed from: e  reason: collision with root package name */
        public int f62096e;

        /* renamed from: f  reason: collision with root package name */
        public Context f62097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ApollonDownloadManager f62098g;

        public /* synthetic */ b(ApollonDownloadManager apollonDownloadManager, Context context, long j, a aVar) {
            this(apollonDownloadManager, context, j);
        }

        public void b(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.f62092a = downloadItemInfo;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62093b.isEmpty() : invokeV.booleanValue;
        }

        public final synchronized boolean d(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f62093b.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public final synchronized void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f62093b.clear();
                }
            }
        }

        public final synchronized boolean g(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f62093b.remove(downloadListener);
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
                if (this.f62098g.d(this.f62092a)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f62096e == this.f62092a.getDownloadState() && this.f62094c == this.f62092a.getCurrentBytes()) || this.f62095d == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.f62092a.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.f62092a;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f62094c) * 1000) / (currentTimeMillis - this.f62095d));
                    } else {
                        this.f62092a.setSpeed(0L);
                    }
                    this.f62094c = this.f62092a.getCurrentBytes();
                    this.f62096e = this.f62092a.getDownloadState();
                    this.f62095d = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f62093b.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f62093b.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.f62092a);
                        }
                    }
                    if ((this.f62092a.getDownloadState() & 24) != 0) {
                        this.f62098g.unregisterObserver(this.f62097f, this.f62092a.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApollonDownloadManager apollonDownloadManager, Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apollonDownloadManager, context, Long.valueOf(j)};
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
            this.f62098g = apollonDownloadManager;
            this.f62093b = new HashSet<>();
            this.f62094c = 0L;
            this.f62095d = 0L;
            this.f62096e = 1;
            this.f62092a = new DownloadItemInfo(j);
            this.f62097f = context.getApplicationContext();
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
        this.f62088b = new HashMap<>();
        this.f62091e = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f62090d = applicationContext;
        this.f62087a = (DownloadManager) applicationContext.getSystemService("download");
        this.f62089c = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f62086f == null) {
                f62086f = new ApollonDownloadManager(context);
            }
            return f62086f;
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
            String str2 = str.startsWith(this.f62089c) ? null : this.f62089c;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f62089c.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void cancelDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f62087a.remove(j);
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
                this.f62091e.put(hashCode, a2);
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
                cursor = this.f62087a.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
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
                long j = cursor.getLong(columnIndexOrThrow);
                long j2 = cursor.getLong(columnIndexOrThrow2);
                int i2 = cursor.getInt(columnIndex);
                downloadItemInfo.setTotalBytes(j);
                downloadItemInfo.setCurrentBytes(j2);
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
                return this.f62087a.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public DownloadItemInfo queryDownloadData(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            if (j == -1) {
                return null;
            }
            DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j);
            d(downloadItemInfo);
            return downloadItemInfo;
        }
        return (DownloadItemInfo) invokeJ.objValue;
    }

    public synchronized void registerObserver(Context context, long j, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Long.valueOf(j), downloadListener}) == null) {
            synchronized (this) {
                if (downloadListener == null || -1 == j) {
                    return;
                }
                b bVar = this.f62088b.get(Long.valueOf(j));
                if (bVar == null) {
                    bVar = new b(this, context, j, null);
                    this.f62088b.put(Long.valueOf(j), bVar);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, bVar);
                }
                bVar.d(downloadListener);
            }
        }
    }

    public void unregisterObserver(Context context, long j, DownloadListener downloadListener) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), downloadListener}) == null) || j == -1 || (bVar = this.f62088b.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.g(downloadListener);
        if (bVar.c()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f62088b.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    public synchronized long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str3) && (str3.startsWith("http://") || str3.startsWith("https://"))) {
                    return this.f62087a.enqueue(a(str, str2, str3, z, z2, z3, str4));
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
        this.f62088b = new HashMap<>();
        this.f62091e = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f62090d = applicationContext;
        this.f62087a = (DownloadManager) applicationContext.getSystemService("download");
        this.f62089c = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public void unregisterObserver(Context context, long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048586, this, context, j) == null) || j == -1 || (bVar = this.f62088b.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.f();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f62088b.remove(Uri.parse("content://downloads/my_downloads/" + j));
    }

    public void doDownload(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || -1 == i2) {
            return;
        }
        DownloadManager.Request request = this.f62091e.get(i2, null);
        if (request != null) {
            this.f62091e.delete(i2);
        }
        ContentResolver contentResolver = this.f62090d.getContentResolver();
        b remove = this.f62088b.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f62087a.enqueue(request);
        this.f62088b.put(Long.valueOf(enqueue), remove);
        remove.b(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }
}
