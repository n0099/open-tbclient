package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z08 extends eo<v08, PersonCenterIntervalHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z08(Context context, BdUniqueId bdUniqueId) {
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, v08 v08Var, PersonCenterIntervalHolder personCenterIntervalHolder) {
        a0(i, view2, viewGroup, v08Var, personCenterIntervalHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: Z */
    public PersonCenterIntervalHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCenterIntervalHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03fe, viewGroup, false)) : (PersonCenterIntervalHolder) invokeL.objValue;
    }

    public View a0(int i, View view2, ViewGroup viewGroup, v08 v08Var, PersonCenterIntervalHolder personCenterIntervalHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, v08Var, personCenterIntervalHolder})) == null) {
            if (v08Var != null && personCenterIntervalHolder != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (personCenterIntervalHolder.a != skinType) {
                    personCenterIntervalHolder.a = skinType;
                    SkinManager.setBackgroundResource(personCenterIntervalHolder.b, v08Var.c);
                }
                ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.b.getLayoutParams();
                int i2 = v08Var.a;
                if (i2 > 0) {
                    layoutParams.height = i2;
                }
                int i3 = v08Var.b;
                if (i3 > 0) {
                    layoutParams.width = i3;
                }
                personCenterIntervalHolder.b.setLayoutParams(layoutParams);
                personCenterIntervalHolder.b.setOnClickListener(null);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
