package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.nearby.viewholder.NearbyForumFriendItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class xm7 extends eo<d05, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public int j;
    public boolean k;

    /* loaded from: classes7.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm7 a;

        public a(xm7 xm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm7Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof d05)) {
                d05 d05Var = (d05) roVar;
                String str = d05Var.a;
                boolean z = !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str);
                rz6.h(i + 1, this.a.j, 2, d05Var.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.i).createNormalConfig(kg.g(str, 0L), z, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ d05 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ xm7 d;

        public b(xm7 xm7Var, ViewGroup viewGroup, d05 d05Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm7Var, viewGroup, d05Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xm7Var;
            this.a = viewGroup;
            this.b = d05Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.d.k) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.a.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    d05 d05Var = this.b;
                    xm7 xm7Var = this.d;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new d25(d05Var, xm7Var.d0(xm7Var.j))));
                }
                rz6.h(this.c + 1, this.d.j, 1, this.b.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xm7(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = context;
        this.j = i;
        V(new a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, d05 d05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        f0(i, view2, viewGroup, d05Var, nearbyForumFriendItemViewHolder);
        return view2;
    }

    public final int d0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: e0 */
    public NearbyForumFriendItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d05df, viewGroup, false), this.i) : (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View f0(int i, View view2, ViewGroup viewGroup, d05 d05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, d05Var, nearbyForumFriendItemViewHolder})) == null) {
            if (d05Var != null && nearbyForumFriendItemViewHolder != null) {
                j0(d05Var, nearbyForumFriendItemViewHolder);
                h0(d05Var, nearbyForumFriendItemViewHolder);
                rz6.n(i + 1, this.j);
                nearbyForumFriendItemViewHolder.k.setOnClickListener(new b(this, viewGroup, d05Var, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, nearbyForumFriendItemViewHolder, i) == null) {
            nearbyForumFriendItemViewHolder.p.setVisibility(0);
            if (i == 1) {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c21));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
            } else if (i == 2) {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c1f));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
            } else if (i != 3) {
                nearbyForumFriendItemViewHolder.p.setVisibility(8);
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
            } else {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c20));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
            }
        }
    }

    public final void h0(d05 d05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, d05Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.K(d05Var.c, 25, false);
            nearbyForumFriendItemViewHolder.d.setText(d05Var.b);
            int i = d05Var.d;
            boolean z2 = true;
            if ((i != 1 && i != 2) || d05Var.e <= 0) {
                nearbyForumFriendItemViewHolder.e.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.e.setVisibility(0);
                nearbyForumFriendItemViewHolder.g.setText(String.valueOf(d05Var.e));
                z = true;
            }
            if (StringUtils.isNull(d05Var.f)) {
                nearbyForumFriendItemViewHolder.h.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.h.setVisibility(0);
                nearbyForumFriendItemViewHolder.h.setText(d05Var.f);
                z = true;
            }
            if (StringUtils.isNull(d05Var.g)) {
                nearbyForumFriendItemViewHolder.i.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.i.setVisibility(0);
                nearbyForumFriendItemViewHolder.i.setText(d05Var.g);
            }
            g0(nearbyForumFriendItemViewHolder, d05Var.k);
            if (z2 && nearbyForumFriendItemViewHolder.p.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.o.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.o.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f066b));
            if (!ListUtils.isEmpty(d05Var.h)) {
                List<c05> list = d05Var.h;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i2).a);
                    sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f064b));
                }
            }
            nearbyForumFriendItemViewHolder.j.setText(sb);
            nearbyForumFriendItemViewHolder.n.setText(d05Var.i);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    public final void j0(d05 d05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d05Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            gs4.d(nearbyForumFriendItemViewHolder.d).v(R.color.CAM_X0105);
            int i = d05Var.d;
            if (i == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0807b2, R.color.CAM_X0330, null);
                gs4.d(nearbyForumFriendItemViewHolder.g).v(R.color.CAM_X0330);
                gs4 d = gs4.d(nearbyForumFriendItemViewHolder.e);
                d.e(R.string.A_X11);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0330);
            } else if (i == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0807ce, R.color.CAM_X0308, null);
                gs4.d(nearbyForumFriendItemViewHolder.g).v(R.color.CAM_X0308);
                gs4 d2 = gs4.d(nearbyForumFriendItemViewHolder.e);
                d2.e(R.string.A_X11);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0308);
            }
            gs4 d3 = gs4.d(nearbyForumFriendItemViewHolder.h);
            d3.n(R.string.J_X01);
            d3.v(R.color.CAM_X0107);
            d3.f(R.color.CAM_X0202);
            gs4.d(nearbyForumFriendItemViewHolder.i).v(R.color.CAM_X0109);
            gs4.d(nearbyForumFriendItemViewHolder.o).v(R.color.CAM_X0109);
            gs4.d(nearbyForumFriendItemViewHolder.p).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.l, R.drawable.obfuscated_res_0x7f08099c, R.color.CAM_X0302, null);
            gs4.d(nearbyForumFriendItemViewHolder.m).v(R.color.CAM_X0302);
            gs4 d4 = gs4.d(nearbyForumFriendItemViewHolder.k);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0905);
            gs4.d(nearbyForumFriendItemViewHolder.j).v(R.color.CAM_X0109);
            gs4.d(nearbyForumFriendItemViewHolder.n).v(R.color.CAM_X0107);
        }
    }
}
