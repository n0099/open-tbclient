package d.a.m0.w.w;

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
import d.a.c.e.p.l;
import d.a.m0.w.m;
import d.a.n0.e3.u;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends d.a.m0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public ForumData f50907a;

    /* renamed from: b  reason: collision with root package name */
    public String f50908b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f50909c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50910d = false;

    /* renamed from: e  reason: collision with root package name */
    public DataModel<?> f50911e;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f50913f;

        public a(e eVar, EditorTools editorTools) {
            this.f50912e = eVar;
            this.f50913f = editorTools;
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            int size;
            e eVar = this.f50912e;
            if (eVar == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f50841a;
            if (i2 == 4) {
                this.f50912e.m0(aVar.f50843c.toString());
                Object obj = aVar.f50843c;
                if (obj instanceof SpanGroupManager) {
                    this.f50912e.q0((SpanGroupManager) obj);
                }
                g.this.f50910d = false;
            } else if (i2 == 5) {
                if (this.f50913f.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.f50913f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f50912e.r().showToast(R.string.over_limit_tip);
                g.this.f50910d = true;
            } else if (i2 == 8) {
                if (g.this.j(this.f50912e.r(), 11001)) {
                    this.f50912e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f50843c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f50912e.t0((VoiceData$VoiceModel) obj2);
                    this.f50912e.z(true, null);
                }
            } else if (i2 == 11) {
                this.f50912e.t0(null);
            } else if (i2 == 18) {
                if (aVar.f50843c != null) {
                    this.f50912e.Q();
                    return;
                }
                int t = this.f50912e.t();
                if (t == 0) {
                    this.f50912e.J();
                } else if (t != 2) {
                } else {
                    this.f50912e.A();
                }
            } else if (i2 == 20) {
                this.f50912e.a().A(new d.a.m0.w.a(2, 7, null));
                d.a.n0.e3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 27) {
                VideoInfo x = this.f50912e.x();
                if (x != null && x.isAvaliable()) {
                    this.f50912e.a().A(new d.a.m0.w.a(28, 20, x));
                } else if (this.f50912e.r() == null || this.f50912e.r().getResources() == null) {
                } else {
                    Resources resources = this.f50912e.r().getResources();
                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                            XiaoyingUtil.showGoPluginDetailDialog(this.f50912e.r(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                            return;
                        } else {
                            XiaoyingUtil.startXiaoying(this.f50912e.r().getPageActivity());
                            return;
                        }
                    }
                    XiaoyingUtil.showGoPluginDetailDialog(this.f50912e.r(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                }
            } else if (i2 == 29) {
                this.f50912e.a().A(new d.a.m0.w.a(2, 19, null));
                this.f50912e.a().A(new d.a.m0.w.a(1, 2, null));
                this.f50912e.m();
            } else if (i2 == 32) {
                this.f50912e.a().A(new d.a.m0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (g.this.j(this.f50912e.r(), 11040)) {
                    this.f50912e.Z();
                }
            } else if (i2 != 43) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f50912e.r().getPageActivity(), this.f50912e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(g.this.f50909c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", g.this.f50909c);
                        }
                        if (g.this.f50907a != null && !StringUtils.isNull(g.this.f50907a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.f50907a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(12002);
                        if (d.a.m0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f50912e.y() != null) {
                                this.f50912e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f50912e.y() != null) {
                            this.f50912e.y().setMaxImagesAllowed(9);
                        }
                        l.x(this.f50912e.r().getPageActivity(), this.f50912e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f50843c).intValue();
                        if (this.f50912e.y() != null && this.f50912e.y().getChosedFiles() != null && (size = this.f50912e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f50912e.r().getPageActivity(), 12012, this.f50912e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (g.this.f50910d) {
                            this.f50912e.r().showToast(R.string.over_limit_tip);
                        }
                        if (g.this.j(this.f50912e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f50912e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (d.a.m0.p0.b.c(this.f50912e.r(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f50912e.r().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (g.this.f50907a != null) {
                    hotSelectActivityConfig.setForumExtra(d.a.c.e.m.b.f(g.this.f50907a.getId(), 0L), g.this.f50907a.getFirst_class(), g.this.f50907a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    @Override // d.a.m0.w.c
    public d.a.m0.w.e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.j0(this.f50911e);
        return eVar;
    }

    @Override // d.a.m0.w.c
    public void c(d.a.m0.w.e eVar) {
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

    @Override // d.a.m0.w.c
    public void d(d.a.m0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        a2.d(new d.a.m0.w.r.d(a2.getContext(), 1));
        if (d.a.n0.e3.p0.c.a() && u.a(this.f50908b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.j = 2;
            a2.d(mVar);
        }
        d.a.m0.w.o.a aVar = new d.a.m0.w.o.a(a2.getContext(), 4);
        aVar.f50853g = false;
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
            a2.d(new d.a.m0.w.q.a(a2.getContext(), 5));
        }
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.j = 3;
        }
        a2.f();
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public ForumData k() {
        return this.f50907a;
    }

    public String l() {
        return this.f50909c;
    }

    public DataModel<?> m() {
        return this.f50911e;
    }

    public void n(ForumData forumData) {
        this.f50907a = forumData;
    }

    public void o(String str) {
        this.f50908b = str;
    }

    public void p(String str) {
        this.f50909c = str;
    }

    public void q(DataModel<?> dataModel) {
        this.f50911e = dataModel;
    }
}
