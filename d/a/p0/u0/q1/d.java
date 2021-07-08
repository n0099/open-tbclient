package d.a.p0.u0.q1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.p0.h3.w;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f63669e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f63670f;

    /* renamed from: g  reason: collision with root package name */
    public int f63671g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f63672h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f63673i;
    public e j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63674e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63674e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.p0.u0.q1.b bVar;
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = (d.a.p0.u0.q1.b) view.getTag()) == null || (feedForumData = (FeedForumData) this.f63674e.getItem(bVar.f63667h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) this.f63674e.f63669e.getOrignalPage()).checkUpIsLogin()) {
                    this.f63674e.f63672h.L(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                this.f63674e.f63669e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63674e.f63669e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f63675a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63675a = dVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f63675a.f63672h.getErrorCode(), this.f63675a.f63672h.getErrorString())) {
                    AntiHelper.u(this.f63675a.f63669e.getPageActivity(), this.f63675a.f63672h.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.f63675a.f63672h.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f63675a.f63672h.getErrorString());
                } else {
                    w wVar = (w) obj;
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                }
            }
        }
    }

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63673i = new a(this);
        this.j = new b(this);
        this.f63669e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f63672h = likeModel;
        likeModel.setLoadDataCallBack(this.j);
    }

    public final void c(d.a.p0.u0.q1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar.f63668i == this.f63671g) {
            return;
        }
        SkinManager.setBackgroundResource(bVar.f63660a, R.drawable.frs_like_feed_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f63662c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f63663d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f63664e, R.color.CAM_X0305, 1);
        View view = bVar.f63666g;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
        }
        bVar.f63668i = this.f63671g;
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
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

    public final void e(d.a.p0.u0.q1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f63665f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f63665f.setEnabled(false);
    }

    public void f(List<FeedForumData> list, w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, wVar) == null) || list == null || list.size() <= 0 || wVar == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.g())) {
                feedForumData.setIsLike(wVar.l());
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void g(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f63670f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FeedForumData> list = this.f63670f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<FeedForumData> list = this.f63670f;
            if (list != null) {
                return list.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d.a.p0.u0.q1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            this.f63671g = TbadkCoreApplication.getInst().getSkinType();
            if (view == null) {
                view = LayoutInflater.from(this.f63669e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
                bVar = new d.a.p0.u0.q1.b(view);
                view.setTag(bVar);
                bVar.f63665f.setTag(bVar);
            } else {
                bVar = (d.a.p0.u0.q1.b) view.getTag();
            }
            FeedForumData feedForumData = (FeedForumData) getItem(i2);
            if (bVar == null) {
                return null;
            }
            bVar.f63667h = i2;
            bVar.f63660a.setOnClickListener(this.f63673i);
            bVar.f63661b.setPlaceHolder(1);
            bVar.f63661b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.f63661b.M(feedForumData.getAvatar(), 15, false);
            bVar.f63662c.setText(feedForumData.getForumName());
            bVar.f63663d.setText(String.format(this.f63669e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
            bVar.f63664e.setText(feedForumData.getReason());
            if (feedForumData.getIsLike() == 0) {
                bVar.f63665f.setClickable(true);
                bVar.f63665f.setOnClickListener(this.f63673i);
                bVar.f63665f.setEnabled(true);
                bVar.f63665f.h(false);
            } else {
                e(bVar);
            }
            c(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
