package d.a.s0.r3;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.userblock.UserBlockSetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65144a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f65145b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.r.f0.a f65146c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.r0.r.s.f f65147d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f65148e;

    /* renamed from: f  reason: collision with root package name */
    public long f65149f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f65150g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f65151h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f65152i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.m.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65153a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65153a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f65153a.k();
                d.a.s0.r3.a.f((ViewGroup) this.f65153a.f65144a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // d.a.r0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f65153a.k();
                d.a.s0.r3.a.f((ViewGroup) this.f65153a.f65144a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: d.a.s0.r3.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1661b implements d.a.r0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65154a;

        public C1661b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65154a = bVar;
        }

        @Override // d.a.r0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f65154a.f65144a == null) {
                return;
            }
            this.f65154a.f65144a.showToast(str);
        }

        @Override // d.a.r0.m.a
        public void onSuccess(Object obj) {
            int i2;
            PermissionList permissionList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj instanceof DataRes) {
                    DataRes dataRes = (DataRes) obj;
                    i2 = dataRes.is_black_white.intValue();
                    permissionList = dataRes.perm_list;
                } else {
                    i2 = 0;
                    permissionList = null;
                }
                if (permissionList != null) {
                    this.f65154a.m(i2, permissionList);
                } else if (this.f65154a.f65144a != null) {
                    this.f65154a.f65144a.showToast(R.string.error_unkown_try_again);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65155e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65155e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (((n) ListUtils.getItem(this.f65155e.f65148e, i2)) != null) {
                    this.f65155e.f65147d.r(true);
                }
                this.f65155e.f65147d.h(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65156e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65156e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65156e.f65147d.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65157e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65157e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65157e.f65147d.d();
                if (this.f65157e.f65148e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.f65157e.f65148e.iterator();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (it.hasNext()) {
                    n nVar = (n) it.next();
                    if (nVar.d() && "1".equals(nVar.b())) {
                        i2 = 1;
                    } else if (nVar.d() && "2".equals(nVar.b())) {
                        i3 = 1;
                    } else if (nVar.d() && "3".equals(nVar.b())) {
                        i4 = 1;
                    }
                }
                this.f65157e.o();
                this.f65157e.f65150g.C(this.f65157e.f65149f, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65158e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65158e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f65158e.f65145b);
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f65152i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f65144a = tbPageContext;
        this.f65145b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f65150g = userBlockSetModel;
        userBlockSetModel.D(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f65151h = userBlockInfoModel;
        userBlockInfoModel.D(new C1661b(this));
    }

    public final String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void k() {
        d.a.r0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f65146c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65149f = -1L;
            d.a.r0.r.f0.a aVar = this.f65146c;
            if (aVar != null) {
                aVar.h(false);
            }
            d.a.r0.r.s.f fVar = this.f65147d;
            if (fVar != null) {
                fVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f65151h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f65150g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f65145b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f65145b);
        }
    }

    public final void m(int i2, PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, permissionList) == null) {
            boolean z = false;
            boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
            boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
            if (permissionList != null && permissionList.chat.intValue() == 1) {
                z = true;
            }
            ArrayList<n> arrayList = new ArrayList<>();
            this.f65148e = arrayList;
            if (i2 == 1) {
                arrayList.add(new n(j(R.string.block_follow), z2, "1"));
                this.f65148e.add(new n(j(R.string.block_action), z3, "2"));
                this.f65148e.add(new n(j(R.string.block_message), z, "3"));
            } else {
                arrayList.add(new n(j(R.string.block_commit), z3, "2"));
                this.f65148e.add(new n(j(R.string.block_message), z, "3"));
            }
            d.a.r0.r.s.f fVar = new d.a.r0.r.s.f(this.f65144a);
            this.f65147d = fVar;
            fVar.l(R.string.block_user_title);
            this.f65147d.k(this.f65148e, this.f65152i);
            this.f65147d.q(R.string.done, this.k);
            this.f65147d.p(R.string.cancel, this.j);
            d.a.r0.r.s.f fVar2 = this.f65147d;
            fVar2.c();
            fVar2.n();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f65149f = j;
            this.f65151h.C(j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f65146c == null) {
                d.a.r0.r.f0.a aVar = new d.a.r0.r.f0.a(this.f65144a);
                this.f65146c = aVar;
                aVar.e(new f(this));
            }
            this.f65146c.h(true);
        }
    }
}
