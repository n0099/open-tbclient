package d.b.i0.f1.k;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import d.b.h0.s.c.f0;
import d.b.h0.w.m;
import d.b.h0.w.n;
import d.b.h0.w.v.d.b;
import d.b.i0.c2.k.e.s0;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54718a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f54719b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.f1.k.b f54720c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f1.k.a f54721d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.f1.k.a f54722e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.f1.k.a f54723f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f54724g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f54725h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public int n;
    public s0 o;
    public ReplyPrivacyCheckController p;
    public boolean m = false;
    public View.OnClickListener q = new a();
    public d.b.h0.w.w.b r = new b();
    public final NewWriteModel.g s = new C1249c();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.j)) {
                return;
            }
            l.L(c.this.f54718a.getPageActivity(), c.this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.w.w.b {
        public b() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            if (c.this.k == null) {
                return false;
            }
            c cVar = c.this;
            if (cVar.o != null) {
                d.b.i0.u3.c e2 = cVar.k.isFirstPost ? c.this.o.e() : c.this.o.g();
                if (e2 != null && e2.d()) {
                    c.this.f54718a.showToast(e2.c());
                    if (c.this.f54721d != null && (c.this.f54721d.B() || c.this.f54721d.D())) {
                        c.this.f54721d.z(false, c.this.o.h());
                    }
                    if (c.this.k.isFirstPost) {
                        c.this.o.a(true);
                    } else {
                        c.this.o.b(true);
                    }
                    return true;
                }
            }
            return !c.this.p.showToastForPrivacy(c.this.i);
        }
    }

    /* renamed from: d.b.i0.f1.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1249c implements NewWriteModel.g {

        /* renamed from: d.b.i0.f1.k.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements a.e {
            public a(C1249c c1249c) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* renamed from: d.b.i0.f1.k.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                c.this.f54718a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(c.this.f54718a.getPageActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public C1249c() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
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
                c.this.k();
                if (c.this.f54718a != null && (c.this.f54718a.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.f54718a.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.f54718a.showToast(str);
                if (c.this.f54721d != null && (c.this.f54721d.B() || c.this.f54721d.D())) {
                    c.this.f54721d.z(false, postWriteCallBackData);
                    c.this.k();
                }
                if (c.this.k.isFirstPost) {
                    c.this.o.k(postWriteCallBackData);
                } else {
                    c.this.o.l(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!k.isEmpty(str)) {
                    c.this.f54718a.showToast(str);
                } else {
                    c.this.f54718a.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.k();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(c.this.f54718a.getPageActivity(), postWriteCallBackData.getErrorString(), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(c.this.f54718a.getPageActivity(), c.this.f54718a.getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(c.this.f54718a.getPageActivity());
                if (k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(c.this.f54718a.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(c.this.f54718a).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            } else if (d.b.i0.m3.a.c(i)) {
                c.this.k();
            } else if (f0Var != null || i == 227001) {
            } else {
                c.this.t(i, str);
                c.this.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return true;
            }
            c.this.k();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AntiHelper.k {
        public e(c cVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public f(c cVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements b.InterfaceC1110b {
        public g() {
        }

        @Override // d.b.h0.w.v.d.b.InterfaceC1110b
        public void a(boolean z) {
            if (!z) {
                c.this.f54722e.a().f13845f.o();
            } else {
                c.this.f54722e.a().f13845f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements b.InterfaceC1110b {
        public h() {
        }

        @Override // d.b.h0.w.v.d.b.InterfaceC1110b
        public void a(boolean z) {
            if (!z) {
                c.this.f54723f.a().f13845f.o();
            } else {
                c.this.f54723f.a().f13845f.setVisibility(0);
            }
        }
    }

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.f54718a = tbPageContext;
        this.f54719b = linearLayout;
        linearLayout.setOnTouchListener(new d());
        this.f54719b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i, Intent intent) {
        n nVar;
        d.b.i0.f1.k.a aVar;
        n nVar2;
        d.b.i0.f1.k.a aVar2;
        if (i == 0 && (aVar2 = this.f54721d) != null) {
            aVar2.a().q();
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
                if (editorType == 1 && (aVar = this.f54723f) != null) {
                    aVar.G(writeData);
                    this.f54723f.t0(pbEditorData.getVoiceModel());
                    m n = this.f54723f.a().n(6);
                    if (n != null && (nVar2 = n.k) != null) {
                        nVar2.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i == -1) {
                        this.f54723f.L(null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            d.b.i0.f1.k.a aVar3 = this.f54722e;
            if (aVar3 != null) {
                aVar3.S();
                this.f54722e.t0(pbEditorData.getVoiceModel());
                this.f54722e.G(writeData);
                m n2 = this.f54722e.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.f54722e.L(null, null);
                }
            }
        }
    }

    public void k() {
        d.b.i0.f1.k.a aVar = this.f54721d;
        if (aVar != null && aVar.a() != null) {
            this.f54721d.a().o();
        }
        l.w(this.f54718a.getPageActivity(), this.f54719b);
        this.f54719b.setVisibility(8);
    }

    public void l(int i, int i2, Intent intent) {
        this.m = true;
        d.b.i0.f1.k.a aVar = this.f54721d;
        if (aVar != null) {
            if (i == 25035) {
                j(i2, intent);
                k();
                return;
            }
            aVar.H(i, i2, intent);
        }
    }

    public void m(int i) {
        d.b.i0.f1.k.a aVar = this.f54721d;
        if (aVar != null) {
            aVar.a().w(i);
        }
    }

    public void n() {
        ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        if (this.f54724g != null) {
            d.b.h0.w.v.d.b.c(this.f54718a.getPageActivity(), this.f54724g);
        }
        if (this.f54725h != null) {
            d.b.h0.w.v.d.b.c(this.f54718a.getPageActivity(), this.f54725h);
        }
    }

    public void o() {
        d.b.i0.f1.k.a aVar;
        if (this.k == null || (aVar = this.f54721d) == null) {
            return;
        }
        aVar.U(this.k.threadId + "");
    }

    public void p() {
        d.b.i0.f1.k.a aVar;
        if (this.k == null || (aVar = this.f54721d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        aVar.l();
        d.b.i0.f1.k.a aVar2 = this.f54721d;
        aVar2.s(this.k.threadId + "");
        this.f54721d.a().q();
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
    public void q(ImageUrlData imageUrlData, d.b.i0.f1.d dVar) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        d.b.h0.w.h m;
        ImageUrlData imageUrlData3;
        if (imageUrlData == null || dVar == null) {
            return;
        }
        if (this.f54720c == null) {
            d.b.i0.f1.k.b bVar = new d.b.i0.f1.k.b();
            this.f54720c = bVar;
            bVar.j(imageUrlData.forumName, imageUrlData.forumId);
        }
        if (imageUrlData.isFirstPost && this.f54722e == null) {
            d.b.i0.f1.k.b bVar2 = this.f54720c;
            bVar2.f54715d = false;
            this.f54722e = (d.b.i0.f1.k.a) bVar2.a(this.f54718a.getPageActivity());
            this.f54724g = d.b.h0.w.v.d.b.b(this.f54718a.getPageActivity(), this.f54722e.a().f13845f, new g());
        } else if (!imageUrlData.isFirstPost && this.f54723f == null) {
            d.b.i0.f1.k.b bVar3 = this.f54720c;
            bVar3.f54715d = true;
            this.f54723f = (d.b.i0.f1.k.a) bVar3.a(this.f54718a.getPageActivity());
            this.f54725h = d.b.h0.w.v.d.b.b(this.f54718a.getPageActivity(), this.f54723f.a().f13845f, new h());
        } else {
            z = false;
            d.b.i0.f1.k.a aVar = !imageUrlData.isFirstPost ? this.f54722e : this.f54723f;
            this.f54721d = aVar;
            jSONArray = null;
            if (z) {
                aVar.e0(this.f54718a);
                this.f54721d.n0(this.s);
                this.f54721d.d0(this.r);
                this.f54721d.F(this.f54718a, null);
                this.f54721d.N(dVar.P, null);
                this.f54721d.h0(dVar.O);
                this.f54721d.E();
                d.b.i0.f1.k.a aVar2 = this.f54721d;
                aVar2.Q = this.l;
                MetaData metaData = dVar.M;
                if (metaData == null) {
                    aVar2.s0(imageUrlData.threadId + "");
                } else {
                    aVar2.O(metaData, imageUrlData.threadId + "", dVar.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.f54721d.P();
                }
                this.f54721d.a().f13844e.setPadding(0, 0, 0, 0);
                this.f54721d.a().A(new d.b.h0.w.a(45, 27, null));
                this.f54721d.a().w(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    d.b.i0.f1.k.a aVar3 = this.f54721d;
                    aVar3.U(this.k.threadId + "");
                }
                this.f54721d.l();
                this.f54721d.S();
                d.b.i0.f1.k.a aVar4 = this.f54721d;
                aVar4.N = !imageUrlData.isFirstPost;
                aVar4.O = imageUrlData.postId + "";
                d.b.i0.f1.k.a aVar5 = this.f54721d;
                aVar5.P = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && aVar5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f54721d.a().A(new d.b.h0.w.a(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.Q(this.f54718a.getPageActivity(), jSONArray, false).toString())));
                }
                this.i = dVar.L;
                this.j = dVar.K;
                if (this.f54721d.a() != null && !StringUtils.isNull(this.j) && (m = this.f54721d.a().m(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) m).setOnClickListener(this.q);
                }
                d.b.i0.f1.k.a aVar6 = this.f54721d;
                aVar6.s(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.f54721d.a() != null) {
                    this.f54719b.removeAllViews();
                    this.f54719b.addView(this.f54721d.a());
                }
                if (this.o == null) {
                    this.o = new s0();
                }
                if (this.f54721d.v() != null) {
                    this.o.m(this.f54721d.v().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.f54721d = aVar;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.f54721d.l();
        this.f54721d.S();
        d.b.i0.f1.k.a aVar42 = this.f54721d;
        aVar42.N = !imageUrlData.isFirstPost;
        aVar42.O = imageUrlData.postId + "";
        d.b.i0.f1.k.a aVar52 = this.f54721d;
        aVar52.P = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.f54721d.a().A(new d.b.h0.w.a(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.Q(this.f54718a.getPageActivity(), jSONArray, false).toString())));
        }
        this.i = dVar.L;
        this.j = dVar.K;
        if (this.f54721d.a() != null) {
            ((View) m).setOnClickListener(this.q);
        }
        d.b.i0.f1.k.a aVar62 = this.f54721d;
        aVar62.s(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.f54721d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.f54721d.v() != null) {
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
            AntiHelper.w(this.f54718a.getPageActivity(), str, i, new e(this));
        } else if (i == 230277) {
            v(str);
        } else {
            this.f54718a.showToast(str);
        }
    }

    public void u(ImageUrlData imageUrlData, d.b.i0.f1.d dVar) {
        ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
        if (replyPrivacyCheckController == null || imageUrlData == null || dVar == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(dVar.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.f54721d == null) {
            q(imageUrlData, dVar);
        }
        d.b.i0.f1.k.a aVar = this.f54721d;
        if (aVar != null) {
            if (!aVar.B() && !this.f54721d.D()) {
                this.f54719b.setVisibility(0);
                if (this.f54721d.a() != null) {
                    this.f54721d.a().j();
                    this.f54721d.a().q();
                    return;
                }
                return;
            }
            this.f54721d.z(false, null);
        }
    }

    public final void v(String str) {
        if (str == null) {
            str = "";
        }
        TbPageContext tbPageContext = this.f54718a;
        if (tbPageContext == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new f(this));
        aVar.create(this.f54718a).show();
    }
}
