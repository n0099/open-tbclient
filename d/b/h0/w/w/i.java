package d.b.h0.w.w;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.h0.w.m;
import d.b.h0.w.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends d.b.h0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52019a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f52020b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52021c;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f52022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f52023f;

        public a(h hVar, EditorTools editorTools) {
            this.f52022e = hVar;
            this.f52023f = editorTools;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            m n;
            n nVar;
            if (aVar == null) {
                return;
            }
            int i = aVar.f51942a;
            if (i == 4) {
                Object obj = aVar.f51944c;
                if (obj instanceof j) {
                    this.f52022e.V((j) obj);
                    this.f52022e.U(((j) aVar.f51944c).f52027c);
                } else if (obj instanceof String) {
                    this.f52022e.P((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f52022e.P(obj.toString());
                    this.f52022e.U((SpanGroupManager) aVar.f51944c);
                }
                i.this.f52019a = false;
            } else if (i == 16) {
                if (i.this.f52019a) {
                    this.f52022e.r().showToast(R.string.over_limit_tip);
                }
                if (i.this.h(this.f52022e.r(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f52022e.r().getPageActivity(), 12005, true)));
                }
            } else if (i == 7) {
                this.f52022e.r().showToast(R.string.over_limit_tip);
                i.this.f52019a = true;
            } else if (i == 8) {
                if (i.this.h(this.f52022e.r(), 11001)) {
                    this.f52022e.D();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i == 10) {
                Object obj2 = aVar.f51944c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f52022e.Y((VoiceData$VoiceModel) obj2);
                    this.f52022e.t(null);
                }
            } else if (i != 11) {
            } else {
                this.f52022e.Y(null);
                EditorTools editorTools = this.f52023f;
                if (editorTools == null || (n = editorTools.n(6)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(new d.b.h0.w.a(52, 0, null));
            }
        }
    }

    public i(boolean z) {
        this.f52021c = false;
        this.f52021c = z;
    }

    @Override // d.b.h0.w.c
    public d.b.h0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.f52021c ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        h hVar = new h(editorTools);
        hVar.v = this.f52021c;
        return hVar;
    }

    @Override // d.b.h0.w.c
    public void c(d.b.h0.w.e eVar) {
        if (eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        a aVar = new a((h) eVar, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
    }

    @Override // d.b.h0.w.c
    public void d(d.b.h0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(false);
            n.j = 1;
        }
        if (!this.f52021c) {
            if (d.b.i0.d3.p0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            a2.d(new d.b.h0.w.o.a(a2.getContext(), 4));
        }
        f fVar = new f(a2.getContext(), this.f52021c, false);
        if (!k.isEmpty(this.f52020b)) {
            fVar.l(this.f52020b);
        }
        a2.d(fVar);
        a2.f();
        a2.A(new d.b.h0.w.a(35, 5, Boolean.FALSE));
        a2.q();
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void i(String str) {
        this.f52020b = str;
    }
}
