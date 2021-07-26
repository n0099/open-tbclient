package d.a.q0.u0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes8.dex */
public class a extends d.a.p0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f64389a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64390b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f64391c;

    /* renamed from: d  reason: collision with root package name */
    public C1726a f64392d;

    /* renamed from: e  reason: collision with root package name */
    public f f64393e;

    /* renamed from: f  reason: collision with root package name */
    public View f64394f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64395g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64396h;

    /* renamed from: d.a.q0.u0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1726a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f64397e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f64398f;

        /* renamed from: d.a.q0.u0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1727a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64399e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1726a f64400f;

            public View$OnClickListenerC1727a(C1726a c1726a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1726a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64400f = c1726a;
                this.f64399e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f64400f.getItem(this.f64399e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64400f.f64398f.f64393e.getContext()).createNormalCfg(this.f64400f.getItem(this.f64399e).forum_name, null)));
            }
        }

        public C1726a(a aVar, List<RecmForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64398f = aVar;
            this.f64397e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f64397e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64397e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f64398f.f64393e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f64406f = view.findViewById(R.id.root_view);
                    bVar.f64401a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f64403c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f64402b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f64404d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f64405e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f64407g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f64408h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f64409i = view.findViewById(R.id.divider_line);
                    bVar.j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f64401a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                    bVar.f64405e.M(getItem(i2).avatar, 10, false);
                    bVar.f64403c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f64402b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f64406f.setOnClickListener(new View$OnClickListenerC1727a(this, i2));
                    SkinManager.setViewTextColor(bVar.f64401a, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f64403c, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f64402b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f64408h, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f64407g, R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f64409i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f64404d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f64401a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64402b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64403c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f64404d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f64405e;

        /* renamed from: f  reason: collision with root package name */
        public View f64406f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64407g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64408h;

        /* renamed from: i  reason: collision with root package name */
        public View f64409i;
        public ImageView j;

        public b() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64393e = fVar;
        this.f64389a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f64390b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f64394f = this.attachedView.findViewById(R.id.divider);
        this.f64391c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f64395g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f64396h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1726a c1726a = new C1726a(this, list);
        this.f64392d = c1726a;
        this.f64391c.setAdapter((ListAdapter) c1726a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f64390b.setVisibility(8);
                return;
            }
            this.f64390b.setVisibility(0);
            this.f64390b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f64389a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f64390b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f64394f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f64395g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f64396h, R.color.CAM_X0106, 1, skinType);
            C1726a c1726a = this.f64392d;
            if (c1726a != null) {
                c1726a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.p0.f0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // d.a.p0.f0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.f64389a.setImageResource(0);
        }
    }
}
