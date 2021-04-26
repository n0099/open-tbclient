package d.a.i0.w.w;

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
import d.a.i0.w.m;
import d.a.i0.w.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i extends d.a.i0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50030a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f50031b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50032c;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f50033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f50034f;

        public a(h hVar, EditorTools editorTools) {
            this.f50033e = hVar;
            this.f50034f = editorTools;
        }

        @Override // d.a.i0.w.b
        public void onAction(d.a.i0.w.a aVar) {
            m n;
            n nVar;
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f49949a;
            if (i2 == 4) {
                Object obj = aVar.f49951c;
                if (obj instanceof j) {
                    this.f50033e.V((j) obj);
                    this.f50033e.U(((j) aVar.f49951c).f50038c);
                } else if (obj instanceof String) {
                    this.f50033e.P((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f50033e.P(obj.toString());
                    this.f50033e.U((SpanGroupManager) aVar.f49951c);
                }
                i.this.f50030a = false;
            } else if (i2 == 16) {
                if (i.this.f50030a) {
                    this.f50033e.r().showToast(R.string.over_limit_tip);
                }
                if (i.this.h(this.f50033e.r(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f50033e.r().getPageActivity(), 12005, true)));
                }
            } else if (i2 == 7) {
                this.f50033e.r().showToast(R.string.over_limit_tip);
                i.this.f50030a = true;
            } else if (i2 == 8) {
                if (i.this.h(this.f50033e.r(), 11001)) {
                    this.f50033e.D();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f49951c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f50033e.Y((VoiceData$VoiceModel) obj2);
                    this.f50033e.t(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f50033e.Y(null);
                EditorTools editorTools = this.f50034f;
                if (editorTools == null || (n = editorTools.n(6)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(new d.a.i0.w.a(52, 0, null));
            }
        }
    }

    public i(boolean z) {
        this.f50032c = false;
        this.f50032c = z;
    }

    @Override // d.a.i0.w.c
    public d.a.i0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.f50032c ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        h hVar = new h(editorTools);
        hVar.v = this.f50032c;
        return hVar;
    }

    @Override // d.a.i0.w.c
    public void c(d.a.i0.w.e eVar) {
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

    @Override // d.a.i0.w.c
    public void d(d.a.i0.w.e eVar) {
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
        if (!this.f50032c) {
            if (d.a.j0.d3.p0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            a2.d(new d.a.i0.w.o.a(a2.getContext(), 4));
        }
        f fVar = new f(a2.getContext(), this.f50032c, false);
        if (!k.isEmpty(this.f50031b)) {
            fVar.l(this.f50031b);
        }
        a2.d(fVar);
        a2.f();
        a2.A(new d.a.i0.w.a(35, 5, Boolean.FALSE));
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
        this.f50031b = str;
    }
}
