package d.a.k0.a1.j.a.e;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.w.m;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends d.a.j0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51811a;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.a1.j.a.e.a f51812e;

        public a(d.a.k0.a1.j.a.e.a aVar) {
            this.f51812e = aVar;
        }

        @Override // d.a.j0.w.b
        public void onAction(d.a.j0.w.a aVar) {
            int size;
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f50768a;
            if (i2 == 4 || i2 == 6) {
                this.f51812e.H((String) aVar.f50770c);
                b.this.f51811a = false;
            } else if (i2 == 7) {
                this.f51812e.m().showToast(R.string.over_limit_tip);
                b.this.f51811a = true;
            } else if (i2 == 8) {
                if (b.this.g(this.f51812e.m(), 11001)) {
                    this.f51812e.y();
                    TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.f51812e.s())));
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f50770c).intValue();
                if (this.f51812e.r() != null && this.f51812e.r().getChosedFiles() != null && (size = this.f51812e.r().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f51812e.m().getPageActivity(), 12012, this.f51812e.r(), intValue)));
                }
            } else {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f51812e.m().getPageActivity(), this.f51812e.r().toJsonString(), true, true);
                albumActivityConfig.setRequestCode(12002);
                if (d.a.j0.w.w.a.a().b() == 1) {
                    albumActivityConfig.setRequestFrom(4);
                    if (this.f51812e.r() != null) {
                        this.f51812e.r().setMaxImagesAllowed(1);
                    }
                } else if (this.f51812e.r() != null) {
                    this.f51812e.r().setMaxImagesAllowed(10);
                }
                l.x(this.f51812e.m().getPageActivity(), this.f51812e.m().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    @Override // d.a.j0.w.c
    public d.a.j0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(false);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        return new d.a.k0.a1.j.a.e.a(editorTools);
    }

    @Override // d.a.j0.w.c
    public void c(d.a.j0.w.e eVar) {
        if (eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        a aVar = new a((d.a.k0.a1.j.a.e.a) eVar);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(6, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(45, aVar);
    }

    @Override // d.a.j0.w.c
    public void d(d.a.j0.w.e eVar) {
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(false);
            n.j = 1;
        }
        a2.d(new d.a.j0.w.r.d(a2.getContext(), 3));
        c cVar = new c(a2.getContext());
        if (cVar.g() != null) {
            cVar.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
        }
        a2.d(cVar);
        a2.f();
        a2.A(new d.a.j0.w.a(35, 5, Boolean.FALSE));
        a2.q();
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }
}
