package d.a.n.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.basic.LogSystemServiceUtil;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.util.SnapshotUtil;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Supplier<List<ProcessEventSceneHandler>> f64019a;

    /* renamed from: b  reason: collision with root package name */
    public String f64020b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64021c;

    /* renamed from: d  reason: collision with root package name */
    public long f64022d;

    public b(@NonNull Context context) {
        if (context instanceof Application) {
            this.f64021c = context;
        } else {
            this.f64021c = context.getApplicationContext();
        }
        this.f64020b = d.a.c0.b.a.a.b();
        this.f64022d = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            b();
        }
    }

    @NonNull
    public final ForwardingProcessEventSceneHandler a() {
        ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
        if (Build.VERSION.SDK_INT > 19) {
            forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
        }
        Supplier<List<ProcessEventSceneHandler>> supplier = this.f64019a;
        if (supplier != null && Build.VERSION.SDK_INT > 19) {
            forwardingProcessEventSceneHandler.addEventHandleCallback(supplier.get());
        }
        return forwardingProcessEventSceneHandler;
    }

    public final void b() {
        DefaultProcessEventSceneHandler.init();
        LogType.init();
        SnapshotUtil.init();
        LogFile.init();
        ProcessSnapshotType.init();
        Utility.init();
        LogPipelineSingleton.init();
        LokiService.init();
        LogExtra.init();
        LogDiskStoreConfig.init();
        CrashUtil.init();
        LogSystemServiceUtil.init();
    }

    public void c(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public void d() {
    }

    public void e(@NonNull Context context) {
    }

    public void f(@NonNull String str, @NonNull String str2) {
    }

    public void g(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        LogSystemServiceUtil.startLogHandlerService(context, LogType.NATIVE_CRASH, str, file, logExtra);
    }

    public final void h(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.f64020b);
        if (!obtainFileDirWithProcessName.exists()) {
            obtainFileDirWithProcessName.mkdirs();
        }
        JSONObject jSONObject = new JSONObject();
        c(this.f64021c, jSONObject);
        logExtra.mJSONAttach = jSONObject.toString();
        ForwardingProcessEventSceneHandler a2 = a();
        File file = null;
        if (a2 != null) {
            hashSet = new HashSet(5);
            EventObject eventObject = new EventObject(LogType.NATIVE_CRASH, str);
            Set<ProcessSnapshotType> requireGeneralSnapshots = a2.requireGeneralSnapshots(this.f64021c, eventObject);
            if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.f64021c, requireGeneralSnapshots, obtainFileDirWithProcessName, this.f64020b, logExtra)) != null && obtainProcessSnapShots.size() > 0) {
                hashSet.addAll(obtainProcessSnapShots);
            }
            Set<LogFile> customizedSnapshots = a2.getCustomizedSnapshots(this.f64021c, obtainFileDirWithProcessName, eventObject);
            if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                hashSet.addAll(customizedSnapshots);
            }
            LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.f64021c, a2, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
            if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                hashSet.add(obtainFragmentSnapShot);
            }
            if (LLog.sDebug) {
                if (hashSet.size() > 0) {
                    Log.d("loki-native-NativeCrashHandler", "uploadLogFiles.size() = " + hashSet.size());
                    for (int i2 = 0; i2 < hashSet.size(); i2++) {
                    }
                } else {
                    Log.d("loki-native-NativeCrashHandler", "uploadLogFiles is null or uploadLogFiles.size() = 0");
                }
            }
        } else {
            hashSet = null;
        }
        e(this.f64021c);
        if (hashSet != null) {
            file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
            if (LLog.sDebug && file != null) {
                Log.d("loki-native-NativeCrashHandler", "pathNameKeeper = " + file.getAbsolutePath());
            }
        }
        g(this.f64021c, str, file, logExtra);
    }

    public void i(@NonNull String str, int i2, int i3) {
        Log.d("loki-native-NativeCrashHandler", str);
        LogExtra logExtra = new LogExtra();
        TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
        if (lastTrackUI != null) {
            if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                logExtra.mPage = lastTrackUI.getFragmentPage();
            } else {
                logExtra.mPage = lastTrackUI.getActivityPage();
            }
        }
        logExtra.mCrashTime = String.valueOf(System.currentTimeMillis());
        logExtra.mLaunchTime = String.valueOf(this.f64022d);
        if (DeviceUtil.OSInfo.hasNougat()) {
            logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - Utility.getProcessStartElapsedRealTime());
        }
        logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
        logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
        try {
            h(str, logExtra);
        } catch (Throwable th) {
            if (LLog.sDebug) {
                th.printStackTrace();
            }
        }
    }
}
