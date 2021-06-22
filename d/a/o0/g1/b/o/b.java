package d.a.o0.g1.b.o;

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
import d.a.c.e.d.l;
import d.a.c.k.e.n;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f58926b;

    /* renamed from: d  reason: collision with root package name */
    public c f58928d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f58929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58930f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58925a = false;

    /* renamed from: c  reason: collision with root package name */
    public long f58927c = 0;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f58931g = new a(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (b.this.f58928d != null) {
                    b.this.f58928d.onFailed(responsedMessage.getErrorString());
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
                b.this.f58930f = agreeMeHTTPResponseMessage.hasMore;
            } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                b.this.i(agreeMeSocketResponseMessage.datas, z);
                b.this.f58930f = agreeMeSocketResponseMessage.hasMore;
            }
        }
    }

    /* renamed from: d.a.o0.g1.b.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1411b extends BdAsyncTask<Void, Void, ArrayList<d.a.o0.g1.b.p.a>> {
        public C1411b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<d.a.o0.g1.b.p.a> doInBackground(Void... voidArr) {
            byte[] bArr;
            ArrayList<d.a.o0.g1.b.p.a> arrayList = new ArrayList<>();
            l<byte[]> e2 = d.a.n0.r.r.a.f().e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
            if (e2 == null || (bArr = e2.get("agree_me_cache_key")) == null) {
                return arrayList;
            }
            try {
                AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
                if (agreeMeResIdl.data != null) {
                    b.this.f58930f = agreeMeResIdl.data.has_more.intValue() == 1;
                    for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                        if (agreeList != null) {
                            d.a.o0.g1.b.p.a aVar = new d.a.o0.g1.b.p.a();
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
        public void onPostExecute(ArrayList<d.a.o0.g1.b.p.a> arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList != null) {
                b.this.h(arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    static {
        d.a.o0.e3.d0.a.h(309593, AgreeMeSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, c cVar) {
        if (tbPageContext != null) {
            this.f58926b = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.f58931g);
            this.f58928d = cVar;
        }
    }

    public void d() {
        e();
        f();
    }

    public final void e() {
        new C1411b().execute(new Void[0]);
    }

    public final void f() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.f58927c;
        agreeMeRequestMessage.setTag(this.f58926b);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    public void g() {
        f();
    }

    public final void h(ArrayList<d.a.o0.g1.b.p.a> arrayList) {
        if (this.f58925a) {
            return;
        }
        if (ListUtils.isEmpty(this.f58929e)) {
            this.f58929e = new ArrayList<>();
        } else {
            this.f58929e.clear();
        }
        this.f58929e.addAll(arrayList);
        ArrayList<n> arrayList2 = this.f58929e;
        n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (nVar instanceof d.a.o0.g1.b.p.a) {
            this.f58927c = ((d.a.o0.g1.b.p.a) nVar).i();
        }
        if (this.f58928d == null || ListUtils.isEmpty(this.f58929e)) {
            return;
        }
        this.f58928d.a(this.f58929e);
    }

    public final void i(ArrayList<d.a.o0.g1.b.p.a> arrayList, boolean z) {
        this.f58925a = true;
        if (ListUtils.isEmpty(this.f58929e)) {
            this.f58929e = new ArrayList<>();
        }
        if (!z) {
            this.f58929e.addAll(arrayList);
        } else {
            this.f58929e.clear();
            this.f58929e.addAll(0, arrayList);
        }
        ArrayList<n> arrayList2 = this.f58929e;
        n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (nVar instanceof d.a.o0.g1.b.p.a) {
            this.f58927c = ((d.a.o0.g1.b.p.a) nVar).i();
        }
        c cVar = this.f58928d;
        if (cVar != null) {
            cVar.a(this.f58929e);
        }
    }

    public void j() {
        this.f58927c = 0L;
        f();
    }
}
