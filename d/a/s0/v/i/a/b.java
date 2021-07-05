package d.a.s0.v.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.view.card.AlaCardBottomUserInfoLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f67986e;

    /* renamed from: f  reason: collision with root package name */
    public List<b2> f67987f;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f67988a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f67989b;

        /* renamed from: c  reason: collision with root package name */
        public AlaCardBottomUserInfoLayout f67990c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f67991d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67992e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67988a = view;
            this.f67989b = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.f67990c = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.f67991d = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.f67992e = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67986e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b2 getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<b2> list = this.f67987f;
            if (list != null && i2 >= 0 && i2 <= list.size()) {
                return this.f67987f.get(i2);
            }
            return null;
        }
        return (b2) invokeI.objValue;
    }

    public void b(List<b2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f67987f = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f67987f)) {
                return 0;
            }
            return this.f67987f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        AlaInfoData g1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f67986e.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
                aVar = new a(view);
                aVar.f67989b.setIsRound(true);
                aVar.f67989b.setDrawBorder(false);
                aVar.f67989b.setAutoChangeStyle(true);
                aVar.f67989b.setGifIconSupport(false);
                int k = (l.k(this.f67986e.getPageActivity()) - this.f67986e.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
                int i3 = (k * 16) / 9;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f67991d.getLayoutParams();
                layoutParams.height = k;
                layoutParams.width = i3;
                aVar.f67991d.setLayoutParams(layoutParams);
                AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
                ((ViewGroup.LayoutParams) layoutParams2).width = i3;
                view.setLayoutParams(layoutParams2);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            b2 item = getItem(i2);
            if (item == null || (g1 = item.g1()) == null) {
                return null;
            }
            aVar.f67989b.M(g1.cover, 10, false);
            aVar.f67990c.setData(item);
            aVar.f67990c.setUserHeadImgVisible(8);
            aVar.f67992e.setText(item.getTitle());
            aVar.f67990c.onChangeSkinType(this.f67986e);
            SkinManager.setViewTextColor(aVar.f67992e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
