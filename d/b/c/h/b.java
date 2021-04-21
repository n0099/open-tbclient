package d.b.c.h;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f42927a;

    /* renamed from: b  reason: collision with root package name */
    public File f42928b;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ActivityInfo> f42930d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ProviderInfo> f42931e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, IntentFilter> f42932f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, IntentFilter> f42933g;
    public Resources i;

    /* renamed from: c  reason: collision with root package name */
    public PackageInfo f42929c = null;

    /* renamed from: h  reason: collision with root package name */
    public ActivityInfo f42934h = null;

    public b(Context context, File file, Resources resources) {
        this.f42930d = null;
        this.f42931e = null;
        this.f42932f = null;
        this.f42933g = null;
        this.i = null;
        this.f42927a = context;
        this.f42928b = file;
        this.i = resources;
        this.f42930d = new HashMap();
        this.f42932f = new HashMap();
        this.f42933g = new HashMap();
        this.f42931e = new HashMap();
    }

    public ServiceInfo a(String str) {
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        if (!TextUtils.isEmpty(str) && (c2 = c()) != null && c2.services != null && !this.f42933g.isEmpty()) {
            for (ServiceInfo serviceInfo : c2.services) {
                IntentFilter intentFilter = this.f42933g.get(serviceInfo.name);
                if (intentFilter != null && intentFilter.hasAction(str)) {
                    return serviceInfo;
                }
            }
        }
        return null;
    }

    public Map<String, ProviderInfo> b() {
        return this.f42931e;
    }

    public PackageInfo c() {
        Context context = this.f42927a;
        if (context == null || this.f42928b == null) {
            return null;
        }
        if (this.f42929c == null) {
            try {
                this.f42929c = context.getPackageManager().getPackageArchiveInfo(this.f42928b.getAbsolutePath(), 15);
            } catch (Exception e2) {
                BdLog.e(e2);
                d.b.c.h.h.a.b().r("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e2.getMessage());
            }
        }
        return this.f42929c;
    }

    public Map<String, IntentFilter> d() {
        return this.f42932f;
    }

    public boolean e() {
        XmlResourceParser openXmlResourceParser;
        PackageInfo c2 = c();
        if (c2 == null) {
            BdLog.w("Plugin: initManifest() pkgInfo == null!!");
            return false;
        }
        ActivityInfo[] activityInfoArr = c2.receivers;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                this.f42930d.put(activityInfo.name, activityInfo);
            }
        }
        ProviderInfo[] providerInfoArr = c2.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                this.f42931e.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.i.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e2) {
            BdLog.e(e2);
            d.b.c.h.h.a.b().r("plugin_install", "plugin_third_manifest_failed", c2.packageName, e2.getMessage());
        }
        if (openXmlResourceParser == null) {
            return false;
        }
        String str = null;
        char c3 = 65535;
        for (int next = openXmlResourceParser.next(); next != 1; next = openXmlResourceParser.next()) {
            if (next == 2) {
                if (SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName())) {
                    c3 = 0;
                } else if ("service".equals(openXmlResourceParser.getName())) {
                    c3 = 1;
                }
                if (c3 >= 0 && str == null) {
                    String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                    if (attributeValue.startsWith(".")) {
                        attributeValue = c2.packageName + attributeValue;
                    }
                    str = attributeValue;
                } else if (str != null && "action".equals(openXmlResourceParser.getName())) {
                    String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                    if (attributeValue2 != null) {
                        Map<String, IntentFilter> map = this.f42932f;
                        if (c3 == 1) {
                            map = this.f42933g;
                        }
                        IntentFilter intentFilter = map.get(str);
                        if (intentFilter == null) {
                            intentFilter = new IntentFilter(attributeValue2);
                        } else {
                            intentFilter.addAction(attributeValue2);
                        }
                        map.put(str, intentFilter);
                    }
                } else if (this.f42934h == null && "activity".equals(openXmlResourceParser.getName())) {
                    f(openXmlResourceParser, next);
                }
            } else if (next != 3) {
                continue;
            } else {
                if (!SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName()) && !"service".equals(openXmlResourceParser.getName())) {
                    if ("application".equals(openXmlResourceParser.getName())) {
                        return true;
                    }
                }
                str = null;
                c3 = 65535;
            }
        }
        return false;
    }

    public final void f(XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        PackageInfo packageInfo = this.f42929c;
        if (packageInfo == null || packageInfo.activities == null) {
            return;
        }
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        while (i != 1) {
            if (i != 2) {
                if (i == 3 && "activity".equals(xmlResourceParser.getName())) {
                    return;
                }
            } else if ("action".equals(xmlResourceParser.getName())) {
                if (!"android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                    i = xmlResourceParser.next();
                } else {
                    if (attributeValue.startsWith(".")) {
                        attributeValue = this.f42929c.packageName + attributeValue;
                    }
                    int i2 = 0;
                    while (true) {
                        ActivityInfo[] activityInfoArr = this.f42929c.activities;
                        if (i2 >= activityInfoArr.length) {
                            break;
                        } else if (activityInfoArr[i2].name.equals(attributeValue)) {
                            this.f42934h = this.f42929c.activities[i2];
                            return;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            i = xmlResourceParser.next();
        }
    }
}
