package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fz;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gn;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes10.dex */
public class f implements gi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static fz a(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, xmlPullParser)) != null) {
            return (fz) invokeL.objValue;
        }
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                strArr3[i2] = xmlPullParser.getAttributeName(i2);
                strArr4[i2] = gn.b(xmlPullParser.getAttributeValue(i2));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new fz(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                fz a2 = a(xmlPullParser);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gj.a().a("all", "xm:chat", this);
        }
    }

    public fz b(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xmlPullParser)) == null) {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1 && eventType != 2) {
                eventType = xmlPullParser.next();
            }
            if (eventType == 2) {
                return a(xmlPullParser);
            }
            return null;
        }
        return (fz) invokeL.objValue;
    }
}
