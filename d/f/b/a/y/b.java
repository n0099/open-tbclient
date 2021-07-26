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
    public byte[] f71188a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f71189b;

    /* renamed from: c  reason: collision with root package name */
    public int f71190c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f71191d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f71192e;

    /* renamed from: f  reason: collision with root package name */
    public int f71193f;

    /* renamed from: g  reason: collision with root package name */
    public int f71194g;

    /* renamed from: h  reason: collision with root package name */
    public int f71195h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f71196i;
    public final C1996b j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: d.f.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1996b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f71197a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f71198b;

        public /* synthetic */ C1996b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f71198b.set(i2, i3);
                this.f71197a.setPattern(this.f71198b);
            }
        }

        public C1996b(MediaCodec.CryptoInfo cryptoInfo) {
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
            this.f71197a = cryptoInfo;
            this.f71198b = new MediaCodec.CryptoInfo.Pattern(0, 0);
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
        MediaCodec.CryptoInfo b2 = v.f70969a >= 16 ? b() : null;
        this.f71196i = b2;
        this.j = v.f70969a >= 24 ? new C1996b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71196i : (MediaCodec.CryptoInfo) invokeV.objValue;
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
            this.f71193f = i2;
            this.f71191d = iArr;
            this.f71192e = iArr2;
            this.f71189b = bArr;
            this.f71188a = bArr2;
            this.f71190c = i3;
            this.f71194g = i4;
            this.f71195h = i5;
            if (v.f70969a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f71196i;
            cryptoInfo.numSubSamples = this.f71193f;
            cryptoInfo.numBytesOfClearData = this.f71191d;
            cryptoInfo.numBytesOfEncryptedData = this.f71192e;
            cryptoInfo.key = this.f71189b;
            cryptoInfo.iv = this.f71188a;
            cryptoInfo.mode = this.f71190c;
            if (v.f70969a >= 24) {
                this.j.b(this.f71194g, this.f71195h);
            }
        }
    }
}
