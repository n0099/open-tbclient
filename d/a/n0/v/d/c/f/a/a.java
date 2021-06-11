package d.a.n0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.n0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.v.d.c.f.a.b f65234a;

    /* renamed from: b  reason: collision with root package name */
    public c f65235b;

    /* renamed from: c  reason: collision with root package name */
    public g f65236c;

    /* renamed from: d  reason: collision with root package name */
    public f f65237d;

    /* renamed from: e  reason: collision with root package name */
    public d f65238e;

    /* renamed from: f  reason: collision with root package name */
    public e f65239f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65240g = new LinkedList();

    /* renamed from: d.a.n0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1701a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65241a;

        public C1701a(a aVar, TbPageContext tbPageContext) {
            this.f65241a = tbPageContext;
        }

        @Override // d.a.n0.v.d.c.f.d.i
        public void a(d.a.n0.v.d.a.c cVar) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (cVar.c().s1() != null && cVar.c().s1().mYyExtData != null) {
                AlaInfoData s1 = cVar.c().s1();
                TbPageContext tbPageContext = this.f65241a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            d.a.n0.v.d.c.c.i(this.f65241a.getPageActivity(), cVar.c());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65242a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f65242a = tbPageContext;
        }

        @Override // d.a.n0.v.d.c.f.d.i
        public void a(d.a.n0.v.d.a.c cVar) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (cVar.c().s1() != null && cVar.c().s1().mYyExtData != null) {
                AlaInfoData s1 = cVar.c().s1();
                TbPageContext tbPageContext = this.f65242a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
                return;
            }
            d.a.n0.v.d.c.c.i(this.f65242a.getPageActivity(), cVar.c());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f65234a = new d.a.n0.v.d.c.f.a.b(tbPageContext);
        this.f65235b = new c(tbPageContext);
        this.f65236c = new g(tbPageContext);
        this.f65237d = new f(tbPageContext);
        this.f65238e = new d(tbPageContext);
        this.f65239f = new e(tbPageContext);
        this.f65235b.h0(new C1701a(this, tbPageContext));
        this.f65237d.h0(new b(this, tbPageContext));
        this.f65240g.add(this.f65234a);
        this.f65240g.add(this.f65235b);
        this.f65240g.add(this.f65236c);
        this.f65240g.add(this.f65237d);
        this.f65240g.add(this.f65238e);
        this.f65240g.add(this.f65239f);
    }

    public List<d.a.c.k.e.a> a() {
        return this.f65240g;
    }
}
