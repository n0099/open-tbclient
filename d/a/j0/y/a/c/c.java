package d.a.j0.y.a.c;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class c extends d.a.i0.g0.f.a<tinfo, d.a.i0.g0.d.b> {
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public RelativeLayout o;
    public TbImageView p;
    public TbImageView q;
    public TbImageView r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                d.a.i0.g0.c.b bVar = new d.a.i0.g0.c.b(4096, new d(((Integer) tag).intValue(), c.this.c()), null, null);
                bVar.i(c.this.j());
                c.this.d().dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f62692e;

        public b(tinfo tinfoVar) {
            this.f62692e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = this.f62692e.forum_name;
            if (k.isForumName(str)) {
                TiebaStatic.eventStat(c.this.a(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.a()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.s = new a();
        this.k = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.l = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.m = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.n = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.o = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.p = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.q = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.r = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.p.setOnClickListener(this.s);
        this.q.setOnClickListener(this.s);
        this.r.setOnClickListener(this.s);
    }

    @Override // d.a.j0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        d.a.i0.r.c layoutMode = e().getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(g());
        return true;
    }

    public final void p(tinfo tinfoVar) {
        List<Pic> list;
        if (tinfoVar == null) {
            return;
        }
        if (d.a.i0.r.k.c().g() && (list = tinfoVar.pics) != null && list.size() > 0) {
            this.o.setVisibility(0);
            int size = tinfoVar.pics.size();
            if (size != 1) {
                if (size != 2) {
                    if (size != 3) {
                        return;
                    }
                    String str = tinfoVar.pics.get(2).small_pic;
                    this.r.setVisibility(0);
                    this.r.V(str, 10, false);
                    this.r.setTag(2);
                }
                String str2 = tinfoVar.pics.get(1).small_pic;
                this.q.setVisibility(0);
                this.q.V(str2, 10, false);
                this.q.setTag(1);
            }
            String str3 = tinfoVar.pics.get(0).small_pic;
            this.p.setVisibility(0);
            this.p.V(str3, 10, false);
            this.p.setTag(0);
            return;
        }
        this.o.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.g0.f.e
    /* renamed from: q */
    public void k(tinfo tinfoVar) {
        super.k(tinfoVar);
        if (tinfoVar == null) {
            return;
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(UtilHelper.getFixedText(b().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.k.setOnClickListener(new b(tinfoVar));
        }
        if (StringUtils.isNull(tinfoVar.title)) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(tinfoVar.title);
        }
        if (tinfoVar.zan_num == null) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            TextView textView = this.l;
            textView.setText(tinfoVar.zan_num + "");
        }
        if (tinfoVar.reply_num == null) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            TextView textView2 = this.m;
            textView2.setText(tinfoVar.reply_num + "");
        }
        p(tinfoVar);
    }
}
