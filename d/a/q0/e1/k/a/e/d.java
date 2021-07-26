package d.a.q0.e1.k.a.e;

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
import d.a.d.e.p.l;
import d.a.p0.s.k;
import d.a.p0.s.q.b2;
import d.a.q0.a0.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes8.dex */
public class d extends d.a.q0.a0.b<d.a.q0.e1.k.a.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public boolean C;
    public int D;
    public TbPageContext m;
    public d.a.q0.e1.k.a.c.c n;
    public ClickableHeaderImageView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public AgreeView s;
    public TextView t;
    public ImageView u;
    public TbRichTextView v;
    public ConstrainImageGroup w;
    public RelativeLayout x;
    public View y;
    public TbImageView z;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.d1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f56350a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b2 f56351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f56352c;

        public a(d dVar, LinkedList linkedList, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, linkedList, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56352c = dVar;
            this.f56350a = linkedList;
            this.f56351b = b2Var;
        }

        @Override // d.a.p0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.f56352c.u();
                } else {
                    this.f56352c.H(view, this.f56350a, i2, this.f56351b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = true;
        this.D = 3;
        this.m = tbPageContext;
        t();
    }

    public void A(d.a.d.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void B(d.a.d.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (constrainImageGroup = this.w) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void F(d.a.q0.e1.k.a.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            b2 b2Var = cVar.f56316f;
            ArrayList<MediaData> A0 = b2Var.A0();
            if (k.c().g() && ListUtils.getCount(A0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < A0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(A0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.x.setVisibility(0);
                    this.w.setFromCDN(this.C);
                    this.w.setImageClickListener(new a(this, linkedList, b2Var));
                    this.w.setImageMediaList(linkedList);
                    return;
                }
                this.x.setVisibility(8);
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public final void G(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            o(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.w;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void H(View view, List<MediaData> list, int i2, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, view, list, i2, b2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                l.L(this.f54320f.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.C ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = d.a.d.e.m.b.f(b2Var.o1(), -1L);
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
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(b2Var.X());
            bVar.y(String.valueOf(b2Var.R()));
            bVar.O(b2Var.o1());
            bVar.C(this.C);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(b2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.f54320f.getPageActivity());
            if (this.l == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.f54320f;
            historyMessage.threadId = b2Var.d0();
            historyMessage.threadName = b2Var.getTitle();
            historyMessage.forumName = b2Var.X();
            historyMessage.postID = b2Var.U();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.topic_discuss_view : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) || this.D == i2 || this.n == null) {
            return;
        }
        this.D = i2;
        this.o.setIsNight(i2 == 1);
        d.a.q0.e1.k.a.c.c cVar = this.n;
        if (cVar.j) {
            int i3 = cVar.f56318h;
            if (i3 == 1) {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_agree_red);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i3 == 2) {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_disagree_blue);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                SkinManager.setImageResource(this.q, R.drawable.label_topic_eat_black);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        }
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0107);
        if (this.u != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, null);
        }
        this.s.v(i2);
        this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundShapeDrawable(this.y, l.g(this.m.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
        this.w.b();
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.q0.e1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (cVar = this.n) == null || cVar.f56316f == null) {
            return;
        }
        if (view == this.v) {
            if (cVar.f56319i == 1) {
                v();
            } else {
                u();
            }
            s("1");
        }
        if (view != this.t && view != this.u) {
            if (view == this.p) {
                w();
                return;
            }
            u();
            s("2");
            return;
        }
        if (this.n.f56319i == 1) {
            v();
        } else {
            u();
        }
        s("3");
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.n.f56316f.o1()).param("topic_id", this.n.f56317g).param("obj_type", String.valueOf(this.n.f56319i)));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View k = k();
            this.o = (ClickableHeaderImageView) k.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
            this.q = (ImageView) k.findViewById(R.id.card_topic_detail_thread_opinion_img);
            this.p = (TextView) k.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
            this.r = (TextView) k.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
            TbRichTextView tbRichTextView = (TbRichTextView) k.findViewById(R.id.card_topic_detail_discuss_title);
            this.v = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.v.setTextEllipsize(TextUtils.TruncateAt.END);
            this.v.setMaxLines(2);
            d.a.p0.d1.m.a aVar = new d.a.p0.d1.m.a();
            aVar.v(l.g(b(), R.dimen.tbds44));
            aVar.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.v.setLayoutStrategy(aVar);
            this.x = (RelativeLayout) k.findViewById(R.id.topic_detail_img_container);
            this.w = (ConstrainImageGroup) k.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
            this.w.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            d.a.p0.d1.j.a aVar2 = new d.a.p0.d1.j.a(3);
            aVar2.d(1.0d);
            this.w.setImageProcessor(aVar2);
            AgreeView agreeView = (AgreeView) k.findViewById(R.id.card_topic_detail_discuss_argee_view);
            this.s = agreeView;
            agreeView.j();
            this.t = (TextView) k.findViewById(R.id.topic_comment_number);
            this.u = (ImageView) k.findViewById(R.id.topic_comment_pic);
            this.y = k.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.card_topic_discuss_original_thread_pic);
            this.z = tbImageView;
            tbImageView.setRadius(l.g(b(), R.dimen.tbds6));
            this.z.setConrers(5);
            this.z.setDrawCorner(true);
            this.A = (TextView) k.findViewById(R.id.card_topic_discuss_original_thread_title);
            this.B = k.findViewById(R.id.card_topic_detail_discuss_line_layout);
            this.p.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.A.setOnClickListener(this);
        }
    }

    public void u() {
        d.a.q0.e1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.n) == null || cVar.f56316f == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(this.n.f56316f, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.n.f56316f.R()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.n.f56316f.X());
        addLocateParam.setStartFrom(this.l);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        m.a(this.n.f56316f.o1());
        this.f54320f.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String format = String.format("%1$s", this.n.f56316f.q1().E());
            String valueOf = String.valueOf(this.n.f56316f.o1());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.m.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void w() {
        d.a.q0.e1.k.a.c.c cVar;
        b2 b2Var;
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (cVar = this.n) == null || (b2Var = cVar.f56316f) == null) {
            return;
        }
        if (cVar.f56319i == 1 && b2Var.q1() != null) {
            H = b2Var.q1().t();
        } else {
            H = b2Var.H();
        }
        if (H == null || StringUtils.isNull(H.getName_show()) || StringUtils.isNull(H.getUserId())) {
            return;
        }
        long f2 = d.a.d.e.m.b.f(H.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(b()).createNormalConfig(f2, f2 == d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), H.isBigV());
        createNormalConfig.setSourceTid(b2Var.o1());
        createNormalConfig.setSourceNid(b2Var.B0());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: x */
    public void l(d.a.q0.e1.k.a.c.c cVar) {
        String name_show;
        String formatTime;
        int Q0;
        AgreeData z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) || cVar == null || cVar.f56316f == null) {
            return;
        }
        this.n = cVar;
        m(this.m, TbadkCoreApplication.getInst().getSkinType());
        b2 b2Var = this.n.f56316f;
        PostData q1 = b2Var.q1();
        if (q1 == null) {
            return;
        }
        this.o.setPlaceHolder(1);
        if (this.n.f56319i == 1) {
            this.o.setData(b2Var, false, true);
        } else {
            this.o.setData(b2Var, false, false);
        }
        this.o.setIsRound(true);
        this.o.setBorderWidth(2);
        this.o.setDrawBorder(true);
        this.o.setPageId(this.m.getUniqueId());
        if (this.n.j) {
            this.q.setVisibility(0);
            int i2 = this.n.f56318h;
            if (i2 == 1) {
                this.q.setImageResource(R.drawable.label_topic_agree_red);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0301));
            } else if (i2 == 2) {
                this.q.setImageResource(R.drawable.label_topic_disagree_blue);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0302));
            } else {
                this.q.setImageResource(R.drawable.label_topic_eat_black);
                this.o.setBorderColor(this.m.getPageActivity().getResources().getColor(R.color.CAM_X0106));
            }
        } else {
            this.q.setVisibility(8);
        }
        if (this.n.f56319i == 1) {
            name_show = q1.t().getName_show();
            formatTime = StringHelper.getFormatTime(q1.R());
            Q0 = q1.N();
        } else {
            name_show = b2Var.H().getName_show();
            formatTime = StringHelper.getFormatTime(b2Var.N());
            Q0 = b2Var.Q0();
        }
        if (!StringUtils.isNull(name_show)) {
            this.p.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
        }
        if (StringUtils.isNull(b2Var.X())) {
            this.r.setText(formatTime);
        } else {
            this.r.setText(String.format(b().getString(R.string.daily_topic_discuss_forum_name), StringHelper.cutChineseAndEnglishWithSuffix(b2Var.X(), 10, StringHelper.STRING_MORE), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(Q0);
        if (Q0 > 0) {
            this.t.setVisibility(0);
            this.t.setText(numFormatOverWan);
        } else {
            this.t.setText(this.m.getString(R.string.action_comment_default));
            this.t.setVisibility(0);
        }
        if (this.n.f56319i == 1) {
            z = q1.q();
            z.objType = 1;
        } else {
            z = b2Var.z();
            z.objType = 3;
        }
        z.threadId = b2Var.o1();
        this.s.setData(z);
        this.s.setTopicId(String.valueOf(this.n.f56317g));
        z(q1, b2Var);
        y(cVar, b2Var);
        G(i());
    }

    public final void y(d.a.q0.e1.k.a.c.c cVar, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, cVar, b2Var) == null) {
            if (this.n.f56319i == 1) {
                this.y.setVisibility(0);
                this.x.setVisibility(8);
                String title = b2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    this.y.setVisibility(8);
                    return;
                }
                this.y.setVisibility(0);
                this.A.setText(title);
                String str = null;
                if (ListUtils.getCount(b2Var.A0()) != 0 && !ListUtils.isEmpty(cVar.f56316f.A0())) {
                    Iterator<MediaData> it = cVar.f56316f.A0().iterator();
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
                    SkinManager.setImageResource(this.z, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.z.setPlaceHolder(1);
                this.z.M(str, 10, false);
                return;
            }
            this.y.setVisibility(8);
            this.x.setVisibility(0);
            F(cVar);
        }
    }

    public final void z(PostData postData, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, postData, b2Var) == null) {
            if (this.n.f56319i == 1) {
                this.v.setVisibility(0);
                this.v.setText(postData.K());
                return;
            }
            List<PbContent> T = b2Var.T();
            if (ListUtils.getCount(T) > 0) {
                this.v.setVisibility(0);
                this.v.setText(TbRichTextView.V(b(), T, false));
                return;
            }
            SpannableString y2 = b2Var.y2();
            if (y2 != null && !StringUtils.isNull(y2.toString())) {
                this.v.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", y2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.v.setText(TbRichTextView.T(b(), jSONArray, false));
                return;
            }
            this.v.setVisibility(8);
        }
    }
}
