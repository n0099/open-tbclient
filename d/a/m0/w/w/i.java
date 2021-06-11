package d.a.m0.w.w;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
    public boolean f54599a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f54600b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54601c;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f54602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f54603f;

        public a(h hVar, EditorTools editorTools) {
            this.f54602e = hVar;
            this.f54603f = editorTools;
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            m n;
            n nVar;
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f54518a;
            if (i2 == 4) {
                Object obj = aVar.f54520c;
                if (obj instanceof j) {
                    this.f54602e.V((j) obj);
                    this.f54602e.U(((j) aVar.f54520c).f54607c);
                } else if (obj instanceof String) {
                    this.f54602e.P((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f54602e.P(obj.toString());
                    this.f54602e.U((SpanGroupManager) aVar.f54520c);
                }
                i.this.f54599a = false;
            } else if (i2 == 16) {
                if (i.this.f54599a) {
                    this.f54602e.r().showToast(R.string.over_limit_tip);
                }
                if (i.this.h(this.f54602e.r(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f54602e.r().getPageActivity(), CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, true)));
                }
            } else if (i2 == 7) {
                this.f54602e.r().showToast(R.string.over_limit_tip);
                i.this.f54599a = true;
            } else if (i2 == 8) {
                if (i.this.h(this.f54602e.r(), 11001)) {
                    this.f54602e.D();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f54520c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f54602e.Y((VoiceData$VoiceModel) obj2);
                    this.f54602e.t(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f54602e.Y(null);
                EditorTools editorTools = this.f54603f;
                if (editorTools == null || (n = editorTools.n(6)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(new d.a.m0.w.a(52, 0, null));
            }
        }
    }

    public i(boolean z) {
        this.f54601c = false;
        this.f54601c = z;
    }

    @Override // d.a.m0.w.c
    public d.a.m0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.f54601c ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        h hVar = new h(editorTools);
        hVar.v = this.f54601c;
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
        if (!this.f54601c) {
            if (d.a.n0.e3.p0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            a2.d(new d.a.m0.w.o.a(a2.getContext(), 4));
        }
        f fVar = new f(a2.getContext(), this.f54601c, false);
        if (!k.isEmpty(this.f54600b)) {
            fVar.l(this.f54600b);
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
        this.f54600b = str;
    }
}
