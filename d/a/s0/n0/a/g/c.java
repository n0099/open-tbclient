package d.a.s0.n0.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.LocalAlbumInfo;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.Buffer;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f63676a;

    /* renamed from: b  reason: collision with root package name */
    public int f63677b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f63678c;

    /* renamed from: d  reason: collision with root package name */
    public float f63679d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63680e;

    /* renamed from: f  reason: collision with root package name */
    public String f63681f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63682g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f63683h;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63684a;

        /* renamed from: b  reason: collision with root package name */
        public int f63685b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f63686c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f63687d;

        /* renamed from: e  reason: collision with root package name */
        public float f63688e;

        /* renamed from: f  reason: collision with root package name */
        public String f63689f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63690g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f63691h;

        /* renamed from: i  reason: collision with root package name */
        public String f63692i;
        public boolean j;
        public Buffer k;
        public long l;

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
                    return;
                }
            }
            this.f63684a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f63685b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f63688e = 0.0f;
            this.f63690g = false;
            this.f63691h = false;
            this.j = false;
        }

        public c m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (c) invokeV.objValue;
        }

        public a n(Buffer buffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer)) == null) {
                this.k = buffer;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f63685b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a q(MultiMediaData multiMediaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiMediaData)) == null) {
                this.f63686c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f63688e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f63692i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f63684a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63676a = aVar.f63684a;
        this.f63677b = aVar.f63685b;
        this.f63679d = aVar.f63688e;
        String unused = aVar.f63689f;
        this.f63678c = aVar.f63686c;
        List unused2 = aVar.f63687d;
        this.f63680e = aVar.f63690g;
        boolean unused3 = aVar.f63691h;
        this.f63681f = aVar.f63692i;
        this.f63682g = aVar.j;
        this.f63683h = aVar.k;
        long unused4 = aVar.l;
    }
}
