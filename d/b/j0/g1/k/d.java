package d.b.j0.g1.k;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.i0.s.c.h0;
import d.b.i0.w.m;
import d.b.i0.w.n;
import d.b.i0.w.v.d.b;
import d.b.j0.d2.k.e.u0;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56609a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f56610b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.g1.k.c f56611c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.g1.k.b f56612d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.g1.k.b f56613e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.g1.k.b f56614f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f56615g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f56616h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public int n;
    public u0 o;
    public ReplyPrivacyCheckController p;
    public boolean m = false;
    public View.OnClickListener q = new a();
    public d.b.i0.w.w.b r = new b();
    public final NewWriteModel.g s = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(d.this.j)) {
                return;
            }
            l.L(d.this.f56609a.getPageActivity(), d.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.w.w.b {
        public b() {
        }

        @Override // d.b.i0.w.w.b
        public boolean a() {
            if (d.this.k == null) {
                return false;
            }
            d dVar = d.this;
            if (dVar.o != null) {
                d.b.j0.v3.c e2 = dVar.k.isFirstPost ? d.this.o.e() : d.this.o.g();
                if (e2 != null && e2.d()) {
                    d.this.f56609a.showToast(e2.c());
                    if (d.this.f56612d != null && (d.this.f56612d.B() || d.this.f56612d.D())) {
                        d.this.f56612d.z(false, d.this.o.h());
                    }
                    if (d.this.k.isFirstPost) {
                        d.this.o.a(true);
                    } else {
                        d.this.o.b(true);
                    }
                    return true;
                }
            }
            return !d.this.p.showToastForPrivacy(d.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NewWriteModel.g {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(c cVar) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
                d.this.f56609a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(d.this.f56609a.getPageActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            String str;
            int i;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
                i = -1;
            }
            if (z) {
                d.this.k();
                if (d.this.f56609a != null && (d.this.f56609a.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) d.this.f56609a.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                d.this.f56609a.showToast(str);
                if (d.this.f56612d != null && (d.this.f56612d.B() || d.this.f56612d.D())) {
                    d.this.f56612d.z(false, postWriteCallBackData);
                    d.this.k();
                }
                if (d.this.k.isFirstPost) {
                    d.this.o.k(postWriteCallBackData);
                } else {
                    d.this.o.l(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!k.isEmpty(str)) {
                    d.this.f56609a.showToast(str);
                } else {
                    d.this.f56609a.showToast(R.string.message_privacy_fans_can_reply);
                }
                d.this.k();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(d.this.f56609a.getPageActivity(), postWriteCallBackData.getErrorString(), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(d.this.f56609a.getPageActivity(), d.this.f56609a.getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(d.this.f56609a.getPageActivity());
                if (k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(d.this.f56609a.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(d.this.f56609a).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (d.b.j0.n3.a.c(i)) {
                d.this.k();
            } else if (h0Var != null || i == 227001) {
            } else {
                d.this.t(i, str);
                d.this.k();
            }
        }
    }

    /* renamed from: d.b.j0.g1.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1329d implements View.OnTouchListener {
        public View$OnTouchListenerC1329d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return true;
            }
            d.this.k();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AntiHelper.k {
        public e(d dVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f(d dVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b.InterfaceC1145b {
        public g() {
        }

        @Override // d.b.i0.w.v.d.b.InterfaceC1145b
        public void a(boolean z) {
            if (!z) {
                d.this.f56613e.a().f13514f.o();
            } else {
                d.this.f56613e.a().f13514f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements b.InterfaceC1145b {
        public h() {
        }

        @Override // d.b.i0.w.v.d.b.InterfaceC1145b
        public void a(boolean z) {
            if (!z) {
                d.this.f56614f.a().f13514f.o();
            } else {
                d.this.f56614f.a().f13514f.setVisibility(0);
            }
        }
    }

    public d(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.f56609a = tbPageContext;
        this.f56610b = linearLayout;
        linearLayout.setOnTouchListener(new View$OnTouchListenerC1329d());
        this.f56610b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i, Intent intent) {
        n nVar;
        d.b.j0.g1.k.b bVar;
        n nVar2;
        d.b.j0.g1.k.b bVar2;
        if (i == 0 && (bVar2 = this.f56612d) != null) {
            bVar2.a().q();
        } else {
            k();
        }
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
        if (serializableExtra instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && (bVar = this.f56614f) != null) {
                    bVar.G(writeData);
                    this.f56614f.t0(pbEditorData.getVoiceModel());
                    m n = this.f56614f.a().n(6);
                    if (n != null && (nVar2 = n.k) != null) {
                        nVar2.onAction(new d.b.i0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i == -1) {
                        this.f56614f.L(null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            d.b.j0.g1.k.b bVar3 = this.f56613e;
            if (bVar3 != null) {
                bVar3.S();
                this.f56613e.t0(pbEditorData.getVoiceModel());
                this.f56613e.G(writeData);
                m n2 = this.f56613e.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new d.b.i0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.f56613e.L(null, null);
                }
            }
        }
    }

    public void k() {
        d.b.j0.g1.k.b bVar = this.f56612d;
        if (bVar != null && bVar.a() != null) {
            this.f56612d.a().o();
        }
        l.w(this.f56609a.getPageActivity(), this.f56610b);
        this.f56610b.setVisibility(8);
    }

    public void l(int i, int i2, Intent intent) {
        this.m = true;
        d.b.j0.g1.k.b bVar = this.f56612d;
        if (bVar != null) {
            if (i == 25035) {
                j(i2, intent);
                k();
                return;
            }
            bVar.H(i, i2, intent);
        }
    }

    public void m(int i) {
        d.b.j0.g1.k.b bVar = this.f56612d;
        if (bVar != null) {
            bVar.a().w(i);
        }
    }

    public void n() {
        ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        if (this.f56615g != null) {
            d.b.i0.w.v.d.b.c(this.f56609a.getPageActivity(), this.f56615g);
        }
        if (this.f56616h != null) {
            d.b.i0.w.v.d.b.c(this.f56609a.getPageActivity(), this.f56616h);
        }
    }

    public void o() {
        d.b.j0.g1.k.b bVar;
        if (this.k == null || (bVar = this.f56612d) == null) {
            return;
        }
        bVar.U(this.k.threadId + "");
    }

    public void p() {
        d.b.j0.g1.k.b bVar;
        if (this.k == null || (bVar = this.f56612d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        bVar.l();
        d.b.j0.g1.k.b bVar2 = this.f56612d;
        bVar2.s(this.k.threadId + "");
        this.f56612d.a().q();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0199 A[Catch: Exception -> 0x01a2, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a2, blocks: (B:46:0x0191, B:48:0x0199), top: B:83:0x0191 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, d.b.j0.g1.d dVar) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        d.b.i0.w.h m;
        ImageUrlData imageUrlData3;
        if (imageUrlData == null || dVar == null) {
            return;
        }
        if (this.f56611c == null) {
            d.b.j0.g1.k.c cVar = new d.b.j0.g1.k.c();
            this.f56611c = cVar;
            cVar.j(imageUrlData.forumName, imageUrlData.forumId);
        }
        if (imageUrlData.isFirstPost && this.f56613e == null) {
            d.b.j0.g1.k.c cVar2 = this.f56611c;
            cVar2.f56606d = false;
            this.f56613e = (d.b.j0.g1.k.b) cVar2.a(this.f56609a.getPageActivity());
            this.f56615g = d.b.i0.w.v.d.b.b(this.f56609a.getPageActivity(), this.f56613e.a().f13514f, new g());
        } else if (!imageUrlData.isFirstPost && this.f56614f == null) {
            d.b.j0.g1.k.c cVar3 = this.f56611c;
            cVar3.f56606d = true;
            this.f56614f = (d.b.j0.g1.k.b) cVar3.a(this.f56609a.getPageActivity());
            this.f56616h = d.b.i0.w.v.d.b.b(this.f56609a.getPageActivity(), this.f56614f.a().f13514f, new h());
        } else {
            z = false;
            d.b.j0.g1.k.b bVar = !imageUrlData.isFirstPost ? this.f56613e : this.f56614f;
            this.f56612d = bVar;
            jSONArray = null;
            if (z) {
                bVar.e0(this.f56609a);
                this.f56612d.n0(this.s);
                this.f56612d.d0(this.r);
                this.f56612d.F(this.f56609a, null);
                this.f56612d.N(dVar.P, null);
                this.f56612d.h0(dVar.O);
                this.f56612d.E();
                d.b.j0.g1.k.b bVar2 = this.f56612d;
                bVar2.Q = this.l;
                MetaData metaData = dVar.M;
                if (metaData == null) {
                    bVar2.s0(imageUrlData.threadId + "");
                } else {
                    bVar2.O(metaData, imageUrlData.threadId + "", dVar.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.f56612d.P();
                }
                this.f56612d.a().f13513e.setPadding(0, 0, 0, 0);
                this.f56612d.a().A(new d.b.i0.w.a(45, 27, null));
                this.f56612d.a().w(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    d.b.j0.g1.k.b bVar3 = this.f56612d;
                    bVar3.U(this.k.threadId + "");
                }
                this.f56612d.l();
                this.f56612d.S();
                d.b.j0.g1.k.b bVar4 = this.f56612d;
                bVar4.N = !imageUrlData.isFirstPost;
                bVar4.O = imageUrlData.postId + "";
                d.b.j0.g1.k.b bVar5 = this.f56612d;
                bVar5.P = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && bVar5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f56612d.a().A(new d.b.i0.w.a(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.S(this.f56609a.getPageActivity(), jSONArray, false).toString())));
                }
                this.i = dVar.L;
                this.j = dVar.K;
                if (this.f56612d.a() != null && !StringUtils.isNull(this.j) && (m = this.f56612d.a().m(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) m).setOnClickListener(this.q);
                }
                d.b.j0.g1.k.b bVar6 = this.f56612d;
                bVar6.s(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.f56612d.a() != null) {
                    this.f56610b.removeAllViews();
                    this.f56610b.addView(this.f56612d.a());
                }
                if (this.o == null) {
                    this.o = new u0();
                }
                if (this.f56612d.v() != null) {
                    this.o.m(this.f56612d.v().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.f56612d = bVar;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.f56612d.l();
        this.f56612d.S();
        d.b.j0.g1.k.b bVar42 = this.f56612d;
        bVar42.N = !imageUrlData.isFirstPost;
        bVar42.O = imageUrlData.postId + "";
        d.b.j0.g1.k.b bVar52 = this.f56612d;
        bVar52.P = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.f56612d.a().A(new d.b.i0.w.a(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.S(this.f56609a.getPageActivity(), jSONArray, false).toString())));
        }
        this.i = dVar.L;
        this.j = dVar.K;
        if (this.f56612d.a() != null) {
            ((View) m).setOnClickListener(this.q);
        }
        d.b.j0.g1.k.b bVar62 = this.f56612d;
        bVar62.s(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.f56612d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.f56612d.v() != null) {
        }
        this.k = imageUrlData;
    }

    public void r(String str) {
        this.l = str;
    }

    public void s(int i) {
        this.n = i;
    }

    public final void t(int i, String str) {
        if (AntiHelper.m(i, str)) {
            AntiHelper.w(this.f56609a.getPageActivity(), str, i, new e(this));
        } else if (i == 230277) {
            v(str);
        } else {
            this.f56609a.showToast(str);
        }
    }

    public void u(ImageUrlData imageUrlData, d.b.j0.g1.d dVar) {
        ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
        if (replyPrivacyCheckController == null || imageUrlData == null || dVar == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(dVar.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.f56612d == null) {
            q(imageUrlData, dVar);
        }
        d.b.j0.g1.k.b bVar = this.f56612d;
        if (bVar != null) {
            if (!bVar.B() && !this.f56612d.D()) {
                this.f56610b.setVisibility(0);
                if (this.f56612d.a() != null) {
                    this.f56612d.a().j();
                    this.f56612d.a().q();
                    return;
                }
                return;
            }
            this.f56612d.z(false, null);
        }
    }

    public final void v(String str) {
        if (str == null) {
            str = "";
        }
        TbPageContext tbPageContext = this.f56609a;
        if (tbPageContext == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new f(this));
        aVar.create(this.f56609a).show();
    }
}
