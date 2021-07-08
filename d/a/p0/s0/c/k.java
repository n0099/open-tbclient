package d.a.p0.s0.c;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ManagerApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class k extends d.a.p0.u0.k<l, ManagerApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.s.i.b x;
    public View.OnClickListener y;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f62062e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62062e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag(k.z);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.f62062e.A0(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f62062e.f41837e), new String[]{tag.toString()});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-913846460, "Ld/a/p0/s0/c/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-913846460, "Ld/a/p0/s0/c/k;");
                return;
            }
        }
        z = R.id.assist_apply_tip;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = new a(this);
    }

    public final void A0(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
            d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f41837e);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.x == null) {
                this.x = new d.a.o0.s.i.b(pageActivity);
            }
            this.x.p();
            this.x.u(accountData);
            this.x.z(1);
        }
    }

    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        z0(i2, view, viewGroup, (l) obj, (ManagerApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.a.o0.s.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.x) == null) {
            return;
        }
        bVar.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public ManagerApplyViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new ManagerApplyViewHolder(LayoutInflater.from(this.f41837e).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null)) : (ManagerApplyViewHolder) invokeL.objValue;
    }

    public View z0(int i2, View view, ViewGroup viewGroup, l lVar, ManagerApplyViewHolder managerApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, managerApplyViewHolder})) == null) {
            super.X(i2, view, viewGroup, lVar, managerApplyViewHolder);
            if (lVar != null && !lVar.d() && managerApplyViewHolder != null) {
                if (lVar.d()) {
                    managerApplyViewHolder.f15260d.setVisibility(8);
                    return view;
                }
                if (managerApplyViewHolder.f15261e != this.r) {
                    SkinManager.setViewTextColor(managerApplyViewHolder.f15258b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(managerApplyViewHolder.f15257a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(managerApplyViewHolder.f15259c, R.drawable.frs_member_manito_bg);
                }
                int c2 = lVar.c();
                if (c2 > 0) {
                    managerApplyViewHolder.f15258b.setText(String.format(this.f41837e.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(c2)));
                    managerApplyViewHolder.f15259c.setTag(z, lVar.b());
                    managerApplyViewHolder.f15259c.setOnClickListener(this.y);
                    managerApplyViewHolder.f15259c.setEnabled(true);
                    managerApplyViewHolder.f15259c.setClickable(true);
                } else {
                    managerApplyViewHolder.f15258b.setText(this.f41837e.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.f15259c.setEnabled(false);
                    managerApplyViewHolder.f15259c.setClickable(false);
                }
                managerApplyViewHolder.f15258b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.f15261e = this.r;
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
