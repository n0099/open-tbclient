package d.b.i0.c2.k.e.w0;

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
import d.b.h0.r.s.a;
import d.b.h0.z0.l;
import d.b.i0.c3.w;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52866a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c2.h.a f52867b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f52868c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.c2.h.e f52869d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f52870e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.a.e f52871f = new e();

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f52872g = new f(this);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
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
                    b.this.f52866a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: d.b.i0.c2.k.e.w0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1157b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52874e;

        public C1157b(int i) {
            this.f52874e = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (l.a()) {
                return;
            }
            if (this.f52874e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.f52866a.getActivity()).createNormalCfg(b.this.f52869d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!b.this.f52866a.checkUpIsLogin()) {
                return;
            } else {
                if (b.this.f52868c == null) {
                    b bVar = b.this;
                    bVar.f52868c = new LikeModel(bVar.f52866a.getPageContext());
                    b.this.f52868c.setLoadDataCallBack(b.this.f52871f);
                }
                b.this.f52868c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                b.this.f52868c.H(b.this.f52869d.l().getName(), String.valueOf(b.this.f52869d.l().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(b bVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.b.b.a.e {
        public e() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (b.this.f52869d == null || b.this.f52869d.l() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(b.this.f52868c.getErrorCode(), b.this.f52868c.getErrorString())) {
                if (AntiHelper.t(b.this.f52866a.getContext(), b.this.f52868c.F(), b.this.f52872g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            b.this.f52869d.l().getName();
            String id = b.this.f52869d.l().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = false;
            boolean z2 = wVar != null && b.this.f52868c.getErrorCode() == 0;
            if (wVar == null || wVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (wVar == null || !z) {
                if (b.this.f52868c.getErrorCode() != 22) {
                    b.this.f52866a.showToast(b.this.f52868c.getErrorString());
                    return;
                } else {
                    b.this.f52866a.showToast(b.this.f52866a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            wVar.v(1);
            b.this.f52866a.showToast(b.this.f52866a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            b.this.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AntiHelper.k {
        public f(b bVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f52870e.dismiss();
            b bVar = b.this;
            bVar.n(bVar.f52867b);
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) b.this.f52866a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f52870e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    public b(PbFragment pbFragment) {
        this.f52866a = pbFragment;
        r();
        s();
    }

    public final void n(d.b.i0.c2.h.a aVar) {
        if (aVar == null) {
            return;
        }
        d.b.i0.b3.c.g().c(this.f52866a.getUniqueId(), d.b.i0.b3.a.e(this.f52869d.L(), "a005", "common_click", 1, aVar.f52407f, true, aVar.f52406e.f52408a + "", "", 19));
    }

    public final void o(d.b.i0.c2.h.a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        String w1 = this.f52869d.L().w1();
        d.b.i0.b3.c.g().d(this.f52866a.getUniqueId(), d.b.i0.b3.a.c(w1, str, "", null) + "_dialog", d.b.i0.b3.a.g(this.f52869d.L(), "a005", "common_exp", aVar.f52407f, true, aVar.f52406e.f52408a + "", "", 19));
    }

    public final void p() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
    }

    public void q() {
        LikeModel likeModel = this.f52868c;
        if (likeModel != null) {
            likeModel.E();
        }
        AlertDialog alertDialog = this.f52870e;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }

    public final void r() {
        this.f52866a.registerListener(new a(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
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
        d.b.i0.d1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void u(d.b.i0.c2.h.a aVar) {
        d.b.i0.c2.h.e eVar;
        if (aVar == null || aVar.f52406e == null || (eVar = this.f52869d) == null || eVar.L() == null) {
            return;
        }
        this.f52867b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f52869d.L().w1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f52406e.f52408a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(d.b.i0.c2.h.e eVar) {
        this.f52869d = eVar;
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        if (i2 == 502014) {
            i3 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i4 = R.string.cancel;
            string = this.f52866a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.f52866a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f52869d.l().getName());
            str = "";
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f52866a.getPageContext().getPageActivity());
        aVar.setTitle(str);
        aVar.setMessage(string);
        aVar.setPositiveButton(i3, new C1157b(i2));
        aVar.setNegativeButton(i4, new c(this));
        aVar.setOnDismissListener(new d());
        aVar.setTitleShowCenter(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f52866a.getPageContext()).show();
    }

    public final void x(d.b.i0.c2.h.b bVar) {
        d.b.i0.c2.h.a aVar;
        d.b.i0.c2.h.a aVar2 = this.f52867b;
        if (aVar2 != null) {
            aVar2.f52406e = bVar;
        }
        d.b.i0.c2.h.e eVar = this.f52869d;
        if (eVar != null && (aVar = eVar.l) != null) {
            aVar.f52406e = bVar;
        }
        o(this.f52867b);
        AlertDialog create = new AlertDialog.Builder(this.f52866a.getPageContext().getPageActivity()).create();
        this.f52870e = create;
        create.setCanceledOnTouchOutside(false);
        d.b.b.e.m.g.i(this.f52870e, this.f52866a.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f52866a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.W(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new g());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new h());
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.f52866a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f52410c}));
        textView2.setText(this.f52866a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f52413f}));
        SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
        SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
        this.f52870e.setOnDismissListener(new i());
        Window window = this.f52870e.getWindow();
        window.setWindowAnimations(R.style.normal_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }
}
