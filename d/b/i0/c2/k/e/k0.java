package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public String f52718a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52719b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f52720c;

    /* renamed from: d  reason: collision with root package name */
    public int f52721d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.c2.h.e f52722e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52723f;

    /* renamed from: g  reason: collision with root package name */
    public Parcelable f52724g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52725h;
    public boolean i;
    public boolean j;
    public PostData k;
    public PostData l;
    public int m;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k0.b().m();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k0.b().m();
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k0.b().l(1, customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k0.b().l(0, customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.h0.t.m)) {
                k0.b().v((d.b.h0.t.m) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.h0.e)) {
                return;
            }
            k0.b().u((d.b.i0.c3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.h0.e)) {
                return;
            }
            k0.b().w((d.b.i0.c3.h0.e) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public static k0 f52726a = new k0(null);
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

    public /* synthetic */ k0(a aVar) {
        this();
    }

    public static k0 b() {
        return h.f52726a;
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
        if (this.f52723f) {
            this.f52723f = false;
            Parcelable parcelable = this.f52724g;
            this.f52724g = null;
            return parcelable;
        }
        this.f52724g = null;
        return null;
    }

    public d.b.i0.c2.h.e f() {
        if (!this.f52719b) {
            this.f52723f = false;
            return null;
        }
        d.b.i0.c2.h.e eVar = this.f52722e;
        if (eVar != null && eVar.D() != null && this.f52722e.D().size() > 0) {
            this.f52723f = true;
            d.b.i0.c2.h.e eVar2 = this.f52722e;
            this.f52722e = null;
            return eVar2;
        }
        this.f52723f = false;
        this.f52722e = null;
        return null;
    }

    public PostData g() {
        return this.k;
    }

    public PostData h() {
        return this.l;
    }

    public boolean i() {
        return this.f52725h;
    }

    public int j() {
        return this.f52721d;
    }

    public Rect k() {
        return this.f52720c;
    }

    public void l(int i, CustomResponsedMessage<?> customResponsedMessage) {
        d.b.i0.c2.h.e eVar;
        if (customResponsedMessage == null || (eVar = this.f52722e) == null || eVar.l() == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == d.b.b.e.m.b.f(this.f52722e.l().getId(), 0L)) {
            this.f52722e.l().setLike(i);
        }
    }

    public void m() {
        this.f52719b = false;
        this.f52722e = null;
        this.f52723f = false;
        this.f52724g = null;
        this.f52720c = null;
        this.f52721d = 0;
    }

    public boolean n(d.b.i0.c2.h.e eVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.f52719b = false;
        if (this.f52718a == null) {
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
            this.f52722e = eVar;
            this.f52723f = false;
            this.f52724g = parcelable;
            this.f52725h = z;
            this.i = z2;
            this.j = z3;
            return true;
        }
    }

    public void o(int i) {
        this.m = i;
    }

    public void p(String str, boolean z) {
        this.f52719b = false;
        if (z) {
            str = null;
        }
        if (str != null && str.length() >= 1) {
            if (!str.equals(this.f52718a)) {
                m();
                this.f52718a = str;
                return;
            }
            this.f52719b = true;
            return;
        }
        m();
        this.f52718a = null;
    }

    public void q(PostData postData) {
        this.k = postData;
    }

    public void r(PostData postData) {
        this.l = postData;
    }

    public void s(int i) {
        this.f52721d = i;
    }

    public void t(Rect rect) {
        this.f52720c = rect;
    }

    public void u(d.b.i0.c3.h0.e eVar) {
        d.b.i0.c2.h.e eVar2 = this.f52722e;
        if (eVar2 == null || eVar2.L() == null || this.f52722e.L().L() == null || eVar == null) {
            return;
        }
        AgreeData agreeData = eVar.f53376b;
        AgreeData L = this.f52722e.L().L();
        if (agreeData == null || L == null) {
            return;
        }
        String str = agreeData.nid;
        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
            BaijiahaoData V = this.f52722e.L().V();
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

    public void v(d.b.h0.t.m mVar) {
        d.b.i0.c2.h.e eVar;
        if (mVar == null || (eVar = this.f52722e) == null || eVar.D() == null || this.f52722e.D().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.f52722e.D().size();
        for (int i = 0; i < size; i++) {
            if (this.f52722e.D().get(i) != null && this.f52722e.D().get(i).s() != null && currentAccount.equals(this.f52722e.D().get(i).s().getUserId()) && this.f52722e.D().get(i).s().getPendantData() != null) {
                this.f52722e.D().get(i).s().getPendantData().d(mVar.a());
                this.f52722e.D().get(i).s().getPendantData().e(mVar.b());
            }
        }
    }

    public void w(d.b.i0.c3.h0.e eVar) {
        d.b.i0.c2.h.e eVar2 = this.f52722e;
        if (eVar2 == null || eVar == null) {
            return;
        }
        ArrayList<PostData> D = eVar2.D();
        if (ListUtils.isEmpty(D)) {
            return;
        }
        AgreeData agreeData = eVar.f53376b;
        for (PostData postData : D) {
            if (postData != null && TextUtils.equals(postData.D(), agreeData.postId)) {
                AgreeData q = postData.q();
                q.agreeType = agreeData.agreeType;
                q.hasAgree = agreeData.hasAgree;
                q.diffAgreeNum = agreeData.diffAgreeNum;
                q.agreeNum = agreeData.agreeNum;
                q.disAgreeNum = agreeData.disAgreeNum;
                return;
            }
        }
    }

    public k0() {
        this.f52718a = null;
        this.f52719b = false;
        this.f52721d = 0;
        this.f52722e = null;
        this.f52723f = false;
        this.f52724g = null;
        this.f52725h = true;
        this.i = false;
        this.j = false;
    }
}
