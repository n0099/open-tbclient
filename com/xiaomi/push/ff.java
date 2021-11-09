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
/* loaded from: classes2.dex */
public class ff {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public XmlPullParser f70940a;

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
            this.f70940a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public gc a(byte[] bArr, fl flVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, flVar)) == null) {
            this.f70940a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
            this.f70940a.next();
            int eventType = this.f70940a.getEventType();
            String name = this.f70940a.getName();
            if (eventType == 2) {
                if (name.equals("message")) {
                    return gk.a(this.f70940a);
                }
                if (name.equals("iq")) {
                    return gk.a(this.f70940a, flVar);
                }
                if (name.equals("presence")) {
                    return gk.m355a(this.f70940a);
                }
                if (this.f70940a.getName().equals("stream")) {
                    return null;
                }
                if (this.f70940a.getName().equals("error")) {
                    throw new fw(gk.m356a(this.f70940a));
                }
                if (!this.f70940a.getName().equals("warning")) {
                    this.f70940a.getName().equals("bind");
                    return null;
                }
                this.f70940a.next();
                this.f70940a.getName().equals("multi-login");
                return null;
            }
            return null;
        }
        return (gc) invokeLL.objValue;
    }
}
