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
/* loaded from: classes7.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public static ApollonDownloadManager a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final DownloadManager f52173b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<Long, a> f52174c;

    /* renamed from: d  reason: collision with root package name */
    public final String f52175d;

    /* renamed from: e  reason: collision with root package name */
    public Context f52176e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f52177f;

    /* renamed from: com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes7.dex */
    public final class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ApollonDownloadManager a;

        /* renamed from: b  reason: collision with root package name */
        public DownloadItemInfo f52178b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<DownloadListener> f52179c;

        /* renamed from: d  reason: collision with root package name */
        public long f52180d;

        /* renamed from: e  reason: collision with root package name */
        public long f52181e;

        /* renamed from: f  reason: collision with root package name */
        public int f52182f;

        /* renamed from: g  reason: collision with root package name */
        public Context f52183g;

        public /* synthetic */ a(ApollonDownloadManager apollonDownloadManager, Context context, long j2, AnonymousClass1 anonymousClass1) {
            this(apollonDownloadManager, context, j2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onChange(z);
                if (this.a.a(this.f52178b)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f52182f == this.f52178b.getDownloadState() && this.f52180d == this.f52178b.getCurrentBytes()) || this.f52181e == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.f52178b.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.f52178b;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f52180d) * 1000) / (currentTimeMillis - this.f52181e));
                    } else {
                        this.f52178b.setSpeed(0L);
                    }
                    this.f52180d = this.f52178b.getCurrentBytes();
                    this.f52182f = this.f52178b.getDownloadState();
                    this.f52181e = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f52179c.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f52179c.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.f52178b);
                        }
                    }
                    if ((this.f52178b.getDownloadState() & 24) != 0) {
                        this.a.unregisterObserver(this.f52183g, this.f52178b.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApollonDownloadManager apollonDownloadManager, Context context, long j2) {
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
            this.a = apollonDownloadManager;
            this.f52179c = new HashSet<>();
            this.f52180d = 0L;
            this.f52181e = 0L;
            this.f52182f = 1;
            this.f52178b = new DownloadItemInfo(j2);
            this.f52183g = context.getApplicationContext();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f52179c.remove(downloadListener);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                synchronized (this) {
                    this.f52179c.clear();
                }
            }
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.f52178b = downloadItemInfo;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f52179c.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52179c.isEmpty() : invokeV.booleanValue;
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
        this.f52174c = new HashMap<>();
        this.f52177f = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f52176e = applicationContext;
        this.f52173b = (DownloadManager) applicationContext.getSystemService("download");
        this.f52175d = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (a == null) {
                a = new ApollonDownloadManager(context);
            }
            return a;
        }
        return (ApollonDownloadManager) invokeL.objValue;
    }

    public void cancelDownload(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f52173b.remove(j2);
        }
    }

    public int createTask(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1;
            }
            if ((str3.startsWith("http://") || str3.startsWith("https://")) && (a2 = a(str2)) != null) {
                DownloadManager.Request a3 = a(str, a2, str3, z, z2, z3, str4);
                int hashCode = a3.hashCode();
                this.f52177f.put(hashCode, a3);
                return hashCode;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public long doDownload(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                return this.f52173b.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public DownloadItemInfo queryDownloadData(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 == -1) {
                return null;
            }
            DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j2);
            a(downloadItemInfo);
            return downloadItemInfo;
        }
        return (DownloadItemInfo) invokeJ.objValue;
    }

    public synchronized void registerObserver(Context context, long j2, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) {
            synchronized (this) {
                if (downloadListener == null || -1 == j2) {
                    return;
                }
                a aVar = this.f52174c.get(Long.valueOf(j2));
                if (aVar == null) {
                    aVar = new a(this, context, j2, null);
                    this.f52174c.put(Long.valueOf(j2), aVar);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, aVar);
                }
                aVar.a(downloadListener);
            }
        }
    }

    public void unregisterObserver(Context context, long j2, DownloadListener downloadListener) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) || j2 == -1 || (aVar = this.f52174c.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b(downloadListener);
        if (aVar.a()) {
            context.getContentResolver().unregisterContentObserver(aVar);
            this.f52174c.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            String str2 = str.startsWith(this.f52175d) ? null : this.f52175d;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f52175d.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str3) && (str3.startsWith("http://") || str3.startsWith("https://"))) {
                    return this.f52173b.enqueue(a(str, str2, str3, z, z2, z3, str4));
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
        this.f52174c = new HashMap<>();
        this.f52177f = new SparseArray<>();
        Context applicationContext = context.getApplicationContext();
        this.f52176e = applicationContext;
        this.f52173b = (DownloadManager) applicationContext.getSystemService("download");
        this.f52175d = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public void unregisterObserver(Context context, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, context, j2) == null) || j2 == -1 || (aVar = this.f52174c.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b();
        context.getContentResolver().unregisterContentObserver(aVar);
        this.f52174c.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    private DownloadManager.Request a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
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

    public void doDownload(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || -1 == i2) {
            return;
        }
        DownloadManager.Request request = this.f52177f.get(i2, null);
        if (request != null) {
            this.f52177f.delete(i2);
        }
        ContentResolver contentResolver = this.f52176e.getContentResolver();
        a remove = this.f52174c.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f52173b.enqueue(request);
        this.f52174c.put(Long.valueOf(enqueue), remove);
        remove.a(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (0 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(DownloadItemInfo downloadItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, downloadItemInfo)) == null) {
            if (-1 == downloadItemInfo.getDownloadId()) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = this.f52173b.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
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
}
