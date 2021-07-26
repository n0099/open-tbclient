package d.a.q0.v.d.e.a;

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
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.e.b.b;
/* loaded from: classes8.dex */
public class b extends d.a.q0.v.d.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.v.d.e.b.b f65114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f65115f;

        public a(b bVar, d.a.q0.v.d.e.b.b bVar2) {
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
            this.f65115f = bVar;
            this.f65114e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.f65114e.f65137a.o1());
                TiebaStatic.log(statisticItem);
                b bVar = this.f65115f;
                bVar.b(bVar.f65110e, this.f65114e.f65137a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* renamed from: d.a.q0.v.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1764b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65116a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65117b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65118c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65119d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65120e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65121f;

        public C1764b() {
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

        public /* synthetic */ C1764b(a aVar) {
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
        C1764b c1764b;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1764b = new C1764b(null);
                view2 = LayoutInflater.from(this.f65111f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
                c1764b.f65116a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                c1764b.f65117b = (TextView) view2.findViewById(R.id.recent_history_living_title);
                c1764b.f65118c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
                c1764b.f65119d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
                c1764b.f65120e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
                c1764b.f65121f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(c1764b.f65117b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(c1764b.f65118c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(c1764b.f65119d, R.color.CAM_X0107);
                SkinManager.setViewTextColor(c1764b.f65121f, R.color.CAM_X0301);
                view2.setTag(c1764b);
            } else {
                view2 = view;
                c1764b = (C1764b) view.getTag();
            }
            d.a.q0.v.d.e.b.b item = getItem(i2);
            if (item != null && (b2Var = item.f65137a) != null && b2Var.H() != null && item.f65137a.h1() != null) {
                MetaData H = item.f65137a.H();
                c1764b.f65116a.M(item.f65137a.h1().cover, 10, false);
                c1764b.f65117b.setText(item.f65137a.getTitle());
                this.f65113h = 0;
                c1764b.f65120e.setVisibility(8);
                c1764b.f65121f.setVisibility(8);
                if (!ListUtils.isEmpty(item.f65140d)) {
                    for (b.a aVar : item.f65140d) {
                        if (aVar != null) {
                            int i3 = aVar.f65141a;
                            if (1 == i3) {
                                c1764b.f65120e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f65142b)) {
                                    c1764b.f65120e.setText(aVar.f65142b);
                                }
                                this.f65113h++;
                            } else if (2 == i3) {
                                c1764b.f65121f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f65142b)) {
                                    c1764b.f65121f.setText(aVar.f65142b);
                                }
                                this.f65113h++;
                            }
                        }
                    }
                }
                String name_show = H.getName_show();
                int i4 = this.f65113h <= 1 ? 14 : 13;
                if (k.byteLength(name_show) > i4) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
                }
                c1764b.f65119d.setText(name_show);
                c1764b.f65118c.setText(this.f65111f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f65137a.h1().audience_count)));
                view2.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.f65137a.o1());
                d.a.q0.v.d.d.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
