package com.repackage;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class es7<T, V extends TypeAdapter.ViewHolder> extends wm<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pw7 i;
    public PbFragment j;
    public AbsVideoPbFragment k;
    public int l;
    public boolean m;
    public SparseIntArray n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es7(pw7 pw7Var, BdUniqueId bdUniqueId) {
        super(pw7Var == null ? null : pw7Var.w(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pw7Var, bdUniqueId};
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
        this.l = 3;
        this.m = false;
        new SparseArray();
        this.n = new SparseIntArray();
        a0(pw7Var);
    }

    @Override // com.repackage.wm
    public View S(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            this.l = TbadkCoreApplication.getInst().getSkinType();
            ln lnVar = (ln) viewGroup;
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public int Z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.n.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.n.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void a0(pw7 pw7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pw7Var) == null) || pw7Var == null) {
            return;
        }
        this.i = pw7Var;
        this.j = pw7Var.z0();
        AbsVideoPbFragment s = pw7Var.s();
        this.k = s;
        PbFragment pbFragment = this.j;
        if (pbFragment != null) {
            this.a = pbFragment.getActivity();
        } else if (s != null) {
            this.a = s.getActivity();
        } else {
            this.a = null;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.m = z;
        }
    }
}
