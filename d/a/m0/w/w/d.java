package d.a.m0.w.w;

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
import d.a.c.e.p.l;
import d.a.m0.w.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends g {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f54570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f54571f;

        public a(e eVar, EditorTools editorTools) {
            this.f54570e = eVar;
            this.f54571f = editorTools;
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            int size;
            e eVar = this.f54570e;
            if (eVar == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f54518a;
            if (i2 == 4) {
                this.f54570e.m0(aVar.f54520c.toString());
            } else if (i2 == 5) {
                if (this.f54571f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f54571f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f54570e.r().showToast(R.string.over_limit_tip);
            } else if (i2 == 8) {
                if (d.this.j(this.f54570e.r(), 11001)) {
                    this.f54570e.L(null, null);
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f54520c).intValue();
                if (this.f54570e.y() != null && this.f54570e.y().getChosedFiles() != null && (size = this.f54570e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f54570e.r().getPageActivity(), 12012, this.f54570e.y(), intValue)));
                }
            } else {
                if (this.f54570e.y() != null) {
                    this.f54570e.y().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f54570e.r().getPageActivity(), this.f54570e.y().toJsonString(), true, true);
                if (!StringUtils.isNull(d.this.l(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", d.this.l());
                }
                if (d.this.k() != null && !StringUtils.isNull(d.this.k().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", d.this.k().getId());
                }
                albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                l.x(this.f54570e.r().getPageActivity(), this.f54570e.r().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    @Override // d.a.m0.w.w.g, d.a.m0.w.c
    public d.a.m0.w.e b(Context context) {
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

    @Override // d.a.m0.w.w.g, d.a.m0.w.c
    public void c(d.a.m0.w.e eVar) {
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

    @Override // d.a.m0.w.w.g, d.a.m0.w.c
    public void d(d.a.m0.w.e eVar) {
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.d(new d.a.m0.w.r.d(a2.getContext(), 1));
        a2.d(new f(a2.getContext(), true, false));
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.j = 2;
            n.f(false);
        }
        a2.f();
        a2.A(new d.a.m0.w.a(35, 5, Boolean.FALSE));
    }
}
