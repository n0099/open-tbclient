package d.a.q0.u0.q1;

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
import d.a.d.a.e;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.h3.w;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f64314e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f64315f;

    /* renamed from: g  reason: collision with root package name */
    public int f64316g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f64317h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f64318i;
    public e j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64319e;

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
            this.f64319e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.q0.u0.q1.b bVar;
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = (d.a.q0.u0.q1.b) view.getTag()) == null || (feedForumData = (FeedForumData) this.f64319e.getItem(bVar.f64312h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) this.f64319e.f64314e.getOrignalPage()).checkUpIsLogin()) {
                    this.f64319e.f64317h.L(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                this.f64319e.f64314e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64319e.f64314e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64320a;

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
            this.f64320a = dVar;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f64320a.f64317h.getErrorCode(), this.f64320a.f64317h.getErrorString())) {
                    AntiHelper.u(this.f64320a.f64314e.getPageActivity(), this.f64320a.f64317h.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.f64320a.f64317h.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f64320a.f64317h.getErrorString());
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
        this.f64318i = new a(this);
        this.j = new b(this);
        this.f64314e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f64317h = likeModel;
        likeModel.setLoadDataCallBack(this.j);
    }

    public final void c(d.a.q0.u0.q1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar.f64313i == this.f64316g) {
            return;
        }
        SkinManager.setBackgroundResource(bVar.f64305a, R.drawable.frs_like_feed_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f64307c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f64308d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(bVar.f64309e, R.color.CAM_X0305, 1);
        View view = bVar.f64311g;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
        }
        bVar.f64313i = this.f64316g;
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

    public final void e(d.a.q0.u0.q1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null || (entelechyUserLikeButton = bVar.f64310f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f64310f.setEnabled(false);
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
            this.f64315f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FeedForumData> list = this.f64315f;
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
            List<FeedForumData> list = this.f64315f;
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
        d.a.q0.u0.q1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            this.f64316g = TbadkCoreApplication.getInst().getSkinType();
            if (view == null) {
                view = LayoutInflater.from(this.f64314e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
                bVar = new d.a.q0.u0.q1.b(view);
                view.setTag(bVar);
                bVar.f64310f.setTag(bVar);
            } else {
                bVar = (d.a.q0.u0.q1.b) view.getTag();
            }
            FeedForumData feedForumData = (FeedForumData) getItem(i2);
            if (bVar == null) {
                return null;
            }
            bVar.f64312h = i2;
            bVar.f64305a.setOnClickListener(this.f64318i);
            bVar.f64306b.setPlaceHolder(1);
            bVar.f64306b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.f64306b.M(feedForumData.getAvatar(), 15, false);
            bVar.f64307c.setText(feedForumData.getForumName());
            bVar.f64308d.setText(String.format(this.f64314e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
            bVar.f64309e.setText(feedForumData.getReason());
            if (feedForumData.getIsLike() == 0) {
                bVar.f64310f.setClickable(true);
                bVar.f64310f.setOnClickListener(this.f64318i);
                bVar.f64310f.setEnabled(true);
                bVar.f64310f.h(false);
            } else {
                e(bVar);
            }
            c(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
