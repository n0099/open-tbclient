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
/* loaded from: classes5.dex */
public class et7 extends es7<ct7, PbPageNewsInfoHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp7 o;
    public PbPageNewsInfoHolder.b p;

    /* loaded from: classes5.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et7 a;

        public a(et7 et7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(ct7 ct7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ct7Var) == null) || ct7Var == null) {
                return;
            }
            ew7.a(this.a.o, ct7Var, ct7Var.h0, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((pw7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
    }

    @Override // com.repackage.es7, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        d0(i, view2, viewGroup, (ct7) obj, (PbPageNewsInfoHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public PbPageNewsInfoHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbPageNewsInfoHolder(this.j.getPageContext(), LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d067c, viewGroup, false), this.p) : (PbPageNewsInfoHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, ct7 ct7Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ct7Var, pbPageNewsInfoHolder})) == null) {
            super.S(i, view2, viewGroup, ct7Var, pbPageNewsInfoHolder);
            if (ct7Var == null) {
                return view2;
            }
            ct7Var.h0 = i + 1;
            ew7.d(this.j.getUniqueId(), this.o, ct7Var, ct7Var.h0, 5);
            pbPageNewsInfoHolder.i(ct7Var);
            pbPageNewsInfoHolder.j(TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kp7Var) == null) {
            this.o = kp7Var;
        }
    }
}
