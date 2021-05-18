package d.a.k0.j3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.j0.r.s.a;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f56766e;

        public a(d.a.j0.r.s.a aVar) {
            this.f56766e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f56766e.dismiss();
        }
    }

    /* renamed from: d.a.k0.j3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1403b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f56767e;

        public C1403b(d.a.j0.r.s.a aVar) {
            this.f56767e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f56767e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f56768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56770g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f56771h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56772i;
        public final /* synthetic */ String j;

        public c(d.a.j0.r.s.a aVar, int i2, TbPageContext tbPageContext, int i3, String str, String str2) {
            this.f56768e = aVar;
            this.f56769f = i2;
            this.f56770g = tbPageContext;
            this.f56771h = i3;
            this.f56772i = str;
            this.j = str2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            int i2;
            this.f56768e.dismiss();
            int i3 = this.f56769f;
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
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f56770g.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i2);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            memberPayActivityConfig.setFromScence(this.f56771h);
            memberPayActivityConfig.setReferPageClickZone(this.f56772i, this.j);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f56773e;

        public d(d.a.j0.r.s.a aVar) {
            this.f56773e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f56773e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f56774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f56775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56776g;

        public e(d.a.j0.r.s.a aVar, String str, TbPageContext tbPageContext) {
            this.f56774e = aVar;
            this.f56775f = str;
            this.f56776g = tbPageContext;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f56774e.dismiss();
            if (this.f56775f == null) {
                return;
            }
            TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
            d.a.j0.l.a.k(this.f56776g.getPageActivity(), this.f56775f);
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
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
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
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
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
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.cancel, new C1403b(aVar));
        aVar.setPositiveButton(R.string.open_now, new c(aVar, i2, tbPageContext, i3, str2, str3));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
