package d.b.i0.f1.k;

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
import d.b.b.e.p.l;
import d.b.h0.w.e;
import d.b.h0.w.m;
import d.b.h0.w.r.d;
import d.b.h0.w.w.f;
import d.b.i0.c3.u;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends d.b.h0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public String f54711a;

    /* renamed from: b  reason: collision with root package name */
    public String f54712b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54713c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54714d;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.f1.k.a f54715e;

        public a(d.b.i0.f1.k.a aVar) {
            this.f54715e = aVar;
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            int size;
            d.b.i0.f1.k.a aVar2 = this.f54715e;
            if (aVar2 == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i = aVar.f51523a;
            if (i == 4) {
                this.f54715e.m0(aVar.f51525c.toString());
                Object obj = aVar.f51525c;
                if (obj instanceof SpanGroupManager) {
                    this.f54715e.q0((SpanGroupManager) obj);
                }
                b.this.f54713c = false;
            } else if (i == 18) {
                if (aVar.f51525c != null) {
                    this.f54715e.Q();
                    return;
                }
                int t = this.f54715e.t();
                if (t == 0) {
                    this.f54715e.J();
                } else if (t != 2) {
                } else {
                    this.f54715e.A();
                }
            } else if (i == 20) {
                this.f54715e.a().A(new d.b.h0.w.a(2, 7, null));
                d.b.i0.c3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 32) {
                this.f54715e.a().A(new d.b.h0.w.a(1, 11, null));
            } else if (i == 36) {
                if (b.this.i(this.f54715e.r(), 11040)) {
                    this.f54715e.Z();
                }
            } else if (i == 7) {
                l.K(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                b.this.f54713c = true;
            } else if (i == 8) {
                if (b.this.i(this.f54715e.r(), 11001)) {
                    this.f54715e.L(null, null);
                }
            } else if (i == 10) {
                Object obj2 = aVar.f51525c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f54715e.t0((VoiceData$VoiceModel) obj2);
                    this.f54715e.z(true, null);
                }
            } else if (i != 11) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54715e.r().getPageActivity(), this.f54715e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(b.this.f54712b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", b.this.f54712b);
                        }
                        albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                        if (d.b.h0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f54715e.y() != null) {
                                this.f54715e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f54715e.y() != null) {
                            this.f54715e.y().setMaxImagesAllowed(9);
                        }
                        l.w(this.f54715e.r().getPageActivity(), this.f54715e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f51525c).intValue();
                        if (this.f54715e.y() != null && this.f54715e.y().getChosedFiles() != null && (size = this.f54715e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f54715e.r().getPageActivity(), 12012, this.f54715e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (b.this.f54713c) {
                            l.K(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (b.this.i(this.f54715e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f54715e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f54715e.t0(null);
            }
        }
    }

    @Override // d.b.h0.w.c
    public e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(this.f54714d ? 2 : 3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        return new d.b.i0.f1.k.a(editorTools);
    }

    @Override // d.b.h0.w.c
    public void c(e eVar) {
        if (eVar instanceof d.b.i0.f1.k.a) {
            EditorTools a2 = eVar.a();
            a aVar = new a((d.b.i0.f1.k.a) eVar);
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
        if (d.b.i0.c3.p0.c.a() && u.a(this.f54711a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.j = 2;
            a2.d(mVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(!this.f54714d);
            n.j = this.f54714d ? 1 : 3;
        }
        d.b.h0.w.o.a aVar = new d.b.h0.w.o.a(a2.getContext(), 4);
        aVar.f51535g = false;
        a2.d(aVar);
        if (!this.f54714d) {
            a2.d(new d(a2.getContext(), 1));
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
        this.f54711a = str;
        this.f54712b = str2;
    }
}
