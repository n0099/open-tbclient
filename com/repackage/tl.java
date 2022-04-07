package com.repackage;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes7.dex */
public class tl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public File b;
    public PackageInfo c;
    public Map<String, ActivityInfo> d;
    public Map<String, ProviderInfo> e;
    public Map<String, IntentFilter> f;
    public Map<String, IntentFilter> g;
    public ActivityInfo h;
    public Resources i;

    public tl(Context context, File file, Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file, resources};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = context;
        this.b = file;
        this.i = resources;
        this.d = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.e = new HashMap();
    }

    public ServiceInfo a(String str) {
        InterceptResult invokeL;
        PackageInfo c;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (c = c()) != null && c.services != null && !this.g.isEmpty()) {
                for (ServiceInfo serviceInfo : c.services) {
                    IntentFilter intentFilter = this.g.get(serviceInfo.name);
                    if (intentFilter != null && intentFilter.hasAction(str)) {
                        return serviceInfo;
                    }
                }
            }
            return null;
        }
        return (ServiceInfo) invokeL.objValue;
    }

    public Map<String, ProviderInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (Map) invokeV.objValue;
    }

    public PackageInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.a;
            if (context == null || this.b == null) {
                return null;
            }
            if (this.c == null) {
                try {
                    this.c = context.getPackageManager().getPackageArchiveInfo(this.b.getAbsolutePath(), 15);
                } catch (Exception e) {
                    BdLog.e(e);
                    em.b().p("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
                }
            }
            return this.c;
        }
        return (PackageInfo) invokeV.objValue;
    }

    public Map<String, IntentFilter> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        XmlResourceParser openXmlResourceParser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PackageInfo c = c();
            if (c == null) {
                BdLog.w("Plugin: initManifest() pkgInfo == null!!");
                return false;
            }
            ActivityInfo[] activityInfoArr = c.receivers;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    this.d.put(activityInfo.name, activityInfo);
                }
            }
            ProviderInfo[] providerInfoArr = c.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    this.e.put(providerInfo.name, providerInfo);
                }
            }
            try {
                openXmlResourceParser = this.i.getAssets().openXmlResourceParser(CommonMethods.ANDROID_MANIFEST_FILENAME);
            } catch (Exception e) {
                BdLog.e(e);
                em.b().p("plugin_install", "plugin_third_manifest_failed", c.packageName, e.getMessage());
            }
            if (openXmlResourceParser == null) {
                return false;
            }
            String str = null;
            char c2 = 65535;
            for (int next = openXmlResourceParser.next(); next != 1; next = openXmlResourceParser.next()) {
                if (next == 2) {
                    if (SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName())) {
                        c2 = 0;
                    } else if ("service".equals(openXmlResourceParser.getName())) {
                        c2 = 1;
                    }
                    if (c2 >= 0 && str == null) {
                        String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue.startsWith(".")) {
                            attributeValue = c.packageName + attributeValue;
                        }
                        str = attributeValue;
                    } else if (str != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = this.f;
                            if (c2 == 1) {
                                map = this.g;
                            }
                            IntentFilter intentFilter = map.get(str);
                            if (intentFilter == null) {
                                intentFilter = new IntentFilter(attributeValue2);
                            } else {
                                intentFilter.addAction(attributeValue2);
                            }
                            map.put(str, intentFilter);
                        }
                    } else if (this.h == null && "activity".equals(openXmlResourceParser.getName())) {
                        f(openXmlResourceParser, next);
                    }
                } else if (next != 3) {
                    continue;
                } else {
                    if (!SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName()) && !"service".equals(openXmlResourceParser.getName())) {
                        if (MimeTypes.BASE_TYPE_APPLICATION.equals(openXmlResourceParser.getName())) {
                            return true;
                        }
                    }
                    str = null;
                    c2 = 65535;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, xmlResourceParser, i) == null) || (packageInfo = this.c) == null || packageInfo.activities == null) {
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
                        attributeValue = this.c.packageName + attributeValue;
                    }
                    int i2 = 0;
                    while (true) {
                        ActivityInfo[] activityInfoArr = this.c.activities;
                        if (i2 >= activityInfoArr.length) {
                            break;
                        } else if (activityInfoArr[i2].name.equals(attributeValue)) {
                            this.h = this.c.activities[i2];
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
