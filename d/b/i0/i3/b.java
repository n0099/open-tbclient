package d.b.i0.i3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56209e;

        public a(d.b.h0.r.s.a aVar) {
            this.f56209e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f56209e.dismiss();
        }
    }

    /* renamed from: d.b.i0.i3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1313b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56210e;

        public C1313b(d.b.h0.r.s.a aVar) {
            this.f56210e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f56210e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56212f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56213g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f56214h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public c(d.b.h0.r.s.a aVar, int i, TbPageContext tbPageContext, int i2, String str, String str2) {
            this.f56211e = aVar;
            this.f56212f = i;
            this.f56213g = tbPageContext;
            this.f56214h = i2;
            this.i = str;
            this.j = str2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            int i;
            this.f56211e.dismiss();
            int i2 = this.f56212f;
            String str = null;
            if (i2 == 1) {
                i = 10;
                TiebaStatic.log("c10271");
                str = "4011001001";
            } else if (i2 == 2) {
                i = 13;
                TiebaStatic.log("c10282");
                str = "4012001001";
            } else if (i2 == 3) {
                i = 11;
                TiebaStatic.log("c10276");
                str = "4011001002";
            } else if (i2 == 4) {
                i = 14;
                TiebaStatic.log("c10285");
                str = "4012001002";
            } else if (i2 != 5) {
                i = i2 != 7 ? 0 : 22;
            } else {
                i = 18;
                TiebaStatic.log("c10767");
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f56213g.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            memberPayActivityConfig.setFromScence(this.f56214h);
            memberPayActivityConfig.setReferPageClickZone(this.i, this.j);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56215e;

        public d(d.b.h0.r.s.a aVar) {
            this.f56215e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f56215e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f56217f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56218g;

        public e(d.b.h0.r.s.a aVar, String str, TbPageContext tbPageContext) {
            this.f56216e = aVar;
            this.f56217f = str;
            this.f56218g = tbPageContext;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f56216e.dismiss();
            if (this.f56217f == null) {
                return;
            }
            TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
            d.b.h0.l.a.k(this.f56218g.getPageActivity(), this.f56217f);
        }
    }

    public static boolean a(DressItemData dressItemData) {
        int freeUserLevel = dressItemData.getFreeUserLevel();
        if (dressItemData.isDefault() || freeUserLevel == 0) {
            return true;
        }
        return freeUserLevel == 100 ? dressItemData.getActivityFinish() != 0 : freeUserLevel == 101 ? TbadkCoreApplication.getCurrentMemberType() == 3 : TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel;
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str) {
        if (tbPageContext == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        aVar.setMessageId(R.string.tip_download_activity_require);
        aVar.setNegativeButton(R.string.cancel, new d(aVar));
        aVar.setPositiveButton(R.string.tip_download_activity_in, new e(aVar, str, tbPageContext));
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        if (tbPageContext == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setTitle(str);
        a aVar2 = new a(aVar);
        aVar.setNegativeButton(R.string.cancel, aVar2);
        aVar.setPositiveButton(R.string.know, aVar2);
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i, String str, int i2, String str2, String str3) {
        if (tbPageContext == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.cancel, new C1313b(aVar));
        aVar.setPositiveButton(R.string.open_now, new c(aVar, i, tbPageContext, i2, str2, str3));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
