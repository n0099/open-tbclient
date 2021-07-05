package d.a.s0.v.d.e.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.e.b.b;
/* loaded from: classes9.dex */
public class b extends d.a.s0.v.d.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.v.d.e.b.b f67687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f67688f;

        public a(b bVar, d.a.s0.v.d.e.b.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67688f = bVar;
            this.f67687e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f67687e.f67710a.n1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f67688f;
                bVar.b(bVar.f67683e, this.f67687e.f67710a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: d.a.s0.v.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1803b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f67689a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f67690b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67691c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67692d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67693e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67694f;

        public C1803b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1803b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C1803b c1803b;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1803b = new C1803b(null);
                view2 = LayoutInflater.from(this.f67684f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1803b.f67689a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1803b.f67690b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1803b.f67691c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1803b.f67692d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1803b.f67693e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1803b.f67694f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1803b.f67690b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1803b.f67691c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1803b.f67692d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1803b.f67694f, R.color.CAM_X0301);
                view2.setTag(c1803b);
            } else {
                view2 = view;
                c1803b = (C1803b) view.getTag();
            }
            d.a.s0.v.d.e.b.b item = getItem(i2);
            if (item != null && (b2Var = item.f67710a) != null && b2Var.H() != null && item.f67710a.g1() != null) {
                MetaData H = item.f67710a.H();
                c1803b.f67689a.M(item.f67710a.g1().cover, 10, false);
                c1803b.f67690b.setText(item.f67710a.getTitle());
                this.f67686h = 0;
                c1803b.f67693e.setVisibility(8);
                c1803b.f67694f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f67713d)) {
                    for (b.a aVar : item.f67713d) {
                        if (aVar != null) {
                            int i3 = aVar.f67714a;
                            if (1 == i3) {
                                c1803b.f67693e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f67715b)) {
                                    c1803b.f67693e.setText(aVar.f67715b);
                                }
                                this.f67686h++;
                            } else if (2 == i3) {
                                c1803b.f67694f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f67715b)) {
                                    c1803b.f67694f.setText(aVar.f67715b);
                                }
                                this.f67686h++;
                            }
                        }
                    }
                }
                String name_show = H.getName_show();
                int i4 = this.f67686h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
                }
                c1803b.f67692d.setText(name_show);
                c1803b.f67691c.setText(this.f67684f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f67710a.g1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f67710a.n1());
                d.a.s0.v.d.d.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
