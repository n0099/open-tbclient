package com.google.android.exoplayer2.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes7.dex */
public final class XmlPullParserUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public XmlPullParserUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAttributeValue(XmlPullParser xmlPullParser, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xmlPullParser, str)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                if (str.equals(xmlPullParser.getAttributeName(i))) {
                    return xmlPullParser.getAttributeValue(i);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isEndTag(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, xmlPullParser, str)) == null) {
            if (isEndTag(xmlPullParser) && xmlPullParser.getName().equals(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isStartTag(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, xmlPullParser, str)) == null) {
            if (isStartTag(xmlPullParser) && xmlPullParser.getName().equals(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isEndTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xmlPullParser)) == null) {
            if (xmlPullParser.getEventType() == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xmlPullParser)) == null) {
            if (xmlPullParser.getEventType() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
