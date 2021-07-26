package d.a.q0.h2.k.e.f1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.h2.h.e;
import d.a.q0.h2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f57846a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f57847b;

    /* renamed from: c  reason: collision with root package name */
    public t0 f57848c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f57849d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.p0.n.a f57850e;

    /* renamed from: d.a.q0.h2.k.e.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1431a implements d.a.p0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57851a;

        public C1431a(a aVar) {
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
            this.f57851a = aVar;
        }

        @Override // d.a.p0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f57851a.f57848c == null || this.f57851a.f57848c.G0() == null) {
                return;
            }
            this.f57851a.f57848c.G0().K();
        }

        @Override // d.a.p0.n.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f57851a.f57849d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    e L0 = this.f57851a.f57849d.L0();
                    String first_class = L0.m() != null ? L0.m().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f57851a.f57848c == null || this.f57851a.f57848c.G0() == null) {
                            return;
                        }
                        this.f57851a.f57848c.G0().K();
                        return;
                    }
                    this.f57851a.f57846a.addAll(b.b(list, first_class, this.f57851a.f57849d.K0()));
                    L0.D0(this.f57851a.f57846a);
                    Integer num = dataRes.rec_type;
                    L0.A0(num == null ? 0 : num.intValue());
                }
                if (this.f57851a.f57848c != null && !ListUtils.isEmpty(this.f57851a.f57846a)) {
                    this.f57851a.f57848c.i3();
                }
                if (this.f57851a.f57848c.G0() == null || !this.f57851a.f57848c.G0().m() || ListUtils.isEmpty(this.f57851a.f57846a)) {
                    return;
                }
                this.f57851a.f57848c.G0().j();
            }
        }
    }

    public a(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId, t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, t0Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57846a = new ArrayList();
        this.f57850e = new C1431a(this);
        this.f57848c = t0Var;
        this.f57849d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f57847b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f57850e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f57849d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.b1()) || this.f57849d.L0() == null || this.f57849d.L0().Y()) {
                return false;
            }
            int Z = this.f57849d.Z();
            int K0 = this.f57849d.K0();
            if (Z == 1 || K0 == 2 || K0 == 3) {
                String forumId = this.f57849d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f57849d.L0().m() != null) {
                    forumId = this.f57849d.L0().m().getId();
                }
                long f2 = d.a.d.e.m.b.f(forumId, 0L);
                long f3 = d.a.d.e.m.b.f(this.f57849d.b1(), 0L);
                Log.e("RecThreadList", "************reqRecThreadList************");
                return this.f57847b.C(f2, f3, Z, K0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57846a.clear();
            this.f57847b.onDestroy();
        }
    }

    public void f(t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t0Var, pbModel) == null) {
            this.f57848c = t0Var;
            this.f57849d = pbModel;
        }
    }
}
