package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.xiaomi.push.ga;
import com.xiaomi.push.ge;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.av;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes8.dex */
public class gk {
    public static /* synthetic */ Interceptable $ic;
    public static XmlPullParser a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56373796, "Lcom/xiaomi/push/gk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56373796, "Lcom/xiaomi/push/gk;");
        }
    }

    public static fz a(String str, String str2, XmlPullParser xmlPullParser) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, xmlPullParser)) == null) {
            Object m388a = gj.a().m388a("all", "xm:chat");
            if (m388a == null || !(m388a instanceof com.xiaomi.push.service.f)) {
                return null;
            }
            return ((com.xiaomi.push.service.f) m388a).b(xmlPullParser);
        }
        return (fz) invokeLLL.objValue;
    }

    public static ga a(XmlPullParser xmlPullParser, fl flVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xmlPullParser, flVar)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue("", "id");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
            ga.a a2 = ga.a.a(xmlPullParser.getAttributeValue("", "type"));
            HashMap hashMap = new HashMap();
            boolean z = false;
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
            }
            ga gaVar = null;
            gg ggVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if (name.equals("error")) {
                        ggVar = m392a(xmlPullParser);
                    } else {
                        gaVar = new ga();
                        gaVar.a(a(name, namespace, xmlPullParser));
                    }
                } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                    z = true;
                }
            }
            if (gaVar == null) {
                if (ga.a.a == a2 || ga.a.b == a2) {
                    gl glVar = new gl();
                    glVar.k(attributeValue);
                    glVar.m(attributeValue3);
                    glVar.n(attributeValue2);
                    glVar.a(ga.a.d);
                    glVar.l(attributeValue4);
                    glVar.a(new gg(gg.a.e));
                    flVar.a(glVar);
                    com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                    return null;
                }
                gaVar = new gm();
            }
            gaVar.k(attributeValue);
            gaVar.m(attributeValue2);
            gaVar.l(attributeValue4);
            gaVar.n(attributeValue3);
            gaVar.a(a2);
            gaVar.a(ggVar);
            gaVar.a(hashMap);
            return gaVar;
        }
        return (ga) invokeLL.objValue;
    }

    public static gc a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xmlPullParser)) == null) {
            boolean z = false;
            String str2 = null;
            if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
                String attributeValue = xmlPullParser.getAttributeValue("", "chid");
                String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
                String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
                String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
                String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
                av.b a2 = com.xiaomi.push.service.av.a().a(attributeValue, attributeValue4);
                if (a2 == null) {
                    a2 = com.xiaomi.push.service.av.a().a(attributeValue, attributeValue3);
                }
                if (a2 != null) {
                    gc gcVar = null;
                    while (!z) {
                        int next = xmlPullParser.next();
                        if (next == 2) {
                            if (!"s".equals(xmlPullParser.getName())) {
                                throw new fw("error while receiving a encrypted message with wrong format");
                            }
                            if (xmlPullParser.next() != 4) {
                                throw new fw("error while receiving a encrypted message with wrong format");
                            }
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                gb gbVar = new gb();
                                gbVar.l(attributeValue);
                                gbVar.b(true);
                                gbVar.n(attributeValue3);
                                gbVar.m(attributeValue4);
                                gbVar.k(attributeValue2);
                                gbVar.f(attributeValue5);
                                fz fzVar = new fz("s", null, null, null);
                                fzVar.m373a(text);
                                gbVar.a(fzVar);
                                return gbVar;
                            }
                            a(com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(a2.h, attributeValue2), text));
                            a.next();
                            gcVar = a(a);
                        } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                            z = true;
                        }
                    }
                    if (gcVar != null) {
                        return gcVar;
                    }
                    throw new fw("error while receiving a encrypted message with wrong format");
                }
                throw new fw("the channel id is wrong while receiving a encrypted message");
            }
            gb gbVar2 = new gb();
            String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
            if (attributeValue6 == null) {
                attributeValue6 = "ID_NOT_AVAILABLE";
            }
            gbVar2.k(attributeValue6);
            gbVar2.m(xmlPullParser.getAttributeValue("", "to"));
            gbVar2.n(xmlPullParser.getAttributeValue("", "from"));
            gbVar2.l(xmlPullParser.getAttributeValue("", "chid"));
            gbVar2.a(xmlPullParser.getAttributeValue("", "appid"));
            try {
                str = xmlPullParser.getAttributeValue("", "transient");
            } catch (Exception unused) {
                str = null;
            }
            try {
                String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
                if (!TextUtils.isEmpty(attributeValue7)) {
                    gbVar2.b(attributeValue7);
                }
            } catch (Exception unused2) {
            }
            try {
                String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
                if (!TextUtils.isEmpty(attributeValue8)) {
                    gbVar2.c(attributeValue8);
                }
            } catch (Exception unused3) {
            }
            try {
                String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
                if (!TextUtils.isEmpty(attributeValue9)) {
                    gbVar2.d(attributeValue9);
                }
            } catch (Exception unused4) {
            }
            try {
                String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
                if (!TextUtils.isEmpty(attributeValue10)) {
                    gbVar2.e(attributeValue10);
                }
            } catch (Exception unused5) {
            }
            gbVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
            gbVar2.f(xmlPullParser.getAttributeValue("", "type"));
            String b = b(xmlPullParser);
            if (b == null || "".equals(b.trim())) {
                gc.q();
            } else {
                gbVar2.j(b);
            }
            while (!z) {
                int next2 = xmlPullParser.next();
                if (next2 == 2) {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if (TextUtils.isEmpty(namespace)) {
                        namespace = "xm";
                    }
                    if (name.equals("subject")) {
                        b(xmlPullParser);
                        gbVar2.g(m393a(xmlPullParser));
                    } else if (name.equals(TtmlNode.TAG_BODY)) {
                        String attributeValue11 = xmlPullParser.getAttributeValue("", HttpClientWrap.c);
                        String m393a = m393a(xmlPullParser);
                        if (TextUtils.isEmpty(attributeValue11)) {
                            gbVar2.h(m393a);
                        } else {
                            gbVar2.a(m393a, attributeValue11);
                        }
                    } else if (name.equals("thread")) {
                        if (str2 == null) {
                            str2 = xmlPullParser.nextText();
                        }
                    } else if (name.equals("error")) {
                        gbVar2.a(m392a(xmlPullParser));
                    } else {
                        gbVar2.a(a(name, namespace, xmlPullParser));
                    }
                } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            gbVar2.i(str2);
            return gbVar2;
        }
        return (gc) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ge m390a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xmlPullParser)) == null) {
            ge.b bVar = ge.b.a;
            String attributeValue = xmlPullParser.getAttributeValue("", "type");
            if (attributeValue != null && !attributeValue.equals("")) {
                try {
                    bVar = ge.b.valueOf(attributeValue);
                } catch (IllegalArgumentException unused) {
                    PrintStream printStream = System.err;
                    printStream.println("Found invalid presence type " + attributeValue);
                }
            }
            ge geVar = new ge(bVar);
            geVar.m(xmlPullParser.getAttributeValue("", "to"));
            geVar.n(xmlPullParser.getAttributeValue("", "from"));
            geVar.l(xmlPullParser.getAttributeValue("", "chid"));
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            if (attributeValue2 == null) {
                attributeValue2 = "ID_NOT_AVAILABLE";
            }
            geVar.k(attributeValue2);
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if (name.equals("status")) {
                        geVar.a(xmlPullParser.nextText());
                    } else if (name.equals("priority")) {
                        try {
                            geVar.a(Integer.parseInt(xmlPullParser.nextText()));
                        } catch (NumberFormatException unused2) {
                        } catch (IllegalArgumentException unused3) {
                            geVar.a(0);
                        }
                    } else if (name.equals("show")) {
                        String nextText = xmlPullParser.nextText();
                        try {
                            geVar.a(ge.a.valueOf(nextText));
                        } catch (IllegalArgumentException unused4) {
                            PrintStream printStream2 = System.err;
                            printStream2.println("Found invalid presence mode " + nextText);
                        }
                    } else if (name.equals("error")) {
                        geVar.a(m392a(xmlPullParser));
                    } else {
                        geVar.a(a(name, namespace, xmlPullParser));
                    }
                } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                    z = true;
                }
            }
            return geVar;
        }
        return (ge) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gf m391a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, xmlPullParser)) == null) {
            gf gfVar = null;
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    gfVar = new gf(xmlPullParser.getName());
                } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            }
            return gfVar;
        }
        return (gf) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gg m392a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xmlPullParser)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            String str = "-1";
            String str2 = null;
            String str3 = null;
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                if (xmlPullParser.getAttributeName(i).equals("code")) {
                    str = xmlPullParser.getAttributeValue("", "code");
                }
                if (xmlPullParser.getAttributeName(i).equals("type")) {
                    str3 = xmlPullParser.getAttributeValue("", "type");
                }
                if (xmlPullParser.getAttributeName(i).equals("reason")) {
                    str2 = xmlPullParser.getAttributeValue("", "reason");
                }
            }
            String str4 = null;
            String str5 = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (xmlPullParser.getName().equals("text")) {
                        str5 = xmlPullParser.nextText();
                    } else {
                        String name = xmlPullParser.getName();
                        String namespace = xmlPullParser.getNamespace();
                        if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                            str4 = name;
                        } else {
                            arrayList.add(a(name, namespace, xmlPullParser));
                        }
                    }
                } else if (next == 3) {
                    if (xmlPullParser.getName().equals("error")) {
                        z = true;
                    }
                } else if (next == 4) {
                    str5 = xmlPullParser.getText();
                }
            }
            return new gg(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
        }
        return (gg) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m393a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, xmlPullParser)) != null) {
            return (String) invokeL.objValue;
        }
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    public static void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bArr) == null) {
            if (a == null) {
                try {
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    a = newPullParser;
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
            a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        }
    }

    public static String b(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, xmlPullParser)) == null) {
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                if ("xml:lang".equals(attributeName) || (WebvttCueParser.TAG_LANG.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                    return xmlPullParser.getAttributeValue(i);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
