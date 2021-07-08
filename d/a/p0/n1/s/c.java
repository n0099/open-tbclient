package d.a.p0.n1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.o0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class c implements d.a.p0.n1.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f60701a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.n1.s.b f60702b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f60703c;

    /* loaded from: classes8.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60704a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60704a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || this.f60704a.f60702b == null) {
                return;
            }
            this.f60704a.f60702b.c(j, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) || this.f60704a.f60702b == null) {
                return;
            }
            this.f60704a.f60702b.b(j, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f60704a.f60702b == null) {
                return;
            }
            this.f60704a.f60702b.a(true, dataRes, !z, j, str, i2);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f60705a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f60706b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60707c;

        public b(c cVar, l lVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60705a = lVar;
            this.f60706b = j;
            this.f60707c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.f60705a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f60706b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f60707c) ? "" : this.f60707c);
                byte[] bArr = (byte[]) lVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException unused) {
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* renamed from: d.a.p0.n1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1566c implements n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f60708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f60709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f60710c;

        public C1566c(c cVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60710c = cVar;
            this.f60708a = j;
            this.f60709b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f60710c.f(this.f60708a, this.f60709b, dataRes);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60703c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f60701a = legoPageModel;
        legoPageModel.z(this.f60703c);
    }

    @Override // d.a.p0.n1.s.a
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            i0.b(new b(this, d.a.o0.r.r.a.f().d("tb.lego_update"), j, str), new C1566c(this, j, str));
        }
    }

    @Override // d.a.p0.n1.s.a
    public void b(d.a.p0.n1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f60702b = bVar;
        }
    }

    @Override // d.a.p0.n1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.f60701a) == null) {
            return;
        }
        legoPageModel.x(i2, j, str, i3, str2);
    }

    public final void f(long j, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, dataRes}) == null) || j < 0) {
            return;
        }
        d.a.p0.n1.s.b bVar = this.f60702b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f60701a.x(2, j, str, 1, "");
    }
}
