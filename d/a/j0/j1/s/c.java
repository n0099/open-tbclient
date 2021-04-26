package d.a.j0.j1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class c implements d.a.j0.j1.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f55903a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.j1.s.b f55904b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f55905c = new a();

    /* loaded from: classes4.dex */
    public class a implements LegoPageModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            if (c.this.f55904b != null) {
                c.this.f55904b.c(j, str, dataRes, z);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            if (c.this.f55904b != null) {
                c.this.f55904b.b(j, str, str2, i2);
            }
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            if (c.this.f55904b != null) {
                c.this.f55904b.a(true, dataRes, !z, j, str, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f55907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f55908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55909c;

        public b(c cVar, l lVar, long j, String str) {
            this.f55907a = lVar;
            this.f55908b = j;
            this.f55909c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            l lVar = this.f55907a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f55908b);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f55909c) ? "" : this.f55909c);
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

    /* renamed from: d.a.j0.j1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1325c implements n<DataRes> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f55910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55911b;

        public C1325c(long j, String str) {
            this.f55910a = j;
            this.f55911b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            c.this.f(this.f55910a, this.f55911b, dataRes);
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f55903a = legoPageModel;
        legoPageModel.v(this.f55905c);
    }

    @Override // d.a.j0.j1.s.a
    public void a(long j, String str) {
        h0.b(new b(this, d.a.i0.r.r.a.f().d("tb.lego_update"), j, str), new C1325c(j, str));
    }

    @Override // d.a.j0.j1.s.a
    public void b(d.a.j0.j1.s.b bVar) {
        this.f55904b = bVar;
    }

    @Override // d.a.j0.j1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel = this.f55903a;
        if (legoPageModel != null) {
            legoPageModel.t(i2, j, str, i3, str2);
        }
    }

    public final void f(long j, String str, DataRes dataRes) {
        if (j < 0) {
            return;
        }
        d.a.j0.j1.s.b bVar = this.f55904b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f55903a.t(2, j, str, 1, "");
    }
}
