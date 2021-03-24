package d.b.h0.w.w;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import d.b.h0.s.c.f0;
import d.b.i0.c3.y;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends d.b.h0.w.e {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f51594f;

    /* renamed from: g  reason: collision with root package name */
    public j f51595g;

    /* renamed from: h  reason: collision with root package name */
    public String f51596h;
    public String i;
    public VoiceData$VoiceModel j;
    public NewWriteModel k;
    public SpanGroupManager l;
    public DataModel<?> m;
    public boolean n;
    public d.b.h0.w.w.c o;
    public d.b.h0.w.w.b p;
    public NewWriteModel.g q;
    public String r;
    public f s;
    public a2 t;
    public y.d u;
    public boolean v;
    public int w;
    public NewWriteModel.g x;
    public AntiHelper.k y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (h.this.q != null) {
                h.this.q.callback(z, postWriteCallBackData, f0Var, writeData, antiData);
            }
            if (z) {
                h.this.f51595g = null;
                h.this.f51596h = null;
                h.this.I(true);
                h.this.p();
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            if (z && h.this.t != null) {
                StatisticItem statisticItem = new StatisticItem("c13563");
                statisticItem.param("tid", h.this.t.o0());
                statisticItem.param("fid", h.this.t.c0());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_type", 2);
                d.b.h0.i0.c k = TbPageExtraHelper.k(h.this.f51594f.getPageActivity());
                if (k != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, k.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                WriteData T = h.this.k.T();
                h.this.k.f0(null);
                h.this.k.Z(false);
                h.this.j = null;
                if (T == null || T == null || T.getType() != 2) {
                    return;
                }
                h.this.m.u();
            } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                if (f0Var == null || writeData == null || StringUtils.isNull(f0Var.c())) {
                    if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(h.this.f51594f.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                        return;
                    } else if (i == 238010 || d.b.i0.m3.a.c(i)) {
                        return;
                    } else {
                        h.this.r().showToast(str);
                        return;
                    }
                }
                writeData.setVcodeMD5(f0Var.b());
                writeData.setVcodeUrl(f0Var.c());
                writeData.setVcodeExtra(f0Var.a());
                if (h.this.t != null) {
                    writeData.setBaijiahaoData(h.this.t.V());
                }
                if (d.b.h0.a1.a.b(f0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(h.this.r().getPageActivity(), 12006, writeData, false, f0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(h.this.r().getPageActivity(), writeData, 12006)));
                }
            } else {
                h.this.Z(i, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AntiHelper.k {
        public b(h hVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements y.d {
        public c() {
        }

        @Override // d.b.i0.c3.y.d
        public void onDraftLoaded(WriteData writeData) {
            if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                if (h.this.f51595g == null) {
                    h.this.f51595g = new j();
                }
                h.this.f51595g.f51606a = writeData.getContent();
                h.this.f51595g.f51607b = writeData.getSubPbReplyPrefix();
                h hVar = h.this;
                hVar.J(hVar.f51595g);
            }
            if (h.this.u != null) {
                h.this.u.onDraftLoaded(writeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(h.this.r)) {
                return;
            }
            l.L(h.this.r().getPageActivity(), h.this.r);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e(h hVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public h(EditorTools editorTools) {
        super(editorTools);
        this.f51596h = "";
        this.n = false;
        this.r = null;
        this.w = 0;
        this.x = new a();
        this.y = new b(this);
        this.z = new d();
    }

    public void A(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        PostWriteCallBackData postWriteCallBackData = null;
        if (i2 != -1) {
            if (i2 == 0 && i == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                NewWriteModel.g gVar = this.q;
                if (gVar != null) {
                    gVar.callback(false, postWriteCallBackData2, null, this.k.T(), null);
                }
            }
        } else if (i == 12005) {
            if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                return;
            }
            H(stringArrayListExtra);
        } else if (i != 12006) {
        } else {
            if (a() != null) {
                a().o();
            }
            p();
            I(true);
            WriteData T = this.k.T();
            this.k.f0(null);
            this.k.Z(false);
            if (T == null || T == null || T.getType() != 2) {
                return;
            }
            this.m.u();
        }
    }

    public void B() {
        G();
        this.k.cancelLoadData();
    }

    public void C() {
    }

    public void D() {
        a2 a2Var;
        if (this.k.T() == null) {
            DataModel<?> dataModel = this.m;
            WriteData t = dataModel.t(dataModel.s());
            if (t != null && (a2Var = this.t) != null) {
                t.setBaijiahaoData(a2Var.V());
            }
            this.k.f0(t);
        }
        if (this.k.T() == null) {
            return;
        }
        this.k.setSpanGroupManager(this.l);
        if (this.f51595g != null) {
            this.k.T().setContent(this.f51595g.f51606a);
            this.k.T().setSubPbReplyPrefix(this.f51595g.f51607b);
            if (this.t != null) {
                this.k.T().setBaijiahaoData(this.t.V());
            }
        }
        this.k.T().setReplyId(this.f51596h);
        if (this.i != null) {
            this.k.T().setRepostId(this.m.s());
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.j;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.k.T().setVoice(this.j.getId());
                this.k.T().setVoiceDuringTime(this.j.duration);
            } else {
                this.k.T().setVoice(null);
                this.k.T().setVoiceDuringTime(-1);
            }
        } else {
            this.k.T().setVoice(null);
            this.k.T().setVoiceDuringTime(-1);
        }
        if (!this.k.Q()) {
            r().showToast(R.string.write_img_limit);
            return;
        }
        d.b.h0.w.w.b bVar = this.p;
        if (bVar == null || !bVar.a()) {
            d.b.h0.w.w.c cVar = this.o;
            if (cVar != null) {
                cVar.a();
            }
            q(this.k.T());
            if (!this.k.i0()) {
            }
        }
    }

    public void E(AntiData antiData) {
        d.b.h0.w.h m;
        if (antiData != null) {
            String voice_message = antiData.getVoice_message();
            this.r = voice_message;
            if (StringUtils.isNull(voice_message) || a() == null || (m = a().m(6)) == null || TextUtils.isEmpty(this.r)) {
                return;
            }
            ((View) m).setOnClickListener(this.z);
        }
    }

    public void F() {
        this.k.f0(null);
        this.k.Z(false);
        this.j = null;
    }

    public void G() {
        WriteData writeData = new WriteData(2);
        j jVar = this.f51595g;
        if (jVar != null) {
            writeData.setContent(jVar.f51606a);
            writeData.setSubPbReplyPrefix(this.f51595g.f51607b);
        }
        writeData.setReplyId(this.f51596h);
        writeData.setThreadId(this.i);
        y.q(this.i, writeData);
    }

    public final void H(ArrayList<String> arrayList) {
        if (a() != null) {
            a().A(new d.b.h0.w.a(17, 27, arrayList));
        }
    }

    public final void I(boolean z) {
        if (a() != null) {
            a().A(new d.b.h0.w.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void J(j jVar) {
        if (a() != null) {
            a().A(new d.b.h0.w.a(6, 27, jVar));
        }
    }

    public void K(d.b.h0.w.w.b bVar) {
        this.p = bVar;
    }

    public void L(TbPageContext<?> tbPageContext) {
        this.f51594f = tbPageContext;
    }

    public void M(int i) {
        this.w = i;
    }

    public void N(NewWriteModel.g gVar) {
        this.q = gVar;
    }

    public void O(y.d dVar) {
        this.u = dVar;
    }

    public void P(String str) {
        if (this.f51595g == null) {
            this.f51595g = new j();
        }
        this.f51595g.f51606a = str;
    }

    public void Q(d.b.h0.w.w.c cVar) {
        this.o = cVar;
    }

    public void R(String str) {
        if (str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
        j jVar = this.f51595g;
        if (jVar != null) {
            if (TextUtils.isEmpty(jVar.f51607b) && TextUtils.isEmpty(this.f51595g.f51606a)) {
                f0(str);
                return;
            } else if (!TextUtils.isEmpty(this.f51595g.f51607b) && this.f51595g.f51607b.equals(replace)) {
                b0(this.f51595g);
                return;
            } else {
                f0(str);
                return;
            }
        }
        f0(str);
    }

    public void S(String str) {
        this.f51596h = str;
    }

    public void T(boolean z) {
        this.n = z;
    }

    public void U(SpanGroupManager spanGroupManager) {
        this.l = spanGroupManager;
    }

    public void V(j jVar) {
        this.f51595g = jVar;
    }

    public void W(DataModel<?> dataModel) {
        this.m = dataModel;
        if (dataModel != null) {
            this.i = dataModel.s();
        }
    }

    public void X(a2 a2Var) {
        this.t = a2Var;
    }

    public void Y(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.j = voiceData$VoiceModel;
    }

    public void Z(int i, String str) {
        if (AntiHelper.m(i, str)) {
            if (AntiHelper.w(this.f51594f.getPageActivity(), str, i, this.y) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        } else if (i != 230277 && i != 230278) {
            r().showToast(str);
        } else {
            d0(str);
        }
    }

    public void a0() {
        T(true);
        a().j();
        a().x((View) a().m(5));
    }

    public final void b0(j jVar) {
        T(true);
        a().j();
        J(jVar);
        TiebaStatic.eventStat(r().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void c0() {
        T(true);
        a().j();
        a().x((View) a().m(2));
    }

    public final void d0(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(r().getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new e(this));
        aVar.create(r()).show();
    }

    public void e0() {
        T(true);
        a().j();
    }

    public void f0(String str) {
        T(true);
        a().j();
        if (str != null && str.length() != 0) {
            String replace = r().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.f51607b = replace;
            J(jVar);
        } else {
            j jVar2 = new j();
            jVar2.f51606a = "";
            J(jVar2);
        }
        TiebaStatic.eventStat(r().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void o(String str) {
        if (StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().A(new d.b.h0.w.a(45, 27, str));
    }

    public void p() {
        y.q(this.i, null);
    }

    public void q(WriteData writeData) {
        if (writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.w > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.w);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.w <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.w);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public TbPageContext<?> r() {
        return this.f51594f;
    }

    public f s() {
        if (this.s == null && a() != null) {
            this.s = (f) a().n(27);
        }
        return this.s;
    }

    public void t(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        j jVar = this.f51595g;
        if (jVar != null) {
            pbEditorData.setContent(jVar.f51606a);
            pbEditorData.setSubPbReplyPrefix(this.f51595g.f51607b);
        }
        pbEditorData.setVoiceModel(this.j);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.r);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.f51594f.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public boolean u() {
        j jVar = this.f51595g;
        return (jVar == null || k.isEmpty(jVar.f51606a)) ? false : true;
    }

    public boolean v() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.j;
        return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.j.duration <= 0) ? false : true;
    }

    public void w() {
        T(false);
        a().o();
    }

    public void x(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.k = newWriteModel;
        newWriteModel.d0(this.x);
        y.j(this.m.s(), new c());
    }

    public boolean y() {
        return this.n;
    }

    public void z(WriteData writeData) {
        if (writeData == null) {
            return;
        }
        if (this.f51595g == null) {
            this.f51595g = new j();
        }
        this.f51595g.f51606a = writeData.getContent();
        this.f51595g.f51607b = writeData.getSubPbReplyPrefix();
        J(this.f51595g);
    }
}
