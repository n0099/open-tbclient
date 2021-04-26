package d.a.j0.c0;

import android.app.Activity;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnAnrCrashListener;
import com.baidu.crabsdk.OnCrashExceedListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.NativeCrashHandler;
import d.a.c.e.p.j;
import d.a.j0.i3.a;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements a.InterfaceC1317a {

    /* renamed from: d  reason: collision with root package name */
    public String f51568d;

    /* renamed from: e  reason: collision with root package name */
    public String f51569e;

    /* renamed from: f  reason: collision with root package name */
    public String f51570f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51565a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51566b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51567c = false;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f51571g = new C1147a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f51572h = new b(this, 2001371);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f51573i = new c(2000994);

    /* renamed from: d.a.j0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1147a extends CustomMessageListener {
        public C1147a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            a.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(a aVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            CrabSdkSwitch.isOn();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError()) {
                return;
            }
            a.this.r();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements OnCrashExceedListener {
        public d(a aVar) {
        }

        @Override // com.baidu.crabsdk.OnCrashExceedListener
        public void onCrashExceedCallback() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements OnAnrCrashListener {
        public e() {
        }

        @Override // com.baidu.crabsdk.OnAnrCrashListener
        public void onAnrStarted(Map map) {
            a.this.p();
            a.this.s(null);
        }

        @Override // com.baidu.crabsdk.OnAnrCrashListener
        public void onCrashStarted(Thread thread, Throwable th) {
            a.this.p();
            a.this.s(th);
        }

        @Override // com.baidu.crabsdk.OnAnrCrashListener
        public void onNativeCrashStarted(String str) {
            a.this.p();
            a.this.s(null);
        }
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void a(Application application) {
        MessageManager.getInstance().registerListener(this.f51572h);
        MessageManager.getInstance().registerListener(this.f51571g);
        MessageManager.getInstance().registerListener(this.f51573i);
        if (this.f51565a) {
            return;
        }
        l(application);
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void b(Exception exc) {
        if (!this.f51565a || exc == null) {
            return;
        }
        CrabSDK.uploadException(exc);
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void c(String str) {
        this.f51570f = str;
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void d(String str) {
        this.f51569e = str;
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void e(String str) {
        this.f51568d = str;
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void f(MotionEvent motionEvent, Activity activity) {
        if (!this.f51565a || activity == null || motionEvent == null) {
            return;
        }
        CrabSDK.behaviorRecordEvent(motionEvent, activity);
    }

    public final void h() {
        if (this.f51565a && this.f51567c) {
            CrabSDK.closeAnrHandler();
        }
    }

    public final void i() {
        if (this.f51565a && this.f51566b) {
            CrabSDK.disableBlockCatch();
        }
    }

    public final String j(Throwable th) {
        StringBuilder sb = new StringBuilder();
        try {
            if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                while (it.hasNext()) {
                    Plugin next = it.next();
                    if (next != null) {
                        PluginSetting P = PluginPackageManager.O().P(next.getPackageName());
                        sb.append(next.getPackageName());
                        sb.append("-");
                        sb.append(next.getCurrentPluginMode());
                        sb.append("-");
                        if (P != null) {
                            sb.append(new File(P.apkPath).exists());
                            sb.append("-");
                            sb.append(next.getVersionCode());
                            sb.append("-");
                            sb.append(P.tempVersionCode);
                            sb.append("-");
                            if (P.enable) {
                                sb.append("true");
                            } else {
                                sb.append("false");
                            }
                        } else {
                            sb.append(StringUtil.NULL_STRING);
                        }
                        sb.append(",");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (th == null) {
            return "--pluginInfo-" + sb.toString();
        }
        boolean z = false;
        StringBuilder sb2 = new StringBuilder();
        String str = "";
        try {
            if (th.getMessage() != null && (th.getMessage().contains("java.lang.ClassNotFoundException") || th.getMessage().contains("java.lang.NoClassDefFoundError"))) {
                z = true;
                PluginSettings l = d.a.c.h.j.g.d.k().l();
                if (l != null) {
                    sb2.append(l.getContainerVersion());
                    sb2.append("-");
                    sb2.append(l.getForbiddenFeatures());
                    sb2.append("#");
                    for (PluginSetting pluginSetting : l.getPlugins().values()) {
                        if (pluginSetting != null) {
                            sb2.append(pluginSetting.packageName);
                            sb2.append("-");
                            sb2.append(pluginSetting.versionCode);
                            sb2.append("-");
                            sb2.append(pluginSetting.tempVersionCode);
                            sb2.append("-");
                            sb2.append(pluginSetting.enable);
                            sb2.append("-");
                            sb2.append(pluginSetting.forbidden);
                            sb2.append("-");
                            sb2.append(pluginSetting.installStatus);
                            sb2.append("-");
                            sb2.append(new File(pluginSetting.apkPath).exists());
                            sb2.append(";");
                        }
                    }
                } else {
                    sb2.append("pluginSettings_is_null");
                }
                str = d.a.c.h.h.b.c().toString();
            }
        } catch (Exception unused2) {
        }
        String str2 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + d.a.c.a.b.f().c();
        if (z) {
            return str2 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str;
        }
        return str2;
    }

    public final String k() {
        return BdBaseApplication.getInst().isDebugMode() ? "DebugBuild" : o() ? "ReleasedBuild" : n() ? "GrayBuild" : m() ? "DailyBuild" : "DefaultBuild";
    }

    public final boolean l(Application application) {
        try {
            CrabSDK.setConstantSameCrashExceedLimit(3);
            CrabSDK.setOnCrashExceedListener(new d(this));
            boolean isDebugMode = BdBaseApplication.getInst().isDebugMode();
            String version = TbConfig.getVersion();
            if (!TextUtils.isEmpty(version)) {
                CrabSDK.setAppVersionName(version);
            }
            if (isDebugMode) {
                CrabSDK.init(application, "ef986e35b4f9ccc5");
            } else {
                CrabSDK.init(application, "b14ed41a92769403");
            }
            this.f51565a = true;
            p();
            s(null);
            r();
            CrabSDK.setChannel(TbConfig.getCurrentFrom());
            CrabSDK.setEnableLog(isDebugMode);
            if (isDebugMode) {
                CrabSDK.enableBlockCatch(-1);
                CrabSDK.setBlockThreshold(2000);
                CrabSDK.setUploadCrashOnlyWifi(false);
                CrabSDK.setSendPrivacyInformation(true);
                CrabSDK.setUploadLimitOfSameCrashInOneday(-1);
                CrabSDK.setUploadLimitOfCrashInOneday(-1);
                CrabSDK.setUploadLimitOfAnrInOneday(-1);
                CrabSDK.setUrlRecordLimit(10);
            } else {
                if (n()) {
                    CrabSDK.disableBlockCatch();
                } else if (o()) {
                    CrabSDK.disableBlockCatch();
                } else {
                    CrabSDK.disableBlockCatch();
                }
                CrabSDK.setUploadCrashOnlyWifi(false);
                CrabSDK.setSendPrivacyInformation(true);
                CrabSDK.setUploadLimitOfSameCrashInOneday(10);
                CrabSDK.setUploadLimitOfCrashInOneday(30);
                CrabSDK.setUploadLimitOfAnrInOneday(10);
                CrabSDK.setBehaviorRecordLimit(5);
            }
            if (NativeCrashHandler.isOn()) {
                CrabSDK.openNativeCrashHandlerWithSysCatched();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(FlutterLoader.DEFAULT_LIBRARY);
                arrayList.add(FlutterLoader.DEFAULT_AOT_SHARED_LIBRARY_NAME);
                CrabSDK.openNativeCrashHandler(arrayList);
            }
            CrabSDK.setOnAnrCrashListener(new e());
            i();
            h();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f51565a = false;
            return false;
        }
    }

    public final boolean m() {
        return TbConfig.getVersionType() == 1;
    }

    public final boolean n() {
        return TbConfig.getVersionType() == 2;
    }

    public final boolean o() {
        return TbConfig.getVersionType() == 3;
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void onPause(Activity activity) {
        if (!this.f51565a || activity == null) {
            return;
        }
        CrabSDK.onPause(activity);
    }

    @Override // d.a.j0.i3.a.InterfaceC1317a
    public void onResume(Activity activity) {
        if (!this.f51565a || activity == null) {
            return;
        }
        CrabSDK.onResume(activity);
    }

    public void p() {
        q(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void q(String str, String str2) {
        if (this.f51565a) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void r() {
        if (this.f51565a) {
            if (j.H()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    public final void s(Throwable th) {
        if (this.f51565a) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", k());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            hashMap.put("plugin_info", j(th));
            hashMap.put("lastFlutterPage", this.f51568d);
            hashMap.put("openFlutterPage", this.f51569e);
            hashMap.put("flutterPath", this.f51570f);
            hashMap.put("customTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put("isBackground", String.valueOf(TbadkCoreApplication.getInst().isInBackground()));
            hashMap.put("pid", String.valueOf(Process.myPid()));
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }
}
