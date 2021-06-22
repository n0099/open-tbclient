package d.a.o0.s3.c;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public VideoEasterEggData f64571a;

    @Override // d.a.o0.s3.c.a
    public String a() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getPopText();
    }

    @Override // d.a.o0.s3.c.a
    public void b(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getStringExtra("from");
        if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
            this.f64571a = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
        }
    }

    @Override // d.a.o0.s3.c.a
    public String c() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getActivityID();
    }

    @Override // d.a.o0.s3.c.a
    public String d() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareTitle();
    }

    @Override // d.a.o0.s3.c.a
    public void e(BdUniqueId bdUniqueId) {
        if (k.isEmpty(g())) {
            return;
        }
        d.h().m(g(), 10, null, bdUniqueId);
    }

    @Override // d.a.o0.s3.c.a
    public String f() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareUrl();
    }

    @Override // d.a.o0.s3.c.a
    public String g() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getPopImageUrl();
    }

    @Override // d.a.o0.s3.c.a
    public String getVideoUrl() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getVideoUrl();
    }

    @Override // d.a.o0.s3.c.a
    public String h() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareImageUrl();
    }

    @Override // d.a.o0.s3.c.a
    public String i() {
        VideoEasterEggData videoEasterEggData = this.f64571a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareContent();
    }
}
