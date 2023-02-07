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
/* loaded from: classes8.dex */
public class fq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XmlPullParser a;

    public fq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public gn a(byte[] bArr, fw fwVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, fwVar)) == null) {
            this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
            this.a.next();
            int eventType = this.a.getEventType();
            String name = this.a.getName();
            if (eventType == 2) {
                if (name.equals("message")) {
                    return gv.a(this.a);
                }
                if (name.equals("iq")) {
                    return gv.a(this.a, fwVar);
                }
                if (name.equals("presence")) {
                    return gv.m453a(this.a);
                }
                if (this.a.getName().equals("stream")) {
                    return null;
                }
                if (this.a.getName().equals("error")) {
                    throw new gh(gv.m454a(this.a));
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
        return (gn) invokeLL.objValue;
    }
}
