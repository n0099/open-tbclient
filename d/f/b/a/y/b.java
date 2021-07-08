package d.f.b.a.y;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f70734a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f70735b;

    /* renamed from: c  reason: collision with root package name */
    public int f70736c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f70737d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f70738e;

    /* renamed from: f  reason: collision with root package name */
    public int f70739f;

    /* renamed from: g  reason: collision with root package name */
    public int f70740g;

    /* renamed from: h  reason: collision with root package name */
    public int f70741h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f70742i;
    public final C1997b j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: d.f.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1997b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f70743a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f70744b;

        public /* synthetic */ C1997b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f70744b.set(i2, i3);
                this.f70743a.setPattern(this.f70744b);
            }
        }

        public C1997b(MediaCodec.CryptoInfo cryptoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cryptoInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70743a = cryptoInfo;
            this.f70744b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public b() {
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
        MediaCodec.CryptoInfo b2 = v.f70515a >= 16 ? b() : null;
        this.f70742i = b2;
        this.j = v.f70515a >= 24 ? new C1997b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70742i : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new MediaCodec.CryptoInfo() : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), iArr, iArr2, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.f70739f = i2;
            this.f70737d = iArr;
            this.f70738e = iArr2;
            this.f70735b = bArr;
            this.f70734a = bArr2;
            this.f70736c = i3;
            this.f70740g = i4;
            this.f70741h = i5;
            if (v.f70515a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f70742i;
            cryptoInfo.numSubSamples = this.f70739f;
            cryptoInfo.numBytesOfClearData = this.f70737d;
            cryptoInfo.numBytesOfEncryptedData = this.f70738e;
            cryptoInfo.key = this.f70735b;
            cryptoInfo.iv = this.f70734a;
            cryptoInfo.mode = this.f70736c;
            if (v.f70515a >= 24) {
                this.j.b(this.f70740g, this.f70741h);
            }
        }
    }
}
