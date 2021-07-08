package d.a.p0.u0.q1;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
import d.a.p0.h3.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<FrsFragment> f63646a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f63647b;

    /* renamed from: c  reason: collision with root package name */
    public View f63648c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63649d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63650e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63651f;

    /* renamed from: g  reason: collision with root package name */
    public View f63652g;

    /* renamed from: h  reason: collision with root package name */
    public View f63653h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.p0.u0.q1.b> f63654i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public e r;

    /* renamed from: d.a.p0.u0.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1718a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63655e;

        public View$OnClickListenerC1718a(a aVar) {
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
                    return;
                }
            }
            this.f63655e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (ViewHelper.checkUpIsLogin(this.f63655e.f63646a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                        this.f63655e.k.L(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.f63655e.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view.getId() == R.id.like_feed_forums_arrow) {
                    this.f63655e.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.f63655e.n));
                } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                    if (view.getId() != this.f63655e.f63651f.getId() || ListUtils.getCount(this.f63655e.j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.f63655e.f63646a.getPageActivity(), (Serializable) this.f63655e.j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.f63655e.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                    if (feedForumData2 != null) {
                        this.f63655e.f63646a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63655e.f63646a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.f63655e.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.f63655e.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63656e;

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
                    return;
                }
            }
            this.f63656e = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f63656e.j != null) {
                    this.f63656e.j.clear();
                }
                this.f63656e.m();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
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

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63657a;

        /* renamed from: d.a.p0.u0.q1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1719a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w f63658e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f63659f;

            public RunnableC1719a(d dVar, w wVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, wVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63659f = dVar;
                this.f63658e = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.f63659f.f63657a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.f63658e.g())) {
                            this.f63659f.f63657a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.f63659f.f63657a.j.size() > 0) {
                        this.f63659f.f63657a.p();
                    } else {
                        this.f63659f.f63657a.m();
                    }
                }
            }
        }

        public d(a aVar) {
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
                    return;
                }
            }
            this.f63657a = aVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f63657a.k.getErrorCode(), this.f63657a.k.getErrorString())) {
                    AntiHelper.u(this.f63657a.f63646a.getPageActivity(), this.f63657a.k.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.f63657a.k.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f63657a.k.getErrorString());
                } else {
                    w wVar = (w) obj;
                    if (ListUtils.getCount(this.f63657a.j) <= 0 || wVar == null) {
                        return;
                    }
                    Iterator it = this.f63657a.f63654i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.a.p0.u0.q1.b bVar = (d.a.p0.u0.q1.b) it.next();
                        FeedForumData feedForumData = (FeedForumData) bVar.f63665f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.g())) {
                            feedForumData.setIsLike(1);
                            this.f63657a.l(bVar);
                            break;
                        }
                    }
                    if (this.f63657a.m == 1) {
                        this.f63657a.l.postDelayed(new RunnableC1719a(this, wVar), 1000L);
                    }
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63654i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1718a(this);
        this.r = new d(this);
    }

    public final String k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0) {
                return "0";
            }
            if (i2 < 10000) {
                return String.valueOf(i2);
            }
            if (i2 == 10000) {
                return "1W";
            }
            float f2 = i2 / 10000.0f;
            return f2 <= 9999.9f ? String.format("%.1fW", Float.valueOf(f2)) : "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public final void l(d.a.p0.u0.q1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f63665f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f63665f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f63647b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.f63646a = tbPageContext;
            this.f63647b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
            this.f63648c = view.findViewById(R.id.frs_header_feed_forums_divider);
            this.f63652g = view.findViewById(R.id.layout_like_feed_forum_header);
            this.f63649d = (TextView) this.f63647b.findViewById(R.id.like_feed_forums_label);
            ImageView imageView = (ImageView) this.f63647b.findViewById(R.id.like_feed_forums_arrow);
            this.f63650e = imageView;
            imageView.setOnClickListener(this.q);
            this.f63651f = (TextView) this.f63647b.findViewById(R.id.feed_forums_more);
            this.f63653h = view.findViewById(R.id.feed_forum_bottom_line);
            this.f63651f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i2;
            this.p = z;
        }
    }

    public void o(String str, List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.n = str;
            this.j = list;
            p();
            if (this.m != 2 || this.o) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
            this.o = true;
        }
    }

    public final void p() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            int size = this.j.size() > 2 ? 2 : this.j.size();
            int size2 = size - this.f63654i.size();
            if (size2 > 0) {
                for (int i3 = 0; i3 < size2; i3++) {
                    if (this.m == 1) {
                        i2 = R.layout.frs_header_feed_forum_item;
                    } else {
                        i2 = R.layout.frs_feed_forum_item;
                    }
                    View inflate = LayoutInflater.from(this.f63646a.getPageActivity()).inflate(i2, (ViewGroup) null);
                    this.f63647b.addView(inflate);
                    this.f63654i.add(new d.a.p0.u0.q1.b(inflate));
                }
            } else if (size2 < 0) {
                for (int i4 = 0; i4 < (-size2); i4++) {
                    int size3 = this.f63654i.size() - 1;
                    this.f63647b.removeView(this.f63654i.get(size3).f63660a);
                    this.f63654i.remove(size3);
                }
            }
            for (int i5 = 0; i5 < size; i5++) {
                FeedForumData feedForumData = this.j.get(i5);
                d.a.p0.u0.q1.b bVar = this.f63654i.get(i5);
                if (feedForumData != null && bVar != null) {
                    bVar.f63660a.setTag(feedForumData);
                    bVar.f63660a.setOnClickListener(this.q);
                    bVar.f63661b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    bVar.f63661b.setPlaceHolder(1);
                    bVar.f63661b.M(feedForumData.getAvatar(), 15, false);
                    bVar.f63662c.setText(feedForumData.getForumName());
                    bVar.f63663d.setText(String.format(this.f63646a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    bVar.f63664e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        bVar.f63665f.setClickable(true);
                        bVar.f63665f.setOnClickListener(this.q);
                        bVar.f63665f.setTag(feedForumData);
                        bVar.f63665f.h(false);
                        bVar.f63665f.setEnabled(true);
                    } else {
                        l(bVar);
                    }
                }
            }
            if (this.p) {
                this.f63653h.setVisibility(0);
            } else {
                this.f63653h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.f63647b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f63648c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f63652g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f63649d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.f63650e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f63651f, R.color.CAM_X0110, 1);
            for (d.a.p0.u0.q1.b bVar : this.f63654i) {
                SkinManager.setBackgroundResource(bVar.f63660a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(bVar.f63662c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(bVar.f63663d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(bVar.f63664e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = bVar.f63665f;
                entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f63647b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f63646a.getPageActivity());
            aVar.setMessage(this.f63646a.getPageActivity().getString(R.string.not_intrested));
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f63646a).show();
        }
    }

    public a(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63654i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new View$OnClickListenerC1718a(this);
        this.r = new d(this);
        n(tbPageContext, view, i2, z, bdUniqueId);
    }
}
