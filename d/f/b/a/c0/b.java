package d.f.b.a.c0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes10.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f72612a = new a();

    /* loaded from: classes10.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // d.f.b.a.c0.b
        public boolean a(Format format) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, format)) == null) {
                String str = format.sampleMimeType;
                return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
            }
            return invokeL.booleanValue;
        }

        @Override // d.f.b.a.c0.b
        public d.f.b.a.c0.a b(Format format) {
            InterceptResult invokeL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format)) == null) {
                String str = format.sampleMimeType;
                int hashCode = str.hashCode();
                if (hashCode == -1248341703) {
                    if (str.equals("application/id3")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else if (hashCode != 1154383568) {
                    if (hashCode == 1652648887 && str.equals("application/x-scte35")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("application/x-emsg")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 == 2) {
                            return new d.f.b.a.c0.h.a();
                        }
                        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    }
                    return new d.f.b.a.c0.f.a();
                }
                return new d.f.b.a.c0.g.a();
            }
            return (d.f.b.a.c0.a) invokeL.objValue;
        }
    }

    boolean a(Format format);

    d.f.b.a.c0.a b(Format format);
}
