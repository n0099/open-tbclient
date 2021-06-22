package d.a.o0.q0.b;

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
import d.a.c.k.e.n;
import d.a.o0.q0.b.d;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62067e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.o0.q0.b.c f62068f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.o0.q0.b.d f62069g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.o0.q0.b.a f62070h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<n> f62071i;
    public String j;
    public int k;
    public long l;
    public String m;
    public BaijiahaoData n;
    public OriginalThreadInfo.ShareInfo o;
    public String p;
    public String q;
    public View.OnClickListener r = new a();
    public Runnable s = new RunnableC1538b();
    public CustomMessageListener t = new c(2921021);
    public CustomMessageListener u = new d(2921020);
    public d.b v = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.o0.q0.c.b) {
                Intent intent = new Intent();
                b.this.f62067e.getPageActivity().setResult(-1, intent);
                d.a.o0.q0.c.b bVar = (d.a.o0.q0.c.b) view.getTag();
                if (b.this.k == 1) {
                    b.this.q(bVar.i(), bVar.k());
                } else if (b.this.k == 2) {
                    b.this.s(bVar);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", bVar.i()));
                } else if (b.this.k != 3) {
                    if (b.this.k == 4) {
                        b.this.r(String.valueOf(bVar.i()), bVar.k());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.i()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.k());
                    b.this.f62067e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: d.a.o0.q0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1538b implements Runnable {
        public RunnableC1538b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.K(b.this.f62067e.getPageActivity(), b.this.f62068f.f62083d);
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
            b.this.f62068f.f62083d.setText(str);
            b.this.f62068f.f62083d.setSelection(str.length());
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

        @Override // d.a.o0.q0.b.d.b
        public void a(boolean z, d.a.o0.q0.c.c cVar) {
            if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                if (StringUtils.isNull(b.this.j)) {
                    b.this.I();
                    return;
                } else {
                    b.this.J();
                    return;
                }
            }
            b.this.f62071i = cVar.a();
            b bVar = b.this;
            bVar.v(bVar.f62071i);
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
                l.x(b.this.f62067e.getPageActivity(), view);
            } else {
                b.this.n();
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f62067e = tbPageContext;
        this.f62068f = new d.a.o0.q0.b.c(tbPageContext);
        m();
        d.a.o0.q0.b.d dVar = new d.a.o0.q0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f62069g = dVar;
        dVar.e(this.v);
        this.f62071i = new ArrayList<>();
        d.a.o0.q0.b.a aVar = new d.a.o0.q0.b.a(tbPageContext, this.f62068f.f62086g);
        this.f62070h = aVar;
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
        this.f62069g.c();
        this.f62071i.clear();
        ArrayList<String> c2 = d.a.o0.q0.b.e.c();
        if (!ListUtils.isEmpty(c2)) {
            d.a.o0.q0.c.a aVar = new d.a.o0.q0.c.a();
            aVar.g(d.a.o0.q0.c.a.f62095h);
            this.f62071i.add(aVar);
            this.f62071i.add(new d.a.o0.q0.c.a(c2));
            v(this.f62071i);
            return;
        }
        this.f62071i.clear();
        v(this.f62071i);
    }

    public final void J() {
        this.f62071i.clear();
        d.a.o0.q0.c.a aVar = new d.a.o0.q0.c.a();
        aVar.g(d.a.o0.q0.c.a.f62096i);
        this.f62071i.add(aVar);
        v(this.f62071i);
    }

    public final void m() {
        this.f62068f.f62081b.setOnClickListener(this);
        this.f62068f.f62083d.setOnEditorActionListener(new f());
        this.f62068f.f62083d.addTextChangedListener(new g());
        this.f62068f.f62083d.setOnFocusChangeListener(new h());
        this.f62068f.f62083d.setOnClickListener(this);
        this.f62068f.f62084e.setOnClickListener(this);
        this.f62068f.f62085f.setOnClickListener(this);
    }

    public final void n() {
        if (this.f62068f.f62083d.getText() != null && !StringUtils.isNull(this.f62068f.f62083d.getText().toString())) {
            n nVar = (n) ListUtils.getItem(this.f62071i, 0);
            if (nVar != null && nVar.getType() == d.a.o0.q0.c.a.f62095h) {
                this.f62071i.clear();
                v(this.f62071i);
            }
            this.f62068f.f62084e.setVisibility(0);
            String obj = this.f62068f.f62083d.getText().toString();
            this.j = obj;
            this.f62069g.d(obj);
            return;
        }
        this.f62068f.f62084e.setVisibility(8);
        this.j = null;
        I();
    }

    public d.a.o0.q0.b.c o() {
        return this.f62068f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.o0.q0.b.c cVar = this.f62068f;
        EditText editText = cVar.f62083d;
        if (view == editText) {
            n();
        } else if (view == cVar.f62085f) {
            l.x(this.f62067e.getPageActivity(), this.f62068f.f62083d);
            this.f62067e.getPageActivity().finish();
        } else if (view == cVar.f62084e) {
            editText.setText("");
        } else if (view == cVar.f62081b) {
            v(this.f62071i);
        }
    }

    public final FrsTabInfoData p(d.a.o0.q0.c.b bVar) {
        if (bVar == null || ListUtils.isEmpty(bVar.o())) {
            return null;
        }
        ArrayList arrayList = new ArrayList(bVar.o().size());
        for (FrsTabInfo frsTabInfo : bVar.o()) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f62067e.getPageActivity(), arrayList, String.valueOf(this.l), this.m)));
        this.f62067e.getPageActivity().finish();
    }

    public final void r(String str, String str2) {
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f62067e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f62067e.getPageActivity().finish();
    }

    public final void s(d.a.o0.q0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f62067e.getPageActivity(), 9, String.valueOf(bVar.i()), bVar.k(), null, null, 13011, null, null, null, this.o);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.n);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.p);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.q);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f62067e.getPageActivity().finish();
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
        this.f62071i = arrayList;
        this.f62068f.f62086g.setData(arrayList);
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
