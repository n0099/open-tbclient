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
/* loaded from: classes9.dex */
public class Downloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f69735a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f69736b;

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f69737c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f69738d;

    /* renamed from: e  reason: collision with root package name */
    public ContentResolver f69739e;

    /* renamed from: f  reason: collision with root package name */
    public final String f69740f;

    /* loaded from: classes9.dex */
    public interface DownloaderListener {
        void onProgress(String str, int i2, long j2, long j3);
    }

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Downloader f69741a;

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
            this.f69741a = downloader;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && 1 == message.what) {
                c cVar = (c) message.obj;
                if (this.f69741a.f69735a == null) {
                    this.f69741a.c(cVar.f69747b, cVar.f69746a);
                } else {
                    this.f69741a.f(cVar.f69746a, cVar.f69747b, cVar.f69748c);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f69742a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f69743b;

        /* renamed from: c  reason: collision with root package name */
        public String f69744c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Downloader f69745d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Downloader downloader, Handler handler, String str, long j2, DownloaderListener downloaderListener) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader, handler, str, Long.valueOf(j2), downloaderListener};
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
            this.f69745d = downloader;
            this.f69744c = str;
            this.f69742a = j2;
            this.f69743b = downloaderListener;
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
        public final void a(long j2) {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                Cursor cursor2 = null;
                try {
                    try {
                        cursor = this.f69745d.f69735a.query(new DownloadManager.Query().setFilterById(j2));
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = j2;
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
                        this.f69743b = null;
                        this.f69745d.f69739e.unregisterContentObserver(this);
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                    if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                        int columnIndex = cursor.getColumnIndex("status");
                        long j3 = cursor.getLong(columnIndexOrThrow);
                        long j4 = cursor.getLong(columnIndexOrThrow2);
                        int i2 = cursor.getInt(columnIndex);
                        if (this.f69743b != null) {
                            this.f69743b.onProgress(this.f69744c, i2, j3, j4);
                        }
                        if ((i2 & 24) != 0) {
                            this.f69743b = null;
                            this.f69745d.f69739e.unregisterContentObserver(this);
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
                a(this.f69742a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69746a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f69747b;

        /* renamed from: c  reason: collision with root package name */
        public String f69748c;

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

    /* loaded from: classes9.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Downloader f69749a;
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
            f69749a = new Downloader(null);
        }
    }

    public /* synthetic */ Downloader(a aVar) {
        this();
    }

    public static Downloader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f69749a : (Downloader) invokeV.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Matcher matcher = this.f69736b.matcher(str);
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
            if (str != null ? this.f69737c.matcher(str).matches() : false) {
                c cVar = new c(this, null);
                cVar.f69746a = str;
                cVar.f69747b = downloaderListener;
                cVar.f69748c = str2;
                this.f69738d.obtainMessage(1, cVar).sendToTarget();
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
                long enqueue = this.f69735a.enqueue(request);
                b bVar = new b(this, this.f69738d, str, enqueue, downloaderListener);
                this.f69739e.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, bVar);
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
            String str2 = str.startsWith(this.f69740f) ? null : this.f69740f;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f69740f.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f69735a == null && context != null) {
            this.f69735a = (DownloadManager) context.getSystemService("download");
            this.f69739e = context.getContentResolver();
            HandlerThread handlerThread = new HandlerThread("downloader");
            handlerThread.start();
            this.f69738d = new a(this, handlerThread.getLooper());
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
        this.f69736b = Pattern.compile(".*\\/(.*)");
        this.f69737c = Pattern.compile("^(https?)://.*");
        this.f69740f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }
}
