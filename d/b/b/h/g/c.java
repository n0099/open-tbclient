package d.b.b.h.g;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallTask;
import com.baidu.adp.plugin.install.PluginInstallerRetryService;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.nps.utils.Constant;
import d.b.b.e.p.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static Handler u = new Handler(Looper.getMainLooper());
    public static volatile c v = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f42213b;

    /* renamed from: c  reason: collision with root package name */
    public BroadcastReceiver f42214c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.h.g.a f42216e;
    public PluginInstallTask i;
    public PluginInstallTask k;
    public Messenger m;
    public ServiceConnection n;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42212a = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42215d = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42217f = true;

    /* renamed from: g  reason: collision with root package name */
    public h f42218g = null;

    /* renamed from: h  reason: collision with root package name */
    public final Object f42219h = new Object();
    public LinkedList<PluginInstallTask> j = new LinkedList<>();
    public LinkedList<PluginInstallTask> l = new LinkedList<>();
    public Handler o = new HandlerC0544c(Looper.getMainLooper());
    public Messenger p = new Messenger(this.o);
    public Runnable q = new d();
    public Runnable r = new e();
    public Runnable s = new f();
    public Runnable t = new g();

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x014c, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.k.f2193f) != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0193, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.k.f2193f) != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0195, code lost:
            r6.this$0.O();
            r0 = r6.this$0.w(null);
            d.b.b.h.h.a.b().g("plugin_retry_install_succ");
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            String str;
            try {
                if (intent == null) {
                    if (c.this.i == null || !TextUtils.equals(null, c.this.i.f2193f)) {
                        if (c.this.k == null || !TextUtils.equals(null, c.this.k.f2193f)) {
                            c.this.w(null);
                            return;
                        }
                        c.this.O();
                        c.this.w(null);
                        d.b.b.h.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    c.this.L();
                    c.this.i = null;
                    c.this.w(null);
                    return;
                }
                try {
                    str = intent.getStringExtra("package_name");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        if (c.this.i == null || !TextUtils.equals(str, c.this.i.f2193f)) {
                            if (c.this.k != null) {
                            }
                            c.this.w(null);
                            return;
                        }
                        c.this.L();
                        c.this.i = null;
                        c.this.w(null);
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (c.this.i == null || !TextUtils.equals(null, c.this.i.f2193f)) {
                        if (c.this.k == null || !TextUtils.equals(null, c.this.k.f2193f)) {
                            c.this.w(null);
                        } else {
                            c.this.O();
                            c.this.w(null);
                            d.b.b.h.h.a.b().g("plugin_retry_install_succ");
                        }
                    } else {
                        c.this.L();
                        c.this.i = null;
                        c.this.w(null);
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(str)) {
                    if (c.this.i == null || !TextUtils.equals(str, c.this.i.f2193f)) {
                        if (c.this.k == null || !TextUtils.equals(str, c.this.k.f2193f)) {
                            c.this.w(null);
                            return;
                        }
                        c.this.O();
                        c.this.w(null);
                        d.b.b.h.h.a.b().g("plugin_retry_install_succ");
                        return;
                    }
                    c.this.L();
                    c.this.i = null;
                    c.this.w(null);
                    return;
                }
                String stringExtra = intent.getStringExtra("install_src_file");
                boolean z = stringExtra != null && stringExtra.startsWith("assets://");
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    c.this.C(str, z);
                    d.b.b.h.j.h.a.b().e(str);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    if (z) {
                        c.this.f42217f = false;
                    }
                    c.this.C(str, z);
                    d.b.b.h.j.h.a.b().d(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    c.this.C(str, z);
                } else {
                    "com.baidu.adp.plugin.installrepeat".equals(action);
                }
                if (c.this.i == null || !TextUtils.equals(str, c.this.i.f2193f)) {
                    if (c.this.k != null) {
                    }
                    c.this.w(null);
                    return;
                }
                c.this.L();
                c.this.i = null;
                c.this.w(null);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f42220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f42221f;

        public b(Intent intent, Context context) {
            this.f42220e = intent;
            this.f42221f = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.m = new Messenger(iBinder);
            String stringExtra = this.f42220e.getStringExtra("package_name");
            if (c.this.i == null || !TextUtils.equals(stringExtra, c.this.i.f2193f)) {
                return;
            }
            try {
                this.f42221f.startService(this.f42220e);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.M();
        }
    }

    /* renamed from: d.b.b.h.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0544c extends Handler {
        public HandlerC0544c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.i == null || message == null) {
                return;
            }
            try {
                if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).f2193f, c.this.i.f2193f)) {
                    c.u.removeCallbacks(c.this.r);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u();
            c.this.J();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K();
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.N();
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.P();
        }
    }

    /* loaded from: classes.dex */
    public class h extends BdAsyncTask<String, Object, String[]> {

        /* renamed from: a  reason: collision with root package name */
        public Context f42228a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f42229b = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

        /* loaded from: classes.dex */
        public class a implements Comparator<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f42231e;

            public a(h hVar, HashMap hashMap) {
                this.f42231e = hashMap;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                PluginStatus pluginStatus = (PluginStatus) this.f42231e.get(str);
                PluginStatus pluginStatus2 = (PluginStatus) this.f42231e.get(str2);
                if (pluginStatus == null || pluginStatus2 == null) {
                    if (pluginStatus == null || pluginStatus2 != null) {
                        return (pluginStatus != null || pluginStatus2 == null) ? 0 : 1;
                    }
                    return -1;
                }
                return pluginStatus2.s() - pluginStatus.s();
            }
        }

        public h(Context context) {
            this.f42228a = null;
            this.f42228a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String[] doInBackground(String... strArr) {
            Context context = this.f42228a;
            InputStream inputStream = null;
            if (context == null) {
                return null;
            }
            try {
                AssetManager assets = context.getAssets();
                String[] list = assets.list("plugins");
                if (list != null) {
                    try {
                        if (list.length > 0) {
                            HashMap hashMap = new HashMap();
                            try {
                                inputStream = assets.open("plugins/plugin.config");
                            } catch (IOException unused) {
                                BdLog.e("plugin.config file not in assets");
                            }
                            if (inputStream != null) {
                                try {
                                    byte[] bArr = new byte[inputStream.available()];
                                    inputStream.read(bArr);
                                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (next instanceof String) {
                                            String str = next;
                                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                            if (!str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                                str = str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                                            }
                                            PluginStatus pluginStatus = (PluginStatus) OrmObject.objectWithJson(optJSONObject, PluginStatus.class);
                                            if (pluginStatus != null) {
                                                hashMap.put(str, pluginStatus);
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                m.e(inputStream);
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new a(this, hashMap));
                                return list;
                            }
                            return list;
                        }
                        return list;
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = list;
                        BdLog.e(e);
                        return inputStream;
                    }
                }
                return list;
            } catch (Exception e4) {
                e = e4;
            }
        }

        public final boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.f42229b) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(String[] strArr) {
            super.onPostExecute(strArr);
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                int i2 = 0;
                while (i < length) {
                    String str = strArr[i];
                    if (str != null && str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && c(str)) {
                        c cVar = c.this;
                        Context context = this.f42228a;
                        if (cVar.D(context, "plugins/" + str, "install_from_start")) {
                            i2 = 1;
                        }
                    }
                    i++;
                }
                i = i2;
            }
            if (i != 0 || c.this.f42216e == null) {
                return;
            }
            c.this.f42216e.a(c.this.f42217f);
        }
    }

    public c() {
        this.f42213b = null;
        this.f42214c = null;
        this.f42213b = new ArrayList<>();
        this.f42214c = new a();
        Q();
    }

    public static File A(String str) {
        String str2;
        PluginSetting P = PluginPackageManager.O().P(str);
        if (P == null || (str2 = P.apkPath) == null || str2.length() <= 0) {
            return null;
        }
        return new File(P.apkPath);
    }

    public static c B() {
        if (v == null) {
            synchronized (c.class) {
                if (v == null) {
                    v = new c();
                }
            }
        }
        return v;
    }

    public final void C(String str, boolean z) {
        if (this.f42213b.contains(str)) {
            this.f42213b.remove(str);
        }
        if (!this.f42215d && z && this.f42213b.isEmpty()) {
            this.f42215d = true;
            d.b.b.h.g.a aVar = this.f42216e;
            if (aVar != null) {
                aVar.a(this.f42217f);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            v();
        }
    }

    public final boolean D(Context context, String str, String str2) {
        PluginSetting pluginSetting;
        InputStream inputStream;
        FileInputStream fileInputStream;
        d.b.b.h.k.f x;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        int i = lastIndexOf + 1;
        if (i >= lastIndexOf2) {
            return false;
        }
        String substring = str.substring(i, lastIndexOf2);
        PluginSetting P = PluginPackageManager.O().P(substring);
        if (substring == null || substring.length() <= 0 || P == null || P.apkPath == null) {
            pluginSetting = P;
        } else {
            File file = new File(P.apkPath);
            boolean exists = file.exists();
            boolean isFile = file.isFile();
            long length = file.length();
            if (file.exists() && file.isFile() && file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        x = Util.x(fileInputStream);
                        inputStream = context.getAssets().open(str);
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                pluginSetting = P;
                            }
                        } catch (Throwable th) {
                            th = th;
                            d.b.b.e.m.a.c(fileInputStream);
                            d.b.b.e.m.a.c(inputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        pluginSetting = P;
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    pluginSetting = P;
                    inputStream = null;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    fileInputStream = null;
                }
                if (x.compareTo(Util.x(inputStream)) == 0) {
                    if (this.f42216e != null) {
                        this.f42216e.b(substring);
                    }
                    pluginSetting = P;
                    try {
                        d.b.b.h.h.a.b().o("plugin_install", "install_timeequals", substring, x.toString());
                        d.b.b.e.m.a.c(fileInputStream);
                        d.b.b.e.m.a.c(inputStream);
                        return false;
                    } catch (Exception e5) {
                        e = e5;
                        BdLog.e(e);
                        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
                        b2.o("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                        d.b.b.e.m.a.c(fileInputStream);
                        d.b.b.e.m.a.c(inputStream);
                        T(context, "assets://" + str, false);
                        d.b.b.h.h.a.b().d("plugin_install", substring, pluginSetting, str2);
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, d.b.b.h.j.h.a.b().c(substring)));
                        return true;
                    }
                }
                pluginSetting = P;
                d.b.b.e.m.a.c(fileInputStream);
                d.b.b.e.m.a.c(inputStream);
            } else {
                pluginSetting = P;
                d.b.b.h.h.a b3 = d.b.b.h.h.a.b();
                b3.o("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
            }
        }
        T(context, "assets://" + str, false);
        d.b.b.h.h.a.b().d("plugin_install", substring, pluginSetting, str2);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, d.b.b.h.j.h.a.b().c(substring)));
        return true;
    }

    public void E(Context context, d.b.b.h.g.a aVar) {
        this.f42216e = aVar;
        h hVar = this.f42218g;
        if (hVar != null) {
            hVar.cancel();
            this.f42218g = null;
        }
        h hVar2 = new h(context);
        this.f42218g = hVar2;
        hVar2.setPriority(4);
        this.f42218g.execute(new String[0]);
    }

    public void F(Context context, String str) {
        T(context, "file://" + str, false);
    }

    public final boolean G() {
        return z() > 0;
    }

    public boolean H(String str) {
        PluginInstallTask pluginInstallTask = this.i;
        if (pluginInstallTask != null) {
            return TextUtils.equals(str, pluginInstallTask.f2193f);
        }
        PluginInstallTask pluginInstallTask2 = this.k;
        if (pluginInstallTask2 != null) {
            return TextUtils.equals(str, pluginInstallTask2.f2193f);
        }
        return false;
    }

    public final void I() {
        if (this.n != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.n);
        }
        this.n = null;
        this.m = null;
        int z = z();
        if (z <= 0 || z == Process.myPid()) {
            return;
        }
        Process.killProcess(z);
    }

    public final void J() {
        u.removeCallbacks(this.q);
        u.postDelayed(this.q, 10000L);
    }

    public final void K() {
        d.b.b.h.h.a.b().g("plugin_installprocess_noresponse");
        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
        PluginInstallTask pluginInstallTask = this.i;
        String str = pluginInstallTask == null ? "" : pluginInstallTask.f2193f;
        b2.o("plugin_install", "installprocess_noresponse", str, this.j.size() + "-" + this.l.size());
        L();
        I();
        S();
    }

    public final void L() {
        u.removeCallbacks(this.q);
        u.removeCallbacks(this.s);
        u.removeCallbacks(this.r);
    }

    public final void M() {
        this.n = null;
        this.m = null;
        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
        PluginInstallTask pluginInstallTask = this.i;
        String str = pluginInstallTask == null ? "" : pluginInstallTask.f2193f;
        b2.o("plugin_install", "system_kill_installprocess", str, this.j.size() + "-" + this.l.size());
        L();
        S();
    }

    public final void N() {
        if (this.i != null) {
            d.b.b.h.j.h.a.b().d(this.i.f2193f, "plugin_install_timeout", null);
        }
        PluginInstallTask pluginInstallTask = this.i;
        if (!G()) {
            d.b.b.h.h.a.b().g("plugin_install_timeout_installprocess_notlive");
            d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
            String str = pluginInstallTask == null ? "" : pluginInstallTask.f2193f;
            StringBuilder sb = new StringBuilder();
            sb.append("timeout-");
            sb.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.s()) : "");
            sb.append("-");
            sb.append(this.j.size());
            sb.append("-");
            sb.append(this.l.size());
            b2.o("plugin_install", "timeout_installprocess_notlive", str, sb.toString());
        } else {
            d.b.b.h.h.a.b().g("plugin_install_timeout");
            d.b.b.h.h.a b3 = d.b.b.h.h.a.b();
            String str2 = pluginInstallTask == null ? "" : pluginInstallTask.f2193f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("timeout-");
            sb2.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.s()) : "");
            sb2.append("-");
            sb2.append(this.j.size());
            sb2.append("-");
            sb2.append(this.l.size());
            b3.o("plugin_install", com.alipay.sdk.data.a.i, str2, sb2.toString());
        }
        L();
        I();
        S();
    }

    public final void O() {
        this.k = null;
        u.removeCallbacks(this.t);
    }

    public final void P() {
        if (this.k != null) {
            d.b.b.h.j.h.a.b().d(this.k.f2193f, "plugin_install_retry_timeout", null);
        }
        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
        PluginInstallTask pluginInstallTask = this.k;
        String str = pluginInstallTask == null ? "" : pluginInstallTask.f2193f;
        StringBuilder sb = new StringBuilder();
        sb.append("timeout-");
        PluginInstallTask pluginInstallTask2 = this.k;
        sb.append(pluginInstallTask2 != null ? Long.valueOf(pluginInstallTask2.s()) : "");
        sb.append("-");
        sb.append(this.j.size());
        sb.append("-");
        sb.append(this.l.size());
        b2.o("plugin_install", com.alipay.sdk.data.a.i, str, sb.toString());
        O();
    }

    public final void Q() {
        if (this.f42212a) {
            return;
        }
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
            if (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().equals(RomUtils.MANUFACTURER_OPPO)) {
                intentFilter.setPriority(1000);
            }
            applicationContext.registerReceiver(this.f42214c, intentFilter);
            this.f42212a = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void R(String str, int i) {
        if (i != 1) {
            return;
        }
        BdBaseApplication inst = BdBaseApplication.getInst();
        D(inst, "plugins/" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX, "install_from_rollback");
    }

    public final void S() {
        if (this.i != null) {
            d.b.b.h.h.a.b().i("plugin_retry_install", this.i.f2193f);
            d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
            String str = this.i.f2193f;
            b2.o("plugin_install", "plugin_retry_install", str, this.i.s() + "");
            y(this.i);
            this.i = null;
            return;
        }
        w(null);
    }

    public final void T(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Q();
        PluginInstallTask pluginInstallTask = new PluginInstallTask();
        pluginInstallTask.f2192e = str;
        boolean z2 = true;
        if (str.startsWith("assets://")) {
            r8 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
            try {
                pluginInstallTask.f2195h = context.getAssets().open(str.substring(9)).available();
            } catch (IOException e2) {
                BdLog.detailException(e2);
            }
        } else {
            if (str.startsWith("file://")) {
                PackageManager packageManager = context.getPackageManager();
                String substring = str.substring(7);
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring, 0);
                r8 = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
                pluginInstallTask.f2195h = new File(substring).length();
            }
            z2 = false;
        }
        if (r8 != null) {
            pluginInstallTask.f2193f = r8;
            if (w(pluginInstallTask) && z2) {
                this.f42213b.add(r8);
                return;
            }
            return;
        }
        pluginInstallTask.f2193f = str;
        w(pluginInstallTask);
    }

    public final boolean U(Context context, PluginInstallTask pluginInstallTask) {
        if (pluginInstallTask == null) {
            return false;
        }
        PluginSetting h2 = d.b.b.h.j.g.d.k().h(pluginInstallTask.f2193f);
        String str = pluginInstallTask.f2192e;
        boolean z = str != null && str.startsWith("assets://");
        String str2 = pluginInstallTask.f2192e;
        if (str2 != null && str2.startsWith("file://")) {
            if (h2 != null && h2.installStatus == 0 && h2.tempVersionCode == 0) {
                d.b.b.h.h.a.b().o("plugin_install", "start_service_install_status_error", pluginInstallTask.f2193f, "apkFilePath_" + pluginInstallTask.f2192e);
                return false;
            }
            String substring = pluginInstallTask.f2192e.substring(7);
            try {
                if (!new File(substring).exists()) {
                    d.b.b.h.h.a.b().o("plugin_install", "start_service_file_not_find", pluginInstallTask.f2193f, "apkFilePath_" + substring);
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        String str3 = "f" + System.currentTimeMillis();
        d.b.b.h.h.a.b().o("plugin_install", "start_install_service", pluginInstallTask.f2193f, "flag=" + str3 + "_" + pluginInstallTask.f2192e);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", pluginInstallTask.f2192e);
        intent.putExtra("package_name", pluginInstallTask.f2193f);
        intent.putExtra("install_flag", str3);
        if (h2 != null) {
            intent.putExtra("plugin_setting", h2);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.O().e0());
        if (pluginInstallTask.f2194g) {
            intent.setClass(context, PluginInstallerRetryService.class);
            try {
                context.startService(intent);
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.n == null && z) {
            ServiceConnection bVar = new b(intent, context);
            this.n = bVar;
            if (context.bindService(intent, bVar, 1)) {
                return true;
            }
            try {
                context.startService(intent);
                return true;
            } catch (Throwable unused3) {
                return false;
            }
        }
        try {
            context.startService(intent);
            return true;
        } catch (Throwable unused4) {
            return false;
        }
    }

    public final void u() {
        if (this.m == null || this.i == null) {
            return;
        }
        Message message = new Message();
        try {
            message.setData(OrmObject.bundleWithObject(this.i));
            message.replyTo = this.p;
            this.m.send(message);
        } catch (RemoteException e2) {
            BdLog.detailException(e2);
        }
        u.removeCallbacks(this.r);
        u.postDelayed(this.r, 1000L);
    }

    public final void v() {
        if (this.n != null) {
            BdBaseApplication.getInst().unbindService(this.n);
            this.n = null;
        }
    }

    public final boolean w(PluginInstallTask pluginInstallTask) {
        if (x(pluginInstallTask)) {
            return true;
        }
        return y(pluginInstallTask);
    }

    public final boolean x(PluginInstallTask pluginInstallTask) {
        synchronized (this.f42219h) {
            if (pluginInstallTask == null) {
                try {
                    pluginInstallTask = this.j.poll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            boolean z = false;
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.i != null) {
                Iterator<PluginInstallTask> it = this.j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.f2193f, next.f2193f)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.j.add(pluginInstallTask);
                }
                return true;
            }
            this.i = pluginInstallTask;
            if (U(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                J();
                u.removeCallbacks(this.s);
                u.postDelayed(this.s, this.i.s());
                return true;
            }
            this.i = null;
            return w(null);
        }
    }

    public final boolean y(PluginInstallTask pluginInstallTask) {
        synchronized (this.f42219h) {
            if (pluginInstallTask == null) {
                try {
                    pluginInstallTask = this.l.poll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            boolean z = false;
            if (pluginInstallTask == null) {
                return false;
            }
            if (this.k != null) {
                Iterator<PluginInstallTask> it = this.l.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PluginInstallTask next = it.next();
                    if (next != null && TextUtils.equals(pluginInstallTask.f2193f, next.f2193f)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.l.add(pluginInstallTask);
                }
                return true;
            }
            this.k = pluginInstallTask;
            pluginInstallTask.f2194g = true;
            if (U(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                u.removeCallbacks(this.t);
                u.postDelayed(this.t, this.k.s());
                return true;
            }
            return w(null);
        }
    }

    public final int z() {
        ServiceInfo serviceInfo;
        Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
        try {
            serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, PluginInstallerService.class), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            BdLog.detailException(e2);
            serviceInfo = null;
        }
        if (serviceInfo != null) {
            String str = serviceInfo.processName;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.pid;
                    }
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }
}
