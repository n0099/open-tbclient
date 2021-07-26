package d.a.q0.s0.c;

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
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class m extends d.a.q0.u0.k<n, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.t.i.b x;
    public View.OnClickListener y;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f62682e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62682e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(m.z);
                    if (tag == null || tag.toString().equals("")) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.d.a.j.a(this.f62682e.f42341e), new String[]{tag.toString()});
                    return;
                }
                this.f62682e.A0(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1110359903, "Ld/a/q0/s0/c/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1110359903, "Ld/a/q0/s0/c/m;");
                return;
            }
        }
        z = R.id.private_apply_tip;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(this.f42341e);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.x == null) {
                this.x = new d.a.p0.t.i.b(pageActivity);
            }
            this.x.p();
            this.x.u(accountData);
            this.x.z(1);
        }
    }

    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        z0(i2, view, viewGroup, (n) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.a.p0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.x) == null) {
            return;
        }
        bVar.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: x0 */
    public PrivateMgrApplyViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new PrivateMgrApplyViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.private_member_apply, (ViewGroup) null)) : (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public View z0(int i2, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, privateMgrApplyViewHolder})) == null) {
            super.X(i2, view, viewGroup, nVar, privateMgrApplyViewHolder);
            if (nVar != null && !nVar.e() && privateMgrApplyViewHolder != null) {
                if (nVar.e()) {
                    privateMgrApplyViewHolder.f15314e.setVisibility(8);
                    return view;
                }
                boolean z2 = true;
                if (privateMgrApplyViewHolder.f15315f != this.r) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.f15313d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15311b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15310a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.f15312c, R.drawable.frs_member_manito_bg);
                }
                int b2 = nVar.b();
                String string = this.f42341e.getResources().getString(R.string.tbtitle_quota_is_full);
                if (b2 == -1) {
                    int d2 = nVar.d();
                    String numberUniformFormat = StringHelper.numberUniformFormat(d2);
                    if (d2 > 0) {
                        string = String.format(this.f42341e.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                        privateMgrApplyViewHolder.f15312c.setOnClickListener(this.y);
                        privateMgrApplyViewHolder.f15311b.setText(string);
                        privateMgrApplyViewHolder.f15312c.setTag(z, nVar.c());
                        privateMgrApplyViewHolder.f15312c.setEnabled(z2);
                        privateMgrApplyViewHolder.f15312c.setClickable(z2);
                        privateMgrApplyViewHolder.f15311b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f15315f = this.r;
                    }
                    z2 = false;
                    privateMgrApplyViewHolder.f15312c.setOnClickListener(this.y);
                    privateMgrApplyViewHolder.f15311b.setText(string);
                    privateMgrApplyViewHolder.f15312c.setTag(z, nVar.c());
                    privateMgrApplyViewHolder.f15312c.setEnabled(z2);
                    privateMgrApplyViewHolder.f15312c.setClickable(z2);
                    privateMgrApplyViewHolder.f15311b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f15315f = this.r;
                } else {
                    if (b2 == 0) {
                        string = this.f42341e.getResources().getString(R.string.tbtitle_is_assist);
                    } else if (b2 == 1) {
                        string = this.f42341e.getResources().getString(R.string.tbtitle_assist_applying);
                    } else {
                        if (b2 == 2) {
                            string = this.f42341e.getResources().getString(R.string.tbtitle_assist_apply_failed);
                        }
                        z2 = false;
                    }
                    privateMgrApplyViewHolder.f15312c.setOnClickListener(this.y);
                    privateMgrApplyViewHolder.f15311b.setText(string);
                    privateMgrApplyViewHolder.f15312c.setTag(z, nVar.c());
                    privateMgrApplyViewHolder.f15312c.setEnabled(z2);
                    privateMgrApplyViewHolder.f15312c.setClickable(z2);
                    privateMgrApplyViewHolder.f15311b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f15315f = this.r;
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
