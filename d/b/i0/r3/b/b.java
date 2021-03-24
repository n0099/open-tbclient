package d.b.i0.r3.b;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.b.h0.w.e;
import d.b.h0.w.m;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends d.b.h0.w.c {

    /* loaded from: classes5.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r3.b.a f60011e;

        public a(d.b.i0.r3.b.a aVar) {
            this.f60011e = aVar;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            d.b.i0.r3.b.a aVar2 = this.f60011e;
            if (aVar2 == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i = aVar.f51523a;
            if (i == 4) {
                this.f60011e.v((String) aVar.f51525c);
            } else if (i == 7) {
                this.f60011e.m().showToast(R.string.over_limit_tip);
            } else if (i != 8) {
            } else {
                this.f60011e.z();
                if (b.this.f(this.f60011e.m(), 11001)) {
                    this.f60011e.p();
                }
            }
        }
    }

    @Override // d.b.h0.w.c
    public e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.CAM_X0207);
        return new d.b.i0.r3.b.a(editorTools);
    }

    @Override // d.b.h0.w.c
    public void c(e eVar) {
        if (eVar instanceof d.b.i0.r3.b.a) {
            EditorTools a2 = eVar.a();
            a aVar = new a((d.b.i0.r3.b.a) eVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // d.b.h0.w.c
    public void d(e eVar) {
        if (eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(false);
            n.f51532d = 0;
        }
        a2.d(new c(a2.getContext()));
        a2.f();
        a2.A(new d.b.h0.w.a(35, 5, Boolean.FALSE));
        a2.o();
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
