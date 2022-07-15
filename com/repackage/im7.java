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
/* loaded from: classes6.dex */
public class im7 extends an<p05, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public int j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im7 a;

        public a(im7 im7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im7Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof p05)) {
                p05 p05Var = (p05) nnVar;
                String str = p05Var.a;
                boolean z = !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str);
                uz6.i(i + 1, this.a.j, 2, p05Var.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.i).createNormalConfig(ng.g(str, 0L), z, false)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ p05 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ im7 d;

        public b(im7 im7Var, ViewGroup viewGroup, p05 p05Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im7Var, viewGroup, p05Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = im7Var;
            this.a = viewGroup;
            this.b = p05Var;
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
                    p05 p05Var = this.b;
                    im7 im7Var = this.d;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new p25(p05Var, im7Var.d0(im7Var.j))));
                }
                uz6.i(this.c + 1, this.d.j, 1, this.b.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im7(Context context, BdUniqueId bdUniqueId, int i) {
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
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, p05 p05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        f0(i, view2, viewGroup, p05Var, nearbyForumFriendItemViewHolder);
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
    @Override // com.repackage.an
    /* renamed from: e0 */
    public NearbyForumFriendItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d05ee, viewGroup, false), this.i) : (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View f0(int i, View view2, ViewGroup viewGroup, p05 p05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p05Var, nearbyForumFriendItemViewHolder})) == null) {
            if (p05Var != null && nearbyForumFriendItemViewHolder != null) {
                j0(p05Var, nearbyForumFriendItemViewHolder);
                h0(p05Var, nearbyForumFriendItemViewHolder);
                uz6.r(i + 1, this.j);
                nearbyForumFriendItemViewHolder.k.setOnClickListener(new b(this, viewGroup, p05Var, i));
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
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c1f));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
            } else if (i == 2) {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c1d));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
            } else if (i != 3) {
                nearbyForumFriendItemViewHolder.p.setVisibility(8);
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
            } else {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c1e));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
            }
        }
    }

    public final void h0(p05 p05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, p05Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.J(p05Var.c, 25, false);
            nearbyForumFriendItemViewHolder.d.setText(p05Var.b);
            int i = p05Var.d;
            boolean z2 = true;
            if ((i != 1 && i != 2) || p05Var.e <= 0) {
                nearbyForumFriendItemViewHolder.e.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.e.setVisibility(0);
                nearbyForumFriendItemViewHolder.g.setText(String.valueOf(p05Var.e));
                z = true;
            }
            if (StringUtils.isNull(p05Var.f)) {
                nearbyForumFriendItemViewHolder.h.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.h.setVisibility(0);
                nearbyForumFriendItemViewHolder.h.setText(p05Var.f);
                z = true;
            }
            if (StringUtils.isNull(p05Var.g)) {
                nearbyForumFriendItemViewHolder.i.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.i.setVisibility(0);
                nearbyForumFriendItemViewHolder.i.setText(p05Var.g);
            }
            g0(nearbyForumFriendItemViewHolder, p05Var.k);
            if (z2 && nearbyForumFriendItemViewHolder.p.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.o.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.o.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0670));
            if (!ListUtils.isEmpty(p05Var.h)) {
                List<o05> list = p05Var.h;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i2).a);
                    sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0650));
                }
            }
            nearbyForumFriendItemViewHolder.j.setText(sb);
            nearbyForumFriendItemViewHolder.n.setText(p05Var.i);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    public final void j0(p05 p05Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p05Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            ur4.d(nearbyForumFriendItemViewHolder.d).v(R.color.CAM_X0105);
            int i = p05Var.d;
            if (i == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0807b0, R.color.CAM_X0330, null);
                ur4.d(nearbyForumFriendItemViewHolder.g).v(R.color.CAM_X0330);
                ur4 d = ur4.d(nearbyForumFriendItemViewHolder.e);
                d.e(R.string.A_X11);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0330);
            } else if (i == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0807cd, R.color.CAM_X0308, null);
                ur4.d(nearbyForumFriendItemViewHolder.g).v(R.color.CAM_X0308);
                ur4 d2 = ur4.d(nearbyForumFriendItemViewHolder.e);
                d2.e(R.string.A_X11);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0308);
            }
            ur4 d3 = ur4.d(nearbyForumFriendItemViewHolder.h);
            d3.n(R.string.J_X01);
            d3.v(R.color.CAM_X0107);
            d3.f(R.color.CAM_X0202);
            ur4.d(nearbyForumFriendItemViewHolder.i).v(R.color.CAM_X0109);
            ur4.d(nearbyForumFriendItemViewHolder.o).v(R.color.CAM_X0109);
            ur4.d(nearbyForumFriendItemViewHolder.p).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.l, R.drawable.obfuscated_res_0x7f08099c, R.color.CAM_X0302, null);
            ur4.d(nearbyForumFriendItemViewHolder.m).v(R.color.CAM_X0302);
            ur4 d4 = ur4.d(nearbyForumFriendItemViewHolder.k);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0905);
            ur4.d(nearbyForumFriendItemViewHolder.j).v(R.color.CAM_X0109);
            ur4.d(nearbyForumFriendItemViewHolder.n).v(R.color.CAM_X0107);
        }
    }
}
