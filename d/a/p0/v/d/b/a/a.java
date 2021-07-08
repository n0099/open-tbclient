package d.a.p0.v.d.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.holder.SquareLiveCategoryViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d.a.c.k.e.a<d.a.p0.v.d.b.b.b, SquareLiveCategoryViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAlaSquareTabController m;

    /* renamed from: d.a.p0.v.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1749a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.v.d.b.b.b f64220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f64221f;

        public View$OnClickListenerC1749a(a aVar, d.a.p0.v.d.b.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64221f = aVar;
            this.f64220e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f64221f.m != null) {
                    int tabIndex = this.f64221f.m.getTabIndex(this.f64220e.f64235e);
                    if (tabIndex >= 0) {
                        this.f64221f.m.goToTab(tabIndex);
                        return;
                    } else {
                        this.f64221f.h0(this.f64220e);
                        return;
                    }
                }
                this.f64221f.h0(this.f64220e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    }

    public final void h0(d.a.p0.v.d.b.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            Context context = this.f41837e;
            String str = bVar.f64238h;
            String str2 = bVar.f64236f;
            String str3 = bVar.f64237g;
            List<String> list = bVar.f64239i;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(context, str, str2, str3, (list == null || !(list instanceof ArrayList)) ? null : (ArrayList) list)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public SquareLiveCategoryViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new SquareLiveCategoryViewHolder(LayoutInflater.from(this.f41837e).inflate(R.layout.square_live_category_layout, viewGroup, false)) : (SquareLiveCategoryViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.v.d.b.b.b bVar, SquareLiveCategoryViewHolder squareLiveCategoryViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, squareLiveCategoryViewHolder})) == null) {
            View findViewById = squareLiveCategoryViewHolder.f13938a.findViewById(R.id.live_category_top_line);
            TextView textView = (TextView) squareLiveCategoryViewHolder.f13938a.findViewById(R.id.live_category_entry_name);
            TextView textView2 = (TextView) squareLiveCategoryViewHolder.f13938a.findViewById(R.id.live_category_entry_tv);
            ImageView imageView = (ImageView) squareLiveCategoryViewHolder.f13938a.findViewById(R.id.live_category_entry_img);
            if (i2 == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(squareLiveCategoryViewHolder.f13938a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
            SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
            textView.setText(!TextUtils.isEmpty(bVar.f64237g) ? bVar.f64237g : bVar.f64236f);
            textView2.setOnClickListener(new View$OnClickListenerC1749a(this, bVar));
            return squareLiveCategoryViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.m = iAlaSquareTabController;
        }
    }
}
