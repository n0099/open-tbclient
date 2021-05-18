package d.a.c.h;

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
    public Context f39391a;

    /* renamed from: b  reason: collision with root package name */
    public File f39392b;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ActivityInfo> f39394d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ProviderInfo> f39395e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, IntentFilter> f39396f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, IntentFilter> f39397g;

    /* renamed from: i  reason: collision with root package name */
    public Resources f39399i;

    /* renamed from: c  reason: collision with root package name */
    public PackageInfo f39393c = null;

    /* renamed from: h  reason: collision with root package name */
    public ActivityInfo f39398h = null;

    public b(Context context, File file, Resources resources) {
        this.f39394d = null;
        this.f39395e = null;
        this.f39396f = null;
        this.f39397g = null;
        this.f39399i = null;
        this.f39391a = context;
        this.f39392b = file;
        this.f39399i = resources;
        this.f39394d = new HashMap();
        this.f39396f = new HashMap();
        this.f39397g = new HashMap();
        this.f39395e = new HashMap();
    }

    public ServiceInfo a(String str) {
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        if (!TextUtils.isEmpty(str) && (c2 = c()) != null && c2.services != null && !this.f39397g.isEmpty()) {
            for (ServiceInfo serviceInfo : c2.services) {
                IntentFilter intentFilter = this.f39397g.get(serviceInfo.name);
                if (intentFilter != null && intentFilter.hasAction(str)) {
                    return serviceInfo;
                }
            }
        }
        return null;
    }

    public Map<String, ProviderInfo> b() {
        return this.f39395e;
    }

    public PackageInfo c() {
        Context context = this.f39391a;
        if (context == null || this.f39392b == null) {
            return null;
        }
        if (this.f39393c == null) {
            try {
                this.f39393c = context.getPackageManager().getPackageArchiveInfo(this.f39392b.getAbsolutePath(), 15);
            } catch (Exception e2) {
                BdLog.e(e2);
                d.a.c.h.h.a.b().r("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e2.getMessage());
            }
        }
        return this.f39393c;
    }

    public Map<String, IntentFilter> d() {
        return this.f39396f;
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
                this.f39394d.put(activityInfo.name, activityInfo);
            }
        }
        ProviderInfo[] providerInfoArr = c2.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                this.f39395e.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.f39399i.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e2) {
            BdLog.e(e2);
            d.a.c.h.h.a.b().r("plugin_install", "plugin_third_manifest_failed", c2.packageName, e2.getMessage());
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
                        Map<String, IntentFilter> map = this.f39396f;
                        if (c3 == 1) {
                            map = this.f39397g;
                        }
                        IntentFilter intentFilter = map.get(str);
                        if (intentFilter == null) {
                            intentFilter = new IntentFilter(attributeValue2);
                        } else {
                            intentFilter.addAction(attributeValue2);
                        }
                        map.put(str, intentFilter);
                    }
                } else if (this.f39398h == null && "activity".equals(openXmlResourceParser.getName())) {
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

    public final void f(XmlResourceParser xmlResourceParser, int i2) throws XmlPullParserException, IOException {
        PackageInfo packageInfo = this.f39393c;
        if (packageInfo == null || packageInfo.activities == null) {
            return;
        }
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        while (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && "activity".equals(xmlResourceParser.getName())) {
                    return;
                }
            } else if ("action".equals(xmlResourceParser.getName())) {
                if (!"android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                    i2 = xmlResourceParser.next();
                } else {
                    if (attributeValue.startsWith(".")) {
                        attributeValue = this.f39393c.packageName + attributeValue;
                    }
                    int i3 = 0;
                    while (true) {
                        ActivityInfo[] activityInfoArr = this.f39393c.activities;
                        if (i3 >= activityInfoArr.length) {
                            break;
                        } else if (activityInfoArr[i3].name.equals(attributeValue)) {
                            this.f39398h = this.f39393c.activities[i3];
                            return;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            i2 = xmlResourceParser.next();
        }
    }
}
