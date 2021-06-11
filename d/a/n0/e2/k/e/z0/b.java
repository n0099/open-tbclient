package d.a.n0.e2.k.e.z0;

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
import d.a.m0.r.s.a;
import d.a.m0.z0.l;
import d.a.n0.e3.w;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57245a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.h.a f57246b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f57247c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.e2.h.e f57248d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f57249e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.e f57250f = new e();

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f57251g = new f(this);

    /* loaded from: classes5.dex */
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
                    b.this.f57245a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: d.a.n0.e2.k.e.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1329b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57253e;

        public C1329b(int i2) {
            this.f57253e = i2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (l.a()) {
                return;
            }
            if (this.f57253e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(b.this.f57245a.getActivity()).createNormalCfg(b.this.f57248d.l().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!b.this.f57245a.checkUpIsLogin()) {
                return;
            } else {
                if (b.this.f57247c == null) {
                    b bVar = b.this;
                    bVar.f57247c = new LikeModel(bVar.f57245a.getPageContext());
                    b.this.f57247c.setLoadDataCallBack(b.this.f57250f);
                }
                b.this.f57247c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                b.this.f57247c.L(b.this.f57248d.l().getName(), String.valueOf(b.this.f57248d.l().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(b bVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends d.a.c.a.e {
        public e() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (b.this.f57248d == null || b.this.f57248d.l() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(b.this.f57247c.getErrorCode(), b.this.f57247c.getErrorString())) {
                if (AntiHelper.t(b.this.f57245a.getContext(), b.this.f57247c.J(), b.this.f57251g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            b.this.f57248d.l().getName();
            String id = b.this.f57248d.l().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = false;
            boolean z2 = wVar != null && b.this.f57247c.getErrorCode() == 0;
            if (wVar == null || wVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (wVar == null || !z) {
                if (b.this.f57247c.getErrorCode() != 22) {
                    b.this.f57245a.showToast(b.this.f57247c.getErrorString());
                    return;
                } else {
                    b.this.f57245a.showToast(b.this.f57245a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            wVar.v(1);
            b.this.f57245a.showToast(b.this.f57245a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            b.this.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements AntiHelper.k {
        public f(b bVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57249e.dismiss();
            b bVar = b.this;
            bVar.n(bVar.f57246b);
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) b.this.f57245a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57249e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.p();
        }
    }

    public b(PbFragment pbFragment) {
        this.f57245a = pbFragment;
        r();
        s();
    }

    public final void n(d.a.n0.e2.h.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.n0.d3.c.g().c(this.f57245a.getUniqueId(), d.a.n0.d3.a.e(this.f57248d.L(), "a005", "common_click", 1, aVar.f56595f, true, aVar.f56594e.f56596a + "", "", 19));
    }

    public final void o(d.a.n0.e2.h.a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        String z1 = this.f57248d.L().z1();
        d.a.n0.d3.c.g().d(this.f57245a.getUniqueId(), d.a.n0.d3.a.c(z1, str, "", null) + "_dialog", d.a.n0.d3.a.g(this.f57248d.L(), "a005", "common_exp", aVar.f56595f, true, aVar.f56594e.f56596a + "", "", 19));
    }

    public final void p() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
    }

    public void q() {
        LikeModel likeModel = this.f57247c;
        if (likeModel != null) {
            likeModel.I();
        }
        AlertDialog alertDialog = this.f57249e;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
    }

    public final void r() {
        this.f57245a.registerListener(new a(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
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
        d.a.n0.f1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void u(d.a.n0.e2.h.a aVar) {
        d.a.n0.e2.h.e eVar;
        if (aVar == null || aVar.f56594e == null || (eVar = this.f57248d) == null || eVar.L() == null) {
            return;
        }
        this.f57246b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f57248d.L().z1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f56594e.f56596a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(d.a.n0.e2.h.e eVar) {
        this.f57248d = eVar;
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        if (i2 == 502014) {
            i3 = R.string.pb_ad_card_gift_fail_guide_update_level;
            i4 = R.string.cancel;
            string = this.f57245a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
        } else {
            i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
            i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
            string = this.f57245a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f57248d.l().getName());
            str = "";
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f57245a.getPageContext().getPageActivity());
        aVar.setTitle(str);
        aVar.setMessage(string);
        aVar.setPositiveButton(i3, new C1329b(i2));
        aVar.setNegativeButton(i4, new c(this));
        aVar.setOnDismissListener(new d());
        aVar.setTitleShowCenter(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(this.f57245a.getPageContext()).show();
    }

    public final void x(d.a.n0.e2.h.b bVar) {
        d.a.n0.e2.h.a aVar;
        d.a.n0.e2.h.a aVar2 = this.f57246b;
        if (aVar2 != null) {
            aVar2.f56594e = bVar;
        }
        d.a.n0.e2.h.e eVar = this.f57248d;
        if (eVar != null && (aVar = eVar.l) != null) {
            aVar.f56594e = bVar;
        }
        o(this.f57246b);
        AlertDialog create = new AlertDialog.Builder(this.f57245a.getPageContext().getPageActivity()).create();
        this.f57249e = create;
        create.setCanceledOnTouchOutside(false);
        d.a.c.e.m.g.i(this.f57249e, this.f57245a.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.f57245a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
        tbImageView.setRadius(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setDrawCorner(true);
        tbImageView.U(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
        textView.setOnClickListener(new g());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
        imageView.setOnClickListener(new h());
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
        textView3.setText(this.f57245a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f56598c}));
        textView2.setText(this.f57245a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f56601f}));
        SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
        SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
        this.f57249e.setOnDismissListener(new i());
        Window window = this.f57249e.getWindow();
        window.setWindowAnimations(R.style.normal_dialog_style);
        window.setGravity(17);
        window.setLayout(-2, -2);
        window.setContentView(inflate);
    }
}
