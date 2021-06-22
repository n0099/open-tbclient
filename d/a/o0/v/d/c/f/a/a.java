package d.a.o0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.o0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.v.d.c.f.a.b f65359a;

    /* renamed from: b  reason: collision with root package name */
    public c f65360b;

    /* renamed from: c  reason: collision with root package name */
    public g f65361c;

    /* renamed from: d  reason: collision with root package name */
    public f f65362d;

    /* renamed from: e  reason: collision with root package name */
    public d f65363e;

    /* renamed from: f  reason: collision with root package name */
    public e f65364f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65365g = new LinkedList();

    /* renamed from: d.a.o0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1705a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65366a;

        public C1705a(a aVar, TbPageContext tbPageContext) {
            this.f65366a = tbPageContext;
        }

        @Override // d.a.o0.v.d.c.f.d.i
        public void a(d.a.o0.v.d.a.c cVar) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (cVar.c().s1() != null && cVar.c().s1().mYyExtData != null) {
                AlaInfoData s1 = cVar.c().s1();
                TbPageContext tbPageContext = this.f65366a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            d.a.o0.v.d.c.c.i(this.f65366a.getPageActivity(), cVar.c());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f65367a;

        public b(a aVar, TbPageContext tbPageContext) {
            this.f65367a = tbPageContext;
        }

        @Override // d.a.o0.v.d.c.f.d.i
        public void a(d.a.o0.v.d.a.c cVar) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (cVar.c().s1() != null && cVar.c().s1().mYyExtData != null) {
                AlaInfoData s1 = cVar.c().s1();
                TbPageContext tbPageContext = this.f65367a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
                return;
            }
            d.a.o0.v.d.c.c.i(this.f65367a.getPageActivity(), cVar.c());
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f65359a = new d.a.o0.v.d.c.f.a.b(tbPageContext);
        this.f65360b = new c(tbPageContext);
        this.f65361c = new g(tbPageContext);
        this.f65362d = new f(tbPageContext);
        this.f65363e = new d(tbPageContext);
        this.f65364f = new e(tbPageContext);
        this.f65360b.h0(new C1705a(this, tbPageContext));
        this.f65362d.h0(new b(this, tbPageContext));
        this.f65365g.add(this.f65359a);
        this.f65365g.add(this.f65360b);
        this.f65365g.add(this.f65361c);
        this.f65365g.add(this.f65362d);
        this.f65365g.add(this.f65363e);
        this.f65365g.add(this.f65364f);
    }

    public List<d.a.c.k.e.a> a() {
        return this.f65365g;
    }
}
