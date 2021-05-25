package d.a.m0.w.w;

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
import d.a.c.e.p.k;
import d.a.m0.w.m;
import d.a.m0.w.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends d.a.m0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50922a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f50923b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50924c;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f50925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f50926f;

        public a(h hVar, EditorTools editorTools) {
            this.f50925e = hVar;
            this.f50926f = editorTools;
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            m n;
            n nVar;
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f50841a;
            if (i2 == 4) {
                Object obj = aVar.f50843c;
                if (obj instanceof j) {
                    this.f50925e.V((j) obj);
                    this.f50925e.U(((j) aVar.f50843c).f50930c);
                } else if (obj instanceof String) {
                    this.f50925e.P((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f50925e.P(obj.toString());
                    this.f50925e.U((SpanGroupManager) aVar.f50843c);
                }
                i.this.f50922a = false;
            } else if (i2 == 16) {
                if (i.this.f50922a) {
                    this.f50925e.r().showToast(R.string.over_limit_tip);
                }
                if (i.this.h(this.f50925e.r(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f50925e.r().getPageActivity(), 12005, true)));
                }
            } else if (i2 == 7) {
                this.f50925e.r().showToast(R.string.over_limit_tip);
                i.this.f50922a = true;
            } else if (i2 == 8) {
                if (i.this.h(this.f50925e.r(), 11001)) {
                    this.f50925e.D();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f50843c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f50925e.Y((VoiceData$VoiceModel) obj2);
                    this.f50925e.t(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f50925e.Y(null);
                EditorTools editorTools = this.f50926f;
                if (editorTools == null || (n = editorTools.n(6)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(new d.a.m0.w.a(52, 0, null));
            }
        }
    }

    public i(boolean z) {
        this.f50924c = false;
        this.f50924c = z;
    }

    @Override // d.a.m0.w.c
    public d.a.m0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.f50924c ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        h hVar = new h(editorTools);
        hVar.v = this.f50924c;
        return hVar;
    }

    @Override // d.a.m0.w.c
    public void c(d.a.m0.w.e eVar) {
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

    @Override // d.a.m0.w.c
    public void d(d.a.m0.w.e eVar) {
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
        if (!this.f50924c) {
            if (d.a.n0.e3.p0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            a2.d(new d.a.m0.w.o.a(a2.getContext(), 4));
        }
        f fVar = new f(a2.getContext(), this.f50924c, false);
        if (!k.isEmpty(this.f50923b)) {
            fVar.l(this.f50923b);
        }
        a2.d(fVar);
        a2.f();
        a2.A(new d.a.m0.w.a(35, 5, Boolean.FALSE));
        a2.q();
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public void i(String str) {
        this.f50923b = str;
    }
}
