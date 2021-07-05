package d.f.b.a.b0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
/* loaded from: classes10.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f72611a = new a();

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

        @Override // d.f.b.a.b0.b
        public d.f.b.a.b0.a a(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) ? MediaCodecUtil.f(str, z) : (d.f.b.a.b0.a) invokeLZ.objValue;
        }

        @Override // d.f.b.a.b0.b
        public d.f.b.a.b0.a b() throws MediaCodecUtil.DecoderQueryException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MediaCodecUtil.j() : (d.f.b.a.b0.a) invokeV.objValue;
        }
    }

    d.f.b.a.b0.a a(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    d.f.b.a.b0.a b() throws MediaCodecUtil.DecoderQueryException;
}
