package d.b.i0.r3.b;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import d.b.h0.r.s.a;
import d.b.h0.s.c.f0;
import d.b.h0.w.e;
import d.b.i0.c3.q0.g;
/* loaded from: classes5.dex */
public class a extends e {

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel f60006f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.u3.c f60007g;

    /* renamed from: h  reason: collision with root package name */
    public String f60008h;
    public TbPageContext<?> i;
    public String j;
    public String k;
    public String l;
    public VideoItemData m;
    public d n;
    public final NewWriteModel.g o;
    public TextWatcher p;

    /* renamed from: d.b.i0.r3.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1516a implements NewWriteModel.g {
        public C1516a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            if (a.this.f60006f == null) {
                return;
            }
            if (a.this.a() != null) {
                a.this.a().o();
            }
            if (a.this.n != null) {
                a.this.n.a(false);
            }
            if (writeData == null) {
                writeData = a.this.f60006f.T();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                a.this.f60007g.n(null);
                a.this.f60007g.i(null);
                a.this.f60007g.k(false);
                a.this.r();
                a.this.q();
                if (writeData2 != null) {
                    String string = a.this.m().getResources().getString(R.string.replay_success);
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        String colorMsg = postWriteCallBackData.getColorMsg();
                        String errorString = postWriteCallBackData.getErrorString();
                        str = colorMsg;
                        string = errorString;
                    } else {
                        str = null;
                    }
                    if (writeData2.getType() != 7) {
                        g.b(a.this.m().getPageActivity(), string, str2, str);
                    }
                }
            } else if (writeData2 != null && f0Var != null && !TextUtils.isEmpty(f0Var.d())) {
                writeData2.setVcodeMD5(f0Var.b());
                writeData2.setVcodeUrl(f0Var.c());
                writeData2.setVcodeExtra(f0Var.a());
                if (d.b.h0.a1.a.b(f0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.i.getPageActivity(), 12006, writeData2, false, f0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.i.getPageActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.i.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                a.this.A(postWriteCallBackData.getErrorString());
                a.this.f60007g.i(postWriteCallBackData.getSensitiveWords());
                a.this.f60007g.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(a.this.f60007g.a())) {
                    return;
                }
                a.this.k(true);
            } else if (postWriteCallBackData == null || !d.b.i0.m3.a.c(postWriteCallBackData.getErrorCode())) {
                if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    a.this.x(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData != null) {
                    a.this.A(postWriteCallBackData.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b(a aVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f60007g == null) {
                return;
            }
            if (!a.this.f60007g.e()) {
                a.this.k(false);
            }
            a.this.f60007g.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.f60008h = "";
        this.j = null;
        this.o = new C1516a();
        this.p = new c();
        editorTools.C(true);
        d.b.i0.u3.c cVar = new d.b.i0.u3.c();
        this.f60007g = cVar;
        cVar.h(R.color.cp_cont_h_alpha85);
        this.f60007g.j(R.color.CAM_X0101);
    }

    public final void A(String str) {
        if (this.i == null || StringUtils.isNull(str)) {
            return;
        }
        this.i.showToast(str);
    }

    public final void k(boolean z) {
        if (a() == null || !(a().n(28) instanceof d.b.i0.r3.b.c) || ((d.b.i0.r3.b.c) a().n(28)).g() == null || ((d.b.i0.r3.b.c) a().n(28)).g().getText() == null) {
            return;
        }
        EditText g2 = ((d.b.i0.r3.b.c) a().n(28)).g();
        int selectionEnd = g2.getSelectionEnd();
        SpannableStringBuilder f2 = this.f60007g.f(g2.getText());
        if (f2 != null) {
            this.f60007g.l(true);
            g2.setText(f2);
            if (z && this.f60007g.b() >= 0) {
                g2.requestFocus();
                g2.setSelection(this.f60007g.b());
            } else {
                g2.setSelection(selectionEnd);
            }
            d.b.i0.u3.c cVar = this.f60007g;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void l() {
        if (a() == null || !(a().n(28) instanceof d.b.i0.r3.b.c) || ((d.b.i0.r3.b.c) a().n(28)).g() == null || ((d.b.i0.r3.b.c) a().n(28)).g().getText() == null) {
            return;
        }
        ((d.b.i0.r3.b.c) a().n(28)).g().setText("");
    }

    public TbPageContext<?> m() {
        return this.i;
    }

    public void n(int i, int i2, Intent intent) {
        if (i != 12006) {
            return;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                r();
                return;
            }
            return;
        }
        PostWriteCallBackData postWriteCallBackData = null;
        if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        }
        this.o.callback(false, postWriteCallBackData, null, this.f60006f.T(), null);
    }

    public void o() {
        NewWriteModel newWriteModel = this.f60006f;
        if (newWriteModel != null) {
            newWriteModel.cancelLoadData();
        }
    }

    public void p() {
        if (this.f60006f == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this.i);
            this.f60006f = newWriteModel;
            newWriteModel.d0(this.o);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.j);
        writeData.setForumId(this.k);
        writeData.setForumName(this.l);
        writeData.setContent(this.f60008h);
        VideoItemData videoItemData = this.m;
        if (videoItemData != null && videoItemData.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.m.baijiahaoData);
        }
        this.f60006f.f0(writeData);
        this.f60006f.i0();
    }

    public final void q() {
        NewWriteModel newWriteModel = this.f60006f;
        if (newWriteModel == null) {
            return;
        }
        newWriteModel.f0(null);
        this.f60006f.Z(false);
    }

    public final void r() {
        if (a() != null) {
            a().A(new d.b.h0.w.a(9, -1, Boolean.TRUE));
            a().A(new d.b.h0.w.a(4, -1, ""));
            a().o();
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.a(true);
        }
    }

    public void s(TbPageContext<?> tbPageContext) {
        this.i = tbPageContext;
    }

    public void t(String str, String str2, String str3) {
        this.j = str;
        this.k = str2;
        this.l = str3;
        if (a() == null || !(a().n(28) instanceof d.b.i0.r3.b.c) || ((d.b.i0.r3.b.c) a().n(28)).g() == null) {
            return;
        }
        EditText g2 = ((d.b.i0.r3.b.c) a().n(28)).g();
        g2.removeTextChangedListener(this.p);
        g2.addTextChangedListener(this.p);
    }

    public void u(d dVar) {
        this.n = dVar;
    }

    public void v(String str) {
        this.f60008h = str;
    }

    public void w(VideoItemData videoItemData) {
        this.m = videoItemData;
    }

    public final void x(int i, String str) {
        if (AntiHelper.m(i, str)) {
            AntiHelper.w(this.i.getPageActivity(), str, i, null);
        } else if (i != 230277 && i != 230278) {
            A(str);
        } else {
            y(str);
        }
    }

    public final void y(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(m().getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new b(this));
        aVar.create(m()).show();
    }

    public void z() {
        StatisticItem statisticItem = new StatisticItem("c13026");
        statisticItem.param("tid", this.j);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", this.k);
        TiebaStatic.log(statisticItem);
    }
}
