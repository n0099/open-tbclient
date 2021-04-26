package d.a.j0.d2.k.e.y0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.i0.r.s.a;
import d.a.i0.z0.l;
import d.a.j0.d3.w;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52597a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.d2.h.a f52598b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f52599c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.d2.h.e f52600d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f52601e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.e f52602f = new e();

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f52603g = new f(this);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    b.this.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    b.this.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    b.this.f52597a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: d.a.j0.d2.k.e.y0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1182b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52605e;

        public C1182b(int i2) {
            this.f52605e = i2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (l.a()) {
                return;
            }
            if (this.f52605e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.f52597a.getActivity()).createNormalCfg(b.this.f52600d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!b.this.f52597a.checkUpIsLogin()) {
                return;
            } else {
                if (b.this.f52599c == null) {
                    b bVar = b.this;
                    bVar.f52599c = new LikeModel(bVar.f52597a.getPageContext());
                    b.this.f52599c.setLoadDataCallBack(b.this.f52602f);
                }
                b.this.f52599c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                b.this.f52599c.H(b.this.f52600d.l().getName(), String.valueOf(b.this.f52600d.l().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c(b bVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends d.a.c.a.e {
        public e() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (b.this.f52600d == null || b.this.f52600d.l() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(b.this.f52599c.getErrorCode(), b.this.f52599c.getErrorString())) {
                if (AntiHelper.t(b.this.f52597a.getContext(), b.this.f52599c.F(), b.this.f52603g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            b.this.f52600d.l().getName();
            String id = b.this.f52600d.l().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = false;
            boolean z2 = wVar != null && b.this.f52599c.getErrorCode() == 0;
            if (wVar == null || wVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (wVar == null || !z) {
                if (b.this.f52599c.getErrorCode() != 22) {
                    b.this.f52597a.showToast(b.this.f52599c.getErrorString());
                    return;
                } else {
                    b.this.f52597a.showToast(b.this.f52597a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            wVar.v(1);
            b.this.f52597a.showToast(b.this.f52597a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            b.this.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AntiHelper.k {
        public f(b bVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f52601e.dismiss();
            b bVar = b.this;
            bVar.n(bVar.f52598b);
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) b.this.f52597a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f52601e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    public b(PbFragment pbFragment) {
        this.f52597a = pbFragment;
        r();
        s();
    }

    public final void n(d.a.j0.d2.h.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.j0.c3.c.g().c(this.f52597a.getUniqueId(), d.a.j0.c3.a.e(this.f52600d.L(), "a005", "common_click", 1, aVar.f52002f, true, aVar.f52001e.f52003a + "", "", 19));
    }

    public final void o(d.a.j0.d2.h.a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        String w1 = this.f52600d.L().w1();
        d.a.j0.c3.c.g().d(this.f52597a.getUniqueId(), d.a.j0.c3.a.c(w1, str, "", null) + "_dialog", d.a.j0.c3.a.g(this.f52600d.L(), "a005", "common_exp", aVar.f52002f, true, aVar.f52001e.f52003a + "", "", 19));
    }

    public final void p() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
    }

    public void q() {
        LikeModel likeModel = this.f52599c;
        if (likeModel != null) {
            likeModel.E();
        }
        AlertDialog alertDialog = this.f52601e;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }

    public final void r() {
        this.f52597a.registerListener(new a(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
    }

    public final void s() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
        tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void t(boolean z, String str) {
        d.a.j0.e1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void u(d.a.j0.d2.h.a aVar) {
        d.a.j0.d2.h.e eVar;
        if (aVar == null || aVar.f52001e == null || (eVar = this.f52600d) == null || eVar.L() == null) {
            return;
        }
        this.f52598b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f52600d.L().w1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f52001e.f52003a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(d.a.j0.d2.h.e eVar) {
        this.f52600d = eVar;
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        if (i2 == 502014) {
            i3 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i4 = R.string.cancel;
            string = this.f52597a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.f52597a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f52600d.l().getName());
            str = "";
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f52597a.getPageContext().getPageActivity());
        aVar.setTitle(str);
        aVar.setMessage(string);
        aVar.setPositiveButton(i3, new C1182b(i2));
        aVar.setNegativeButton(i4, new c(this));
        aVar.setOnDismissListener(new d());
        aVar.setTitleShowCenter(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f52597a.getPageContext()).show();
    }

    public final void x(d.a.j0.d2.h.b bVar) {
        d.a.j0.d2.h.a aVar;
        d.a.j0.d2.h.a aVar2 = this.f52598b;
        if (aVar2 != null) {
            aVar2.f52001e = bVar;
        }
        d.a.j0.d2.h.e eVar = this.f52600d;
        if (eVar != null && (aVar = eVar.l) != null) {
            aVar.f52001e = bVar;
        }
        o(this.f52598b);
        AlertDialog create = new AlertDialog.Builder(this.f52597a.getPageContext().getPageActivity()).create();
        this.f52601e = create;
        create.setCanceledOnTouchOutside(false);
        d.a.c.e.m.g.i(this.f52601e, this.f52597a.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f52597a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.V(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new g());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new h());
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.f52597a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f52005c}));
        textView2.setText(this.f52597a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f52008f}));
        SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
        SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
        this.f52601e.setOnDismissListener(new i());
        Window window = this.f52601e.getWindow();
        window.setWindowAnimations(R.style.normal_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }
}
