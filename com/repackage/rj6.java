package com.repackage;

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
import java.util.List;
/* loaded from: classes7.dex */
public class rj6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<FrsMoreFeedForumsActivity> a;
    public List<FeedForumData> b;
    public int c;
    public LikeModel d;
    public View.OnClickListener e;
    public a9 f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj6 a;

        public a(rj6 rj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pj6 pj6Var;
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (pj6Var = (pj6) view2.getTag()) == null || (feedForumData = (FeedForumData) this.a.getItem(pj6Var.h)) == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090af1) {
                if (((FrsMoreFeedForumsActivity) this.a.a.getOrignalPage()).checkUpIsLogin()) {
                    this.a.d.P(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090b63) {
                this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj6 a;

        public b(rj6 rj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.d.getErrorCode(), this.a.d.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.d.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.a.d.getErrorString())) {
                        return;
                    }
                    oi.N(TbadkCoreApplication.getInst(), this.a.d.getErrorString());
                } else {
                    ck8 ck8Var = (ck8) obj;
                    ck8Var.y(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ck8Var));
                }
            }
        }
    }

    public rj6(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.f = new b(this);
        this.a = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.d = likeModel;
        likeModel.setLoadDataCallBack(this.f);
    }

    public final void c(pj6 pj6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pj6Var) == null) || pj6Var.i == this.c) {
            return;
        }
        SkinManager.setBackgroundResource(pj6Var.a, R.drawable.frs_like_feed_forum_item_bg);
        SkinManager.setViewTextColor(pj6Var.c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(pj6Var.d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(pj6Var.e, R.color.CAM_X0305, 1);
        View view2 = pj6Var.g;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
        }
        pj6Var.i = this.c;
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                return "0";
            }
            if (i < 10000) {
                return String.valueOf(i);
            }
            if (i == 10000) {
                return "1W";
            }
            float f = i / 10000.0f;
            return f <= 9999.9f ? String.format("%.1fW", Float.valueOf(f)) : "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public final void e(pj6 pj6Var) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pj6Var) == null) || pj6Var == null || (entelechyUserLikeButton = pj6Var.f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        pj6Var.f.setEnabled(false);
    }

    public void f(List<FeedForumData> list, ck8 ck8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, ck8Var) == null) || list == null || list.size() <= 0 || ck8Var == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(ck8Var.g())) {
                feedForumData.setIsLike(ck8Var.n());
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void g(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FeedForumData> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List<FeedForumData> list = this.b;
            if (list != null) {
                return list.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        pj6 pj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            this.c = TbadkCoreApplication.getInst().getSkinType();
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d033f, (ViewGroup) null);
                pj6Var = new pj6(view2);
                view2.setTag(pj6Var);
                pj6Var.f.setTag(pj6Var);
            } else {
                pj6Var = (pj6) view2.getTag();
            }
            FeedForumData feedForumData = (FeedForumData) getItem(i);
            if (pj6Var == null) {
                return null;
            }
            pj6Var.h = i;
            pj6Var.a.setOnClickListener(this.e);
            pj6Var.b.setPlaceHolder(1);
            pj6Var.b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            pj6Var.b.K(feedForumData.getAvatar(), 15, false);
            pj6Var.c.setText(feedForumData.getForumName());
            pj6Var.d.setText(String.format(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f02aa), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
            pj6Var.e.setText(feedForumData.getReason());
            if (feedForumData.getIsLike() == 0) {
                pj6Var.f.setClickable(true);
                pj6Var.f.setOnClickListener(this.e);
                pj6Var.f.setEnabled(true);
                pj6Var.f.h(false);
            } else {
                e(pj6Var);
            }
            c(pj6Var);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
