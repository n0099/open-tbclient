package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.net.http.Headers;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DownloadInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<DownloadInfo> CREATOR;
    public static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    public static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    public static final int RESERVE_STATUS_NEVER = 0;
    public static final int RESERVE_STATUS_NOW = 2;
    public static final int RESERVE_STATUS_ONCE = 1;
    public static final String TAG = "DownloadInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean addListenerToSameTask;
    public AtomicLong allConnectTime;
    public int appVersionCode;
    public com.ss.android.socialbase.downloader.constants.a asyncHandleStatus;
    public boolean autoResumed;
    public int backUpUrlRetryCount;
    public boolean backUpUrlUsed;
    public List<String> backUpUrls;
    public String backUpUrlsStr;
    public int bindValueCount;
    public com.ss.android.socialbase.downloader.constants.b byteInvalidRetryStatus;
    public int chunkCount;
    public boolean chunkDowngradeRetryUsed;
    public int curBackUpUrlIndex;
    public AtomicLong curBytes;
    public int curRetryTime;
    public JSONObject dbJsonData;
    public String dbJsonDataString;
    public boolean deleteCacheIfCheckFailed;
    public boolean distinctDirectory;
    public long downloadTime;
    public String eTag;
    public EnqueueType enqueueType;
    public StringBuffer errorBytesLog;
    public boolean expiredRedownload;
    public String extra;
    public List<c> extraHeaders;
    public int[] extraMonitorStatus;
    public BaseException failedException;
    public String filePackageName;
    public List<String> forbiddenBackupUrls;
    public boolean force;
    public boolean forceIgnoreRecommendSize;
    public boolean headConnectionAvailable;
    public String headConnectionException;
    public int httpStatusCode;
    public String httpStatusMessage;
    public boolean httpsToHttpRetryUsed;
    public String iconUrl;
    public int id;
    public boolean ignoreDataVerify;
    public Boolean isAutoInstallWithoutNotification;
    public boolean isFirstDownload;
    public boolean isFirstSuccess;
    public boolean isForbiddenRetryed;
    public volatile boolean isSaveTempFile;
    public AtomicLong lastNotifyProgressTime;
    public boolean mDownloadFromReserveWifi;
    public int maxBytes;
    public int maxProgressCount;
    public String md5;
    public String mimeType;
    public int minProgressTimeMsInterval;
    public String monitorScene;
    public String name;
    public boolean needChunkDowngradeRetry;
    public boolean needDefaultHttpServiceBackUp;
    public boolean needHttpsToHttpRetry;
    public boolean needIndependentProcess;
    public boolean needPostProgress;
    public boolean needRetryDelay;
    public boolean needReuseChunkRunnable;
    public boolean needReuseFirstConnection;
    public boolean needSDKMonitor;
    public String networkQuality;
    public int notificationVisibility;
    public boolean onlyWifi;
    public boolean openLimitSpeed;
    public String[] outIp;
    public int[] outSize;
    public SoftReference<PackageInfo> packageInfoRef;
    public String packageName;
    public long realDownloadTime;
    public long realStartDownloadTime;
    public int retryCount;
    public g retryDelayStatus;
    public String retryDelayTimeArray;
    @Deprecated
    public int retryScheduleMinutes;
    public String savePath;
    public boolean showNotification;
    public boolean showNotificationForAutoResumed;
    public boolean showNotificationForNetworkResumed;
    public JSONObject spData;
    public long startDownloadTime;
    public AtomicInteger status;
    public int statusAtDbInit;
    public boolean successByCache;
    public boolean supportPartial;
    public String taskId;
    public ConcurrentHashMap<String, Object> tempCacheData;
    public volatile List<ai> tempFileSaveCompleteCallbacks;
    public String tempPath;
    public long throttleNetSpeed;
    public String title;
    public long totalBytes;
    public long ttnetProtectTimeout;
    public String url;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String A;
        public String B;
        public long C;
        public boolean D;
        public String E;
        public boolean F;
        public boolean G;
        public EnqueueType H;
        public boolean I;
        public boolean J;
        public boolean K;
        public String L;
        public long M;
        public boolean N;
        public boolean O;
        public JSONObject P;
        public boolean Q;
        public String R;
        public int[] S;
        public int T;
        public boolean U;
        public boolean V;
        public long W;
        public boolean X;

        /* renamed from: a  reason: collision with root package name */
        public String f70528a;

        /* renamed from: b  reason: collision with root package name */
        public String f70529b;

        /* renamed from: c  reason: collision with root package name */
        public String f70530c;

        /* renamed from: d  reason: collision with root package name */
        public String f70531d;

        /* renamed from: e  reason: collision with root package name */
        public String f70532e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70533f;

        /* renamed from: g  reason: collision with root package name */
        public String f70534g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f70535h;

        /* renamed from: i  reason: collision with root package name */
        public int f70536i;
        public String[] j;
        public int[] k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public int p;
        public int q;
        public List<String> r;
        public boolean s;
        public boolean t;
        public String u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        public a() {
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
            this.o = true;
            this.t = true;
            this.y = true;
            this.H = EnqueueType.ENQUEUE_NONE;
            this.Q = true;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f70528a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f70529b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f70530c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.f70531d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
                this.f70532e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.f70534g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                this.u = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
                this.y = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                this.z = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.D = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.F = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
                this.G = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
                this.I = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a n(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
                this.J = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                this.K = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
                this.O = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                this.Q = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a r(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
                this.N = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a s(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048623, this, z)) == null) {
                this.U = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a t(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048624, this, z)) == null) {
                this.V = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a u(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
                this.X = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
                this.t = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f70533f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.m = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                this.p = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                this.q = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
                this.w = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
                this.x = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                this.A = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                this.B = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                this.E = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                this.R = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
                this.L = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(List<c> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
                this.f70535h = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
                this.v = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                this.s = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
                this.T = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f70536i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
                this.r = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
                this.W = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr)) == null) {
                this.j = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, iArr)) == null) {
                this.S = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.o = true;
            this.t = true;
            this.y = true;
            this.H = EnqueueType.ENQUEUE_NONE;
            this.Q = true;
            this.f70530c = str;
        }

        public a a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iArr)) == null) {
                this.k = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
                this.M = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.C = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(EnqueueType enqueueType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, enqueueType)) == null) {
                this.H = enqueueType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.P = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public DownloadInfo a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new DownloadInfo(this) : (DownloadInfo) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(178164289, "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(178164289, "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<DownloadInfo>() { // from class: com.ss.android.socialbase.downloader.model.DownloadInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public DownloadInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new DownloadInfo(parcel) : (DownloadInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public DownloadInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new DownloadInfo[i2] : (DownloadInfo[]) invokeI.objValue;
            }
        };
    }

    private void convertEnqueueType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            if (i2 == EnqueueType.ENQUEUE_HEAD.ordinal()) {
                this.enqueueType = EnqueueType.ENQUEUE_HEAD;
            } else if (i2 == EnqueueType.ENQUEUE_TAIL.ordinal()) {
                this.enqueueType = EnqueueType.ENQUEUE_TAIL;
            } else {
                this.enqueueType = EnqueueType.ENQUEUE_NONE;
            }
        }
    }

    private void convertRetryDelayStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            if (i2 == g.f70110b.ordinal()) {
                this.retryDelayStatus = g.f70110b;
            } else if (i2 == g.f70111c.ordinal()) {
                this.retryDelayStatus = g.f70111c;
            } else if (i2 == g.f70112d.ordinal()) {
                this.retryDelayStatus = g.f70112d;
            } else {
                this.retryDelayStatus = g.f70109a;
            }
        }
    }

    private JSONObject convertStrToJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private void ensureDBJsonData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                        this.dbJsonData = new JSONObject(this.dbJsonDataString);
                        this.dbJsonDataString = null;
                    } else {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    private void ensureSpData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.spData == null) {
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            if (N != null) {
                String string = N.getSharedPreferences("sp_download_info", 0).getString(Long.toString(getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    private void ensureTempCacheData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    private String getBackUpUrlsStr() {
        InterceptResult invokeV;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : this.backUpUrls) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(str);
                        }
                    }
                    this.backUpUrlsStr = jSONArray.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.backUpUrlsStr == null) {
                this.backUpUrlsStr = "";
            }
            return this.backUpUrlsStr;
        }
        return (String) invokeV.objValue;
    }

    private String getDBJsonDataString() {
        InterceptResult invokeV;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            String str = this.dbJsonDataString;
            if (str != null) {
                return str;
            }
            ensureDBJsonData();
            synchronized (this.dbJsonData) {
                jSONObject = this.dbJsonData.toString();
                this.dbJsonDataString = jSONObject;
            }
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    private int getReserveWifiStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            ensureSpData();
            try {
                return this.spData.optInt("pause_reserve_on_wifi", 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && opt != null) {
                        this.dbJsonData.put(next, opt);
                    }
                }
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    private void parseMonitorSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            ensureDBJsonData();
            this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
            this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
            JSONArray optJSONArray = this.dbJsonData.optJSONArray("extra_monitor_status");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            this.extraMonitorStatus = new int[optJSONArray.length()];
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.extraMonitorStatus[i2] = optJSONArray.optInt(i2);
            }
        }
    }

    private void putMonitorSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            safePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
            safePutToDBJsonData("monitor_scene", this.monitorScene);
            try {
                JSONArray jSONArray = new JSONArray();
                if (this.extraMonitorStatus != null && this.extraMonitorStatus.length > 0) {
                    for (int i2 = 0; i2 < this.extraMonitorStatus.length; i2++) {
                        jSONArray.put(this.extraMonitorStatus[i2]);
                    }
                }
                safePutToDBJsonData("extra_monitor_status", jSONArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65554, this, z) == null) || (list = this.forbiddenBackupUrls) == null || list.size() <= z) {
            return;
        }
        List<String> list2 = this.backUpUrls;
        if (list2 == null) {
            this.backUpUrls = new ArrayList();
        } else {
            list2.clear();
        }
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        for (int i2 = z; i2 < this.forbiddenBackupUrls.size(); i2++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i2));
        }
    }

    private void setBackUpUrlsStr(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, str) == null) || TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                this.backUpUrls = arrayList;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void addErrorBytesLog(long j, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), str}) == null) {
            try {
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    if (this.errorBytesLog == null) {
                        this.errorBytesLog = new StringBuffer();
                    }
                    if (this.errorBytesLog.length() != 0) {
                        this.errorBytesLog.append(",");
                    }
                    StringBuffer stringBuffer = this.errorBytesLog;
                    stringBuffer.append("[type:");
                    stringBuffer.append(i2);
                    stringBuffer.append(",bytes:");
                    stringBuffer.append(j);
                    stringBuffer.append(",method:");
                    stringBuffer.append(str);
                    stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteStatement) == null) || sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        sQLiteStatement.bindLong(i2, this.id);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i3, str);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i4, str2);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i5, str3);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i6, str4);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, this.chunkCount);
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getStatus());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, getCurBytes());
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        sQLiteStatement.bindLong(i10, this.totalBytes);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i11, str5);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.onlyWifi ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.force ? 1L : 0L);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        sQLiteStatement.bindLong(i14, this.retryCount);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i15, str6);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i16, str7);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i17, str8);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.showNotification ? 1L : 0L);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.notificationVisibility);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstDownload ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.isFirstSuccess ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.needHttpsToHttpRetry ? 1L : 0L);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        sQLiteStatement.bindLong(i23, this.downloadTime);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i24, str9);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i25, str10);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.needRetryDelay ? 1L : 0L);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, this.curRetryTime);
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.retryDelayStatus.ordinal());
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        sQLiteStatement.bindLong(i30, this.needReuseChunkRunnable ? 1L : 0L);
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i31, str11);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindLong(i32, this.needChunkDowngradeRetry ? 1L : 0L);
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindString(i33, getBackUpUrlsStr());
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.backUpUrlRetryCount);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, this.realDownloadTime);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.retryScheduleMinutes);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindLong(i37, this.needIndependentProcess ? 1L : 0L);
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        sQLiteStatement.bindString(i38, getDBJsonDataString());
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        String str12 = this.iconUrl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i39, str12);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        sQLiteStatement.bindLong(i40, this.appVersionCode);
        int i41 = this.bindValueCount + 1;
        this.bindValueCount = i41;
        String str13 = this.taskId;
        sQLiteStatement.bindString(i41, str13 != null ? str13 : "");
    }

    public boolean cacheExpierd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (isDownloaded()) {
                return f.d(this);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean canNotifyProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.lastNotifyProgressTime.get();
            return j == 0 || SystemClock.uptimeMillis() - j > 20;
        }
        return invokeV.booleanValue;
    }

    public boolean canReStartAsyncTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getStatus() != -3 && this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.f70076b : invokeV.booleanValue;
    }

    public boolean canReplaceHttpForRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed : invokeV.booleanValue;
    }

    public boolean canShowNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (!this.autoResumed && this.showNotification) || (this.autoResumed && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed)) : invokeV.booleanValue;
    }

    public boolean canSkipStatusHandler() {
        InterceptResult invokeV;
        com.ss.android.socialbase.downloader.constants.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int status = getStatus();
            return status == 7 || this.retryDelayStatus == g.f70110b || status == 8 || (aVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.a.f70076b || aVar == com.ss.android.socialbase.downloader.constants.a.f70077c || this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.b.f70082b;
        }
        return invokeV.booleanValue;
    }

    public boolean canStartRetryDelayTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == g.f70110b : invokeV.booleanValue;
    }

    public void changeSkipStatus() {
        com.ss.android.socialbase.downloader.constants.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int status = getStatus();
            if (status == 7 || this.retryDelayStatus == g.f70110b) {
                setRetryDelayStatus(g.f70111c);
            }
            if (status == 8 || (aVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.a.f70076b || aVar == com.ss.android.socialbase.downloader.constants.a.f70077c) {
                setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f70078d);
            }
            if (this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.b.f70082b) {
                setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f70083c);
            }
        }
    }

    public int checkMd5Status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? f.b(getSavePath(), getName(), this.md5) : invokeV.intValue;
    }

    public boolean checkMd5Valid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? f.c(getSavePath(), getName(), this.md5) : invokeV.booleanValue;
    }

    public void clearSpData() {
        Context N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (N = com.ss.android.socialbase.downloader.downloader.c.N()) == null) {
            return;
        }
        try {
            N.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(getId())).apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (!downloadInfo.canSkipStatusHandler() && !canSkipStatusHandler()) {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        } else {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        }
        seteTag(downloadInfo.geteTag());
        if (z) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    public void copyTaskIdFromCacheData(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.taskId = downloadInfo.getTaskId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downloadInfo)) == null) ? (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true : invokeL.booleanValue;
    }

    public void erase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setCurBytes(0L, true);
            this.totalBytes = 0L;
            this.chunkCount = 1;
            this.downloadTime = 0L;
            this.realStartDownloadTime = 0L;
            this.realDownloadTime = 0L;
            this.curRetryTime = 0;
            this.isFirstDownload = true;
            this.isFirstSuccess = true;
            this.backUpUrlUsed = false;
            this.httpsToHttpRetryUsed = false;
            this.eTag = null;
            this.failedException = null;
            this.tempCacheData = null;
            this.packageInfoRef = null;
        }
    }

    public void generateTaskId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.taskId = UUID.randomUUID().toString();
        }
    }

    public long getAllConnectTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ensureDBJsonData();
            if (this.allConnectTime == null) {
                this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
            }
            return this.allConnectTime.get();
        }
        return invokeV.longValue;
    }

    public int getAntiHijackErrorCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("anti_hijack_error_code", i2);
        }
        return invokeI.intValue;
    }

    public int getAppVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.appVersionCode : invokeV.intValue;
    }

    public com.ss.android.socialbase.downloader.constants.a getAsyncHandleStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.asyncHandleStatus : (com.ss.android.socialbase.downloader.constants.a) invokeV.objValue;
    }

    public String getBackUpUrl() {
        InterceptResult invokeV;
        List<String> list;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i2 = this.curBackUpUrlIndex) >= 0 && i2 < this.backUpUrls.size()) {
                String str = this.backUpUrls.get(this.curBackUpUrlIndex);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getBackUpUrlRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.backUpUrlRetryCount : invokeV.intValue;
    }

    public List<String> getBackUpUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.backUpUrls : (List) invokeV.objValue;
    }

    public int getBindValueCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.bindValueCount : invokeV.intValue;
    }

    public com.ss.android.socialbase.downloader.constants.b getByteInvalidRetryStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.byteInvalidRetryStatus : (com.ss.android.socialbase.downloader.constants.b) invokeV.objValue;
    }

    public String getCacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ensureSpData();
            try {
                return this.spData.optString(Headers.CACHE_CONTROL, null);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public long getCacheExpiredTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ensureSpData();
            try {
                return this.spData.optLong("cache-control/expired_time", -1L);
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public int getChunkCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.chunkCount : invokeV.intValue;
    }

    public String getConnectionUrl() {
        InterceptResult invokeV;
        List<String> list;
        int i2;
        List<String> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            String str = this.url;
            if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
                return this.forbiddenBackupUrls.get(0);
            }
            if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i2 = this.curBackUpUrlIndex) < 0 || i2 >= this.backUpUrls.size()) {
                return (!TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst("https", "http") : str;
            }
            String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeV.objValue;
    }

    public int getCurBackUpUrlIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.curBackUpUrlIndex : invokeV.intValue;
    }

    public long getCurBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            AtomicLong atomicLong = this.curBytes;
            if (atomicLong != null) {
                return atomicLong.get();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getCurRetryTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.curRetryTime : invokeV.intValue;
    }

    public int getCurRetryTimeInTotal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            int i2 = this.curRetryTime;
            if (this.backUpUrlUsed) {
                int i3 = i2 + this.retryCount;
                int i4 = this.curBackUpUrlIndex;
                return i4 > 0 ? i3 + (i4 * this.backUpUrlRetryCount) : i3;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getDBJsonInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt(str);
        }
        return invokeL.intValue;
    }

    public String getDBJsonString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optString(str);
        }
        return (String) invokeL.objValue;
    }

    public long getDownloadPrepareTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
        }
        return invokeV.longValue;
    }

    public int getDownloadProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.totalBytes <= 0) {
                return 0;
            }
            if (getCurBytes() > this.totalBytes) {
                return 100;
            }
            return (int) ((getCurBytes() * 100) / this.totalBytes);
        }
        return invokeV.intValue;
    }

    public String getDownloadSettingString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optString("download_setting");
        }
        return (String) invokeV.objValue;
    }

    public double getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            double curBytes = getCurBytes() / 1048576.0d;
            double realDownloadTime = getRealDownloadTime() / 1000.0d;
            if (curBytes <= 0.0d || realDownloadTime <= 0.0d) {
                return -1.0d;
            }
            return curBytes / realDownloadTime;
        }
        return invokeV.doubleValue;
    }

    public long getDownloadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.downloadTime : invokeV.longValue;
    }

    public EnqueueType getEnqueueType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.enqueueType : (EnqueueType) invokeV.objValue;
    }

    public String getErrorBytesLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            StringBuffer stringBuffer = this.errorBytesLog;
            return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
        }
        return (String) invokeV.objValue;
    }

    public int getExecutorGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("executor_group", 2);
        }
        return invokeV.intValue;
    }

    public long getExpectFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optLong("dbjson_key_expect_file_length");
        }
        return invokeV.longValue;
    }

    public String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.extra : (String) invokeV.objValue;
    }

    public List<c> getExtraHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.extraHeaders : (List) invokeV.objValue;
    }

    public int[] getExtraMonitorStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.extraMonitorStatus : (int[]) invokeV.objValue;
    }

    public BaseException getFailedException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.failedException : (BaseException) invokeV.objValue;
    }

    public int getFailedResumeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            ensureSpData();
            return this.spData.optInt("failed_resume_count", 0);
        }
        return invokeV.intValue;
    }

    public String getFilePackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.filePackageName : (String) invokeV.objValue;
    }

    public long getFirstSpeedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optLong("dbjson_key_first_speed_time");
        }
        return invokeV.longValue;
    }

    public List<String> getForbiddenBackupUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.forbiddenBackupUrls : (List) invokeV.objValue;
    }

    public String getHeadConnectionException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.headConnectionException : (String) invokeV.objValue;
    }

    public int getHttpStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.httpStatusCode : invokeV.intValue;
    }

    public String getHttpStatusMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.httpStatusMessage : (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.id == 0) {
                this.id = com.ss.android.socialbase.downloader.downloader.c.a(this);
            }
            return this.id;
        }
        return invokeV.intValue;
    }

    public boolean getIsFirstDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.isFirstDownload : invokeV.booleanValue;
    }

    public long getLastDownloadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optLong("dbjson_last_start_download_time", 0L);
        }
        return invokeV.longValue;
    }

    public long getLastFailedResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            ensureSpData();
            return this.spData.optLong("last_failed_resume_time", 0L);
        }
        return invokeV.longValue;
    }

    public String getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ensureSpData();
            try {
                return this.spData.optString(Headers.LAST_MODIFIED, null);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public long getLastUninstallResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ensureSpData();
            return this.spData.optLong("last_unins_resume_time", 0L);
        }
        return invokeV.longValue;
    }

    public int getLinkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("link_mode");
        }
        return invokeV.intValue;
    }

    public int getMaxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.maxBytes : invokeV.intValue;
    }

    public int getMaxProgressCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.maxProgressCount : invokeV.intValue;
    }

    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.md5 : (String) invokeV.objValue;
    }

    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mimeType : (String) invokeV.objValue;
    }

    public long getMinByteIntervalForPostToMainThread(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048646, this, j)) == null) {
            int i2 = this.maxProgressCount;
            if (i2 <= 0) {
                i2 = 100;
            }
            long j2 = j / (i2 + 1);
            if (j2 <= 0) {
                return 1048576L;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public int getMinProgressTimeMsInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            int i2 = this.minProgressTimeMsInterval;
            if (i2 < 1000) {
                return 1000;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public String getMonitorScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.monitorScene : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getNetworkQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.networkQuality : (String) invokeV.objValue;
    }

    public int getNotificationVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.notificationVisibility : invokeV.intValue;
    }

    public boolean getOpenLimitSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.openLimitSpeed : invokeV.booleanValue;
    }

    public String[] getOutIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.outIp : (String[]) invokeV.objValue;
    }

    public int[] getOutSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.outSize : (int[]) invokeV.objValue;
    }

    public PackageInfo getPackageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            SoftReference<PackageInfo> softReference = this.packageInfoRef;
            if (softReference == null) {
                return null;
            }
            return softReference.get();
        }
        return (PackageInfo) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public int getPausedResumeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            ensureSpData();
            return this.spData.optInt("paused_resume_count", 0);
        }
        return invokeV.intValue;
    }

    public int getPreconnectLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("dbjson_key_preconnect_level", 0);
        }
        return invokeV.intValue;
    }

    public long getRealDownloadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime) : invokeV.longValue;
    }

    public int getRealStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            AtomicInteger atomicInteger = this.status;
            if (atomicInteger != null) {
                return atomicInteger.get();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.retryCount : invokeV.intValue;
    }

    public g getRetryDelayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.retryDelayStatus : (g) invokeV.objValue;
    }

    public String getRetryDelayTimeArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.retryDelayTimeArray : (String) invokeV.objValue;
    }

    public int getRetryScheduleCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("retry_schedule_count", 0);
        }
        return invokeV.intValue;
    }

    public String getSavePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.savePath : (String) invokeV.objValue;
    }

    public int getSpIntVal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, str)) == null) {
            ensureSpData();
            return this.spData.optInt(str, 0);
        }
        return invokeL.intValue;
    }

    public long getSpLongVal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, str)) == null) {
            ensureSpData();
            return this.spData.optLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public String getSpStringVal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, str)) == null) {
            ensureSpData();
            return this.spData.optString(str, null);
        }
        return (String) invokeL.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            AtomicInteger atomicInteger = this.status;
            if (atomicInteger != null) {
                int i2 = atomicInteger.get();
                if (i2 == -5) {
                    return -2;
                }
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getStatusAtDbInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.statusAtDbInit : invokeV.intValue;
    }

    public int getTTMd5CheckStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("ttmd5_check_status", -1);
        }
        return invokeV.intValue;
    }

    public String getTargetFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? f.a(this.savePath, this.name) : (String) invokeV.objValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.taskId : (String) invokeV.objValue;
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            ensureTempCacheData();
            return this.tempCacheData;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    public String getTempFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? f.a(this.savePath, this.tempPath, this.name) : (String) invokeV.objValue;
    }

    public String getTempName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? f.c(this.name) : (String) invokeV.objValue;
    }

    public String getTempPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? f.b(this.savePath, this.tempPath) : (String) invokeV.objValue;
    }

    public long getThrottleNetSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.throttleNetSpeed : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (TextUtils.isEmpty(this.title)) {
                return this.name;
            }
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public long getTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.totalBytes : invokeV.longValue;
    }

    public int getTotalRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            int i2 = this.retryCount;
            List<String> list = this.backUpUrls;
            return (list == null || list.isEmpty()) ? i2 : i2 + (this.backUpUrlRetryCount * this.backUpUrls.size());
        }
        return invokeV.intValue;
    }

    public long getTtnetProtectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.ttnetProtectTimeout : invokeV.longValue;
    }

    public int getUninstallResumeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            ensureSpData();
            return this.spData.optInt("unins_resume_count", 0);
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public String geteTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.eTag : (String) invokeV.objValue;
    }

    public synchronized void handleTempSaveCallback(boolean z, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048686, this, z, baseException) == null) {
            synchronized (this) {
                this.isSaveTempFile = false;
                if (this.tempFileSaveCompleteCallbacks == null) {
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.b(TAG, "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
                for (ai aiVar : this.tempFileSaveCompleteCallbacks) {
                    if (aiVar != null) {
                        if (z) {
                            aiVar.a();
                        } else {
                            aiVar.a(baseException);
                        }
                    }
                }
            }
        }
    }

    public boolean hasNextBackupUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            List<String> list = this.backUpUrls;
            if (list != null && list.size() > 0) {
                if (!this.backUpUrlUsed) {
                    return true;
                }
                int i2 = this.curBackUpUrlIndex;
                if (i2 >= 0 && i2 < this.backUpUrls.size() - 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasPauseReservedOnWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? (getReserveWifiStatus() & 1) > 0 : invokeV.booleanValue;
    }

    public void increaseAllConnectTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048689, this, j) == null) || j <= 0) {
            return;
        }
        getAllConnectTime();
        safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(j)));
    }

    public void increaseCurBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048690, this, j) == null) {
            this.curBytes.addAndGet(j);
        }
    }

    public void increaseDownloadPrepareTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048691, this, j) == null) || j <= 0) {
            return;
        }
        safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + j));
    }

    public boolean isAddListenerToSameTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.addListenerToSameTask : invokeV.booleanValue;
    }

    public boolean isAutoInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("auto_install", 1) == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isAutoInstallWithoutNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.isAutoInstallWithoutNotification == null) {
                if (!TextUtils.isEmpty(this.extra)) {
                    try {
                        this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean("auto_install_without_notification", false));
                    } catch (JSONException unused) {
                        this.isAutoInstallWithoutNotification = Boolean.FALSE;
                    }
                } else {
                    this.isAutoInstallWithoutNotification = Boolean.FALSE;
                }
            }
            return this.isAutoInstallWithoutNotification.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean isAutoResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.autoResumed : invokeV.booleanValue;
    }

    public boolean isBackUpUrlUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.backUpUrlUsed : invokeV.booleanValue;
    }

    public boolean isBreakpointAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            if (isFileDataValid()) {
                return isChunkBreakpointAvailable();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            int status = getStatus();
            if (status == 4 || status == 3 || status == -1 || status == 5 || status == 8) {
                return true;
            }
            return (status == 1 || status == 2) && getCurBytes() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isChunkBreakpointAvailable() {
        InterceptResult invokeV;
        j x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (this.chunkCount > 1 && (x = com.ss.android.socialbase.downloader.downloader.c.x()) != null) {
                List<b> c2 = x.c(getId());
                if (c2 == null || c2.size() != this.chunkCount) {
                    return false;
                }
                long j = 0;
                for (b bVar : c2) {
                    if (bVar != null) {
                        j += bVar.o();
                    }
                }
                if (j != getCurBytes()) {
                    setCurBytes(j);
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isChunkDowngradeRetryUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.chunkDowngradeRetryUsed : invokeV.booleanValue;
    }

    public boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? f.b(this.totalBytes) : invokeV.booleanValue;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.deleteCacheIfCheckFailed : invokeV.booleanValue;
    }

    public boolean isDownloadFromReserveWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.mDownloadFromReserveWifi : invokeV.booleanValue;
    }

    public boolean isDownloadOverStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? DownloadStatus.isDownloadOver(getStatus()) : invokeV.booleanValue;
    }

    public boolean isDownloadWithWifiValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? !isOnlyWifi() || f.b(com.ss.android.socialbase.downloader.downloader.c.N()) : invokeV.booleanValue;
    }

    public boolean isDownloaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? f.c(this) : invokeV.booleanValue;
    }

    public boolean isDownloadingStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? DownloadStatus.isDownloading(getStatus()) : invokeV.booleanValue;
    }

    public boolean isEntityInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath) : invokeV.booleanValue;
    }

    public boolean isExpiredRedownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("force_close_download_cache_check", 0) == 1) {
                com.ss.android.socialbase.downloader.c.a.c("isExpiredRedownload force to false, reason(global setting) id=" + getId() + " name=" + getName());
                return false;
            }
            return this.expiredRedownload;
        }
        return invokeV.booleanValue;
    }

    public boolean isFileDataExists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            if (isEntityInvalid()) {
                return false;
            }
            File file = new File(getTempPath(), getTempName());
            return file.exists() && !file.isDirectory();
        }
        return invokeV.booleanValue;
    }

    public boolean isFileDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if (isEntityInvalid()) {
                return false;
            }
            File file = new File(getTempPath(), getTempName());
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long curBytes = getCurBytes();
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_file_data_valid")) {
                    if (curBytes > 0) {
                        long j = this.totalBytes;
                        if (j > 0 && this.chunkCount > 0 && length >= curBytes && length <= j) {
                            return true;
                        }
                    }
                    com.ss.android.socialbase.downloader.c.a.d(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                    return false;
                }
                if (length > 0 && curBytes > 0) {
                    long j2 = this.totalBytes;
                    if (j2 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j2 && curBytes < j2) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.c.a.d(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (!this.isFirstDownload || TextUtils.isEmpty(getTempPath()) || TextUtils.isEmpty(getTempName())) {
                return false;
            }
            return !new File(getTempPath(), getTempName()).exists();
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.isFirstSuccess : invokeV.booleanValue;
    }

    public boolean isForbiddenRetryed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.isForbiddenRetryed : invokeV.booleanValue;
    }

    public boolean isForce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.force : invokeV.booleanValue;
    }

    public boolean isForceIgnoreRecommendSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.forceIgnoreRecommendSize : invokeV.booleanValue;
    }

    public boolean isHeadConnectionAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.headConnectionAvailable : invokeV.booleanValue;
    }

    public boolean isHttpsToHttpRetryUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? this.httpsToHttpRetryUsed : invokeV.booleanValue;
    }

    public boolean isIgnoreDataVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.ignoreDataVerify : invokeV.booleanValue;
    }

    public boolean isNeedChunkDowngradeRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.needChunkDowngradeRetry : invokeV.booleanValue;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.needDefaultHttpServiceBackUp : invokeV.booleanValue;
    }

    public boolean isNeedHttpsToHttpRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.needHttpsToHttpRetry : invokeV.booleanValue;
    }

    public boolean isNeedIndependentProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.needIndependentProcess : invokeV.booleanValue;
    }

    public boolean isNeedPostProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.needPostProgress : invokeV.booleanValue;
    }

    public boolean isNeedRetryDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedReuseChunkRunnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.needReuseChunkRunnable : invokeV.booleanValue;
    }

    public boolean isNeedReuseFirstConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.needReuseFirstConnection : invokeV.booleanValue;
    }

    public boolean isNeedSDKMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.needSDKMonitor : invokeV.booleanValue;
    }

    public boolean isNewTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? getStatus() == 0 : invokeV.booleanValue;
    }

    public boolean isOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.onlyWifi : invokeV.booleanValue;
    }

    public boolean isPauseReserveOnWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? (getReserveWifiStatus() & 2) > 0 : invokeV.booleanValue;
    }

    public boolean isPauseReserveWithWifiValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (this.mDownloadFromReserveWifi) {
                return isPauseReserveOnWifi() && f.b(com.ss.android.socialbase.downloader.downloader.c.N());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isRwConcurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isSavePathRedirected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            ensureDBJsonData();
            return this.dbJsonData.optBoolean("is_save_path_redirected", false);
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean isSaveTempFile() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            synchronized (this) {
                z = this.isSaveTempFile;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.showNotification : invokeV.booleanValue;
    }

    public boolean isShowNotificationForAutoResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.showNotificationForAutoResumed : invokeV.booleanValue;
    }

    public boolean isShowNotificationForNetworkResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.showNotificationForNetworkResumed : invokeV.booleanValue;
    }

    public boolean isSuccessByCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.successByCache : invokeV.booleanValue;
    }

    public boolean isSupportPartial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.supportPartial : invokeV.booleanValue;
    }

    public boolean isWaitingWifiStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            BaseException baseException = this.failedException;
            return baseException != null && baseException.getErrorCode() == 1013;
        }
        return invokeV.booleanValue;
    }

    public void readFromParcel(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, parcel) == null) {
            this.id = parcel.readInt();
            this.name = parcel.readString();
            this.title = parcel.readString();
            this.url = parcel.readString();
            this.savePath = parcel.readString();
            this.tempPath = parcel.readString();
            this.onlyWifi = parcel.readByte() != 0;
            this.extra = parcel.readString();
            this.extraHeaders = parcel.createTypedArrayList(c.CREATOR);
            this.maxBytes = parcel.readInt();
            this.outIp = parcel.createStringArray();
            this.outSize = parcel.createIntArray();
            this.retryCount = parcel.readInt();
            this.backUpUrlRetryCount = parcel.readInt();
            this.force = parcel.readByte() != 0;
            this.needPostProgress = parcel.readByte() != 0;
            this.maxProgressCount = parcel.readInt();
            this.minProgressTimeMsInterval = parcel.readInt();
            this.backUpUrls = parcel.createStringArrayList();
            this.showNotification = parcel.readByte() != 0;
            this.mimeType = parcel.readString();
            this.needHttpsToHttpRetry = parcel.readByte() != 0;
            this.packageName = parcel.readString();
            this.md5 = parcel.readString();
            this.needRetryDelay = parcel.readByte() != 0;
            this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
            this.needReuseChunkRunnable = parcel.readByte() != 0;
            this.retryDelayTimeArray = parcel.readString();
            this.eTag = parcel.readString();
            this.curRetryTime = parcel.readInt();
            convertRetryDelayStatus(parcel.readInt());
            this.needReuseFirstConnection = parcel.readByte() != 0;
            this.forceIgnoreRecommendSize = parcel.readByte() != 0;
            this.networkQuality = parcel.readString();
            this.curBackUpUrlIndex = parcel.readInt();
            this.notificationVisibility = parcel.readInt();
            this.chunkCount = parcel.readInt();
            setCurBytes(parcel.readLong());
            this.totalBytes = parcel.readLong();
            setStatus(parcel.readInt());
            this.downloadTime = parcel.readLong();
            this.realDownloadTime = parcel.readLong();
            this.backUpUrlUsed = parcel.readByte() != 0;
            this.httpsToHttpRetryUsed = parcel.readByte() != 0;
            try {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new StringBuffer(parcel.readString());
                } else {
                    this.errorBytesLog.delete(0, this.errorBytesLog.length()).append(parcel.readString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.autoResumed = parcel.readByte() != 0;
            this.showNotificationForAutoResumed = parcel.readByte() != 0;
            this.showNotificationForNetworkResumed = parcel.readByte() != 0;
            this.forbiddenBackupUrls = parcel.createStringArrayList();
            this.needIndependentProcess = parcel.readByte() != 0;
            convertEnqueueType(parcel.readInt());
            this.headConnectionAvailable = parcel.readByte() != 0;
            this.httpStatusCode = parcel.readInt();
            this.httpStatusMessage = parcel.readString();
            this.isSaveTempFile = parcel.readByte() != 0;
            this.isForbiddenRetryed = parcel.readByte() != 0;
            this.addListenerToSameTask = parcel.readByte() != 0;
            this.needChunkDowngradeRetry = parcel.readByte() != 0;
            this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
            this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
            this.retryScheduleMinutes = parcel.readInt();
            this.dbJsonDataString = parcel.readString();
            this.supportPartial = parcel.readByte() != 0;
            this.iconUrl = parcel.readString();
            this.appVersionCode = parcel.readInt();
            this.taskId = parcel.readString();
            this.expiredRedownload = parcel.readByte() != 0;
            this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
            this.successByCache = parcel.readByte() != 0;
            parseMonitorSetting();
        }
    }

    public synchronized void registerTempFileSaveCallback(ai aiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, aiVar) == null) {
            synchronized (this) {
                if (aiVar == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.c.a.b(TAG, "registerTempFileSaveCallback");
                    if (this.tempFileSaveCompleteCallbacks == null) {
                        this.tempFileSaveCompleteCallbacks = new ArrayList();
                    }
                    if (!this.tempFileSaveCompleteCallbacks.contains(aiVar)) {
                        this.tempFileSaveCompleteCallbacks.add(aiVar);
                    }
                } finally {
                }
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            setCurBytes(0L, true);
            this.totalBytes = 0L;
            this.chunkCount = 1;
            this.downloadTime = 0L;
            this.realStartDownloadTime = 0L;
            this.realDownloadTime = 0L;
        }
    }

    public void resetDataForEtagEndure(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
            setCurBytes(0L, true);
            setTotalBytes(0L);
            seteTag(str);
            setChunkCount(1);
            this.downloadTime = 0L;
            this.realStartDownloadTime = 0L;
            this.realDownloadTime = 0L;
        }
    }

    public void resetRealStartDownloadTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.realStartDownloadTime = 0L;
        }
    }

    public void safePutToDBJsonData(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048747, this, str, obj) == null) {
            ensureDBJsonData();
            synchronized (this.dbJsonData) {
                try {
                    this.dbJsonData.put(str, obj);
                } catch (Exception unused) {
                }
                this.dbJsonDataString = null;
            }
        }
    }

    public void setAddListenerToSameTask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            this.addListenerToSameTask = z;
        }
    }

    public void setAntiHijackErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048749, this, i2) == null) {
            safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(i2));
        }
    }

    public void setAppVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048750, this, i2) == null) {
            this.appVersionCode = i2;
        }
    }

    public void setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, aVar) == null) {
            this.asyncHandleStatus = aVar;
        }
    }

    public void setAutoResumed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z) == null) {
            this.autoResumed = z;
        }
    }

    public void setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, bVar) == null) {
            this.byteInvalidRetryStatus = bVar;
        }
    }

    public void setCacheControl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, str) == null) {
            ensureSpData();
            try {
                this.spData.put(Headers.CACHE_CONTROL, str);
                updateSpData();
            } catch (Exception unused) {
            }
        }
    }

    public void setCacheExpiredTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048755, this, j) == null) {
            ensureSpData();
            try {
                this.spData.put("cache-control/expired_time", j);
                updateSpData();
            } catch (Exception unused) {
            }
        }
    }

    public void setChunkCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048756, this, i2) == null) {
            this.chunkCount = i2;
        }
    }

    public void setChunkDowngradeRetryUsed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
            this.chunkDowngradeRetryUsed = z;
        }
    }

    public void setCurBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048758, this, j) == null) {
            AtomicLong atomicLong = this.curBytes;
            if (atomicLong != null) {
                atomicLong.set(j);
            } else {
                this.curBytes = new AtomicLong(j);
            }
        }
    }

    public void setDeleteCacheIfCheckFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            this.deleteCacheIfCheckFailed = true;
        }
    }

    public void setDownloadFromReserveWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048761, this, z) == null) {
            this.mDownloadFromReserveWifi = z;
        }
    }

    public void setDownloadTime(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048762, this, j) == null) || j < 0) {
            return;
        }
        this.downloadTime = j;
    }

    public void setExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, str) == null) {
            this.extra = str;
        }
    }

    public void setFailedException(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, baseException) == null) {
            this.failedException = baseException;
        }
    }

    public void setFailedResumeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048765, this, i2) == null) {
            ensureSpData();
            try {
                this.spData.put("failed_resume_count", i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setFilePackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, str) == null) {
            this.filePackageName = str;
        }
    }

    public void setFirstDownload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
            this.isFirstDownload = z;
        }
    }

    public void setFirstSpeedTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048768, this, j) == null) {
            safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(j));
        }
    }

    public void setFirstSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z) == null) {
            this.isFirstSuccess = z;
        }
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048770, this, list, z) == null) {
            this.forbiddenBackupUrls = list;
            refreshBackupUrls(z);
        }
    }

    public void setForbiddenRetryed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            this.isForbiddenRetryed = true;
        }
    }

    public void setForceIgnoreRecommendSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048772, this, z) == null) {
            this.forceIgnoreRecommendSize = z;
        }
    }

    public void setHeadConnectionException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.headConnectionException = str;
        }
    }

    public void setHttpStatusCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048774, this, i2) == null) {
            this.httpStatusCode = i2;
        }
    }

    public void setHttpStatusMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, str) == null) {
            this.httpStatusMessage = str;
        }
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048776, this, z) == null) {
            this.httpsToHttpRetryUsed = z;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, str) == null) {
            this.iconUrl = str;
        }
    }

    public void setId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048778, this, i2) == null) {
            this.id = i2;
        }
    }

    public void setIsRwConcurrent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z) == null) {
            safePutToDBJsonData("rw_concurrent", Integer.valueOf(z ? 1 : 0));
        }
    }

    public synchronized void setIsSaveTempFile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z) == null) {
            synchronized (this) {
                this.isSaveTempFile = z;
            }
        }
    }

    public void setLastFailedResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048781, this, j) == null) {
            ensureSpData();
            try {
                this.spData.put("last_failed_resume_time", j);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setLastModified(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, str) == null) {
            ensureSpData();
            try {
                this.spData.put(Headers.LAST_MODIFIED, str);
                updateSpData();
            } catch (Exception unused) {
            }
        }
    }

    public void setLastNotifyProgressTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
        }
    }

    public void setLastUninstallResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048784, this, j) == null) {
            ensureSpData();
            try {
                this.spData.put("last_unins_resume_time", j);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setLinkMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048785, this, i2) == null) {
            safePutToDBJsonData("link_mode", Integer.valueOf(i2));
        }
    }

    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, str) == null) {
            this.md5 = str;
        }
    }

    public void setMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, str) == null) {
            this.mimeType = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, str) == null) {
            this.name = str;
        }
    }

    public void setNetworkQuality(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, str) == null) {
            this.networkQuality = str;
        }
    }

    public void setNotificationVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048790, this, i2) == null) {
            this.notificationVisibility = i2;
        }
    }

    public void setOnlyWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048791, this, z) == null) {
            this.onlyWifi = z;
        }
    }

    public void setOpenLimitSpeed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z) == null) {
            this.openLimitSpeed = z;
        }
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, packageInfo) == null) {
            this.packageInfoRef = new SoftReference<>(packageInfo);
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, str) == null) {
            this.packageName = str;
        }
    }

    public void setPausedResumeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048795, this, i2) == null) {
            ensureSpData();
            try {
                this.spData.put("paused_resume_count", i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setPreconnectLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048796, this, i2) == null) {
            ensureDBJsonData();
            safePutToDBJsonData("dbjson_key_preconnect_level", Integer.valueOf(i2));
        }
    }

    public void setRetryDelayStatus(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, gVar) == null) {
            this.retryDelayStatus = gVar;
        }
    }

    public void setRetryScheduleCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048798, this, i2) == null) {
            safePutToDBJsonData("retry_schedule_count", Integer.valueOf(i2));
        }
    }

    public void setSavePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, str) == null) {
            this.savePath = str;
        }
    }

    public void setSavePathRedirected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z) == null) {
            safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(z));
        }
    }

    public void setShowNotification(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.showNotification = z;
        }
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z) == null) {
            this.showNotificationForAutoResumed = z;
        }
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048803, this, z) == null) {
            this.showNotificationForNetworkResumed = z;
        }
    }

    public void setSpValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048804, this, str, str2) == null) {
            ensureSpData();
            try {
                this.spData.put(str, str2);
                updateSpData();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048805, this, i2) == null) {
            AtomicInteger atomicInteger = this.status;
            if (atomicInteger != null) {
                atomicInteger.set(i2);
            } else {
                this.status = new AtomicInteger(i2);
            }
        }
    }

    public void setStatusAtDbInit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048806, this, i2) == null) {
            this.statusAtDbInit = i2;
        }
    }

    public void setSuccessByCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048807, this, z) == null) {
            this.successByCache = z;
        }
    }

    public void setSupportPartial(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048808, this, z) == null) {
            this.supportPartial = z;
        }
    }

    public void setTTMd5CheckStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048809, this, i2) == null) {
            safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(i2));
        }
    }

    public void setThrottleNetSpeed(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048810, this, j) == null) {
            this.throttleNetSpeed = j;
        }
    }

    public void setTotalBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048811, this, j) == null) {
            this.totalBytes = j;
        }
    }

    public void setUninstallResumeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048812, this, i2) == null) {
            ensureSpData();
            try {
                this.spData.put("unins_resume_count", i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, str) == null) {
            this.url = str;
        }
    }

    public void seteTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, str) == null) {
            this.eTag = str;
        }
    }

    public void startPauseReserveOnWifi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048815, this) == null) {
            ensureSpData();
            try {
                this.spData.put("pause_reserve_on_wifi", 3);
                updateSpData();
            } catch (Exception unused) {
            }
        }
    }

    public boolean statusInPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) ? getRealStatus() == -2 || getRealStatus() == -5 : invokeV.booleanValue;
    }

    public void stopPauseReserveOnWifi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048817, this) == null) {
            ensureSpData();
            try {
                this.spData.put("pause_reserve_on_wifi", 1);
                updateSpData();
            } catch (Exception unused) {
            }
        }
    }

    public ContentValues toContentValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048818, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(this.id));
            contentValues.put("url", this.url);
            contentValues.put("savePath", this.savePath);
            contentValues.put("tempPath", this.tempPath);
            contentValues.put("name", this.name);
            contentValues.put("chunkCount", Integer.valueOf(this.chunkCount));
            contentValues.put("status", Integer.valueOf(getStatus()));
            contentValues.put("curBytes", Long.valueOf(getCurBytes()));
            contentValues.put("totalBytes", Long.valueOf(this.totalBytes));
            contentValues.put("eTag", this.eTag);
            contentValues.put("onlyWifi", Integer.valueOf(this.onlyWifi ? 1 : 0));
            contentValues.put(TTDownloadField.TT_FORCE, Integer.valueOf(this.force ? 1 : 0));
            contentValues.put("retryCount", Integer.valueOf(this.retryCount));
            contentValues.put("extra", this.extra);
            contentValues.put("mimeType", this.mimeType);
            contentValues.put("title", this.title);
            contentValues.put("notificationEnable", Integer.valueOf(this.showNotification ? 1 : 0));
            contentValues.put("notificationVisibility", Integer.valueOf(this.notificationVisibility));
            contentValues.put("isFirstDownload", Integer.valueOf(this.isFirstDownload ? 1 : 0));
            contentValues.put("isFirstSuccess", Integer.valueOf(this.isFirstSuccess ? 1 : 0));
            contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
            contentValues.put("downloadTime", Long.valueOf(this.downloadTime));
            contentValues.put("packageName", this.packageName);
            contentValues.put(PackageTable.MD5, this.md5);
            contentValues.put("retryDelay", Integer.valueOf(this.needRetryDelay ? 1 : 0));
            contentValues.put("curRetryTime", Integer.valueOf(this.curRetryTime));
            contentValues.put("retryDelayStatus", Integer.valueOf(this.retryDelayStatus.ordinal()));
            contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
            contentValues.put("chunkRunnableReuse", Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
            contentValues.put("retryDelayTimeArray", this.retryDelayTimeArray);
            contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
            contentValues.put("backUpUrlsStr", getBackUpUrlsStr());
            contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.backUpUrlRetryCount));
            contentValues.put("realDownloadTime", Long.valueOf(this.realDownloadTime));
            contentValues.put("retryScheduleMinutes", Integer.valueOf(this.retryScheduleMinutes));
            contentValues.put("independentProcess", Integer.valueOf(this.needIndependentProcess ? 1 : 0));
            contentValues.put("auxiliaryJsonobjectString", getDBJsonDataString());
            contentValues.put("iconUrl", this.iconUrl);
            contentValues.put("appVersionCode", Integer.valueOf(this.appVersionCode));
            contentValues.put(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, this.taskId);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048819, this)) == null) {
            return "DownloadInfo{id=" + this.id + ", name='" + this.name + ExtendedMessageFormat.QUOTE + ", title='" + this.title + ExtendedMessageFormat.QUOTE + ", url='" + this.url + ExtendedMessageFormat.QUOTE + ", savePath='" + this.savePath + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public boolean trySwitchToNextBackupUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) {
            if (this.backUpUrlUsed) {
                this.curBackUpUrlIndex++;
            }
            List<String> list = this.backUpUrls;
            if (list != null && list.size() != 0 && this.curBackUpUrlIndex >= 0) {
                while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                    if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                        this.backUpUrlUsed = true;
                        return true;
                    }
                    this.curBackUpUrlIndex++;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void updateCurRetryTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048821, this, i2) == null) {
            int i3 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i2;
            this.curRetryTime = i3;
            if (i3 < 0) {
                this.curRetryTime = 0;
            }
        }
    }

    public void updateDownloadTime() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048822, this) == null) || this.startDownloadTime == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (uptimeMillis > 0) {
            this.downloadTime = uptimeMillis;
        }
    }

    public void updateRealDownloadTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048823, this, z) == null) {
            long nanoTime = System.nanoTime();
            long j = this.realStartDownloadTime;
            if (j <= 0) {
                if (z) {
                    this.realStartDownloadTime = nanoTime;
                    return;
                }
                return;
            }
            long j2 = nanoTime - j;
            if (z) {
                this.realStartDownloadTime = nanoTime;
            } else {
                this.realStartDownloadTime = 0L;
            }
            if (j2 > 0) {
                this.realDownloadTime += j2;
            }
        }
    }

    public void updateRealStartDownloadTime() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048824, this) == null) && this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void updateSpData() {
        Context N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048825, this) == null) || this.spData == null || (N = com.ss.android.socialbase.downloader.downloader.c.N()) == null) {
            return;
        }
        N.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
    }

    public void updateStartDownloadTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048826, this) == null) {
            this.startDownloadTime = SystemClock.uptimeMillis();
            safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048827, this, parcel, i2) == null) {
            parcel.writeInt(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            parcel.writeString(this.savePath);
            parcel.writeString(this.tempPath);
            parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
            parcel.writeString(this.extra);
            parcel.writeTypedList(this.extraHeaders);
            parcel.writeInt(this.maxBytes);
            parcel.writeStringArray(this.outIp);
            parcel.writeIntArray(this.outSize);
            parcel.writeInt(this.retryCount);
            parcel.writeInt(this.backUpUrlRetryCount);
            parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.maxProgressCount);
            parcel.writeInt(this.minProgressTimeMsInterval);
            parcel.writeStringList(this.backUpUrls);
            parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
            parcel.writeString(this.mimeType);
            parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
            parcel.writeString(this.packageName);
            parcel.writeString(this.md5);
            parcel.writeByte(this.needRetryDelay ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : (byte) 0);
            parcel.writeString(this.retryDelayTimeArray);
            parcel.writeString(this.eTag);
            parcel.writeInt(this.curRetryTime);
            parcel.writeInt(this.retryDelayStatus.ordinal());
            parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : (byte) 0);
            parcel.writeString(this.networkQuality);
            parcel.writeInt(this.curBackUpUrlIndex);
            parcel.writeInt(this.notificationVisibility);
            parcel.writeInt(this.chunkCount);
            parcel.writeLong(getCurBytes());
            parcel.writeLong(this.totalBytes);
            parcel.writeInt(getRealStatus());
            parcel.writeLong(this.downloadTime);
            parcel.writeLong(this.realDownloadTime);
            parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
            StringBuffer stringBuffer = this.errorBytesLog;
            parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
            parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
            parcel.writeStringList(this.forbiddenBackupUrls);
            parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.enqueueType.ordinal());
            parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.httpStatusCode);
            parcel.writeString(this.httpStatusMessage);
            parcel.writeByte(this.isSaveTempFile ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
            parcel.writeParcelable(this.failedException, i2);
            parcel.writeInt(this.retryScheduleMinutes);
            parcel.writeString(getDBJsonDataString());
            parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
            parcel.writeString(this.iconUrl);
            parcel.writeInt(this.appVersionCode);
            parcel.writeString(this.taskId);
            parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
        }
    }

    public DownloadInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = g.f70109a;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.f70075a;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.f70081a;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
    }

    public void setCurBytes(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048759, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (z) {
                setCurBytes(j);
            } else if (j > getCurBytes()) {
                setCurBytes(j);
            }
        }
    }

    public DownloadInfo(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = g.f70109a;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.f70075a;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.f70081a;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (aVar == null) {
            return;
        }
        this.name = aVar.f70528a;
        this.title = aVar.f70529b;
        this.url = aVar.f70530c;
        String str = aVar.f70531d;
        if (TextUtils.isEmpty(str)) {
            try {
                str = f.e();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        String str2 = aVar.f70532e;
        this.tempPath = str2;
        if (TextUtils.isEmpty(str2) && !f.h(str)) {
            this.tempPath = f.f();
        }
        if (aVar.X) {
            if (com.ss.android.socialbase.downloader.downloader.c.x().b(getId()) == null) {
                this.savePath = f.e(this.savePath, this.url);
                this.tempPath = f.e(this.tempPath, this.url);
            }
        } else {
            com.ss.android.socialbase.downloader.c.a.e(TAG, "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.extra = aVar.f70534g;
        this.onlyWifi = aVar.f70533f;
        this.extraHeaders = aVar.f70535h;
        this.maxBytes = aVar.f70536i;
        this.retryCount = aVar.l;
        this.backUpUrlRetryCount = aVar.m;
        this.force = aVar.n;
        this.outIp = aVar.j;
        this.outSize = aVar.k;
        this.needPostProgress = aVar.o;
        this.maxProgressCount = aVar.p;
        this.minProgressTimeMsInterval = aVar.q;
        this.backUpUrls = aVar.r;
        this.showNotification = aVar.s;
        this.mimeType = aVar.u;
        this.needHttpsToHttpRetry = aVar.v;
        this.needRetryDelay = aVar.D;
        this.retryDelayTimeArray = aVar.E;
        this.autoResumed = aVar.w;
        this.showNotificationForAutoResumed = aVar.x;
        this.needDefaultHttpServiceBackUp = aVar.y;
        this.needReuseChunkRunnable = aVar.z;
        this.packageName = aVar.A;
        this.md5 = aVar.B;
        this.needReuseFirstConnection = aVar.F;
        this.needIndependentProcess = aVar.G;
        this.enqueueType = aVar.H;
        this.headConnectionAvailable = aVar.I;
        this.ignoreDataVerify = aVar.J;
        this.addListenerToSameTask = aVar.O;
        this.needChunkDowngradeRetry = aVar.K;
        this.iconUrl = aVar.L;
        this.throttleNetSpeed = aVar.M;
        this.openLimitSpeed = aVar.N;
        JSONObject jSONObject = aVar.P;
        if (jSONObject != null) {
            safePutToDBJsonData("download_setting", jSONObject.toString());
        }
        safePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(aVar.C));
        safePutToDBJsonData("executor_group", Integer.valueOf(aVar.T));
        safePutToDBJsonData("auto_install", Integer.valueOf(aVar.t ? 1 : 0));
        this.needSDKMonitor = aVar.Q;
        this.monitorScene = aVar.R;
        this.extraMonitorStatus = aVar.S;
        this.expiredRedownload = aVar.U;
        this.deleteCacheIfCheckFailed = aVar.V;
        this.ttnetProtectTimeout = aVar.W;
        this.distinctDirectory = aVar.X;
        if (this.expiredRedownload && this.retryCount <= 0) {
            this.retryCount = 1;
        }
        putMonitorSetting();
    }

    public DownloadInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = g.f70109a;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.f70075a;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.f70081a;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    public DownloadInfo(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        boolean z = true;
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = g.f70109a;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.f70075a;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.f70081a;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                this.id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.name = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.title = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.savePath = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.tempPath = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                this.status = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.status = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.curBytes = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.curBytes = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.totalBytes = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.eTag = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                this.onlyWifi = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex(TTDownloadField.TT_FORCE);
            if (columnIndex13 != -1) {
                this.force = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.retryCount = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.extra = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.mimeType = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                this.showNotification = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.notificationVisibility = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                this.isFirstDownload = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                this.isFirstSuccess = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                this.needHttpsToHttpRetry = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.downloadTime = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("packageName");
            if (columnIndex23 != -1) {
                this.packageName = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(PackageTable.MD5);
            if (columnIndex24 != -1) {
                this.md5 = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                this.needRetryDelay = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i4 = cursor.getInt(columnIndex27);
                if (i4 == g.f70110b.ordinal()) {
                    this.retryDelayStatus = g.f70110b;
                } else if (i4 == g.f70111c.ordinal()) {
                    this.retryDelayStatus = g.f70111c;
                } else if (i4 == g.f70112d.ordinal()) {
                    this.retryDelayStatus = g.f70112d;
                } else {
                    this.retryDelayStatus = g.f70109a;
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                this.needDefaultHttpServiceBackUp = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                this.needReuseChunkRunnable = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.retryDelayTimeArray = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                this.needChunkDowngradeRetry = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                setBackUpUrlsStr(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.realDownloadTime = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.retryScheduleMinutes = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z = false;
                }
                this.needIndependentProcess = z;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.dbJsonDataString = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.iconUrl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.appVersionCode = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID);
            if (columnIndex40 != -1) {
                this.taskId = cursor.getString(columnIndex40);
            }
            parseMonitorSetting();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
