package d.b.i0.d2.k.e;

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
    public String f54204a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54205b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f54206c;

    /* renamed from: d  reason: collision with root package name */
    public int f54207d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d2.h.e f54208e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54209f;

    /* renamed from: g  reason: collision with root package name */
    public Parcelable f54210g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54211h;
    public boolean i;
    public boolean j;
    public PostData k;
    public PostData l;
    public int m;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().m();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().m();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().l(1, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m0.b().l(0, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.h0.t.n)) {
                m0.b().v((d.b.h0.t.n) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.d3.h0.e)) {
                return;
            }
            m0.b().u((d.b.i0.d3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.d3.h0.e)) {
                return;
            }
            m0.b().w((d.b.i0.d3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public static m0 f54212a = new m0(null);
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
        return h.f54212a;
    }

    public boolean a() {
        return this.i;
    }

    public boolean c() {
        return this.j;
    }

    public int d() {
        return this.m;
    }

    public Parcelable e() {
        if (this.f54209f) {
            this.f54209f = false;
            Parcelable parcelable = this.f54210g;
            this.f54210g = null;
            return parcelable;
        }
        this.f54210g = null;
        return null;
    }

    public d.b.i0.d2.h.e f() {
        if (!this.f54205b) {
            this.f54209f = false;
            return null;
        }
        d.b.i0.d2.h.e eVar = this.f54208e;
        if (eVar != null && eVar.D() != null && this.f54208e.D().size() > 0) {
            this.f54209f = true;
            d.b.i0.d2.h.e eVar2 = this.f54208e;
            this.f54208e = null;
            return eVar2;
        }
        this.f54209f = false;
        this.f54208e = null;
        return null;
    }

    public PostData g() {
        return this.k;
    }

    public PostData h() {
        return this.l;
    }

    public boolean i() {
        return this.f54211h;
    }

    public int j() {
        return this.f54207d;
    }

    public Rect k() {
        return this.f54206c;
    }

    public void l(int i, CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.d2.h.e eVar;
        if (customResponsedMessage == null || (eVar = this.f54208e) == null || eVar.l() == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == d.b.c.e.m.b.f(this.f54208e.l().getId(), 0L)) {
            this.f54208e.l().setLike(i);
        }
    }

    public void m() {
        this.f54205b = false;
        this.f54208e = null;
        this.f54209f = false;
        this.f54210g = null;
        this.f54206c = null;
        this.f54207d = 0;
    }

    public boolean n(d.b.i0.d2.h.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.f54205b = false;
        if (this.f54204a == null) {
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
            this.f54208e = eVar;
            this.f54209f = false;
            this.f54210g = parcelable;
            this.f54211h = z;
            this.i = z2;
            this.j = z3;
            return true;
        }
    }

    public void o(int i) {
        this.m = i;
    }

    public void p(String str, boolean z) {
        this.f54205b = false;
        if (z) {
            str = null;
        }
        if (str != null && str.length() >= 1) {
            if (!str.equals(this.f54204a)) {
                m();
                this.f54204a = str;
                return;
            }
            this.f54205b = true;
            return;
        }
        m();
        this.f54204a = null;
    }

    public void q(PostData postData) {
        this.k = postData;
    }

    public void r(PostData postData) {
        this.l = postData;
    }

    public void s(int i) {
        this.f54207d = i;
    }

    public void t(Rect rect) {
        this.f54206c = rect;
    }

    public void u(d.b.i0.d3.h0.e eVar) {
        d.b.i0.d2.h.e eVar2 = this.f54208e;
        if (eVar2 == null || eVar2.L() == null || this.f54208e.L().L() == null || eVar == null) {
            return;
        }
        AgreeData agreeData = eVar.f54819b;
        AgreeData L = this.f54208e.L().L();
        if (agreeData == null || L == null) {
            return;
        }
        String str = agreeData.nid;
        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
            BaijiahaoData V = this.f54208e.L().V();
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

    public void v(d.b.h0.t.n nVar) {
        d.b.i0.d2.h.e eVar;
        if (nVar == null || (eVar = this.f54208e) == null || eVar.D() == null || this.f54208e.D().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.f54208e.D().size();
        for (int i = 0; i < size; i++) {
            if (this.f54208e.D().get(i) != null && this.f54208e.D().get(i).t() != null && currentAccount.equals(this.f54208e.D().get(i).t().getUserId()) && this.f54208e.D().get(i).t().getPendantData() != null) {
                this.f54208e.D().get(i).t().getPendantData().d(nVar.a());
                this.f54208e.D().get(i).t().getPendantData().e(nVar.b());
            }
        }
    }

    public void w(d.b.i0.d3.h0.e eVar) {
        d.b.i0.d2.h.e eVar2 = this.f54208e;
        if (eVar2 == null || eVar == null) {
            return;
        }
        ArrayList<PostData> D = eVar2.D();
        if (ListUtils.isEmpty(D)) {
            return;
        }
        AgreeData agreeData = eVar.f54819b;
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
        this.f54204a = null;
        this.f54205b = false;
        this.f54207d = 0;
        this.f54208e = null;
        this.f54209f = false;
        this.f54210g = null;
        this.f54211h = true;
        this.i = false;
        this.j = false;
    }
}
