package d.b.j0.a1.j.a.e;

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
import d.b.c.e.p.l;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e extends d.b.j0.x.b<d.b.j0.a1.j.a.c.d> {
    public int m;
    public CellTopicLinearLayout n;
    public TextView o;
    public TbImageView p;
    public TextView q;
    public TextView r;
    public d.b.j0.a1.j.a.c.d s;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        View m = m();
        this.n = (CellTopicLinearLayout) m.findViewById(R.id.topic_special_root);
        this.o = (TextView) m.findViewById(R.id.topic_special_title);
        this.p = (TbImageView) m.findViewById(R.id.topic_special_thread_img);
        this.q = (TextView) m.findViewById(R.id.topic_special_thread_title);
        this.r = (TextView) m.findViewById(R.id.topic_special_thread_discuss);
        this.p.setRadius(l.g(this.f64178g, R.dimen.tbds10));
        this.p.setConrers(15);
        this.p.setPlaceHolder(2);
        this.n.setTopicOnClickListener(this);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_topic_special_view;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (i == this.m) {
            return;
        }
        this.m = i;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        this.p.setIsNight(this.m == 1);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.j0.a1.j.a.c.d dVar = this.s;
        if (dVar == null || dVar.i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13354").param("tid", this.s.i.A).param("topic_id", this.s.f53364g).param("obj_locate", this.s.f53363f));
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f64177f.getPageActivity()).createFromThreadCfg(this.s.i, null, "", 18005, true, false, false);
        if (this.s.i.h0() == null) {
            createFromThreadCfg.setForumId(String.valueOf(this.s.i.c0()));
            createFromThreadCfg.setForumName(this.s.i.i0());
        } else {
            createFromThreadCfg.setForumId(this.s.i.h0().h());
            createFromThreadCfg.setForumName(this.s.i.h0().i());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.a1.j.a.c.d dVar) {
        if (dVar == null || dVar.i == null) {
            return;
        }
        this.s = dVar;
        if (dVar.f53362e) {
            if (StringUtils.isNull(dVar.f53365h)) {
                this.o.setText(R.string.topic_special_title_default);
            } else {
                this.o.setText(dVar.f53365h);
            }
        }
        this.o.setVisibility(dVar.f53362e ? 0 : 8);
        String str = null;
        if (!ListUtils.isEmpty(dVar.i.K0())) {
            Iterator<MediaData> it = dVar.i.K0().iterator();
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
            this.p.S();
        }
        this.p.W(str, 10, false);
        if (StringUtils.isNull(dVar.i.x1())) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText(dVar.i.x1());
        }
        this.r.setText(String.format(this.f64178g.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.i.Z0())));
    }
}
