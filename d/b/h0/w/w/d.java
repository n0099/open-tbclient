package d.b.h0.w.w;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.kwai.video.player.PlayerPostEvent;
import d.b.b.e.p.l;
import d.b.h0.w.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends g {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f51574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f51575f;

        public a(e eVar, EditorTools editorTools) {
            this.f51574e = eVar;
            this.f51575f = editorTools;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            int size;
            e eVar = this.f51574e;
            if (eVar == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i = aVar.f51524a;
            if (i == 4) {
                this.f51574e.m0(aVar.f51526c.toString());
            } else if (i == 5) {
                if (this.f51575f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f51575f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.f51574e.r().showToast(R.string.over_limit_tip);
            } else if (i == 8) {
                if (d.this.j(this.f51574e.r(), 11001)) {
                    this.f51574e.L(null, null);
                }
            } else if (i != 14) {
                if (i != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f51526c).intValue();
                if (this.f51574e.y() != null && this.f51574e.y().getChosedFiles() != null && (size = this.f51574e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f51574e.r().getPageActivity(), 12012, this.f51574e.y(), intValue)));
                }
            } else {
                if (this.f51574e.y() != null) {
                    this.f51574e.y().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f51574e.r().getPageActivity(), this.f51574e.y().toJsonString(), true, true);
                if (!StringUtils.isNull(d.this.l(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", d.this.l());
                }
                if (d.this.k() != null && !StringUtils.isNull(d.this.k().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.k().getId());
                }
                albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                l.w(this.f51574e.r().getPageActivity(), this.f51574e.r().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    @Override // d.b.h0.w.w.g, d.b.h0.w.c
    public d.b.h0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.j0(m());
        eVar.z = true;
        return eVar;
    }

    @Override // d.b.h0.w.w.g, d.b.h0.w.c
    public void c(d.b.h0.w.e eVar) {
        if (eVar instanceof e) {
            EditorTools a2 = eVar.a();
            a aVar = new a((e) eVar, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // d.b.h0.w.w.g, d.b.h0.w.c
    public void d(d.b.h0.w.e eVar) {
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.d(new d.b.h0.w.r.d(a2.getContext(), 1));
        a2.d(new f(a2.getContext(), true, false));
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.j = 2;
            n.f(false);
        }
        a2.f();
        a2.A(new d.b.h0.w.a(35, 5, Boolean.FALSE));
    }
}
