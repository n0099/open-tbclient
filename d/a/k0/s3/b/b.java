package d.a.k0.s3.b;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.a.j0.w.e;
import d.a.j0.w.m;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends d.a.j0.w.c {

    /* loaded from: classes5.dex */
    public class a implements d.a.j0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.s3.b.a f61108e;

        public a(d.a.k0.s3.b.a aVar) {
            this.f61108e = aVar;
        }

        @Override // d.a.j0.w.b
        public void onAction(d.a.j0.w.a aVar) {
            d.a.k0.s3.b.a aVar2 = this.f61108e;
            if (aVar2 == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f50768a;
            if (i2 == 4) {
                this.f61108e.v((String) aVar.f50770c);
            } else if (i2 == 7) {
                this.f61108e.m().showToast(R.string.over_limit_tip);
            } else if (i2 != 8) {
            } else {
                this.f61108e.z();
                if (b.this.f(this.f61108e.m(), 11001)) {
                    this.f61108e.p();
                }
            }
        }
    }

    @Override // d.a.j0.w.c
    public e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.CAM_X0207);
        return new d.a.k0.s3.b.a(editorTools);
    }

    @Override // d.a.j0.w.c
    public void c(e eVar) {
        if (eVar instanceof d.a.k0.s3.b.a) {
            EditorTools a2 = eVar.a();
            a aVar = new a((d.a.k0.s3.b.a) eVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // d.a.j0.w.c
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
            n.f50777d = 0;
        }
        a2.d(new c(a2.getContext()));
        a2.f();
        a2.A(new d.a.j0.w.a(35, 5, Boolean.FALSE));
        a2.o();
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }
}
