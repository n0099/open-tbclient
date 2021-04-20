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
import com.baidu.searchbox.pms.db.PackageTable;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.constants.h;
import com.ss.android.socialbase.downloader.exception.BaseException;
import d.o.a.e.b.f.j;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new a();
    public static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    public static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    public static final int RESERVE_STATUS_NEVER = 0;
    public static final int RESERVE_STATUS_NOW = 2;
    public static final int RESERVE_STATUS_ONCE = 1;
    public static final String TAG = "DownloadInfo";
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
    public long downloadTime;
    public String eTag;
    public f enqueueType;
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
    public boolean newSaveTempFileEnable;
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
    public h retryDelayStatus;
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
    public ConcurrentHashMap<String, Object> tempCacheData;
    public volatile List<j> tempFileSaveCompleteCallbacks;
    public String tempPath;
    public long throttleNetSpeed;
    public String title;
    public long totalBytes;
    public String url;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<DownloadInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    }

    public /* synthetic */ DownloadInfo(b bVar, a aVar) {
        this(bVar);
    }

    public long A() {
        n();
        try {
            return this.spData.optLong("cache-control/expired_time", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final int A0() {
        n();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean A1() {
        return this.needDefaultHttpServiceBackUp;
    }

    public void A2(int i) {
        this.httpStatusCode = i;
    }

    public int B() {
        return this.chunkCount;
    }

    public int B0() {
        return this.retryCount;
    }

    public boolean B1() {
        return this.needHttpsToHttpRetry;
    }

    public void B2(String str) {
        this.httpStatusMessage = str;
    }

    public String C() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.url;
        if (H0() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i = this.curBackUpUrlIndex) < 0 || i >= this.backUpUrls.size()) {
            return (!TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst("https", "http") : str;
        }
        String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public h C0() {
        return this.retryDelayStatus;
    }

    public boolean C1() {
        return this.needIndependentProcess;
    }

    public void C2(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public int D() {
        return this.curBackUpUrlIndex;
    }

    public String D0() {
        return this.retryDelayTimeArray;
    }

    public boolean D1() {
        return this.needPostProgress;
    }

    public void D2(int i) {
        this.id = i;
    }

    public long E() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int E0() {
        m();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public boolean E1() {
        return false;
    }

    public void E2(boolean z) {
        c2("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public int F() {
        return this.curRetryTime;
    }

    public String F0() {
        return this.savePath;
    }

    public boolean F1() {
        return this.needReuseChunkRunnable;
    }

    public synchronized void F2(boolean z) {
        this.isSaveTempFile = z;
    }

    public int G() {
        int i = this.curRetryTime;
        if (this.backUpUrlUsed) {
            int i2 = i + this.retryCount;
            int i3 = this.curBackUpUrlIndex;
            return i3 > 0 ? i2 + (i3 * this.backUpUrlRetryCount) : i2;
        }
        return i;
    }

    public int G0(String str) {
        n();
        return this.spData.optInt(str, 0);
    }

    public boolean G1() {
        return this.needReuseFirstConnection;
    }

    public void G2(long j) {
        n();
        try {
            this.spData.put("last_failed_resume_time", j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String H() {
        String jSONObject;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        m();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    public int H0() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            int i = atomicInteger.get();
            if (i == -5) {
                return -2;
            }
            return i;
        }
        return 0;
    }

    public boolean H1() {
        return this.needSDKMonitor;
    }

    public void H2(String str) {
        n();
        try {
            this.spData.put(Headers.LAST_MODIFIED, str);
            s3();
        } catch (Exception unused) {
        }
    }

    public String I(String str) {
        m();
        return this.dbJsonData.optString(str);
    }

    public int I0() {
        return this.statusAtDbInit;
    }

    public boolean I1() {
        return this.newSaveTempFileEnable;
    }

    public void I2() {
        this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
    }

    public long J() {
        m();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
    }

    public int J0() {
        m();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public boolean J1() {
        return H0() == 0;
    }

    public void J2(long j) {
        n();
        try {
            this.spData.put("last_unins_resume_time", j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String K() {
        m();
        return this.dbJsonData.optString("download_setting");
    }

    public String K0() {
        return e.l(this.savePath, this.name);
    }

    public boolean K1() {
        return this.onlyWifi;
    }

    public void K2(int i) {
        c2("link_mode", Integer.valueOf(i));
    }

    public double L() {
        double E = E() / 1048576.0d;
        double y0 = y0() / 1000.0d;
        if (E <= 0.0d || y0 <= 0.0d) {
            return -1.0d;
        }
        return E / y0;
    }

    public ConcurrentHashMap<String, Object> L0() {
        o();
        return this.tempCacheData;
    }

    public boolean L1() {
        return (A0() & 2) > 0;
    }

    public void L2(String str) {
        this.md5 = str;
    }

    public long M() {
        return this.downloadTime;
    }

    public String M0() {
        return e.l0(this.name);
    }

    public boolean M1() {
        if (this.mDownloadFromReserveWifi) {
            return L1() && e.d0(d.l());
        }
        return true;
    }

    public void M2(String str) {
        this.mimeType = str;
    }

    public f N() {
        return this.enqueueType;
    }

    public String N0() {
        return e.X(this.savePath, this.tempPath);
    }

    public boolean N1() {
        m();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public void N2(String str) {
        this.name = str;
    }

    public String O() {
        StringBuffer stringBuffer = this.errorBytesLog;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
    }

    public long O0() {
        return this.throttleNetSpeed;
    }

    public boolean O1() {
        m();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
    }

    public void O2(String str) {
        this.networkQuality = str;
    }

    public int P() {
        m();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public String P0() {
        if (TextUtils.isEmpty(this.title)) {
            return this.name;
        }
        return this.title;
    }

    public synchronized boolean P1() {
        return this.isSaveTempFile;
    }

    public void P2(int i) {
        this.notificationVisibility = i;
    }

    public long Q() {
        m();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
    }

    public long Q0() {
        return this.totalBytes;
    }

    public boolean Q1() {
        return this.showNotification;
    }

    public void Q2(boolean z) {
        this.onlyWifi = z;
    }

    public String R() {
        return this.extra;
    }

    public int R0() {
        int i = this.retryCount;
        List<String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i : i + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public boolean R1() {
        return this.showNotificationForNetworkResumed;
    }

    public void R2(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public List<c> S() {
        return this.extraHeaders;
    }

    public int S0() {
        n();
        return this.spData.optInt("unins_resume_count", 0);
    }

    public boolean S1() {
        return this.successByCache;
    }

    public void S2(String str) {
        this.packageName = str;
    }

    public int[] T() {
        return this.extraMonitorStatus;
    }

    public String T0() {
        return this.url;
    }

    public final void T1(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        m();
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
        U1();
    }

    public void T2(int i) {
        n();
        try {
            this.spData.put("paused_resume_count", i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public BaseException U() {
        return this.failedException;
    }

    public String U0() {
        return this.eTag;
    }

    public final void U1() {
        m();
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray optJSONArray = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.extraMonitorStatus = new int[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            this.extraMonitorStatus[i] = optJSONArray.optInt(i);
        }
    }

    public void U2(int i) {
        m();
        c2("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    public int V() {
        n();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public synchronized void V0(boolean z, BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks == null) {
            return;
        }
        d.o.a.e.b.c.a.g(TAG, "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
        for (j jVar : this.tempFileSaveCompleteCallbacks) {
            if (jVar != null) {
                if (z) {
                    jVar.a();
                } else {
                    jVar.a(baseException);
                }
            }
        }
    }

    public final void V1() {
        c2("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        c2("monitor_scene", this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.extraMonitorStatus != null && this.extraMonitorStatus.length > 0) {
                for (int i = 0; i < this.extraMonitorStatus.length; i++) {
                    jSONArray.put(this.extraMonitorStatus[i]);
                }
            }
            c2("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void V2(h hVar) {
        this.retryDelayStatus = hVar;
    }

    public String W() {
        return this.filePackageName;
    }

    public boolean W0() {
        List<String> list = this.backUpUrls;
        if (list != null && list.size() > 0) {
            if (!this.backUpUrlUsed) {
                return true;
            }
            int i = this.curBackUpUrlIndex;
            if (i >= 0 && i < this.backUpUrls.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public void W1(Parcel parcel) {
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
        k(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        n2(parcel.readLong());
        this.totalBytes = parcel.readLong();
        a3(parcel.readInt());
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
        j(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.newSaveTempFileEnable = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        U1();
    }

    public void W2(int i) {
        c2("retry_schedule_count", Integer.valueOf(i));
    }

    public long X() {
        m();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
    }

    public boolean X0() {
        return (A0() & 1) > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public final void X1(boolean z) {
        List<String> list = this.forbiddenBackupUrls;
        if (list == null || list.size() <= z) {
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
        for (int i = z; i < this.forbiddenBackupUrls.size(); i++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i));
        }
    }

    public void X2(boolean z) {
        c2("is_save_path_redirected", Boolean.valueOf(z));
    }

    public List<String> Y() {
        return this.forbiddenBackupUrls;
    }

    public void Y0(long j) {
        if (j > 0) {
            r();
            c2("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(j)));
        }
    }

    public synchronized void Y1(j jVar) {
        if (jVar == null) {
            return;
        }
        try {
            d.o.a.e.b.c.a.g(TAG, "registerTempFileSaveCallback");
            if (this.tempFileSaveCompleteCallbacks == null) {
                this.tempFileSaveCompleteCallbacks = new ArrayList();
            }
            if (!this.tempFileSaveCompleteCallbacks.contains(jVar)) {
                this.tempFileSaveCompleteCallbacks.add(jVar);
            }
        } finally {
        }
    }

    public void Y2(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public String Z() {
        return this.headConnectionException;
    }

    public void Z0(long j) {
        this.curBytes.addAndGet(j);
    }

    public void Z1() {
        o2(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void Z2(String str, String str2) {
        n();
        try {
            this.spData.put(str, str2);
            s3();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.chunkCount);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, H0());
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, E());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, this.totalBytes);
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, this.onlyWifi ? 1L : 0L);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.force ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.retryCount);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        sQLiteStatement.bindLong(i17, this.showNotification ? 1L : 0L);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.notificationVisibility);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.isFirstDownload ? 1L : 0L);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstSuccess ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.needHttpsToHttpRetry ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.downloadTime);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        sQLiteStatement.bindLong(i25, this.needRetryDelay ? 1L : 0L);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.curRetryTime);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, this.retryDelayStatus.ordinal());
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.needReuseChunkRunnable ? 1L : 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i30, str11);
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        sQLiteStatement.bindLong(i31, this.needChunkDowngradeRetry ? 1L : 0L);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindString(i32, x());
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindLong(i33, this.backUpUrlRetryCount);
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.realDownloadTime);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, this.retryScheduleMinutes);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.needIndependentProcess ? 1L : 0L);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindString(i37, H());
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        String str12 = this.iconUrl;
        sQLiteStatement.bindString(i38, str12 != null ? str12 : "");
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        sQLiteStatement.bindLong(i39, this.appVersionCode);
    }

    public int a0() {
        return this.httpStatusCode;
    }

    public void a1(long j) {
        if (j > 0) {
            c2("dbjson_key_download_prepare_time", Long.valueOf(J() + j));
        }
    }

    public void a2(String str) {
        o2(0L, true);
        g3(0L);
        i3(str);
        l2(1);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void a3(int i) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.status = new AtomicInteger(i);
        }
    }

    public boolean b() {
        long j = this.lastNotifyProgressTime.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public String b0() {
        return this.iconUrl;
    }

    public boolean b1() {
        return this.addListenerToSameTask;
    }

    public void b2() {
        this.realStartDownloadTime = 0L;
    }

    public void b3(int i) {
        this.statusAtDbInit = i;
    }

    public boolean c() {
        return H0() != -3 && this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING;
    }

    public int c0() {
        if (this.id == 0) {
            this.id = d.r(this);
        }
        return this.id;
    }

    public boolean c1() {
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

    public void c2(String str, Object obj) {
        m();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    public void c3(boolean z) {
        this.successByCache = z;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public boolean d0() {
        return this.isFirstDownload;
    }

    public boolean d1() {
        return this.autoResumed;
    }

    public void d2(int i) {
        c2("anti_hijack_error_code", Integer.valueOf(i));
    }

    public void d3(boolean z) {
        this.supportPartial = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return (!this.autoResumed && this.showNotification) || (this.autoResumed && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed));
    }

    public long e0() {
        m();
        return this.dbJsonData.optLong("dbjson_last_start_download_time", 0L);
    }

    public boolean e1() {
        return this.backUpUrlUsed;
    }

    public void e2(int i) {
        this.appVersionCode = i;
    }

    public void e3(int i) {
        c2("ttmd5_check_status", Integer.valueOf(i));
    }

    public boolean f() {
        com.ss.android.socialbase.downloader.constants.a aVar;
        int H0 = H0();
        return H0 == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING || H0 == 8 || (aVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING || aVar == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public long f0() {
        n();
        return this.spData.optLong("last_failed_resume_time", 0L);
    }

    public boolean f1() {
        if (r1()) {
            return h1();
        }
        return false;
    }

    public void f2(com.ss.android.socialbase.downloader.constants.a aVar) {
        this.asyncHandleStatus = aVar;
    }

    public void f3(long j) {
        this.throttleNetSpeed = j;
    }

    public boolean g() {
        return E1() && H0() != -3 && this.retryDelayStatus == h.DELAY_RETRY_WAITING;
    }

    public String g0() {
        n();
        try {
            return this.spData.optString(Headers.LAST_MODIFIED, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean g1() {
        int H0 = H0();
        if (H0 == 4 || H0 == 3 || H0 == -1 || H0 == 5 || H0 == 8) {
            return true;
        }
        return (H0 == 1 || H0 == 2) && E() > 0;
    }

    public void g2(boolean z) {
        this.autoResumed = z;
    }

    public void g3(long j) {
        this.totalBytes = j;
    }

    public void h() {
        com.ss.android.socialbase.downloader.constants.a aVar;
        int H0 = H0();
        if (H0 == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING) {
            V2(h.DELAY_RETRY_DOWNLOADING);
        }
        if (H0 == 8 || (aVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING || aVar == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART) {
            f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART) {
            i2(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public long h0() {
        n();
        return this.spData.optLong("last_unins_resume_time", 0L);
    }

    public boolean h1() {
        d.o.a.e.b.g.j I0;
        if (this.chunkCount > 1 && (I0 = d.I0()) != null) {
            List<com.ss.android.socialbase.downloader.model.b> c2 = I0.c(c0());
            if (c2 == null || c2.size() != this.chunkCount) {
                return false;
            }
            long j = 0;
            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                if (bVar != null) {
                    j += bVar.B();
                }
            }
            if (j != E()) {
                n2(j);
            }
        }
        return true;
    }

    public final void h2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
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

    public void h3(int i) {
        n();
        try {
            this.spData.put("unins_resume_count", i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int i() {
        return e.R(F0(), q0(), this.md5);
    }

    public int i0() {
        m();
        return this.dbJsonData.optInt("link_mode");
    }

    public boolean i1() {
        return this.chunkDowngradeRetryUsed;
    }

    public void i2(com.ss.android.socialbase.downloader.constants.b bVar) {
        this.byteInvalidRetryStatus = bVar;
    }

    public void i3(String str) {
        this.eTag = str;
    }

    public final void j(int i) {
        if (i == f.ENQUEUE_HEAD.ordinal()) {
            this.enqueueType = f.ENQUEUE_HEAD;
        } else if (i == f.ENQUEUE_TAIL.ordinal()) {
            this.enqueueType = f.ENQUEUE_TAIL;
        } else {
            this.enqueueType = f.ENQUEUE_NONE;
        }
    }

    public int j0() {
        return this.maxBytes;
    }

    public boolean j1() {
        return e.c0(this.totalBytes);
    }

    public void j2(String str) {
        n();
        try {
            this.spData.put(Headers.CACHE_CONTROL, str);
            s3();
        } catch (Exception unused) {
        }
    }

    public void j3() {
        n();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            s3();
        } catch (Exception unused) {
        }
    }

    public final void k(int i) {
        if (i == h.DELAY_RETRY_WAITING.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_WAITING;
        } else if (i == h.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADING;
        } else if (i == h.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADED;
        } else {
            this.retryDelayStatus = h.DELAY_RETRY_NONE;
        }
    }

    public int k0() {
        return this.maxProgressCount;
    }

    public boolean k1() {
        return this.deleteCacheIfCheckFailed;
    }

    public void k2(long j) {
        n();
        try {
            this.spData.put("cache-control/expired_time", j);
            s3();
        } catch (Exception unused) {
        }
    }

    public boolean k3() {
        return z0() == -2 || z0() == -5;
    }

    public void l(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        l2(downloadInfo.B());
        g3(downloadInfo.Q0());
        o2(downloadInfo.E(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (!downloadInfo.f() && !f()) {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        } else {
            this.curRetryTime = downloadInfo.F();
        }
        i3(downloadInfo.U0());
        if (z) {
            a3(downloadInfo.H0());
        }
        this.isFirstDownload = downloadInfo.d0();
        this.isFirstSuccess = downloadInfo.t1();
        this.retryDelayStatus = downloadInfo.C0();
        T1(downloadInfo.dbJsonData);
    }

    public String l0() {
        return this.md5;
    }

    public boolean l1() {
        return this.mDownloadFromReserveWifi;
    }

    public void l2(int i) {
        this.chunkCount = i;
    }

    public void l3() {
        n();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            s3();
        } catch (Exception unused) {
        }
    }

    public final void m() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                        this.dbJsonData = new JSONObject(this.dbJsonDataString);
                    } else {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    public String m0() {
        return this.mimeType;
    }

    public boolean m1() {
        return d.o.a.e.b.d.a.a(H0());
    }

    public void m2(boolean z) {
        this.chunkDowngradeRetryUsed = z;
    }

    public ContentValues m3() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put("url", this.url);
        contentValues.put("savePath", this.savePath);
        contentValues.put("tempPath", this.tempPath);
        contentValues.put("name", this.name);
        contentValues.put("chunkCount", Integer.valueOf(this.chunkCount));
        contentValues.put("status", Integer.valueOf(H0()));
        contentValues.put("curBytes", Long.valueOf(E()));
        contentValues.put("totalBytes", Long.valueOf(this.totalBytes));
        contentValues.put("eTag", this.eTag);
        contentValues.put("onlyWifi", Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.force ? 1 : 0));
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
        contentValues.put("backUpUrlsStr", x());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put("realDownloadTime", Long.valueOf(this.realDownloadTime));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put("independentProcess", Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", H());
        contentValues.put("iconUrl", this.iconUrl);
        contentValues.put("appVersionCode", Integer.valueOf(this.appVersionCode));
        return contentValues;
    }

    public final void n() {
        if (this.spData == null) {
            Context l = d.l();
            if (l != null) {
                String string = l.getSharedPreferences("sp_download_info", 0).getString(Long.toString(c0()), "");
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

    public long n0(long j) {
        int i = this.maxProgressCount;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / (i + 1);
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public boolean n1() {
        return !K1() || e.d0(d.l());
    }

    public void n2(long j) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.curBytes = new AtomicLong(j);
        }
    }

    public boolean n3() {
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

    public final void o() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public int o0() {
        int i = this.minProgressTimeMsInterval;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean o1() {
        return e.r0(this);
    }

    public void o2(long j, boolean z) {
        if (z) {
            n2(j);
        } else if (j > E()) {
            n2(j);
        }
    }

    public void o3(int i) {
        int i2 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i;
        this.curRetryTime = i2;
        if (i2 < 0) {
            this.curRetryTime = 0;
        }
    }

    public boolean p(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.T0()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.F0())) ? false : true;
    }

    public String p0() {
        return this.monitorScene;
    }

    public boolean p1() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public void p2(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public void p3() {
        if (this.startDownloadTime == 0) {
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

    public void q() {
        o2(0L, true);
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

    public String q0() {
        return this.name;
    }

    public boolean q1() {
        return this.expiredRedownload;
    }

    public void q2(BaseException baseException) {
        this.failedException = baseException;
    }

    public void q3(boolean z) {
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

    public long r() {
        m();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
        }
        return this.allConnectTime.get();
    }

    public String r0() {
        return this.networkQuality;
    }

    public boolean r1() {
        if (p1()) {
            return false;
        }
        File file = new File(N0(), M0());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long E = E();
            if (d.o.a.e.b.j.a.r().l("fix_file_data_valid")) {
                if (E > 0) {
                    long j = this.totalBytes;
                    if (j > 0 && this.chunkCount > 0 && length >= E && length <= j) {
                        return true;
                    }
                }
                d.o.a.e.b.c.a.i(TAG, "isFileDataValid: cur = " + E + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && E > 0) {
                long j2 = this.totalBytes;
                if (j2 > 0 && this.chunkCount > 0 && length >= E && length <= j2 && E < j2) {
                    return true;
                }
            }
            d.o.a.e.b.c.a.i(TAG, "isFileDataValid: cur = " + E + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        }
        return false;
    }

    public void r2(int i) {
        n();
        try {
            this.spData.put("failed_resume_count", i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void r3() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public int s(int i) {
        m();
        return this.dbJsonData.optInt("anti_hijack_error_code", i);
    }

    public int s0() {
        return this.notificationVisibility;
    }

    public boolean s1() {
        if (!this.isFirstDownload || TextUtils.isEmpty(N0()) || TextUtils.isEmpty(M0())) {
            return false;
        }
        return !new File(N0(), M0()).exists();
    }

    public void s2(String str) {
        this.filePackageName = str;
    }

    public void s3() {
        Context l;
        if (this.spData == null || (l = d.l()) == null) {
            return;
        }
        l.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(c0()), this.spData.toString()).apply();
    }

    public int t() {
        return this.appVersionCode;
    }

    public boolean t0() {
        return this.openLimitSpeed;
    }

    public boolean t1() {
        return this.isFirstSuccess;
    }

    public void t2(boolean z) {
        this.isFirstDownload = z;
    }

    public void t3() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        c2("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public com.ss.android.socialbase.downloader.constants.a u() {
        return this.asyncHandleStatus;
    }

    public PackageInfo u0() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public boolean u1() {
        return this.isForbiddenRetryed;
    }

    public void u2(long j) {
        c2("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public int v() {
        return this.backUpUrlRetryCount;
    }

    public String v0() {
        return this.packageName;
    }

    public boolean v1() {
        return this.force;
    }

    public void v2(boolean z) {
        this.isFirstSuccess = z;
    }

    public List<String> w() {
        return this.backUpUrls;
    }

    public int w0() {
        n();
        return this.spData.optInt("paused_resume_count", 0);
    }

    public boolean w1() {
        return this.headConnectionAvailable;
    }

    public void w2(List<String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        X1(z);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
        parcel.writeLong(E());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(z0());
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
        parcel.writeByte(this.newSaveTempFileEnable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(H());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
    }

    public final String x() {
        List<String> list;
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

    public int x0() {
        m();
        return this.dbJsonData.optInt("dbjson_key_preconnect_level", 0);
    }

    public boolean x1() {
        return this.httpsToHttpRetryUsed;
    }

    public void x2() {
        this.isForbiddenRetryed = true;
    }

    public int y() {
        return this.bindValueCount;
    }

    public long y0() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public boolean y1() {
        return this.ignoreDataVerify;
    }

    public void y2(boolean z) {
        this.forceIgnoreRecommendSize = z;
    }

    public com.ss.android.socialbase.downloader.constants.b z() {
        return this.byteInvalidRetryStatus;
    }

    public int z0() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean z1() {
        return this.needChunkDowngradeRetry;
    }

    public void z2(String str) {
        this.headConnectionException = str;
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public String A;
        public long B;
        public boolean C;
        public String D;
        public boolean E;
        public boolean F;
        public boolean H;
        public boolean I;
        public boolean J;
        public String K;
        public long L;
        public boolean M;
        public boolean O;
        public JSONObject P;
        public String R;
        public int[] S;
        public int T;
        public boolean U;
        public boolean V;

        /* renamed from: a  reason: collision with root package name */
        public String f39211a;

        /* renamed from: b  reason: collision with root package name */
        public String f39212b;

        /* renamed from: c  reason: collision with root package name */
        public String f39213c;

        /* renamed from: d  reason: collision with root package name */
        public String f39214d;

        /* renamed from: e  reason: collision with root package name */
        public String f39215e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f39216f;

        /* renamed from: g  reason: collision with root package name */
        public String f39217g;

        /* renamed from: h  reason: collision with root package name */
        public List<c> f39218h;
        public int i;
        public String[] j;
        public int[] k;
        public int l;
        public int m;
        public boolean n;
        public int p;
        public int q;
        public List<String> r;
        public boolean s;
        public String t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean y;
        public String z;
        public boolean o = true;
        public boolean x = true;
        public f G = f.ENQUEUE_NONE;
        public boolean N = true;
        public boolean Q = true;

        public b() {
        }

        public b A(JSONObject jSONObject) {
            this.P = jSONObject;
            return this;
        }

        public b B(boolean z) {
            this.f39216f = z;
            return this;
        }

        public DownloadInfo C() {
            return new DownloadInfo(this, null);
        }

        public b E(int i) {
            this.l = i;
            return this;
        }

        public b F(long j) {
            this.L = j;
            return this;
        }

        public b G(String str) {
            this.f39212b = str;
            return this;
        }

        public b H(List<String> list) {
            this.r = list;
            return this;
        }

        public b I(boolean z) {
            this.n = z;
            return this;
        }

        public b J(int[] iArr) {
            this.S = iArr;
            return this;
        }

        public b L(int i) {
            this.m = i;
            return this;
        }

        public b M(String str) {
            this.f39213c = str;
            return this;
        }

        public b O(int i) {
            this.p = i;
            return this;
        }

        public b P(String str) {
            this.f39214d = str;
            return this;
        }

        public b Q(boolean z) {
            this.u = z;
            return this;
        }

        public b S(int i) {
            this.q = i;
            return this;
        }

        public b T(boolean z) {
            this.s = z;
            return this;
        }

        public b V(int i) {
            this.T = i;
            return this;
        }

        public b W(String str) {
            this.f39217g = str;
            return this;
        }

        public b X(boolean z) {
            this.v = z;
            return this;
        }

        public b Z(String str) {
            this.t = str;
            return this;
        }

        public b a0(boolean z) {
            this.w = z;
            return this;
        }

        public b c0(String str) {
            this.z = str;
            return this;
        }

        public b d0(boolean z) {
            this.x = z;
            return this;
        }

        public b g0(String str) {
            this.A = str;
            return this;
        }

        public b h0(boolean z) {
            this.y = z;
            return this;
        }

        public b j0(String str) {
            this.D = str;
            return this;
        }

        public b k0(boolean z) {
            this.C = z;
            return this;
        }

        public b m0(String str) {
            this.R = str;
            return this;
        }

        public b n0(boolean z) {
            this.E = z;
            return this;
        }

        public b o0(String str) {
            this.K = str;
            return this;
        }

        public b p0(boolean z) {
            this.F = z;
            return this;
        }

        public b r0(boolean z) {
            this.H = z;
            return this;
        }

        public b u0(boolean z) {
            this.J = z;
            return this;
        }

        public b w(long j) {
            this.B = j;
            return this;
        }

        public b x(f fVar) {
            this.G = fVar;
            return this;
        }

        public b y(String str) {
            this.f39211a = str;
            return this;
        }

        public b y0(boolean z) {
            this.Q = z;
            return this;
        }

        public b z(List<c> list) {
            this.f39218h = list;
            return this;
        }

        public b(String str) {
            this.f39213c = str;
        }
    }

    public DownloadInfo(b bVar) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
        if (bVar == null) {
            return;
        }
        this.name = bVar.f39211a;
        this.title = bVar.f39212b;
        this.url = bVar.f39213c;
        String str = bVar.f39214d;
        if (TextUtils.isEmpty(str)) {
            try {
                str = e.E0();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        this.tempPath = bVar.f39215e;
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.extra = bVar.f39217g;
        this.onlyWifi = bVar.f39216f;
        this.extraHeaders = bVar.f39218h;
        this.maxBytes = bVar.i;
        this.retryCount = bVar.l;
        this.backUpUrlRetryCount = bVar.m;
        this.force = bVar.n;
        this.outIp = bVar.j;
        this.outSize = bVar.k;
        this.needPostProgress = bVar.o;
        this.maxProgressCount = bVar.p;
        this.minProgressTimeMsInterval = bVar.q;
        this.backUpUrls = bVar.r;
        this.showNotification = bVar.s;
        this.mimeType = bVar.t;
        this.needHttpsToHttpRetry = bVar.u;
        this.needRetryDelay = bVar.C;
        this.retryDelayTimeArray = bVar.D;
        this.autoResumed = bVar.v;
        this.showNotificationForAutoResumed = bVar.w;
        this.needDefaultHttpServiceBackUp = bVar.x;
        this.needReuseChunkRunnable = bVar.y;
        this.packageName = bVar.z;
        this.md5 = bVar.A;
        this.needReuseFirstConnection = bVar.E;
        this.needIndependentProcess = bVar.F;
        this.enqueueType = bVar.G;
        this.headConnectionAvailable = bVar.H;
        this.ignoreDataVerify = bVar.I;
        this.newSaveTempFileEnable = bVar.N;
        this.addListenerToSameTask = bVar.O;
        this.needChunkDowngradeRetry = bVar.J;
        this.iconUrl = bVar.K;
        this.throttleNetSpeed = bVar.L;
        this.openLimitSpeed = bVar.M;
        JSONObject jSONObject = bVar.P;
        if (jSONObject != null) {
            c2("download_setting", jSONObject.toString());
        }
        c2("dbjson_key_expect_file_length", Long.valueOf(bVar.B));
        c2("executor_group", Integer.valueOf(bVar.T));
        this.needSDKMonitor = bVar.Q;
        this.monitorScene = bVar.R;
        this.extraMonitorStatus = bVar.S;
        this.expiredRedownload = bVar.U;
        this.deleteCacheIfCheckFailed = bVar.V;
        V1();
    }

    public DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.newSaveTempFileEnable = true;
        this.isAutoInstallWithoutNotification = null;
        W1(parcel);
    }

    public DownloadInfo(Cursor cursor) {
        boolean z = true;
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = f.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.newSaveTempFileEnable = true;
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
            int columnIndex13 = cursor.getColumnIndex("force");
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
                int i = cursor.getInt(columnIndex27);
                if (i == h.DELAY_RETRY_WAITING.ordinal()) {
                    this.retryDelayStatus = h.DELAY_RETRY_WAITING;
                } else if (i == h.DELAY_RETRY_DOWNLOADING.ordinal()) {
                    this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADING;
                } else if (i == h.DELAY_RETRY_DOWNLOADED.ordinal()) {
                    this.retryDelayStatus = h.DELAY_RETRY_DOWNLOADED;
                } else {
                    this.retryDelayStatus = h.DELAY_RETRY_NONE;
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
                h2(cursor.getString(columnIndex32));
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
            U1();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
