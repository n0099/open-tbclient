package d.a.k0.g1.k;

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
import d.a.c.e.p.l;
import d.a.j0.w.e;
import d.a.j0.w.m;
import d.a.j0.w.w.f;
import d.a.k0.d3.u;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.a.j0.w.c {

    /* renamed from: a  reason: collision with root package name */
    public String f55207a;

    /* renamed from: b  reason: collision with root package name */
    public String f55208b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55209c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55210d;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.w.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55211e;

        public a(b bVar) {
            this.f55211e = bVar;
        }

        @Override // d.a.j0.w.b
        public void onAction(d.a.j0.w.a aVar) {
            int size;
            b bVar = this.f55211e;
            if (bVar == null || bVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f50768a;
            if (i2 == 4) {
                this.f55211e.m0(aVar.f50770c.toString());
                Object obj = aVar.f50770c;
                if (obj instanceof SpanGroupManager) {
                    this.f55211e.q0((SpanGroupManager) obj);
                }
                c.this.f55209c = false;
            } else if (i2 == 18) {
                if (aVar.f50770c != null) {
                    this.f55211e.Q();
                    return;
                }
                int t = this.f55211e.t();
                if (t == 0) {
                    this.f55211e.J();
                } else if (t != 2) {
                } else {
                    this.f55211e.A();
                }
            } else if (i2 == 20) {
                this.f55211e.a().A(new d.a.j0.w.a(2, 7, null));
                d.a.k0.d3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f55211e.a().A(new d.a.j0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (c.this.i(this.f55211e.r(), 11040)) {
                    this.f55211e.Z();
                }
            } else if (i2 == 7) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                c.this.f55209c = true;
            } else if (i2 == 8) {
                if (c.this.i(this.f55211e.r(), 11001)) {
                    this.f55211e.L(null, null);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f50770c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f55211e.t0((VoiceData$VoiceModel) obj2);
                    this.f55211e.z(true, null);
                }
            } else if (i2 != 11) {
                switch (i2) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f55211e.r().getPageActivity(), this.f55211e.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(c.this.f55208b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", c.this.f55208b);
                        }
                        albumFloatActivityConfig.setRequestCode(12002);
                        if (d.a.j0.w.w.a.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.f55211e.y() != null) {
                                this.f55211e.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.f55211e.y() != null) {
                            this.f55211e.y().setMaxImagesAllowed(9);
                        }
                        l.x(this.f55211e.r().getPageActivity(), this.f55211e.r().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) aVar.f50770c).intValue();
                        if (this.f55211e.y() != null && this.f55211e.y().getChosedFiles() != null && (size = this.f55211e.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f55211e.r().getPageActivity(), 12012, this.f55211e.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (c.this.f55209c) {
                            l.L(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        }
                        if (c.this.i(this.f55211e.r(), 11025)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f55211e.r().getPageActivity(), 12004, true)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.f55211e.t0(null);
            }
        }
    }

    @Override // d.a.j0.w.c
    public e b(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(this.f55210d ? 2 : 3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
        editorTools.D(false);
        editorTools.setMoreButtonAtEnd(true);
        return new b(editorTools);
    }

    @Override // d.a.j0.w.c
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

    @Override // d.a.j0.w.c
    public void d(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools a2 = eVar.a();
        if (d.a.k0.d3.p0.c.a() && u.a(this.f55207a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.j = 2;
            a2.d(mVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(!this.f55210d);
            n.j = this.f55210d ? 1 : 3;
        }
        d.a.j0.w.o.a aVar = new d.a.j0.w.o.a(a2.getContext(), 4);
        aVar.f50780g = false;
        a2.d(aVar);
        if (!this.f55210d) {
            a2.d(new d.a.j0.w.r.d(a2.getContext(), 1));
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
            a2.d(new d.a.j0.w.q.a(a2.getContext(), 5));
        } else {
            a2.d(new f(a2.getContext(), false, false));
        }
        a2.f();
    }

    public final boolean i(TbPageContext<?> tbPageContext, int i2) {
        if (d.a.j0.f0.f.e()) {
            return true;
        }
        TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
        return false;
    }

    public void j(String str, String str2) {
        this.f55207a = str;
        this.f55208b = str2;
    }
}
