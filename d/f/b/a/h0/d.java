package d.f.b.a.h0;

import android.net.Uri;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.net.URLDecoder;
/* loaded from: classes8.dex */
public final class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f70375a;

    /* renamed from: b  reason: collision with root package name */
    public int f70376b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f70377c;

    public d() {
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

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            this.f70375a = gVar;
            Uri uri = gVar.f70383a;
            String scheme = uri.getScheme();
            if ("data".equals(scheme)) {
                String[] split = uri.getSchemeSpecificPart().split(",");
                if (split.length <= 2) {
                    String str = split[1];
                    if (split[0].contains(DataUrlLoader.BASE64_TAG)) {
                        try {
                            this.f70377c = Base64.decode(str, 0);
                        } catch (IllegalArgumentException e2) {
                            throw new ParserException("Error while parsing Base64 encoded string: " + str, e2);
                        }
                    } else {
                        this.f70377c = URLDecoder.decode(str, "US-ASCII").getBytes();
                    }
                    return this.f70377c.length;
                }
                throw new ParserException("Unexpected URI format: " + uri);
            }
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        return invokeL.longValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70375a = null;
            this.f70377c = null;
        }
    }

    @Override // d.f.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.f70375a;
            if (gVar != null) {
                return gVar.f70383a;
            }
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            int length = this.f70377c.length - this.f70376b;
            if (length == 0) {
                return -1;
            }
            int min = Math.min(i3, length);
            System.arraycopy(this.f70377c, this.f70376b, bArr, i2, min);
            this.f70376b += min;
            return min;
        }
        return invokeLII.intValue;
    }
}
