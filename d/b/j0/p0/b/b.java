package d.b.j0.p0.b;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.j0.p0.b.d;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f59281e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.j0.p0.b.c f59282f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.j0.p0.b.d f59283g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.j0.p0.b.a f59284h;
    public ArrayList<n> i;
    public String j;
    public int k;
    public long l;
    public BaijiahaoData m;
    public OriginalThreadInfo.ShareInfo n;
    public String o;
    public String p;
    public View.OnClickListener q = new a();
    public Runnable r = new RunnableC1448b();
    public CustomMessageListener s = new c(2921021);
    public CustomMessageListener t = new d(2921020);
    public d.b u = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.b.j0.p0.c.b) {
                Intent intent = new Intent();
                b.this.f59281e.getPageActivity().setResult(-1, intent);
                d.b.j0.p0.c.b bVar = (d.b.j0.p0.c.b) view.getTag();
                if (b.this.k == 1) {
                    b.this.q(bVar.n(), bVar.o());
                } else if (b.this.k == 2) {
                    b.this.s(bVar);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", bVar.n()));
                } else if (b.this.k != 3) {
                    if (b.this.k == 4) {
                        b.this.r(String.valueOf(bVar.n()), bVar.o());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.n()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.o());
                    b.this.f59281e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: d.b.j0.p0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1448b implements Runnable {
        public RunnableC1448b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.J(b.this.f59281e.getPageActivity(), b.this.f59282f.f59296d);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            b.this.f59282f.f59296d.setText(str);
            b.this.f59282f.f59296d.setSelection(str.length());
            b.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
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

        @Override // d.b.j0.p0.b.d.b
        public void a(boolean z, d.b.j0.p0.c.c cVar) {
            if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                if (StringUtils.isNull(b.this.j)) {
                    b.this.I();
                    return;
                } else {
                    b.this.J();
                    return;
                }
            }
            b.this.i = cVar.a();
            b bVar = b.this;
            bVar.w(bVar.i);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
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
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(b.this.f59281e.getPageActivity(), view);
            } else {
                b.this.n();
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f59281e = tbPageContext;
        this.f59282f = new d.b.j0.p0.b.c(tbPageContext);
        m();
        d.b.j0.p0.b.d dVar = new d.b.j0.p0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f59283g = dVar;
        dVar.e(this.u);
        this.i = new ArrayList<>();
        d.b.j0.p0.b.a aVar = new d.b.j0.p0.b.a(tbPageContext, this.f59282f.f59299g);
        this.f59284h = aVar;
        aVar.a(this.q);
        I();
        tbPageContext.registerListener(this.t);
        tbPageContext.registerListener(this.s);
        d.b.c.e.m.e.a().postDelayed(this.r, 500L);
    }

    public void A(String str) {
    }

    public void B(String str) {
    }

    public void E(OriginalThreadInfo.ShareInfo shareInfo) {
        this.n = shareInfo;
    }

    public void F(String str) {
        this.o = str;
    }

    public void G(String str) {
        this.p = str;
    }

    public final void I() {
        this.f59283g.c();
        this.i.clear();
        ArrayList<String> c2 = d.b.j0.p0.b.e.c();
        if (!ListUtils.isEmpty(c2)) {
            d.b.j0.p0.c.a aVar = new d.b.j0.p0.c.a();
            aVar.j(d.b.j0.p0.c.a.f59307h);
            this.i.add(aVar);
            this.i.add(new d.b.j0.p0.c.a(c2));
            w(this.i);
            return;
        }
        this.i.clear();
        w(this.i);
    }

    public final void J() {
        this.i.clear();
        d.b.j0.p0.c.a aVar = new d.b.j0.p0.c.a();
        aVar.j(d.b.j0.p0.c.a.i);
        this.i.add(aVar);
        w(this.i);
    }

    public final void m() {
        this.f59282f.f59294b.setOnClickListener(this);
        this.f59282f.f59296d.setOnEditorActionListener(new f());
        this.f59282f.f59296d.addTextChangedListener(new g());
        this.f59282f.f59296d.setOnFocusChangeListener(new h());
        this.f59282f.f59296d.setOnClickListener(this);
        this.f59282f.f59297e.setOnClickListener(this);
        this.f59282f.f59298f.setOnClickListener(this);
    }

    public final void n() {
        if (this.f59282f.f59296d.getText() != null && !StringUtils.isNull(this.f59282f.f59296d.getText().toString())) {
            n nVar = (n) ListUtils.getItem(this.i, 0);
            if (nVar != null && nVar.getType() == d.b.j0.p0.c.a.f59307h) {
                this.i.clear();
                w(this.i);
            }
            this.f59282f.f59297e.setVisibility(0);
            String obj = this.f59282f.f59296d.getText().toString();
            this.j = obj;
            this.f59283g.d(obj);
            return;
        }
        this.f59282f.f59297e.setVisibility(8);
        this.j = null;
        I();
    }

    public d.b.j0.p0.b.c o() {
        return this.f59282f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.j0.p0.b.c cVar = this.f59282f;
        EditText editText = cVar.f59296d;
        if (view == editText) {
            n();
        } else if (view == cVar.f59298f) {
            l.w(this.f59281e.getPageActivity(), this.f59282f.f59296d);
            this.f59281e.getPageActivity().finish();
        } else if (view == cVar.f59297e) {
            editText.setText("");
        } else if (view == cVar.f59294b) {
            w(this.i);
        }
    }

    public final FrsTabInfoData p(d.b.j0.p0.c.b bVar) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f59281e.getPageActivity(), arrayList, String.valueOf(this.l))));
        this.f59281e.getPageActivity().finish();
    }

    public final void r(String str, String str2) {
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f59281e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f59281e.getPageActivity().finish();
    }

    public final void s(d.b.j0.p0.c.b bVar) {
        if (bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f59281e.getPageActivity(), 9, String.valueOf(bVar.n()), bVar.o(), null, null, 13011, null, null, null, this.n);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.m);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.o);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.p);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f59281e.getPageActivity().finish();
    }

    public void u() {
        d.b.c.e.m.e.a().removeCallbacks(this.r);
        MessageManager.getInstance().unRegisterListener(this.t);
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    public void v(BaijiahaoData baijiahaoData) {
        this.m = baijiahaoData;
    }

    public void w(ArrayList<n> arrayList) {
        this.i = arrayList;
        this.f59282f.f59299g.setData(arrayList);
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(long j) {
        this.l = j;
    }

    public void z(String str) {
    }
}
