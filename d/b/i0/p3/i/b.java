package d.b.i0.p3.i;

import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicModel;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f58927a;

    /* renamed from: b  reason: collision with root package name */
    public final d f58928b;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.p3.i.i.a<CloudMusicData> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.p3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            b.this.f58928b.displayLoading(false);
            if (cloudMusicData != null) {
                b.this.f58928b.displayNoDataView(false);
                if (cloudMusicData.tag_list.isEmpty()) {
                    b.this.f58928b.displayNoDataView(true);
                    return;
                } else {
                    b.this.f58928b.showCloudMusicWithTagData(cloudMusicData);
                    return;
                }
            }
            b.this.f58928b.displayNoDataView(true);
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        this.f58927a = cloudMusicModel;
        this.f58928b = dVar;
        dVar.setPresenter(this);
    }

    @Override // d.b.i0.p3.i.c
    public void a() {
        this.f58927a.cancelLoadData();
    }

    @Override // d.b.i0.p3.i.c
    public void b() {
        this.f58928b.displayLoading(true);
        this.f58927a.t(new a());
    }
}
