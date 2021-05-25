package d.a.n0.q0.b;

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
import d.a.n0.q0.b.d;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f58251e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.n0.q0.b.c f58252f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.n0.q0.b.d f58253g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.n0.q0.b.a f58254h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<n> f58255i;
    public String j;
    public int k;
    public long l;
    public String m;
    public BaijiahaoData n;
    public OriginalThreadInfo.ShareInfo o;
    public String p;
    public String q;
    public View.OnClickListener r = new a();
    public Runnable s = new RunnableC1478b();
    public CustomMessageListener t = new c(2921021);
    public CustomMessageListener u = new d(2921020);
    public d.b v = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.a.n0.q0.c.b) {
                Intent intent = new Intent();
                b.this.f58251e.getPageActivity().setResult(-1, intent);
                d.a.n0.q0.c.b bVar = (d.a.n0.q0.c.b) view.getTag();
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
                    b.this.f58251e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: d.a.n0.q0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1478b implements Runnable {
        public RunnableC1478b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.K(b.this.f58251e.getPageActivity(), b.this.f58252f.f58267d);
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
            b.this.f58252f.f58267d.setText(str);
            b.this.f58252f.f58267d.setSelection(str.length());
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

        @Override // d.a.n0.q0.b.d.b
        public void a(boolean z, d.a.n0.q0.c.c cVar) {
            if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                if (StringUtils.isNull(b.this.j)) {
                    b.this.I();
                    return;
                } else {
                    b.this.J();
                    return;
                }
            }
            b.this.f58255i = cVar.a();
            b bVar = b.this;
            bVar.v(bVar.f58255i);
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
                l.x(b.this.f58251e.getPageActivity(), view);
            } else {
                b.this.n();
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f58251e = tbPageContext;
        this.f58252f = new d.a.n0.q0.b.c(tbPageContext);
        m();
        d.a.n0.q0.b.d dVar = new d.a.n0.q0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f58253g = dVar;
        dVar.e(this.v);
        this.f58255i = new ArrayList<>();
        d.a.n0.q0.b.a aVar = new d.a.n0.q0.b.a(tbPageContext, this.f58252f.f58270g);
        this.f58254h = aVar;
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
        this.f58253g.c();
        this.f58255i.clear();
        ArrayList<String> c2 = d.a.n0.q0.b.e.c();
        if (!ListUtils.isEmpty(c2)) {
            d.a.n0.q0.c.a aVar = new d.a.n0.q0.c.a();
            aVar.l(d.a.n0.q0.c.a.f58279h);
            this.f58255i.add(aVar);
            this.f58255i.add(new d.a.n0.q0.c.a(c2));
            v(this.f58255i);
            return;
        }
        this.f58255i.clear();
        v(this.f58255i);
    }

    public final void J() {
        this.f58255i.clear();
        d.a.n0.q0.c.a aVar = new d.a.n0.q0.c.a();
        aVar.l(d.a.n0.q0.c.a.f58280i);
        this.f58255i.add(aVar);
        v(this.f58255i);
    }

    public final void m() {
        this.f58252f.f58265b.setOnClickListener(this);
        this.f58252f.f58267d.setOnEditorActionListener(new f());
        this.f58252f.f58267d.addTextChangedListener(new g());
        this.f58252f.f58267d.setOnFocusChangeListener(new h());
        this.f58252f.f58267d.setOnClickListener(this);
        this.f58252f.f58268e.setOnClickListener(this);
        this.f58252f.f58269f.setOnClickListener(this);
    }

    public final void n() {
        if (this.f58252f.f58267d.getText() != null && !StringUtils.isNull(this.f58252f.f58267d.getText().toString())) {
            n nVar = (n) ListUtils.getItem(this.f58255i, 0);
            if (nVar != null && nVar.getType() == d.a.n0.q0.c.a.f58279h) {
                this.f58255i.clear();
                v(this.f58255i);
            }
            this.f58252f.f58268e.setVisibility(0);
            String obj = this.f58252f.f58267d.getText().toString();
            this.j = obj;
            this.f58253g.d(obj);
            return;
        }
        this.f58252f.f58268e.setVisibility(8);
        this.j = null;
        I();
    }

    public d.a.n0.q0.b.c o() {
        return this.f58252f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.q0.b.c cVar = this.f58252f;
        EditText editText = cVar.f58267d;
        if (view == editText) {
            n();
        } else if (view == cVar.f58269f) {
            l.x(this.f58251e.getPageActivity(), this.f58252f.f58267d);
            this.f58251e.getPageActivity().finish();
        } else if (view == cVar.f58268e) {
            editText.setText("");
        } else if (view == cVar.f58265b) {
            v(this.f58255i);
        }
    }

    public final FrsTabInfoData p(d.a.n0.q0.c.b bVar) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f58251e.getPageActivity(), arrayList, String.valueOf(this.l), this.m)));
        this.f58251e.getPageActivity().finish();
    }

    public final void r(String str, String str2) {
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f58251e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f58251e.getPageActivity().finish();
    }

    public final void s(d.a.n0.q0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f58251e.getPageActivity(), 9, String.valueOf(bVar.m()), bVar.p(), null, null, 13011, null, null, null, this.o);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.n);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.p);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.q);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f58251e.getPageActivity().finish();
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
        this.f58255i = arrayList;
        this.f58252f.f58270g.setData(arrayList);
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
