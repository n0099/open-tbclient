package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zg6 extends cd6<qh8, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public boolean u;

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public View c;
        public TextView d;
        public View e;
        public View f;
        public TextView g;
        public View h;
        public View i;
        public View j;
        public List<View> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new ArrayList();
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ac4);
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090ac6);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b69);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090b4a);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090aa1);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090aa2);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f091624);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f091625);
            this.j = view2.findViewById(R.id.obfuscated_res_0x7f091623);
            this.k.add(this.h);
            this.k.add(this.i);
            this.k.add(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.u = z;
    }

    public final void l0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view2 : list) {
                view2.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: m0 */
    public a M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02fb, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: n0 */
    public View S(int i, View view2, ViewGroup viewGroup, qh8 qh8Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qh8Var, aVar})) == null) {
            super.S(i, view2, viewGroup, qh8Var, aVar);
            boolean z = true;
            if (qh8Var.g()) {
                String c = qh8Var.c();
                if (c != null) {
                    aVar.b.setText(c);
                } else {
                    FrsViewData frsViewData = this.j;
                    if (frsViewData != null && frsViewData.getForum() != null && this.j.getForum().getName() != null) {
                        TextView textView = aVar.b;
                        Context context = this.a;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.j;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f079e, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.h.setVisibility(8);
            }
            jh8 d = qh8Var.d();
            if (d != null && d.b() && !TextUtils.isEmpty(d.a())) {
                aVar.d.setText(d.a());
                aVar.c.setTag(Integer.valueOf(i));
                aVar.c.setOnClickListener(this);
                aVar.c.setVisibility(0);
            } else {
                aVar.c.setVisibility(8);
                aVar.i.setVisibility(8);
            }
            if (this.u) {
                aVar.e.setVisibility(0);
            } else {
                aVar.e.setVisibility(8);
            }
            this.k.getLayoutMode().k(this.n == 1);
            this.k.getLayoutMode().j(view2);
            FrsViewData frsViewData3 = this.j;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.j.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f, R.drawable.frs_top_item_bg);
                aVar.e.setVisibility(0);
                aVar.f.setOnClickListener(this);
                aVar.f.setTag(Integer.valueOf(i));
            } else {
                aVar.f.setVisibility(8);
                aVar.j.setVisibility(8);
            }
            if (this.t || qh8Var.g()) {
                return view2;
            }
            if (z) {
                aVar.a.setVisibility(8);
                aVar.c.setVisibility(8);
                l0(aVar);
                return view2;
            }
            return new View(this.a);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || this.l == null) {
            return;
        }
        int id = view2.getId();
        int intValue = ((Integer) view2.getTag()).intValue();
        if (y(intValue) instanceof ThreadData) {
            ThreadData threadData = (ThreadData) y(intValue);
            this.l.a(id, intValue, view2, Z(this.m.getListView(), intValue), threadData);
        }
    }
}
