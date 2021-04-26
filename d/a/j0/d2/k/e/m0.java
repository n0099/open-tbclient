package d.a.j0.d2.k.e;

import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public String f52433a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52434b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f52435c;

    /* renamed from: d  reason: collision with root package name */
    public int f52436d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.d2.h.e f52437e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52438f;

    /* renamed from: g  reason: collision with root package name */
    public Parcelable f52439g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52440h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52441i;
    public boolean j;
    public PostData k;
    public PostData l;
    public int m;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().m();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().m();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().l(1, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().l(0, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.i0.t.n)) {
                m0.b().v((d.a.i0.t.n) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e)) {
                return;
            }
            m0.b().u((d.a.j0.d3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e)) {
                return;
            }
            m0.b().w((d.a.j0.d3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public static m0 f52442a = new m0(null);
    }

    static {
        MessageManager.getInstance().registerListener(new a(2005016));
        MessageManager.getInstance().registerListener(new b(2004006));
        MessageManager.getInstance().registerListener(new c(2001335));
        MessageManager.getInstance().registerListener(new d(2001336));
        MessageManager.getInstance().registerListener(new e(2016485));
        MessageManager.getInstance().registerListener(new f(2016528));
        MessageManager.getInstance().registerListener(new g(2016530));
    }

    public /* synthetic */ m0(a aVar) {
        this();
    }

    public static m0 b() {
        return h.f52442a;
    }

    public boolean a() {
        return this.f52441i;
    }

    public boolean c() {
        return this.j;
    }

    public int d() {
        return this.m;
    }

    public Parcelable e() {
        if (this.f52438f) {
            this.f52438f = false;
            Parcelable parcelable = this.f52439g;
            this.f52439g = null;
            return parcelable;
        }
        this.f52439g = null;
        return null;
    }

    public d.a.j0.d2.h.e f() {
        if (!this.f52434b) {
            this.f52438f = false;
            return null;
        }
        d.a.j0.d2.h.e eVar = this.f52437e;
        if (eVar != null && eVar.D() != null && this.f52437e.D().size() > 0) {
            this.f52438f = true;
            d.a.j0.d2.h.e eVar2 = this.f52437e;
            this.f52437e = null;
            return eVar2;
        }
        this.f52438f = false;
        this.f52437e = null;
        return null;
    }

    public PostData g() {
        return this.k;
    }

    public PostData h() {
        return this.l;
    }

    public boolean i() {
        return this.f52440h;
    }

    public int j() {
        return this.f52436d;
    }

    public Rect k() {
        return this.f52435c;
    }

    public void l(int i2, CustomResponsedMessage<?> customResponsedMessage) {
        d.a.j0.d2.h.e eVar;
        if (customResponsedMessage == null || (eVar = this.f52437e) == null || eVar.l() == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == d.a.c.e.m.b.f(this.f52437e.l().getId(), 0L)) {
            this.f52437e.l().setLike(i2);
        }
    }

    public void m() {
        this.f52434b = false;
        this.f52437e = null;
        this.f52438f = false;
        this.f52439g = null;
        this.f52435c = null;
        this.f52436d = 0;
    }

    public boolean n(d.a.j0.d2.h.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.f52434b = false;
        if (this.f52433a == null) {
            m();
            return false;
        } else if (eVar == null) {
            m();
            return false;
        } else if (eVar.D() == null) {
            m();
            return false;
        } else if (eVar.D().size() < 1) {
            m();
            return false;
        } else {
            this.f52437e = eVar;
            this.f52438f = false;
            this.f52439g = parcelable;
            this.f52440h = z;
            this.f52441i = z2;
            this.j = z3;
            return true;
        }
    }

    public void o(int i2) {
        this.m = i2;
    }

    public void p(String str, boolean z) {
        this.f52434b = false;
        if (z) {
            str = null;
        }
        if (str != null && str.length() >= 1) {
            if (!str.equals(this.f52433a)) {
                m();
                this.f52433a = str;
                return;
            }
            this.f52434b = true;
            return;
        }
        m();
        this.f52433a = null;
    }

    public void q(PostData postData) {
        this.k = postData;
    }

    public void r(PostData postData) {
        this.l = postData;
    }

    public void s(int i2) {
        this.f52436d = i2;
    }

    public void t(Rect rect) {
        this.f52435c = rect;
    }

    public void u(d.a.j0.d3.h0.e eVar) {
        d.a.j0.d2.h.e eVar2 = this.f52437e;
        if (eVar2 == null || eVar2.L() == null || this.f52437e.L().L() == null || eVar == null) {
            return;
        }
        AgreeData agreeData = eVar.f53077b;
        AgreeData L = this.f52437e.L().L();
        if (agreeData == null || L == null) {
            return;
        }
        String str = agreeData.nid;
        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
            BaijiahaoData V = this.f52437e.L().V();
            if (V == null || !TextUtils.equals(str, V.oriUgcNid)) {
                return;
            }
            L.agreeType = agreeData.agreeType;
            L.hasAgree = agreeData.hasAgree;
            L.diffAgreeNum = agreeData.diffAgreeNum;
            L.agreeNum = agreeData.agreeNum;
            L.disAgreeNum = agreeData.disAgreeNum;
            return;
        }
        String str2 = agreeData.threadId;
        if ("0".equals(str2) || TextUtils.isEmpty(str2) || !str2.equals(L.threadId)) {
            return;
        }
        L.agreeType = agreeData.agreeType;
        L.hasAgree = agreeData.hasAgree;
        L.diffAgreeNum = agreeData.diffAgreeNum;
        L.agreeNum = agreeData.agreeNum;
        L.disAgreeNum = agreeData.disAgreeNum;
    }

    public void v(d.a.i0.t.n nVar) {
        d.a.j0.d2.h.e eVar;
        if (nVar == null || (eVar = this.f52437e) == null || eVar.D() == null || this.f52437e.D().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.f52437e.D().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f52437e.D().get(i2) != null && this.f52437e.D().get(i2).t() != null && currentAccount.equals(this.f52437e.D().get(i2).t().getUserId()) && this.f52437e.D().get(i2).t().getPendantData() != null) {
                this.f52437e.D().get(i2).t().getPendantData().d(nVar.a());
                this.f52437e.D().get(i2).t().getPendantData().e(nVar.b());
            }
        }
    }

    public void w(d.a.j0.d3.h0.e eVar) {
        d.a.j0.d2.h.e eVar2 = this.f52437e;
        if (eVar2 == null || eVar == null) {
            return;
        }
        ArrayList<PostData> D = eVar2.D();
        if (ListUtils.isEmpty(D)) {
            return;
        }
        AgreeData agreeData = eVar.f53077b;
        for (PostData postData : D) {
            if (postData != null && TextUtils.equals(postData.E(), agreeData.postId)) {
                AgreeData r = postData.r();
                r.agreeType = agreeData.agreeType;
                r.hasAgree = agreeData.hasAgree;
                r.diffAgreeNum = agreeData.diffAgreeNum;
                r.agreeNum = agreeData.agreeNum;
                r.disAgreeNum = agreeData.disAgreeNum;
                return;
            }
        }
    }

    public m0() {
        this.f52433a = null;
        this.f52434b = false;
        this.f52436d = 0;
        this.f52437e = null;
        this.f52438f = false;
        this.f52439g = null;
        this.f52440h = true;
        this.f52441i = false;
        this.j = false;
    }
}
