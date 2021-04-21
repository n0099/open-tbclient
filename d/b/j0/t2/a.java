package d.b.j0.t2;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.webkit.sdk.SevenZipUtils;
import d.b.j0.t2.b;
/* loaded from: classes4.dex */
public class a {
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63004a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63005b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63006c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63007d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63008e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63009f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63010g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63011h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* renamed from: d.b.j0.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1655a extends CustomMessageListener {
        public C1655a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                a.this.E(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                if (responseUnreadPointNum.getNum() <= 0 || a.this.n >= responseUnreadPointNum.getNum()) {
                    a.this.n = responseUnreadPointNum.getNum();
                    a.this.o = false;
                } else {
                    a.this.o = true;
                    a aVar = a.this;
                    aVar.f63008e = aVar.o ? true : a.this.f63008e;
                    a.this.n = responseUnreadPointNum.getNum();
                    a.this.D();
                }
                a.this.H();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (booleanValue) {
                d.b.i0.r.d0.b.j().t("key_feedback_tip_show", true);
            }
            a.this.i = booleanValue;
            a.this.v = booleanValue;
            a.this.D();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (com.baidu.tbadk.core.TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= r2.l("maintab_member_center_red_tip_" + r1, 0)) goto L10;
         */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (booleanValue) {
                if (TbadkCoreApplication.isLogin()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
                }
                booleanValue = false;
            }
            a.this.t = booleanValue;
            a.this.f63010g = booleanValue;
            a.this.D();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            a.this.p = ((Boolean) customResponsedMessage.getData()).booleanValue();
            a aVar = a.this;
            aVar.f63009f = aVar.p ? true : a.this.f63009f;
            a.this.D();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                a.this.F();
                if (a.this.j) {
                    TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 1));
                    a.this.j = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            a.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.s.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (activityPrizeData.g()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                String a2 = activityPrizeData.a();
                d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
                String p = j.p("person_item_activity_prize_red_tip" + currentAccount, "");
                if (StringUtils.isNull(a2) || a2.equals(p)) {
                    return;
                }
                a.this.f63011h = true;
                a.this.u = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.w) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }

    /* loaded from: classes4.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public static final a f63021a = new a(null);
    }

    public /* synthetic */ a(C1655a c1655a) {
        this();
    }

    public static final a v() {
        return j.f63021a;
    }

    public boolean A() {
        return this.f63006c;
    }

    public boolean B() {
        return this.f63005b;
    }

    public boolean C() {
        return this.f63010g;
    }

    public final void D() {
        SparseArray sparseArray = new SparseArray();
        if (this.o) {
            sparseArray.append(4, new b.a(this.f63008e, this.n));
        }
        if (this.q) {
            sparseArray.append(2, new b.a(this.f63005b, this.k));
        }
        if (this.r) {
            sparseArray.append(1, new b.a(this.f63007d, this.l));
        }
        if (this.s) {
            sparseArray.append(3, new b.a(this.f63006c, this.m));
        }
        if (this.p) {
            sparseArray.append(5, new b.a(this.f63009f, 0));
        }
        if (this.t) {
            sparseArray.append(7, new b.a(this.f63010g, 0));
        }
        if (this.u) {
            sparseArray.append(9, new b.a(this.f63011h, 0));
        }
        if (this.v) {
            sparseArray.append(10, new b.a(this.i, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new d.b.j0.t2.b(sparseArray)));
        M();
    }

    public final void E(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.s = newsNotifyMessage.getMsgBookmark() > this.m;
            this.q = newsNotifyMessage.getMsgFans() > this.k;
            this.r = newsNotifyMessage.getMsgGiftNum() > this.l;
            this.m = newsNotifyMessage.getMsgBookmark();
            this.k = newsNotifyMessage.getMsgFans();
            this.l = newsNotifyMessage.getMsgGiftNum();
            if (this.s || this.q || this.r || this.p) {
                this.f63005b = this.q ? true : this.f63005b;
                this.f63006c = this.s ? true : this.f63006c;
                this.f63007d = this.r ? true : this.f63007d;
                this.f63009f = this.p ? true : this.f63009f;
                D();
            }
        }
    }

