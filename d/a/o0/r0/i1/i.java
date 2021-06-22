package d.a.o0.r0.i1;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.aggregation.VideoAggregationModel;
import java.util.List;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public d f62545a;

    /* renamed from: b  reason: collision with root package name */
    public String f62546b;

    /* renamed from: c  reason: collision with root package name */
    public VideoAggregationModel f62547c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62548d;

    /* renamed from: e  reason: collision with root package name */
    public VideoAggregationModel.c f62549e;

    /* loaded from: classes4.dex */
    public class a implements VideoAggregationModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void a(String str) {
            if (i.this.f62545a == null) {
                return;
            }
            i.this.f62545a.o();
            i.this.f62545a.c(str);
            i.this.f62545a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.aggregation.VideoAggregationModel.c
        public void b(List<g> list, boolean z, boolean z2) {
            if (i.this.f62545a == null) {
                return;
            }
            i.this.f62545a.o();
            i.this.f62548d = z2;
            i.this.f62545a.d(list, z, z2);
        }
    }

    public i(TbPageContext tbPageContext, d dVar) {
        a aVar = new a();
        this.f62549e = aVar;
        this.f62545a = dVar;
        this.f62547c = new VideoAggregationModel(tbPageContext, aVar);
    }

    public void c() {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.cancelLoadData();
        }
    }

    public void d() {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel == null || !this.f62548d) {
            return;
        }
        videoAggregationModel.LoadData();
    }

    public void e() {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.A();
        }
    }

    public void f(String str) {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.setFrom(str);
        }
    }

    public void g(String str) {
        this.f62546b = str;
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.B(str);
        }
    }

    public void h(String str) {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.C(str);
        }
    }

    public void i(String str) {
        VideoAggregationModel videoAggregationModel = this.f62547c;
        if (videoAggregationModel != null) {
            videoAggregationModel.D(str);
        }
    }
}
