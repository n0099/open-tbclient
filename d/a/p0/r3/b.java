package d.a.p0.r3;

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
import d.a.o0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61922a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f61923b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.r.f0.a f61924c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.r.s.f f61925d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f61926e;

    /* renamed from: f  reason: collision with root package name */
    public long f61927f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f61928g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f61929h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f61930i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements d.a.o0.m.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61931a;

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
            this.f61931a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f61931a.k();
                d.a.p0.r3.a.f((ViewGroup) this.f61931a.f61922a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // d.a.o0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f61931a.k();
                d.a.p0.r3.a.f((ViewGroup) this.f61931a.f61922a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: d.a.p0.r3.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1619b implements d.a.o0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61932a;

        public C1619b(b bVar) {
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
            this.f61932a = bVar;
        }

        @Override // d.a.o0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f61932a.f61922a == null) {
                return;
            }
            this.f61932a.f61922a.showToast(str);
        }

        @Override // d.a.o0.m.a
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
                    this.f61932a.m(i2, permissionList);
                } else if (this.f61932a.f61922a != null) {
                    this.f61932a.f61922a.showToast(R.string.error_unkown_try_again);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61933e;

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
            this.f61933e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (((n) ListUtils.getItem(this.f61933e.f61926e, i2)) != null) {
                    this.f61933e.f61925d.r(true);
                }
                this.f61933e.f61925d.h(i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61934e;

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
            this.f61934e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61934e.f61925d.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61935e;

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
            this.f61935e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61935e.f61925d.d();
                if (this.f61935e.f61926e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.f61935e.f61926e.iterator();
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
                this.f61935e.o();
                this.f61935e.f61928g.C(this.f61935e.f61927f, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61936e;

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
            this.f61936e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f61936e.f61923b);
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
        this.f61930i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f61922a = tbPageContext;
        this.f61923b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f61928g = userBlockSetModel;
        userBlockSetModel.D(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f61929h = userBlockInfoModel;
        userBlockInfoModel.D(new C1619b(this));
    }

    public final String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void k() {
        d.a.o0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f61924c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61927f = -1L;
            d.a.o0.r.f0.a aVar = this.f61924c;
            if (aVar != null) {
                aVar.h(false);
            }
            d.a.o0.r.s.f fVar = this.f61925d;
            if (fVar != null) {
                fVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f61929h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f61928g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f61923b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f61923b);
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
            this.f61926e = arrayList;
            if (i2 == 1) {
                arrayList.add(new n(j(R.string.block_follow), z2, "1"));
                this.f61926e.add(new n(j(R.string.block_action), z3, "2"));
                this.f61926e.add(new n(j(R.string.block_message), z, "3"));
            } else {
                arrayList.add(new n(j(R.string.block_commit), z3, "2"));
                this.f61926e.add(new n(j(R.string.block_message), z, "3"));
            }
            d.a.o0.r.s.f fVar = new d.a.o0.r.s.f(this.f61922a);
            this.f61925d = fVar;
            fVar.l(R.string.block_user_title);
            this.f61925d.k(this.f61926e, this.f61930i);
            this.f61925d.q(R.string.done, this.k);
            this.f61925d.p(R.string.cancel, this.j);
            d.a.o0.r.s.f fVar2 = this.f61925d;
            fVar2.c();
            fVar2.n();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f61927f = j;
            this.f61929h.C(j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f61924c == null) {
                d.a.o0.r.f0.a aVar = new d.a.o0.r.f0.a(this.f61922a);
                this.f61924c = aVar;
                aVar.e(new f(this));
            }
            this.f61924c.h(true);
        }
    }
}
