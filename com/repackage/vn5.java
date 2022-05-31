package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernOfflineViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vn5 extends wm<zn5, LiveTabConcernOfflineViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public nw5<zn5> j;

    /* loaded from: classes7.dex */
    public class a extends nw5<zn5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn5 b;

        public a(vn5 vn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vn5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, zn5 zn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zn5Var) == null) {
                this.b.a0(zn5Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vn5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), zn5.g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.i = tbPageContext;
    }

    public final void a0(zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zn5Var) == null) || zn5Var == null) {
            return;
        }
        String str = zn5Var.a;
        if (StringUtils.isNull(str) || jg.g(str, 0L) == 0) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.i.getPageActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.i.getPageActivity()).createNormalConfig(jg.g(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public LiveTabConcernOfflineViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            io5 io5Var = new io5(this.i, viewGroup);
            io5Var.n(this.j);
            return new LiveTabConcernOfflineViewHolder(io5Var);
        }
        return (LiveTabConcernOfflineViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, zn5 zn5Var, LiveTabConcernOfflineViewHolder liveTabConcernOfflineViewHolder) {
        InterceptResult invokeCommon;
        io5 io5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zn5Var, liveTabConcernOfflineViewHolder})) == null) {
            if (liveTabConcernOfflineViewHolder == null || (io5Var = liveTabConcernOfflineViewHolder.a) == null) {
                return null;
            }
            io5Var.l(zn5Var);
            return liveTabConcernOfflineViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
