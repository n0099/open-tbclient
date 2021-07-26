package d.a.q0.v.d.e.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MetaData;
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
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d.a.q0.v.d.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f65122i;
    public InterfaceC1765c j;
    public Drawable k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.v.d.e.b.b f65123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f65124f;

        public a(c cVar, d.a.q0.v.d.e.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65124f = cVar;
            this.f65123e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65124f.j == null) {
                return;
            }
            this.f65124f.j.a(this.f65123e);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.v.d.e.b.b f65125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f65126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f65127g;

        public b(c cVar, d.a.q0.v.d.e.b.b bVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65127g = cVar;
            this.f65125e = bVar;
            this.f65126f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f65127g.g(this.f65125e.f65140d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f65125e.f65137a.H().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f65127g.g(this.f65125e.f65140d)) {
                    this.f65127g.h(this.f65126f);
                    return;
                }
                c cVar = this.f65127g;
                cVar.b(cVar.f65110e, this.f65125e.f65137a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: d.a.q0.v.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1765c {
        void a(d.a.q0.v.d.e.b.b bVar);
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65128a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65129b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65130c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65131d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65132e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65133f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65134g;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
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
        this.f65122i = d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f65111f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.f65141a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d(this, null);
                view2 = LayoutInflater.from(this.f65111f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.f65128a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.f65128a.setIsRound(true);
                dVar.f65128a.setAutoChangeStyle(false);
                dVar.f65128a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f65129b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f65130c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f65131d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f65132e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f65133f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f65134g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f65129b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f65132e, R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f65133f, R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f65134g, R.color.square_follow_btn_txt_color);
                dVar.f65130c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f65131d, R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            d.a.q0.v.d.e.b.b item = getItem(i2);
            if (item != null && (b2Var = item.f65137a) != null && b2Var.H() != null) {
                com.baidu.tbadk.core.data.MetaData H = item.f65137a.H();
                int i3 = 12;
                dVar.f65128a.M(H.getPortrait(), 12, false);
                this.f65113h = 0;
                dVar.f65130c.setVisibility(8);
                dVar.f65131d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f65140d)) {
                    for (b.a aVar : item.f65140d) {
                        if (aVar != null) {
                            int i4 = aVar.f65141a;
                            if (1 == i4) {
                                dVar.f65130c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f65142b)) {
                                    dVar.f65130c.setText(aVar.f65142b);
                                }
                                this.f65113h++;
                            } else if (2 == i4) {
                                dVar.f65131d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f65142b)) {
                                    dVar.f65131d.setText(aVar.f65142b);
                                }
                                this.f65113h++;
                            }
                        }
                    }
                }
                boolean z = item.f65138b;
                String name_show = H.getName_show();
                if (this.f65113h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (k.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
                }
                dVar.f65129b.setText(name_show);
                dVar.f65132e.setText(StringHelper.getFormatTimeShort(item.f65139c * 1000));
                j(z, dVar);
                dVar.f65134g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, H));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.f65137a.H().getUserId());
                d.a.q0.v.d.d.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f65111f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f65122i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC1765c interfaceC1765c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1765c) == null) {
            this.j = interfaceC1765c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f65134g.setVisibility(8);
                dVar.f65133f.setVisibility(0);
                dVar.f65133f.setEnabled(false);
                return;
            }
            dVar.f65133f.setVisibility(8);
            dVar.f65134g.setVisibility(0);
        }
    }
}
