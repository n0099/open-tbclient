package d.a.k0.p0.b;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.k0.p0.b.d;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f58055e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.k0.p0.b.c f58056f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.k0.p0.b.d f58057g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.k0.p0.b.a f58058h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<n> f58059i;
    public String j;
    public int k;
    public long l;
    public String m;
    public BaijiahaoData n;
    public OriginalThreadInfo.ShareInfo o;
    public String p;
    public String q;
    public View.OnClickListener r = new a();
    public Runnable s = new RunnableC1461b();
    public CustomMessageListener t = new c(2921021);
    public CustomMessageListener u = new d(2921020);
    public d.b v = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.k0.p0.c.b) {
                Intent intent = new Intent();
                b.this.f58055e.getPageActivity().setResult(-1, intent);
                d.a.k0.p0.c.b bVar = (d.a.k0.p0.c.b) view.getTag();
                if (b.this.k == 1) {
                    b.this.q(bVar.m(), bVar.p());
                } else if (b.this.k == 2) {
                    b.this.s(bVar);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", bVar.m()));
                } else if (b.this.k != 3) {
                    if (b.this.k == 4) {
                        b.this.r(String.valueOf(bVar.m()), bVar.p());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.m()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.p());
                    b.this.f58055e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: d.a.k0.p0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1461b implements Runnable {
        public RunnableC1461b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.K(b.this.f58055e.getPageActivity(), b.this.f58056f.f58071d);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            b.this.f58056f.f58071d.setText(str);
            b.this.f58056f.f58071d.setSelection(str.length());
            b.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            b.this.I();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b {
        public e() {
        }

        @Override // d.a.k0.p0.b.d.b
        public void a(boolean z, d.a.k0.p0.c.c cVar) {
            if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                if (StringUtils.isNull(b.this.j)) {
                    b.this.I();
                    return;
                } else {
                    b.this.J();
                    return;
                }
            }
            b.this.f58059i = cVar.a();
            b bVar = b.this;
            bVar.v(bVar.f58059i);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                b.this.n();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b.this.n();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(b.this.f58055e.getPageActivity(), view);
            } else {
                b.this.n();
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f58055e = tbPageContext;
        this.f58056f = new d.a.k0.p0.b.c(tbPageContext);
        m();
        d.a.k0.p0.b.d dVar = new d.a.k0.p0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f58057g = dVar;
        dVar.e(this.v);
        this.f58059i = new ArrayList<>();
        d.a.k0.p0.b.a aVar = new d.a.k0.p0.b.a(tbPageContext, this.f58056f.f58074g);
        this.f58058h = aVar;
        aVar.a(this.r);
        I();
        tbPageContext.registerListener(this.u);
        tbPageContext.registerListener(this.t);
        d.a.c.e.m.e.a().postDelayed(this.s, 500L);
    }

    public void A(String str) {
    }

    public void B(OriginalThreadInfo.ShareInfo shareInfo) {
        this.o = shareInfo;
    }

    public void F(String str) {
        this.p = str;
    }

    public void G(String str) {
        this.q = str;
    }

    public void H(String str) {
        this.m = str;
    }

    public final void I() {
        this.f58057g.c();
        this.f58059i.clear();
        ArrayList<String> c2 = d.a.k0.p0.b.e.c();
        if (!ListUtils.isEmpty(c2)) {
            d.a.k0.p0.c.a aVar = new d.a.k0.p0.c.a();
            aVar.l(d.a.k0.p0.c.a.f58083h);
            this.f58059i.add(aVar);
            this.f58059i.add(new d.a.k0.p0.c.a(c2));
            v(this.f58059i);
            return;
        }
        this.f58059i.clear();
        v(this.f58059i);
    }

    public final void J() {
        this.f58059i.clear();
        d.a.k0.p0.c.a aVar = new d.a.k0.p0.c.a();
        aVar.l(d.a.k0.p0.c.a.f58084i);
        this.f58059i.add(aVar);
        v(this.f58059i);
    }

    public final void m() {
        this.f58056f.f58069b.setOnClickListener(this);
        this.f58056f.f58071d.setOnEditorActionListener(new f());
        this.f58056f.f58071d.addTextChangedListener(new g());
        this.f58056f.f58071d.setOnFocusChangeListener(new h());
        this.f58056f.f58071d.setOnClickListener(this);
        this.f58056f.f58072e.setOnClickListener(this);
        this.f58056f.f58073f.setOnClickListener(this);
    }

    public final void n() {
        if (this.f58056f.f58071d.getText() != null && !StringUtils.isNull(this.f58056f.f58071d.getText().toString())) {
            n nVar = (n) ListUtils.getItem(this.f58059i, 0);
            if (nVar != null && nVar.getType() == d.a.k0.p0.c.a.f58083h) {
                this.f58059i.clear();
                v(this.f58059i);
            }
            this.f58056f.f58072e.setVisibility(0);
            String obj = this.f58056f.f58071d.getText().toString();
            this.j = obj;
            this.f58057g.d(obj);
            return;
        }
        this.f58056f.f58072e.setVisibility(8);
        this.j = null;
        I();
    }

    public d.a.k0.p0.b.c o() {
        return this.f58056f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.k0.p0.b.c cVar = this.f58056f;
        EditText editText = cVar.f58071d;
        if (view == editText) {
            n();
        } else if (view == cVar.f58073f) {
            l.x(this.f58055e.getPageActivity(), this.f58056f.f58071d);
            this.f58055e.getPageActivity().finish();
        } else if (view == cVar.f58072e) {
            editText.setText("");
        } else if (view == cVar.f58069b) {
            v(this.f58059i);
        }
    }

    public final FrsTabInfoData p(d.a.k0.p0.c.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.s())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.s().size());
        for (FrsTabInfo frsTabInfo : bVar.s()) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    public final void q(long j, String str) {
        TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
        transmitForumData.tabItemDatas = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(transmitForumData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f58055e.getPageActivity(), arrayList, String.valueOf(this.l), this.m)));
        this.f58055e.getPageActivity().finish();
    }

    public final void r(String str, String str2) {
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f58055e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f58055e.getPageActivity().finish();
    }

    public final void s(d.a.k0.p0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f58055e.getPageActivity(), 9, String.valueOf(bVar.m()), bVar.p(), null, null, 13011, null, null, null, this.o);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.n);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.p);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.q);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f58055e.getPageActivity().finish();
    }

    public void t() {
        d.a.c.e.m.e.a().removeCallbacks(this.s);
        MessageManager.getInstance().unRegisterListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.t);
    }

    public void u(BaijiahaoData baijiahaoData) {
        this.n = baijiahaoData;
    }

    public void v(ArrayList<n> arrayList) {
        this.f58059i = arrayList;
        this.f58056f.f58074g.setData(arrayList);
    }

    public void w(int i2) {
        this.k = i2;
    }

    public void x(long j) {
        this.l = j;
    }

    public void y(String str) {
    }

    public void z(String str) {
    }
}
