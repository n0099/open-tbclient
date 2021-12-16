package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes4.dex */
public final class ApplicationInfoLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
    public static final String PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY = "io.flutter.automatically-register-plugins";
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-524231839, "Lio/flutter/embedding/engine/loader/ApplicationInfoLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-524231839, "Lio/flutter/embedding/engine/loader/ApplicationInfoLoader;");
                return;
            }
        }
        PUBLIC_AOT_SHARED_LIBRARY_NAME = FlutterLoader.class.getName() + '.' + FlutterLoader.AOT_SHARED_LIBRARY_NAME;
        PUBLIC_VM_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + '.' + FlutterLoader.VM_SNAPSHOT_DATA_KEY;
        PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = FlutterLoader.class.getName() + '.' + FlutterLoader.ISOLATE_SNAPSHOT_DATA_KEY;
        PUBLIC_FLUTTER_ASSETS_DIR_KEY = FlutterLoader.class.getName() + '.' + FlutterLoader.FLUTTER_ASSETS_DIR_KEY;
    }

    public ApplicationInfoLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static ApplicationInfo getApplicationInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bundle, str, z)) == null) ? bundle == null ? z : bundle.getBoolean(str, z) : invokeLLZ.booleanValue;
    }

    public static String getNetworkPolicy(ApplicationInfo applicationInfo, Context context) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, applicationInfo, context)) == null) {
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && (i2 = bundle.getInt(NETWORK_POLICY_METADATA_KEY, 0)) > 0) {
                JSONArray jSONArray = new JSONArray();
                try {
                    XmlResourceParser xml = context.getResources().getXml(i2);
                    xml.next();
                    for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                        if (eventType == 2) {
                            if (xml.getName().equals("domain-config")) {
                                parseDomainConfig(xml, jSONArray, false);
                            }
                        }
                    }
                    return jSONArray.toString();
                } catch (IOException | XmlPullParserException unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String getString(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bundle, str)) == null) {
            if (bundle == null) {
                return null;
            }
            return bundle.getString(str, null);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static FlutterApplicationInfo load(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            ApplicationInfo applicationInfo = getApplicationInfo(context);
            return new FlutterApplicationInfo(getString(applicationInfo.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), getString(applicationInfo.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), getString(applicationInfo.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), getString(applicationInfo.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), getNetworkPolicy(applicationInfo, context), applicationInfo.nativeLibraryDir, getBoolean(applicationInfo.metaData, PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY, true));
        }
        return (FlutterApplicationInfo) invokeL.objValue;
    }

    public static void parseDomain(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, xmlResourceParser, jSONArray, z) == null) {
            boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
            xmlResourceParser.next();
            if (xmlResourceParser.getEventType() == 4) {
                String trim = xmlResourceParser.getText().trim();
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(trim);
                jSONArray2.put(attributeBooleanValue);
                jSONArray2.put(z);
                jSONArray.put(jSONArray2);
                xmlResourceParser.next();
                if (xmlResourceParser.getEventType() != 3) {
                    throw new IllegalStateException("Expected end of domain tag");
                }
                return;
            }
            throw new IllegalStateException("Expected text");
        }
    }

    public static void parseDomainConfig(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLZ(65544, null, xmlResourceParser, jSONArray, z) != null) {
            return;
        }
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", z);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    parseDomain(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    parseDomainConfig(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    skipTag(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    public static void skipTag(XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, xmlResourceParser) != null) {
            return;
        }
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlResourceParser.getName() == name) {
                return;
            }
            eventType = xmlResourceParser.next();
        }
    }
}
