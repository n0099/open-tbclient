package d.a.p0.s1.h;

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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f62128e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f62129f;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f62130g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f62131h;

    /* renamed from: i  reason: collision with root package name */
    public String f62132i;
    public LikeModel j;

    /* renamed from: d.a.p0.s1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1629a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f62133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62134f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f62135g;

        /* renamed from: d.a.p0.s1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1630a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC1629a f62136a;

            public C1630a(View$OnClickListenerC1629a view$OnClickListenerC1629a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1629a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62136a = view$OnClickListenerC1629a;
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.f62136a.f62135g.j.getErrorCode() != 0) {
                        l.L(this.f62136a.f62135g.f62128e, R.string.attention_fail);
                        return;
                    }
                    this.f62136a.f62134f.f62141e.setText(R.string.followed);
                    l.L(this.f62136a.f62135g.f62128e, R.string.attention_success);
                    this.f62136a.f62134f.f62141e.setBackgroundDrawable(null);
                    SkinManager.setViewTextColor(this.f62136a.f62134f.f62141e, R.color.CAM_X0109);
                    this.f62136a.f62134f.f62141e.setOnClickListener(null);
                }
            }
        }

        public View$OnClickListenerC1629a(a aVar, ForumInfo forumInfo, b bVar) {
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
            this.f62135g = aVar;
            this.f62133e = forumInfo;
            this.f62134f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f62133e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                LikeModel likeModel = this.f62135g.j;
                ForumInfo forumInfo = this.f62133e;
                likeModel.L(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
                this.f62135g.j.setLoadDataCallBack(new C1630a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f62137a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f62138b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62139c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62140d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62141e;

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

        public /* synthetic */ b(a aVar, View$OnClickListenerC1629a view$OnClickListenerC1629a) {
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
        this.f62128e = context;
        this.f62129f = true;
        this.f62130g = arrayList;
        this.j = new LikeModel(null);
    }

    public void c(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f62132i)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f62132i.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f62132i.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(List<ForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f62130g = list;
            this.f62131h = new ArrayList<>();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f62130g.size()) {
                    break;
                } else if (this.f62130g.get(i3).has_concerned.intValue() == 0) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.f62131h.addAll(this.f62130g);
            if (i2 > 0) {
                this.f62131h.add(i2, "divider");
            }
            if (this.f62130g != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f62132i = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f62131h == null || TextUtils.isEmpty(this.f62132i)) {
                return 0;
            }
            return this.f62131h.size();
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
            return this.f62131h.get(i2);
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
                    view = LayoutInflater.from(this.f62128e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                    bVar.f62138b = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.f62137a = (TextView) view.findViewById(R.id.name);
                    bVar.f62139c = (TextView) view.findViewById(R.id.forum_member_count);
                    bVar.f62140d = (TextView) view.findViewById(R.id.forum_thread_count);
                    bVar.f62141e = (TextView) view.findViewById(R.id.follow_text_view);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (forumInfo == null) {
                    return view;
                }
                String str2 = forumInfo.avatar;
                bVar.f62138b.setTag(str2);
                bVar.f62138b.M(str2, 15, false);
                bVar.f62138b.invalidate();
                if (this.f62129f) {
                    str = this.f62128e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
                } else {
                    str = forumInfo.forum_name;
                }
                c(bVar.f62137a, str);
                bVar.f62138b.setTag(forumInfo.avatar);
                TextView textView = bVar.f62139c;
                textView.setText(this.f62128e.getString(R.string.attention) + " " + forumInfo.concern_num);
                TextView textView2 = bVar.f62140d;
                textView2.setText(this.f62128e.getString(R.string.text_post) + " " + forumInfo.post_num);
                SkinManager.setViewTextColor(bVar.f62139c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f62140d, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f62137a, R.color.CAM_X0105);
                if (forumInfo.has_concerned.intValue() > 0) {
                    bVar.f62141e.setText(R.string.followed);
                    SkinManager.setBackgroundResource(bVar.f62141e, 0);
                    SkinManager.setViewTextColor(bVar.f62141e, R.color.CAM_X0109);
                    bVar.f62141e.setOnClickListener(null);
                    return view;
                }
                bVar.f62141e.setText(R.string.attention);
                SkinManager.setBackgroundResource(bVar.f62141e, R.drawable.search_like_btn_bg);
                SkinManager.setViewTextColor(bVar.f62141e, R.color.CAM_X0302);
                bVar.f62141e.setOnClickListener(new View$OnClickListenerC1629a(this, forumInfo, bVar));
                return view;
            } else if (item instanceof String) {
                View inflate = LayoutInflater.from(this.f62128e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
                SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
                return inflate;
            } else {
                return view;
            }
        }
        return (View) invokeILL.objValue;
    }
}
