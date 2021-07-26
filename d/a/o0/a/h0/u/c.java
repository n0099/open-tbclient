package d.a.o0.a.h0.u;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.XDetailPageJavaScript;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d.a.o0.a.o0.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.o0.a.o0.d.a> f45747d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("combine");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45747d = new ArrayList();
    }

    @Override // d.a.o0.a.o0.d.a
    public String b(d.a.o0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        String str;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null || this.f45747d.size() <= 0) {
                return null;
            }
            int i2 = 0;
            StringBuilder sb = new StringBuilder();
            for (d.a.o0.a.o0.d.a aVar2 : this.f45747d) {
                String str2 = "event" + i2;
                if (aVar.isWebView()) {
                    str = "var " + str2 + " = new Event('" + aVar2.f47037a + "');";
                    c2 = "";
                } else {
                    str = "var " + str2 + " = new Object();";
                    c2 = d.a.o0.a.o0.a.c(str2, "type", aVar2.f47037a);
                }
                sb.append(str);
                sb.append(c2);
                sb.append(aVar2.f(str2));
                sb.append(d.a.o0.a.o0.a.e(aVar));
                sb.append(".dispatchEvent(");
                sb.append(str2);
                sb.append(");");
                i2++;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("javascript:(function(){");
            stringBuffer.append((CharSequence) sb);
            stringBuffer.append(XDetailPageJavaScript.STATIC_JAVASCRIPT_FUNC_OVER);
            if (d.a.o0.a.o0.d.a.f47036b) {
                Log.d("JSEventDispatcher", "combine msg - " + stringBuffer.toString());
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public c h(d.a.o0.a.o0.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar != null && !this.f45747d.contains(aVar)) {
                this.f45747d.add(aVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }
}
