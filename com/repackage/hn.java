package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hn<V extends TypeAdapter.ViewHolder> extends an<gn, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public an<nn, V> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.an
    public V M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) ? N(viewGroup, new gn()) : (V) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: Z */
    public V N(ViewGroup viewGroup, gn gnVar) {
        InterceptResult invokeLL;
        V M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, gnVar)) == null) {
            an<nn, V> anVar = this.i;
            if (anVar == null) {
                return null;
            }
            if (this.d == anVar.x()) {
                M = this.i.L(viewGroup, gnVar.c());
            } else if (this.d == this.i.v()) {
                M = this.i.I(viewGroup, gnVar.c());
            } else if (this.d == this.i.w()) {
                M = this.i.J(viewGroup, gnVar.c());
            } else if (this.d == this.i.u()) {
                M = this.i.H(viewGroup, gnVar.c());
            } else {
                M = this.i.M(viewGroup);
            }
            if (M != null) {
                V(this.i.z());
                return M;
            }
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, gn gnVar, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gnVar, v})) == null) {
            an<nn, V> anVar = this.i;
            if (anVar == null) {
                return null;
            }
            if (this.d == anVar.x()) {
                return this.i.R(i, view2, viewGroup, gnVar.c(), v);
            }
            if (this.d == this.i.v()) {
                return this.i.P(i, view2, viewGroup, gnVar.c(), v);
            }
            if (this.d == this.i.w()) {
                return this.i.Q(i, view2, viewGroup, gnVar.c(), v);
            }
            if (this.d == this.i.u()) {
                return this.i.O(i, view2, viewGroup, gnVar.c(), v);
            }
            return this.i.S(i, view2, viewGroup, gnVar.c(), v);
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(an anVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, anVar) == null) {
            this.i = anVar;
        }
    }
}
