package d.a.j0.d2.k.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class w extends d.a.i0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public PbEditorData.ThreadData f52572a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.w.b f52573b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52574c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52575d = false;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f52576e;

        public a(v vVar) {
            this.f52576e = vVar;
        }

        @Override // d.a.i0.w.b
        public void onAction(d.a.i0.w.a aVar) {
            v vVar = this.f52576e;
            if (vVar == null || vVar.a() == null || aVar == null) {
                return;
            }
            if (w.this.f52573b != null) {
                w.this.f52573b.onAction(aVar);
            }
            int i2 = aVar.f49949a;
            if (i2 == 16) {
                if (w.this.h(this.f52576e.f().getPageContext(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f52576e.f().getActivity(), 12004, true)));
                }
            } else if (i2 == 18) {
                if (aVar.f49951c != null) {
                    this.f52576e.m();
                    return;
                }
                int g2 = this.f52576e.g();
                if (g2 == 0) {
                    this.f52576e.l();
                } else if (g2 != 2) {
                } else {
                    this.f52576e.i();
                }
            } else if (i2 == 20) {
                d.a.j0.d3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f52576e.a().A(new d.a.i0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (w.this.h(this.f52576e.f().getPageContext(), 11040)) {
                    this.f52576e.n();
                }
            } else if (i2 == 43 && !d.a.i0.p0.b.c(this.f52576e.f().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f52576e.f().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (w.this.f52572a != null) {
                    hotSelectActivityConfig.setForumExtra(d.a.c.e.m.b.f(w.this.f52572a.getForumId(), 0L), w.this.f52572a.getFirstDir(), w.this.f52572a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    @Override // d.a.i0.w.c
    public d.a.i0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.f52574c) {
            editorTools.setBarLauncherType(2);
        } else if (this.f52575d) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.C(true);
        return new v(editorTools);
    }

    @Override // d.a.i0.w.c
    public void c(d.a.i0.w.e eVar) {
        if (eVar instanceof v) {
            EditorTools a2 = eVar.a();
            a aVar = new a((v) eVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(24, aVar);
            a2.setActionListener(3, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // d.a.i0.w.c
    public void d(d.a.i0.w.e eVar) {
        CustomResponsedMessage runTask;
        d.a.i0.w.m mVar;
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.f52574c) {
            arrayList.add(10);
            a2.d(new d.a.i0.w.r.d(a2.getContext(), 1));
        }
        if (!this.f52575d) {
            arrayList.add(6);
            arrayList.add(9);
            PbEditorData.ThreadData threadData = this.f52572a;
            String forumName = threadData != null ? threadData.getForumName() : "";
            if (d.a.j0.d3.p0.c.a() && d.a.j0.d3.u.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), d.a.i0.w.m.class)) != null && (mVar = (d.a.i0.w.m) runTask.getData()) != null) {
                mVar.j = 2;
                a2.d(mVar);
            }
            a2.d(new d.a.i0.w.o.a(a2.getContext(), 4));
            if (!this.f52574c) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), d.a.i0.w.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    d.a.i0.w.m mVar2 = (d.a.i0.w.m) runTask2.getData();
                    mVar2.j = 6;
                    a2.d(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), d.a.i0.w.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    d.a.i0.w.m mVar3 = (d.a.i0.w.m) runTask3.getData();
                    mVar3.j = 7;
                    a2.d(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f52574c) {
                a2.d(new d.a.i0.w.q.a(a2.getContext(), 5));
            }
        }
        if (!this.f52574c && !this.f52575d) {
            arrayList.add(8);
        }
        a2.h(arrayList);
        d.a.i0.w.m n = a2.n(5);
        if (n != null) {
            n.j = 3;
            if (this.f52575d) {
                n.f(false);
            }
        }
        a2.f();
        if (this.f52574c || this.f52575d) {
            a2.A(new d.a.i0.w.a(35, 5, Boolean.FALSE));
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public void i(boolean z) {
        this.f52575d = z;
    }

    public void j(boolean z) {
        this.f52574c = z;
    }

    public void k(d.a.i0.w.b bVar) {
        this.f52573b = bVar;
    }

    public void l(PbEditorData.ThreadData threadData) {
        this.f52572a = threadData;
    }
}
