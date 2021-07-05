package d.a.s0.s1.h;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f65350e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65351f;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f65352g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f65353h;

    /* renamed from: i  reason: collision with root package name */
    public String f65354i;
    public LikeModel j;

    /* renamed from: d.a.s0.s1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1671a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f65355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f65356f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f65357g;

        /* renamed from: d.a.s0.s1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1672a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC1671a f65358a;

            public C1672a(View$OnClickListenerC1671a view$OnClickListenerC1671a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1671a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65358a = view$OnClickListenerC1671a;
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.f65358a.f65357g.j.getErrorCode() != 0) {
                        l.L(this.f65358a.f65357g.f65350e, R.string.attention_fail);
                        return;
                    }
                    this.f65358a.f65356f.f65363e.setText(R.string.followed);
                    l.L(this.f65358a.f65357g.f65350e, R.string.attention_success);
                    this.f65358a.f65356f.f65363e.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f65358a.f65356f.f65363e, R.color.CAM_X0109);
                    this.f65358a.f65356f.f65363e.setOnClickListener(null);
                }
            }
        }

        public View$OnClickListenerC1671a(a aVar, ForumInfo forumInfo, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, forumInfo, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65357g = aVar;
            this.f65355e = forumInfo;
            this.f65356f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f65355e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                LikeModel likeModel = this.f65357g.j;
                ForumInfo forumInfo = this.f65355e;
                likeModel.L(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                this.f65357g.j.setLoadDataCallBack(new C1672a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f65359a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f65360b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65361c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65362d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65363e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1671a view$OnClickListenerC1671a) {
            this(aVar);
        }
    }

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65350e = context;
        this.f65351f = true;
        this.f65352g = arrayList;
        this.j = new LikeModel(null);
    }

    public void c(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f65354i)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f65354i.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f65354i.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(List<ForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f65352g = list;
            this.f65353h = new ArrayList<>();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f65352g.size()) {
                    break;
                } else if (this.f65352g.get(i3).has_concerned.intValue() == 0) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.f65353h.addAll(this.f65352g);
            if (i2 > 0) {
                this.f65353h.add(i2, "divider");
            }
            if (this.f65352g != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f65354i = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f65353h == null || TextUtils.isEmpty(this.f65354i)) {
                return 0;
            }
            return this.f65353h.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int count = getCount();
            if (count <= 0 || i2 >= count) {
                return null;
            }
            return this.f65353h.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                if (view == null) {
                    view = LayoutInflater.from(this.f65350e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                    bVar.f65360b = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.f65359a = (TextView) view.findViewById(R.id.name);
                    bVar.f65361c = (TextView) view.findViewById(R.id.forum_member_count);
                    bVar.f65362d = (TextView) view.findViewById(R.id.forum_thread_count);
                    bVar.f65363e = (TextView) view.findViewById(R.id.follow_text_view);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (forumInfo == null) {
                    return view;
                }
                String str2 = forumInfo.avatar;
                bVar.f65360b.setTag(str2);
                bVar.f65360b.M(str2, 15, false);
                bVar.f65360b.invalidate();
                if (this.f65351f) {
                    str = this.f65350e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(bVar.f65359a, str);
                bVar.f65360b.setTag(forumInfo.avatar);
                TextView textView = bVar.f65361c;
                textView.setText(this.f65350e.getString(R.string.attention) + " " + forumInfo.concern_num);
                TextView textView2 = bVar.f65362d;
                textView2.setText(this.f65350e.getString(R.string.text_post) + " " + forumInfo.post_num);
                SkinManager.setViewTextColor(bVar.f65361c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f65362d, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f65359a, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    bVar.f65363e.setText(R.string.followed);
                    SkinManager.setBackgroundResource(bVar.f65363e, 0);
                    SkinManager.setViewTextColor(bVar.f65363e, R.color.CAM_X0109);
                    bVar.f65363e.setOnClickListener(null);
                    return view;
                }
                bVar.f65363e.setText(R.string.attention);
                SkinManager.setBackgroundResource(bVar.f65363e, R.drawable.search_like_btn_bg);
                SkinManager.setViewTextColor(bVar.f65363e, R.color.CAM_X0302);
                bVar.f65363e.setOnClickListener(new View$OnClickListenerC1671a(this, forumInfo, bVar));
                return view;
            } else if (item instanceof String) {
                View inflate = LayoutInflater.from(this.f65350e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
                SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
                return inflate;
            } else {
                return view;
            }
        }
        return (View) invokeILL.objValue;
    }
}
