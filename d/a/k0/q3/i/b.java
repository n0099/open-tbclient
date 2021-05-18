package d.a.k0.q3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f59893a;

    /* renamed from: b  reason: collision with root package name */
    public final d f59894b;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.q3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f59894b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f59894b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f59894b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f59894b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f59894b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f59893a = cloudMusicModel;
        this.f59894b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.a.k0.q3.i.c
    public void a() {
        this.f59894b.displayLoading(true);
        this.f59893a.t(new a());
    }

    @Override // d.a.k0.q3.i.c
    public void cancelLoadData() {
        this.f59893a.cancelLoadData();
    }
}
