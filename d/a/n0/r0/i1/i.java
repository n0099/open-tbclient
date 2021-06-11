package d.a.n0.r0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f62420a;

    /* renamed from: b  reason: collision with root package name */
    public String f62421b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f62422c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62423d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f62424e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f62420a == null) {
                return;
            }
            i.this.f62420a.o();
            i.this.f62420a.c(str);
            i.this.f62420a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f62420a == null) {
                return;
            }
            i.this.f62420a.o();
            i.this.f62423d = z2;
            i.this.f62420a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f62424e = aVar;
        this.f62420a = dVar;
        this.f62422c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel == null || !this.f62423d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.A();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f62421b = str;
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.B(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.C(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f62422c;
        if (videoAggregationModel != null) {
            videoAggregationModel.D(str);
        }
    }
}
