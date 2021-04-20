package d.b.i0.g1.k;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.kwai.video.player.PlayerPostEvent;
import d.b.c.e.p.l;
import d.b.h0.w.e;
import d.b.h0.w.m;
import d.b.h0.w.w.f;
import d.b.i0.d3.u;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.b.h0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public String f56182a;

    /* renamed from: b  reason: collision with root package name */
    public String f56183b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56184c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56185d;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56186e;

        public a(b bVar) {
            this.f56186e = bVar;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            int size;
            b bVar = this.f56186e;
            if (bVar == null || bVar.a() == null || aVar == null) {
                return;
            }
            int i = aVar.f51942a;
            if (i == 4) {
                this.f56186e.m0(aVar.f51944c.toString());
                Object obj = aVar.f51944c;
                if (obj instanceof SpanGroupManager) {
                    this.f56186e.q0((SpanGroupManager) obj);
                }
                c.this.f56184c = false;
            } else if (i == 18) {
                if (aVar.f51944c != null) {
                    this.f56186e.Q();
                    return;
                }
                int t = this.f56186e.t();
                if (t == 0) {
                    this.f56186e.J();
                } else if (t != 2) {
                } else {
                    this.f56186e.A();
                }
            } else if (i == 20) {
                this.f56186e.a().A(new d.b.h0.w.a(2, 7, null));
                d.b.i0.d3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 32) {
                this.f56186e.a().A(new d.b.h0.w.a(1, 11, null));
            } else if (i == 36) {
                if (c.this.i(this.f56186e.r(), 11040)) {
                    this.f56186e.Z();
                }
            } else if (i == 7) {
                l.K(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                c.this.f56184c = true;
            } else if (i == 8) {
                if (c.this.i(this.f56186e.r(), 11001)) {
                    this.f56186e.L(null, null);
                }
            } else if (i == 10) {
                Object obj2 = aVar.f51944c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f56186e.t0((VoiceData$VoiceModel) obj2);
                    this.f56186e.z(true, null);
                }
            } else if (i != 11) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f56186e.r().getPageActivity(), this.f56186e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(c.this.f56183b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", c.this.f56183b);
                        }
                        albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                        if (d.b.h0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f56186e.y() != null) {
                                this.f56186e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f56186e.y() != null) {
                            this.f56186e.y().setMaxImagesAllowed(9);
                        }
                        l.w(this.f56186e.r().getPageActivity(), this.f56186e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f51944c).intValue();
                        if (this.f56186e.y() != null && this.f56186e.y().getChosedFiles() != null && (size = this.f56186e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f56186e.r().getPageActivity(), 12012, this.f56186e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (c.this.f56184c) {
                            l.K(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (c.this.i(this.f56186e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f56186e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f56186e.t0(null);
            }
        }
    }

    @Override // d.b.h0.w.c
    public e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(this.f56185d ? 2 : 3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        return new b(editorTools);
    }

    @Override // d.b.h0.w.c
    public void c(e eVar) {
        if (eVar instanceof b) {
            EditorTools a2 = eVar.a();
            a aVar = new a((b) eVar);
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
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
        }
    }

    @Override // d.b.h0.w.c
    public void d(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools a2 = eVar.a();
        if (d.b.i0.d3.p0.c.a() && u.a(this.f56182a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.j = 2;
            a2.d(mVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(!this.f56185d);
            n.j = this.f56185d ? 1 : 3;
        }
        d.b.h0.w.o.a aVar = new d.b.h0.w.o.a(a2.getContext(), 4);
        aVar.f51954g = false;
        a2.d(aVar);
        if (!this.f56185d) {
            a2.d(new d.b.h0.w.r.d(a2.getContext(), 1));
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
            a2.d(new d.b.h0.w.q.a(a2.getContext(), 5));
        } else {
            a2.d(new f(a2.getContext(), false, false));
        }
        a2.f();
    }

    public final boolean i(TbPageContext<?> tbPageContext, int i) {
        if (d.b.h0.f0.f.e()) {
            return true;
        }
        TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
        return false;
    }

    public void j(String str, String str2) {
        this.f56182a = str;
        this.f56183b = str2;
    }
}
