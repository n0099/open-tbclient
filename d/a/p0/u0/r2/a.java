package d.a.p0.u0.r2;

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
/* loaded from: classes8.dex */
public class a extends d.a.o0.d0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f63744a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63745b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63746c;

    /* renamed from: d  reason: collision with root package name */
    public C1723a f63747d;

    /* renamed from: e  reason: collision with root package name */
    public f f63748e;

    /* renamed from: f  reason: collision with root package name */
    public View f63749f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63750g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63751h;

    /* renamed from: d.a.p0.u0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1723a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f63752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63753f;

        /* renamed from: d.a.p0.u0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1724a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63754e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1723a f63755f;

            public View$OnClickListenerC1724a(C1723a c1723a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1723a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63755f = c1723a;
                this.f63754e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f63755f.getItem(this.f63754e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63755f.f63753f.f63748e.getContext()).createNormalCfg(this.f63755f.getItem(this.f63754e).forum_name, null)));
            }
        }

        public C1723a(a aVar, List<RecmForumInfo> list) {
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
            this.f63753f = aVar;
            this.f63752e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f63752e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63752e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f63753f.f63748e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f63761f = view.findViewById(R.id.root_view);
                    bVar.f63756a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f63758c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f63757b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f63759d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f63760e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f63762g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f63763h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f63764i = view.findViewById(R.id.divider_line);
                    bVar.j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f63756a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                    bVar.f63760e.M(getItem(i2).avatar, 10, false);
                    bVar.f63758c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f63757b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f63761f.setOnClickListener(new View$OnClickListenerC1724a(this, i2));
                    SkinManager.setViewTextColor(bVar.f63756a, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f63758c, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f63757b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f63763h, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f63762g, R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f63764i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f63759d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
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
        public TextView f63756a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63757b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63758c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f63759d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f63760e;

        /* renamed from: f  reason: collision with root package name */
        public View f63761f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63762g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63763h;

        /* renamed from: i  reason: collision with root package name */
        public View f63764i;
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
        this.f63748e = fVar;
        this.f63744a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f63745b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f63749f = this.attachedView.findViewById(R.id.divider);
        this.f63746c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f63750g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f63751h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1723a c1723a = new C1723a(this, list);
        this.f63747d = c1723a;
        this.f63746c.setAdapter((ListAdapter) c1723a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f63745b.setVisibility(8);
                return;
            }
            this.f63745b.setVisibility(0);
            this.f63745b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f63744a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f63745b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f63749f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f63750g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f63751h, R.color.CAM_X0106, 1, skinType);
            C1723a c1723a = this.f63747d;
            if (c1723a != null) {
                c1723a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.o0.d0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // d.a.o0.d0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.f63744a.setImageResource(0);
        }
    }
}
