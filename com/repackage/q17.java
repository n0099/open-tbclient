package com.repackage;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes7.dex */
public class q17 extends jx5<i17> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public i17 j;
    public ClickableHeaderImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public AgreeView o;
    public TextView p;
    public ImageView q;
    public TbRichTextView r;
    public ConstrainImageGroup s;
    public RelativeLayout t;
    public View u;
    public TbImageView v;
    public TextView w;
    public View x;
    public boolean y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements cg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ q17 c;

        public a(q17 q17Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q17Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q17Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.repackage.cg5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.c.u();
                } else {
                    this.c.E(view2, this.a, i, this.b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q17(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = 3;
        this.i = tbPageContext;
        t();
    }

    public void A(eg<TbImageView> egVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, egVar) == null) || (constrainImageGroup = this.s) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(egVar);
    }

    public void B(eg<ConstrainImageLayout> egVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egVar) == null) || (constrainImageGroup = this.s) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(egVar);
    }

    public final void C(i17 i17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i17Var) == null) {
            ThreadData threadData = i17Var.b;
            ArrayList<MediaData> medias = threadData.getMedias();
            if (an4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.t.setVisibility(0);
                    this.s.setFromCDN(this.y);
                    this.s.setImageClickListener(new a(this, linkedList, threadData));
                    this.s.setImageMediaList(linkedList);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public final void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            o(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.s;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void E(View view2, List<MediaData> list, int i, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, view2, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                pi.N(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0e73);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.y ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = ng.g(threadData.getTid(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.y(arrayList);
            builder.C(i);
            builder.A(threadData.getForum_name());
            builder.z(String.valueOf(threadData.getFid()));
            builder.P(threadData.getTid());
            builder.D(this.y);
            builder.K(arrayList.size() > 0 ? arrayList.get(0) : "");
            builder.G(true);
            builder.x(concurrentHashMap);
            builder.I(true);
            builder.O(threadData);
            builder.N(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig w = builder.w(this.b.getPageActivity());
            if (this.h == 2) {
                w.getIntent().putExtra("from", "index");
            } else {
                w.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, w));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.b;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0851 : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) || this.z == i || this.j == null) {
            return;
        }
        this.z = i;
        this.k.setSkinType(i);
        i17 i17Var = this.j;
        if (i17Var.f) {
            int i2 = i17Var.d;
            if (i2 == 1) {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_agree_red);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i2 == 2) {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_disagree_blue);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                SkinManager.setImageResource(this.m, R.drawable.label_topic_eat_black);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        }
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0107);
        if (this.q != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f0809ec, R.color.CAM_X0107, null);
        }
        this.o.K(i);
        this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundShapeDrawable(this.u, pi.f(this.i.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
        this.s.b();
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        i17 i17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || (i17Var = this.j) == null || i17Var.b == null) {
            return;
        }
        if (view2 == this.r) {
            if (i17Var.e == 1) {
                v();
            } else {
                u();
            }
            s("1");
        }
        if (view2 != this.p && view2 != this.q) {
            if (view2 == this.l) {
                w();
                return;
            }
            u();
            s("2");
            return;
        }
        if (this.j.e == 1) {
            v();
        } else {
            u();
        }
        s("3");
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.j.b.getTid()).param("topic_id", this.j.c).param("obj_type", String.valueOf(this.j.e)));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View h = h();
            this.k = (ClickableHeaderImageView) h.findViewById(R.id.obfuscated_res_0x7f09055e);
            this.m = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090562);
            this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09055f);
            this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09055c);
            TbRichTextView tbRichTextView = (TbRichTextView) h.findViewById(R.id.obfuscated_res_0x7f090560);
            this.r = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.r.setTextEllipsize(TextUtils.TruncateAt.END);
            this.r.setMaxLines(2);
            ng5 ng5Var = new ng5();
            ng5Var.v(pi.f(getContext(), R.dimen.tbds44));
            ng5Var.o(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.r.setLayoutStrategy(ng5Var);
            this.t = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f09216f);
            this.s = (ConstrainImageGroup) h.findViewById(R.id.obfuscated_res_0x7f09055d);
            this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            zf5 zf5Var = new zf5(3);
            zf5Var.d(1.0d);
            this.s.setImageProcessor(zf5Var);
            AgreeView agreeView = (AgreeView) h.findViewById(R.id.obfuscated_res_0x7f090559);
            this.o = agreeView;
            agreeView.v();
            this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092161);
            this.q = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092162);
            this.u = h.findViewById(R.id.obfuscated_res_0x7f09055b);
            TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f090564);
            this.v = tbImageView;
            tbImageView.setRadius(pi.f(getContext(), R.dimen.tbds6));
            this.v.setConrers(5);
            this.v.setDrawCorner(true);
            this.w = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090565);
            this.x = h.findViewById(R.id.obfuscated_res_0x7f09055a);
            this.l.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
        }
    }

    public void u() {
        i17 i17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (i17Var = this.j) == null || i17Var.b == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(this.j.b, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.j.b.getFid()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.j.b.getForum_name());
        addLocateParam.setStartFrom(this.h);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        ux5.a(this.j.b.getTid());
        this.b.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String format = String.format("%1$s", this.j.b.getTopAgreePost().J());
            String valueOf = String.valueOf(this.j.b.getTid());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.i.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void w() {
        i17 i17Var;
        ThreadData threadData;
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (i17Var = this.j) == null || (threadData = i17Var.b) == null) {
            return;
        }
        if (i17Var.e == 1 && threadData.getTopAgreePost() != null) {
            author = threadData.getTopAgreePost().s();
        } else {
            author = threadData.getAuthor();
        }
        if (author == null || StringUtils.isNull(author.getName_show()) || StringUtils.isNull(author.getUserId())) {
            return;
        }
        long g = ng.g(author.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(g, g == ng.g(TbadkCoreApplication.getCurrentAccount(), 0L), author.isBigV(), threadData.getThreadVideoInfo() != null, PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
        createNormalConfig.setSourceTid(threadData.getTid());
        createNormalConfig.setSourceNid(threadData.getNid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: x */
    public void i(i17 i17Var) {
        String name_show;
        String formatTime;
        int reply_num;
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, i17Var) == null) || i17Var == null || i17Var.b == null) {
            return;
        }
        this.j = i17Var;
        j(this.i, TbadkCoreApplication.getInst().getSkinType());
        ThreadData threadData = this.j.b;
        PostData topAgreePost = threadData.getTopAgreePost();
        if (topAgreePost == null) {
            return;
        }
        this.k.setPlaceHolder(1);
        if (this.j.e == 1) {
            this.k.setData(threadData, false, true);
        } else {
            this.k.setData(threadData, false, false);
        }
        this.k.setIsRound(true);
        this.k.setBorderWidth(2);
        this.k.setDrawBorder(true);
        this.k.setPageId(this.i.getUniqueId());
        if (this.j.f) {
            this.m.setVisibility(0);
            int i = this.j.d;
            if (i == 1) {
                this.m.setImageResource(R.drawable.label_topic_agree_red);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i == 2) {
                this.m.setImageResource(R.drawable.label_topic_disagree_blue);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                this.m.setImageResource(R.drawable.label_topic_eat_black);
                this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        } else {
            this.m.setVisibility(8);
        }
        if (this.j.e == 1) {
            name_show = topAgreePost.s().getName_show();
            formatTime = StringHelper.getFormatTime(topAgreePost.Y());
            reply_num = topAgreePost.U();
        } else {
            name_show = threadData.getAuthor().getName_show();
            formatTime = StringHelper.getFormatTime(threadData.getCreateTime());
            reply_num = threadData.getReply_num();
        }
        if (!StringUtils.isNull(name_show)) {
            this.l.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
        }
        if (StringUtils.isNull(threadData.getForum_name())) {
            this.n.setText(formatTime);
        } else {
            this.n.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0476), StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 10, StringHelper.STRING_MORE), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f0809ec, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(reply_num);
        if (reply_num > 0) {
            this.p.setVisibility(0);
            this.p.setText(numFormatOverWan);
        } else {
            this.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0086));
            this.p.setVisibility(0);
        }
        if (this.j.e == 1) {
            agreeData = topAgreePost.p();
            agreeData.objType = 1;
        } else {
            agreeData = threadData.getAgreeData();
            agreeData.objType = 3;
        }
        agreeData.threadId = threadData.getTid();
        this.o.setData(agreeData);
        this.o.setTopicId(String.valueOf(this.j.c));
        z(topAgreePost, threadData);
        y(i17Var, threadData);
        D(f());
    }

    public final void y(i17 i17Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, i17Var, threadData) == null) {
            if (this.j.e == 1) {
                this.u.setVisibility(0);
                this.t.setVisibility(8);
                String title = threadData.getTitle();
                if (StringUtils.isNull(title)) {
                    this.u.setVisibility(8);
                    return;
                }
                this.u.setVisibility(0);
                this.w.setText(title);
                String str = null;
                if (ListUtils.getCount(threadData.getMedias()) != 0 && !ListUtils.isEmpty(i17Var.b.getMedias())) {
                    Iterator<MediaData> it = i17Var.b.getMedias().iterator();
                    while (it.hasNext()) {
                        MediaData next = it.next();
                        if (next != null && next.getType() == 3) {
                            str = next.getPicUrl();
                            if (StringUtils.isNull(str)) {
                                str = next.getSmallUrl();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getThumbnails_url();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getSrc_pic();
                            }
                            if (!StringUtils.isNull(str)) {
                                break;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    SkinManager.setImageResource(this.v, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.v.setPlaceHolder(1);
                this.v.J(str, 10, false);
                return;
            }
            this.u.setVisibility(8);
            this.t.setVisibility(0);
            C(i17Var);
        }
    }

    public final void z(PostData postData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, postData, threadData) == null) {
            if (this.j.e == 1) {
                this.r.setVisibility(0);
                this.r.setText(postData.Q());
                return;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (ListUtils.getCount(firstFloorList) > 0) {
                this.r.setVisibility(0);
                this.r.setText(TbRichTextView.Y(firstFloorList, false, threadData));
                return;
            }
            SpannableString parseAbstract = threadData.parseAbstract();
            if (parseAbstract != null && !StringUtils.isNull(parseAbstract.toString())) {
                this.r.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", parseAbstract);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.r.setText(TbRichTextView.U(jSONArray, false));
                return;
            }
            this.r.setVisibility(8);
        }
    }
}
