package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernNotificationViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class up5 extends an<yp5, LiveTabConcernNotificationViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public boolean j;
    public jy5<yp5> k;

    /* loaded from: classes7.dex */
    public class a extends jy5<yp5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up5 b;

        public a(up5 up5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = up5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, yp5 yp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yp5Var) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090df9) {
                    if (this.b.j) {
                        return;
                    }
                    this.b.j = true;
                    AlaSharedPrefHelper.getInstance().putLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, System.currentTimeMillis());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921421));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090dfa) {
                    bq5.b(this.b.i);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), yp5.a);
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
        this.j = false;
        this.k = new a(this);
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public LiveTabConcernNotificationViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            hq5 hq5Var = new hq5(this.i, viewGroup);
            hq5Var.n(this.k);
            return new LiveTabConcernNotificationViewHolder(hq5Var);
        }
        return (LiveTabConcernNotificationViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, yp5 yp5Var, LiveTabConcernNotificationViewHolder liveTabConcernNotificationViewHolder) {
        InterceptResult invokeCommon;
        hq5 hq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yp5Var, liveTabConcernNotificationViewHolder})) == null) {
            if (liveTabConcernNotificationViewHolder == null || (hq5Var = liveTabConcernNotificationViewHolder.a) == null) {
                return null;
            }
            this.j = false;
            hq5Var.i(yp5Var);
            return liveTabConcernNotificationViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
