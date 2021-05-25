package d.a.n0.b1.j.a.e;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.l;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.n0.z.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class d extends d.a.n0.z.b<d.a.n0.b1.j.a.c.c> {
    public TextView A;
    public View B;
    public boolean C;
    public int D;
    public TbPageContext m;
    public d.a.n0.b1.j.a.c.c n;
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

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.b1.j.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f51981a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a2 f51982b;

        public a(LinkedList linkedList, a2 a2Var) {
            this.f51981a = linkedList;
            this.f51982b = a2Var;
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            if (z) {
                d.this.v();
            } else {
                d.this.I(view, this.f51981a, i2, this.f51982b);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.C = true;
        this.D = 3;
        this.m = tbPageContext;
        u();
    }

    public final void A(PostData postData, a2 a2Var) {
        if (this.n.f51950i == 1) {
            this.v.setVisibility(0);
            this.v.setText(postData.K());
            return;
        }
        List<PbContent> e0 = a2Var.e0();
        if (ListUtils.getCount(e0) > 0) {
            this.v.setVisibility(0);
            this.v.setText(TbRichTextView.U(b(), e0, false));
            return;
        }
        SpannableString I2 = a2Var.I2();
        if (I2 != null && !StringUtils.isNull(I2.toString())) {
            this.v.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", I2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.v.setText(TbRichTextView.S(b(), jSONArray, false));
            return;
        }
        this.v.setVisibility(8);
    }

    public void B(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.w;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void F(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.w;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public final void G(d.a.n0.b1.j.a.c.c cVar) {
        a2 a2Var = cVar.f51947f;
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (ListUtils.getCount(linkedList) > 0) {
                this.x.setVisibility(0);
                this.w.setFromCDN(this.C);
                this.w.setImageClickListener(new a(linkedList, a2Var));
                this.w.setImageMediaList(linkedList);
                return;
            }
            this.x.setVisibility(8);
            return;
        }
        this.x.setVisibility(8);
    }

    public final void H(BdUniqueId bdUniqueId) {
        p(bdUniqueId);
        ConstrainImageGroup constrainImageGroup = this.w;
        if (constrainImageGroup != null) {
            constrainImageGroup.setPageUniqueId(bdUniqueId);
        }
    }

    public final void I(View view, List<MediaData> list, int i2, a2 a2Var) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.L(this.f63441f.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.threadId = d.a.c.e.m.b.f(a2Var.y1(), -1L);
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
        bVar.z(a2Var.i0());
        bVar.y(String.valueOf(a2Var.c0()));
        bVar.O(a2Var.y1());
        bVar.C(this.C);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(a2Var);
        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(this.f63441f.getPageActivity());
        if (this.l == 2) {
            v.getIntent().putExtra("from", "index");
        } else {
            v.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.f63441f;
        historyMessage.threadId = a2Var.o0();
        historyMessage.threadName = a2Var.z1();
        historyMessage.forumName = a2Var.i0();
        historyMessage.postID = a2Var.f0();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.topic_discuss_view;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.D == i2 || this.n == null) {
            return;
        }
        this.D = i2;
        this.o.setIsNight(i2 == 1);
        d.a.n0.b1.j.a.c.c cVar = this.n;
        if (cVar.j) {
            int i3 = cVar.f51949h;
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
        this.s.t(i2);
        this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundShapeDrawable(this.y, l.g(this.m.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
        this.w.b();
        SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.b1.j.a.c.c cVar = this.n;
        if (cVar == null || cVar.f51947f == null) {
            return;
        }
        if (view == this.v) {
            if (cVar.f51950i == 1) {
                w();
            } else {
                v();
            }
            t("1");
        }
        if (view != this.t && view != this.u) {
            if (view == this.p) {
                x();
                return;
            }
            v();
            t("2");
            return;
        }
        if (this.n.f51950i == 1) {
            w();
        } else {
            v();
        }
        t("3");
    }

    public final void t(String str) {
        TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.n.f51947f.y1()).param("topic_id", this.n.f51948g).param("obj_type", String.valueOf(this.n.f51950i)));
    }

    public final void u() {
        View l = l();
        this.o = (ClickableHeaderImageView) l.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.q = (ImageView) l.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.p = (TextView) l.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.r = (TextView) l.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        TbRichTextView tbRichTextView = (TbRichTextView) l.findViewById(R.id.card_topic_detail_discuss_title);
        this.v = tbRichTextView;
        tbRichTextView.setClickable(true);
        this.v.setTextEllipsize(TextUtils.TruncateAt.END);
        this.v.setMaxLines(2);
        d.a.m0.b1.m.a aVar = new d.a.m0.b1.m.a();
        aVar.v(l.g(b(), R.dimen.tbds44));
        aVar.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.v.setLayoutStrategy(aVar);
        this.x = (RelativeLayout) l.findViewById(R.id.topic_detail_img_container);
        this.w = (ConstrainImageGroup) l.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.w.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        d.a.m0.b1.j.a aVar2 = new d.a.m0.b1.j.a(3);
        aVar2.d(1.0d);
        this.w.setImageProcessor(aVar2);
        AgreeView agreeView = (AgreeView) l.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.s = agreeView;
        agreeView.i();
        this.t = (TextView) l.findViewById(R.id.topic_comment_number);
        this.u = (ImageView) l.findViewById(R.id.topic_comment_pic);
        this.y = l.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        TbImageView tbImageView = (TbImageView) l.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.z = tbImageView;
        tbImageView.setRadius(l.g(b(), R.dimen.tbds6));
        this.z.setConrers(5);
        this.z.setDrawCorner(true);
        this.A = (TextView) l.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.B = l.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.A.setOnClickListener(this);
    }

    public void v() {
        d.a.n0.b1.j.a.c.c cVar = this.n;
        if (cVar == null || cVar.f51947f == null) {
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(this.n.f51947f, null, "none", 18003, true, false, false).addLocateParam(null);
        addLocateParam.setForumId(String.valueOf(this.n.f51947f.c0()));
        addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        addLocateParam.setForumName(this.n.f51947f.i0());
        addLocateParam.setStartFrom(this.l);
        addLocateParam.setJumpGodReply(false);
        addLocateParam.setJumpToCommentArea(true);
        m.a(this.n.f51947f.y1());
        this.f63441f.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void w() {
        String format = String.format("%1$s", this.n.f51947f.B1().E());
        String valueOf = String.valueOf(this.n.f51947f.y1());
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.m.getPageActivity());
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public final void x() {
        a2 a2Var;
        MetaData T;
        d.a.n0.b1.j.a.c.c cVar = this.n;
        if (cVar == null || (a2Var = cVar.f51947f) == null) {
            return;
        }
        if (cVar.f51950i == 1 && a2Var.B1() != null) {
            T = a2Var.B1().t();
        } else {
            T = a2Var.T();
        }
        if (T == null || StringUtils.isNull(T.getName_show()) || StringUtils.isNull(T.getUserId())) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(T.getUserId(), 0L);
        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(b()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), T.isBigV());
        createNormalConfig.setSourceTid(a2Var.y1());
        createNormalConfig.setSourceNid(a2Var.M0());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: y */
    public void m(d.a.n0.b1.j.a.c.c cVar) {
        String name_show;
        String formatTime;
        int a1;
        AgreeData L;
        if (cVar == null || cVar.f51947f == null) {
            return;
        }
        this.n = cVar;
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
        a2 a2Var = this.n.f51947f;
        PostData B1 = a2Var.B1();
        if (B1 == null) {
            return;
        }
        this.o.setPlaceHolder(1);
        if (this.n.f51950i == 1) {
            this.o.setData(a2Var, false, true);
        } else {
            this.o.setData(a2Var, false, false);
        }
        this.o.setIsRound(true);
        this.o.setBorderWidth(2);
        this.o.setDrawBorder(true);
        this.o.setPageId(this.m.getUniqueId());
        if (this.n.j) {
            this.q.setVisibility(0);
            int i2 = this.n.f51949h;
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
        if (this.n.f51950i == 1) {
            name_show = B1.t().getName_show();
            formatTime = StringHelper.getFormatTime(B1.R());
            a1 = B1.N();
        } else {
            name_show = a2Var.T().getName_show();
            formatTime = StringHelper.getFormatTime(a2Var.Z());
            a1 = a2Var.a1();
        }
        if (!StringUtils.isNull(name_show)) {
            this.p.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
        }
        if (StringUtils.isNull(a2Var.i0())) {
            this.r.setText(formatTime);
        } else {
            this.r.setText(String.format(b().getString(R.string.daily_topic_discuss_forum_name), StringHelper.cutChineseAndEnglishWithSuffix(a2Var.i0(), 10, StringHelper.STRING_MORE), formatTime));
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        String numFormatOverWan = StringHelper.numFormatOverWan(a1);
        if (a1 > 0) {
            this.t.setVisibility(0);
            this.t.setText(numFormatOverWan);
        } else {
            this.t.setText(this.m.getString(R.string.action_comment_default));
            this.t.setVisibility(0);
        }
        if (this.n.f51950i == 1) {
            L = B1.r();
            L.objType = 1;
        } else {
            L = a2Var.L();
            L.objType = 3;
        }
        L.threadId = a2Var.y1();
        this.s.setData(L);
        this.s.setTopicId(String.valueOf(this.n.f51948g));
        A(B1, a2Var);
        z(cVar, a2Var);
        H(i());
    }

    public final void z(d.a.n0.b1.j.a.c.c cVar, a2 a2Var) {
        if (this.n.f51950i == 1) {
            this.y.setVisibility(0);
            this.x.setVisibility(8);
            String z1 = a2Var.z1();
            if (StringUtils.isNull(z1)) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            this.A.setText(z1);
            String str = null;
            if (ListUtils.getCount(a2Var.L0()) != 0 && !ListUtils.isEmpty(cVar.f51947f.L0())) {
                Iterator<MediaData> it = cVar.f51947f.L0().iterator();
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
            this.z.V(str, 10, false);
            return;
        }
        this.y.setVisibility(8);
        this.x.setVisibility(0);
        G(cVar);
    }
}
