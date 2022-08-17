package com.repackage;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements hh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ mx7 b;

        public a(PbModel pbModel, mx7 mx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, mx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = mx7Var;
        }

        @Override // com.repackage.hh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.u4(false);
            }
        }

        @Override // com.repackage.hh5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.a.S1() == null) {
                return;
            }
            ArrayList<PostData> F = this.a.S1().F();
            if (ListUtils.isEmpty(F) || ListUtils.isEmpty(list)) {
                return;
            }
            Iterator<PostData> it = F.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    } else if (TextUtils.equals(list.get(i), next.K())) {
                        it.remove();
                        if (this.a.S1().O() != null) {
                            this.a.S1().O().setReply_num(this.a.S1().O().getReply_num() - 1);
                        }
                    } else {
                        i++;
                    }
                }
            }
            this.b.F1(this.a.S1());
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            gh5.b().a();
        }
    }

    public static jh5 b(PbModel pbModel, mx7 mx7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, mx7Var)) == null) {
            if (pbModel == null || mx7Var == null) {
                return null;
            }
            jh5 jh5Var = new jh5();
            if (pbModel.S1() != null && pbModel.S1().l() != null) {
                if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                    jh5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    jh5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                jh5Var.l(pbModel.S1().l().getId());
                jh5Var.m(pbModel.S1().l().getName());
                jh5Var.k(pbModel.S1().l().getImage_url());
                jh5Var.t(pbModel.S1().l().getUser_level());
            }
            if (pbModel.S1() != null && pbModel.S1().o() != null) {
                jh5Var.n(pbModel.S1().o().has_forum_rule.intValue());
            }
            if (pbModel.S1() != null && pbModel.S1().V() != null) {
                jh5Var.s(pbModel.S1().V());
            }
            jh5Var.q(new a(pbModel, mx7Var));
            if (pbModel.S1() != null) {
                AntiData d = pbModel.S1().d();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (d != null && d.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                jh5Var.r(sparseArray);
            }
            return jh5Var;
        }
        return (jh5) invokeLL.objValue;
    }

    public static boolean c(et7 et7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, et7Var, postData)) == null) {
            if (et7Var == null || postData == null) {
                return false;
            }
            lh5 lh5Var = new lh5();
            lh5Var.d(postData.G() + "");
            if (et7Var.O() != null) {
                lh5Var.f(et7Var.O().getId());
            }
            lh5Var.e(postData.K());
            return gh5.b().c(lh5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, mx7 mx7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, mx7Var) == null) || tbPageContext == null || pbModel == null || mx7Var == null) {
            return;
        }
        gh5.b().e(tbPageContext, (ViewGroup) mx7Var.m1(), b(pbModel, mx7Var));
        gh5.b().d(1);
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
