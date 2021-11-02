package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes2.dex */
public final class fr {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f70960a = 5000;

    /* renamed from: a  reason: collision with other field name */
    public static Vector<String> f415a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f70961b = 330000;

    /* renamed from: c  reason: collision with root package name */
    public static int f70962c = 600000;

    /* renamed from: d  reason: collision with root package name */
    public static int f70963d = 330000;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374540, "Lcom/xiaomi/push/fr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374540, "Lcom/xiaomi/push/fr;");
                return;
            }
        }
        f415a = new Vector<>();
        try {
            for (ClassLoader classLoader : m335a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                    a(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f70960a = a(newPullParser, f70960a);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    f70961b = a(newPullParser, f70961b);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    f415a.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public fr() {
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f70961b : invokeV.intValue;
    }

    public static int a(XmlPullParser xmlPullParser, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, xmlPullParser, i2)) == null) {
            try {
                return Integer.parseInt(xmlPullParser.nextText());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m334a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "3.1.0" : (String) invokeV.objValue;
    }

    public static void a(XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, xmlPullParser) == null) {
            String nextText = xmlPullParser.nextText();
            try {
                Class.forName(nextText);
            } catch (ClassNotFoundException unused) {
                PrintStream printStream = System.err;
                printStream.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ClassLoader[] m335a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            ClassLoader[] classLoaderArr = {fr.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                ClassLoader classLoader = classLoaderArr[i2];
                if (classLoader != null) {
                    arrayList.add(classLoader);
                }
            }
            return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
        }
        return (ClassLoader[]) invokeV.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f70962c : invokeV.intValue;
    }
}