    public void F() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new d.b.i0.e0.a(false)));
    }

    public void G() {
        this.f63005b = false;
        this.f63006c = false;
        this.f63007d = false;
        this.f63008e = false;
        this.f63009f = false;
        this.f63010g = false;
        this.f63011h = false;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        x();
        d.b.c.e.m.e.a().post(new i());
        y();
    }

    public void H() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder();
        sb.append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        sb.append(TbadkCoreApplication.getCurrentAccount());
        inst.saveBoolean(sb.toString(), !this.o);
    }

    public void I(boolean z) {
        this.f63004a = z;
    }

    public final void J() {
        boolean z = this.f63007d || this.f63006c || this.f63005b || this.f63008e || this.f63009f || this.f63010g || this.f63011h || this.j;
        if (this.f63004a || !TbadkCoreApplication.isLogin()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new d.b.i0.e0.a(z, 0)));
    }

    public void K(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.f63008e, this.n));
            sparseArray.append(2, new b.a(this.f63005b, this.k));
            sparseArray.append(1, new b.a(this.f63007d, this.l));
            sparseArray.append(3, new b.a(this.f63006c, this.m));
            sparseArray.append(5, new b.a(this.f63009f, 0));
            sparseArray.append(7, new b.a(this.f63010g, 0));
            sparseArray.append(9, new b.a(this.f63011h, 0));
            sparseArray.append(10, new b.a(this.i, 0));
            sparseArray.append(11, new b.a(this.j, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new d.b.j0.t2.b(sparseArray)));
        }
    }

    public void L(int i2, boolean z, boolean z2) {
        if (z2) {
            switch (i2) {
                case 1:
                    this.f63007d = z;
                    break;
                case 2:
                    this.f63005b = z;
                    break;
                case 3:
                    this.f63006c = z;
                    break;
                case 4:
                    this.f63008e = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        d.b.i0.r.d0.b.j().t("member_close_ad_setting_clicked", true);
                    }
                    this.f63009f = z;
                    break;
                case 7:
                    String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                    d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
                    j2.w("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.f63010g = z;
                    break;
                case 9:
                    this.f63011h = z;
                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                    d.b.i0.r.d0.b j3 = d.b.i0.r.d0.b.j();
                    j3.x("person_item_activity_prize_red_tip" + currentAccount2, TbadkCoreApplication.getInst().getActivityPrizeData().a());
                    break;
                case 10:
                    this.i = z;
                    break;
                case 11:
                    this.j = z;
                    break;
            }
            K(true);
            J();
        }
    }

    public final void M() {
        if (((this.k > 0 && this.q) || (this.m > 0 && this.s) || this.p || this.u || this.v) && !this.f63004a && TbadkCoreApplication.isLogin()) {
            if (this.v) {
                d.b.i0.r.d0.b.j().t("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new d.b.i0.e0.a(true, 0)));
        }
    }

    public final void w() {
        MessageManager.getInstance().registerListener(this.x);
        MessageManager.getInstance().registerListener(this.y);
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.D);
        MessageManager.getInstance().registerListener(this.A);
        MessageManager.getInstance().registerListener(this.C);
        MessageManager.getInstance().registerListener(this.z);
        MessageManager.getInstance().registerListener(this.E);
    }

    public final void x() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!d.b.i0.r.d0.b.j().g("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.f63009f = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder();
        sb.append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        sb.append(TbadkCoreApplication.getCurrentAccount());
        this.w = inst.loadBoolean(sb.toString(), false);
    }

    public final void y() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new d.b.i0.e0.a(this.f63009f)));
        }
    }

    public boolean z() {
        return this.f63011h;
    }

    public a() {
        this.f63004a = false;
        this.f63005b = false;
        this.f63006c = false;
        this.f63007d = false;
        this.f63008e = false;
        this.f63009f = false;
        this.f63010g = false;
        this.f63011h = false;
        this.i = d.b.i0.r.d0.b.j().g("key_feedback_tip_show", false);
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = new C1655a(2001120);
        this.y = new b(2001176);
        this.z = new c(2016561);
        this.A = new d(2016459);
        this.B = new e(2001436);
        this.C = new f(2001384);
        this.D = new g(2005016);
        this.E = new h(2001371);
        w();
    }
}
