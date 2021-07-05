package d.a.q0.a.n1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes8.dex */
public class h extends ResponseBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ResponseBody f49629e;

    /* renamed from: f  reason: collision with root package name */
    public final e f49630f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f49631g;

    /* loaded from: classes8.dex */
    public class a extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f49632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f49633f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, Source source) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Source) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49633f = hVar;
            this.f49632e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, buffer, j)) == null) {
                long read = super.read(buffer, j);
                int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
                this.f49632e += i2 != 0 ? read : 0L;
                this.f49633f.f49630f.a(this.f49632e, this.f49633f.f49629e.contentLength(), i2 == 0);
                return read;
            }
            return invokeLJ.longValue;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {responseBody, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49629e = responseBody;
        this.f49630f = eVar;
    }

    public final Source c(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, source)) == null) ? new a(this, source) : (Source) invokeL.objValue;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49629e.contentLength() : invokeV.longValue;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49629e.contentType() : (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f49631g == null) {
                this.f49631g = Okio.buffer(c(this.f49629e.source()));
            }
            return this.f49631g;
        }
        return (BufferedSource) invokeV.objValue;
    }
}
