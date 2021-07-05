package d.a.w0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.a.c;
import java.util.Map;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends d.a.w0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f70931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f70932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f70933g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f70934h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70931e = map;
            this.f70932f = aVar;
            this.f70933g = str;
            this.f70934h = str2;
        }

        @Override // d.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70931e != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(StringUtil.ARRAY_START);
                    for (Map.Entry entry : this.f70931e.entrySet()) {
                        stringBuffer.append("\"");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("\":\"");
                        stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                        stringBuffer.append("\",");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                    stringBuffer2.append("}");
                    this.f70932f.w(stringBuffer2.toString());
                }
                try {
                    this.f70932f.x(m.e().I());
                    this.f70932f.u(String.valueOf(System.currentTimeMillis()));
                    this.f70932f.t(this.f70933g);
                    this.f70932f.s(this.f70934h == null ? "" : this.f70934h);
                    new c.b().c(this.f70932f);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        d.a.w0.a.f.a.b(e2.getMessage());
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, map) == null) {
            com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
            aVar.v(str);
            d.a.w0.a.f.b.c(new a(map, aVar, str2, str3));
        }
    }
}
