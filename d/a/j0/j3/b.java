package d.a.j0.j3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.i0.r.s.a;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f56059e;

        public a(d.a.i0.r.s.a aVar) {
            this.f56059e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f56059e.dismiss();
        }
    }

    /* renamed from: d.a.j0.j3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1331b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f56060e;

        public C1331b(d.a.i0.r.s.a aVar) {
            this.f56060e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f56060e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f56061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56063g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f56064h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56065i;
        public final /* synthetic */ String j;

        public c(d.a.i0.r.s.a aVar, int i2, TbPageContext tbPageContext, int i3, String str, String str2) {
            this.f56061e = aVar;
            this.f56062f = i2;
            this.f56063g = tbPageContext;
            this.f56064h = i3;
            this.f56065i = str;
            this.j = str2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            int i2;
            this.f56061e.dismiss();
            int i3 = this.f56062f;
            String str = null;
            if (i3 == 1) {
                i2 = 10;
                TiebaStatic.log("c10271");
                str = "4011001001";
            } else if (i3 == 2) {
                i2 = 13;
                TiebaStatic.log("c10282");
                str = "4012001001";
            } else if (i3 == 3) {
                i2 = 11;
                TiebaStatic.log("c10276");
                str = "4011001002";
            } else if (i3 == 4) {
                i2 = 14;
                TiebaStatic.log("c10285");
                str = "4012001002";
            } else if (i3 != 5) {
                i2 = i3 != 7 ? 0 : 22;
            } else {
                i2 = 18;
                TiebaStatic.log("c10767");
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f56063g.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i2);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            memberPayActivityConfig.setFromScence(this.f56064h);
            memberPayActivityConfig.setReferPageClickZone(this.f56065i, this.j);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f56066e;

        public d(d.a.i0.r.s.a aVar) {
            this.f56066e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f56066e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f56067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f56068f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56069g;

        public e(d.a.i0.r.s.a aVar, String str, TbPageContext tbPageContext) {
            this.f56067e = aVar;
            this.f56068f = str;
            this.f56069g = tbPageContext;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f56067e.dismiss();
            if (this.f56068f == null) {
                return;
            }
            TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
            d.a.i0.l.a.k(this.f56069g.getPageActivity(), this.f56068f);
        }
    }

    public static boolean a(DressItemData dressItemData) {
        int freeUserLevel = dressItemData.getFreeUserLevel();
        if (dressItemData.isDefault() || freeUserLevel == 0) {
            return true;
        }
        return freeUserLevel == 100 ? dressItemData.getActivityFinish() != 0 : freeUserLevel == 101 ? TbadkCoreApplication.getCurrentMemberType() == 3 : TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel;
    }

    public static void b(TbPageContext<?> tbPageContext, int i2, String str) {
        if (tbPageContext == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setMessageId(R.string.tip_download_activity_require);
        aVar.setNegativeButton(R.string.cancel, new d(aVar));
        aVar.setPositiveButton(R.string.tip_download_activity_in, new e(aVar, str, tbPageContext));
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void c(TbPageContext<?> tbPageContext, int i2, String str, int i3) {
        if (tbPageContext == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setTitle(str);
        a aVar2 = new a(aVar);
        aVar.setNegativeButton(R.string.cancel, aVar2);
        aVar.setPositiveButton(R.string.know, aVar2);
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void d(TbPageContext<?> tbPageContext, int i2, String str, int i3, String str2, String str3) {
        if (tbPageContext == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.cancel, new C1331b(aVar));
        aVar.setPositiveButton(R.string.open_now, new c(aVar, i2, tbPageContext, i3, str2, str3));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
