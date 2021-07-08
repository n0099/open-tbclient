package d.a.p0.n0.a.g;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f60442a;

    /* renamed from: b  reason: collision with root package name */
    public int f60443b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f60444c;

    /* renamed from: d  reason: collision with root package name */
    public float f60445d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60446e;

    /* renamed from: f  reason: collision with root package name */
    public String f60447f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60448g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f60449h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f60450a;

        /* renamed from: b  reason: collision with root package name */
        public int f60451b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f60452c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f60453d;

        /* renamed from: e  reason: collision with root package name */
        public float f60454e;

        /* renamed from: f  reason: collision with root package name */
        public String f60455f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f60456g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f60457h;

        /* renamed from: i  reason: collision with root package name */
        public String f60458i;
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
            this.f60450a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f60451b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f60454e = 0.0f;
            this.f60456g = false;
            this.f60457h = false;
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
                this.f60451b = i2;
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
                this.f60452c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f60454e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f60458i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f60450a = i2;
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
        this.f60442a = aVar.f60450a;
        this.f60443b = aVar.f60451b;
        this.f60445d = aVar.f60454e;
        String unused = aVar.f60455f;
        this.f60444c = aVar.f60452c;
        List unused2 = aVar.f60453d;
        this.f60446e = aVar.f60456g;
        boolean unused3 = aVar.f60457h;
        this.f60447f = aVar.f60458i;
        this.f60448g = aVar.j;
        this.f60449h = aVar.k;
        long unused4 = aVar.l;
    }
}
