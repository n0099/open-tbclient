package d.b.i0.e1.b.o;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.b.j.e.n;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f54470b;

    /* renamed from: d  reason: collision with root package name */
    public c f54472d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f54473e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54474f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54469a = false;

    /* renamed from: c  reason: collision with root package name */
    public long f54471c = 0;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f54475g = new a(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (b.this.f54472d != null) {
                    b.this.f54472d.onFailed(responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            boolean z = false;
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0) {
                z = true;
            }
            if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                b.this.i(agreeMeHTTPResponseMessage.datas, z);
                b.this.f54474f = agreeMeHTTPResponseMessage.hasMore;
            } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                b.this.i(agreeMeSocketResponseMessage.datas, z);
                b.this.f54474f = agreeMeSocketResponseMessage.hasMore;
            }
        }
    }

    /* renamed from: d.b.i0.e1.b.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1239b extends BdAsyncTask<Void, Void, ArrayList<d.b.i0.e1.b.p.a>> {
        public C1239b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<d.b.i0.e1.b.p.a> doInBackground(Void... voidArr) {
            byte[] bArr;
            ArrayList<d.b.i0.e1.b.p.a> arrayList = new ArrayList<>();
            l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
            if (e2 == null || (bArr = e2.get("agree_me_cache_key")) == null) {
                return arrayList;
            }
            try {
                AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
                if (agreeMeResIdl.data != null) {
                    b.this.f54474f = agreeMeResIdl.data.has_more.intValue() == 1;
                    for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                        if (agreeList != null) {
                            d.b.i0.e1.b.p.a aVar = new d.b.i0.e1.b.p.a();
                            aVar.G(agreeList);
                            arrayList.add(aVar);
                        }
                    }
                    return arrayList;
                }
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<d.b.i0.e1.b.p.a> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null) {
                b.this.h(arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void d(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    static {
        d.b.i0.c3.d0.a.h(309593, AgreeMeSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, c cVar) {
        if (tbPageContext != null) {
            this.f54470b = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.f54475g);
            this.f54472d = cVar;
        }
    }

    public void d() {
        e();
        f();
    }

    public final void e() {
        new C1239b().execute(new Void[0]);
    }

    public final void f() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.f54471c;
        agreeMeRequestMessage.setTag(this.f54470b);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    public void g() {
        f();
    }

    public final void h(ArrayList<d.b.i0.e1.b.p.a> arrayList) {
        if (this.f54469a) {
            return;
        }
        if (ListUtils.isEmpty(this.f54473e)) {
            this.f54473e = new ArrayList<>();
        } else {
            this.f54473e.clear();
        }
        this.f54473e.addAll(arrayList);
        ArrayList<n> arrayList2 = this.f54473e;
        n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (nVar instanceof d.b.i0.e1.b.p.a) {
            this.f54471c = ((d.b.i0.e1.b.p.a) nVar).n();
        }
        if (this.f54472d == null || ListUtils.isEmpty(this.f54473e)) {
            return;
        }
        this.f54472d.d(this.f54473e);
    }

    public final void i(ArrayList<d.b.i0.e1.b.p.a> arrayList, boolean z) {
        this.f54469a = true;
        if (ListUtils.isEmpty(this.f54473e)) {
            this.f54473e = new ArrayList<>();
        }
        if (!z) {
            this.f54473e.addAll(arrayList);
        } else {
            this.f54473e.clear();
            this.f54473e.addAll(0, arrayList);
        }
        ArrayList<n> arrayList2 = this.f54473e;
        n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (nVar instanceof d.b.i0.e1.b.p.a) {
            this.f54471c = ((d.b.i0.e1.b.p.a) nVar).n();
        }
        c cVar = this.f54472d;
        if (cVar != null) {
            cVar.d(this.f54473e);
        }
    }

    public void j() {
        this.f54471c = 0L;
        f();
    }
}
