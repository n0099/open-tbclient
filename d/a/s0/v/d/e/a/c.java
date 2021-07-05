package d.a.s0.v.d.e.a;

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
import d.a.c.e.p.k;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.e.b.b;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d.a.s0.v.d.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public long f67695i;
    public InterfaceC1804c j;
    public Drawable k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.v.d.e.b.b f67696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f67697f;

        public a(c cVar, d.a.s0.v.d.e.b.b bVar) {
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
            this.f67697f = cVar;
            this.f67696e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67697f.j == null) {
                return;
            }
            this.f67697f.j.a(this.f67696e);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.v.d.e.b.b f67698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f67699f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f67700g;

        public b(c cVar, d.a.s0.v.d.e.b.b bVar, MetaData metaData) {
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
            this.f67700g = cVar;
            this.f67698e = bVar;
            this.f67699f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean g2 = this.f67700g.g(this.f67698e.f67713d);
                StatisticItem statisticItem = new StatisticItem("c12661");
                statisticItem.param("obj_id", this.f67698e.f67710a.H().getUserId());
                statisticItem.param("obj_type", g2 ? 1 : 0);
                TiebaStatic.log(statisticItem);
                if (!this.f67700g.g(this.f67698e.f67713d)) {
                    this.f67700g.h(this.f67699f);
                    return;
                }
                c cVar = this.f67700g;
                cVar.b(cVar.f67683e, this.f67698e.f67710a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
            }
        }
    }

    /* renamed from: d.a.s0.v.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1804c {
        void a(d.a.s0.v.d.e.b.b bVar);
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f67701a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f67702b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67703c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67704d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67705e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67706f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67707g;

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
        this.f67695i = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f67684f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.f67714a) {
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
                view2 = LayoutInflater.from(this.f67684f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
                dVar.f67701a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.f67701a.setIsRound(true);
                dVar.f67701a.setAutoChangeStyle(false);
                dVar.f67701a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.f67702b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
                dVar.f67703c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
                dVar.f67704d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
                dVar.f67705e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
                dVar.f67706f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
                dVar.f67707g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.f67702b, R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.f67705e, R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f67706f, R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.f67707g, R.color.square_follow_btn_txt_color);
                dVar.f67703c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.f67704d, R.color.CAM_X0301);
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            d.a.s0.v.d.e.b.b item = getItem(i2);
            if (item != null && (b2Var = item.f67710a) != null && b2Var.H() != null) {
                com.baidu.tbadk.core.data.MetaData H = item.f67710a.H();
                int i3 = 12;
                dVar.f67701a.M(H.getPortrait(), 12, false);
                this.f67686h = 0;
                dVar.f67703c.setVisibility(8);
                dVar.f67704d.setVisibility(8);
                if (!ListUtils.isEmpty(item.f67713d)) {
                    for (b.a aVar : item.f67713d) {
                        if (aVar != null) {
                            int i4 = aVar.f67714a;
                            if (1 == i4) {
                                dVar.f67703c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f67715b)) {
                                    dVar.f67703c.setText(aVar.f67715b);
                                }
                                this.f67686h++;
                            } else if (2 == i4) {
                                dVar.f67704d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.f67715b)) {
                                    dVar.f67704d.setText(aVar.f67715b);
                                }
                                this.f67686h++;
                            }
                        }
                    }
                }
                boolean z = item.f67711b;
                String name_show = H.getName_show();
                if (this.f67686h <= 1) {
                    i3 = 14;
                } else if (!z) {
                    i3 = 10;
                }
                if (k.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
                }
                dVar.f67702b.setText(name_show);
                dVar.f67705e.setText(StringHelper.getFormatTimeShort(item.f67712c * 1000));
                j(z, dVar);
                dVar.f67707g.setOnClickListener(new a(this, item));
                view2.setOnClickListener(new b(this, item, H));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.f67710a.H().getUserId());
                d.a.s0.v.d.d.a.c().a(statisticItem);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67684f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f67695i).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public void i(InterfaceC1804c interfaceC1804c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1804c) == null) {
            this.j = interfaceC1804c;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.f67707g.setVisibility(8);
                dVar.f67706f.setVisibility(0);
                dVar.f67706f.setEnabled(false);
                return;
            }
            dVar.f67706f.setVisibility(8);
            dVar.f67707g.setVisibility(0);
        }
    }
}
