package d.b.j0.j1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import d.b.c.e.d.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class c implements d.b.j0.j1.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f57929a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.j1.s.b f57930b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f57931c = new a();

    /* loaded from: classes4.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f57930b != null) {
                c.this.f57930b.b(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i, String str2) {
            if (c.this.f57930b != null) {
                c.this.f57930b.a(j, str, str2, i);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i) {
            if (c.this.f57930b != null) {
                c.this.f57930b.c(true, dataRes, !z, j, str, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f57933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f57934b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f57935c;

        public b(c cVar, l lVar, long j, String str) {
            this.f57933a = lVar;
            this.f57934b = j;
            this.f57935c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f57933a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f57934b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f57935c) ? "" : this.f57935c);
            byte[] bArr = (byte[]) lVar.get(sb.toString());
            if (bArr != null && bArr.length != 0) {
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException unused) {
                }
            }
            return null;
        }
    }

    /* renamed from: d.b.j0.j1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1386c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f57936a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57937b;

        public C1386c(long j, String str) {
            this.f57936a = j;
            this.f57937b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f57936a, this.f57937b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f57929a = legoPageModel;
        legoPageModel.v(this.f57931c);
    }

    @Override // d.b.j0.j1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.b.i0.r.r.a.f().d("tb.lego_update"), j, str), new C1386c(j, str));
    }

    @Override // d.b.j0.j1.s.a
    public void b(d.b.j0.j1.s.b bVar) {
        this.f57930b = bVar;
    }

    @Override // d.b.j0.j1.s.a
    public void c(int i, long j, String str, int i2, String str2) {
        LegoPageModel legoPageModel = this.f57929a;
        if (legoPageModel != null) {
            legoPageModel.t(i, j, str, i2, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.b.j0.j1.s.b bVar = this.f57930b;
        if (bVar != null) {
            bVar.c(false, dataRes, false, j, str, 1);
        }
        this.f57929a.t(2, j, str, 1, "");
    }
}
