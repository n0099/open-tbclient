package d.a.k0.a1.j.a.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import d.a.c.e.p.l;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e extends d.a.k0.x.b<d.a.k0.a1.j.a.c.d> {
    public int m;
    public CellTopicLinearLayout n;
    public TextView o;
    public TbImageView p;
    public TextView q;
    public TextView r;
    public d.a.k0.a1.j.a.c.d s;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        View l = l();
        this.n = (CellTopicLinearLayout) l.findViewById(R.id.topic_special_root);
        this.o = (TextView) l.findViewById(R.id.topic_special_title);
        this.p = (TbImageView) l.findViewById(R.id.topic_special_thread_img);
        this.q = (TextView) l.findViewById(R.id.topic_special_thread_title);
        this.r = (TextView) l.findViewById(R.id.topic_special_thread_discuss);
        this.p.setRadius(l.g(this.f63162g, R.dimen.tbds10));
        this.p.setConrers(15);
        this.p.setPlaceHolder(2);
        this.n.setTopicOnClickListener(this);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_topic_special_view;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == this.m) {
            return;
        }
        this.m = i2;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        this.p.setIsNight(this.m == 1);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.k0.a1.j.a.c.d dVar = this.s;
        if (dVar == null || dVar.f51788i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13354").param("tid", this.s.f51788i.A).param("topic_id", this.s.f51786g).param("obj_locate", this.s.f51785f));
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f63161f.getPageActivity()).createFromThreadCfg(this.s.f51788i, null, "", 18005, true, false, false);
        if (this.s.f51788i.h0() == null) {
            createFromThreadCfg.setForumId(String.valueOf(this.s.f51788i.c0()));
            createFromThreadCfg.setForumName(this.s.f51788i.i0());
        } else {
            createFromThreadCfg.setForumId(this.s.f51788i.h0().h());
            createFromThreadCfg.setForumName(this.s.f51788i.h0().g());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(d.a.k0.a1.j.a.c.d dVar) {
        if (dVar == null || dVar.f51788i == null) {
            return;
        }
        this.s = dVar;
        if (dVar.f51784e) {
            if (StringUtils.isNull(dVar.f51787h)) {
                this.o.setText(R.string.topic_special_title_default);
            } else {
                this.o.setText(dVar.f51787h);
            }
        }
        this.o.setVisibility(dVar.f51784e ? 0 : 8);
        String str = null;
        if (!ListUtils.isEmpty(dVar.f51788i.K0())) {
            Iterator<MediaData> it = dVar.f51788i.K0().iterator();
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
        if (!StringHelper.equals(str, this.p.getUrl())) {
            this.p.Q();
        }
        this.p.V(str, 10, false);
        if (StringUtils.isNull(dVar.f51788i.y1())) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText(dVar.f51788i.y1());
        }
        this.r.setText(String.format(this.f63162g.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.f51788i.Z0())));
    }
}
