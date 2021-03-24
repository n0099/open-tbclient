package d.b.b.h;

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
    public Context f42189a;

    /* renamed from: b  reason: collision with root package name */
    public File f42190b;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ActivityInfo> f42192d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ProviderInfo> f42193e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, IntentFilter> f42194f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, IntentFilter> f42195g;
    public Resources i;

    /* renamed from: c  reason: collision with root package name */
    public PackageInfo f42191c = null;

    /* renamed from: h  reason: collision with root package name */
    public ActivityInfo f42196h = null;

    public b(Context context, File file, Resources resources) {
        this.f42192d = null;
        this.f42193e = null;
        this.f42194f = null;
        this.f42195g = null;
        this.i = null;
        this.f42189a = context;
        this.f42190b = file;
        this.i = resources;
        this.f42192d = new HashMap();
        this.f42194f = new HashMap();
        this.f42195g = new HashMap();
        this.f42193e = new HashMap();
    }

    public ServiceInfo a(String str) {
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        if (!TextUtils.isEmpty(str) && (c2 = c()) != null && c2.services != null && !this.f42195g.isEmpty()) {
            for (ServiceInfo serviceInfo : c2.services) {
                IntentFilter intentFilter = this.f42195g.get(serviceInfo.name);
                if (intentFilter != null && intentFilter.hasAction(str)) {
                    return serviceInfo;
                }
            }
        }
        return null;
    }

    public Map<String, ProviderInfo> b() {
        return this.f42193e;
    }

    public PackageInfo c() {
        Context context = this.f42189a;
        if (context == null || this.f42190b == null) {
            return null;
        }
        if (this.f42191c == null) {
            try {
                this.f42191c = context.getPackageManager().getPackageArchiveInfo(this.f42190b.getAbsolutePath(), 15);
            } catch (Exception e2) {
                BdLog.e(e2);
                d.b.b.h.h.a.b().r("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e2.getMessage());
            }
        }
        return this.f42191c;
    }

    public Map<String, IntentFilter> d() {
        return this.f42194f;
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
                this.f42192d.put(activityInfo.name, activityInfo);
            }
        }
        ProviderInfo[] providerInfoArr = c2.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                this.f42193e.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.i.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e2) {
            BdLog.e(e2);
            d.b.b.h.h.a.b().r("plugin_install", "plugin_third_manifest_failed", c2.packageName, e2.getMessage());
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
                        Map<String, IntentFilter> map = this.f42194f;
                        if (c3 == 1) {
                            map = this.f42195g;
                        }
                        IntentFilter intentFilter = map.get(str);
                        if (intentFilter == null) {
                            intentFilter = new IntentFilter(attributeValue2);
                        } else {
                            intentFilter.addAction(attributeValue2);
                        }
                        map.put(str, intentFilter);
                    }
                } else if (this.f42196h == null && "activity".equals(openXmlResourceParser.getName())) {
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
        PackageInfo packageInfo = this.f42191c;
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
                        attributeValue = this.f42191c.packageName + attributeValue;
                    }
                    int i2 = 0;
                    while (true) {
                        ActivityInfo[] activityInfoArr = this.f42191c.activities;
                        if (i2 >= activityInfoArr.length) {
                            break;
                        } else if (activityInfoArr[i2].name.equals(attributeValue)) {
                            this.f42196h = this.f42191c.activities[i2];
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
