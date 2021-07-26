package d.a.q0.n0.a.g;

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
    public int f61056a;

    /* renamed from: b  reason: collision with root package name */
    public int f61057b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f61058c;

    /* renamed from: d  reason: collision with root package name */
    public float f61059d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61060e;

    /* renamed from: f  reason: collision with root package name */
    public String f61061f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61062g;

    /* renamed from: h  reason: collision with root package name */
    public Buffer f61063h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f61064a;

        /* renamed from: b  reason: collision with root package name */
        public int f61065b;

        /* renamed from: c  reason: collision with root package name */
        public MultiMediaData f61066c;

        /* renamed from: d  reason: collision with root package name */
        public List<LocalAlbumInfo> f61067d;

        /* renamed from: e  reason: collision with root package name */
        public float f61068e;

        /* renamed from: f  reason: collision with root package name */
        public String f61069f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f61070g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61071h;

        /* renamed from: i  reason: collision with root package name */
        public String f61072i;
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
            this.f61064a = RecordConstants.VIDEO_CONSTANT_WIDTH;
            this.f61065b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            this.f61068e = 0.0f;
            this.f61070g = false;
            this.f61071h = false;
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
                this.f61065b = i2;
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
                this.f61066c = multiMediaData;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a r(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                this.f61068e = f2;
                return this;
            }
            return (a) invokeF.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f61072i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.f61064a = i2;
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
        this.f61056a = aVar.f61064a;
        this.f61057b = aVar.f61065b;
        this.f61059d = aVar.f61068e;
        String unused = aVar.f61069f;
        this.f61058c = aVar.f61066c;
        List unused2 = aVar.f61067d;
        this.f61060e = aVar.f61070g;
        boolean unused3 = aVar.f61071h;
        this.f61061f = aVar.f61072i;
        this.f61062g = aVar.j;
        this.f61063h = aVar.k;
        long unused4 = aVar.l;
    }
}
