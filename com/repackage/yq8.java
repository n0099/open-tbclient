package com.repackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes7.dex */
public class yq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public ku4 c;
    public sr4 d;
    public ArrayList<as4> e;
    public long f;
    public UserBlockSetModel g;
    public UserBlockInfoModel h;
    public AdapterView.OnItemClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes7.dex */
    public class a implements qm4<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public a(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qm4
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.k();
                xq8.g((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921690));
            }
        }

        @Override // com.repackage.qm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.k();
                xq8.g((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public b(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        @Override // com.repackage.qm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showToast(str);
        }

        @Override // com.repackage.qm4
        public void onSuccess(Object obj) {
            int i;
            PermissionList permissionList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj instanceof DataRes) {
                    DataRes dataRes = (DataRes) obj;
                    i = dataRes.is_black_white.intValue();
                    permissionList = dataRes.perm_list;
                } else {
                    i = 0;
                    permissionList = null;
                }
                if (permissionList != null) {
                    this.a.m(i, permissionList);
                } else if (this.a.a != null) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f05a5);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public c(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                as4 as4Var = (as4) ListUtils.getItem(this.a.e, i);
                if (as4Var != null) {
                    this.a.d.r(true);
                }
                this.a.d.h(i);
                xq8.a(as4Var, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public d(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public e(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d();
                if (this.a.e == null || !ki.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.a.e.iterator();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    as4 as4Var = (as4) it.next();
                    if (as4Var.d() && "1".equals(as4Var.b())) {
                        i = 1;
                    } else if (as4Var.d() && "2".equals(as4Var.b())) {
                        i2 = 1;
                    } else if (as4Var.d() && "3".equals(as4Var.b())) {
                        i3 = 1;
                    }
                }
                this.a.o();
                this.a.g.E(this.a.f, i, i2, i3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq8 a;

        public f(yq8 yq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.a.b);
            }
        }
    }

    public yq8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.a = tbPageContext;
        this.b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.g = userBlockSetModel;
        userBlockSetModel.F(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.h = userBlockInfoModel;
        userBlockInfoModel.F(new b(this));
    }

    public final String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public final void k() {
        ku4 ku4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ku4Var = this.c) == null) {
            return;
        }
        ku4Var.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = -1L;
            ku4 ku4Var = this.c;
            if (ku4Var != null) {
                ku4Var.h(false);
            }
            sr4 sr4Var = this.d;
            if (sr4Var != null) {
                sr4Var.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.b);
        }
    }

    public final void m(int i, PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, permissionList) == null) {
            boolean z = false;
            boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
            boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
            if (permissionList != null && permissionList.chat.intValue() == 1) {
                z = true;
            }
            ArrayList<as4> arrayList = new ArrayList<>();
            this.e = arrayList;
            if (i == 1) {
                arrayList.add(new as4(j(R.string.obfuscated_res_0x7f0f0313), z2, "1"));
                this.e.add(new as4(j(R.string.obfuscated_res_0x7f0f030e), z3, "2"));
                this.e.add(new as4(j(R.string.obfuscated_res_0x7f0f0314), z, "3"));
            } else {
                arrayList.add(new as4(j(R.string.obfuscated_res_0x7f0f0312), z3, "2"));
                this.e.add(new as4(j(R.string.obfuscated_res_0x7f0f0314), z, "3"));
            }
            sr4 sr4Var = new sr4(this.a);
            this.d = sr4Var;
            sr4Var.l(R.string.obfuscated_res_0x7f0f031b);
            this.d.k(this.e, this.i);
            this.d.q(R.string.obfuscated_res_0x7f0f04ed, this.k);
            this.d.p(R.string.obfuscated_res_0x7f0f0374, this.j);
            sr4 sr4Var2 = this.d;
            sr4Var2.c();
            sr4Var2.n();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f = j;
            this.h.E(j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c == null) {
                ku4 ku4Var = new ku4(this.a);
                this.c = ku4Var;
                ku4Var.e(new f(this));
            }
            this.c.h(true);
        }
    }
}
