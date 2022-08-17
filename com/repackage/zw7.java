package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zw7 extends aw7<xw7, PbPageNewsInfoHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public et7 g;
    public PbPageNewsInfoHolder.b h;

    /* loaded from: classes8.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw7 a;

        public a(zw7 zw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(xw7 xw7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, xw7Var) == null) || xw7Var == null) {
                return;
            }
            h08.a(this.a.g, xw7Var, xw7Var.b0, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s08) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
    }

    @Override // com.repackage.aw7, com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w(i, view2, viewGroup, (xw7) obj, (PbPageNewsInfoHolder) viewHolder);
        return view2;
    }

    public void r(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, et7Var) == null) {
            this.g = et7Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public PbPageNewsInfoHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new PbPageNewsInfoHolder(this.b.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06c4, viewGroup, false), this.h) : (PbPageNewsInfoHolder) invokeL.objValue;
    }

    public View w(int i, View view2, ViewGroup viewGroup, xw7 xw7Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xw7Var, pbPageNewsInfoHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, xw7Var, pbPageNewsInfoHolder);
            if (xw7Var == null) {
                return view2;
            }
            xw7Var.b0 = i + 1;
            h08.d(this.b.getUniqueId(), this.g, xw7Var, xw7Var.b0, 5);
            pbPageNewsInfoHolder.g(xw7Var);
            pbPageNewsInfoHolder.h(TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
