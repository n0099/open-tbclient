package com.repackage;

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
import com.repackage.dq4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class gh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<FrsFragment> a;
    public LinearLayout b;
    public View c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public View g;
    public View h;
    public List<hh6> i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public a9 r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh6 a;

        public a(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FeedForumData feedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090acc) {
                    if (ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && (feedForumData = (FeedForumData) view2.getTag()) != null) {
                        this.a.k.P(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new StatisticItem(this.a.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091215) {
                    this.a.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.a.n));
                } else if (view2.getId() != R.id.obfuscated_res_0x7f090b3a) {
                    if (view2.getId() != this.a.f.getId() || ListUtils.getCount(this.a.j) <= 0) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.a.a.getPageActivity(), (Serializable) this.a.j)));
                    TiebaStatic.log(new StatisticItem("c10046").param("fid", this.a.n));
                } else {
                    FeedForumData feedForumData2 = (FeedForumData) view2.getTag();
                    if (feedForumData2 != null) {
                        this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), this.a.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                        TiebaStatic.log(new StatisticItem(this.a.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh6 a;

        public b(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh6Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (this.a.j != null) {
                    this.a.j.clear();
                }
                this.a.m();
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ag8 a;
            public final /* synthetic */ d b;

            public a(d dVar, ag8 ag8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, ag8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = ag8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.b.a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.a.g())) {
                            this.b.a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.b.a.j.size() > 0) {
                        this.b.a.p();
                    } else {
                        this.b.a.m();
                    }
                }
            }
        }

        public d(gh6 gh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh6Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.k.getErrorCode(), this.a.k.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.k.getErrorString());
                } else if (obj == null) {
                    if (StringUtils.isNull(this.a.k.getErrorString())) {
                        return;
                    }
                    li.O(TbadkCoreApplication.getInst(), this.a.k.getErrorString());
                } else {
                    ag8 ag8Var = (ag8) obj;
                    if (ListUtils.getCount(this.a.j) <= 0 || ag8Var == null) {
                        return;
                    }
                    Iterator it = this.a.i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        hh6 hh6Var = (hh6) it.next();
                        FeedForumData feedForumData = (FeedForumData) hh6Var.f.getTag();
                        if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(ag8Var.g())) {
                            feedForumData.setIsLike(1);
                            this.a.l(hh6Var);
                            break;
                        }
                    }
                    if (this.a.m == 1) {
                        this.a.l.postDelayed(new a(this, ag8Var), 1000L);
                    }
                }
            }
        }
    }

    public gh6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
    }

    public final String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
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

    public final void l(hh6 hh6Var) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh6Var) == null) || hh6Var == null || (entelechyUserLikeButton = hh6Var.f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        hh6Var.f.setEnabled(false);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setVisibility(8);
        }
    }

    public void n(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b0c);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090b0d);
            this.g = view2.findViewById(R.id.obfuscated_res_0x7f0911ac);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091216);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091215);
            this.e = imageView;
            imageView.setOnClickListener(this.q);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090972);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090971);
            this.f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            int size = this.j.size() > 2 ? 2 : this.j.size();
            int size2 = size - this.i.size();
            if (size2 > 0) {
                for (int i = 0; i < size2; i++) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(this.m == 1 ? R.layout.obfuscated_res_0x7f0d0314 : R.layout.obfuscated_res_0x7f0d0301, (ViewGroup) null);
                    this.b.addView(inflate);
                    this.i.add(new hh6(inflate));
                }
            } else if (size2 < 0) {
                for (int i2 = 0; i2 < (-size2); i2++) {
                    int size3 = this.i.size() - 1;
                    this.b.removeView(this.i.get(size3).a);
                    this.i.remove(size3);
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                FeedForumData feedForumData = this.j.get(i3);
                hh6 hh6Var = this.i.get(i3);
                if (feedForumData != null && hh6Var != null) {
                    hh6Var.a.setTag(feedForumData);
                    hh6Var.a.setOnClickListener(this.q);
                    hh6Var.b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    hh6Var.b.setPlaceHolder(1);
                    hh6Var.b.K(feedForumData.getAvatar(), 15, false);
                    hh6Var.c.setText(feedForumData.getForumName());
                    hh6Var.d.setText(String.format(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f02b1), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    hh6Var.e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        hh6Var.f.setClickable(true);
                        hh6Var.f.setOnClickListener(this.q);
                        hh6Var.f.setTag(feedForumData);
                        hh6Var.f.h(false);
                        hh6Var.f.setEnabled(true);
                    } else {
                        l(hh6Var);
                    }
                }
            }
            if (this.p) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0110, 1);
            for (hh6 hh6Var : this.i) {
                SkinManager.setBackgroundResource(hh6Var.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(hh6Var.c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(hh6Var.d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(hh6Var.e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = hh6Var.f;
                entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(0);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            dq4 dq4Var = new dq4(this.a.getPageActivity());
            dq4Var.setMessage(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c98));
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new b(this));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new c(this));
            dq4Var.create(this.a).show();
        }
    }

    public gh6(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
        n(tbPageContext, view2, i, z, bdUniqueId);
    }
}
