package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes2.dex */
public class gj {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static gj f71034a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Object> f443a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Object> f71035b;

    public gj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f443a = new ConcurrentHashMap();
        this.f71035b = new ConcurrentHashMap();
        m354a();
    }

    public static synchronized gj a() {
        InterceptResult invokeV;
        gj gjVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (gj.class) {
                if (f71034a == null) {
                    f71034a = new gj();
                }
                gjVar = f71034a;
            }
            return gjVar;
        }
        return (gj) invokeV.objValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            sb.append(str);
            sb.append("/>");
            if (str != null) {
                sb.append("<");
                sb.append(str2);
                sb.append("/>");
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m352a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ClassLoader[] classLoaderArr = {gj.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
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

    /* renamed from: a  reason: collision with other method in class */
    public Object m353a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? this.f443a.get(a(str, str2)) : invokeLL.objValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0103 */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m354a() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                for (ClassLoader classLoader : m352a()) {
                    Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                    while (resources.hasMoreElements()) {
                        InputStream openStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String a2 = a(nextText, nextText2);
                                    if (!this.f71035b.containsKey(a2)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (gh.class.isAssignableFrom(cls)) {
                                                map2 = this.f71035b;
                                                obj2 = cls.newInstance();
                                            } else if (ga.class.isAssignableFrom(cls)) {
                                                map2 = this.f71035b;
                                                obj2 = cls;
                                            }
                                            map2.put(a2, obj2);
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                            }
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String a3 = a(nextText4, nextText5);
                                    if (!this.f443a.containsKey(a3)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (gi.class.isAssignableFrom(cls2)) {
                                                map = this.f443a;
                                                obj = cls2.newInstance();
                                            } else if (gd.class.isAssignableFrom(cls2)) {
                                                map = this.f443a;
                                                obj = cls2;
                                            }
                                            map.put(a3, obj);
                                        } catch (ClassNotFoundException e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                            if (eventType == 1) {
                                                openStream.close();
                                            }
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType == 1);
                        try {
                            openStream.close();
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (!(obj instanceof gi) && !(obj instanceof Class)) {
                throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
            }
            this.f443a.put(a(str, str2), obj);
        }
    }
}
