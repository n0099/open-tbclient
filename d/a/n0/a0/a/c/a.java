package d.a.n0.a0.a.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
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
public class a extends d.a.m0.g0.f.a<tinfo, d.a.m0.g0.d.b> {
    public TbImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public View p;

    /* renamed from: d.a.n0.a0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1232a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ tinfo f54804e;

        public View$OnClickListenerC1232a(tinfo tinfoVar) {
            this.f54804e = tinfoVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = this.f54804e.forum_name;
            if (k.isForumName(str)) {
                TiebaStatic.eventStat(a.this.a(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.a()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.k = (TbImageView) view.findViewById(R.id.chosen_image_text_img);
        this.l = (TextView) view.findViewById(R.id.chosen_image_text_title);
        this.p = view.findViewById(R.id.chosen_image_text_divider);
        this.m = (TextView) view.findViewById(R.id.chosen_image_text_forum);
        this.n = (TextView) view.findViewById(R.id.chosen_image_text_praise);
        this.o = (TextView) view.findViewById(R.id.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.g0.f.e
    /* renamed from: o */
    public void k(tinfo tinfoVar) {
        super.k(tinfoVar);
        if (tinfoVar == null) {
            return;
        }
        String str = null;
        List<Pic> list = tinfoVar.pics;
        if (list != null && list.size() > 0) {
            str = tinfoVar.pics.get(0).small_pic;
        }
        this.k.U(str, 10, false);
        this.l.setText(tinfoVar.title);
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            this.m.setText(UtilHelper.getFixedText(b().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.m.setOnClickListener(new View$OnClickListenerC1232a(tinfoVar));
        }
        Integer num = tinfoVar.zan_num;
        if (num != null) {
            this.n.setText(String.valueOf(num));
        }
        Integer num2 = tinfoVar.reply_num;
        if (num2 != null) {
            this.o.setText(String.valueOf(num2));
        }
        this.p.setVisibility(0);
        d.a.n0.e3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(String.valueOf(tinfoVar.forum_id))) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
        } else {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
        }
    }

    @Override // d.a.n0.e3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        d.a.m0.s0.a.a(tbPageContext, g());
        return true;
    }
}
