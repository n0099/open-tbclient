package d.f.b.a.i0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes10.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(XmlPullParser xmlPullParser, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, xmlPullParser, str)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i2 = 0; i2 < attributeCount; i2++) {
                if (str.equals(xmlPullParser.getAttributeName(i2))) {
                    return xmlPullParser.getAttributeValue(i2);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(XmlPullParser xmlPullParser) throws XmlPullParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xmlPullParser)) == null) ? xmlPullParser.getEventType() == 3 : invokeL.booleanValue;
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xmlPullParser, str)) == null) ? b(xmlPullParser) && xmlPullParser.getName().equals(str) : invokeLL.booleanValue;
    }

    public static boolean d(XmlPullParser xmlPullParser) throws XmlPullParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xmlPullParser)) == null) ? xmlPullParser.getEventType() == 2 : invokeL.booleanValue;
    }

    public static boolean e(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, xmlPullParser, str)) == null) ? d(xmlPullParser) && xmlPullParser.getName().equals(str) : invokeLL.booleanValue;
    }
}
