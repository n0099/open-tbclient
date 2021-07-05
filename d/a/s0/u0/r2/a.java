package d.a.s0.u0.r2;

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
import d.a.c.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes9.dex */
public class a extends d.a.r0.d0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f66961a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66962b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f66963c;

    /* renamed from: d  reason: collision with root package name */
    public C1764a f66964d;

    /* renamed from: e  reason: collision with root package name */
    public f f66965e;

    /* renamed from: f  reason: collision with root package name */
    public View f66966f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66967g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66968h;

    /* renamed from: d.a.s0.u0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1764a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f66969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f66970f;

        /* renamed from: d.a.s0.u0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1765a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f66971e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1764a f66972f;

            public View$OnClickListenerC1765a(C1764a c1764a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1764a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66972f = c1764a;
                this.f66971e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f66972f.getItem(this.f66971e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f66972f.f66970f.f66965e.getContext()).createNormalCfg(this.f66972f.getItem(this.f66971e).forum_name, null)));
            }
        }

        public C1764a(a aVar, List<RecmForumInfo> list) {
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
            this.f66970f = aVar;
            this.f66969e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f66969e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66969e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f66970f.f66965e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f66978f = view.findViewById(R.id.root_view);
                    bVar.f66973a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f66975c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f66974b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f66976d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f66977e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f66979g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f66980h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f66981i = view.findViewById(R.id.divider_line);
                    bVar.j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f66973a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                    bVar.f66977e.M(getItem(i2).avatar, 10, false);
                    bVar.f66975c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f66974b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f66978f.setOnClickListener(new View$OnClickListenerC1765a(this, i2));
                    SkinManager.setViewTextColor(bVar.f66973a, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f66975c, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f66974b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f66980h, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f66979g, R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f66981i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f66976d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f66973a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66974b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f66975c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f66976d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f66977e;

        /* renamed from: f  reason: collision with root package name */
        public View f66978f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f66979g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f66980h;

        /* renamed from: i  reason: collision with root package name */
        public View f66981i;
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
        this.f66965e = fVar;
        this.f66961a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f66962b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f66966f = this.attachedView.findViewById(R.id.divider);
        this.f66963c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f66967g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f66968h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1764a c1764a = new C1764a(this, list);
        this.f66964d = c1764a;
        this.f66963c.setAdapter((ListAdapter) c1764a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f66962b.setVisibility(8);
                return;
            }
            this.f66962b.setVisibility(0);
            this.f66962b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f66961a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f66962b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f66966f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f66967g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f66968h, R.color.CAM_X0106, 1, skinType);
            C1764a c1764a = this.f66964d;
            if (c1764a != null) {
                c1764a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.r0.d0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // d.a.r0.d0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.f66961a.setImageResource(0);
        }
    }
}
