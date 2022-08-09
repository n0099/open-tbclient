package com.repackage;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class jz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements hh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;
        public final /* synthetic */ SubPbModel b;

        public a(qz7 qz7Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
            this.b = subPbModel;
        }

        @Override // com.repackage.hh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.repackage.hh5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && (this.a.B() instanceof BdTypeListView)) {
                List<on> data = ((BdTypeListView) this.a.B()).getData();
                if (ListUtils.isEmpty(data) || ListUtils.isEmpty(list)) {
                    return;
                }
                Iterator<on> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    on next = it.next();
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).K())) {
                                it.remove();
                                if (this.b.m0() != null) {
                                    this.b.m0().F(this.b.m0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof zz7) {
                        ((zz7) data.get(i)).b(this.b.m0().m());
                    }
                    i++;
                }
                ((BdTypeListView) this.a.B()).setData(data);
                this.a.T();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            gh5.b().a();
        }
    }

    public static jh5 b(SubPbModel subPbModel, qz7 qz7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, qz7Var)) == null) {
            if (subPbModel == null || qz7Var == null) {
                return null;
            }
            jh5 jh5Var = new jh5();
            jh5Var.p(subPbModel.o0());
            jh5Var.o(subPbModel.n0());
            jh5Var.n(subPbModel.r0());
            if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                jh5Var.l(subPbModel.m0().d().getId());
                jh5Var.m(subPbModel.m0().d().getName());
                jh5Var.k(subPbModel.m0().d().getImage_url());
                jh5Var.t(subPbModel.m0().d().getUser_level());
            }
            UserData userData = new UserData();
            userData.setIsManager(subPbModel.t0());
            jh5Var.s(userData);
            jh5Var.q(new a(qz7Var, subPbModel));
            AntiData k0 = subPbModel.k0();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (k0 != null && k0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            jh5Var.r(sparseArray);
            return jh5Var;
        }
        return (jh5) invokeLL.objValue;
    }

    public static boolean c(vt7 vt7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vt7Var, postData)) == null) {
            if (vt7Var == null || postData == null || vt7Var.d() == null || vt7Var.l() == null) {
                return false;
            }
            lh5 lh5Var = new lh5();
            lh5Var.d(vt7Var.d().getId());
            lh5Var.f(vt7Var.l().getId());
            lh5Var.e(postData.K());
            return gh5.b().c(lh5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, qz7 qz7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, qz7Var) == null) || tbPageContext == null || qz7Var == null || qz7Var.u() == null || subPbModel == null) {
            return;
        }
        gh5.b().e(tbPageContext, (ViewGroup) qz7Var.u(), b(subPbModel, qz7Var));
        gh5.b().d(3);
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return gh5.b().f(postData.K());
        }
        return invokeL.booleanValue;
    }
}
