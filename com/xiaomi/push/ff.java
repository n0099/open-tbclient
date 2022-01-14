package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes4.dex */
public class ff {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XmlPullParser a;

    public ff() {
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
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, flVar)) == null) {
            this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
            this.a.next();
            int eventType = this.a.getEventType();
            String name = this.a.getName();
            if (eventType == 2) {
                if (name.equals("message")) {
                    return gk.a(this.a);
                }
                if (name.equals("iq")) {
                    return gk.a(this.a, flVar);
                }
                if (name.equals("presence")) {
                    return gk.m416a(this.a);
                }
                if (this.a.getName().equals("stream")) {
                    return null;
                }
                if (this.a.getName().equals("error")) {
                    throw new fw(gk.m417a(this.a));
                }
                if (!this.a.getName().equals("warning")) {
                    this.a.getName().equals("bind");
                    return null;
                }
                this.a.next();
                this.a.getName().equals("multi-login");
                return null;
            }
            return null;
        }
        return (gc) invokeLL.objValue;
    }
}
