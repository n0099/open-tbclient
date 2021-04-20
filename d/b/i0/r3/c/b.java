package d.b.i0.r3.c;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
import d.b.c.e.l.d;
import d.b.c.e.p.k;
/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public VideoEasterEggData f61308a;

    @Override // d.b.i0.r3.c.a
    public void a(BdUniqueId bdUniqueId) {
        if (k.isEmpty(f())) {
            return;
        }
        d.h().m(f(), 10, null, bdUniqueId);
    }

    @Override // d.b.i0.r3.c.a
    public String b() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getPopText();
    }

    @Override // d.b.i0.r3.c.a
    public void c(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getStringExtra("from");
        if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
            this.f61308a = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
        }
    }

    @Override // d.b.i0.r3.c.a
    public String d() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareUrl();
    }

    @Override // d.b.i0.r3.c.a
    public String e() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getActivityID();
    }

    @Override // d.b.i0.r3.c.a
    public String f() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getPopImageUrl();
    }

    @Override // d.b.i0.r3.c.a
    public String g() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareImageUrl();
    }

    @Override // d.b.i0.r3.c.a
    public String getVideoUrl() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getVideoUrl();
    }

    @Override // d.b.i0.r3.c.a
    public String h() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareContent();
    }

    @Override // d.b.i0.r3.c.a
    public String i() {
        VideoEasterEggData videoEasterEggData = this.f61308a;
        if (videoEasterEggData == null) {
            return null;
        }
        return videoEasterEggData.getShareTitle();
    }
}
