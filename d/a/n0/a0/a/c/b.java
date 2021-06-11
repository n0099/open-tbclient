package d.a.n0.a0.a.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b extends d.a.m0.g0.f.a<tinfo, d.a.m0.g0.d.b> {
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public LinearLayout p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f54806e;

        public a(tinfo tinfoVar) {
            this.f54806e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = this.f54806e.forum_name;
            if (k.isForumName(str)) {
                TiebaStatic.eventStat(b.this.a(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.a()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.k = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.l = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.m = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.n = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.o = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.p = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.g0.f.e
    /* renamed from: o */
    public void k(tinfo tinfoVar) {
        super.k(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
            this.n.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setText(UtilHelper.getFixedText(b().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.k.setOnClickListener(new a(tinfoVar));
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
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        this.o.setText(tinfoVar._abstract);
    }

    @Override // d.a.n0.e3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        d.a.m0.r.c layoutMode = e().getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(g());
        return true;
    }
}
