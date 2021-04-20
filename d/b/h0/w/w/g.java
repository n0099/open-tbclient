package d.b.h0.w.w;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.kwai.video.player.PlayerPostEvent;
import d.b.c.e.p.l;
import d.b.h0.w.m;
import d.b.i0.d3.u;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends d.b.h0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public ForumData f52005a;

    /* renamed from: b  reason: collision with root package name */
    public String f52006b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f52007c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52008d = false;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f52009e;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f52010e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f52011f;

        public a(e eVar, EditorTools editorTools) {
            this.f52010e = eVar;
            this.f52011f = editorTools;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            int size;
            e eVar = this.f52010e;
            if (eVar == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i = aVar.f51942a;
            if (i == 4) {
                this.f52010e.m0(aVar.f51944c.toString());
                Object obj = aVar.f51944c;
                if (obj instanceof SpanGroupManager) {
                    this.f52010e.q0((SpanGroupManager) obj);
                }
                g.this.f52008d = false;
            } else if (i == 5) {
                if (this.f52011f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f52011f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.f52010e.r().showToast(R.string.over_limit_tip);
                g.this.f52008d = true;
            } else if (i == 8) {
                if (g.this.j(this.f52010e.r(), 11001)) {
                    this.f52010e.L(null, null);
                }
            } else if (i == 10) {
                Object obj2 = aVar.f51944c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f52010e.t0((VoiceData$VoiceModel) obj2);
                    this.f52010e.z(true, null);
                }
            } else if (i == 11) {
                this.f52010e.t0(null);
            } else if (i == 18) {
                if (aVar.f51944c != null) {
                    this.f52010e.Q();
                    return;
                }
                int t = this.f52010e.t();
                if (t == 0) {
                    this.f52010e.J();
                } else if (t != 2) {
                } else {
                    this.f52010e.A();
                }
            } else if (i == 20) {
                this.f52010e.a().A(new d.b.h0.w.a(2, 7, null));
                d.b.i0.d3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 27) {
                VideoInfo x = this.f52010e.x();
                if (x != null && x.isAvaliable()) {
                    this.f52010e.a().A(new d.b.h0.w.a(28, 20, x));
                } else if (this.f52010e.r() == null || this.f52010e.r().getResources() == null) {
                } else {
                    Resources resources = this.f52010e.r().getResources();
                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                            XiaoyingUtil.showGoPluginDetailDialog(this.f52010e.r(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                            return;
                        } else {
                            XiaoyingUtil.startXiaoying(this.f52010e.r().getPageActivity());
                            return;
                        }
                    }
                    XiaoyingUtil.showGoPluginDetailDialog(this.f52010e.r(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                }
            } else if (i == 29) {
                this.f52010e.a().A(new d.b.h0.w.a(2, 19, null));
                this.f52010e.a().A(new d.b.h0.w.a(1, 2, null));
                this.f52010e.m();
            } else if (i == 32) {
                this.f52010e.a().A(new d.b.h0.w.a(1, 11, null));
            } else if (i == 36) {
                if (g.this.j(this.f52010e.r(), 11040)) {
                    this.f52010e.Z();
                }
            } else if (i != 43) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f52010e.r().getPageActivity(), this.f52010e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(g.this.f52007c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", g.this.f52007c);
                        }
                        if (g.this.f52005a != null && !StringUtils.isNull(g.this.f52005a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.f52005a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                        if (d.b.h0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f52010e.y() != null) {
                                this.f52010e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f52010e.y() != null) {
                            this.f52010e.y().setMaxImagesAllowed(9);
                        }
                        l.w(this.f52010e.r().getPageActivity(), this.f52010e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f51944c).intValue();
                        if (this.f52010e.y() != null && this.f52010e.y().getChosedFiles() != null && (size = this.f52010e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f52010e.r().getPageActivity(), 12012, this.f52010e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (g.this.f52008d) {
                            this.f52010e.r().showToast(R.string.over_limit_tip);
                        }
                        if (g.this.j(this.f52010e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f52010e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (d.b.h0.p0.b.c(this.f52010e.r(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f52010e.r().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (g.this.f52005a != null) {
                    hotSelectActivityConfig.setForumExtra(d.b.c.e.m.b.f(g.this.f52005a.getId(), 0L), g.this.f52005a.getFirst_class(), g.this.f52005a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    @Override // d.b.h0.w.c
    public d.b.h0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.j0(this.f52009e);
        return eVar;
    }

    @Override // d.b.h0.w.c
    public void c(d.b.h0.w.e eVar) {
        if (eVar instanceof e) {
            EditorTools a2 = eVar.a();
            a aVar = new a((e) eVar, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(27, aVar);
            a2.setActionListener(29, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // d.b.h0.w.c
    public void d(d.b.h0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        a2.d(new d.b.h0.w.r.d(a2.getContext(), 1));
        if (d.b.i0.d3.p0.c.a() && u.a(this.f52006b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.j = 2;
            a2.d(mVar);
        }
        d.b.h0.w.o.a aVar = new d.b.h0.w.o.a(a2.getContext(), 4);
        aVar.f51954g = false;
        a2.d(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), m.class);
        if (runTask2 != null && runTask2.getData() != null) {
            m mVar2 = (m) runTask2.getData();
            mVar2.j = 6;
            a2.d(mVar2);
        }
        a2.d(new f(a2.getContext(), false, true));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), m.class);
        if (runTask3 != null && runTask3.getData() != null) {
            m mVar3 = (m) runTask3.getData();
            mVar3.j = 7;
            a2.d(mVar3);
        }
        if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
            a2.d(new d.b.h0.w.q.a(a2.getContext(), 5));
        }
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.j = 3;
        }
        a2.f();
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public ForumData k() {
        return this.f52005a;
    }

    public String l() {
        return this.f52007c;
    }

    public DataModel<?> m() {
        return this.f52009e;
    }

    public void n(ForumData forumData) {
        this.f52005a = forumData;
    }

    public void o(String str) {
        this.f52006b = str;
    }

    public void p(String str) {
        this.f52007c = str;
    }

    public void q(DataModel<?> dataModel) {
        this.f52009e = dataModel;
    }
}
