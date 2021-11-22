package com.dxmpay.wallet.utils;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class Downloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f63586a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f63587b;

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f63588c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f63589d;

    /* renamed from: e  reason: collision with root package name */
    public ContentResolver f63590e;

    /* renamed from: f  reason: collision with root package name */
    public final String f63591f;

    /* loaded from: classes11.dex */
    public interface DownloaderListener {
        void onProgress(String str, int i2, long j, long j2);
    }

    /* loaded from: classes11.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Downloader f63592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Downloader downloader, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63592a = downloader;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && 1 == message.what) {
                c cVar = (c) message.obj;
                if (this.f63592a.f63586a == null) {
                    this.f63592a.c(cVar.f63598b, cVar.f63597a);
                } else {
                    this.f63592a.f(cVar.f63597a, cVar.f63598b, cVar.f63599c);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f63593a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f63594b;

        /* renamed from: c  reason: collision with root package name */
        public String f63595c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Downloader f63596d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Downloader downloader, Handler handler, String str, long j, DownloaderListener downloaderListener) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader, handler, str, Long.valueOf(j), downloaderListener};
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
            this.f63596d = downloader;
            this.f63595c = str;
            this.f63593a = j;
            this.f63594b = downloaderListener;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(long j) {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                Cursor cursor2 = null;
                try {
                    try {
                        cursor = this.f63596d.f63586a.query(new DownloadManager.Query().setFilterById(j));
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = j;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
                if (cursor != null) {
                    try {
                    } catch (Exception unused2) {
                        this.f63594b = null;
                        this.f63596d.f63590e.unregisterContentObserver(this);
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                    if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                        int columnIndex = cursor.getColumnIndex("status");
                        long j2 = cursor.getLong(columnIndexOrThrow);
                        long j3 = cursor.getLong(columnIndexOrThrow2);
                        int i2 = cursor.getInt(columnIndex);
                        if (this.f63594b != null) {
                            this.f63594b.onProgress(this.f63595c, i2, j2, j3);
                        }
                        if ((i2 & 24) != 0) {
                            this.f63594b = null;
                            this.f63596d.f63590e.unregisterContentObserver(this);
                        }
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                }
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                a(this.f63593a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63597a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f63598b;

        /* renamed from: c  reason: collision with root package name */
        public String f63599c;

        public c(Downloader downloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(Downloader downloader, a aVar) {
            this(downloader);
        }
    }

    /* loaded from: classes11.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Downloader f63600a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349840024, "Lcom/dxmpay/wallet/utils/Downloader$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1349840024, "Lcom/dxmpay/wallet/utils/Downloader$d;");
                    return;
                }
            }
            f63600a = new Downloader(null);
        }
    }

    public /* synthetic */ Downloader(a aVar) {
        this();
    }

    public static Downloader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f63600a : (Downloader) invokeV.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Matcher matcher = this.f63587b.matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void c(DownloaderListener downloaderListener, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloaderListener, str) == null) || downloaderListener == null) {
            return;
        }
        downloaderListener.onProgress(str, 16, 0L, 0L);
    }

    public void download(String str, String str2, DownloaderListener downloaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, downloaderListener) == null) {
            if (str != null ? this.f63588c.matcher(str).matches() : false) {
                c cVar = new c(this, null);
                cVar.f63597a = str;
                cVar.f63598b = downloaderListener;
                cVar.f63599c = str2;
                this.f63589d.obtainMessage(1, cVar).sendToTarget();
                return;
            }
            c(downloaderListener, str);
        }
    }

    public final void f(String str, DownloaderListener downloaderListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, downloaderListener, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = b(str);
            }
            if (str2 == null) {
                c(downloaderListener, str);
                return;
            }
            String h2 = h(str2);
            if (h2 == null) {
                c(downloaderListener, str);
                return;
            }
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setNotificationVisibility(2);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, h2);
                request.setAllowedNetworkTypes(2);
                long enqueue = this.f63586a.enqueue(request);
                b bVar = new b(this, this.f63589d, str, enqueue, downloaderListener);
                this.f63590e.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, bVar);
            } catch (Exception e2) {
                c(downloaderListener, str);
                e2.printStackTrace();
            }
        }
    }

    public final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String str2 = str.startsWith(this.f63591f) ? null : this.f63591f;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f63591f.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f63586a == null && context != null) {
            this.f63586a = (DownloadManager) context.getSystemService("download");
            this.f63590e = context.getContentResolver();
            HandlerThread handlerThread = new HandlerThread("downloader");
            handlerThread.start();
            this.f63589d = new a(this, handlerThread.getLooper());
        }
    }

    public Downloader() {
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
        this.f63587b = Pattern.compile(".*\\/(.*)");
        this.f63588c = Pattern.compile("^(https?)://.*");
        this.f63591f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }
}
