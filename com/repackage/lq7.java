package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lq7 extends bn<uq7, InterestedForumStyleAMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ar7 a;
    public br7 b;

    /* loaded from: classes6.dex */
    public class a implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq7 a;

        public a(lq7 lq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq7Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof uq7)) {
                uq7 uq7Var = (uq7) onVar;
                if (this.a.a != null) {
                    this.a.a.d(uq7Var.a(), uq7Var.b(), i);
                }
                if (this.a.b != null) {
                    this.a.b.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lq7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.mContext = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uq7 uq7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        v(i, view2, viewGroup, uq7Var, interestedForumStyleAMoreViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public InterestedForumStyleAMoreViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new InterestedForumStyleAMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d03eb, viewGroup, false)) : (InterestedForumStyleAMoreViewHolder) invokeL.objValue;
    }

    public View v(int i, View view2, ViewGroup viewGroup, uq7 uq7Var, InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uq7Var, interestedForumStyleAMoreViewHolder})) == null) {
            z(interestedForumStyleAMoreViewHolder);
            w(interestedForumStyleAMoreViewHolder, uq7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void w(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder, uq7 uq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, interestedForumStyleAMoreViewHolder, uq7Var) == null) {
            interestedForumStyleAMoreViewHolder.c.setText(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0939));
            if (uq7Var.c()) {
                interestedForumStyleAMoreViewHolder.b.setVisibility(0);
            } else {
                interestedForumStyleAMoreViewHolder.b.setVisibility(8);
            }
        }
    }

    public void x(ar7 ar7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ar7Var) == null) {
            this.a = ar7Var;
        }
    }

    public void y(br7 br7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, br7Var) == null) {
            this.b = br7Var;
        }
    }

    public final void z(InterestedForumStyleAMoreViewHolder interestedForumStyleAMoreViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interestedForumStyleAMoreViewHolder) == null) {
            ms4 d = ms4.d(interestedForumStyleAMoreViewHolder.c);
            d.v(R.color.CAM_X0302);
            d.z(R.dimen.T_X07);
            ms4.d(interestedForumStyleAMoreViewHolder.d).f(R.color.CAM_X0206);
        }
    }
}
